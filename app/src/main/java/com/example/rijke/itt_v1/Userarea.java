package com.example.rijke.itt_v1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Userarea extends AppCompatActivity {


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

//          Definition of Textfields, will be filled with information later

            final TextView etName = (TextView) findViewById(R.id.editTextLName);
            final TextView etFName = (TextView) findViewById(R.id.editTextFName);
            final TextView tvWelcome = (TextView) findViewById(R.id.tvWelcome);
            final TextView tvIDreisender = (TextView) findViewById(R.id.tvIDreisender2);
            final TextView etGeburtsdatum = (TextView) findViewById(R.id.editTextGeburtsdatum);

            Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Userarea.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Interessen));
            myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mySpinner.setAdapter(myAdapter);


            //        Get information from Start with same IDreisender and pass over to Userarea
            Intent intent = getIntent();
            String Nachname = intent.getStringExtra("Nachname");
            String Vorname = intent.getStringExtra("Vorname");
            String Geburtsdatum = intent.getStringExtra("Geburtsdatum");
            String EMail = intent.getStringExtra("EMail");
            int IDreisender = intent.getIntExtra("IDreisender", -1);


//       Display information
            etName.setText(Nachname);
            etFName.setText(Vorname);
            String message = "Hallo " + Vorname;
            tvWelcome.setText(message);
            etGeburtsdatum.setText(Geburtsdatum);
            tvIDreisender.setText(IDreisender + "");



            final Button buttonBack= (Button) findViewById(R.id.buttonBack);
            buttonBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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
                                    int IDreisender = jsonResponse.getInt("IDreisender");

                                    Intent intent = new Intent(Userarea.this, Userdaten.class);
                                    intent.putExtra("Vorname", Vorname);
                                    intent.putExtra("Nachname", Nachname);
                                    intent.putExtra("Geburtsdatum", Geburtsdatum);
                                    intent.putExtra("IDreisender", IDreisender);


                                    Userarea.this.startActivity(intent);


                                }else{
                                    AlertDialog.Builder builder = new AlertDialog.Builder(Userarea.this);
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
                    RequestQueue queue = Volley.newRequestQueue(Userarea.this);
                    queue.add(datenRequest);
                }
            });


        }
    @Override
    public void onBackPressed() {
    }
}







