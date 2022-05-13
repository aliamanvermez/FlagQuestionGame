package com.example.flagquestiongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewTrue, textViewFalse, textViewQuestion;
    private ImageView imageViewFlag;
    private Button buttonA,buttonB,buttonC,buttonD;
    private ArrayList<Flags>sorularListe;
    private ArrayList<Flags>yanlisSeceneklerListe;
    private Flags dogruSoru;
    private Database db;

    private int soruSayac = 0;
    private int dogruSayac = 0;
    private int yanlisSayac = 0;

    private HashSet<Flags>siklariKaristir = new HashSet<>();

    private ArrayList<Flags> siklarList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewTrue = (TextView) findViewById(R.id.textViewTrue);

        textViewFalse = (TextView) findViewById(R.id.textViewFalse);

        imageViewFlag = (ImageView) findViewById(R.id.imageViewFlag);

        buttonA = (Button) findViewById(R.id.buttonA);

        buttonB = (Button) findViewById(R.id.buttonB);

        buttonC = (Button) findViewById(R.id.buttonC);

        buttonD = (Button) findViewById(R.id.buttonD);

        db = new Database(this);

        sorularListe = new FlagsDao().random5(db);

        soruYukle();


        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dogruKontrol(buttonA);
                sayacKontrol();
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dogruKontrol(buttonB);
                sayacKontrol();
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dogruKontrol(buttonC);
                sayacKontrol();
            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dogruKontrol(buttonD);
                sayacKontrol();
            }
        });


    }

    public void soruYukle(){

        textViewQuestion.setText((soruSayac+1)+". QUESTION");


        dogruSoru = sorularListe.get(soruSayac);
        yanlisSeceneklerListe = new FlagsDao().random3(db,dogruSoru.getFlag_id());

        imageViewFlag.setImageResource(getResources().getIdentifier(dogruSoru.getFlag_image(),"drawable",getPackageName()));

        siklarList.clear();

        siklarList.add(dogruSoru);
        siklarList.add(yanlisSeceneklerListe.get(0));
        siklarList.add(yanlisSeceneklerListe.get(1));
        siklarList.add(yanlisSeceneklerListe.get(2));

        siklarList.clear();

        textViewTrue.setText("True : "+dogruSayac);
        textViewFalse.setText("False : "+yanlisSayac);


        for(Flags f:siklarList){
            siklarList.add(f);
        }
        buttonA.setText(siklarList.get(0).getFlag_name());
        buttonB.setText(siklarList.get(1).getFlag_name());
        buttonC.setText(siklarList.get(2).getFlag_name());
        buttonD.setText(siklarList.get(3).getFlag_name());

    }
    
    public void dogruKontrol (Button button) {
        String buttonYazi = button.getText().toString();
        String dogruCevap = dogruSoru.getFlag_name();
        if(buttonYazi.equals(dogruCevap)){
            dogruSayac++;
        }else {
            yanlisSayac++;
        }


    }
    public void sayacKontrol () {
        soruSayac++;
        if ( soruSayac != 5 ) {
            soruYukle();
        }else {
            Intent intent = new Intent(QuizActivity.this,ResultActivity.class);
            intent.putExtra("dogruSayac",dogruSayac);
            startActivity(intent);
            finish();


        }
    }
}




























