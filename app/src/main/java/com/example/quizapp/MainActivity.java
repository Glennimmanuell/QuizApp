package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Question[] questionBank = new Question[] {
            new Question(R.string.q1, true),
            new Question(R.string.q2, true),
            new Question(R.string.q3, false),
            new Question(R.string.q4, true),
};
    private int current = 0;
    private TextView questions;
    private Button btnTrue, btnFalse, btnNext, btnResult;
    private int calculateScore() {
        int score = 0;
        for (Question setiapPertanyaan : questionBank) {
            if (setiapPertanyaan.isCorrectlyAnswered()) {
                score++;
            }
        }
        return score;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questions = findViewById(R.id.questions);
        btnTrue = findViewById(R.id.btnTrue);
        btnFalse = findViewById(R.id.btnFalse);
        btnNext = findViewById(R.id.btnNext);
        btnResult = findViewById(R.id.btnResult);

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkAnswer(true);
            }
        });
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkAnswer(false);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current = (current + 1);

                if (current >= questionBank.length) {
                    int score = calculateScore();
                    Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                    i.putExtra("info", "Info dari Main Activity");
                    i.putExtra("score", score);
                    startActivity(i);
                    return;
                }
                updateQuestion();
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int score = calculateScore();
                Intent i = new Intent(getApplicationContext(),ResultActivity.class);
                i.putExtra("info","Info dari Main Activity");
//                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.petra.ac.id"));
                i.putExtra("score", score);
                startActivity(i);
            }
        });
        updateQuestion();
        //Toast.makeText(getApplicationContext(), R.string.welcomme, Toast.LENGTH_LONG).show();

        //Toast.makeText(getApplicationContext(),questionBank[0].getResId(), Toast.LENGTH_SHORT).show();


    }

    private void updateQuestion() {
        findViewById(R.id.questionLayout).setBackgroundColor(Color.WHITE);
        int question = questionBank[current].getResId();
        questions.setText(question);
    }


    private void checkAnswer(boolean ngecek) {
        boolean trueAnswer = questionBank[current].getAnswer();
        if (trueAnswer == ngecek) {
            Toast.makeText(getApplicationContext(), R.string.resTrue, Toast.LENGTH_LONG).show();
            questionBank[current].setCorrectlyAnswered(true);
            findViewById(R.id.questionLayout).setBackgroundColor(Color.GREEN);
        } else {
            Toast.makeText(getApplicationContext(), R.string.resFalse, Toast.LENGTH_LONG).show();
            questionBank[current].setCorrectlyAnswered(false);
            findViewById(R.id.questionLayout).setBackgroundColor(Color.RED);
        }
    }

}