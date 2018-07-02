package com.example.rijke.itt_v1;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final TextView TextViewWelcomeMessage = (TextView) findViewById(R.id.begruessung);
        final TextView TextViewIDreisender = (TextView) findViewById(R.id.tvIDreisender);


        Intent intent = getIntent();
        final String Vorname = intent.getStringExtra("Vorname");
        final String EMail = intent.getStringExtra("EMail");
//        int IDreisender = intent.getIntExtra("IDreisender", -1);

        String nachricht =  Vorname + "!";
        TextViewWelcomeMessage.setText(nachricht);
        TextViewIDreisender.setText(EMail);




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


                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                String EMail = jsonResponse.getString("EMail");
                                String Vorname = jsonResponse.getString("Vorname");
                                String Nachname = jsonResponse.getString("Nachname");
                                String Geburtsdatum = jsonResponse.getString("Geburtsdatum");

                                Intent intent = new Intent(Start.this, Userarea.class);
                                intent.putExtra("Vorname", Vorname);
                                intent.putExtra("EMail", EMail);
                                intent.putExtra("Nachname", Nachname);
                                intent.putExtra("Geburtsdatum", Geburtsdatum);


                                Start.this.startActivity(intent);


                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Start.this);
                                builder.setMessage("Datenabruf fehlgeschlagen")
                                        .setNegativeButton("Wiederholen",null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                DatenRequest datenRequest = new DatenRequest(EMail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Start.this);
                queue.add(datenRequest);


            }
        });

        final Button buttonHistorie=(Button)findViewById(R.id.btnHistorie);
        buttonHistorie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                String EMail = jsonResponse.getString("EMail");
                                String Vorname = jsonResponse.getString("Vorname");
                                String Nachname = jsonResponse.getString("Nachname");
                                String Geburtsdatum = jsonResponse.getString("Geburtsdatum");

                                Intent intent = new Intent(Start.this, Historie.class);
                                intent.putExtra("Vorname", Vorname);
                                intent.putExtra("EMail", EMail);
                                intent.putExtra("Nachname", Nachname);
                                intent.putExtra("Geburtsdatum", Geburtsdatum);


                                Start.this.startActivity(intent);


                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Start.this);
                                builder.setMessage("Datenabruf fehlgeschlagen")
                                        .setNegativeButton("Wiederholen",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                DatenRequest datenRequest = new DatenRequest(EMail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Start.this);
                queue.add(datenRequest);

            }
        });

        final Button buttonSocial=(Button)findViewById(R.id.btnSocial);
        buttonSocial.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                @Override
                public void onResponse(String response){
                     try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                             if(success){
                                String EMail = jsonResponse.getString("EMail");
                                String Vorname = jsonResponse.getString("Vorname");
                                String Nachname = jsonResponse.getString("Nachname");
                                String Geburtsdatum = jsonResponse.getString("Geburtsdatum");

                                Intent intent = new Intent(Start.this, Social.class);
                                intent.putExtra("Vorname", Vorname);
                                intent.putExtra("EMail", EMail);
                                intent.putExtra("Nachname", Nachname);
                                intent.putExtra("Geburtsdatum", Geburtsdatum);


                                Start.this.startActivity(intent);


                             }else{
                                 AlertDialog.Builder builder = new AlertDialog.Builder(Start.this);
                                 builder.setMessage("Datenabruf fehlgeschlagen")
                                    .setNegativeButton("Wiederholen",null)
                                    .create()
                                    .show();
                        }
                     } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
                DatenRequest datenRequest = new DatenRequest(EMail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Start.this);
                queue.add(datenRequest);


            }
        });


    }
}
