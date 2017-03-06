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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cviac.calendar.datamodel.MyDataHolder;
import android.widget.ImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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
        onBackPressed();




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








        private static final String tag = "GridCellAdapter";

        private final String[] weekdays = new String[]{"Sun", "Mon", "Tue",

                "Wed", "Thu", "Fri", "Sat"};

        String[] aspcious={"ராகு","எமகண்டம்","குளிகை","இரவு ராகு","இரவு எம","இரவு குளிகை"};
        String[] rasis={"மேஷம் -வரவு , ரிஷபம் சிக்கல் , மிதுனம் , நோய் , கடகம் எதிர்ப்பு , சிம்சிம் , வெற்றி , கனி , சிந்தனை , துலாம் , பயம் , விருச்சகம் நட்ப்பு , தனுசு , தடங்கல் , மகரம் , மகிழ்ச்சி , கும்பம் ஆதாயம் , மீனம் சுகம்" };




        private final String[] months = {"January", "February", "March",
                "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};

        private final int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30,
                31, 30, 31};
       
        String[] parts;
        String part1;
        String part2;
        String[] prt;
        String part3;
        String part4;
        String timecom;
       ImageView onc1 ,onc2,pan;

        TextView english_mn, english_date, english_day, tamil_mn, tamil_date, tamil_day, daysevents, nalaneram, panchanganeram, nightpangam,
                rasihet, rasipalan, pan_kulikai, pan_aama, nigh_pan_aam, night_kuli,l1,l2,l3,l4,l5,l6;
        TextView box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, box13;
        private static final String ARG_SECTION_NUMBER = "section_number";
        String formattedDate;
        DatabaseAccess databaseAccess ;
        Cursor cursor;

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
            databaseAccess = DatabaseAccess.getInstance(getActivity());

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
            box5 = (TextView) rootView.findViewById(R.id.ee);
            box6 = (TextView) rootView.findViewById(R.id.ff);
            box7 = (TextView) rootView.findViewById(R.id.gg);
            box8 = (TextView) rootView.findViewById(R.id.hh);
            box9 = (TextView) rootView.findViewById(R.id.ii);
            box10 = (TextView) rootView.findViewById(R.id.jj);
            box11 = (TextView) rootView.findViewById(R.id.kk);
            box12 = (TextView) rootView.findViewById(R.id.ll);
            box13 = (TextView) rootView.findViewById(R.id.mm);
            pan=(ImageView)rootView.findViewById(R.id.pan_click);
            onc1=(ImageView)rootView.findViewById(R.id.onclick);
            onc2=(ImageView)rootView.findViewById(R.id.onclick2);
            l1=(TextView)rootView.findViewById(R.id.lt1);
            l2=(TextView)rootView.findViewById(R.id.lt2);
            l3=(TextView)rootView.findViewById(R.id.ltt3);
            l4=(TextView)rootView.findViewById(R.id.ltt4);
            l5=(TextView)rootView.findViewById(R.id.lt5);
            l6=(TextView)rootView.findViewById(R.id.lt6);


            String s=getActivity().getIntent().getStringExtra("dats");
            pan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent pa=new Intent(getActivity(),Panchaingam_chat.class);
                    startActivity(pa);
                }
            });













            onc1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),"onclick",Toast.LENGTH_LONG).show();
                    databaseAccess.open();
                    cursor=databaseAccess.getDayReacord(formattedDate);
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()){
                        String val=(cursor.getString(7));
                        l4.setText("இரவு ராகு");

                        nightpangam.setText(val);

                        val=(cursor.getString(8));
                        l5.setText("இரவு எம");

                        nigh_pan_aam.setText(val);

                        val=(cursor.getString(9));
                        l6.setText("இரவு குளிகை");

                        night_kuli.setText(val);


                        cursor.moveToNext();
                    }
                    databaseAccess.close();

                    Toast.makeText(getActivity(),"click one",Toast.LENGTH_LONG).show();
                }
            });
            rasipalan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    databaseAccess.open();
                    cursor = databaseAccess.getDayReacord(formattedDate);
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {
                        String val = (cursor.getString(10));
                        rasipalan.setText(val);

                        cursor.moveToNext();
                    }
                    databaseAccess.close();
                }
            });






            Intent intent =getActivity(). getIntent();
            if (null != intent) {
                String mothlydata = intent.getStringExtra("image");

                holde.setMonthdate(mothlydata);


            }
            daysevents.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent eve=new Intent(getActivity(),Cardview_tab.class);
                    startActivity(eve);
                }
            });

            Typeface faceAkshar = Typeface.createFromAsset(getActivity().getAssets(), "akshar.ttf");

            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat tf=new SimpleDateFormat("h");
            formattedDate = df.format(c.getTime());
            timecom=tf.format(c.getTime());
            int a = getArguments().getInt(ARG_SECTION_NUMBER);
            int dd=50;

            int b = a -dd;

            if(s!=null){
                formattedDate=s;
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    c.setTime(sdf.parse(s));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getActivity(),s,Toast.LENGTH_LONG).show();

            }


                c.add(Calendar.DATE, b);


            formattedDate = df.format(c.getTime());

            english_date.setText(formattedDate);
            english_mn.setText(new SimpleDateFormat("MMM").format(c.getTime()));


            tamil_day.setTypeface(faceAkshar);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            tamil_day.setTypeface(faceAkshar);
            String weekDay = "";

            if (Calendar.MONDAY == dayOfWeek) {
                weekDay = "Monday";
                english_day.setText(weekDay);

                tamil_day.setText("திங்கள்");


            } else if (Calendar.TUESDAY == dayOfWeek) {
                weekDay = "Tuesday";
                tamil_day.setText("செவ்வாய்");
                english_day.setText(weekDay);
            } else if (Calendar.WEDNESDAY == dayOfWeek) {
                weekDay = "Wednesday";
                tamil_day.setText("புதன்");
                english_day.setText(weekDay);

            } else if (Calendar.THURSDAY == dayOfWeek) {
                weekDay = "Thursday";
                tamil_day.setText("வியாழன்");
                english_day.setText(weekDay);
            } else if (Calendar.FRIDAY == dayOfWeek) {
                weekDay = "Friday";
                tamil_day.setText("வெள்ளி");
                english_day.setText(weekDay);

            } else if (Calendar.SATURDAY == dayOfWeek) {
                weekDay = "Saturday";
                tamil_day.setText("சனி");
                english_day.setText(weekDay);
            } else if (Calendar.SUNDAY == dayOfWeek) {
                weekDay = "Sunday";
                tamil_day.setText("ஞாயிறு");
                english_day.setText(weekDay);
            }










            // TextView textView = (TextView) rootView.findViewById(R.id.section_label);
           // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));e





            onc2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    databaseAccess.open();
                    cursor=databaseAccess.getDayReacord(formattedDate);
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()){
                       String val=(cursor.getString(3));

                        panchanganeram.setText(val);
                        l1.setText("ராகு");


                        val=(cursor.getString(5));
                        l3.setText("குளிகை");

                        pan_kulikai.setText(val);

                        val=(cursor.getString(4));
                        l2.setText("எமகண்டம்");

                        pan_aama.setText(val);


                        cursor.moveToNext();
                    }
                    databaseAccess.close();

                    Toast.makeText(getActivity(),"click one",Toast.LENGTH_LONG).show();

                }
            });

            databaseAccess.open();
             cursor= databaseAccess.getDayReacord(formattedDate);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String  val=(cursor.getString(1));
                daysevents.setText(val);
                val=(cursor.getString(2));


                nalaneram.setText(val);
                val=(cursor.getString(6));

                tamil_mn.setText(val);

                val=(cursor.getString(3));
                String spl=val;
                parts = spl.split("-");
                part1= parts[0];
                part2= parts[1];

                prt= part1.split("\\.");
                part3= prt[0];
                part4 = prt[1];
                if (part3.equals(timecom)) {
                    l2.setText("ராகு");

                   pan_kulikai .setText(val);
                }

                val=(cursor.getString(5));
                spl = val;
                parts = spl.split("-");
                part1= parts[0];
                part2= parts[1];

                prt= part1.split("\\.");
                part3= prt[0];
                part4 = prt[1];
                if (part3.equals(timecom)) {
                    l2.setText("குளிகை");

                    pan_kulikai .setText(val);
                }

                val=(cursor.getString(4));
                spl = val;
                parts = spl.split("-");
                part1= parts[0];
                part2= parts[1];

                prt= part1.split("\\.");
                part3= prt[0];
                part4 = prt[1];
                if (part3.equals(timecom)) {
                    l2.setText("எமகண்டம்");

                    pan_kulikai .setText(val);
                }


                val=(cursor.getString(7));
                spl = val;
                parts = spl.split("-");
                part1= parts[0];
                part2= parts[1];

                prt= part1.split("\\.");
                part3= prt[0];
                part4 = prt[1];
                if (part3.equals(timecom)) {

                    nigh_pan_aam.setText(val);
                }



                val=(cursor.getString(8));
                spl = val;
                parts = spl.split("-");
                part1= parts[0];
                part2= parts[1];

                prt= part1.split("\\.");
                part3= prt[0];
                part4 = prt[1];
                if (part3.equals(timecom)) {

                    nigh_pan_aam.setText(val);
                }

                val=(cursor.getString(9));
                spl = val;
                parts = spl.split("-");
                part1= parts[0];
                part2= parts[1];

                prt= part1.split("\\.");
                part3= prt[0];
                part4 = prt[1];
                if (part3.equals(timecom)) {

                    nigh_pan_aam.setText(val);
                }

                val=(cursor.getString(11));
                rasipalan.setText(val);
                cursor.moveToNext();
            }
            databaseAccess.close();



           // rasihet.setText(time);



                    rasihet.setTypeface(faceAkshar);
                    rasihet.setText("இராசிபலன்");












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

