package com.cviac.calendar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity implements View.OnClickListener {





    EditText name,phonumber,inmail,Birth_time,Date_birth;

    Button reg;

    ImageView date_pick;
    RadioGroup group;
    String male_selection,ename,ephone,mail,edate;
    String female_selection;

    Calendar c = Calendar.getInstance();
    int startYear = c.get(Calendar.YEAR);
    int startMonth = c.get(Calendar.MONTH);
    int startDay = c.get(Calendar.DAY_OF_MONTH);
    private int mYear, mMonth, mDay;

    List<String> citys=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        name = (EditText) findViewById(R.id.name);
     group=(RadioGroup)findViewById(R.id.Radio_selection);

       Date_birth = (EditText) findViewById(R.id.date);

        inmail = (EditText) findViewById(R.id.email);
        phonumber = (EditText) findViewById(R.id.phone);

        date_pick = (ImageView) findViewById(R.id.date_pick);
        reg=(Button)findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ename=name.getText().toString();
                Toast.makeText(getApplicationContext(),"Succes",Toast.LENGTH_LONG).show();
                edate=Date_birth.getText().toString();
                ephone=phonumber.getText().toString();
                mail=inmail.getText().toString();
                if (ename.length() < 1) {
                    name.setError("Enter Valid Name");
                    return;
                }
                if(edate.length()<1)
                {
                    Date_birth.setError("Enter Valid Date");
                    return;
                }
                if (ephone.length()<=10)
                {
                    phonumber.setError("Enter valid Phonenumber");
                    return;
                }
                if(!isValidEmail(mail))
                {
                    inmail.setError("Enter valid Mail");
                    return;
                }

            }


        });
        date_pick.setOnClickListener(this);


        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioMale) {
                    male_selection="male";

                    Toast.makeText(getApplicationContext(), "choice: Silent",
                            Toast.LENGTH_SHORT).show();

                } else if (checkedId == R.id.radioFemale) {
                    female_selection="female";

                    Toast.makeText(getApplicationContext(), "choice: Sound",

                            Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    private boolean isValidEmail(String mail) {

            String EMAILPATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

            Pattern pattern = Pattern.compile(EMAILPATTERN);
            Matcher matcher = pattern.matcher(mail);
            return matcher.matches();


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

