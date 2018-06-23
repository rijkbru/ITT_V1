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


// Add Button activity = change page
        buttonReg = (Button) findViewById(R.id.buttonBack);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }


        public void openMain(){
            Intent intent = new Intent(Userdaten.this, Userarea.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Daten erfolgreich geändert!",Toast.LENGTH_SHORT).show();
        }


        final TextView TextViewWelcomeMessage = (TextView) findViewById(R.id.textView_Registrierung);
        final EditText EtFirstname = (EditText) findViewById(R.id.editTextFName);
        final EditText EtLastname = (EditText) findViewById(R.id.editTextLName);
        final EditText EtGeburtstag = (EditText) findViewById(R.id.editTextGeburtsdatum);
        final EditText EtGeburtsort = (EditText) findViewById(R.id.editTextGeburtsort);
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


        Response.Listener<String> responseListener = new Response.Listener<String>(){
            @Override
            public void onResponse(String response){
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success){
//                        String Vorname = jsonResponse.getString("Vorname");
//                        String Nachname =jsonResponse.getString("Nachname");

                        Intent intent = getIntent();
                        String Vorname = intent.getStringExtra("Vorname");
                        String Nachname = intent.getStringExtra("Nachname");
                        String nachricht = "Hallo" + Vorname + "!";
                        TextViewWelcomeMessage.setText(nachricht);



                        Userdaten.this.startActivity(intent);

                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Userdaten.this);
                        builder.setMessage("Login fehlgeschlagen")
                                .setNegativeButton("Wiederholen",null)
                                .create()
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };


        DatenRequest datenRequest = new DatenRequest(Vorname, Nachname, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Userdaten.this);
        queue.add(datenRequest);
     });

}


// get information from database
//        Intent intent = getIntent();
//        String Vorname = intent.getStringExtra("Vorname");
//        String Nachname = intent.getStringExtra("Nachname");
//        int age = intent.getStringExtra("age"); alles einfügen, bzw Zahlen als int einfügen
//        String Geburtsort = intent.getStringExtra("Geburtsort");
//        String EMail = intent.getStringExtra("EMail");



// insert information from database
//        String nachricht = "Hallo" + Vorname + "!";
//        TextViewWelcomeMessage.setText(nachricht);
//        EtFirstname.setText(Vorname);
//        EtLastname.setText(Nachname);
//        EtGeburtsort.setText(Geburtsort);
//        EtEmail.setText(EMail);





