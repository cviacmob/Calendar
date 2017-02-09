package com.cviac.calendar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class Gridview_tamil extends ActionBarActivity {
    GridView grid;
    private Calendar _calendar;
    private int month, year, month1,year1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        _calendar = Calendar.getInstance(Locale.getDefault());
        month = _calendar.get(Calendar.MONTH) + 1;
        year = _calendar.get(Calendar.YEAR);
        month1=_calendar.get(Calendar.MONTH) + 1;
        year1= _calendar.get(Calendar.YEAR);



        CustomGrid adapter = new CustomGrid(Gridview_tamil.this, month, year,month1,year1);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(Gridview_tamil.this, "You Clicked at " , Toast.LENGTH_SHORT).show();

            }
        });

    }
    }

