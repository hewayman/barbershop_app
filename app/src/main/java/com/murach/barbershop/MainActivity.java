package com.murach.barbershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button loginBtn;
    private TextView goToRegisterTextView;
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        addListenerOnButton();
        addListenerForRegistration();
    }

    public void addListenerOnButton() {
        // set listener for login button
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper.checkUser(usernameEditText.toString(), passwordEditText.toString());
                openHome();
            }
        });
    }

    public void addListenerForRegistration() {
        // set listener for registration text view
        goToRegisterTextView = (TextView) findViewById(R.id.goToRegisterTextView);
        goToRegisterTextView.setOnClickListener(new View.OnClickListener() {
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