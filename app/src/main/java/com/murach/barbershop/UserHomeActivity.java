package com.murach.barbershop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserHomeActivity extends AppCompatActivity {

    private Button apptBtn;
    private Button haircutBtn;
    private Button styleBtn;
    private Button shaveBtn;
    private Button colorBtn;
    private Boolean isHaircutClicked;
    private Boolean isStyleClicked;
    private Boolean isShaveClicked;
    private Boolean isColorClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // sets layout to user home page
        setContentView(R.layout.user_home);
        apptBtn = (Button) findViewById(R.id.apptBtn);

        haircutBtn = (Button) findViewById(R.id.haircutBtn);
        haircutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isHaircutClicked = true;
                if(isHaircutClicked) {
                    haircutBtn.setBackgroundColor(getResources().getColor(R.color.orange));
                }
            }
        });

        styleBtn = (Button) findViewById(R.id.styleBtn);
        styleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isStyleClicked = true;
                if(isStyleClicked) {
                    styleBtn.setBackgroundColor(getResources().getColor(R.color.orange));
                }
            }
        });

        shaveBtn = (Button) findViewById(R.id.shaveBtn);
        shaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isShaveClicked = true;
                if(isShaveClicked) {
                    shaveBtn.setBackgroundColor(getResources().getColor(R.color.orange));
                }
            }
        });

        colorBtn = (Button) findViewById(R.id.colorBtn);
        colorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isColorClicked = true;
                if(isColorClicked) {
                    colorBtn.setBackgroundColor(getResources().getColor(R.color.orange));
                }
            }
        });

        apptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalendar();
            }
        });
    }

    // continues to calendar
    public void openCalendar() {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }
}
