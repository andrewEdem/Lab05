package edu.calvin.akg8.lab05;

/*
* Lab05
* CS-262
* This activity creates an options menu and settings preference in an app
*
* @author Andrew Gbeddy
* @author Karen Cudjoe
* @version fall 2016
 */

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import static edu.calvin.akg8.lab05.R.id.preferenceTextView;

public class SettingsFragment extends PreferenceFragment {

    private SharedPreferences prefs;
    private boolean testPreference = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }

}
