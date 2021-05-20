package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PowerActivity extends AppCompatActivity {

    Button year1,year2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);

       year1 = findViewById(R.id.btnyear1);
       year2 = findViewById(R.id.btnyear2);

       year1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(PowerActivity.this , Year1Activity.class));
           }
       });

       year2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(PowerActivity.this , Year2Activity.class));
           }
       });


    }
}
