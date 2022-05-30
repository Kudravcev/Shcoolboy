package com.example.shcoolboy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Exercise extends AppCompatActivity {
    private TextView textView7;
    private Button b1,b2, b4,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        textView7 = findViewById(R.id.textView7);
        textView7.setText("Задание от учителя " +
                "\n Найдите в предложении имя существительное: " +
                "\n " );
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);

        b1.setText("Я");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Exercise.this, "Местоимение", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setText("гулял");
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Exercise.this, "Глагол", Toast.LENGTH_SHORT).show();
            }
        });
        b3.setText("один");
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Exercise.this, "Имя числительное", Toast.LENGTH_SHORT).show();
            }
        });
        b4.setText("по парку");
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Quest2.class);
                startActivity(intent);
            }
        });

    }
}