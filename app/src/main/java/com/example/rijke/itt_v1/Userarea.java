package com.example.rijke.itt_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Userarea extends AppCompatActivity {
        private Button button;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_userarea);

            //Funktionen zum Hin- und Herwechseln zwischen den Seiten
            final Button buttonStart=(Button)findViewById(R.id.btnStart);
            buttonStart.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent StartIntent = new Intent(Userarea.this, Start.class);
                    Userarea.this.startActivity(StartIntent);
                }
            });

            final Button buttonProfil=(Button)findViewById(R.id.btnProfil);
            buttonProfil.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent ProfilIntent = new Intent(Userarea.this, Userarea.class);
                    Userarea.this.startActivity(ProfilIntent);
                }
            });

            final Button buttonHistorie=(Button)findViewById(R.id.btnHistorie);
            buttonHistorie.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent HistorieIntent = new Intent(Userarea.this, Historie.class);
                    Userarea.this.startActivity(HistorieIntent);
                }
            });

            final Button buttonSocial=(Button)findViewById(R.id.btnSocial);
            buttonSocial.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent SocialIntent = new Intent(Userarea.this, Social.class);
                    Userarea.this.startActivity(SocialIntent);
                }
            });

//            Definition of Textfields, will be filled with information later

            final TextView etName = (TextView) findViewById(R.id.etName);
            final TextView etFName = (TextView) findViewById(R.id.editTextFName);
            final TextView tvWelcome = (TextView) findViewById(R.id.tvWelcome);

            Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Userarea.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Interessen));
            myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mySpinner.setAdapter(myAdapter);



            button = (Button) findViewById(R.id.buttonBack);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openRegistrierdaten();
                }
            });



//        Get information from LogIn and pass over to Main Area
            Intent intent = getIntent();
            String Nachname = intent.getStringExtra("Nachname");
            String Vorname = intent.getStringExtra("Vorname");


//       Display information
            etName.setText(Nachname);
            etFName.setText(Vorname);
            String message = Nachname + "welcome!";
            tvWelcome.setText(message);




        }
        public void openRegistrierdaten() {
            Intent intent = new Intent(Userarea.this, Userdaten.class);
            startActivity(intent);
        }
    }





