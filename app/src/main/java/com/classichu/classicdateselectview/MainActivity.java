package com.classichu.classicdateselectview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.classichu.dateselectview.widget.DateSelectView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DateSelectView dateSelectView = (DateSelectView) findViewById(R.id.id_date_select_view);
        dateSelectView.setupDateText("2017-8-10", "2017-7-10", "2017-9-12");

        DateSelectView id_date_select_view2 = (DateSelectView) findViewById(R.id.id_date_select_view2);
        id_date_select_view2.setupDateText("2017-11-3 17:40:00");

        DateSelectView id_date_select_view3 = (DateSelectView) findViewById(R.id.id_date_select_view3);
        id_date_select_view3.setupDateText("2017-11-3");

        DateSelectView id_date_select_view4 = (DateSelectView) findViewById(R.id.id_date_select_view4);
        id_date_select_view4.setupDateText("17:40:00");

        DateSelectView id_date_select_view5 = (DateSelectView) findViewById(R.id.id_date_select_view5);
        id_date_select_view5.setupDateText("2017-8-10  17:40:00", "2017-7-10", "2017-9-12");
    }
}
