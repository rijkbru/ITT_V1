package com.example.rijke.itt_v1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity ;
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

public class LogIn extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        final EditText editTextEmailToLogin=(EditText)findViewById(R.id. editTextEmailToLogin);
        final EditText editTextPasswordToLogin=(EditText)findViewById(R.id. editTextPasswordToLogin);
        final Button buttonLogin=(Button)findViewById(R.id. buttonLogin);
        final Button buttonReg_Link=(Button)findViewById(R.id.buttonReg_Link);

        buttonReg_Link.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registerIntent = new Intent(LogIn.this, Registrieren.class);
                LogIn.this.startActivity(registerIntent);
                }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String Email = editTextEmailToLogin.getText().toString();
                final String Passwort = editTextPasswordToLogin.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                String Vorname = jsonResponse.getString("Vorname");
                                String EMail = jsonResponse.getString("EMail");
                                int IDreisender = jsonResponse.getInt("IDreisender");
//                                String Geburtsort = jsonResponse.getString("Geburtsort");
                                Toast.makeText(getApplicationContext(),"Login erfolgreich!",Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(LogIn.this, Start.class);
                                intent.putExtra("Vorname", Vorname);
                                intent.putExtra("EMail", EMail);
                                intent.putExtra("IDreisender", IDreisender);


                                LogIn.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LogIn.this);
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
                LoginRequest loginRequest = new LoginRequest(Email, Passwort, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LogIn.this);
                queue.add(loginRequest);
            }
        });

    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
