package edu.dartmouth.asthmaguard;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * By: Justice Amoh, 2/21/15
 * For recording raw audio from microphone
 * Adapted from: http://stackoverflow.com/questions/8499042/android-audiorecord-example
 */

public class AudioRecorder extends ActionBarActivity {

    private Context mContext = getApplicationContext();
    private FileOutputStream audiofile = null;

    // Audio recording parameters
    private int SampleRate = 8000;
    private int Channels = AudioFormat.CHANNEL_IN_MONO;
    private int Encoding = AudioFormat.ENCODING_PCM_16BIT;

    private AudioRecord rec = null;
    private Thread recordingThread = null;
    private boolean isRecording = false;

    // Recorder Buffer settings
    int BufferSize = AudioRecord.getMinBufferSize(SampleRate, Channels, Encoding);
    int BufferElements2Rec = 1024;  // want to play 2048 ~2K~ since 2 bytes we use only 1024
    int BytesPerElement = 2; // 2 bytes in 16bit format


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_recorder);



        //Create audio recorder object
        rec = new AudioRecord(MediaRecorder.AudioSource.MIC,
                SampleRate,Channels,Encoding,BufferSize);

        //Create or open Audio File to use
//        try {
//            audiofile = mContext.openFileOutput(
//                    getResources().getString(R.string.audio_file), Context.MODE_PRIVATE);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }


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

        Toast.makeText(mContext, "Recording started!", Toast.LENGTH_SHORT).show();
    }

    public void writeAudioDataToFile() {
        // Write the incoming audio from mic to file in bytes

        short sData[] = new short[BufferElements2Rec];


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


            System.out.println("Writing short to file" + sData.toString());
            byte bData[] = short2byte(sData);
            try {
                audiofile.write(bData, 0, BufferElements2Rec*BytesPerElement);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            audiofile.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void stop() {
        System.out.println("Stop Recording");
        if (rec != null) {
            isRecording = false;
            rec.stop();
            rec = null;
            recordingThread = null;
        }

        Toast.makeText(mContext, "Audio recording complete", Toast.LENGTH_SHORT).show();

    }



    private byte[] short2byte(short[] sData) {
        //convert short to byte
        int shortArraysize = sData.length;
        byte[] bytes = new byte[shortArraysize * 2];
        for (int i = 0; i < shortArraysize; i++) {
            bytes[i * 2] = (byte) (sData[i] & 0x00FF);
            bytes[(i * 2) + 1] = (byte) (sData[i] >> 8);
            sData[i] = 0;
        }
        return bytes;

    }




}
