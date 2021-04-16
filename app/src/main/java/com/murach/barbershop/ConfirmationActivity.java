package com.murach.barbershop;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    private TextView dateConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_page);
        dateConfirmation = (TextView) findViewById(R.id.dateConfirmation);
        dateConfirmation.setText("Test");
    }
}
