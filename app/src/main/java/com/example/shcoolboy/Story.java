package com.example.shcoolboy;

public class Story {
    protected Situation currentSituation;

    public Story(Situation currentSituation) {
        this.currentSituation = currentSituation;
    }


    public void go(int characterAnswer) {
        currentSituation = (Situation) currentSituation.directions[characterAnswer];
    }

    public boolean isEnd() {
        return currentSituation.directions.length == 1;
    }
}

