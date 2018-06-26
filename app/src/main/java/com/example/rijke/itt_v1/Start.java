package com.example.rijke.itt_v1;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final TextView TextViewWelcomeMessage = (TextView) findViewById(R.id.begruessung);


        Intent intent = getIntent();
        String Vorname = intent.getStringExtra("Vorname");

        String nachricht = "Hallo " + Vorname + "!";
        TextViewWelcomeMessage.setText(nachricht);

        //Funktionen zum Hin- und Herwechseln zwischen den Seiten
        final Button buttonStart=(Button)findViewById(R.id.btnStart);
        buttonStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent StartIntent = new Intent(Start.this, Start.class);
                Start.this.startActivity(StartIntent);
            }
        });

        final Button buttonProfil=(Button)findViewById(R.id.btnProfil);
        buttonProfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent ProfilIntent = new Intent(Start.this, Userarea.class);
                Start.this.startActivity(ProfilIntent);
            }
        });

        final Button buttonHistorie=(Button)findViewById(R.id.btnHistorie);
        buttonHistorie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent HistorieIntent = new Intent(Start.this, Historie.class);
                Start.this.startActivity(HistorieIntent);
            }
        });

        final Button buttonSocial=(Button)findViewById(R.id.btnSocial);
        buttonSocial.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent SocialIntent = new Intent(Start.this, Social.class);
                Start.this.startActivity(SocialIntent);
            }
        });
    }
}
