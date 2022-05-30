package com.example.shcoolboy;

import java.util.Scanner;

public class Game {
    public static Situation came;
    protected Character charact;
    protected Story story;
    private String string;

    public Game(Character charact, Story story) {
        this.charact = charact;
        this.story = story;
    }

    private void start() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            charact.P += story.currentSituation.dP;
            charact.T += story.currentSituation.dT;
            charact.R += story.currentSituation.dR;
            charact.showStatus();
            story.currentSituation.show();
            if (story.isEnd()) break;
            else {
                int answer = scanner.nextInt();
                story.go(answer);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите ваше имя:");
        Character character = new Character(scanner.nextLine(), 0, 100, 0);

    }
}