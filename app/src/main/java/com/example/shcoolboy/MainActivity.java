package com.example.shcoolboy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowId;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public TextView  textView;
    public EditText editTextName;
    public Button button;
    public View view;
    public Button button2, button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        editTextName = findViewById(R.id.editTextName);
        button = findViewById(R.id.button);


//        DBSituations db = new DBSituations(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), StartActivity.class);
                intent.putExtra("name",editTextName.getText().toString());
                startActivity(intent);
            }
        });
    }
}