package com.example.maphistory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.badge.BadgeUtils;

public class ResetPasswordActivity extends AppCompatActivity {


    EditText edt1, edt2;
    Button btn1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password_layout);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Khai báo intent
                Intent intentReset = new Intent(ResetPasswordActivity.this,MainActivity.class);
                //khoi dong
                startActivity(intentReset);
            }
        });
    }
}
