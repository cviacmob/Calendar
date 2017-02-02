package com.cviac.calendar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseAccess2 {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess2 instance1;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess2(Context context) {
        this.openHelper = new DatabaseOpenHelper2(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */


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

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    /*public List<String> getQuotes() {
        List<String> list = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM calendar where dates='18-01-2017'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }*/



    public Cursor getDayReacord2(String s) {
        String data = new String();
        return database.rawQuery("SELECT * FROM astro WHERE dates='"+s+"'", null);
    }

    /*public String gettamildat(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }*/


    public static DatabaseAccess2 getInstance1(Context context) {
        if (instance1 == null) {
            instance1 = new DatabaseAccess2(context);
        }
        return instance1;
    }

    /*public String getbox1(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getbox2(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(3));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getbox3(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(4));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getbox4(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(5));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getbox5(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(6));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getbox6(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(7));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getbox7(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(8));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getbox8(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(9));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getbox9(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(10));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getbox10(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(11));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getbox11(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(12));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getbox12(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(13));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getbox13(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(14));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }*/
}
