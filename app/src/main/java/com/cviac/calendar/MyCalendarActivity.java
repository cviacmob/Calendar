package com.cviac.calendar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cviac.calendar.datamodel.MyDataHolder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static android.R.attr.text;
import static android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE;

@TargetApi(3)
public class MyCalendarActivity extends Activity implements OnClickListener {
	private static final String tag = "MyCalendarActivity";




	private TextView currentMonth;
	//private Button selectedDayMonthYearButton,addeve;
	private ImageView prevMonth;
	private ImageView nextMonth;
	private GridView calendarView;
	private GridCellAdapter adapter;
	private Calendar _calendar;
	@SuppressLint("NewApi")
	private int month, year, month1,year1;
	@SuppressWarnings("unused")
	@SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
	private final DateFormat dateFormatter = new DateFormat();
	private static final String dateTemplate = "MMMM yyyy";

	private String getdataes;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_calendar_view);






		_calendar = Calendar.getInstance(Locale.getDefault());
		month = _calendar.get(Calendar.MONTH) + 1;
		year = _calendar.get(Calendar.YEAR);
		month1=_calendar.get(Calendar.MONTH) + 1;
		year1= _calendar.get(Calendar.YEAR);
		Log.d(tag, "Calendar Instance:= " + "Month: " + month + " " + "Year: "
				+ year);

		//selectedDayMonthYearButton = (Button) this
				//.findViewById(R.id.selectedDayMonthYear);
		//selectedDayMonthYearButton.setText("Selected: ");

		prevMonth = (ImageView) this.findViewById(R.id.prevMonth);
		prevMonth.setOnClickListener(this);

		currentMonth = (TextView) this.findViewById(R.id.currentMonth);
		currentMonth.setText(DateFormat.format(dateTemplate,
				_calendar.getTime()));

		nextMonth = (ImageView) this.findViewById(R.id.nextMonth);
		nextMonth.setOnClickListener(this);

		calendarView = (GridView) this.findViewById(R.id.calendar);

		// Initialised
		adapter = new GridCellAdapter(getApplicationContext(),
				R.id.calendar_day_gridcell, month, year,month1,year1);
		adapter.notifyDataSetChanged();
		calendarView.setAdapter(adapter);
		calendarView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(MyCalendarActivity.this, position + "#Selected", Toast.LENGTH_LONG).show();

			}
		});


	}

	/**
	 * 
	 * @param month
	 * @param year
	 */
	private void setGridCellAdapterToDate(int month, int year) {
		adapter = new GridCellAdapter(getApplicationContext(),
				R.id.calendar_day_gridcell, month, R.id.calendar_day_gridcell, month, year);
		_calendar.set(year, month - 1, _calendar.get(Calendar.DAY_OF_MONTH));
		currentMonth.setText(DateFormat.format(dateTemplate,
				_calendar.getTime()));
		adapter.notifyDataSetChanged();
		calendarView.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		if (v == prevMonth) {
			if (month <= 1) {
				month = 12;
				year--;
			} else {
				month--;
			}
			Log.d(tag, "Setting Prev Month in GridCellAdapter: " + "Month: "
					+ month + " Year: " + year);
			setGridCellAdapterToDate(month, year);
		}
		if (v == nextMonth) {
			if (month > 11) {
				month = 1;
				year++;
			} else {
				month++;
			}
			Log.d(tag, "Setting Next Month in GridCellAdapter: " + "Month: "
					+ month + " Year: " + year);
			setGridCellAdapterToDate(month, year);
		}

	}

	@Override
	public void onDestroy() {
		Log.d(tag, "Destroying View ...");
		super.onDestroy();
	}

	// Inner Class

	public class GridCellAdapter extends BaseAdapter implements View.OnClickListener {
		private static final String tag = "GridCellAdapter";

		private final Context _context;

		private final List<String> list;
		private Daily_calendar INSTANCE;


		private final List<String> tamil;
		private static final int DAY_OFFSET = 1;
		private final String[] weekdays = new String[]{"Sun", "Mon", "Tue",
				"Wed", "Thu", "Fri", "Sat"};
		private final String[] months = {"January", "February", "March",
				"April", "May", "June", "July", "August", "September",
				"October", "November", "December"};
		private final int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30,
				31, 30, 31};
		private int daysInMonth;
		private int monthstart;
		private int monthend;
		private int currentDayOfMonth;
		private int currentWeekDay;
		private Button gridcell;
		private TextView num_events_per_day;
		private final HashMap<String, Integer> eventsPerMonthMap;
		private final SimpleDateFormat dateFormatter = new SimpleDateFormat(
				"dd-MMM-yyyy");
		private String data;
		String s1;
		String s2;
		String s5;


		// Days in Current Month
		public GridCellAdapter(Context context, int calendar_day_gridcell, int i, int textViewResourceId,
							   int month, int year) {
			super();
			this._context = context;
			this.list = new ArrayList<String>();
			this.tamil = new ArrayList<String>();
			Log.d(tag, "==> Passed in Date FOR Month: " + month + " "
					+ "Year: " + year);
			Calendar calendar = Calendar.getInstance();
			setCurrentDayOfMonth(calendar.get(Calendar.DAY_OF_MONTH));
			setCurrentWeekDay(calendar.get(Calendar.DAY_OF_WEEK));
			Log.d(tag, "New Calendar:= " + calendar.getTime().toString());
			Log.d(tag, "CurrentDayOfWeek :" + getCurrentWeekDay());
			Log.d(tag, "CurrentDayOfMonth :" + getCurrentDayOfMonth());

			// Print Month
			printMonth(month, year);
			printtamil(month, year);

			// Find Number of Events
			eventsPerMonthMap = findNumberOfEventsPerMonth(year, month);
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
						+ prevYear + String.valueOf(j));
			}

			// Current Month Days
			for (int j = 1; j <= daysInMonth; j++) {
				Log.d(currentMonthName, String.valueOf(j) + " " + getMonthAsString(currentMonth) + " " + yy);
				if (j == getCurrentDayOfMonth()) {
					tamil.add(String.valueOf(j) + "-BLUE" + "-" + getMonthAsString(currentMonth) + "-" + yy);


				} else {
					tamil.add(String.valueOf(j) + "-WHITE" + "-" + getMonthAsString(currentMonth) + "-" + yy + String.valueOf(j));


				}
			}

			// Leading Month days
			for (int j = 0; j < list.size() % 7; j++) {
				Log.d(tag, "NEXT MONTH:= " + getMonthAsString(nextMonth));
				list.add(String.valueOf(j + 1) + "-GREY" + "-"
						+ getMonthAsString(nextMonth) + "-" + nextYear + String.valueOf(j));

			}

		}


		private String getMonthAsString(int i) {
			return months[i];
		}

		private String getWeekDayAsString(int i) {
			return weekdays[i];
		}

		private int getNumberOfDaysOfMonth(int i) {
			return daysOfMonth[i];
		}

		public String getItem(int position) {
			return list.get(position);
		}

		@Override
		public int getCount() {
			return tamil.size();
		}

		/**
		 * Prints Month
		 *
		 * @param mm
		 * @param yy
		 */
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
				list.add(String.valueOf((daysInPrevMonth - trailingSpaces + DAY_OFFSET) + i) + "-WHITE" + "-"
						+ getMonthAsString(prevMonth)
						+ "-"
						+ prevYear);
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
				if (i == getCurrentDayOfMonth()) {
					list.add(String.valueOf(i) + "-BLUE" + "-" + getMonthAsString(currentMonth) + "-" + yy);
				} else {
					int ab = i;
					int ac = 0;
					int ad = bb;


					if (ab > ad) {

						ac = ab - ad;
					} else {
						ac = ab;

					}
					list.add(String.valueOf(ac) + "-GREY" + "-" + getMonthAsString(currentMonth) + "-" + yy + String.valueOf(i));


				}
			}


			// Leading Month days
			for (int i = 0; i < list.size() % 7; i++) {
				Log.d(tag, "NEXT MONTH:= " + getMonthAsString(nextMonth));
				list.add(String.valueOf(i + 1) + "-GREY" + "-" + getMonthAsString(nextMonth) + "-" + nextYear);


			}
		}

		/**
		 * NOTE: YOU NEED TO IMPLEMENT THIS PART Given the YEAR, MONTH, retrieve
		 * ALL entries from a SQLite database for that month. Iterate over the
		 * List of All entries, and get the dateCreated, which is converted into
		 * day.
		 *
		 * @param year
		 * @param month
		 * @return
		 */
		private HashMap<String, Integer> findNumberOfEventsPerMonth(int year,
																	int month) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();

			return map;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			if (row == null) {
				LayoutInflater inflater = (LayoutInflater) _context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				row = inflater.inflate(R.layout.screen_gridcell, parent, false);
			}

			// Get a reference to the Day gridcell
			gridcell = (Button) row.findViewById(R.id.calendar_day_gridcell);
			//Button scon=(Button)row.findViewById(R.id.second);

			gridcell.setOnClickListener(this);

			// ACCOUNT FOR SPACING

			Log.d(tag, "Current Day: " + getCurrentDayOfMonth());
			String[] day_color = list.get(position).split("-");
			String theday = day_color[0];

			String themonth = day_color[2];

			String theyear = day_color[3];

			String[] tom_colour = tamil.get(position).split("-");

			String tomorrow = tom_colour[0];
			String tom_month = tom_colour[2];
			String tom_year = tom_colour[3];
			num_events_per_day = (TextView) row
					.findViewById(R.id.num_events_per_day);


			if ((!eventsPerMonthMap.isEmpty()) && (eventsPerMonthMap != null)) {
				if (eventsPerMonthMap.containsKey(theday)) {

					Integer numEvents = (Integer) eventsPerMonthMap.get(theday);

				}
			}

			String text1 = day_color[0];
			String text2 = tom_colour[0];
			Spannable word = new SpannableString(text2);
			word.setSpan(new ForegroundColorSpan(Color.parseColor("#FF00FF")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


			//Spannable word1 = new SpannableString(text2);
			//word1.setSpan(new ForegroundColorSpan(Color.YELLOW), 0, word1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


			SpannableString span1 = new SpannableString(text1);
			span1.setSpan(new AbsoluteSizeSpan(40), 0, text1.length(), SPAN_INCLUSIVE_INCLUSIVE);
			//span1.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 6, 0);

			SpannableString span2 = new SpannableString(word);
			span2.setSpan(new AbsoluteSizeSpan(20), 0, word.length(), SPAN_INCLUSIVE_INCLUSIVE);

// let's put both spans together with a separator and all
			CharSequence finalText = TextUtils.concat(span2, " ", span1);

			// Set the Day GridCell
			gridcell.setText(finalText);
			//scon.setText(tomorrow);

			// set color
			//TextView tv= (TextView) findViewById(R.id.textview);

			num_events_per_day.setText(tomorrow);


			gridcell.setTag(tomorrow + "-" + tom_month + "-" + tom_year);
			Log.d(tag, "Setting GridCell " + tomorrow + "-" + tom_month + "-"
					+ tom_year);

			if (day_color[1].equals("GREY")) {
				gridcell.setTextColor(Color.parseColor("#155ED4"));

			}
			if (day_color[1].equals("WHITE")) {
				gridcell.setTextColor(Color.parseColor("#ffffff"));

			}
		if (tom_colour[1].equals("lavendar")){
			gridcell.setTextColor(Color.parseColor("#E6E6FA"));
		}
			if (tom_colour[1].equals("BLUE")) {
				gridcell.setTextColor(Color.parseColor("#D42F15"));
			}
			return row;
		}

		public String date_month_year;


		public void setData(String data) {
			this.data = data;
		}

		public String getData() {
			return data;
		}

		@Override
		public void onClick(View view) {
			date_month_year = (String) view.getTag();
			String [] dsp=date_month_year.split("-");
			 s1=dsp[0];
			 s2=dsp[1];
			if (s2 == "January") {
				s5="01";
			}

			if (s2 == "February") {
				s5="02";

			}
			if (s2 .equals("March")) {
				s5="03";
			}
			if (s2.equals("April")) {
				s5="04";

			}
			if (s2 .equals("May") ) {
				s2="05";

			}
			if (s2 .equals("June") ) {
				s5="06";

			}
			if (s2 .equals("July") ) {
				s5="07";

			}
			if (s2 .equals("August") ) {
				s5="08";

			}

			if (s2 .equals("September")) {
				s5="09";

			}
			if (s2 .equals("October")) {
				s2="10";

			}
			if (s2 .equals("November")) {
				s5="11";

			}
			if (s2 == "December") {
				s5="12";

			}
			String s3=dsp[2];
			String s4=s3.substring(0,4);
			String date=s1+"-"+s5+"-"+s4;

			Toast.makeText(getApplication(),date_month_year,Toast.LENGTH_LONG).show();
		/*	Intent daily=new Intent(getApplication(),Daily_calendar.class);
					daily.putExtra("dats",date);
			startActivity(daily);*/




			/*String tomorrow=tom_colour[0];
			String tom_month=tom_colour[2];
			String tom_year=tom_colour[3];*/
			///String date_month_year =text1;

			//
			//selectedDayMonthYearButton.setText("Selected: " + date_month_year);
			/*Intent in=new Intent(MyCalendarActivity.this,Daily_calendar.class);
			startAcitvity(in);*/









			Log.e("Selected date", date_month_year);
			try {
				Date parsedDate = dateFormatter.parse(date_month_year);
				Log.d(tag, "Parsed Date: " + parsedDate.toString());

			} catch (ParseException e) {
				e.printStackTrace();
			}

		}



		public int getCurrentDayOfMonth() {
			return currentDayOfMonth;
		}

		private void setCurrentDayOfMonth(int currentDayOfMonth) {
			this.currentDayOfMonth = currentDayOfMonth;
		}

		public void setCurrentWeekDay(int currentWeekDay) {
			this.currentWeekDay = currentWeekDay;
		}

		public int getCurrentWeekDay() {
			return currentWeekDay;
		}


	}



}
