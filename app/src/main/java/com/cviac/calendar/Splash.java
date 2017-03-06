package com.cviac.calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

    public static String str_reg_test;
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        str_reg_test = Prefs.getString("isregistered", null);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (str_reg_test != null
                        && !str_reg_test.toString().trim().equals("")) {
                    Intent log = new Intent(Splash.this, Daily_calendar.class);
                    startActivity(log);
                    finish();
                } else {
                    Intent send = new Intent(getApplicationContext(),
                            Registration.class);
                    startActivity(send);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }
}