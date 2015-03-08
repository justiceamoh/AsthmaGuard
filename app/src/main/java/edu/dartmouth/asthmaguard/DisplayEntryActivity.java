package edu.dartmouth.asthmaguard;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by menglingli on 2/21/15.
 */




public class DisplayEntryActivity extends ListActivity {

    public static final String DATE_TIME_FORMAT = "hh:mm:ss MMM dd yyyy";

    public static final int LIST_ITEM_ID_DATE = 0;
    public static final int LIST_ITEM_ID_TIME = 1;
    public static final int LIST_ITEM_ID_DURATION = 2;
    public static final int LIST_ITEM_ID_EVENTTYPE = 3;
    public static final int LIST_ITEM_ID_DEGREE = 4;
    private Calendar mDateAndTime = Calendar.getInstance();
    private Entry entry;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        db = new DatabaseHelper(this);

        entry = new Entry();
        entry.setDateTime(DateFormat.format("kk:mm:ss MMM dd yyyy",
                mDateAndTime.getTimeInMillis()).toString());
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);

        int dialogId = 0;

        switch(position) {
            case LIST_ITEM_ID_DATE:
                dialogId = MyDialogFragment.DATE;
                break;
            case LIST_ITEM_ID_TIME:
                dialogId = MyDialogFragment.TIME;
                break;
            case LIST_ITEM_ID_DURATION:
                dialogId = MyDialogFragment.DURATION;
                break;
            case LIST_ITEM_ID_EVENTTYPE:
                dialogId = MyDialogFragment.EVENTTYPE;
                break;
            case LIST_ITEM_ID_DEGREE:
                dialogId = MyDialogFragment.DEGREE;
                break;
            default:
                dialogId = MyDialogFragment.ERROR;
        }
        displayDialog(dialogId);
    }

    public void displayDialog(int id){
        MyDialogFragment mdf = MyDialogFragment.newInstance(id);
        mdf.show(getFragmentManager(),getString(R.string.dialog_fragment_tag_general));
    }

    public void onDateSet(int year, int monthOfYear, int dayOfMonth) {
        mDateAndTime.set(Calendar.YEAR, year);
        mDateAndTime.set(Calendar.MONTH, monthOfYear);
        mDateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        entry.setDateTime(DateFormat.format("kk:mm:ss MMM dd yyyy",
                mDateAndTime.getTimeInMillis()).toString());
        entry.setDate(DateFormat.format("MMM dd yyyy",
                mDateAndTime.getTimeInMillis()).toString());
    }

    public void onTimeSet(int hourOfDay, int minute) {
        mDateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        mDateAndTime.set(Calendar.MINUTE, minute);
        entry.setDateTime(DateFormat.format("kk:mm:ss MMM dd yyyy",
                mDateAndTime.getTimeInMillis()).toString());
    }


    public void onEventTypeSet(String eventType) {
        entry.setEventType(eventType);
    }

    public void onDurationSet(double durationInMinutes) {
        entry.setDuration(durationInMinutes);
    }

    public void onDegreeSet(long degree) {
        entry.setDegree(degree);
    }

    public void onSaveClicked(View v){
        Toast.makeText(this, "New entry saved", Toast.LENGTH_SHORT).show();
        // Close the activity
        db.addEntry(entry);
        finish();
    }

    public void onCancelClicked(View v){
        Toast.makeText(this, "Entry discarded.", Toast.LENGTH_SHORT).show();
        finish();
    }
}
