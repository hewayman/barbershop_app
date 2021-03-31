package com.murach.barbershop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class CalendarActivity extends AppCompatActivity {

    private static final String TAG = "CalendarActivity";
    private CalendarView calendarView;
    private TextView dateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        dateTextView = (TextView) findViewById(R.id.dateTextView);

        // sets color of Month text
        ViewGroup vg = (ViewGroup) calendarView.getChildAt(0);
        View child = vg.getChildAt(0);
        if(child instanceof TextView) {
            ((TextView)child).setTextColor(getResources().getColor(R.color.orange));
        }

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = (i1 + 1) + "/" + i2 + "/" + i;
                Log.d(TAG, "onSelectedDayChange: mm/dd/yyyy: " + date);

//                Intent intent = new Intent(CalendarActivity.this, MainActivity.class);
//                intent.putExtra("date", date);
//                startActivity(intent);

                if (date != null) {
                    dateTextView.setText(date);
                }

            }
        });
    }
}
