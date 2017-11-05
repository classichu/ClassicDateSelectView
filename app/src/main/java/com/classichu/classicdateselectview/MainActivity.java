package com.classichu.classicdateselectview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.classichu.dateselectview.widget.DateSelectView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DateSelectView dateSelectView = (DateSelectView) findViewById(R.id.id_date_select_view);
        dateSelectView.setupDateText("2017-08-10", "2017-08-09", "2017-08-11");

        DateSelectView id_date_select_view2 = (DateSelectView) findViewById(R.id.id_date_select_view2);
        id_date_select_view2.setupDateText("2017-11-01 11:40:00", "2017-09-09", "2017-12-11");

        DateSelectView id_date_select_view3 = (DateSelectView) findViewById(R.id.id_date_select_view3);
        id_date_select_view3.setupDateText("2017-11-03 16:40:00");

        DateSelectView id_date_select_view4 = (DateSelectView) findViewById(R.id.id_date_select_view4);
        id_date_select_view4.setupDateText("2017-11-03");



    }
}
