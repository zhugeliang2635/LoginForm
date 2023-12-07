package com.example.maphistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePassword extends AppCompatActivity {
    private EditText currentPass;
    private EditText newPass;
    private EditText confirmPass;

    private FirebaseAuth fAuth;

    private FirebaseUser user;
    private TextView errorMessage;

    private AppCompatButton changeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        currentPass = findViewById(R.id.currentPass);
        newPass = findViewById(R.id.newPass);
        confirmPass = findViewById(R.id.confirmNewPass);
        changeButton = findViewById(R.id.changeButton);
        errorMessage = findViewById(R.id.errorMessage);
        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newPassText = newPass.getText().toString();
                String confirmPassText = confirmPass.getText().toString();
                if (newPassText.length() < 6) {
                    errorMessage.setText("Vui lòng nhập mật khẩu từ 6 ký tự trở lên!");
                    errorMessage.setVisibility(View.VISIBLE);
                }
                else if (!newPassText.equals(confirmPassText)) {
                    errorMessage.setText("Mật khẩu không khớp với trường xác nhận mật khẩu!");
                    errorMessage.setVisibility(View.VISIBLE);
                }
                else {
                    user.updatePassword(newPassText).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(ChangePassword.this, "Đổi mật khẩu thành công!", Toast.LENGTH_SHORT).show();
                            fAuth.signOut();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            errorMessage.setText("Không thể đổi mật khẩu" + e.getMessage());
                            errorMessage.setVisibility(View.VISIBLE);
                        }
                    });
                }

            }
        });
    }
}