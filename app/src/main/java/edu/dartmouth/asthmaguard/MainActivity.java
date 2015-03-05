package edu.dartmouth.asthmaguard;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_add    = (Button) findViewById(R.id.btn_add);
        Button btn_charts = (Button) findViewById(R.id.btn_charts);
        Button btn_events = (Button) findViewById(R.id.btn_recorder);

        btn_events.setBackgroundColor(Color.TRANSPARENT);
        btn_add.setBackgroundColor(Color.TRANSPARENT);
        btn_charts.setBackgroundColor(Color.TRANSPARENT);

        btn_events.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main_SlindingTab.class);
                startActivity(intent);
            }
        });

        btn_charts.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewPagerChartsActivity.class);
                startActivity(intent);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AudioRecorder.class);
                startActivity(intent);
            }
        });

        setHealthLevel(1);
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
