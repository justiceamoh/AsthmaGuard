package edu.dartmouth.asthmaguard;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    Double temperature=0.0, pollencount=0.0;
    int humidity=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_add    = (Button) findViewById(R.id.btn_add);
        Button btn_charts = (Button) findViewById(R.id.btn_charts);
        Button btn_events = (Button) findViewById(R.id.btn_recorder);

        Button btn_panic  = (Button) findViewById(R.id.btn_panic);
        btn_events.setBackgroundColor(Color.TRANSPARENT);
        btn_add.setBackgroundColor(Color.TRANSPARENT);
        btn_charts.setBackgroundColor(Color.TRANSPARENT);

        btn_events.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AudioRecorder.class);
                startActivity(intent);
            }
        });

        btn_panic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Menu Items
                final CharSequence[] items2 = {"Call Emergency Contact","Call Doctor","Call 911"};

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.create(); //Read Update
                alertDialog.setTitle("Panic?");
                alertDialog.setItems(items2,new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int which) {
                                   switch (which) {
                                       case 0:
                                           //Numbers can be changed
                                           //Check
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
            }

        });


        new AsyncTaskWeather().execute();
        setHealthLevel(1);
    }


    public class AsyncTaskWeather extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                temperature = WeatherParser.getTemperature();
                humidity    = WeatherParser.getHumidity();
                pollencount = WeatherParser.getPollen();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String response) {
            TextView temp_tv = (TextView)findViewById(R.id.temperature_tv);
            TextView hum_tv = (TextView)findViewById(R.id.humid_tv);
            TextView pollen_tv = (TextView)findViewById(R.id.pollen_tv);

            temp_tv.setText(String.valueOf(temperature));
            hum_tv.setText(String.valueOf(humidity));
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

    public void setHealthLevel(int level){
        RelativeLayout mlayout = (RelativeLayout) findViewById(R.id.mainlayout);

        switch(level){
            case 1:
                mlayout.setBackgroundResource(R.drawable.goodhealth);
                break;
            case 2:
                mlayout.setBackgroundResource(R.drawable.moderatehealth);
                break;
            case 3:
                mlayout.setBackgroundResource(R.drawable.baddhealth);
                break;
        }
    }


}
