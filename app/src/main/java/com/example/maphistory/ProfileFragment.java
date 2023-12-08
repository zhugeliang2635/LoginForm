package com.example.maphistory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    FirebaseAuth fAuth;
    private TextView gotoProfile;
    private TextView gotoChangePass;

    private TextView email;
    private TextView name;
    private ImageView profileImage;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */

    Activity context;



    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        View view2 = inflater.inflate(R.layout.new_fragment_profile, container, false);
        MainActivity parent = (MainActivity) getActivity();
        fAuth = FirebaseAuth.getInstance();
        name = view2.findViewById(R.id.name);
        email = view2.findViewById(R.id.email);
        name.setText(parent.getName());
        email.setText(parent.getEmail());
        profileImage = view2.findViewById(R.id.profileImage);
        AppCompatButton btn1 = view2.findViewById(R.id.imageNoti);
        gotoProfile = view2.findViewById(R.id.goToChangeProfileButton);
        gotoChangePass = view2.findViewById(R.id.goToChangePassButton);

        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference profileImageRef = storageReference.child("users/"+fAuth.getCurrentUser().getUid().toString()+"/profile.jpg");
        profileImageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).transform(new CropCircleTransformation()).into(profileImage);
            }
        });

        gotoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, changeProfile.class));

            }
        });

        gotoChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, ChangePassword.class));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(context, LoginActivity.class));
                parent.finish();
            }
        });
        return view2;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        ImageButton btn1 = context.findViewById(R.id.imageNoti);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent moveToSignIn = new Intent(context, LoginActivity.class);
//                startActivity(moveToSignIn);
//            }
//        });
//
//    }
}