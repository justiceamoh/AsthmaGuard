package edu.dartmouth.asthmaguard;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by menglingli on 3/8/15.
 */
public class settingActivity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

    }
}
