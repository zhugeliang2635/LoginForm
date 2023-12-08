package com.example.maphistory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerViewPopular;

    private ImageView profileImage;
    private TextView name;
    private FirebaseAuth fAuth;
    private FirebaseFirestore firestore;
    private StorageReference storageReference;



    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */

    Activity context;




    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
    public void onStart() {
        super.onStart();
        TextView xtc = context.findViewById(R.id.textView2);

        ImageView img1, img2, img3, quiz1;
        img1 = context.findViewById(R.id.imageView1);
        img2 = context.findViewById(R.id.imageView);
        img3 = context.findViewById(R.id.exit);
        quiz1 = context.findViewById(R.id.quiz1);
        xtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToInfo = new Intent(context, ListActivity.class);
                startActivity(moveToInfo);
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move1 = new Intent(context, detail.class);
                startActivity(move1);
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), detail.class);
                intent.putExtra("event", "dienbienphu");
                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), detail.class);

                intent.putExtra("event", "bachdang");
                startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), detail.class);
                intent.putExtra("event", "chiendichHCM");
                startActivity(intent);
            }
        });
        quiz1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent moveToQuiz = new Intent(context, QuizActivity.class);
                    String[] id = {"bachdang", "nhunguyet", "dongbodau","chilang","rachgam","ngochoi",
                            "dienbienphu","dienbienphutrenkhong","chiendichHCM"};
                    int num = new Random().nextInt(id.length);
                    moveToQuiz.putExtra("event", id[num]);
                    startActivity(moveToQuiz);
                }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        name = view.findViewById(R.id.user);
        profileImage = view.findViewById(R.id.imageViewpf);

        fAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        MainActivity mainActivity = (MainActivity) getActivity();
        name.setText( mainActivity.getName());

        DocumentReference documentReference = firestore.collection("users").document(fAuth.getCurrentUser().getUid().toString());
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot snapshot = task.getResult();
                    name.setText(snapshot.getString("fname")) ;
                    Toast.makeText(mainActivity, name.getText().toString(), Toast.LENGTH_SHORT);
                } else {
                    Log.d("TAG", "Cannot get user information");
                }
            }
        });



        ImageSlider imageSlider = view.findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.home_pic, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img_8, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img_12, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img_13, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        StorageReference profileImageRef = storageReference.child("users/"+fAuth.getCurrentUser().getUid().toString()+"/profile.jpg");
        profileImageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).transform(new CropCircleTransformation()).into(profileImage);
            }
        });

        return view;

    }


}