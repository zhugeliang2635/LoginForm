package com.example.maphistory;

import static android.content.Intent.getIntent;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.checkerframework.checker.units.qual.A;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizDetail2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizDetail2Fragment extends Fragment {
    private String name;
    private ImageView image;
    private TextView textView;

    private Button start;

    private View mView;
    private QuizActivity activity;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuizDetail2Fragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuizDetail2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizDetail2Fragment newInstance(String param1, String param2) {
        QuizDetail2Fragment fragment = new QuizDetail2Fragment();
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
        mView =  inflater.inflate(R.layout.fragment_quiz_detail2, container, false);

        activity = (QuizActivity) getActivity();
        start = mView.findViewById(R.id.quiz_des_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.nextQuestion(1);
            }
        });
        textView = mView.findViewById(R.id.quiz_des_title);

        image = mView.findViewById(R.id.quiz_des_image);
        image.setBackgroundResource(R.drawable.home_pic);

        return mView;
    }
}