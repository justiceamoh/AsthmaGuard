package edu.dartmouth.asthmaguard;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




/**
 * By: Justice Amoh, 2/21/15
 * For recording raw audio from microphone
 * Adapted from: http://stackoverflow.com/questions/8499042/android-audiorecord-example
 */

public class AudioRecorder extends ActionBarActivity {

    private Context mContext = this;
    private FileOutputStream audiofile = null;

    private Button btnStart, btnStop, btnPlay;

    // Audio recording parameters
    private int SampleRate = 16000;
    private int Channels = AudioFormat.CHANNEL_IN_MONO;
    private int Encoding = AudioFormat.ENCODING_PCM_16BIT;

    private AudioRecord rec = null;
    private Thread recordingThread = null;
    private boolean isRecording = false;

    // Recorder Buffer settings
    int BufferSize = AudioRecord.getMinBufferSize(SampleRate, Channels, Encoding)*10;
    int BufferElements2Rec = 1024;  // want each frame to be 64ms. 2 bytes per frame, hence 512 frames / Fs => 0.064
    int BytesPerElement = 2; // 2 bytes in 16bit format
    int FrameLength = BufferElements2Rec*BytesPerElement;
//    int AnalysisWidth = 200;   // for analysis width of 25ms => 0.025*8000 = 200


    // For Feature Extraction
    private int numCepstra = 14;
    private MFCC mfcc = new MFCC(BufferElements2Rec,SampleRate,numCepstra);
    private static final float rmsthresh = 250;
    private int winLength = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_recorder);

        btnStart = (Button) findViewById(R.id.btn_start);
        btnStop  = (Button) findViewById(R.id.btn_stop);
        btnPlay  = (Button) findViewById(R.id.btn_play);


        // Enable/Disable Buttons respectively
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        btnPlay.setEnabled(false);

        // Button Click Listener
        btnStart.setOnClickListener(onClickListener);
        btnStop.setOnClickListener(onClickListener);
        btnPlay.setOnClickListener(onClickListener);

        //Create audio recorder object
        rec = new AudioRecord(MediaRecorder.AudioSource.MIC,
                SampleRate,Channels,Encoding,BufferSize);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch(v.getId()){
                case R.id.btn_start:
                    start();
                    break;
                case R.id.btn_stop:
                    stop();
                    break;
                case R.id.btn_play:
                    try {
                        play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_audio_recorder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    public void start(){
        //Open a thread to start recording audio
        try{
            isRecording = true;
            rec.startRecording();
            recordingThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    writeAudioDataToFile();
                }
            },"AudioRecorder Thread");
            recordingThread.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
        btnPlay.setEnabled(false);

        Toast.makeText(getApplicationContext(), "Recording started!", Toast.LENGTH_SHORT).show();
    }

    public void writeAudioDataToFile() {
        // Write the incoming audio from mic to file in bytes
        short sData[] = new short[BufferElements2Rec];
        int i = 0;
        List<Float> window = new ArrayList<Float>();
        List<double[]> featVect = new ArrayList<double[]>();
        double[] mdat;
        double rmsval, zcval;
        int[] classifiedVal = new int[winLength];
        Double[] temp;

//        //Create or open Audio File to use
        try {
            audiofile = mContext.openFileOutput(
                    getResources().getString(R.string.audio_file), Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (isRecording) {
            // gets the voice output from microphone to byte format
            rec.read(sData, 0, BufferElements2Rec);
            //TODO: Buffer/Window based processing goes here on sData

            rmsval = Utils.rms(sData);
//            System.out.println("Rms value is:" + String.valueOf(rmsval));
            // Voice Activity Detection
            if (rmsval > rmsthresh) {
                i++;
                mdat = mfcc.doMFCC(Utils.short2float(sData));
                mdat[mdat.length-1] = Utils.rms(sData);
                featVect.add(mdat);
//                for (int j = 0; j < sData.length; j++) {
//                    window.add((float) sData[j]);
//                }


                if (i == winLength) {
                    System.out.println("Voice Activity Detected");
                    //TODO: Do feature extraction here

                    for (int j = 0; j < featVect.size(); j++) {
                        temp = Utils.double2Double(featVect.get(j));
                        try {
                            classifiedVal[j] = (int) WekaClassifier.classify(temp);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    if (winLength - Utils.summation(classifiedVal) > 3) {
                        System.out.println("Cough Event Occurred");
                    }
                    System.out.println("Cough Frames detected:" + String.valueOf(winLength - Utils.summation(classifiedVal)));

                    featVect.clear();
//                    window.clear();
                    i=0;
                }

            }

                //TODO: Uncomment for testing to actually write to file
//            System.out.println("Writing mic data to file" + sData.toString());
            byte bData[] = Utils.short2byte(sData);
            try {
                audiofile.write(bData, 0, FrameLength);
            } catch (IOException e) {
                e.printStackTrace();
            }
            }

            try {
                audiofile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }



    public void stop() {
        System.out.println("Stop Recording");
        if (rec != null) {
            isRecording = false;
            rec.stop();
            recordingThread = null;
        }

        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        btnPlay.setEnabled(true);

        Toast.makeText(getApplicationContext(), "Audio recording complete", Toast.LENGTH_SHORT).show();

    }


    public void play() throws IOException {
        btnPlay.setEnabled(false);
        FileInputStream inFile = null;

        int intSize = android.media.AudioTrack.getMinBufferSize(SampleRate, AudioFormat.CHANNEL_CONFIGURATION_MONO,
                AudioFormat.ENCODING_PCM_16BIT);

        AudioTrack atrack = new AudioTrack(AudioManager.STREAM_MUSIC, SampleRate, AudioFormat.CHANNEL_CONFIGURATION_MONO,
                AudioFormat.ENCODING_PCM_16BIT, intSize, AudioTrack.MODE_STREAM);


        // Open Audio File to use
        try {
              inFile = mContext.openFileInput(getResources().getString(R.string.audio_file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        byte[] readBuffer = new byte[FrameLength];
        int ret;

        atrack.play();
//        while (true) {
//            ret = inFile.read(readBuffer,0,FrameLength);
//            if (ret != -1) {
//                atrack.write(readBuffer,0,ret);
//            } else {
//                break;
//            }
//        }


        try {
            inFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        inFile.close();
        atrack.stop();
        atrack.release();

        btnPlay.setEnabled(true);

    }


}
