package com.example.maphistory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OTPActivity extends AppCompatActivity {
    TextView tv1, tv2;
    EditText edt1;
    Button btn1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_layout);

        edt1 = findViewById(R.id.edt1);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo intent
                Intent intentOTP = new Intent(OTPActivity.this,ResetPasswordActivity.class);
                //khoi dong
                startActivity(intentOTP);
            }
        });
    }
}
