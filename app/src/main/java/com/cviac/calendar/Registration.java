package com.cviac.calendar;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Registration extends AppCompatActivity implements View.OnClickListener {
    TextView contact,mail;
    EditText name,phonumber,email,Birth_time,Date_birth;
    Spinner city;
    Button sub;
    RadioButton male,female;
    ImageView date_pick,time_pick;

    Calendar c = Calendar.getInstance();
    int startYear = c.get(Calendar.YEAR);
    int startMonth = c.get(Calendar.MONTH);
    int startDay = c.get(Calendar.DAY_OF_MONTH);
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        name=(EditText)findViewById(R.id.name);
        male=(RadioButton)findViewById(R.id.selection_male);
        female=(RadioButton)findViewById(R.id.selection_female);
        Date_birth=(EditText)findViewById(R.id.date);
        Birth_time=(EditText)findViewById(R.id.time);
        email=(EditText)findViewById(R.id.email);
        phonumber=(EditText)findViewById(R.id.phone);
        city=(Spinner)findViewById(R.id.city_birth);
        sub=(Button)findViewById(R.id.submit);
        date_pick=(ImageView)findViewById(R.id.date_pick);
        time_pick=(ImageView)findViewById(R.id.time_pick);

        date_pick.setOnClickListener(this);





    }
    @Override
    public void onClick(View v) {
        if (v == date_pick) {

            // Process to get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfaMonth) {
                    // Display Selected date in textbox


                    Date_birth.setText(year + "-"
                            + (monthOfYear + 1) + "-" + dayOfaMonth);

                }
            }, mYear, mMonth, mDay);
            dpd.show();

        }
    }
}
