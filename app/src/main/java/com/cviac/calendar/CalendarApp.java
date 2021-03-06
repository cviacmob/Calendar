package com.cviac.calendar;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

public class CalendarApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }
}
