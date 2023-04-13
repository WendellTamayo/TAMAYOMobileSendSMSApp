package com.example.tamayomobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Acitivity_SendSMS extends AppCompatActivity {
    Button btnSend;
    EditText txtPhoneNumber;
    EditText txtMessage;
    Button btnClear;
    String phoneNo;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity_send_sms);

        btnSend = findViewById(R.id.btnSend);
        txtPhoneNumber = findViewById(R.id.txtPhone);
        txtMessage = findViewById(R.id.txtMessage);
        btnClear = findViewById(R.id.btnClear);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNo = txtPhoneNumber.getText().toString();
                message = txtMessage.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", phoneNo, null));
                intent.putExtra("sms_body", message);
                startActivity(intent);

                Toast.makeText(Acitivity_SendSMS.this, "SMS Sent", Toast.LENGTH_SHORT).show();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtPhoneNumber.setText("");
                txtMessage.setText("");
            }
        });
    }
}