package com.cviac.calendar.fragments;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cviac.calendar.Event;
import com.cviac.calendar.R;
import com.cviac.calendar.datamodel.AndroidVersion;
import com.cviac.calendar.datamodel.WonderModel;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public class CardFragment extends Fragment {

    ArrayList<WonderModel> listitems = new ArrayList<>();
    RecyclerView MyRecyclerView;
    Context context;
    int count;
    private final String android_image_urls[] = {
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };
    String[] cost;


    String[] description = {"Andal temple", "Karpaga Vinayagar Temple", "Meenakshi Amman Temple", "Abhishtavaradha Ganapathi Temple",
            "Naramuga Vinayagar Temple", "Ganapatheeswarar Temple", "Khabartheesar Karpaga Nathar Temple", "Eachanari Vinayagar Temple"};
    //String []description;
    int Images[] = {R.mipmap.ei, R.mipmap.eh, R.mipmap.c, R.mipmap.d, R.mipmap.f, R.mipmap.g, R.mipmap.h};
    String eve;
    String eve2;
    String eve1;
    String eve3;
    String eve4;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeList();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_card, container, false);
        MyRecyclerView = (RecyclerView) view.findViewById(R.id.cardView);
        /// final TextView text = (TextView) view.findViewById(R.id.re_text);
        MyRecyclerView.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        if (listitems.size() > 0 & MyRecyclerView != null) {
            MyRecyclerView.setAdapter(new MyAdapter(listitems));
        }
        MyRecyclerView.setLayoutManager(MyLayoutManager);


        MyRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                String text = rv.toString();


                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private ArrayList<WonderModel> list;
        int pos;

        public MyAdapter(ArrayList<WonderModel> Data) {
            list = Data;
        }

        private ArrayList<AndroidVersion> android_versions;
        private Context context;

        public MyAdapter(Context context, ArrayList<AndroidVersion> android_versions) {
            this.context = context;
            this.android_versions = android_versions;

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycle_items, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {

            //  holder.titleTextView.setText(list.get(position).getCardName());

            //Toast.makeText(getActivity(),list.get(position).getCardName(),Toast.LENGTH_LONG).show();


            holder.coverImageView.setImageResource(list.get(position).getImageResourceId());

            holder.dates.setText(list.get(position).getdate());
            holder.places.setText(list.get(position).getplace());
            //Picasso.with(context).load(android_versions.get(position).getAndroid_image_url()).resize(120, 60).into(holder.coverImageView);
            // Picasso.with(context).load(android_versions.get(i).getAndroid_image_url()).resize(120, 60).into( holder.coverImageView);
            // Picasso.with(context).load(list.get(position).getAndroid_image_url()).resize(120, 60).into( holder.coverImageView);
            //Picasso.with(context).load(list.get(position).getAndroid_image_url()).resize(0b1111000, 60).into(holder.coverImageView);


            holder.coverImageView.setTag(list.get(position).getImageResourceId());
            //  holder.likeImageView.setTag(R.drawable.ic_like);
            holder.event.setText(list.get(position).getDescription());
            int a = holder.getAdapterPosition();


            MyRecyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener1(context, MyRecyclerView, new RecyclerItemClickListener1.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            // do whatever
                            /*int itemPosition = MyRecyclerView.indexOfChild(view);*/

                            WonderModel wm = listitems.get(position);


                            Intent eve_in = new Intent(getActivity(), Event.class);
                            eve_in.putExtra("events", wm);
                            startActivity(eve_in);

                            //Toast.makeText(getActivity(),itemPosition,Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            // do whatever
                        }
                    })
            );


        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private String mItem;

        public TextView titleTextView, event, dates, places;
        public ImageView coverImageView;
        public ImageView likeImageView;
        public ImageView shareImageView;

        public MyViewHolder(View v) {
            super(v);
            //titleTextView = (TextView) v.findViewById(R.id.titleTextView);
            coverImageView = (ImageView) v.findViewById(R.id.coverImageView);

            shareImageView = (ImageView) v.findViewById(R.id.shareImageView);
            dates = (TextView) v.findViewById(R.id.date_venue);
            places = (TextView) v.findViewById(R.id.venue);


            event = (TextView) v.findViewById(R.id.eve_name);
            coverImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* Intent in=new Intent(getActivity(), Event.class);
                    startActivity(in);*/


                }
            });

        /*    likeImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    int id = (int)likeImageView.getTag();
                        if( id == R.drawable.ic_like){

                            likeImageView.setTag(R.drawable.ic_liked);
                            likeImageView.setImageResource(R.drawable.ic_liked);

                            //Toast.makeText(getActivity(),titleTextView.getText()+" added to favourites", Toast.LENGTH_SHORT).show();

                        }else{

                            likeImageView.setTag(R.drawable.ic_like);
                            likeImageView.setImageResource(R.drawable.ic_like);
                          //  Toast.makeText(getActivity(),titleTextView.getText()+" removed from favourites", Toast.LENGTH_SHORT).show();


                        }

                }
            });*/


            shareImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                            "://" + getResources().getResourcePackageName(coverImageView.getId())
                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int) coverImageView.getTag()));


                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                    shareIntent.setType("image/jpeg");
                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));


                }
            });


        }


    }

    String[] des;
    String[] place;
    String[] date;
    String[] about;

    String[] time;
    String cost1;

    String cost2;
    String cost3;
    String time1;
    String time2;
    String time3;
    String about1;
    String about2;
    String about3;


    String value1;
    String value2;
    String value3;

    String[] title;


    public void initializeList() {
        SQLiteDatabase dp = getActivity().openOrCreateDatabase("EventsDB", getActivity().getBaseContext().MODE_PRIVATE, null);
        dp.execSQL("CREATE TABLE IF NOT EXISTS  Event(dates varchar(15),title varchar(100),cost varchar(50),about varchar(200),location varchar(100),image_uri varchar(200),time varchar(20));");
        //dp.execSQL("insert into Events(dates ,title ,cost ,about ,location ,image_uri )values('27-02-2017','Nebosh courses chennai','299 onwards','Nebosh international general certification course in chennai','Velachery','http://www.modernbuildinginc.com/wp-content/uploads/2015/05/safety_hardhat_1600_clr.png')");
        // dp.execSQL("ALTER TABLE Events ADD Time_event varchar(20)",null);
        dp.execSQL("insert into Event(dates ,title ,cost ,about ,location ,image_uri,time )values('27-02-2017','Nebosh courses chennai','299 onwards','Nebosh international general certification course in chennai','Velachery','http://www.modernbuildinginc.com/wp-content/uploads/2015/05/safety_hardhat_1600_clr.png','9.00')");
        dp.execSQL("insert into Event(dates ,title ,cost ,about ,location ,image_uri,time )values('28-02-2017','java course chennai','299 onwards','Tirch madurai','Velachery','http://www.modernbuildinginc.com/wp-content/uploads/2015/05/safety_hardhat_1600_clr.png','9.00')");
        Cursor cur = dp.rawQuery("Select * from Event where dates='27-02-2017'", null);


        if (cur.moveToFirst()) {
            eve = cur.getString(1);
            eve1 = cur.getString(4);
            eve2 = cur.getString(0);
            cost1=cur.getString(2);
            time1=cur.getString(6);
            about1=cur.getString(3);

        }
        title = new String[]{eve, "plc programming"};
        cost=new String[]{cost1};
        about=new String[]{about1};
        time=new String[]{time1};


        // insert into Events(dates ,title ,cost ,about ,location ,image_uri )values('27-02-2017','Nebosh courses chennai','299 onwards','Nebosh international general certification course in chennai','Velachery','http://www.modernbuildinginc.com/wp-content/uploads/2015/05/safety_hardhat_1600_clr.png');


        String Wonders[] = {eve, "Plc programming", "Great Wall of China", "Machu Picchu", "Petra", "Taj Mahal", "Colosseum"};
        listitems.clear();
     /*   EventAcces eventAcces= EventAcces.getInstance2(getActivity());
        eventAcces.open();
        Cursor cursor=eventAcces.getDayEvent("25-02-2017");

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            eve=(cursor.getString(1));


            // description= new String[]{eve};

            ar.add(eve);





            cursor.moveToNext();
        }
        eventAcces.close();*/

        getActivity().setTitle("Events");


        des = new String[]{eve, value1};
        place = new String[]{eve1, value2};
        date = new String[]{eve2, value3};


        for (int i = 0; i < 1; i++) {

            WonderModel item = new WonderModel();
            AndroidVersion androidVersion = new AndroidVersion();
            item.setCardName(Wonders[i]);
            item.setplace(place[i]);
            item.setdate(date[i]);
            item.setCost(cost[i]);
            item.setAbout(about[i]);
            item.setTime(time[i]);
            //item.setandroid_image_urls(android_image_url[i]);
            // item.setAndroid_image_url(android_image_urls[i]);
            //androidVersion.setAndroid_image_url(android_image_urls[i]);

            item.setDescription(title[i]);
            item.setImageResourceId(Images[i]);
            item.setIsfav(0);
            item.setIsturned(0);
            listitems.add(item);

        }


    }
}
