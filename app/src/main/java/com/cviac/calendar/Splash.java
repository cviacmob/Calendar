package com.cviac.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.ListView;




public class Splash extends ActionBarActivity {
    private ListView listView;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ImageView im = (ImageView) findViewById(R.id.spimage);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ShamsiCalleder dd =new ShamsiCalleder();

        Thread background = new Thread() {
            public void run() {
                try {
                    sleep(2 * 1000);
                    Intent i = new Intent(getBaseContext(),Daily_calendar.class);
                    startActivity(i);
                    finish();

                } catch (Exception e) {
                }
            }
        };

        background.start();
    }
}
