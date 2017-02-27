package com.cviac.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cviac.calendar.datamodel.WonderModel;

import java.util.ArrayList;
import java.util.List;

public class Event extends AppCompatActivity {
    TextView titles, expen, dates,eve_place,times,eve_cost,ab;
    ImageView eve_image;
    List<WonderModel> wndr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_test);

        Intent i = getIntent();
        WonderModel wndrm = (WonderModel) i.getSerializableExtra("events");

        titles = (TextView) findViewById(R.id.title);
        dates = (TextView) findViewById(R.id.date_event);
        expen = (TextView) findViewById(R.id.event_cost);
        times=(TextView)findViewById(R.id.eve_time);

        ab=(TextView)findViewById(R.id.about);

        eve_image = (ImageView) findViewById(R.id.event_image);
        eve_place=(TextView)findViewById(R.id.event_place);

        eve_image.setImageResource(wndrm.getImageResourceId());
        titles.setText(wndrm.getDescription());
        dates.setText(wndrm.getdate());
      eve_place.setText(wndrm.getplace());
        expen.setText(wndrm.getCost());
        times.setText(wndrm.getTime());
        ab.setText(wndrm.getAbout());



    }
}