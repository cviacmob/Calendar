package com.cviac.calendar;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper2 extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "AstroDB.sqlite";
    private static final int DATABASE_VERSION = 1;

    public DatabaseOpenHelper2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}