package com.cviac.calendar;

/**
 * Created by cviac on 2/8/2017.
 */
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

public class CustomGrid extends BaseAdapter implements View.OnClickListener {
    private static final String tag = "GridCellAdapter";
    private final Context _context;

    private final List<String> list;
    private final List<String>tamil;
    List<String>er;

    private static final int DAY_OFFSET = 1;
    private final String[] weekdays = new String[] { "Sun", "Mon", "Tue",
            "Wed", "Thu", "Fri", "Sat" };
    private final String[] months = { "January", "February", "March",
            "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };

    private final int[] daysOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30,
            31, 30, 31 };

    private int daysInMonth;
    private String[] tamilmonth={"மார்கழி","தை","மாசி","பங்குனி","சித்திரை","வைகாசி","ஆனி","ஆடி","ஆவணி","புரட்டாசி","ஐப்பசி","கார்த்திகை"};
    private final int [ ] tamildays={30,29,30,30,31,31,32,31,31,31,30,29};

    private int currentDayOfMonth;
    private int currentWeekDay;
    private Button gridcell;
    private TextView num_events_per_day;
    private final HashMap<String, Integer> eventsPerMonthMap;
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat(
            "dd-MMM-yyyy");

    public CustomGrid(Context c, int month, int year, int month1, int i) {

        this.tamil=new ArrayList<String>();
        this.list = new ArrayList<String>();
        this._context = c;
        // this.Imageid = Imageid;
        // this.web = web;
        printMonth(month1, i);
        printtamil(month,year);




        eventsPerMonthMap = findNumberOfEventsPerMonth(month1, i);

    }



    private void printtamil(int mm, int yy) {
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
        for (int j = 0; j < trailingSpaces; j++) {
            Log.d(tag,
                    "PREV MONTH:= "
                            + prevMonth
                            + " => "
                            + getMonthAsString(prevMonth)
                            + " "
                            + String.valueOf((daysInPrevMonth
                            - trailingSpaces + DAY_OFFSET)
                            + j));
            tamil.add(String.valueOf((daysInPrevMonth - trailingSpaces + DAY_OFFSET) + j) + "-GREY" + "-"
                    + getMonthAsString(prevMonth)
                    + "-"
                    + prevYear+ String.valueOf(j));
        }

        // Current Month Days
        for (int j = 1; j <= daysInMonth; j++) {
            Log.d(currentMonthName, String.valueOf(j) + " " + getMonthAsString(currentMonth) + " " + yy);
            if (j == getCurrentDayOfMonth()) {
               // int ag=17;
                //j=j+ag;

                tamil.add(String.valueOf(j) + "-BLUE" + "-"
                        + getMonthAsString(currentMonth) + "-" + yy + String.valueOf(j));

            } else {
                tamil.add(String.valueOf(j) + "-WHITE" + "-" + getMonthAsString(currentMonth) + "-" + yy + String.valueOf(j));


            }
        }

        // Leading Month days
        for (int j = 0; j < list.size() % 7; j++) {
            Log.d(tag, "NEXT MONTH:= " + getMonthAsString(nextMonth));
            list.add(String.valueOf(j + 1) + "-GREY" + "-"
                    + getMonthAsString(nextMonth) + "-" + nextYear+String.valueOf(j));

        }

    }


    private HashMap<String,Integer> findNumberOfEventsPerMonth(int year, int month) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        return map;
    }

    private void printMonth(int mm, int yy) {
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
            list.add(String.valueOf((daysInPrevMonth - trailingSpaces + DAY_OFFSET) + i) + "-GREY" + "-"
                    + getMonthAsString(prevMonth)
                    + "-"
                    + prevYear+ String.valueOf(i));
        }

        // Current Month Days
        for (int i = 18; i <= daysInMonth+18; i++) {
            Log.d(currentMonthName, String.valueOf(i) + " " + getMonthAsString(currentMonth) + " " + yy);
            if (i == getCurrentDayOfMonth()) {
                if(i<daysInMonth){

                  //  list.add(String.valueOf(i) + "-BLUE" + "-"
                           // + getMonthAsString(currentMonth) + "-" + yy + String.valueOf(i));

                }


            } else {
                int ab=i;
                int ac=0;
                int ad=0;

                if (ab>30){

                   ac=ab-30;
               }
                else {
                    ac=ab;
                }
                list.add(String.valueOf(ac) + "-WHITE" + "-" + getMonthAsString(currentMonth) + "-" + yy + String.valueOf(i));




            }
        }

        // Leading Month days
        for (int i = 0; i < list.size() % 7; i++) {
            Log.d(tag, "NEXT MONTH:= " + getMonthAsString(nextMonth));
            list.add(String.valueOf(i + 1) + "-GREY" + "-"
                    + getMonthAsString(nextMonth) + "-" + nextYear+String.valueOf(i));

        }
    }

    private int getCurrentDayOfMonth() {
        return currentDayOfMonth;
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


    @Override
    public int getCount( ) {
        // TODO Auto-generated method stub
        return tamil.size();

    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View row;
        LayoutInflater inflater = (LayoutInflater) _context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        row = inflater.inflate(R.layout.screen_gridcell, parent, false);


            // Get a reference to the Day gridcell
        gridcell = (Button) row.findViewById(R.id.calendar_day_gridcell);


        gridcell.setOnClickListener(this);


        // ACCOUNT FOR SPACING

        Log.d(tag, "Current Day: " + getCurrentDayOfMonth());
        String[] day_color = list.get(position).split("-");
        //String demo=day_color[6];
        String theday = day_color[0];
        String themonth = day_color[2];
        String theyear = day_color[3];

       String[]tom_colour=tamil.get(position).split("-");

        String tomorrow=tom_colour[0];
        String tom_month=tom_colour[2];
        String tom_year=tom_colour[3];
        num_events_per_day = (TextView) row
                .findViewById(R.id.num_events_per_day);

        if ((!eventsPerMonthMap.isEmpty()) && (eventsPerMonthMap != null)) {
            if (eventsPerMonthMap.containsKey(theday)) {

                Integer numEvents = (Integer) eventsPerMonthMap.get(theday);

            }
        }

        // Set the Day GridCell

            gridcell.setText(theday+"  "+tomorrow);
        num_events_per_day.setText(tomorrow);


        gridcell.setTag(theday + "-" + themonth + "-" + theyear);
        Log.d(tag, "Setting GridCell " + theday + "-" + themonth + "-"
                + theyear);

        if (day_color[1].equals("GREY")) {
            gridcell.setTextColor(Color.parseColor("#808080"));

        }
        if (day_color[1].equals("WHITE")) {
            gridcell.setTextColor(Color.parseColor("#ffffff"));

        }
        if (day_color[1].equals("BLUE")) {
            gridcell.setTextColor(Color.parseColor("#00BFFF"));
        }

        return row;
    }

    @Override
    public void onClick(View v) {

    }
}
