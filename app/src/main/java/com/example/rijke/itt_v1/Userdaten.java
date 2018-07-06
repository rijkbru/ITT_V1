package com.example.rijke.itt_v1;


import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Userdaten extends AppCompatActivity {
    private Button buttonReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdaten);

        // Definition der Textfelder
        final EditText EtHandynummer = (EditText) findViewById(R.id.editTextHandynummer);
        final EditText EtEmail = (EditText) findViewById(R.id.editTextEmail);
        final EditText EtPersonummer = (EditText) findViewById(R.id.editTextPersonummer);
        final EditText EtPassword = (EditText) findViewById(R.id.editTextPasswort);
        final EditText EtPasswortWH = (EditText) findViewById(R.id.editTextPasswortWH);
        final TextView TextViewWelcomeMessage = (TextView) findViewById(R.id.textView_Registrierung);
        final EditText EtFirstname = (EditText) findViewById(R.id.editTextFName);
        final EditText EtLastname = (EditText) findViewById(R.id.editTextLName);
        final EditText EtGeburtstag = (EditText) findViewById(R.id.editTextGeburtsdatum);
        final EditText EtGeburtsort = (EditText) findViewById(R.id. editTextGeburtsort);
        final TextView tvIDreisender = (TextView) findViewById(R.id.tvIDreisender3);

        //Auswerten der Textfelder auf der Seite
        Intent intent = getIntent();
        String Vorname = intent.getStringExtra("Vorname");
        String Nachname = intent.getStringExtra("Nachname");
        String EMail = intent.getStringExtra("EMail");
        String Geburtsdatum = intent.getStringExtra("Geburtsdatum");
        String Geburtsort = intent.getStringExtra("Geburtsort");
        String Handynummer = intent.getStringExtra("Handynummer");
        String Personalausweisnummer = intent.getStringExtra("Personalausweisnummer");
        String Passwort = intent.getStringExtra("Passwort");
        int IDreisender = intent.getIntExtra("IDreisender", -1);

        //Setzen der pesonalisierten Überschrift unf füllen der Felder mit Daten des Reisenden
        EtFirstname.setText(Vorname);
        EtLastname.setText(Nachname);
        EtGeburtstag.setText(Geburtsdatum);
        EtGeburtsort.setText(Geburtsort);
        EtHandynummer.setText(Handynummer);
        EtPersonummer.setText(Personalausweisnummer);
        EtPassword.setText(Passwort);
        EtPasswortWH.setText(Passwort);

        tvIDreisender.setText(IDreisender + "");
        String nachricht = Vorname + ", deine persönlichen Daten!" ;
        TextViewWelcomeMessage.setText(nachricht);
        EtEmail.setText(EMail);






        //Funktionen zum Hin- und Herwechseln zwischen den Seiten, sobald der jeweilige Button gedrückt wird
        buttonReg = (Button) findViewById(R.id.buttonBack);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Übergabe der Daten and die PHP-Datei
                final int IDreisender = Integer.parseInt(tvIDreisender.getText().toString());
                final String EMail = EtEmail.getText().toString();
                final String Vorname = EtFirstname.getText().toString();
                final String Nachname = EtLastname.getText().toString();
                final String Geburtsdatum = EtGeburtstag.getText().toString();
                final String Geburtsort = EtGeburtsort.getText().toString();
                final String Handynummer = EtHandynummer.getText().toString();
                final String Personalausweisnummer = EtPersonummer.getText().toString();
                final String Passwort = EtPassword.getText().toString();
                final String PasswortWH = EtPasswortWH.getText().toString();

                //Abruf der Daten aus der Datenbank mit Hilfe der php-Datei und der Aktivität ChangeRequest
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){

                        try {
                            //Abfrage, ob Datenabruf durch die php-Datei erfolgreich war
                            JSONObject jsonresponse = new JSONObject(response);
                            boolean success = jsonresponse.getBoolean("success");

                            if (success){
                                //Abspeichern aller zurückgegebenen Nutzerdaten
                                String Vorname = jsonresponse.getString("Vorname");
                                String Nachname = jsonresponse.getString("Nachname");
                                String Geburtsdatum = jsonresponse.getString("Geburtsdatum");
                                int IDreisender = jsonresponse.getInt("IDreisender");

                                //Aufruf der neuen Aktivität (Userarea) und gleichzeitige Weitergabe der Nutzerdaten
                                Intent intent = new Intent(Userdaten.this, Userarea.class);
                                intent.putExtra("Vorname", Vorname);
                                intent.putExtra("Nachname", Nachname);
                                intent.putExtra("Geburtsdatum", Geburtsdatum);
                                intent.putExtra("IDreisender", IDreisender);

                                Userdaten.this.startActivity(intent);
                                Toast.makeText(getApplicationContext(),"Änderungen erfolgreich gespeichert!",Toast.LENGTH_SHORT).show();

                            }else{
                                //Fehlermeldung, falls beim Datenabruf etwas nicht funktioniert (bsp. Fehler in  der php-Datei, keine Verbindung zum Server)
                                AlertDialog.Builder builder = new AlertDialog.Builder(Userdaten.this);
                                builder.setMessage("Änderungen fehlgeschlagen")
                                        .setNegativeButton("Bitte wiederholen",null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                //Aufforderung zum Aufruf der Aktitivät ChangeRequest und Weitergabe der zur Abfrage benötigten Daten
                ChangeRequest changeRequest = new ChangeRequest(IDreisender,Vorname,Nachname, Geburtsdatum,EMail,Geburtsort,Handynummer,Personalausweisnummer,Passwort, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Userdaten.this);
                queue.add(changeRequest);

            }




  });
    }
    @Override
    public void onBackPressed() {
    }
}

