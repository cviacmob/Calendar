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
import com.cviac.calendar.Event_details;
import com.cviac.calendar.R;
import com.cviac.calendar.datamodel.AndroidVersion;
import com.cviac.calendar.datamodel.WonderModel;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


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


    String[] description = {"Andal temple", "Karpaga Vinayagar Temple", "Meenakshi Amman Temple", "Abhishtavaradha Ganapathi Temple",
            "Naramuga Vinayagar Temple", "Ganapatheeswarar Temple", "Khabartheesar Karpaga Nathar Temple", "Eachanari Vinayagar Temple"};
    //String []description;
    int Images[] = {R.mipmap.ei, R.mipmap.eh, R.mipmap.c, R.mipmap.d, R.mipmap.f, R.mipmap.g, R.mipmap.h};
    String eve;
    String eve2;
    String eve1;

    ArrayList<String> Location = new ArrayList<String>();
    ArrayList<String> date = new ArrayList<String>();
    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<String> cost = new ArrayList<String>();
    ArrayList<String> About = new ArrayList<String>();
    ArrayList<String> imageurl = new ArrayList<String>();
    ArrayList<String> time = new ArrayList<String>();
    String cost1;
    String time1;
    String about1;
    String date1;
    String title1;
    String imageurl1;


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




            //holder.coverImageView.setImageResource(list.get(position).getImageResourceId());

            holder.dates.setText(list.get(position).getdate());
            holder.places.setText(list.get(position).getplace());
            Picasso.with(getActivity()).load(list.get(position).getUrl()).resize(120, 60).into(holder.coverImageView);



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


                            Intent eve_in = new Intent(getActivity(), Event_details.class);
                            eve_in.putExtra("events", wm);
                            startActivity(eve_in);



                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

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


        public TextView titleTextView, event, dates, places;
        public ImageView coverImageView;

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

    int i;


    public void initializeList() {
        SQLiteDatabase dp = getActivity().openOrCreateDatabase("EventsDB", getActivity().getBaseContext().MODE_PRIVATE, null);
        dp.execSQL("CREATE TABLE IF NOT EXISTS  Event(dates varchar(15),title varchar(100),cost varchar(50),about varchar(500),location varchar(150),image_uri varchar(200),time varchar(20),organiser varchar(100));");
        //dp.execSQL("insert into Events(dates ,title ,cost ,about ,location ,image_uri )values('27-02-2017','Nebosh courses chennai','299 onwards','Nebosh international general certification course in chennai','Velachery','http://www.modernbuildinginc.com/wp-content/uploads/2015/05/safety_hardhat_1600_clr.png')");
        // dp.execSQL("ALTER TABLE Events ADD Time_event varchar(20)",null);
        dp.execSQL("insert into Event(dates ,title ,cost ,about ,location ,image_uri,time,organiser )values('1-03-2017',' Ekadasi Purappadu','0 ','On February 22nd 2017, on the occasion of Maasi Ekadasi, purappadu for Sri Veeraraghava Perumal took place in the evening around 5.30 pm','Thiruvallur','http://www.tierratravels.com/travelblog/wp-content/uploads/2014/01/Brihadeeswara-Temple-Tamilnadu-10.jpg','9.00','')");
        dp.execSQL("insert into Event(dates ,title ,cost ,about ,location ,image_uri,time,organiser )values('2-03-2017','Ratha Sapthami Utsavam','0','Rathasapthami utsavam was celebrated across many temples. At Thiruvallur Sri Veeraraghava Perumal temple.','Srivilliputhur" +
                "" +
                "','http://media02.hongkiat.com/beautiful-temples-asia/temple-of-heaven.jpg','10.00',' ')");
        Cursor cur = dp.rawQuery("Select * from Event", null);



        if (cur.moveToFirst()) {
            while (cur.isAfterLast() == false) {
                String name = cur.getString(cur.getColumnIndex("location"));
                date1 = cur.getString(cur.getColumnIndex("dates"));
                title1 = cur.getString(cur.getColumnIndex("title"));
                cost1 = cur.getString(cur.getColumnIndex("cost"));
                about1 = cur.getString(cur.getColumnIndex("about"));
                imageurl1 = cur.getString(cur.getColumnIndex("image_uri"));
                time1 = cur.getString(cur.getColumnIndex("time"));

                Location.add(name);
                date.add(date1);
                titles.add(title1);
                cost.add(cost1);
                About.add(about1);
                imageurl.add(imageurl1);
                time.add(time1);
                cur.moveToNext();
            }
        }


        if (cur.moveToFirst()) {
            eve = cur.getString(1);
            eve1 = cur.getString(4);
            eve2 = cur.getString(0);
            cost1 = cur.getString(2);
            time1 = cur.getString(6);
            about1 = cur.getString(3);
            cur.moveToNext();


        }


        // insert into Events(dates ,title ,cost ,about ,location ,image_uri )values('27-02-2017','Nebosh courses chennai','299 onwards','Nebosh international general certification course in chennai','Velachery','http://www.modernbuildinginc.com/wp-content/uploads/2015/05/safety_hardhat_1600_clr.png');


        String Wonders[] = {eve, "Plc programming", "Great Wall of China", "Machu Picchu", "Petra", "Taj Mahal", "Colosseum"};
        listitems.clear();


        getActivity().setTitle("Events");


        for (int i = 0; i < 2; i++) {

            WonderModel item = new WonderModel();
            AndroidVersion androidVersion = new AndroidVersion();
            item.setCardName(Wonders[i]);
            item.setplace(Location.get(i));
            item.setdate(date.get(i));
            item.setCost(cost.get(i));
            item.setAbout(About.get(i));
            item.setTime(time.get(i));
            //item.setandroid_image_urls(android_image_url[i]);
            // item.setAndroid_image_url(android_image_urls[i]);
            //androidVersion.setAndroid_image_url(android_image_urls[i]);

            item.setDescription(titles.get(i));
            item.setImageResourceId(Images[i]);
            item.setUrl(imageurl.get(i));
            item.setIsfav(0);
            item.setIsturned(0);
            listitems.add(item);

        }


    }
}
