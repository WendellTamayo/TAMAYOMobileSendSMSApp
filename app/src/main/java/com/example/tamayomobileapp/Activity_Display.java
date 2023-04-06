package com.example.tamayomobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewGender = findViewById(R.id.textViewGender);
        TextView textViewBirthdate = findViewById(R.id.textViewBirthdate);
        TextView textViewPhone = findViewById(R.id.textViewPhone);
        TextView textViewEmail = findViewById(R.id.textViewEmail);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name_key");
        String gender = intent.getStringExtra("gender_key");
        String birthdate = intent.getStringExtra("birthdate_key");
        String phone = intent.getStringExtra("phoneNumber_key");
        String email = intent.getStringExtra("email_key");

        textViewName.setText(name);
        textViewGender.setText(gender);
        textViewBirthdate.setText(birthdate);
        textViewPhone.setText(phone);
        textViewEmail.setText(email);
    }
}