package com.example.shcoolboy;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cotan extends AppCompatActivity {
    public boolean finish = false;
    private ProcessBuilder t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5);
                    finish=true;
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (finish) {
            Toast.makeText(Cotan.this, "From thread", Toast.LENGTH_SHORT).show();
        }
    }
}
