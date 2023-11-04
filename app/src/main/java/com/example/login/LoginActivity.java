package com.example.login;

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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login1layout);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);

        btn1_login = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        btn1_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khai báo intent
                Intent intentLogin = new Intent(LoginActivity.this,ResetPassword.class);
                //khoi dong
                startActivity(intentLogin);
            }
        });

    }

}