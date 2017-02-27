package com.cviac.calendar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EventAcces {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static EventAcces instance2;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private EventAcces(Context context) {
        this.openHelper = new EventOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static EventAcces getInstance2(Context context) {
        if (instance2 == null) {
            instance2 = new EventAcces(context);
        }
        return instance2;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }



   /* public Cursor getDayReacord(String s) {
        String data = new String();
        return database.rawQuery("SELECT * FROM Events WHERE dates='"+s+"'", null);
    }*/


    public Cursor getDayEvent(String s) {
        String data = new String();
        return database.rawQuery("SELECT * FROM Events WHERE dates='"+s+"'", null);

       // return database.rawQuery("SELECT * FROM Events WHERE dates='"+s+"'", null);
    }
}
