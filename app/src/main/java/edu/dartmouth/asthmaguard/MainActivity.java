package edu.dartmouth.asthmaguard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    int temperature = 0;
    double pollencount = 0.0;
    int humidity = 0;
    int healthlevel=0;
    private DatabaseHelper db;
    private static Calendar cal = Calendar.getInstance();
    int totalCough=0;
    boolean updatebg = false;

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

    // For Feature Extraction
    private int numCepstra = 14;
    private MFCC mfcc = new MFCC(BufferElements2Rec/12,SampleRate,numCepstra);
    private static final float rmsthresh = 250;
    private int winLength = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_add     = (Button) findViewById(R.id.btn_add);
        Button btn_charts  = (Button) findViewById(R.id.btn_charts);
        Button btn_events  = (Button) findViewById(R.id.btn_events);
        Button btn_setting = (Button) findViewById(R.id.btn_settings);
        Button btn_panic   = (Button) findViewById(R.id.btn_panic);
        Button btn_toggle  = (Button) findViewById(R.id.btn_togglebg);

        Switch detectSwitch = (Switch) findViewById(R.id.detectorSwitch);

        btn_events.setBackgroundColor(Color.TRANSPARENT);
        btn_add.setBackgroundColor(Color.TRANSPARENT);
        btn_charts.setBackgroundColor(Color.TRANSPARENT);
        btn_setting.setBackgroundColor(Color.TRANSPARENT);
        btn_panic.setBackgroundColor(Color.TRANSPARENT);
        btn_toggle.setBackgroundColor(Color.TRANSPARENT);

        btn_events.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main_SlindingTab.class);
                startActivity(intent);
            }
        });

        btn_charts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewPagerChartsActivity.class);
                startActivity(intent);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DisplayEntryActivity.class);
                startActivity(intent);
            }
        });

        btn_setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), settingActivity.class);
                startActivity(intent);
            }
        });

        btn_toggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int i = (++healthlevel % 3);
                setHealthLevel(i);
            }
        });

        btn_panic.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                //Menu Items
                final CharSequence[] items2 = {"Call Emergency Contact", "Call Doctor", "Call 911"};

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.create(); //Read Update
                alertDialog.setTitle("Panic?");
                alertDialog.setItems(items2, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                //Numbers can be changed

                                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:7325434595"));

                                startActivity(callIntent);

                                return;
                            case 1:
                                Intent callIntent2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:7325434595"));
                                startActivity(callIntent2);

                                return;
                            case 2:
                                Intent callIntent3 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:7325434595"));
                                startActivity(callIntent3);

                        }
                    }
                });

                alertDialog.show();
                return true;
            }

        });

        //Instantiate Db
        db = new DatabaseHelper(this);



        //Create audio recorder object
        rec = new AudioRecord(MediaRecorder.AudioSource.MIC,
                SampleRate,Channels,Encoding,BufferSize);



        final Handler bgupdate = new Handler();
        final int delay = 1000; //milliseconds

        bgupdate.postDelayed(new Runnable(){
            public void run(){
                if(updatebg){
                    if(totalCough>=1 & totalCough<3){
                        setHealthLevel(1);
                    } else if (totalCough>=3) {
                        setHealthLevel(2);
                    }
                    updatebg = false;
                }
                bgupdate.postDelayed(this, delay);
            }
        }, delay);

        detectSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //Start Cough Detector
                    startStreaming();
                } else {
                    //Stop Cough Detector
                    stopStreaming();
                }

            }
        });


        String mKey = getString(R.string.preference_name);
        SharedPreferences mPrefs = getSharedPreferences(mKey, MODE_PRIVATE);

        mKey = getString(R.string.preference_key_profile_name);
        String username = mPrefs.getString(mKey,"Wilson");


//        String username = "Justice";
        TextView greetings = (TextView) findViewById(R.id.greetings_tv);
        greetings.setText(Greetings.getGreeting() + " " + username + "!");
        new AsyncTaskWeather().execute();   // Get temperature, humidity & pollen count
        setHealthLevel(0);
    }


    public class AsyncTaskWeather extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                temperature = (int) WeatherParser.getTemperature();
                humidity = WeatherParser.getHumidity();
                pollencount = WeatherParser.getPollen();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String response) {
            TextView temp_tv = (TextView) findViewById(R.id.temperature_tv);
            TextView hum_tv = (TextView) findViewById(R.id.humid_tv);
            TextView pollen_tv = (TextView) findViewById(R.id.pollen_tv);

            temp_tv.setText(String.valueOf(temperature) + "°");
            hum_tv.setText(String.valueOf(humidity) + "%");
            pollen_tv.setText(String.valueOf(pollencount));
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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



    public void setHealthLevel(int level) {
        RelativeLayout mlayout = (RelativeLayout) findViewById(R.id.mainlayout);

        switch (level) {
            case 0:
                mlayout.setBackgroundResource(R.drawable.goodhealth);
                break;
            case 1:
                mlayout.setBackgroundResource(R.drawable.moderatehealth);
                break;
            case 2:
                mlayout.setBackgroundResource(R.drawable.badhealth);
                break;
        }
        healthlevel = level;
    }





    public void startStreaming(){
        //Open a thread to start recording audio
        try{
            isRecording = true;
            rec.startRecording();
            recordingThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    doAudioProcessing();
                }
            },"AudioRecorder Thread");
            recordingThread.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), "Streaming started!", Toast.LENGTH_SHORT).show();
    }


    public void doAudioProcessing() {
        // Write the incoming audio from mic to file in bytes
        short sData[] = new short[BufferElements2Rec];
        int i = 0;
        List<Float> window = new ArrayList<Float>();
        List<double[]> featVect = new ArrayList<double[]>();
        double[] mdat;
        double rmsval, zcval;
        int[] classifiedVal = new int[winLength];
        Double[] temp;

        while (isRecording) {
            // gets the voice output from microphone to byte format
            rec.read(sData, 0, BufferElements2Rec);
            rmsval = Utils.rms(sData);
            // Voice Activity Detection
            if (rmsval > rmsthresh) {
                i++;
                mdat = mfcc.doMFCC(Utils.short2float(sData));
                mdat[mdat.length-1] = Utils.rms(sData);
                featVect.add(mdat);


                if (i == winLength) {
                    System.out.println("Voice Activity Detected");

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
                        addCough(rmsval);
                    }
                    System.out.println("Cough Frames detected:" + String.valueOf(winLength - Utils.summation(classifiedVal)));

                    featVect.clear();
                    i=0;
                }


            }

        }

    }


    public void stopStreaming() {
        System.out.println("Stop Recording");
        if (rec != null) {
            isRecording = false;
            rec.stop();
            recordingThread = null;
        }

        Toast.makeText(getApplicationContext(), "Audio streaming stopped", Toast.LENGTH_SHORT).show();
    }

    private void addCough(double rmsval){
        Entry entry = new Entry();
        entry.setEventType("Coughing");
        int d = ((int)rmsval % 10)+1;
        entry.setDegree(d);
        double f = Math.random();
        entry.setDuration(f);
        String s= android.text.format.DateFormat.format("MMM dd yyyy",cal.getTimeInMillis()).toString();
        entry.setDate(s);
        s= android.text.format.DateFormat.format("kk:mm:ss MMM dd yyyy",cal.getTimeInMillis()).toString();
        entry.setDateTime(s);
        db.addEntry(entry);

        totalCough++;
        updatebg = true;


    }



    @Override
    protected void onResume(){
        super.onResume();


    }

}
