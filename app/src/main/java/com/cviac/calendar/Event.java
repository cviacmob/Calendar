package com.cviac.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cviac.calendar.datamodel.WonderModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Event extends AppCompatActivity {
    TextView titles, expen, dates,eve_place,times,eve_cost,ab;
    ImageView eve_image;
    List<WonderModel> wndr;
    TextView more;
    String moredetails;
    ImageView ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Intent i = getIntent();
        final WonderModel wndrm = (WonderModel) i.getSerializableExtra("events");

        titles = (TextView) findViewById(R.id.title);
        dates = (TextView) findViewById(R.id.date_event);
        expen = (TextView) findViewById(R.id.event_cost);
        times=(TextView)findViewById(R.id.eve_time);
        more=(TextView)findViewById(R.id.more_about);
        ma=(ImageView)findViewById(R.id.map);

        ab=(TextView)findViewById(R.id.about);

        eve_image = (ImageView) findViewById(R.id.event_image);
        eve_place=(TextView)findViewById(R.id.event_place);

       // eve_image.setImageResource(wndrm.getImageResourceId());
        titles.setText(wndrm.getDescription());
        dates.setText(wndrm.getdate());
      eve_place.setText(wndrm.getplace());
        expen.setText(wndrm.getCost());
        times.setText(wndrm.getTime());
        ab.setText(wndrm.getAbout());
        moredetails=wndrm.getAbout();
        Picasso.with(this).load(wndrm.getUrl()).resize(120, 60).into(eve_image);
        final String Actionbar=wndrm.getDescription();
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent detail=new Intent(Event.this,About.class);
                detail.putExtra("det",moredetails);
                detail.putExtra("action",Actionbar);
                startActivity(detail);
            }
        });


        ma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent detail=new Intent(Event.this,MapsActivity.class);
//                detail.putExtra("det",moredetails);
//                detail.putExtra("action",Actionbar);
                startActivity(detail);
            }
        });


    }
}