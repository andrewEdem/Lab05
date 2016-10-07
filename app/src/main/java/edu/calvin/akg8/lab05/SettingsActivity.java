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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
