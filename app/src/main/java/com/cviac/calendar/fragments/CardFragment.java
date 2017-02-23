package com.cviac.calendar.fragments;

import android.content.ContentResolver;
import android.content.Context;
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
import android.widget.Toast;

import com.cviac.calendar.Event;
import com.cviac.calendar.R;
import com.cviac.calendar.datamodel.WonderModel;

import java.util.ArrayList;


public class CardFragment extends Fragment  {

    ArrayList<WonderModel> listitems = new ArrayList<>();
    RecyclerView MyRecyclerView;
    Context context;
    int count;
    String Wonders[] = {"Chichen Itza","Christ the Redeemer","Great Wall of China","Machu Picchu","Petra","Taj Mahal","Colosseum"};
    String []description={"Andal temple","Karpaga Vinayagar Temple", "Meenakshi Amman Temple","Abhishtavaradha Ganapathi Temple",
    "Naramuga Vinayagar Temple","Ganapatheeswarar Temple","Khabartheesar Karpaga Nathar Temple","Eachanari Vinayagar Temple"};
    int  Images[] = {R.mipmap.andal,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.f,R.mipmap.g,R.mipmap.h};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeList();
        getActivity().setTitle("Events");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_card, container, false);
        MyRecyclerView = (RecyclerView) view.findViewById(R.id.cardView);
        final TextView text = (TextView) view.findViewById(R.id.re_text);
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
        private ArrayList<WonderModel> list;
        int pos;

        public MyAdapter(ArrayList<WonderModel> Data) {
            list = Data;
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


            holder.coverImageView.setImageResource(list.get(position).getImageResourceId());

            holder.coverImageView.setTag(list.get(position).getImageResourceId());
            holder.likeImageView.setTag(R.drawable.ic_like);
            holder.event.setText(list.get(position).getDescription());
                int a=holder.getAdapterPosition();





/*
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
            });*/

            MyRecyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener1(context, MyRecyclerView ,new RecyclerItemClickListener1.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {
                            // do whatever
                            int itemPosition = MyRecyclerView.indexOfChild(view);
                            Toast.makeText(getActivity(),"hhhh"+itemPosition,Toast.LENGTH_LONG).show();

                        }

                        @Override public void onLongItemClick(View view, int position) {
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

        for(int i =0;i<7;i++){

            WonderModel item = new WonderModel();
            item.setCardName(Wonders[i]);
            item.setDescription(description[i]);
            item.setImageResourceId(Images[i]);
            item.setIsfav(0);
            item.setIsturned(0);
            listitems.add(item);

        }




    }
}
