package com.example.shcoolboy;

import android.widget.EditText;

public class Character {
    protected int P,T,R;
    protected String name;

    public Character(String name,int p,int t,int r) {
        this.P = p;
        this.T = t;
        this.R = r;
        this.name = name;

    }

    public Character(EditText editTextName, int p, int t, int r) {

    }

    public void showStatus(){
        System.out.println("P="+P+",T="+T+",R="+R);}
}
