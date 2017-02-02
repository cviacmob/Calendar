package com.cviac.calendar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
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

    public Cursor getDayReacord(String s) {
        String data = new String();
        return database.rawQuery("SELECT * FROM calendar WHERE dates='"+s+"'", null);
    }



    /*
    public String getname(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM calendar WHERE dates='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }



    public String getnallaneram(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM calendar WHERE dates='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String gettamildat(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM calendar WHERE dates='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String gettamilmonth(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM calendar WHERE dates='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(6));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getraghu(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM calendar WHERE dates='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(3));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getpangulikai(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM calendar WHERE dates='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(4));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getpanaam(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM calendar WHERE dates='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(5));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public String getnightpan(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM calendar WHERE dates='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(7));
            cursor.moveToNext();
        }
        cursor.close();
        return data;

    }

    public String getgulikai(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM calendar WHERE dates='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(8));
            cursor.moveToNext();
        }
        cursor.close();
        return data;

    }

    public String getnightaam(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM calendar WHERE dates='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(9));
            cursor.moveToNext();
        }
        cursor.close();
        return data;


    }

    public String getrasi(String s) {
        String data = new String();
        Cursor cursor = database.rawQuery("SELECT * FROM calendar WHERE dates='"+s+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(10));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }*/
}
