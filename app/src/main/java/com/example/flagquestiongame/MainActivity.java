package com.example.flagquestiongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.buttonStart);

        veritabaniKopyala();

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,QuizActivity.class));


            }
        });


    }
    public void veritabaniKopyala(){
        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);

        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        helper.openDataBase();
    }
}