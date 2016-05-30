package binarycounter.reenc;

import android.preference.PreferenceActivity;
import android.os.Bundle;

public class settingsActivity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}