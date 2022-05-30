package com.example.shcoolboy;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.graphics.ExperimentalGraphicsApi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.telephony.CellIdentity;
import android.view.Display;
import android.view.FrameStats;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Snake extends AppCompatActivity {
    ProgressBar pb;
    TextView tv;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Toast.makeText(Snake.this, msg.what + "%", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snaces);
        LoadImageTask lit = new LoadImageTask();
        lit.execute("cats.gif", "a.java", "Sony");
        pb = findViewById(R.id.pb);
        tv = findViewById(R.id.tv);
    }

    private class LoadImageTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int i = values[0];
            pb.setProgress(i*10);
            tv.setText(i*10+"%");

        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(500);
                    publishProgress(i);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }Intent intent = new Intent(getBaseContext(), Exercise.class);
            startActivity(intent);
            return "";
        }


        @Override
        protected void onPostExecute(String unused) {
            super.onPostExecute(unused);
        }
    }
    public static class GameField {

        static int [] canvas = {0,0,0,
                                0,0,0,
                                0,0,0};

        //012, 345, 678, 036, 147, 258, 048, 246
        public static void main(String[] args){

            boolean b;
            boolean isCurrentX = false;
            do {
                isCurrentX = !isCurrentX;
                drawCanvas();
                System.out.println("mark " + (isCurrentX ? "X" : "O"));
                int n = getNumber();
                canvas[n] = isCurrentX ? 1 : 1;
                b = !isGameOver(n);
                if (isDraw()){
                    System.out.println("Draw");
                    return;
                }
            } while (b);
            drawCanvas();
            System.out.println();

            System.out.println("The winner is " + (isCurrentX ? "X" : "O") + "!");
        }

        static int getNumber(){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                try {
                    int n = Integer.parseInt(reader.readLine());
                    if (n >= 0 && n < canvas.length && canvas[n]==0){
                        return n;
                    }
                    System.out.println("Choose free cell and enter its number");
                } catch (NumberFormatException e) {
                    System.out.println("Please enter the number");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        static boolean isGameOver(int n){
            // 0 1 2
            // 3 4 5
            // 6 7 8
            int row = n-n%3;
            if (canvas[row]==canvas[row+1] &&
                    canvas[row]==canvas[row+2]) return true;

            int column = n%3;
            if (canvas[column]==canvas[column+3])
                if (canvas[column]==canvas[column+6]) return true;

            if (n%2!=0) return false;

            if (n%4==0){

                if (canvas[0] == canvas[4] &&
                        canvas[0] == canvas[8]) return true;
                if (n!=4) return false;
            }
            return canvas[2] == canvas[4] &&
                    canvas[2] == canvas[6];
        }

        static void drawCanvas(){
            System.out.println("     |     |     ");
            for (int i = 0; i < canvas.length; i++) {
                if (i!=0){
                    if (i%3==0) {
                        System.out.println();
                        System.out.println("_____|_____|_____");
                        System.out.println("     |     |     ");
                    }
                    else
                        System.out.print("|");
                }

                if (canvas[i]==0) System.out.print("  " + i + "  ");
                if (canvas[i]==1) System.out.print("  X  ");
                if (canvas[i]==2) System.out.print("  O  ");
            }
            System.out.println();
            System.out.println("     |     |     ");
        }

        public static boolean isDraw() {
            for (int n : canvas) if (n==0) return false;
            return true;
        }
    }
}