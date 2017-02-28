package com.cviac.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {
    TextView moreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView moreView=(TextView)findViewById(R.id.detail_about) ;
        String moredet=getIntent().getStringExtra("det");

        setTitle(getIntent().getStringExtra("action"));

        moreView.setText(moredet);

    }
}
