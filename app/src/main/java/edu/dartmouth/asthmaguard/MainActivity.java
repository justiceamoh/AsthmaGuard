package edu.dartmouth.asthmaguard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    int temperature = 0;
    double pollencount = 0.0;
    int humidity = 0;
    int healthlevel=0;


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


   @Override
    protected void onResume(){
       super.onResume();


   }

}
