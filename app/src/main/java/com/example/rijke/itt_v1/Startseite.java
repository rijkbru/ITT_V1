package com.example.rijke.itt_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import junit.framework.Test;

import org.w3c.dom.Text;

public class Startseite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startseite);

        final TextView TextViewWelcomeMessage=(TextView) findViewById(R.id. TextViewWelcomeMessage);

        Intent intent = getIntent();
        String Vorname = intent.getStringExtra("Vorname");

        String nachricht = "Hallo " + Vorname + "!";
        TextViewWelcomeMessage.setText(nachricht);
    }
}
