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

public class Historie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historie);

        final TextView tvUeberschrift = (TextView) findViewById(R.id.ueberschrift);
        final TextView tvIDreisender = (TextView) findViewById(R.id.tvIDreisender5);

        //Auswerten der Textfelder auf der Seite
        Intent intent = getIntent();
        final String Vorname = intent.getStringExtra("Vorname");
        int IDreisender = intent.getIntExtra("IDreisender", -1);

        //Setzen der pesonalisierten Überschrift
        String nachricht =  Vorname + ", deine Fahrten!";
        tvUeberschrift.setText(nachricht);
        tvIDreisender.setText(IDreisender + "");

        //Funktionen zum Hin- und Herwechseln zwischen den Seiten, sobald der jeweilige Button gedrückt wird
        final Button buttonStart=(Button)findViewById(R.id.btnStart);
        buttonStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Übergabe der ID zum Abruf der Daten aus der Datenbank
                final int IDreisender = Integer.parseInt(tvIDreisender.getText().toString());

                //Abruf der Daten aus der Datenbank mit Hilfe der php-Datei und der Aktivität DatenRequest
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            //Abfrage, ob Datenabruf durch die php-Datei erfolgreich war
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                //Abspeichern aller zurückgegebenen Nutzerdaten
                                String Vorname = jsonResponse.getString("Vorname");
                                String Nachname = jsonResponse.getString("Nachname");
                                String Geburtsdatum = jsonResponse.getString("Geburtsdatum");
                                String Geburtsort = jsonResponse.getString("Geburtsort");
                                String Handynummer = jsonResponse.getString("Handynummer");
                                String EMail = jsonResponse.getString("EMail");
                                String Personalausweisnummer = jsonResponse.getString("Personalausweisnummer");
                                String Passwort = jsonResponse.getString("Passwort");
                                int IDreisender = jsonResponse.getInt("IDreisender");

                                //Aufruf der neuen Aktivität (Start) und gleichzeitige Weitergabe der Nutzerdaten
                                Intent intent = new Intent(Historie.this, Start.class);
                                intent.putExtra("Vorname", Vorname);
                                intent.putExtra("Nachname", Nachname);
                                intent.putExtra("Geburtsdatum", Geburtsdatum);
                                intent.putExtra("Geburtsort", Geburtsort);
                                intent.putExtra("Handynummer", Handynummer);
                                intent.putExtra("EMail", EMail);
                                intent.putExtra("Personalausweisnummer", Personalausweisnummer);
                                intent.putExtra("Passwort", Passwort);
                                intent.putExtra("IDreisender", IDreisender);
                                Historie.this.startActivity(intent);


                            }else{
                                //Fehlermeldung, falls beim Datenabruf etwas nicht funktioniert (bsp. Fehler in  der php-Datei, keine Verbindung zum Server)
                                AlertDialog.Builder builder = new AlertDialog.Builder(Historie.this);
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
                //Aufforderung zum Aufruf der Aktitivät DatenRequest und Weitergabe der zur Abfrage benötigten Daten
                DatenRequest datenRequest = new DatenRequest(IDreisender, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Historie.this);
                queue.add(datenRequest);

            }
        });

        //Funktionen zum Hin- und Herwechseln zwischen den Seiten, sobald der jeweilige Button gedrückt wird
        final Button buttonProfil=(Button)findViewById(R.id.btnProfil);
        buttonProfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Übergabe der ID zum Abruf der Daten aus der Datenbank
                final int IDreisender = Integer.parseInt(tvIDreisender.getText().toString());

                //Abruf der Daten aus der Datenbank mit Hilfe der php-Datei und der Aktivität DatenRequest
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            //Abfrage, ob Datenabruf durch die php-Datei erfolgreich war
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                //Abspeichern aller zurückgegebenen Nutzerdaten
                                String Vorname = jsonResponse.getString("Vorname");
                                String Nachname = jsonResponse.getString("Nachname");
                                String Geburtsdatum = jsonResponse.getString("Geburtsdatum");
                                String Geburtsort = jsonResponse.getString("Geburtsort");
                                String Handynummer = jsonResponse.getString("Handynummer");
                                String EMail = jsonResponse.getString("EMail");
                                String Personalausweisnummer = jsonResponse.getString("Personalausweisnummer");
                                String Passwort = jsonResponse.getString("Passwort");
                                int IDreisender = jsonResponse.getInt("IDreisender");

                                //Aufruf der neuen Aktivität (Userarea) und gleichzeitige Weitergabe der Nutzerdaten
                                Intent intent = new Intent(Historie.this, Userarea.class);
                                intent.putExtra("Vorname", Vorname);
                                intent.putExtra("Nachname", Nachname);
                                intent.putExtra("Geburtsdatum", Geburtsdatum);
                                intent.putExtra("Geburtsort", Geburtsort);
                                intent.putExtra("Handynummer", Handynummer);
                                intent.putExtra("EMail", EMail);
                                intent.putExtra("Personalausweisnummer", Personalausweisnummer);
                                intent.putExtra("Passwort", Passwort);
                                intent.putExtra("IDreisender", IDreisender);
                                Historie.this.startActivity(intent);


                            }else{
                                //Fehlermeldung, falls beim Datenabruf etwas nicht funktioniert (bsp. Fehler in  der php-Datei, keine Verbindung zum Server)
                                AlertDialog.Builder builder = new AlertDialog.Builder(Historie.this);
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
                //Aufforderung zum Aufruf der Aktitivät DatenRequest und Weitergabe der zur Abfrage benötigten Daten
                DatenRequest datenRequest = new DatenRequest(IDreisender, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Historie.this);
                queue.add(datenRequest);

            }
        });

        //Funktionen zum Hin- und Herwechseln zwischen den Seiten, sobald der jeweilige Button gedrückt wird
        final Button buttonHistorie=(Button)findViewById(R.id.btnHistorie);
        buttonHistorie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Übergabe der ID zum Abruf der Daten aus der Datenbank
                final int IDreisender = Integer.parseInt(tvIDreisender.getText().toString());

                //Abruf der Daten aus der Datenbank mit Hilfe der php-Datei und der Aktivität DatenRequest
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            //Abfrage, ob Datenabruf durch die php-Datei erfolgreich war
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                //Abspeichern aller zurückgegebenen Nutzerdaten
                                String Vorname = jsonResponse.getString("Vorname");
                                String Nachname = jsonResponse.getString("Nachname");
                                String Geburtsdatum = jsonResponse.getString("Geburtsdatum");
                                String Geburtsort = jsonResponse.getString("Geburtsort");
                                String Handynummer = jsonResponse.getString("Handynummer");
                                String EMail = jsonResponse.getString("EMail");
                                String Personalausweisnummer = jsonResponse.getString("Personalausweisnummer");
                                String Passwort = jsonResponse.getString("Passwort");
                                int IDreisender = jsonResponse.getInt("IDreisender");

                                //Aufruf der neuen Aktivität (Historie) und gleichzeitige Weitergabe der Nutzerdaten
                                Intent intent = new Intent(Historie.this, Historie.class);
                                intent.putExtra("Vorname", Vorname);
                                intent.putExtra("Nachname", Nachname);
                                intent.putExtra("Geburtsdatum", Geburtsdatum);
                                intent.putExtra("Geburtsort", Geburtsort);
                                intent.putExtra("Handynummer", Handynummer);
                                intent.putExtra("EMail", EMail);
                                intent.putExtra("Personalausweisnummer", Personalausweisnummer);
                                intent.putExtra("Passwort", Passwort);
                                intent.putExtra("IDreisender", IDreisender);
                                Historie.this.startActivity(intent);


                            }else{
                                //Fehlermeldung, falls beim Datenabruf etwas nicht funktioniert (bsp. Fehler in  der php-Datei, keine Verbindung zum Server)
                                AlertDialog.Builder builder = new AlertDialog.Builder(Historie.this);
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
                //Aufforderung zum Aufruf der Aktitivät DatenRequest und Weitergabe der zur Abfrage benötigten Daten
                DatenRequest datenRequest = new DatenRequest(IDreisender, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Historie.this);
                queue.add(datenRequest);

            }
        });

        //Funktionen zum Hin- und Herwechseln zwischen den Seiten, sobald der jeweilige Button gedrückt wird
        final Button buttonSocial=(Button)findViewById(R.id.btnSocial);
        buttonSocial.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Übergabe der ID zum Abruf der Daten aus der Datenbank
                final int IDreisender = Integer.parseInt(tvIDreisender.getText().toString());

                //Abruf der Daten aus der Datenbank mit Hilfe der php-Datei und der Aktivität DatenRequest
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            //Abfrage, ob Datenabruf durch die php-Datei erfolgreich war
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                //Abspeichern aller zurückgegebenen Nutzerdaten
                                String Vorname = jsonResponse.getString("Vorname");
                                String Nachname = jsonResponse.getString("Nachname");
                                String Geburtsdatum = jsonResponse.getString("Geburtsdatum");
                                String Geburtsort = jsonResponse.getString("Geburtsort");
                                String Handynummer = jsonResponse.getString("Handynummer");
                                String EMail = jsonResponse.getString("EMail");
                                String Personalausweisnummer = jsonResponse.getString("Personalausweisnummer");
                                String Passwort = jsonResponse.getString("Passwort");
                                int IDreisender = jsonResponse.getInt("IDreisender");

                                //Aufruf der neuen Aktivität (Social) und gleichzeitige Weitergabe der Nutzerdaten
                                Intent intent = new Intent(Historie.this, Social.class);
                                intent.putExtra("Vorname", Vorname);
                                intent.putExtra("Nachname", Nachname);
                                intent.putExtra("Geburtsdatum", Geburtsdatum);
                                intent.putExtra("Geburtsort", Geburtsort);
                                intent.putExtra("Handynummer", Handynummer);
                                intent.putExtra("EMail", EMail);
                                intent.putExtra("Personalausweisnummer", Personalausweisnummer);
                                intent.putExtra("Passwort", Passwort);
                                intent.putExtra("IDreisender", IDreisender);
                                Historie.this.startActivity(intent);


                            }else{
                                //Fehlermeldung, falls beim Datenabruf etwas nicht funktioniert (bsp. Fehler in  der php-Datei, keine Verbindung zum Server)
                                AlertDialog.Builder builder = new AlertDialog.Builder(Historie.this);
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
                //Aufforderung zum Aufruf der Aktitivät DatenRequest und Weitergabe der zur Abfrage benötigten Daten
                DatenRequest datenRequest = new DatenRequest(IDreisender, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Historie.this);
                queue.add(datenRequest);
            }
        });
    }
    //Ausschalten der Zurück-Taste
    @Override
    public void onBackPressed() {
    }
}
