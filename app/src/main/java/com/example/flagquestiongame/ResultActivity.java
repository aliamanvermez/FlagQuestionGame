package com.example.flagquestiongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private Button buttonTryAgain;
    private TextView textViewScore, textViewPercentScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        buttonTryAgain = (Button) findViewById(R.id.buttonTryAgain);

        textViewScore = (TextView) findViewById(R.id.textViewScore);

        textViewPercentScore = (TextView) findViewById(R.id.textViewPercentScore);

        buttonTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ResultActivity.this,QuizActivity.class));
                finish();

            }
        });




    }
}