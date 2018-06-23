package com.example.rijke.itt_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Historie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historie);

        final Button buttonStart=(Button)findViewById(R.id.btnStart);
        buttonStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent StartIntent = new Intent(Historie.this, Start.class);
                Historie.this.startActivity(StartIntent);
            }
        });
    }
}
