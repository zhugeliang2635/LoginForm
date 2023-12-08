package com.example.maphistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class QuizActivity extends AppCompatActivity {
    private String name;
    private int correct;
    private int wrong;


    public void increaseCorrect() {
        correct++;
    }
    public void increaseWrong() {
        wrong++;
    }

    public int getCorrect() {
        return correct;
    }

    public int getWrong() {
        return wrong;
    }

    public String getName() {
        return this.name;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        correct = 0;
        wrong = 0;
        Bundle args = getIntent().getExtras();
        if (args != null) {
            name = args.getString("event");
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.quiz_activity, new QuizDetail2Fragment());
        fragmentTransaction.commit();
    }

    public void nextQuestion(int questionNum) {
        if (questionNum <= 10) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            QuizFragment quizFragment = new QuizFragment( questionNum);
            transaction.replace(R.id.quiz_activity, quizFragment);
            transaction.commit();
        }

    }

    public void showResult() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ResultFragment resultFragment = new ResultFragment();
        transaction.replace(R.id.quiz_activity, resultFragment);
        transaction.commit();
    }

    public void goHome() {
        finish();
    }
}