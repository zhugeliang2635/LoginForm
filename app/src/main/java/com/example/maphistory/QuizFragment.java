package com.example.maphistory;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private TextView questionText;
    private QuizActivity activity;
    private String ans;
    private String mParam1;
    private String mParam2;
    private TextView feedback;

    private ImageView exit;

    private TextView questionVal;
    private AppCompatButton optionA;
    private AppCompatButton optionB;
    private AppCompatButton optionC;
    private AppCompatButton nextQuestion;

    private TextView ansVerify;
    private int number;

    private boolean canAnswer = false;
    public QuizFragment() {
        // Required empty public constructor
    }

    public QuizFragment( int questionNumber) {
        this.number = questionNumber;

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizFragment newInstance(String param1, String param2) {
        QuizFragment fragment = new QuizFragment();
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
        View view =  inflater.inflate(R.layout.fragment_quiz, container, false);
        activity = (QuizActivity) getActivity();
        feedback = view.findViewById(R.id.ansFeedbackTv);

        canAnswer = true;
        feedback.setVisibility(View.INVISIBLE);
        optionA = view.findViewById(R.id.option1Btn);
        optionB = view.findViewById(R.id.option2Btn);
        optionC = view.findViewById(R.id.option3Btn);
        exit = view.findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizActivity parent = (QuizActivity)getActivity();
                Intent intent = new Intent(parent, detail.class);
                intent.putExtra("event", parent.getName());
                startActivity(intent);
                parent.finish();

            }
        });
        optionC.setEnabled(true);
//        optionC.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                verify(optionC);
//            }
//        });
//
//        optionB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                verify(optionB);
//            }
//        });
//
//        optionA.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                verify(optionA);
//            }
//        });

        optionC.setOnClickListener(this);
        optionB.setOnClickListener(this);
        optionA.setOnClickListener(this);


        questionVal = view.findViewById(R.id.quizQuestionsCount);
        questionVal.setText(Integer.toString(number));
        nextQuestion = view.findViewById(R.id.nextQueBtn);
        nextQuestion.setVisibility(View.INVISIBLE);
        questionText = view.findViewById(R.id.quizQuestionTv);
