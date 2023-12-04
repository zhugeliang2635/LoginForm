package com.example.maphistory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class LoginActivity extends AppCompatActivity {


    Button btn1_login;
    TextView signUpText, forget;
    EditText loginEmail, loginPassword;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        databaseHelper = new DatabaseHelper(this);

        btn1_login = findViewById(R.id.loginButton);
        signUpText = findViewById(R.id.signupText);
        forget = findViewById(R.id.forgetText);
        loginEmail = findViewById(R.id.username);
        loginPassword = findViewById(R.id.password);
        btn1_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Khai báo intent
//                Intent intentLogin = new Intent(LoginActivity.this,MainActivity.class);
//                //khoi dong
//                startActivity(intentLogin);
//            }
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString();
                String password = loginPassword.getText().toString();
                if(email.equals("")||password.equals(""))
                    Toast.makeText(LoginActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);
                    if(checkCredentials == true){
                        Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo intent
                Intent intentSignUp = new Intent(LoginActivity.this,SignupActivity.class);
                //khoi dong
                startActivity(intentSignUp);
            }

        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo intent
                Intent intentForget = new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                //khoi dong
                startActivity(intentForget);
            }
        });

    }

}