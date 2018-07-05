package com.example.rijke.itt_v1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.CodeSigner;

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


        String nachricht =  Vorname + ", deine Aktivitäten!";
        tvUeberschrift.setText(nachricht);
        tvIDreisender.setText(IDreisender + "");

        //Funktionen zum Hin- und Herwechseln zwischen den Seiten
        final Button buttonStart=(Button)findViewById(R.id.btnStart);
        buttonStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final int IDreisender = Integer.parseInt(tvIDreisender.getText().toString());


                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                                String Vorname = jsonResponse.getString("Vorname");
                                String Nachname = jsonResponse.getString("Nachname");
                                String Geburtsdatum = jsonResponse.getString("Geburtsdatum");
                                String Geburtsort = jsonResponse.getString("Geburtsort");
                                String Handynummer = jsonResponse.getString("Handynummer");
                                String EMail = jsonResponse.getString("EMail");
                                String Personalausweisnummer = jsonResponse.getString("Personalausweisnummer");
                                String Passwort = jsonResponse.getString("Passwort");
                                int IDreisender = jsonResponse.getInt("IDreisender");


                                Intent intent = new Intent(Social.this, Start.class);
                                intent.putExtra("Vorname", Vorname);
                                intent.putExtra("Nachname", Nachname);
                                intent.putExtra("Geburtsdatum", Geburtsdatum);
                                intent.putExtra("Geburtsort", Geburtsort);
                                intent.putExtra("Handynummer", Handynummer);
                                intent.putExtra("EMail", EMail);
                                intent.putExtra("Personalausweisnummer", Personalausweisnummer);
                                intent.putExtra("Passwort", Passwort);
                                intent.putExtra("IDreisender", IDreisender);


                                Social.this.startActivity(intent);


                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Social.this);
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
                DatenRequest datenRequest = new DatenRequest(IDreisender, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Social.this);
                queue.add(datenRequest);

            }
        });


        final Button buttonProfil=(Button)findViewById(R.id.btnProfil);
        buttonProfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final int IDreisender = Integer.parseInt(tvIDreisender.getText().toString());


                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                                String Vorname = jsonResponse.getString("Vorname");
                                String Nachname = jsonResponse.getString("Nachname");
                                String Geburtsdatum = jsonResponse.getString("Geburtsdatum");
                                String Geburtsort = jsonResponse.getString("Geburtsort");
                                String Handynummer = jsonResponse.getString("Handynummer");
                                String EMail = jsonResponse.getString("EMail");
                                String Personalausweisnummer = jsonResponse.getString("Personalausweisnummer");
                                String Passwort = jsonResponse.getString("Passwort");
                                int IDreisender = jsonResponse.getInt("IDreisender");


                                Intent intent = new Intent(Social.this, Userarea.class);
                                intent.putExtra("Vorname", Vorname);
                                intent.putExtra("Nachname", Nachname);
                                intent.putExtra("Geburtsdatum", Geburtsdatum);
                                intent.putExtra("Geburtsort", Geburtsort);
                                intent.putExtra("Handynummer", Handynummer);
                                intent.putExtra("EMail", EMail);
                                intent.putExtra("Personalausweisnummer", Personalausweisnummer);
                                intent.putExtra("Passwort", Passwort);
                                intent.putExtra("IDreisender", IDreisender);


                                Social.this.startActivity(intent);


                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Social.this);
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
                DatenRequest datenRequest = new DatenRequest(IDreisender, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Social.this);
                queue.add(datenRequest);

            }
        });

        final Button buttonHistorie=(Button)findViewById(R.id.btnHistorie);
        buttonHistorie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final int IDreisender = Integer.parseInt(tvIDreisender.getText().toString());


                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                                String Vorname = jsonResponse.getString("Vorname");
                                String Nachname = jsonResponse.getString("Nachname");
                                String Geburtsdatum = jsonResponse.getString("Geburtsdatum");
                                String Geburtsort = jsonResponse.getString("Geburtsort");
                                String Handynummer = jsonResponse.getString("Handynummer");
                                String EMail = jsonResponse.getString("EMail");
                                String Personalausweisnummer = jsonResponse.getString("Personalausweisnummer");
                                String Passwort = jsonResponse.getString("Passwort");
                                int IDreisender = jsonResponse.getInt("IDreisender");


                                Intent intent = new Intent(Social.this, Historie.class);
                                intent.putExtra("Vorname", Vorname);
                                intent.putExtra("Nachname", Nachname);
                                intent.putExtra("Geburtsdatum", Geburtsdatum);
                                intent.putExtra("Geburtsort", Geburtsort);
                                intent.putExtra("Handynummer", Handynummer);
                                intent.putExtra("EMail", EMail);
                                intent.putExtra("Personalausweisnummer", Personalausweisnummer);
                                intent.putExtra("Passwort", Passwort);
                                intent.putExtra("IDreisender", IDreisender);



                                Social.this.startActivity(intent);


                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Social.this);
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
                DatenRequest datenRequest = new DatenRequest(IDreisender, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Social.this);
                queue.add(datenRequest);

            }
        });

        final Button buttonSocial=(Button)findViewById(R.id.btnSocial);
        buttonSocial.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final int IDreisender = Integer.parseInt(tvIDreisender.getText().toString());


                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                                String Vorname = jsonResponse.getString("Vorname");
                                String Nachname = jsonResponse.getString("Nachname");
                                String Geburtsdatum = jsonResponse.getString("Geburtsdatum");
                                String Geburtsort = jsonResponse.getString("Geburtsort");
                                String Handynummer = jsonResponse.getString("Handynummer");
                                String EMail = jsonResponse.getString("EMail");
                                String Personalausweisnummer = jsonResponse.getString("Personalausweisnummer");
                                String Passwort = jsonResponse.getString("Passwort");
                                int IDreisender = jsonResponse.getInt("IDreisender");


                                Intent intent = new Intent(Social.this, Social.class);
                                intent.putExtra("Vorname", Vorname);
                                intent.putExtra("Nachname", Nachname);
                                intent.putExtra("Geburtsdatum", Geburtsdatum);
                                intent.putExtra("Geburtsort", Geburtsort);
                                intent.putExtra("Handynummer", Handynummer);
                                intent.putExtra("EMail", EMail);
                                intent.putExtra("Personalausweisnummer", Personalausweisnummer);
                                intent.putExtra("Passwort", Passwort);
                                intent.putExtra("IDreisender", IDreisender);



                                Social.this.startActivity(intent);


                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Social.this);
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
                DatenRequest datenRequest = new DatenRequest(IDreisender, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Social.this);
                queue.add(datenRequest);
            }
        });


    }

    @Override
    public void onBackPressed() {
    }
}
