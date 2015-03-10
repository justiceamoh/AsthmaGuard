package edu.dartmouth.asthmaguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by menglingli on 2/21/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String TAG = "DBHelper";
    private static Calendar cal = Calendar.getInstance();
    // All static variables
    // Database Version
    // class members should include event type,
    // time, duration, degree, location
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "entries.db";

    //Contacts table name
    private static final String ENTRY_TABLE = "entries";

    //Contacts Table Columns names
    public static final String KEY_ID = "_id";
    public static final String KEY_EVENT_TYPE = "mEventType";
    public static final String KEY_DATE_TIME = "mDateTime";
    public static final String KEY_DURATION = "mDuration";
    public static final String KEY_DEGREE = "mDegree";
    public static final String KEY_DATE = "mDate";
    public static final String KEY_LONGITUDE = "mLongitude";
    public static final String KEY_LATITUDE = "mLatitude";

    private String[] allColumns = {KEY_ID,KEY_EVENT_TYPE,KEY_DATE_TIME,KEY_DURATION,KEY_DEGREE,KEY_DATE};

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    //Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + ENTRY_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_EVENT_TYPE + " TEXT NOT NULL, "
                + KEY_DATE_TIME + " DATETIME NOT NULL, "
                + KEY_DURATION + " FLOAT, "
                + KEY_DEGREE + " FLOAT, "
                + KEY_DATE + " FLOAT "
                //+ KEY_LONGITUDE + "FLOAT, "
                //+ KEY_LATITUDE + "FLOAT"
                + ");";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + ENTRY_TABLE);
        onCreate(db);
    }


    public long addEntry(Entry entry){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EVENT_TYPE,entry.getEventType());
        values.put(KEY_DATE_TIME,entry.getDateTime());
        values.put(KEY_DURATION,entry.getDuration());
        values.put(KEY_DEGREE,entry.getDegree());
        values.put(KEY_DATE,entry.getDate());
        //values.put(KEY_LONGITUDE,entry.getLongitude());
        //values.put(KEY_LATITUDE,entry.getLatitude());

        long insertId = db.insert(ENTRY_TABLE, null, values);
        db.close();
        return insertId;
    }

    public List<Entry> getAllEntries() {
        List<Entry> pictures = new ArrayList<Entry>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(ENTRY_TABLE,
                allColumns, null, null, null, null, null);


        Log.d(TAG, "row number in the cursor: " + cursor.getCount());

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Entry entry = cursorToEntry(cursor);
            Log.d(TAG, "get entry = " + cursorToEntry(cursor).toString());
            if(entry.getDate()!=null&&entry.getEventType()!=null)
                pictures.add(entry);
            cursor.moveToNext();
        }

        // Make sure to close the cursor
        cursor.close();
        db.close();
        return pictures;
    }

    public Entry getEntryById(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(ENTRY_TABLE,
                allColumns, KEY_ID + " = " + id, null,
                null, null, null);
        cursor.moveToFirst();
        Entry entry = cursorToEntry(cursor);

        // Log the comment stored
        Log.d(TAG, "get exercise entry = " + cursorToEntry(cursor).toString()
                + " with ID = " + id);

        cursor.close();
        db.close();
        return entry;
    }

    public void deleteEntryById(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d(TAG, "delete picture = " + id);
        db.delete(ENTRY_TABLE, KEY_ID + " = " + id, null);
        db.close();
    }

    public void deleteAllEntries() {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d(TAG, "delete all = ");
        db.delete(ENTRY_TABLE, null, null);
        db.close();
    }

    private Entry cursorToEntry(Cursor cursor) {
        Entry entry = new Entry();

        entry.setId(cursor.getLong(0));
        entry.setEventType(cursor.getString(1));
        entry.setDateTime(cursor.getString(2));
        entry.setDuration(cursor.getDouble(3));
        entry.setDegree(cursor.getLong(4));
        entry.setDate(cursor.getString(5));
       // entry.setLongitude(cursor.getDouble(5));
       // entry.setLatitude(cursor.getDouble(6));

        return entry;
    }

    public Cursor createCursor(String[] cols, String args) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query(ENTRY_TABLE, cols, args, null,
                null, null, null);

    }

    public HashMap<String,List<Entry>> getRecent() {
        Log.d("data", "start");
        ArrayList<String> recent = new ArrayList<String>();
        HashMap<String, List<Entry>> res = new HashMap<String, List<Entry>>();
        List<Entry> all_entries = getAllEntries();
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        int mm = cal.get(Calendar.MONTH);

        for (int i = 0; i < 7; i++) {
            Calendar slot = Calendar.getInstance();
            slot.add(Calendar.DATE, -i);
            //System.out.println("Date = "+ slot.getTime());
            String s = android.text.format.DateFormat.format("MMM dd yyyy", slot.getTimeInMillis()).toString();
            System.out.println(s);
            recent.add(s);
        }

        for (String s : recent) {
            Log.d("recent", "" + s);
            res.put(s, null);
        }
        for (Entry e : all_entries) {
            String entry_datetime = e.getDate();
            if (res.containsKey(entry_datetime)) {
                List<Entry> tmp = res.get(entry_datetime);
                tmp.add(e);
                res.put(entry_datetime, tmp);
            }
        }
        Calendar slot_tmp1 = Calendar.getInstance();
        slot_tmp1.add(Calendar.DATE,-6);
        String s1 = android.text.format.DateFormat.format("MMM dd yyyy", slot_tmp1.getTimeInMillis()).toString();
        Calendar slot_tmp2 = Calendar.getInstance();
        slot_tmp2.add(Calendar.DATE,-6);
        String s2 = android.text.format.DateFormat.format("MMM dd yyyy", slot_tmp2.getTimeInMillis()).toString();
        List<Entry> tmp = new ArrayList<Entry>();
        Entry t = new Entry();
        t.setDateTime(s1);
        t.setDate(s2);
        tmp.add(t);
        res.put("flag",tmp);
        return res;
    }

    //
}
