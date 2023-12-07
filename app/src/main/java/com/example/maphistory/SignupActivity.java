package com.example.maphistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maphistory.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class SignupActivity extends AppCompatActivity {

//    ActivitySignupBinding binding;
//    DatabaseHelper databaseHelper;

    EditText email;
    EditText pass;
    EditText confirmPass;
    EditText name;
    EditText phone;
    FirebaseAuth fAuth;
    Button signUpButton;
    String userID;
    FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email = findViewById(R.id.signup_email);
        pass = findViewById(R.id.signup_password);
        confirmPass = findViewById(R.id.signup_confirm);
        signUpButton = findViewById(R.id.signup_button);
        name = findViewById(R.id.signup_name);
        phone = findViewById(R.id.signup_phone);

        fAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                String passText = pass.getText().toString();
                String confirmPassText = confirmPass.getText().toString();

                if (TextUtils.isEmpty(emailText)) {
                    email.setError("Vui lòng nhập email");
                }
                else if (TextUtils.isEmpty(passText)) {
                    pass.setError("Vui lòng nhập mật khẩu");
                }
                else if (TextUtils.isEmpty(confirmPassText)) {
                    confirmPass.setError("Vui lòng nhập xác nhận mật khẩu");
                }

                else if (passText.length() < 6) {
                    pass.setError("Mật khẩu cần có độ dài ít nhất 6 ký tự");
                }

                else if (!passText.equals(confirmPassText)) {
                     confirmPass.setError("Mật khẩu không trùng khớp");
                }
                else {
                    fAuth.createUserWithEmailAndPassword(emailText, passText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignupActivity.this, "Tạo thành công tài khoản", Toast.LENGTH_SHORT).show();
                                userID = fAuth.getCurrentUser().getUid();
                                String fullName = name.getText().toString();
                                String phoneNumber = phone.getText().toString();
                                DocumentReference documentReference = firestore.collection("users").document(userID);
                                Map<String, String> user = new HashMap<>();
                                user.put("fname", fullName);
                                user.put("phone", phoneNumber);
                                user.put("email", emailText);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Log.d("TAG", "user created: " + userID );
                                    }
                                });
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                                Toast.makeText(SignupActivity.this, "Lỗi thể tạo tài khoản: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }


            }
        });

//        binding = ActivitySignupBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        databaseHelper = new DatabaseHelper(this);
//        binding.signupButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String email = binding.signupEmail.getText().toString();
//                String password = binding.signupPassword.getText().toString();
//                String confirmPassword = binding.signupConfirm.getText().toString();
//                if(email.equals("")||password.equals("")||confirmPassword.equals(""))
//                    Toast.makeText(SignupActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
//                else{
//                    if(password.equals(confirmPassword)){
//                        Boolean checkUserEmail = databaseHelper.checkEmail(email);
//                        if(checkUserEmail == false){
//                            Boolean insert = databaseHelper.insertData(email, password);
//                            if(insert == true){
//                                Toast.makeText(SignupActivity.this, "Signup Successfully!", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
//                                startActivity(intent);
//                            }else{
//                                Toast.makeText(SignupActivity.this, "Signup Failed!", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                        else{
//                            Toast.makeText(SignupActivity.this, "User already exists! Please login", Toast.LENGTH_SHORT).show();
//                        }
//                    }else{
//                        Toast.makeText(SignupActivity.this, "Invalid Password!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
//        binding.loginRedirectText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
