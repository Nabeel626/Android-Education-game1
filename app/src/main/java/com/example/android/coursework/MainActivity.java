package com.example.android.coursework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button guess_the_country = findViewById(R.id.guess_the_country);
        guess_the_country.setOnClickListener(new View.OnClickListener() {

            public void onClick(View button1) {
                Intent guess_the_country = new Intent (MainActivity.this, Guess_the_country.class);
                startActivity(guess_the_country);
            }

        });

        Button guess_hints = findViewById(R.id.Guess_Hints);
        guess_hints.setOnClickListener(new View.OnClickListener() {

            public void onClick(View button2) {
                Intent guess_hints = new Intent (MainActivity.this, Guess_the_hints.class);
                startActivity(guess_hints);
            }

        });

        Button advanced_level = findViewById(R.id.Advanced_level);
        advanced_level.setOnClickListener(new View.OnClickListener() {

            public void onClick(View button3) {
                Intent advanced_level = new Intent (MainActivity.this, Advanced_Level.class);
                startActivity(advanced_level);
            }

        });

        Button guess_the_flag = findViewById(R.id.Guess_the_Flag);
        guess_the_flag.setOnClickListener(new View.OnClickListener() {

            public void onClick(View button4) {
                Intent guess_the_flag = new Intent (MainActivity.this, Guess_the_flag.class);
                startActivity(guess_the_flag);
            }

        });
    }
}
