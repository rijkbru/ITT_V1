package com.example.rijke.itt_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Social extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        final TextView tvUeberschrift = (TextView) findViewById(R.id.ueberschriftAktivitaeten);
        final TextView tvIDreisender = (TextView) findViewById(R.id.tvIDreisender4);

        Intent intent = getIntent();
        final String Vorname = intent.getStringExtra("Vorname");
        final String EMail = intent.getStringExtra("EMail");
        int IDreisender = intent.getIntExtra("IDreisender", -1);


        String nachricht =  Vorname + " , deine Aktivitäten!";
        tvUeberschrift.setText(nachricht);
        tvIDreisender.setText(IDreisender + "");

        //Funktionen zum Hin- und Herwechseln zwischen den Seiten
        final Button buttonStart=(Button)findViewById(R.id.btnStart);
        buttonStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent StartIntent = new Intent(Social.this, Start.class);
                Social.this.startActivity(StartIntent);
            }
        });

        final Button buttonProfil=(Button)findViewById(R.id.btnProfil);
        buttonProfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent ProfilIntent = new Intent(Social.this, Userarea.class);
                Social.this.startActivity(ProfilIntent);
            }
        });

        final Button buttonHistorie=(Button)findViewById(R.id.btnHistorie);
        buttonHistorie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent HistorieIntent = new Intent(Social.this, Historie.class);
                Social.this.startActivity(HistorieIntent);
            }
        });

        final Button buttonSocial=(Button)findViewById(R.id.btnSocial);
        buttonSocial.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent SocialIntent = new Intent(Social.this, Social.class);
                Social.this.startActivity(SocialIntent);
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}
