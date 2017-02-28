package com.cviac.calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;





public class Splash extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/
//       ImageView im = (ImageView) findViewById(R.id.spimage);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();


        Thread background = new Thread() {
            public void run() {
                try {
                    sleep(1 * 1000);
                    Intent i = new Intent(Splash.this,Daily_calendar.class);
                    startActivity(i);
                    finish();

                } catch (Exception e) {
                }
            }
        };

        background.start();
    }
}
