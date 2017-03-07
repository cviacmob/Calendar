package com.cviac.calendar;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cviac.calendar.adapters.LoadImageTask;


public class Assert_data extends Activity implements View.OnClickListener, LoadImageTask.Listener {
    private static final String TAG = "Assert_data";
    SQLiteDatabase rb;
    public String sql="27-01-2017";
    String eve;





    public static final String IMAGE_URL = "http://photos.wikimapia.org/p/00/00/58/20/98_big.jpg";
    ImageView im;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assert_data);




        TextView t1=(TextView)findViewById(R.id.tex);

        t1.setText(eve);
        b1=(Button)findViewById(R.id.imload);



      im=(ImageView)findViewById(R.id.testimage);
b1.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imload:
                new LoadImageTask(this).execute(IMAGE_URL);
                break;
        }
        }



    @Override
    public void onImageLoaded(Bitmap bitmap) {
        im.setImageBitmap(bitmap);

    }

    @Override
    public void onError() {

    }
}

