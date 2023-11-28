package com.example.maphistory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.maphistory.MainActivity;

public class ForgetPasswordActivity extends AppCompatActivity {

    EditText edt1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_layout);

        edt1 = findViewById(R.id.edt1);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ForgetpasswordIntent = new Intent(ForgetPasswordActivity.this, OTPActivity.class);
                startActivity(ForgetpasswordIntent);
            }
        });
    }
}
