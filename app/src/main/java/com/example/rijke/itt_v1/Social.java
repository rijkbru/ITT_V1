package com.example.rijke.itt_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Social extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

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
}
