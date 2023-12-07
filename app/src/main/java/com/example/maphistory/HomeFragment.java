package com.example.maphistory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

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
        img3 = context.findViewById(R.id.imageView3);
        quiz1 = context.findViewById(R.id.quiz1);
        xtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToInfo = new Intent(context, ListActivity.class);
                startActivity(moveToInfo);
            }
        });
        ArrayList<ListData> eventList = new ArrayList<>();
        ListData listData1 = new ListData("Điện Biên Phủ", "Năm 1954", R.drawable.img_4);
        ListData listData2 = new ListData("Trận Bạch Đằng", "Năm 938", R.drawable.img_7);
        ListData listData3 = new ListData("Chiến dịch HCM", "Năm 1975", R.drawable.img_6);
        eventList.add(listData1);
        eventList.add(listData2);
        eventList.add(listData3);

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
                Intent move1 = new Intent(context, detail.class);
                startActivity(move1);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move2 = new Intent(context, detail.class);
                startActivity(move2);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move3 = new Intent(context, detail.class);
                startActivity(move3);
            }
        });
        quiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToQuiz = new Intent(context, QuizActivity.class);
                moveToQuiz.putExtra("event", "Bạch Đằng Giang");
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

        ImageSlider imageSlider = view.findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.home_pic, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img_8, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img_12, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img_13, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        return view;

    }


}