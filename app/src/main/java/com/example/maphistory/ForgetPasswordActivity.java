package com.example.maphistory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.maphistory.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {

    EditText edt1;
    AppCompatButton btn1;
    AppCompatButton gotoLogin;
    TextView message;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_layout);
        fAuth = FirebaseAuth.getInstance();
        edt1 = findViewById(R.id.edt1);
        btn1 = findViewById(R.id.btn1);
        message = findViewById(R.id.message);
        gotoLogin = findViewById(R.id.backToLogin);

        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent ForgetpasswordIntent = new Intent(ForgetPasswordActivity.this, OTPActivity.class);
//                startActivity(ForgetpasswordIntent);
//            }
//        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edt1.getText().toString();
                if (email.isEmpty()) {
                    edt1.setError("Vui lòng nhập email");
                } else {
                    fAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
//                            Toast.makeText(ForgetPasswordActivity.this, "Đường dẫn đặt lại mật khẩu đã được gửi về email của bạn", Toast.LENGTH_LONG).show();
                                message.setVisibility(View.VISIBLE);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ForgetPasswordActivity.this, "Lỗi, đường dẫn chưa được gửi: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }
}
