package com.example.maphistory;

import android.content.Context;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment {

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

    private TextView questionVal;
    private Button optionA;
    private Button optionB;
    private Button optionC;
    private Button nextQuestion;
    private int number;
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
        optionA = view.findViewById(R.id.option1Btn);
        optionB = view.findViewById(R.id.option2Btn);
        optionC = view.findViewById(R.id.option3Btn);

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        questionVal = view.findViewById(R.id.quizQuestionsCount);
        questionVal.setText(Integer.toString(number));
        nextQuestion = view.findViewById(R.id.nextQueBtn);
        questionText = view.findViewById(R.id.quizQuestionTv);
        switch (activity.getName()) {
            case "bachdang":
                if (number == 1) {
                    questionText.setText(R.string.bachdang_ques_1);
                    optionA.setText(R.string.bachdang_ques_1_a);
                    optionB.setText(R.string.bachdang_ques_1_b);
                    optionC.setText(R.string.bachdang_ques_1_c);
                    ans = getResources().getString(R.string.bachdang_ques_1_ans);
                }
        }


        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.nextQuestion(number + 1);
            }
        });
        return view;
    }

    public void verify(Button option) {
        if (option.getText().equals(ans)) {
            option.setBackground(ContextCompat.getDrawable(getContext(), R.color.green));
        }
    }

}