package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Year1Activity extends AppCompatActivity {

    Button Clang,Math;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year1);

        Clang=findViewById(R.id.clang);
        Math=findViewById(R.id.btnmath);

        Clang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Year1Activity.this,Year1CLang.class));
            }
        });

        Math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Year1Activity.this, Year1Math.class));
            }
        });

    }
}
