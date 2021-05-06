package com.murach.barbershop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AppointmentsActivity extends AppCompatActivity {

    private TextView apptsTextView;
    private Button backToLandingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointments_page);
        apptsTextView = (TextView) findViewById(R.id.apptsTextView);
        apptsTextView.setText("Test");

        backToLandingBtn = (Button) findViewById(R.id.backToLandingBtn);
        backToLandingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToLanding();
            }
        });
    }

    public void GoToLanding() {
        Intent intent = new Intent(this, LandingPageActivity.class);
        startActivity(intent);
    }
}