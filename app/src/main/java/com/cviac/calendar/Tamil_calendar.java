package com.cviac.calendar;


import android.app.ActionBar;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
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



import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Tamil_calendar extends ActionBarActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamil_calendar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int ab =position;
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                formatted = df.format(c.getTime());
               // int a = getArguments().getInt(ARG_SECTION_NUMBER);

                int b = ab - 1;
                c.add(Calendar.DATE, b);
                formatted = df.format(c.getTime());

                Log.v("NEXT DATE : ", formatted);



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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
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
        TextView english_mn, english_date, english_day, tamil_mn, tamil_date, tamil_day, daysevents, nalaneram, panchanganeram, nightpangam,
                rasihet, rasipalan, pan_kulikai, pan_aama, nigh_pan_aam, night_kuli;
        TextView box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, box13;
        private static final String ARG_SECTION_NUMBER = "section_number";
        String formattedDate;

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
            english_day = (TextView) rootView.findViewById(R.id.day_week);
            tamil_mn = (TextView) rootView.findViewById(R.id.tamil_month);
            tamil_date = (TextView) rootView.findViewById(R.id.tamil_date);
            tamil_day = (TextView) rootView.findViewById(R.id.tamil_day);
            daysevents = (TextView) rootView.findViewById(R.id.daysevents);
            nalaneram = (TextView) rootView.findViewById(R.id.nala_neram);
            panchanganeram = (TextView) rootView.findViewById(R.id.one);
            nightpangam = (TextView) rootView.findViewById(R.id.one2);
            rasihet = (TextView) rootView.findViewById(R.id.rasiheat);
            rasipalan = (TextView) rootView.findViewById(R.id.rasi);
            pan_aama = (TextView) rootView.findViewById(R.id.three);
            pan_kulikai = (TextView) rootView.findViewById(R.id.two);
            nigh_pan_aam = (TextView) rootView.findViewById(R.id.two3);
            night_kuli = (TextView) rootView.findViewById(R.id.two2);


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

            Typeface faceAkshar = Typeface.createFromAsset(getActivity().getAssets(), "akshar.ttf");

            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            formattedDate = df.format(c.getTime());
            int a = getArguments().getInt(ARG_SECTION_NUMBER);

            int b = a - 1;
            c.add(Calendar.DATE, b);
            formattedDate = df.format(c.getTime());
            english_date.setText(formattedDate);


            english_mn.setText(new SimpleDateFormat("MMM").format(c.getTime()));
            english_date.setText(formattedDate);

            tamil_day.setTypeface(faceAkshar);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            tamil_day.setTypeface(faceAkshar);
            String weekDay = "";


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
            english_day.setText(weekDay);
            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
            databaseAccess.open();

            Cursor cursor = databaseAccess.getDayReacord(formattedDate);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String  val=(cursor.getString(1));
                daysevents.setText(val);
                val=(cursor.getString(2));
                nalaneram.setText(val);
                val=(cursor.getString(3));
                tamil_mn.setText(val);
                val=(cursor.getString(6));
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
                val=(cursor.getString(3));
                tamil_mn.setText(val);
                cursor.moveToNext();
            }



            /*tamil_mn.setText(databaseAccess.gettamilmonth(formattedDate));
            panchanganeram.setText(databaseAccess.getraghu(formattedDate));
            pan_kulikai.setText(databaseAccess.getpangulikai(formattedDate));
            pan_aama.setText(databaseAccess.getpanaam(formattedDate));
            nightpangam.setText(databaseAccess.getnightpan(formattedDate));
            night_kuli.setText(databaseAccess.getgulikai(formattedDate));
            nigh_pan_aam.setText(databaseAccess.getnightaam(formattedDate));
            rasipalan.setText(databaseAccess.getrasi(formattedDate));*/
            databaseAccess.close();
            rasihet.setTypeface(faceAkshar);
            rasihet.setText("இராசிபலன்");

/*
            DatabaseAccess2 databaseAccess2 = DatabaseAccess2.getInstance1(getActivity());
            databaseAccess2.open();

            Cursor cursor2 = databaseAccess2.getDayReacord2(formattedDate);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String  val=(cursor.getString(1));
                tamil_date.setText(val);
                val=(cursor2.getString(2));
                box1.setText(val);
                val=(cursor2.getString(3));
                box2.setText(val);
                val=(cursor2.getString(6));
                box3.setText(val);
                val=(cursor2.getString(5));
                box4.setText(val);
                val=(cursor2.getString(4));
                box5.setText(val);
                val=(cursor2.getString(7));
                box7.setText(val);
                val=(cursor2.getString(8));
                box8.setText(val);
                val=(cursor2.getString(9));
                box9.setText(val);
                val=(cursor2.getString(10));
                box10.setText(val);
                val=(cursor2.getString(11));
                box12.setText(val);
                val=(cursor2.getString(12));
                box12.setText(val);
                val=(cursor2.getString(13));
                box13.setText(val);


                cursor.moveToNext();
            }*//*
            tamil_date.setText(databaseAccess2.gettamildat(formattedDate));
            box1.setText(databaseAccess2.getbox1(formattedDate));
            box2.setText(databaseAccess2.getbox2(formattedDate));
            box3.setText(databaseAccess2.getbox3(formattedDate));
            box4.setText(databaseAccess2.getbox4(formattedDate));
            box5.setText(databaseAccess2.getbox5(formattedDate));
            box6.setText(databaseAccess2.getbox6(formattedDate));
            box7.setText(databaseAccess2.getbox7(formattedDate));
            box8.setText(databaseAccess2.getbox8(formattedDate));
            box9.setText(databaseAccess2.getbox9(formattedDate));
            box10.setText(databaseAccess2.getbox10(formattedDate));
            box11.setText(databaseAccess2.getbox11(formattedDate));
            box12.setText(databaseAccess2.getbox12(formattedDate));
            box13.setText(databaseAccess2.getbox13(formattedDate));*//*


            databaseAccess2.close();*/
            return rootView;
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
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 100;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "object" + (position + 100);
            /*switch (position) {
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
