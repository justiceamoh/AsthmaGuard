package edu.dartmouth.asthmaguard;

/**
 * Created by menglingli on 1/22/15.
 */

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class HistoryFragment extends ListFragment{

   private DatabaseHelper db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //datasource = EntryDataSource.getInstance(getActivity());
        db = new DatabaseHelper(getActivity());
        return inflater.inflate(R.layout.historyfragment, container, false);
    }

    public void refresh(){
        Cursor cursor = db.createCursor(new String[] {
                db.KEY_ID, db.KEY_EVENT_TYPE,
                db.KEY_DATE_TIME, db.KEY_DURATION,
                db.KEY_DEGREE }, null);

        ActivityEntryCursorAdapter mAdapter = new ActivityEntryCursorAdapter(
                getActivity(), cursor);
        setListAdapter(mAdapter);
    }

    @Override
    public void onResume(){
        super.onResume();
        refresh();
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Entry entry = db.getEntryById(id);
        Intent intent = new Intent();
        intent.putExtra("_id",id);
        intent.setClass(getActivity(),HistoryDetailActivity.class);
        startActivity(intent);
    }

    private class ActivityEntryCursorAdapter extends CursorAdapter{
        private LayoutInflater flater;

        public ActivityEntryCursorAdapter(Context context, Cursor c) {
            super(context, c, FLAG_REGISTER_CONTENT_OBSERVER);
            flater = LayoutInflater.from(context);
        }

        @Override
        public void bindView(View view, Context context,Cursor cursor){
            TextView textview1 = (TextView) view.findViewById(android.R.id.text1);
            TextView textview2 = (TextView) view.findViewById(android.R.id.text2);

            String content1 = cursor.getString(1);
            String content2 = cursor.getString(2);
            textview1.setText(content1+","+content2);


            content1 = String.valueOf(cursor.getDouble(3));
            content2 = String.valueOf(cursor.getLong(4));


            textview2.setText(content1+","+content2);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent){
            return flater.inflate(android.R.layout.two_line_list_item,null);
        }
    }
}
