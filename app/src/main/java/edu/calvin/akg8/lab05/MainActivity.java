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

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import static edu.calvin.akg8.lab05.R.id.preferenceTextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private boolean testPreference = true;

    public static TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        showPreferences();
    }

    private void showPreferences() {
        TextView preferenceTextView = (TextView) findViewById(R.id.preferenceTextView);
        preferenceTextView.setText("Preference: " + prefs.getBoolean("preference", false));
    }


    @Override
    public void onPause() {
        // save the instance variables
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("preference", testPreference);
        editor.commit();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        testPreference = prefs.getBoolean("preference", true);
        showPreferences();
    }

    // implement and display the menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    // start the activity when the item is selected
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                return true;
            case R.id.settings:
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
