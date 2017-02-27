package com.cviac.calendar;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class EventOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "Event.sqlite";
    private static final int DATABASE_VERSION = 1;

    public EventOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
