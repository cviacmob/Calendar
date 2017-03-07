package com.cviac.calendar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Panchaingam_chat extends AppCompatActivity {

    TextView bo1,bo2,bo3,bo4,bo5,bo6,bo7,bo8,bo9,bo10,bo11,bo12,bo13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bo1=(TextView) findViewById(R.id.aaa);
        bo2=(TextView) findViewById(R.id.bbb);
        bo3=(TextView) findViewById(R.id.ccc);
        bo4=(TextView) findViewById(R.id.daa);
        bo5=(TextView) findViewById(R.id.ddd);
        bo6=(TextView) findViewById(R.id.eee);
        bo7=(TextView) findViewById(R.id.fff);
        bo8=(TextView) findViewById(R.id.ggg);
        bo9=(TextView) findViewById(R.id.hhh);
        bo10=(TextView) findViewById(R.id.jjj);
        bo11=(TextView) findViewById(R.id.kkk);
        bo12=(TextView) findViewById(R.id.lll);
        bo13=(TextView)findViewById(R.id.t13);

        bo1.setText(this.getIntent().getStringExtra("bo1"));
        bo2.setText(this.getIntent().getStringExtra("bo2"));
        bo3.setText(this.getIntent().getStringExtra("bo3"));
        bo4.setText(this.getIntent().getStringExtra("bo4"));
        bo5.setText(this.getIntent().getStringExtra("bo5"));
        bo6.setText(this.getIntent().getStringExtra("bo6"));
        bo7.setText(this.getIntent().getStringExtra("bo7"));
        bo8.setText(this.getIntent().getStringExtra("bo8"));
        bo9.setText(this.getIntent().getStringExtra("bo9"));
        bo10.setText(this.getIntent().getStringExtra("bo10"));
        bo11.setText(this.getIntent().getStringExtra("bo11"));
        bo12.setText(this.getIntent().getStringExtra("bo12"));
        bo13.setText(this.getIntent().getStringExtra("bo13"));






    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        onBackPressed();

        //noinspection SimplifiableIfStatement


        return true;

        //return super.onOptionsItemSelected(item);
    }




}