//        switch (activity.getName()) {
//            case "bachdang":
//                if (number == 1) {
//                    questionText.setText(R.string.bachdang_ques_1);
//                    optionA.setText(R.string.bachdang_ques_1_a);
//                    optionB.setText(R.string.bachdang_ques_1_b);
//                    optionC.setText(R.string.bachdang_ques_1_c);
//                    ans = getResources().getString(R.string.bachdang_ques_1_ans);
//                } else if (number == 2) {
//                    questionText.setText(R.string.bachdang_ques_2);
//                    optionA.setText(R.string.bachdang_ques_2_a);
//                    optionB.setText(R.string.bachdang_ques_2_b);
//                    optionC.setText(R.string.bachdang_ques_2_c);
//                    ans = getResources().getString(R.string.bachdang_ques_2_ans);
//                } else if (number == 3) {
//                    questionText.setText(R.string.bachdang_ques_3);
//                    optionA.setText(R.string.bachdang_ques_3_a);
//                    optionB.setText(R.string.bachdang_ques_3_b);
//                    optionC.setText(R.string.bachdang_ques_3_c);
//                    ans = getResources().getString(R.string.bachdang_ques_3_ans);
//                } else if (number == 4) {
//                    questionText.setText(R.string.bachdang_ques_4);
//                    optionA.setText(R.string.bachdang_ques_4_a);
//                    optionB.setText(R.string.bachdang_ques_4_b);
//                    optionC.setText(R.string.bachdang_ques_4_c);
//                    ans = getResources().getString(R.string.bachdang_ques_4_ans);
//                } else if (number == 5) {
//                    questionText.setText(R.string.bachdang_ques_5);
//                }
//        }
        switch (activity.getName()) {
            case "bachdang":
                switch (number) {
                    case 1:
                        questionText.setText(R.string.bachdang_ques_1);
                        optionA.setText(R.string.bachdang_ques_1_a);
                        optionB.setText(R.string.bachdang_ques_1_b);
                        optionC.setText(R.string.bachdang_ques_1_c);
                        ans = getResources().getString(R.string.bachdang_ques_1_ans);
                        break;
                    case 2:
                        questionText.setText(R.string.bachdang_ques_2);
                        optionA.setText(R.string.bachdang_ques_2_a);
                        optionB.setText(R.string.bachdang_ques_2_b);
                        optionC.setText(R.string.bachdang_ques_2_c);
                        ans = getResources().getString(R.string.bachdang_ques_2_ans);
                        break;
                    case 3:
                        questionText.setText(R.string.bachdang_ques_3);
                        optionA.setText(R.string.bachdang_ques_3_a);
                        optionB.setText(R.string.bachdang_ques_3_b);
                        optionC.setText(R.string.bachdang_ques_3_c);
                        ans = getResources().getString(R.string.bachdang_ques_3_ans);
                        break;
                    case 4:
                        questionText.setText(R.string.bachdang_ques_4);
                        optionA.setText(R.string.bachdang_ques_4_a);
                        optionB.setText(R.string.bachdang_ques_4_b);
                        optionC.setText(R.string.bachdang_ques_4_c);
                        ans = getResources().getString(R.string.bachdang_ques_4_ans);
                        break;
                    case 5:
                        questionText.setText(R.string.bachdang_ques_5);
                        optionA.setText(R.string.bachdang_ques_5_a);
                        optionB.setText(R.string.bachdang_ques_5_b);
                        optionC.setText(R.string.bachdang_ques_5_c);
                        ans = getResources().getString(R.string.bachdang_ques_5_ans);
                        break;
                    case 6:
                        questionText.setText(R.string.bachdang_ques_6);
                        optionA.setText(R.string.bachdang_ques_6_a);
                        optionB.setText(R.string.bachdang_ques_6_b);
                        optionC.setText(R.string.bachdang_ques_6_c);
                        ans = getResources().getString(R.string.bachdang_ques_6_ans);
                        break;
                    case 7:
                        questionText.setText(R.string.bachdang_ques_7);
                        optionA.setText(R.string.bachdang_ques_7_a);
                        optionB.setText(R.string.bachdang_ques_7_b);
                        optionC.setText(R.string.bachdang_ques_7_c);
                        ans = getResources().getString(R.string.bachdang_ques_7_ans);
                        break;
                    case 8:
                        questionText.setText(R.string.bachdang_ques_8);
                        optionA.setText(R.string.bachdang_ques_8_a);
                        optionB.setText(R.string.bachdang_ques_8_b);
                        optionC.setText(R.string.bachdang_ques_8_c);
                        ans = getResources().getString(R.string.bachdang_ques_8_ans);
                        break;
                    case 9:
                        questionText.setText(R.string.bachdang_ques_9);
                        optionA.setText(R.string.bachdang_ques_9_a);
                        optionB.setText(R.string.bachdang_ques_9_b);
                        optionC.setText(R.string.bachdang_ques_9_c);
                        ans = getResources().getString(R.string.bachdang_ques_9_ans);
                        break;
                    case 10:
                        questionText.setText(R.string.bachdang_ques_10);
                        optionA.setText(R.string.bachdang_ques_10_a);
                        optionB.setText(R.string.bachdang_ques_10_b);
                        optionC.setText(R.string.bachdang_ques_10_c);
                        ans = getResources().getString(R.string.bachdang_ques_10_ans);
                        break;
                }
                break;
            case "nhunguyet":
                switch (number) {
                    case 1:
                        questionText.setText(R.string.nhunguyet_ques_1);
                        optionA.setText(R.string.nhunguyet_ques_1_a);
                        optionB.setText(R.string.nhunguyet_ques_1_b);
                        optionC.setText(R.string.nhunguyet_ques_1_c);
                        ans = getResources().getString(R.string.nhunguyet_ques_1_ans);
                        break;
                    case 2:
                        questionText.setText(R.string.nhunguyet_ques_2);
                        optionA.setText(R.string.nhunguyet_ques_2_a);
                        optionB.setText(R.string.nhunguyet_ques_2_b);
                        optionC.setText(R.string.nhunguyet_ques_2_c);
                        ans = getResources().getString(R.string.nhunguyet_ques_2_ans);
                        break;
                    case 3:
                        questionText.setText(R.string.nhunguyet_ques_3);
                        optionA.setText(R.string.nhunguyet_ques_3_a);
                        optionB.setText(R.string.nhunguyet_ques_3_b);
                        optionC.setText(R.string.nhunguyet_ques_3_c);
                        ans = getResources().getString(R.string.nhunguyet_ques_3_ans);
                        break;
                    case 4:
                        questionText.setText(R.string.nhunguyet_ques_4);
                        optionA.setText(R.string.nhunguyet_ques_4_a);
                        optionB.setText(R.string.nhunguyet_ques_4_b);
                        optionC.setText(R.string.nhunguyet_ques_4_c);
                        ans = getResources().getString(R.string.nhunguyet_ques_4_ans);
                        break;
                    case 5:
                        questionText.setText(R.string.nhunguyet_ques_5);
                        optionA.setText(R.string.nhunguyet_ques_5_a);
                        optionB.setText(R.string.nhunguyet_ques_5_b);
                        optionC.setText(R.string.nhunguyet_ques_5_c);
                        ans = getResources().getString(R.string.nhunguyet_ques_5_ans);
                        break;
                    case 6:
                        questionText.setText(R.string.nhunguyet_ques_6);
                        optionA.setText(R.string.nhunguyet_ques_6_a);
                        optionB.setText(R.string.nhunguyet_ques_6_b);
                        optionC.setText(R.string.nhunguyet_ques_6_c);
                        ans = getResources().getString(R.string.nhunguyet_ques_6_ans);
                        break;
                    case 7:
                        questionText.setText(R.string.nhunguyet_ques_7);
                        optionA.setText(R.string.nhunguyet_ques_7_a);
                        optionB.setText(R.string.nhunguyet_ques_7_b);
                        optionC.setText(R.string.nhunguyet_ques_7_c);
                        ans = getResources().getString(R.string.nhunguyet_ques_7_ans);
                        break;
                    case 8:
                        questionText.setText(R.string.nhunguyet_ques_8);
                        optionA.setText(R.string.nhunguyet_ques_8_a);
                        optionB.setText(R.string.nhunguyet_ques_8_b);
                        optionC.setText(R.string.nhunguyet_ques_8_c);
                        ans = getResources().getString(R.string.nhunguyet_ques_8_ans);
                        break;
                    case 9:
                        questionText.setText(R.string.nhunguyet_ques_9);
                        optionA.setText(R.string.nhunguyet_ques_9_a);
                        optionB.setText(R.string.nhunguyet_ques_9_b);
                        optionC.setText(R.string.nhunguyet_ques_9_c);
                        ans = getResources().getString(R.string.nhunguyet_ques_9_ans);
                        break;
                    case 10:
                        questionText.setText(R.string.nhunguyet_ques_10);
                        optionA.setText(R.string.nhunguyet_ques_10_a);
                        optionB.setText(R.string.nhunguyet_ques_10_b);
                        optionC.setText(R.string.nhunguyet_ques_10_c);
                        ans = getResources().getString(R.string.nhunguyet_ques_10_ans);
                        break;
                }
                break;
            case "dongbodau":
                switch (number) {
                    case 1:
                        questionText.setText(R.string.dongbodau_ques_1);
                        optionA.setText(R.string.dongbodau_ques_1_a);
                        optionB.setText(R.string.dongbodau_ques_1_b);
                        optionC.setText(R.string.dongbodau_ques_1_c);
                        ans = getResources().getString(R.string.dongbodau_ques_1_ans);
                        break;
                    case 2:
                        questionText.setText(R.string.dongbodau_ques_2);
                        optionA.setText(R.string.dongbodau_ques_2_a);
                        optionB.setText(R.string.dongbodau_ques_2_b);
                        optionC.setText(R.string.dongbodau_ques_2_c);
                        ans = getResources().getString(R.string.dongbodau_ques_2_ans);
                        break;
                    case 3:
                        questionText.setText(R.string.dongbodau_ques_3);
                        optionA.setText(R.string.dongbodau_ques_3_a);
                        optionB.setText(R.string.dongbodau_ques_3_b);
                        optionC.setText(R.string.dongbodau_ques_3_c);
                        ans = getResources().getString(R.string.dongbodau_ques_3_ans);
                        break;
                    case 4:
                        questionText.setText(R.string.dongbodau_ques_4);
                        optionA.setText(R.string.dongbodau_ques_4_a);
                        optionB.setText(R.string.dongbodau_ques_4_b);
                        optionC.setText(R.string.dongbodau_ques_4_c);
                        ans = getResources().getString(R.string.dongbodau_ques_4_ans);
                        break;
                    case 5:
                        questionText.setText(R.string.dongbodau_ques_5);
                        optionA.setText(R.string.dongbodau_ques_5_a);
                        optionB.setText(R.string.dongbodau_ques_5_b);
                        optionC.setText(R.string.dongbodau_ques_5_c);
                        ans = getResources().getString(R.string.dongbodau_ques_5_ans);
                        break;
                    case 6:
                        questionText.setText(R.string.dongbodau_ques_6);
                        optionA.setText(R.string.dongbodau_ques_6_a);
                        optionB.setText(R.string.dongbodau_ques_6_b);
                        optionC.setText(R.string.dongbodau_ques_6_c);
                        ans = getResources().getString(R.string.dongbodau_ques_6_ans);
                        break;
                    case 7:
                        questionText.setText(R.string.dongbodau_ques_7);
                        optionA.setText(R.string.dongbodau_ques_7_a);
                        optionB.setText(R.string.dongbodau_ques_7_b);
                        optionC.setText(R.string.dongbodau_ques_7_c);
                        ans = getResources().getString(R.string.dongbodau_ques_7_ans);
                        break;
                    case 8:
                        questionText.setText(R.string.dongbodau_ques_8);
                        optionA.setText(R.string.dongbodau_ques_8_a);
                        optionB.setText(R.string.dongbodau_ques_8_b);
                        optionC.setText(R.string.dongbodau_ques_8_c);
                        ans = getResources().getString(R.string.dongbodau_ques_8_ans);
                        break;
                    case 9:
                        questionText.setText(R.string.dongbodau_ques_9);
                        optionA.setText(R.string.dongbodau_ques_9_a);
                        optionB.setText(R.string.dongbodau_ques_9_b);
                        optionC.setText(R.string.dongbodau_ques_9_c);
                        ans = getResources().getString(R.string.dongbodau_ques_9_ans);
                        break;
                    case 10:
                        questionText.setText(R.string.dongbodau_ques_10);
                        optionA.setText(R.string.dongbodau_ques_10_a);
                        optionB.setText(R.string.dongbodau_ques_10_b);
                        optionC.setText(R.string.dongbodau_ques_10_c);
                        ans = getResources().getString(R.string.dongbodau_ques_10_ans);
                        break;
                }
                break;
            case "chilang":
                switch (number) {
                    case 1:
                        questionText.setText(R.string.chilang_ques_1);
                        optionA.setText(R.string.chilang_ques_1_a);
                        optionB.setText(R.string.chilang_ques_1_b);
                        optionC.setText(R.string.chilang_ques_1_c);
                        ans = getResources().getString(R.string.chilang_ques_1_ans);
                        break;
                    case 2:
                        questionText.setText(R.string.chilang_ques_2);
                        optionA.setText(R.string.chilang_ques_2_a);
                        optionB.setText(R.string.chilang_ques_2_b);
                        optionC.setText(R.string.chilang_ques_2_c);
                        ans = getResources().getString(R.string.chilang_ques_2_ans);
                        break;
                    case 3:
                        questionText.setText(R.string.chilang_ques_3);
                        optionA.setText(R.string.chilang_ques_3_a);
                        optionB.setText(R.string.chilang_ques_3_b);
                        optionC.setText(R.string.chilang_ques_3_c);
                        ans = getResources().getString(R.string.chilang_ques_3_ans);
                        break;
                    case 4:
                        questionText.setText(R.string.chilang_ques_4);
                        optionA.setText(R.string.chilang_ques_4_a);
                        optionB.setText(R.string.chilang_ques_4_b);
                        optionC.setText(R.string.chilang_ques_4_c);
                        ans = getResources().getString(R.string.chilang_ques_4_ans);
                        break;
                    case 5:
                        questionText.setText(R.string.chilang_ques_5);
                        optionA.setText(R.string.chilang_ques_5_a);
                        optionB.setText(R.string.chilang_ques_5_b);
                        optionC.setText(R.string.chilang_ques_5_c);
                        ans = getResources().getString(R.string.chilang_ques_5_ans);
                        break;
                    case 6:
                        questionText.setText(R.string.chilang_ques_6);
                        optionA.setText(R.string.chilang_ques_6_a);
                        optionB.setText(R.string.chilang_ques_6_b);
                        optionC.setText(R.string.chilang_ques_6_c);
                        ans = getResources().getString(R.string.chilang_ques_6_ans);
                        break;
                    case 7:
                        questionText.setText(R.string.chilang_ques_7);
                        optionA.setText(R.string.chilang_ques_7_a);
                        optionB.setText(R.string.chilang_ques_7_b);
                        optionC.setText(R.string.chilang_ques_7_c);
                        ans = getResources().getString(R.string.chilang_ques_7_ans);
                        break;
                    case 8:
                        questionText.setText(R.string.chilang_ques_8);
                        optionA.setText(R.string.chilang_ques_8_a);
                        optionB.setText(R.string.chilang_ques_8_b);
                        optionC.setText(R.string.chilang_ques_8_c);
                        ans = getResources().getString(R.string.chilang_ques_8_ans);
                        break;
                    case 9:
                        questionText.setText(R.string.chilang_ques_9);
                        optionA.setText(R.string.chilang_ques_9_a);
                        optionB.setText(R.string.chilang_ques_9_b);
                        optionC.setText(R.string.chilang_ques_9_c);
                        ans = getResources().getString(R.string.chilang_ques_9_ans);
                        break;
                    case 10:
                        questionText.setText(R.string.chilang_ques_10);
                        optionA.setText(R.string.chilang_ques_10_a);
                        optionB.setText(R.string.chilang_ques_10_b);
                        optionC.setText(R.string.chilang_ques_10_c);
                        ans = getResources().getString(R.string.chilang_ques_10_ans);
                        break;
                }
                break;
            case "rachgam":
                switch (number) {
                    case 1:
                        questionText.setText(R.string.rachgam_ques_1);
                        optionA.setText(R.string.rachgam_ques_1_a);
                        optionB.setText(R.string.rachgam_ques_1_b);
                        optionC.setText(R.string.rachgam_ques_1_c);
                        ans = getResources().getString(R.string.rachgam_ques_1_ans);
                        break;
                    case 2:
                        questionText.setText(R.string.rachgam_ques_2);
                        optionA.setText(R.string.rachgam_ques_2_a);
                        optionB.setText(R.string.rachgam_ques_2_b);
                        optionC.setText(R.string.rachgam_ques_2_c);
                        ans = getResources().getString(R.string.rachgam_ques_2_ans);
                        break;
                    case 3:
                        questionText.setText(R.string.rachgam_ques_3);
                        optionA.setText(R.string.rachgam_ques_3_a);
                        optionB.setText(R.string.rachgam_ques_3_b);
                        optionC.setText(R.string.rachgam_ques_3_c);
                        ans = getResources().getString(R.string.rachgam_ques_3_ans);
                        break;
                    case 4:
                        questionText.setText(R.string.rachgam_ques_4);
                        optionA.setText(R.string.rachgam_ques_4_a);
                        optionB.setText(R.string.rachgam_ques_4_b);
                        optionC.setText(R.string.rachgam_ques_4_c);
                        ans = getResources().getString(R.string.rachgam_ques_4_ans);
                        break;
                    case 5:
                        questionText.setText(R.string.rachgam_ques_5);
                        optionA.setText(R.string.rachgam_ques_5_a);
                        optionB.setText(R.string.rachgam_ques_5_b);
                        optionC.setText(R.string.rachgam_ques_5_c);
                        ans = getResources().getString(R.string.rachgam_ques_5_ans);
                        break;
                    case 6:
                        questionText.setText(R.string.rachgam_ques_6);
                        optionA.setText(R.string.rachgam_ques_6_a);
                        optionB.setText(R.string.rachgam_ques_6_b);
                        optionC.setText(R.string.rachgam_ques_6_c);
                        ans = getResources().getString(R.string.rachgam_ques_6_ans);
                        break;
                    case 7:
                        questionText.setText(R.string.rachgam_ques_7);
                        optionA.setText(R.string.rachgam_ques_7_a);
                        optionB.setText(R.string.rachgam_ques_7_b);
                        optionC.setText(R.string.rachgam_ques_7_c);
                        ans = getResources().getString(R.string.rachgam_ques_7_ans);
                        break;
                    case 8:
                        questionText.setText(R.string.rachgam_ques_8);
                        optionA.setText(R.string.rachgam_ques_8_a);
                        optionB.setText(R.string.rachgam_ques_8_b);
                        optionC.setText(R.string.rachgam_ques_8_c);
                        ans = getResources().getString(R.string.rachgam_ques_8_ans);
                        break;
                    case 9:
                        questionText.setText(R.string.rachgam_ques_9);
                        optionA.setText(R.string.rachgam_ques_9_a);
                        optionB.setText(R.string.rachgam_ques_9_b);
                        optionC.setText(R.string.rachgam_ques_9_c);
                        ans = getResources().getString(R.string.rachgam_ques_9_ans);
                        break;
                    case 10:
                        questionText.setText(R.string.rachgam_ques_10);
                        optionA.setText(R.string.rachgam_ques_10_a);
                        optionB.setText(R.string.rachgam_ques_10_b);
                        optionC.setText(R.string.rachgam_ques_10_c);
                        ans = getResources().getString(R.string.rachgam_ques_10_ans);
                        break;
                }
                break;
            case "ngochoi":
                switch (number) {
                    case 1:
                        questionText.setText(R.string.ngochoi_ques_1);
                        optionA.setText(R.string.ngochoi_ques_1_a);
                        optionB.setText(R.string.ngochoi_ques_1_b);
                        optionC.setText(R.string.ngochoi_ques_1_c);
                        ans = getResources().getString(R.string.ngochoi_ques_1_ans);
                        break;
                    case 2:
                        questionText.setText(R.string.ngochoi_ques_2);
                        optionA.setText(R.string.ngochoi_ques_2_a);
                        optionB.setText(R.string.ngochoi_ques_2_b);
                        optionC.setText(R.string.ngochoi_ques_2_c);
                        ans = getResources().getString(R.string.ngochoi_ques_2_ans);
                        break;
                    case 3:
                        questionText.setText(R.string.ngochoi_ques_3);
                        optionA.setText(R.string.ngochoi_ques_3_a);
                        optionB.setText(R.string.ngochoi_ques_3_b);
                        optionC.setText(R.string.ngochoi_ques_3_c);
                        ans = getResources().getString(R.string.ngochoi_ques_3_ans);
                        break;
                    case 4:
                        questionText.setText(R.string.ngochoi_ques_4);
                        optionA.setText(R.string.ngochoi_ques_4_a);
                        optionB.setText(R.string.ngochoi_ques_4_b);
                        optionC.setText(R.string.ngochoi_ques_4_c);
                        ans = getResources().getString(R.string.ngochoi_ques_4_ans);
                        break;
                    case 5:
                        questionText.setText(R.string.ngochoi_ques_5);
                        optionA.setText(R.string.ngochoi_ques_5_a);
                        optionB.setText(R.string.ngochoi_ques_5_b);
                        optionC.setText(R.string.ngochoi_ques_5_c);
                        ans = getResources().getString(R.string.ngochoi_ques_5_ans);
                        break;
                    case 6:
                        questionText.setText(R.string.ngochoi_ques_6);
                        optionA.setText(R.string.ngochoi_ques_6_a);
                        optionB.setText(R.string.ngochoi_ques_6_b);
                        optionC.setText(R.string.ngochoi_ques_6_c);
                        ans = getResources().getString(R.string.ngochoi_ques_6_ans);
                        break;
                    case 7:
                        questionText.setText(R.string.ngochoi_ques_7);
                        optionA.setText(R.string.ngochoi_ques_7_a);
                        optionB.setText(R.string.ngochoi_ques_7_b);
                        optionC.setText(R.string.ngochoi_ques_7_c);
                        ans = getResources().getString(R.string.ngochoi_ques_7_ans);
                        break;
                    case 8:
                        questionText.setText(R.string.ngochoi_ques_8);
                        optionA.setText(R.string.ngochoi_ques_8_a);
                        optionB.setText(R.string.ngochoi_ques_8_b);
                        optionC.setText(R.string.ngochoi_ques_8_c);
                        ans = getResources().getString(R.string.ngochoi_ques_8_ans);
                        break;
                    case 9:
                        questionText.setText(R.string.ngochoi_ques_9);
                        optionA.setText(R.string.ngochoi_ques_9_a);
                        optionB.setText(R.string.ngochoi_ques_9_b);
                        optionC.setText(R.string.ngochoi_ques_9_c);
                        ans = getResources().getString(R.string.ngochoi_ques_9_ans);
                        break;
                    case 10:
                        questionText.setText(R.string.ngochoi_ques_10);
                        optionA.setText(R.string.ngochoi_ques_10_a);
                        optionB.setText(R.string.ngochoi_ques_10_b);
                        optionC.setText(R.string.ngochoi_ques_10_c);
                        ans = getResources().getString(R.string.ngochoi_ques_10_ans);
                        break;
                }
                break;
            case "dienbienphu":
                switch (number) {
                    case 1:
                        questionText.setText(R.string.dienbienphu_ques_1);
                        optionA.setText(R.string.dienbienphu_ques_1_a);
                        optionB.setText(R.string.dienbienphu_ques_1_b);
                        optionC.setText(R.string.dienbienphu_ques_1_c);
                        ans = getResources().getString(R.string.dienbienphu_ques_1_ans);
                        break;
                    case 2:
                        questionText.setText(R.string.dienbienphu_ques_2);
                        optionA.setText(R.string.dienbienphu_ques_2_a);
                        optionB.setText(R.string.dienbienphu_ques_2_b);
                        optionC.setText(R.string.dienbienphu_ques_2_c);
                        ans = getResources().getString(R.string.dienbienphu_ques_2_ans);
                        break;
                    case 3:
                        questionText.setText(R.string.dienbienphu_ques_3);
                        optionA.setText(R.string.dienbienphu_ques_3_a);
                        optionB.setText(R.string.dienbienphu_ques_3_b);
                        optionC.setText(R.string.dienbienphu_ques_3_c);
                        ans = getResources().getString(R.string.dienbienphu_ques_3_ans);
                        break;
                    case 4:
                        questionText.setText(R.string.dienbienphu_ques_4);
                        optionA.setText(R.string.dienbienphu_ques_4_a);
                        optionB.setText(R.string.dienbienphu_ques_4_b);
                        optionC.setText(R.string.dienbienphu_ques_4_c);
                        ans = getResources().getString(R.string.dienbienphu_ques_4_ans);
                        break;
                    case 5:
                        questionText.setText(R.string.dienbienphu_ques_5);
                        optionA.setText(R.string.dienbienphu_ques_5_a);
                        optionB.setText(R.string.dienbienphu_ques_5_b);
                        optionC.setText(R.string.dienbienphu_ques_5_c);
                        ans = getResources().getString(R.string.dienbienphu_ques_5_ans);
                        break;
                    case 6:
                        questionText.setText(R.string.dienbienphu_ques_6);
                        optionA.setText(R.string.dienbienphu_ques_6_a);
                        optionB.setText(R.string.dienbienphu_ques_6_b);
                        optionC.setText(R.string.dienbienphu_ques_6_c);
                        ans = getResources().getString(R.string.dienbienphu_ques_6_ans);
                        break;
                    case 7:
                        questionText.setText(R.string.dienbienphu_ques_7);
                        optionA.setText(R.string.dienbienphu_ques_7_a);
                        optionB.setText(R.string.dienbienphu_ques_7_b);
                        optionC.setText(R.string.dienbienphu_ques_7_c);
                        ans = getResources().getString(R.string.dienbienphu_ques_7_ans);
                        break;
                    case 8:
                        questionText.setText(R.string.dienbienphu_ques_8);
                        optionA.setText(R.string.dienbienphu_ques_8_a);
                        optionB.setText(R.string.dienbienphu_ques_8_b);
                        optionC.setText(R.string.dienbienphu_ques_8_c);
                        ans = getResources().getString(R.string.dienbienphu_ques_8_ans);
                        break;
                    case 9:
                        questionText.setText(R.string.dienbienphu_ques_9);
                        optionA.setText(R.string.dienbienphu_ques_9_a);
                        optionB.setText(R.string.dienbienphu_ques_9_b);
                        optionC.setText(R.string.dienbienphu_ques_9_c);
                        ans = getResources().getString(R.string.dienbienphu_ques_9_ans);
                        break;
                    case 10:
                        questionText.setText(R.string.dienbienphu_ques_10);
                        optionA.setText(R.string.dienbienphu_ques_10_a);
                        optionB.setText(R.string.dienbienphu_ques_10_b);
                        optionC.setText(R.string.dienbienphu_ques_10_c);
                        ans = getResources().getString(R.string.dienbienphu_ques_10_ans);
                        break;
                }
                break;
            case "dienbienphutrenkhong":
                switch (number) {
                    case 1:
                        questionText.setText(R.string.dienbienphutrenkhong_ques_1);
                        optionA.setText(R.string.dienbienphutrenkhong_ques_1_a);
                        optionB.setText(R.string.dienbienphutrenkhong_ques_1_b);
                        optionC.setText(R.string.dienbienphutrenkhong_ques_1_c);
                        ans = getResources().getString(R.string.dienbienphutrenkhong_ques_1_ans);
                        break;
                    case 2:
                        questionText.setText(R.string.dienbienphutrenkhong_ques_2);
                        optionA.setText(R.string.dienbienphutrenkhong_ques_2_a);
                        optionB.setText(R.string.dienbienphutrenkhong_ques_2_b);
                        optionC.setText(R.string.dienbienphutrenkhong_ques_2_c);
                        ans = getResources().getString(R.string.dienbienphutrenkhong_ques_2_ans);
                        break;
                    case 3:
                        questionText.setText(R.string.dienbienphutrenkhong_ques_3);
                        optionA.setText(R.string.dienbienphutrenkhong_ques_3_a);
                        optionB.setText(R.string.dienbienphutrenkhong_ques_3_b);
                        optionC.setText(R.string.dienbienphutrenkhong_ques_3_c);
                        ans = getResources().getString(R.string.dienbienphutrenkhong_ques_3_ans);
                        break;
                    case 4:
                        questionText.setText(R.string.dienbienphutrenkhong_ques_4);
                        optionA.setText(R.string.dienbienphutrenkhong_ques_4_a);
                        optionB.setText(R.string.dienbienphutrenkhong_ques_4_b);
                        optionC.setText(R.string.dienbienphutrenkhong_ques_4_c);
                        ans = getResources().getString(R.string.dienbienphutrenkhong_ques_4_ans);
                        break;
                    case 5:
                        questionText.setText(R.string.dienbienphutrenkhong_ques_5);
                        optionA.setText(R.string.dienbienphutrenkhong_ques_5_a);
                        optionB.setText(R.string.dienbienphutrenkhong_ques_5_b);
                        optionC.setText(R.string.dienbienphutrenkhong_ques_5_c);
                        ans = getResources().getString(R.string.dienbienphutrenkhong_ques_5_ans);
                        break;
                    case 6:
                        questionText.setText(R.string.dienbienphutrenkhong_ques_6);
                        optionA.setText(R.string.dienbienphutrenkhong_ques_6_a);
                        optionB.setText(R.string.dienbienphutrenkhong_ques_6_b);
                        optionC.setText(R.string.dienbienphutrenkhong_ques_6_c);
                        ans = getResources().getString(R.string.dienbienphutrenkhong_ques_6_ans);
                        break;
                    case 7:
                        questionText.setText(R.string.dienbienphutrenkhong_ques_7);
                        optionA.setText(R.string.dienbienphutrenkhong_ques_7_a);
                        optionB.setText(R.string.dienbienphutrenkhong_ques_7_b);
                        optionC.setText(R.string.dienbienphutrenkhong_ques_7_c);
                        ans = getResources().getString(R.string.dienbienphutrenkhong_ques_7_ans);
                        break;
                    case 8:
                        questionText.setText(R.string.dienbienphutrenkhong_ques_8);
                        optionA.setText(R.string.dienbienphutrenkhong_ques_8_a);
                        optionB.setText(R.string.dienbienphutrenkhong_ques_8_b);
                        optionC.setText(R.string.dienbienphutrenkhong_ques_8_c);
                        ans = getResources().getString(R.string.dienbienphutrenkhong_ques_8_ans);
                        break;
                    case 9:
                        questionText.setText(R.string.dienbienphutrenkhong_ques_9);
                        optionA.setText(R.string.dienbienphutrenkhong_ques_9_a);
                        optionB.setText(R.string.dienbienphutrenkhong_ques_9_b);
                        optionC.setText(R.string.dienbienphutrenkhong_ques_9_c);
                        ans = getResources().getString(R.string.dienbienphutrenkhong_ques_9_ans);
                        break;
                    case 10:
                        questionText.setText(R.string.dienbienphutrenkhong_ques_10);
                        optionA.setText(R.string.dienbienphutrenkhong_ques_10_a);
                        optionB.setText(R.string.dienbienphutrenkhong_ques_10_b);
                        optionC.setText(R.string.dienbienphutrenkhong_ques_10_c);
                        ans = getResources().getString(R.string.dienbienphutrenkhong_ques_10_ans);
                        break;
                }
                break;
            case "chiendichHCM":
                switch (number) {
                    case 1:
                        questionText.setText(R.string.chiendichHCM_ques_1);
                        optionA.setText(R.string.chiendichHCM_ques_1_a);
                        optionB.setText(R.string.chiendichHCM_ques_1_b);
                        optionC.setText(R.string.chiendichHCM_ques_1_c);
                        ans = getResources().getString(R.string.chiendichHCM_ques_1_ans);
                        break;
                    case 2:
                        questionText.setText(R.string.chiendichHCM_ques_2);
                        optionA.setText(R.string.chiendichHCM_ques_2_a);
                        optionB.setText(R.string.chiendichHCM_ques_2_b);
                        optionC.setText(R.string.chiendichHCM_ques_2_c);
                        ans = getResources().getString(R.string.chiendichHCM_ques_2_ans);
                        break;
                    case 3:
                        questionText.setText(R.string.chiendichHCM_ques_3);
                        optionA.setText(R.string.chiendichHCM_ques_3_a);
                        optionB.setText(R.string.chiendichHCM_ques_3_b);
                        optionC.setText(R.string.chiendichHCM_ques_3_c);
                        ans = getResources().getString(R.string.chiendichHCM_ques_3_ans);
                        break;
                    case 4:
                        questionText.setText(R.string.chiendichHCM_ques_4);
                        optionA.setText(R.string.chiendichHCM_ques_4_a);
                        optionB.setText(R.string.chiendichHCM_ques_4_b);
                        optionC.setText(R.string.chiendichHCM_ques_4_c);
                        ans = getResources().getString(R.string.chiendichHCM_ques_4_ans);
                        break;
                    case 5:
                        questionText.setText(R.string.chiendichHCM_ques_5);
                        optionA.setText(R.string.chiendichHCM_ques_5_a);
                        optionB.setText(R.string.chiendichHCM_ques_5_b);
                        optionC.setText(R.string.chiendichHCM_ques_5_c);
                        ans = getResources().getString(R.string.chiendichHCM_ques_5_ans);
                        break;
                    case 6:
                        questionText.setText(R.string.chiendichHCM_ques_6);
                        optionA.setText(R.string.chiendichHCM_ques_6_a);
                        optionB.setText(R.string.chiendichHCM_ques_6_b);
                        optionC.setText(R.string.chiendichHCM_ques_6_c);
                        ans = getResources().getString(R.string.chiendichHCM_ques_6_ans);
                        break;
                    case 7:
                        questionText.setText(R.string.chiendichHCM_ques_7);
                        optionA.setText(R.string.chiendichHCM_ques_7_a);
                        optionB.setText(R.string.chiendichHCM_ques_7_b);
                        optionC.setText(R.string.chiendichHCM_ques_7_c);
                        ans = getResources().getString(R.string.chiendichHCM_ques_7_ans);
                        break;
                    case 8:
                        questionText.setText(R.string.chiendichHCM_ques_8);
                        optionA.setText(R.string.chiendichHCM_ques_8_a);
                        optionB.setText(R.string.chiendichHCM_ques_8_b);
                        optionC.setText(R.string.chiendichHCM_ques_8_c);
                        ans = getResources().getString(R.string.chiendichHCM_ques_8_ans);
                        break;
                    case 9:
                        questionText.setText(R.string.chiendichHCM_ques_9);
                        optionA.setText(R.string.chiendichHCM_ques_9_a);
                        optionB.setText(R.string.chiendichHCM_ques_9_b);
                        optionC.setText(R.string.chiendichHCM_ques_9_c);
                        ans = getResources().getString(R.string.chiendichHCM_ques_9_ans);
                        break;
                    case 10:
                        questionText.setText(R.string.chiendichHCM_ques_10);
                        optionA.setText(R.string.chiendichHCM_ques_10_a);
                        optionB.setText(R.string.chiendichHCM_ques_10_b);
                        optionC.setText(R.string.chiendichHCM_ques_10_c);
                        ans = getResources().getString(R.string.chiendichHCM_ques_10_ans);
                        break;
                }
                break;
        }
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number < 10) {
                    activity.nextQuestion(number + 1);
                } else  {
                    activity.showResult();
                }

            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.option1Btn) {
            verify(optionA);
        } else if (v.getId() == R.id.option2Btn) {
            verify(optionB);
        } else if (v.getId() == R.id.option3Btn) {
            verify(optionC);
        }
    }
    public void showNextButton() {
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void verify(AppCompatButton option) {
        if (canAnswer) {
            if (option.getText().equals(ans)) {
                option.setBackgroundResource(R.drawable.custom_button_correct);
                feedback.setText("Bạn đã trả lời đúng!");
                feedback.setVisibility(View.VISIBLE);
                feedback.setTextColor(getResources().getColor(R.color.green));
                activity.increaseCorrect();
            } else {
                option.setBackgroundResource(R.drawable.custom_button_wrong);
                feedback.setText("Bạn đã trả lời sai!");
                feedback.setVisibility(View.VISIBLE);
                feedback.setTextColor(getResources().getColor(R.color.red));
                activity.increaseWrong();
                if (ans.equals(optionC.getText())) {
                    optionC.setBackgroundResource(R.drawable.custom_button_correct);
                } else if (ans.equals(optionA.getText())) {
                    optionA.setBackgroundResource(R.drawable.custom_button_correct);
                } else if (ans.equals(optionB.getText())) {
                    optionB.setBackgroundResource(R.drawable.custom_button_correct);
                }
            }

            canAnswer = false;
            showNextButton();
        }

    }

}