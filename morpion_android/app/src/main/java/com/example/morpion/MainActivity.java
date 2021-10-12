package com.example.morpion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Button> listeBtn;
    private Morpion Lejeu;
    private int t=1;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        inittab();
        ecouteBtn();
        Lejeu = new Morpion();
        t=1;
    }

    @SuppressLint("ResourceType")
    public void inittab(){

        listeBtn= new ArrayList<>();
        listeBtn.add(findViewById(R.id.b00));
        listeBtn.add(findViewById(R.id.b01));
        listeBtn.add(findViewById(R.id.b02));
        listeBtn.add(findViewById(R.id.b10));
        listeBtn.add(findViewById(R.id.b11));
        listeBtn.add(findViewById(R.id.b12));
        listeBtn.add(findViewById(R.id.b20));
        listeBtn.add(findViewById(R.id.b21));
        listeBtn.add(findViewById(R.id.b22));

        for (Button unBtn: listeBtn){
            unBtn.setText(" ");
        }

        ((Button)findViewById(R.id.buttontxt)).setText("Nouvelle partie!");
        ((Button)findViewById(R.id.bR)).setText(" Recommencer ");
        ((Button)findViewById(R.id.bQ)).setText(" Quitter ");
    }

    public void ecouteBtn(){
        for (Button lebtn: listeBtn){
            lebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    s = lebtn.getTransitionName();

                    if (Lejeu.win() != 1 && Lejeu.win() != 2)  {
                        ((Button)findViewById(R.id.buttontxt)).setText("joueur suivant");

                        if (Lejeu.cochercase(s)) {
                            if (t % 2 == 1) {
                                lebtn.setText("X");
                            } else {
                                lebtn.setText("O");
                            }
                            t = t + 1;
                        } else {
                                ((Button) findViewById(R.id.buttontxt)).setText("case prise");
                        }
                    }
                    if (Lejeu.win() == 2) {
                        ((Button)findViewById(R.id.buttontxt)).setText("égalité");
                    }else{
                        if (Lejeu.win() == 1) {
                            ((Button)findViewById(R.id.buttontxt)).setText("victoire");
                        }
                    }

                }
            });
        }
        ((Button)findViewById(R.id.bR)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inittab();
                Lejeu.restart();
            }
        });

        ((Button)findViewById(R.id.bQ)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }




}