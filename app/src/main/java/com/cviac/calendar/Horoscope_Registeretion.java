package com.cviac.calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by cviac on 2/15/2017.
 */

public class Horoscope_Registeretion extends ActionBarActivity implements View.OnClickListener{
    Button generated;
    private int mYear, mMonth, mDay;
    EditText dates;

    @Override
    protected void onCreate(Bundle saveInstenceState){
        super.onCreate(saveInstenceState);
        setContentView(R.layout.horoscope);
       // dates=(EditText)findViewById(R.id.dateset);
       // generated=(Button)findViewById(R.id.generate);
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v == generated) {

            // Process to get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // Display Selected date in textbox
                            dates.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);


                        }
                    }, mYear, mMonth, mDay);

            dpd.getDatePicker().setMaxDate(System.currentTimeMillis());

            dpd.show();
        }

    }



}
