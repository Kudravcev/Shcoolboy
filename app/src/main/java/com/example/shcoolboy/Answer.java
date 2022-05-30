package com.example.shcoolboy;

public class Answer {
    protected long idanswer;
    protected String textanswer;
    protected long idnext;
    protected long idlast;

    public long getIdanswer() {
        return idanswer;
    }

    public String getTextanswer() {
        return textanswer;
    }

    public long getIdnext() {
        return idnext;
    }

    public long getIdlast() {
        return idlast;
    }

    public Answer(long idanswer, String textanswer, long idnext, long idlast){
        this.idanswer = idanswer;
        this.textanswer = textanswer;
        this.idnext = idnext;
        this.idlast = idlast;
    }
    public void show(){
        System.out.println(textanswer);
    }
}
