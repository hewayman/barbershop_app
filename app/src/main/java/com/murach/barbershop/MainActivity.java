package com.murach.barbershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button loginBtn;
    private TextView registerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
        addListenerForRegistration();
    }

    public void addListenerOnButton() {
        // set listener for login button
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });
    }

    public void addListenerForRegistration() {
        // set listener for registration text view
        registerTextView = (TextView) findViewById(R.id.registerTextView);
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistration();
            }
        });
    }

    // continues to home page
    public void openHome() {
        Intent intent = new Intent(this, UserHomeActivity.class);
        startActivity(intent);
    }

    // continues to registration page
    public void openRegistration() {
        Intent intent = new Intent(this, UserRegistration.class);
        startActivity(intent);
    }
}