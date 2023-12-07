package com.example.maphistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {


    Button btn1_login;
    TextView signUpText, forget;
    EditText loginEmail, loginPassword;

    FirebaseAuth fAuth;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

//        databaseHelper = new DatabaseHelper(this);
        fAuth = FirebaseAuth.getInstance();
        btn1_login = findViewById(R.id.loginButton);
        signUpText = findViewById(R.id.signupText);
        forget = findViewById(R.id.forgetText);
        loginEmail = findViewById(R.id.username);
        loginPassword = findViewById(R.id.password);

        btn1_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = loginEmail.getText().toString();
                String passText = loginPassword.getText().toString();

                if (TextUtils.isEmpty(emailText)) {
                    loginEmail.setError("Vui lòng nhập email");
                }
                else if (TextUtils.isEmpty(passText)) {
                    loginEmail.setError("Vui lòng nhập mật khẩu");
                }

                else if (passText.length() < 6) {
                    loginPassword.setError("Mật khẩu cần có độ dài ít nhất 6 ký tự");
                }

                else {
                    fAuth.signInWithEmailAndPassword(emailText, passText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                                Toast.makeText(LoginActivity.this, "Lỗi không thể đăng nhập:" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });

//        btn1_login.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                //Khai báo intent
////                Intent intentLogin = new Intent(LoginActivity.this,MainActivity.class);
////                //khoi dong
////                startActivity(intentLogin);
////            }
//            @Override
//            public void onClick(View view) {
//                String email = loginEmail.getText().toString();
//                String password = loginPassword.getText().toString();
//                if(email.equals("")||password.equals(""))
//                    Toast.makeText(LoginActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
//                else{
//                    Boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);
//                    if(checkCredentials == true){
//                        Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
//                        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
//                        startActivity(intent);
//                    }else{
//                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
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