package com.example.rijke.itt_v1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registrieren extends AppCompatActivity {

    //Initialisierung einer Variable zur Abfrage, ob die FAQ gelesen wurden
    public int gelesen = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrieren);

        //Initialisierung der Textfelder, Buttons, Bilder und Checkbox
        final EditText editTextFName = (EditText) findViewById(R.id.editTextFName);
        final EditText editTextLName = (EditText) findViewById(R.id.editTextLName);
        final EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        final EditText editTextGeburtsdatum = (EditText) findViewById(R.id.editTextGeburtsdatum);
        final EditText editTextGeburtsort = (EditText) findViewById(R.id.editTextGeburtsort);
        final EditText editTextHandynummer = (EditText) findViewById(R.id.editTextHandynummer);
        final EditText editTextPersonummer = (EditText) findViewById(R.id.editTextPersonummer);
        final EditText editTextPasswort = (EditText) findViewById(R.id.editTextPasswort);
        final EditText editTextPasswortWH = (EditText) findViewById(R.id.editTextPasswortWH);
        final EditText editTextStrasse = (EditText) findViewById(R.id.editTextStrasse);
        final EditText editTextHausnummer = (EditText) findViewById(R.id.editTextHausnummer);
        final EditText editTextPLZ = (EditText) findViewById(R.id.editTextPLZ);
        final EditText editTextOrt = (EditText) findViewById(R.id.editTextOrt);
        final EditText editTextLand = (EditText) findViewById(R.id.editTextLand);
        final EditText editTextNameKC = (EditText) findViewById(R.id.editTextNameKC);
        final EditText editTextNummerKC = (EditText) findViewById(R.id.editTextNummerKC);
        final EditText editTextDatum = (EditText) findViewById(R.id.editTextDatum);
        final EditText editTextZiffer = (EditText) findViewById(R.id.editTextZiffer);
        final CheckBox checkBoxAGB = (CheckBox) findViewById(R.id.checkBoxAGB);
        final Button buttonReg = (Button) findViewById(R.id.buttonReg);
        final Button buttonAGB = (Button) findViewById(R.id.buttonAGB);
        final ImageView imageViewAGB = (ImageView) findViewById(R.id.imageViewAGB);

        //Wenn der AGB-Buttopn gedrückt wird, werden die AGB angezeigt und der Variablenwert für gelesen geändert
        buttonAGB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewAGB.setVisibility(View.VISIBLE);
                gelesen = 2;
                }
        });

        //sobald die AGB akzeptiert werden, werden diese wieder ausgeblendet
        checkBoxAGB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                imageViewAGB.setVisibility(View.INVISIBLE);
            }
        });

        //Ausführung der Regsitrierung nach Betätigen des entsprechenden Buttons
        buttonReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Speichern der Textfeldwerte in den entsprechenden Variablen
                final String Vorname = editTextFName.getText().toString();
                final String Nachname = editTextLName.getText().toString();
                final String EMail = editTextEmail.getText().toString();
                final String Geburtsdatum = editTextGeburtsdatum.getText().toString();
                final String Geburtsort = editTextGeburtsort.getText().toString();
                final String Handynummer = editTextHandynummer.getText().toString();
                final String Personalausweisnummer = editTextPersonummer.getText().toString();
                final String Passwort = editTextPasswort.getText().toString();
                final String Strasse = editTextStrasse.getText().toString();
                final String Hausnummer = editTextHausnummer.getText().toString();
                final int PLZ = Integer.parseInt(editTextPLZ.getText().toString());
                final String Ort = editTextOrt.getText().toString();
                final String Land = editTextLand.getText().toString();
                final String Kontoinhaber = editTextNameKC.getText().toString();
                final int Kartennummer = Integer.parseInt(editTextNummerKC.getText().toString());
                final String Datum = editTextDatum.getText().toString();
                final int Ziffer = Integer.parseInt(editTextZiffer.getText().toString());
                final String PasswortWH = editTextPasswortWH.getText().toString();

                //Abfrage, ob die AGB gelesen wurden
                if (checkBoxAGB.isChecked()) {
                    //Abfrage, ob die AGB aufgerufen wurden
                    if (gelesen == 1){
                        //Fehlermeldung, wenn die AGB nicht aufgerufen wurden (Variablenwert unverändert)
                        AlertDialog.Builder builder = new AlertDialog.Builder(Registrieren.this);
                        builder.setMessage("Sie müssen die AGBs auch lesen, nicht nur klicken!")
                                .setNegativeButton("Wiederholen", null)
                                .create()
                                .show();
                    }else {
                        //Überprüfung, ob die Passwörter übereinstimmen
                        if (Passwort.equals(PasswortWH)) {

                            Response.Listener<String> responseListener = new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        //Abfrage, ob die Abfragen der php-Datei erfolgreich waren
                                        JSONObject jsonresponse = new JSONObject(response);
                                        boolean success = jsonresponse.getBoolean("success");

                                        if (success) {
                                            //Bei erfolgreicher Durchführung der Registrierung wird die Login-Seite erneut aufgezeigt
                                            Intent intent = new Intent(Registrieren.this, LogIn.class);
                                            Registrieren.this.startActivity(intent);
                                            //Nutzer bekommt Meldung, dass die Registrierung erfolgreich war
                                            Toast.makeText(getApplicationContext(), "Registrierung erfolgreich!", Toast.LENGTH_SHORT).show();

                                        } else {
                                            //Wenn die Abfrage nicht erfolgreich war, besteht bereits ein konto mit der E-Mail-Adresse, folglich wird dies dem Nutzer mitgeteilt
                                            AlertDialog.Builder builder = new AlertDialog.Builder(Registrieren.this);
                                            builder.setMessage("Es existiert bereits ein Konto mit dieser E-Mail-Adresse")
                                                    .setNegativeButton("Wiederholen", null)
                                                    .create()
                                                    .show();
                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            };
                            //Aufruf der RegisterRequest mit Weitergabe der benötigten variablen
                            RegisterRequest registerRequest = new RegisterRequest(Vorname, Nachname, Geburtsdatum, Geburtsort, Handynummer, EMail, Personalausweisnummer, Passwort, Strasse, Hausnummer, PLZ, Ort, Land, Kontoinhaber, Kartennummer, Datum, Ziffer, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(Registrieren.this);
                            queue.add(registerRequest);

                        } else {
                            //Wenn die Passwörter nicht übereinstimmen, wird dies dem Nutzer mitgeteilt und er kann diese erneut eingeben
                            AlertDialog.Builder builder = new AlertDialog.Builder(Registrieren.this);
                            builder.setMessage("Die Passwörter stimmen nicht überein!")
                                    .setNegativeButton("Wiederholen", null)
                                    .create()
                                    .show();
                        }
                    }
                }else{
                    //Wenn die AGBs nicht akzeptiert wurden, wird dies angezeigt und der Nutzer kann dies Nachholen
                    AlertDialog.Builder builder = new AlertDialog.Builder(Registrieren.this);
                    builder.setMessage("Sie müssen die AGBs akzeptieren!")
                            .setNegativeButton("Wiederholen", null)
                            .create()
                            .show();
                }
            }
        });
    }
}
