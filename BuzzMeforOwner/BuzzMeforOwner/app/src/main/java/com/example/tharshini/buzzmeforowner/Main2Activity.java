package com.example.tharshini.buzzmeforowner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Switch;

public class Main2Activity extends AppCompatActivity {
    Switch switch1;
    Button displayGraph;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        /*Add in Oncreate() funtion after setContentView()*/
        // initiate a Switch
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        //set the current state of a Switch
        switch1.setChecked(false);

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main4Activity.class);
                startActivity(intent);
            }
        });
/*
        // get the reference of CalendarView
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        // get selected date in milliseconds
        long selectedDate = calendarView.getDate();
        // set selected date 22 May 2016 in milliseconds
        calendarView.setDate(1463918226920L);
        // set Monday as the first day of the week
        calendarView.setFirstDayOfWeek(2);
        // get first day of the week
        int firstDayOfWeek= calendarView.getFirstDayOfWeek();
        // set true value for showing the week numbers.
        calendarView.setShowWeekNumber(false);
        // checks whether the week number are shown or not.
        calendarView.getShowWeekNumber();

        // perform setOnDateChangeListener event on CalendarView
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
// add code here
            }
        });
*/
        displayGraph = (Button) findViewById(R.id.displayGraph);

        displayGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
    }
}
