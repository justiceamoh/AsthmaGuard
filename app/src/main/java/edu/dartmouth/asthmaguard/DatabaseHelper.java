package edu.dartmouth.asthmaguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by menglingli on 2/21/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String TAG = "DBHelper";
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
    public static final String KEY_LONGITUDE = "mLongitude";
    public static final String KEY_LATITUDE = "mLatitude";

    private String[] allColumns = {KEY_ID,KEY_EVENT_TYPE,KEY_DATE_TIME,KEY_DURATION,KEY_DEGREE};

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    //Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + ENTRY_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_EVENT_TYPE + " text, "
                + KEY_DATE_TIME + " DATETIME NOT NULL, "
                + KEY_DURATION + " FLOAT, "
                + KEY_DEGREE + " FLOAT "
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
       // entry.setLongitude(cursor.getDouble(5));
       // entry.setLatitude(cursor.getDouble(6));

        return entry;
    }

    public Cursor createCursor(String[] cols, String args) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query(ENTRY_TABLE, cols, args, null,
                null, null, null);

    }

    //
}
