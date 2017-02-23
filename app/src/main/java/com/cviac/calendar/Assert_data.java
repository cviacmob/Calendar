package com.cviac.calendar;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Assert_data extends ActionBarActivity {
    SQLiteDatabase rb;
    public String sql="27-01-2017";
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assert_data);
        TextView t1=(TextView)findViewById(R.id.textView);
        /*Insert into calendar(dates ,daysspecial,aspicious,pan_ragu,pan_gulikai ,pan_aam,tamil_month,night_ragu,night_gulikai ,night_aam,rasi)
        values ('04-02-2017','சர்வதேச புற்றுநோய் தினம்.முதல் முறையாக ரேடியம் ஈ என்ற செயற்கைக் கதிரியக்க மூலகம் உருவாக்கப்பட்டது(1936)' ,'நல்ல நேரம்: காலை, 7.30-8.30 மணி முதல்   மாலை 4.30-5.30 மணி வரை
        ','ராகு     :9.00-10.30
        ','குளிகை	:5.00-7.30
        ','எமகண்டம்   :1.30-2.30
        ','துர்முகி வருடம் - தை
        ','இரவுராகு  :3.00-4.30
        ','இரவுகுளி  :10.30-12-30
        ','இரவு எம :7.30-9.00  ','மேஷம்  - கோபம்    விருச்சி -நடப்பு  ரிஷபம்-போட்டி   மிதுனம்-ஆர்வம்  சிம்மம் - மேன்மை   கடகம்- பயம்   கன்னி -   இனபம்      துலாம்-நன்மை   விருச்சி-பெருமை   தனுசு - நிறைவு      மகரம்- வெற்றி   கும்பம்-உதவி  மீனம் - விவேகம்   ');*/

       /* DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        t1.setText(databaseAccess.getname());
        databaseAccess.close();*/

        ImageView im=(ImageView)findViewById(R.id.testimage);
        bitmap=GetBitmapfromUrl("http://http://www.planwallpaper.com/static/images/Winter-Tiger-Wild-Cat-Images.jpg");
        im.setImageBitmap(bitmap);






    }

    private Bitmap GetBitmapfromUrl(String s) {
        try {

            URL url=new URL(s);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input=connection.getInputStream();
            Bitmap bmp = BitmapFactory.decodeStream(input);
            return bmp;



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }
    }
 /*   public String dates() {
        String datas = new String();
        datas="27-01-2017";

      *//*  Cursor cursor = database.rawQuery("SELECT * FROM astro WHERE date='27-01-2017'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data=(cursor.getString(6));
            cursor.moveToNext();
        }*//*
        //cursor.close();
        return datas;
    }*/

  /*  public String getdatess() {
        String b=new String();
        b="27-01-2017";
        return b;
    }*/

   /* insert into astro(date,tamil_date ,t1 ,t2 ,t3 ,t4 ,t5 ,t6 ,t7,t8 ,t9 ,t10 ,t11 ,t12 ,t13) values('16-02-2017','4','சு சே ','' ,'','  ','கு கே' ,' ',' பு மா',' ரா ',' சனி ',' ','ல','சாந் வி ', 'சித்திரை ');*/

  //  Insert into calendar (dates ,daysspecial ,aspicious ,pan_ragu ,pan_gulikai ,pan_aam ,tamil_month ,night_ragu ,night_gulikai ,night_aam , rasi ) values('20-03-2017','சுபமுகூர்த்த நாள்(காலை 10.30 - 12.00)','நல்ல நேரம்: காலை, 7.30-8.30 மணி முதல்   மாலை 4.30-5.30 மணி வரை','ராகு     :9.00-10.30','குளிகை	:5.00-7.30','எமகண்டம்   :1.30-2.30','துர்முகி வருடம் - தை','இரவுராகு  :3.00-4.30','இரவுகுளி  :10.30-12-30','இரவு எம :7.30-9.00','மேஷம்  - கோபம்    விருச்சி -நடப்பு  ரிஷபம்-போட்டி   மிதுனம்-ஆர்வம்  சிம்மம் - மேன்மை   கடகம்- பயம்   கன்னி -   இனபம்      துலாம்-நன்மை   விருச்சி-பெருமை   தனுசு - நிறைவு      மகரம்- வெற்றி   கும்பம்-உதவி  மீனம் - விவேகம்  ');


}
