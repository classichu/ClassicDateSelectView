package com.classichu.classicdateselectview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.classichu.dateselectview.widget.DateSelectView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     DateSelectView dateSelectView= (DateSelectView) findViewById(R.id.id_date_select_view);
     dateSelectView.setupDateText("2017-8-10","2017-7-10","2017-9-12");
    }
}