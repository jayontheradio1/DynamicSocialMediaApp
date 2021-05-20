package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Year2Activity extends AppCompatActivity {

    Button Java,Algo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year2);


        Java=findViewById(R.id.java);
        Algo=findViewById(R.id.algorithms);

        Java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Year2Activity.this,Year2Java.class));
            }
        });

        Algo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Year2Activity.this, Year2Algorithms.class));
            }
        });


    }
}
