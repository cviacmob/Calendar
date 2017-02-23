package com.cviac.calendar.fragments;

import android.content.ContentResolver;
import android.content.Intent;
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

import com.cviac.calendar.R;
import com.cviac.calendar.datamodel.WonderModel;
import com.cviac.calendar.datamodel.WonderModel2;

import java.util.ArrayList;


public class CardFragmentTab2 extends Fragment  {

    ArrayList<WonderModel2> listitems = new ArrayList<>();
    RecyclerView MyRecyclerView;
    int count;
    String Wonders2[] = {"Chichen Itza","Christ the Redeemer","Great Wall of China","Machu Picchu","Petra","Taj Mahal","Colosseum"};
    String []description={"Sport is generally physical activity","Sport is generally physical activity",
    "Sport is generally physical activity","The Story of the World's Greatest Batsman","World's Greatest Batsman"};
    int  Images[] = {R.mipmap.sa,R.mipmap.sb,R.mipmap.sc,R.mipmap.sd,R.mipmap.sf,R.mipmap.sg};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeList();
        getActivity().setTitle("Events");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_card2, container, false);
        MyRecyclerView = (RecyclerView) view.findViewById(R.id.cardView2);
        final TextView text = (TextView) view.findViewById(R.id.re_text2);
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
                String text=rv.toString();


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
        private ArrayList<WonderModel2> list;
        int pos;

        public MyAdapter(ArrayList<WonderModel2> Data) {
            list = Data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycle_items2, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {

          //  holder.titleTextView.setText(list.get(position).getCardName());


            holder.coverImageView.setImageResource(list.get(position).getImageResourceId2());
            holder.coverImageView.setTag(list.get(position).getImageResourceId2());
            holder.likeImageView.setTag(R.drawable.ic_like);
            holder.event.setText(list.get(position).getDescription2());
                int a=holder.getAdapterPosition();






            MyRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                @Override
                public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                    count=e.getPointerCount();
                    //Toast.makeText(getActivity(),"hello",Toast.LENGTH_LONG).show();



                    return false;
                }

                @Override
                public void onTouchEvent(RecyclerView rv, MotionEvent e) {

                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                }
            });


        }

       @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private String mItem;

        public TextView titleTextView,event;
        public ImageView coverImageView;
        public ImageView likeImageView;
        public ImageView shareImageView;

        public MyViewHolder(View v) {
            super(v);
            //titleTextView = (TextView) v.findViewById(R.id.titleTextView);
            coverImageView = (ImageView) v.findViewById(R.id.coverImageView);
            likeImageView = (ImageView) v.findViewById(R.id.fava);
            shareImageView = (ImageView) v.findViewById(R.id.shareImageView);
            event=(TextView)v.findViewById(R.id.eve_name);
            coverImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* Intent in=new Intent(getActivity(), Event.class);
                    startActivity(in);*/




                }
            });

            likeImageView.setOnClickListener(new View.OnClickListener() {
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
            });



            shareImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {






                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                            "://" + getResources().getResourcePackageName(coverImageView.getId())
                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int)coverImageView.getTag()));


                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
                    shareIntent.setType("image/jpeg");
                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));



                }
            });



        }


    }

    public void initializeList() {
        listitems.clear();

        for(int i =0;i<5;i++){


            WonderModel2 item = new WonderModel2();
            item.setCardName2(Wonders2[i]);
            item.setDescription2(description[i]);
            item.setImageResourceId2(Images[i]);
            item.setIsfav2(0);
            item.setIsturned2(0);
            listitems.add(item);

        }




    }
}
