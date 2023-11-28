package com.example.maphistory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class LoginActivity extends AppCompatActivity {

    ImageView img;
    EditText edt1, edt2;
    Button btn1_login, btn2;
    TextView tv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);

        tv = findViewById(R.id.tv1);

        btn1_login = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        btn1_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khai báo intent
                Intent intentLogin = new Intent(LoginActivity.this,MainActivity.class);
                //khoi dong
                startActivity(intentLogin);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo intent
                Intent intentforget = new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                //khoi dong
                startActivity(intentforget);
            }
        });

    }

}