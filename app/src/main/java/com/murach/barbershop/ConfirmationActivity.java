package com.murach.barbershop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    private TextView dateConfirmation;
    private Button backBtn;
    private Button bookBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_page);
        dateConfirmation = (TextView) findViewById(R.id.dateConfirmation);
        dateConfirmation.setText("Test");

        backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenCalendar();
            }
        });

        bookBtn = (Button) findViewById(R.id.bookBtn);
        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoHome();
            }
        });

    }

    public void OpenCalendar() {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    public void GoHome() {
        Intent intent = new Intent(this, UserHomeActivity.class);
        startActivity(intent);
    }
}
