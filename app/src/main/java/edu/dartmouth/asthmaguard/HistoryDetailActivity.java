package edu.dartmouth.asthmaguard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class HistoryDetailActivity extends Activity {

    private Entry entry;
    private long _id;
    private DatabaseHelper db;

    private EditText activityType;
    private EditText dateTime;
    private EditText duration;
    private EditText degree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_list_item);
        Intent intent = getIntent();

        _id = intent.getLongExtra("_id",0);

        //datasource = EntryDataSource.getInstance(this);
        db  = new DatabaseHelper(this);

        entry = db.getEntryById(_id);

        activityType = (EditText) findViewById(R.id.activityTypelist);
        activityType.setText(entry.getEventType());

        dateTime = (EditText) findViewById(R.id.dateTimelist);
        dateTime.setText(entry.getDateTime());

        duration = (EditText) findViewById(R.id.durationlist);

        duration.setText(String.valueOf(entry.getDuration()));

        degree = (EditText) findViewById(R.id.degreelist);
        degree.setText(String.valueOf(entry.getDegree()));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.btn_delete) {
            db.deleteEntryById(entry.getId());
//            exerciseEntryDbHelper.removeEntry(entryID);
            finish();
        }
        return true;
    }

    public void onDeleteClicked(View v){
        Toast.makeText(this, "delete entry", Toast.LENGTH_SHORT).show();
        // Close the activity
        db.deleteEntryById(entry.getId());
//            exerciseEntryDbHelper.removeEntry(entryID);
        finish();
    }
}
