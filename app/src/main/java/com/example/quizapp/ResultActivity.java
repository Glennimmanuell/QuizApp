package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    TextView scoreTextView, resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoreTextView = findViewById(R.id.scoreTextView);
        resultTextView = findViewById(R.id.resultTextView);

        Bundle extras = getIntent().getExtras();
        String info = extras.getString("info");
        Toast.makeText(getApplicationContext(), info, Toast.LENGTH_LONG).show();

        int score = getIntent().getIntExtra("score", 0);

        scoreTextView.setText("Your Score: " + score);

        if (score >= 3) {
            resultTextView.setText("Selamat yak!.");
            findViewById(R.id.resultLayout).setBackgroundColor(Color.BLUE);
        } else {
            resultTextView.setText("Maaf belum lulus");
            findViewById(R.id.resultLayout).setBackgroundColor(Color.RED);
        }
    }
}