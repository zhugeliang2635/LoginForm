package com.example.maphistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class QuizActivity extends AppCompatActivity {
    private String name;

    public String getName() {
        return this.name;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Bundle args = getIntent().getExtras();
        if (args != null) {
            name = args.getString("event");
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.quiz_activity, new QuizDetail2Fragment());
        fragmentTransaction.commit();
    }

    public void nextQuestion(int questionNum) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        QuizFragment quizFragment = new QuizFragment( questionNum);
        transaction.replace(R.id.quiz_activity, quizFragment);
        transaction.commit();

    }
}