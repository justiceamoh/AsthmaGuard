package edu.dartmouth.asthmaguard;

/**
 * Created by menglingli on 1/22/15.
 */

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.melnykov.fab.FloatingActionButton;


public class HistoryFragment extends ListFragment{

    private DatabaseHelper db;
    private Intent intent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //datasource = EntryDataSource.getInstance(getActivity());
        db = new DatabaseHelper(getActivity());
        View v = inflater.inflate(R.layout.historyfragment, container, false);

        //ListView lv = (ListView) v.fndViewById(R.id.list);
        ListView lv = (ListView)v.findViewById(android.R.id.list);

        if(lv==null)
            Log.d("here","here");
//        lv.setHasFixedSize(false);
//        lv.setLayoutManager(new LinearLayoutManager(getActivity()));


        intent = new Intent();
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.attachToListView(lv);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(getActivity(), DisplayEntryActivity.class);
                startActivity(intent);
            }
        });


        return v;
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
            textview1.setTextColor(Color.parseColor("#9370DB"));


            content1 = String.valueOf(cursor.getDouble(3));
            content1 = String.format("%.3s",content1);
            content2 = String.valueOf(cursor.getLong(4));

            String str = "It lasts ";
            String unit = " minutes at ";
            String d = " degree.";
            textview2.setText(str+content1+unit+content2+d);
            // textview2.setTextColor(Color.parseColor("#FFFFFF"));
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent){
            return flater.inflate(android.R.layout.two_line_list_item,null);
        }

    }
}
