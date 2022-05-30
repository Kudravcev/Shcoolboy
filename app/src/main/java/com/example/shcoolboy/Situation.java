package com.example.shcoolboy;

class Situation {
    protected String text;
    protected String subject;
    public Situation[] directions;
    protected int dP,dT,dR;

    public String getText() {
        return text;
    }

    public String getSubject() {
        return subject;
    }

    public int getdP() {
        return dP;
    }

    public int getdT() {
        return dT;
    }

    public int getdR() {
        return dR;
    }

    public Situation( String text, String subject, int dP, int dT, int dR) {
        this( text,subject,0,dP,dT,dR);
    }

    public Situation( String text, String subject, int directions, int dP, int dT, int dR) {
        this.text = text;
        this.subject = subject;
        this.dP = dP;
        this.dT = dT;
        this.directions=new Situation[directions];
        this.dR = dR;
    }

    public void show(){
        System.out.println(text);
        System.out.println(subject);
    }

}