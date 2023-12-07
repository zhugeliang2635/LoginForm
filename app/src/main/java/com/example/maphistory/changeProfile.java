package com.example.maphistory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class changeProfile extends AppCompatActivity {

    private FirebaseAuth fAuth;

    private FirebaseFirestore firestore;
    private EditText phone;
    private EditText name;
    private AppCompatButton changePicture;
    private AppCompatButton saveInfor;
    private ImageView editName;
    private ImageView editPhone;

    private ImageView profileImage;

    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);
        phone =(EditText) findViewById(R.id.phone);
        name = findViewById(R.id.name);
        changePicture = findViewById(R.id.changePicture);
        saveInfor = findViewById(R.id.saveInfor);
        editName = findViewById(R.id.editNameButton);
        editPhone = findViewById(R.id.editPhoneButton);
        profileImage = findViewById(R.id.profileImage);
        fAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        StorageReference profileImageRef = storageReference.child("users/"+fAuth.getCurrentUser().getUid().toString()+"/profile.jpg");
        profileImageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).transform(new CropCircleTransformation()).into(profileImage);
            }
        });

        DocumentReference documentReference = firestore.collection("users").document(fAuth.getCurrentUser().getUid().toString());
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot snapshot = task.getResult();
                    phone.setText(snapshot.getString("phone"));
                    name.setText(snapshot.getString("fname"));
                } else {
                    Log.d("TAG", "Cannot get user information");
                }
            }
        });

        editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (android.view.inputmethod.InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
                name.setEnabled(true);
                name.requestFocus();
                name.setFocusable(true);
                name.setSelection(name.getText().length());
            }
        });

        editPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (android.view.inputmethod.InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                phone.setEnabled(true);
                phone.requestFocus();
                phone.setFocusable(true);
                phone.setSelection(phone.getText().length());
            }
        });


        saveInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = fAuth.getUid().toString();
                DocumentReference documentReference = firestore.collection("users").document(userId);
                String phoneText = phone.getText().toString();
                String nameText = name.getText().toString();
                Map<String, Object> edited = new HashMap<>();
                edited.put("phone", phoneText);
                edited.put("name", nameText);
                documentReference.update(edited);
                phone.setEnabled(false);
                name.setEnabled(false);
            }
        });

        changePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGallery, 1000);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                Uri imageUri = data.getData();
//                profileImage.setImageURI(imageUri);
                uploadImage(imageUri);
            }
        }
    }

    public void uploadImage(Uri imageUri) {
        StorageReference fileRef = storageReference.child("users/"+fAuth.getCurrentUser().getUid().toString()+"/profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                Toast.makeText(changeProfile.this, "Thay đổi ảnh đại diện thành công", Toast.LENGTH_SHORT).show();
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).transform(new CropCircleTransformation()).into(profileImage);
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(changeProfile.this, "Không thể thay đổi ảnh đại diện", Toast.LENGTH_SHORT).show();
            }
        });
    }

}