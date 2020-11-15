package com.example.multiplicationtable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mylistview;

    public final void generate(int seekbarno){
        final ArrayList<String> myarraylist= new ArrayList<String>();
        for (int j = 1; j <= 100; j++)
        {
            myarraylist.add(Integer.toString( j* seekbarno));
        }
        ArrayAdapter<String> myarrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myarraylist);
        mylistview.setAdapter(myarrayadapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylistview= findViewById(R.id.myListView);
        final SeekBar myseekbar= findViewById(R.id.mySeekBar);
        myseekbar.setMax(100);
        generate(10);
        myseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1 ,seekbarno;
                if(progress<min)
                {

                 seekbarno=min;

                }
                else
                {
                    seekbarno=progress;

                }

                Log.i("value",Integer.toString(progress));
                generate(seekbarno);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}

