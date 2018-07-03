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

        final TextView TextViewWelcomeMessage = (TextView) findViewById(R.id.textView_Registrierung);
        final EditText EtFirstname = (EditText) findViewById(R.id.editTextFName);
        final EditText EtLastname = (EditText) findViewById(R.id.editTextLName);
        final EditText EtGeburtstag = (EditText) findViewById(R.id.editTextGeburtsdatum);
        final TextView tvIDreisender = (TextView) findViewById(R.id.tvIDreisender3);

        Intent intent = getIntent();
        String Vorname = intent.getStringExtra("Vorname");
        String Nachname = intent.getStringExtra("Nachname");
        String EMail = intent.getStringExtra("EMail");
        String Geburtsdatum = intent.getStringExtra("Geburtsdatum");
        int IDreisender = intent.getIntExtra("IDreisender", -1);

        EtFirstname.setText(Vorname);
        EtLastname.setText(Nachname);
        EtGeburtstag.setText(Geburtsdatum);
        tvIDreisender.setText(IDreisender + "");



// Add Button activity = change page
        buttonReg = (Button) findViewById(R.id.buttonBack);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int IDreisender = Integer.parseInt(tvIDreisender.getText().toString());
                final String EMail = tvIDreisender.getText().toString();

                final String Vorname = EtFirstname.getText().toString();
                final String Nachname = EtLastname.getText().toString();
                final String Geburtsdatum = EtGeburtstag.getText().toString();
   /*            final String Geburtsort = editTextGeburtsort.getText().toString();
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
   */

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){

                        try {
                            JSONObject jsonresponse = new JSONObject(response);
                            boolean success = jsonresponse.getBoolean("success");

                            if (success){
                                Intent intent = new Intent(Userdaten.this, Userarea.class);
                                Userdaten.this.startActivity(intent);
                                Toast.makeText(getApplicationContext(),"Änderungen erfolgreich gespeichert!",Toast.LENGTH_SHORT).show();

                            }else{
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

                ChangeRequest changeRequest = new ChangeRequest(IDreisender,Vorname,Nachname, Geburtsdatum, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Userdaten.this);
                queue.add(changeRequest);

            }


            final EditText EtHandynummer = (EditText) findViewById(R.id.editTextHandynummer);
            final EditText EtEmail = (EditText) findViewById(R.id.editTextEmail);
            final EditText EtPersonummer = (EditText) findViewById(R.id.editTextPersonummer);
            final EditText EtPassword = (EditText) findViewById(R.id.editTextPasswort);
            final EditText EtPasswortWH = (EditText) findViewById(R.id.editTextPasswortWH);
            final EditText EtStrasse = (EditText) findViewById(R.id.editTextStrasse);
            final EditText EtHausnummer = (EditText) findViewById(R.id.editTextHausnummer);
            final EditText EtPLZ = (EditText) findViewById(R.id.editTextPLZ);
            final EditText EtOrt = (EditText) findViewById(R.id.editTextOrt);
            final EditText EtLand = (EditText) findViewById(R.id.editTextLand);
            final EditText EtNameKC = (EditText) findViewById(R.id.editTextNameKC);
            final EditText EtNummerKC = (EditText) findViewById(R.id.editTextNummerKC);
            final EditText EtDatum = (EditText) findViewById(R.id.editTextDatum);
            final EditText EtZiffer = (EditText) findViewById(R.id.editTextZiffer);


  });
    }
    @Override
    public void onBackPressed() {
    }
}