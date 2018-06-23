package com.example.rijke.itt_v1;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final TextView TextViewWelcomeMessage = (TextView) findViewById(R.id.begruessung);


        Intent intent = getIntent();
        String Vorname = intent.getStringExtra("Vorname");

        String nachricht = "Hallo " + Vorname + "!";
        TextViewWelcomeMessage.setText(nachricht);

        final Button buttonHistorie=(Button)findViewById(R.id.btnHistorie);
        buttonHistorie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent HistorieIntent = new Intent(Start.this, Historie.class);
                Start.this.startActivity(HistorieIntent);
            }
        });
    }
}
