package com.cviac.calendar;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cviac.calendar.datamodel.MyDataHolder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class Daily_calendar extends ActionBarActivity {

    private static String ARG_SECTION_NUMBER;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    String formatted;
    int count=50;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamil_calendar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        if(mViewPager !=null) {

            mViewPager.setAdapter(mSectionsPagerAdapter);
            mViewPager.setCurrentItem(count);
        }





        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int ab =position;




            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tamil_calendar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent in;


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.action){

           in=new Intent(Daily_calendar.this,MyCalendarActivity.class);
            startActivity(in);
        }




        return super.onOptionsItemSelected(item);
    }


    public String getdatess() {
        //String cv="27-01-2017";
       // Toast.makeText(getApplication(),"success",Toast.LENGTH_LONG).show();
        String cv=formatted;
        return cv;
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         *

         * fragment.
         */


        String datas;

        int mm=2;
        int yy=2017;
        String current;
        private static final String tag = "GridCellAdapter";
        private static final int DAY_OFFSET = 1;
        private final String[] weekdays = new String[]{"Sun", "Mon", "Tue",
                "Wed", "Thu", "Fri", "Sat"};
        private  List<String> list;
        private int daysInMonth;
        private int currentDayOfMonth;
        private int currentWeekDay;
        private final String[] months = {"January", "February", "March",
                "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        private final int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30,
                31, 30, 31};

        TextView english_mn, english_date, english_day, tamil_mn, tamil_date, tamil_day, daysevents, nalaneram, panchanganeram, nightpangam,
                rasihet, rasipalan, pan_kulikai, pan_aama, nigh_pan_aam, night_kuli;
        TextView box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, box13;
        private static final String ARG_SECTION_NUMBER = "section_number";
        String formattedDate;
        String data;
        MyDataHolder holde=new MyDataHolder();


        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {




            View rootView = inflater.inflate(R.layout.fragment_tamil_calendar, container, false);
            english_mn = (TextView) rootView.findViewById(R.id.eng_mn);
            english_date = (TextView) rootView.findViewById(R.id.engdate);
            english_day = (TextView) rootView.findViewById(R.id.english_day);
            tamil_mn = (TextView) rootView.findViewById(R.id.tamil_month);
            tamil_date = (TextView) rootView.findViewById(R.id.tamil_date);
            tamil_day = (TextView) rootView.findViewById(R.id.tamil_day);
            daysevents = (TextView) rootView.findViewById(R.id.daysevents);
            nalaneram = (TextView) rootView.findViewById(R.id.nala_neram);
            panchanganeram = (TextView) rootView.findViewById(R.id.rahu);
            nightpangam = (TextView) rootView.findViewById(R.id.nigh_rahu);
            rasihet = (TextView) rootView.findViewById(R.id.rasiheat);
            rasipalan = (TextView) rootView.findViewById(R.id.rasi);
            pan_aama = (TextView) rootView.findViewById(R.id.aam);
            pan_kulikai = (TextView) rootView.findViewById(R.id.gulikai);
            nigh_pan_aam = (TextView) rootView.findViewById(R.id.night_aam);
           night_kuli = (TextView) rootView.findViewById(R.id.night_gulikai);


            box1 = (TextView) rootView.findViewById(R.id.aa);
            box2 = (TextView) rootView.findViewById(R.id.bb);
            box3 = (TextView) rootView.findViewById(R.id.cc);
            box4 = (TextView) rootView.findViewById(R.id.dd);
            box5 = (TextView) rootView.findViewById(R.id.six);
            box6 = (TextView) rootView.findViewById(R.id.ii);
            box7 = (TextView) rootView.findViewById(R.id.hh);
            box8 = (TextView) rootView.findViewById(R.id.mmm);
            box9 = (TextView) rootView.findViewById(R.id.jj);
            box10 = (TextView) rootView.findViewById(R.id.kk);
            box11 = (TextView) rootView.findViewById(R.id.mm);
            box12 = (TextView) rootView.findViewById(R.id.nn);
            box13 = (TextView) rootView.findViewById(R.id.oo);
          //  String Item = getActivity().getIntent().getExtras().getString("image");
            Intent intent =getActivity(). getIntent();
            if (null != intent) {
                String mothlydata = intent.getStringExtra("image");

                holde.setMonthdate(mothlydata);


            }






            Typeface faceAkshar = Typeface.createFromAsset(getActivity().getAssets(), "akshar.ttf");

            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            formattedDate = df.format(c.getTime());
            int a = getArguments().getInt(ARG_SECTION_NUMBER);
            int dd=50;

            int b = a -dd;
            c.add(Calendar.DATE, b);
            formattedDate = df.format(c.getTime());
            english_date.setText(formattedDate);


            english_mn.setText(new SimpleDateFormat("MMM").format(c.getTime()));
            english_date.setText(formattedDate);

            tamil_day.setTypeface(faceAkshar);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            tamil_day.setTypeface(faceAkshar);
            String weekDay = "";

            //rasihet.setText(dataes);
           // tamil_date.setText(dataes);



            if (Calendar.MONDAY == dayOfWeek) {
                weekDay = "Monday";

                tamil_day.setText("திங்கள்");


            } else if (Calendar.TUESDAY == dayOfWeek) {
                weekDay = "Tuesday";
                tamil_day.setText("செவ்வாய்");
            } else if (Calendar.WEDNESDAY == dayOfWeek) {
                weekDay = "Wednesday";
                tamil_day.setText("புதன்");

            } else if (Calendar.THURSDAY == dayOfWeek) {
                weekDay = "Thursday";
                tamil_day.setText("வியாழன்");
            } else if (Calendar.FRIDAY == dayOfWeek) {
                weekDay = "Friday";
                tamil_day.setText("வெள்ளி");

            } else if (Calendar.SATURDAY == dayOfWeek) {
                weekDay = "Saturday";
                tamil_day.setText("சனி");
            } else if (Calendar.SUNDAY == dayOfWeek) {
                weekDay = "Sunday";
                tamil_day.setText("ஞாயிறு");
            }



            // TextView textView = (TextView) rootView.findViewById(R.id.section_label);
           // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));e
            
            english_day.setText(holde.getMonthdate());


            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
            databaseAccess.open();
            Cursor cursor = databaseAccess.getDayReacord(formattedDate);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String  val=(cursor.getString(1));
                daysevents.setText(val);
                val=(cursor.getString(2));
                nalaneram.setText(val);
                val=(cursor.getString(6));
                tamil_mn.setText(val);
                val=(cursor.getString(3));
                panchanganeram.setText(val);
                val=(cursor.getString(5));
                pan_kulikai.setText(val);
                val=(cursor.getString(4));
                pan_aama.setText(val);
                val=(cursor.getString(7));
                nightpangam.setText(val);
                val=(cursor.getString(8));
                night_kuli.setText(val);
                val=(cursor.getString(9));
                nigh_pan_aam.setText(val);
                val=(cursor.getString(10));
                rasipalan.setText(val);
                cursor.moveToNext();
            }
            databaseAccess.close();
         rasihet.setTypeface(faceAkshar);
           rasihet.setText("இராசிபலன்");

           // rasihet.setText(Item);





       DatabaseAccess2 databaseAccess2 = DatabaseAccess2.getInstance1(getActivity());
            databaseAccess2.open();

            //tamil_date.setText(databaseAccess2.getbox13(formattedDate));
            Cursor cursoras=databaseAccess2.getDayReacordas(formattedDate);
            cursoras.moveToNext();
            while (!cursoras.isAfterLast())
            {
               // String as=(cursoras.getString(1));
               // tamil_date.setText(as);
                String as=(cursoras.getString(2));
                //as=(cursoras.getString(2));
                box1.setText(as);
                as=(cursoras.getString(3));
                box2.setText(as);
                as=(cursoras.getString(3));
                box3.setText(as);
                as=(cursoras.getString(4));
                box4.setText(as);
                as=(cursoras.getString(5));
                box5.setText(as);
                as=(cursoras.getString(6));
                box6.setText(as);
                as=(cursoras.getString(7));
                box7.setText(as);
                as=(cursoras.getString(9));
                box8.setText(as);
                as=(cursoras.getString(10));
                box9.setText(as);
                as=(cursoras.getString(11));
                box10.setText(as);
                as=(cursoras.getString(12));
                box11.setText(as);
                as=(cursoras.getString(13));
                box12.setText(as);
                as=(cursoras.getString(14));
                box13.setText(as);
                cursoras.moveToNext();
            }
            databaseAccess2.close();

            Calendar calendar = Calendar.getInstance();
            setCurrentDayOfMonth(calendar.get(Calendar.DAY_OF_MONTH));
            setCurrentWeekDay(calendar.get(Calendar.DAY_OF_WEEK));


                Log.d(tag, "==> printMonth: mm: " + mm + " " + "yy: " + yy);
                int trailingSpaces = 0;
                int daysInPrevMonth = 0;
                int prevMonth = 0;
                int prevYear = 0;
                int nextMonth = 0;
                int nextYear = 0;

                int currentMonth = mm - 1;
                String currentMonthName = getMonthAsString(currentMonth);

                daysInMonth = getNumberOfDaysOfMonth(currentMonth);

                Log.d(tag, "Current Month: " + " " + currentMonthName + " having "
                        + daysInMonth + " days.");

                GregorianCalendar cal = new GregorianCalendar(yy, currentMonth, 1);
                Log.d(tag, "Gregorian Calendar:= " + cal.getTime().toString());

                if (currentMonth == 11) {
                    prevMonth = currentMonth - 1;
                    daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                    nextMonth = 0;
                    prevYear = yy;
                    nextYear = yy + 1;
                    Log.d(tag, "*->PrevYear: " + prevYear + " PrevMonth:"
                            + prevMonth + " NextMonth: " + nextMonth
                            + " NextYear: " + nextYear);
                } else if (currentMonth == 0) {
                    prevMonth = 11;
                    prevYear = yy - 1;
                    nextYear = yy;
                    daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                    nextMonth = 1;
                    Log.d(tag, "**--> PrevYear: " + prevYear + " PrevMonth:"
                            + prevMonth + " NextMonth: " + nextMonth
                            + " NextYear: " + nextYear);
                } else {
                    prevMonth = currentMonth - 1;
                    nextMonth = currentMonth + 1;
                    nextYear = yy;
                    prevYear = yy;
                    daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                    Log.d(tag, "***---> PrevYear: " + prevYear + " PrevMonth:"
                            + prevMonth + " NextMonth: " + nextMonth
                            + " NextYear: " + nextYear);
                }

                int currentWeekDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
                trailingSpaces = currentWeekDay;

                Log.d(tag, "Week Day:" + currentWeekDay + " is "
                        + getWeekDayAsString(currentWeekDay));
                Log.d(tag, "No. Trailing space to Add: " + trailingSpaces);
                Log.d(tag, "No. of Days in Previous Month: " + daysInPrevMonth);

                if (cal.isLeapYear(cal.get(Calendar.YEAR)))
                    if (mm == 2)
                        ++daysInMonth;
                    else if (mm == 3)
                        ++daysInPrevMonth;

                // Trailing Month days
                for (int i = 0; i < trailingSpaces; i++) {
                    Log.d(tag,
                            "PREV MONTH:= "
                                    + prevMonth
                                    + " => "
                                    + getMonthAsString(prevMonth)
                                    + " "
                                    + String.valueOf((daysInPrevMonth
                                    - trailingSpaces + DAY_OFFSET)
                                    + i));

               /* list.add(String.valueOf((daysInPrevMonth - trailingSpaces + DAY_OFFSET) + i) + "-WHITE" + "-"
                        + getMonthAsString(prevMonth)
                        + "-"
                        + prevYear);*/
                }

                // Current Month Days
			/*private final String[] months = { "January", "February", "March",
					"April", "May", "June", "July", "August", "September",
					"October", "November", "December" };*/

                String mon = getMonthAsString(currentMonth);

                int aa = 0;
                int bb = 0;
                if (mon == "January") {
                    aa = 17;
                    bb = 29;
                }

                if (mon == "February") {
                    aa = 19;
                    bb = 30;
                }
                if (mon == "March") {
                    aa = 17;
                    bb = 29;
                }
                if (mon == "April") {
                    aa = 19;
                    bb = 31;
                }
                if (mon == "May") {
                    aa = 18;
                    bb = 30;
                }
                if (mon == "June") {
                    aa = 18;
                    bb = 31;
                }
                if (mon == "July") {
                    aa = 17;
                    bb = 32;
                }
                if (mon == "August") {
                    aa = 16;
                    bb = 31;
                }

                if (mon == "September") {
                    aa = 16;
                    bb = 31;
                }
                if (mon == "October") {
                    aa = 15;
                    bb = 31;
                }
                if (mon == "November") {
                    aa = 15;
                    bb = 30;
                }
                if (mon == "December") {
                    aa = 15;
                    bb = 29;
                }


                for (int i = aa; i <= daysInMonth + aa; i++) {

                    Log.d(currentMonthName, String.valueOf(i) + " " + getMonthAsString(currentMonth) + " " + yy);
                    current=String.valueOf(i);
                   // tamil_date.setText(current);
                    if (i == getCurrentDayOfMonth()) {
                        // list.add(String.valueOf(i) + "-BLUE" + "-" + getMonthAsString(currentMonth) + "-" + yy);
                        current=String.valueOf(i) + "-BLUE" + "-" + getMonthAsString(currentMonth) + "-" + yy;
                        //tamil_date.setText(current);

                    } else {
                        int ab = i;
                        int ac = 0;
                        int ad = bb;


                        if (ab > ad) {

                            ac = ab - ad;
                        } else {
                            ac = ab;


                        }

                        //tamil_date.setText(cc);
                        // list.add(String.valueOf(ac) + "-GREY" + "-" + getMonthAsString(currentMonth) + "-" + yy + String.valueOf(i));


                    }
                }


                // Leading Month days
           /*     for (int i = 0; i < list.size() % 7; i++) {
                    Log.d(tag, "NEXT MONTH:= " + getMonthAsString(nextMonth));
                    // list.add(String.valueOf(i + 1) + "-GREY" + "-" + getMonthAsString(nextMonth) + "-" + nextYear);


                }*/





            return rootView;
        }

        private void setCurrentWeekDay(int i) {
            this.currentWeekDay = i;
        }


        private String getWeekDayAsString(int i) {
            return weekdays[i];
        }

        private int getNumberOfDaysOfMonth(int i) {

            return daysOfMonth[i];
        }

        private String getMonthAsString(int i) {
            return months[i];
        }


        public int getCurrentDayOfMonth() {
            return currentDayOfMonth;
        }

        public void setCurrentDayOfMonth(int currentDayOfMonth) {
            this.currentDayOfMonth = currentDayOfMonth;
        }
        public int getCurrentWeekDay() {
            return currentWeekDay;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position );
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 100;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "object" + (position + 100);
         /*   switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;*/
        }
    }

}

