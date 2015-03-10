package edu.dartmouth.asthmaguard;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

/**
 * Created by Wilson on 3/9/15.
 */
public class SharePage extends Activity {
    private DatabaseHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        db= new DatabaseHelper(this);

        List<Entry> entryHolder=db.getAllEntries();

        String entryHolderTxt="";
        for(Entry item: entryHolder){
            entryHolderTxt+=(item.getEventType()+" "+item.getDateTime()+" "+item.getDate()+'\n');
        }

        final String dataTxt=entryHolderTxt;
        setContentView(R.layout.share_page_layout);
        Button btn_share    = (Button) findViewById(R.id.share_btn);
        Button btn_back  = (Button) findViewById(R.id.back_button);


        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String subject="Dataset Sharing";
                String body=dataTxt;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:?subject=" + subject + "&body=" + body);
                intent.setData(data);
                startActivity(intent);

            }
        });



    }


}