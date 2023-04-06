package com.example.tamayomobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Activity_Registration extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private EditText birthdateEditText;
    private EditText phoneNumberEditText;
    private EditText emailEditText;
    private Button clearButton;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
        birthdateEditText = findViewById(R.id.birthdateEditText);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        emailEditText = findViewById(R.id.emailEditText);
        clearButton = findViewById(R.id.clearButton);
        submitButton = findViewById(R.id.submitButton);

        clearButton.setOnClickListener(v -> {
            firstNameEditText.setText("");
            lastNameEditText.setText("");
            femaleRadioButton.setSelected(false);
            maleRadioButton.setSelected(false);
            birthdateEditText.setText("");
            phoneNumberEditText.setText("");
            emailEditText.setText("");
        });

        submitButton.setOnClickListener(v -> {
            String firstName = firstNameEditText.getText().toString();
            String lastName = lastNameEditText.getText().toString();
            String name = firstName.concat(" ").concat(lastName);
            String gender;
            if(maleRadioButton.isSelected()) {
                gender = "Female";
            } else {
                gender = "Male";
            }
            String birthdate = birthdateEditText.getText().toString();
            String phoneNumber = phoneNumberEditText.getText().toString();
            String email = emailEditText.getText().toString();

            if (firstName.isEmpty() || lastName.isEmpty() || gender.isEmpty() || birthdate.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()) {
                Toast.makeText(Activity_Registration.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Activity_Registration.this, "Registration submitted", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(getApplicationContext(), Activity_Display.class);
            intent.putExtra("name_key", name);
            intent.putExtra("gender_key", gender);
            intent.putExtra("birthdate_key", birthdate);
            intent.putExtra("phoneNumber_key", phoneNumber);
            intent.putExtra("email_key", email);

            startActivity(intent);
        });
    }

}