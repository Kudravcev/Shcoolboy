package com.example.shcoolboy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Quest2 extends AppCompatActivity {
    Character charact;
    Story story;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest2);
        charact = new Character(editTextName,0,100,100);
        Situation startSituation = new Situation("Ты выполнил квест","Молодец",0,1,1,1);
        story = new Story(startSituation);
        updateStatus();
    }
    private void go(int i) {
        story.go(i + 1);
        updateStatus();
        if (story.isEnd()){
            Toast.makeText(this, " ", Toast.LENGTH_LONG).show();
        }
    }

    private void updateStatus() {
        charact.P += story.currentSituation.dP;
        charact.T += story.currentSituation.dT;
        charact.R += story.currentSituation.dR;
        TextView tv = findViewById(R.id.textView);
        tv.setText("П:" + charact.P + "\nТ:" + charact.T + "\nР:" + charact.R);
        TextView tv1 = findViewById(R.id.textView3);
        tv1.setText(story.currentSituation.subject);
        TextView tv2 = findViewById(R.id.textView4);
        tv2.setText(story.currentSituation.text);
        LinearLayout linearLayout = findViewById(R.id.layout2);
        linearLayout.removeAllViews();
        for (int i = 0; i < story.currentSituation.directions.length; i++) {
            Button b = new Button(this);
            b.setText(Integer.toString(i + 1));
            final int buttonId = i;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    go(buttonId);
                }
            });
            ((LinearLayout) findViewById(R.id.layout2)).addView(b);
        }
        return;
    }
}