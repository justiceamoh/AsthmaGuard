package edu.dartmouth.asthmaguard;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by menglingli on 2/21/15.
 */
public class StartFragment extends Fragment {
    private Button but_start;
    private Intent intent;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.startfragment, container, false);
        intent = new Intent();
        but_start = (Button) v.findViewById(R.id.Start_record);
        but_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(getActivity(), DisplayEntryActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
