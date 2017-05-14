package com.example.michael.smarthealth;

/**
 * Created by Robin on 5/13/2017.
 */

import java.util.Random;

/**
 * Gamification IDs
 * 1. Level
 * 2. Badge
 * 3. Fact
 * 4. Friend
 * 5. Competition
 */

public class Gamification {
    //currently have:
    private float level;
    private int[] badges;

    private String[] facts;
    /*
    Friend
    Competition
     */

    //badges
    private int[] badgeImages;

    //constructor
    public Gamification() {
        level = 0;
        for (int i=0; i<4; i++) {
            badges[i] = 0;
        }

        badgeImages[0] = R.drawable.redbadge;
        badgeImages[1] = R.drawable.greenbadge;
        badgeImages[2] = R.drawable.purplebadge;
        badgeImages[3] = R.drawable.yellowbadge;

        //facts
        facts = new String[5];
        facts[0] = "Exercising allows you to control your main.  2 hours of moderate exercise, " +
                "or 1 hour of vigorous exercise a week can help maintain your weight.  For " +
                "losing weight including dieting.";
        facts[1] = "2 hours of moderate exercise a week can reduce your risk of cardiovascular " +
                "disease.";
        facts[2] = "2 hours of moderate exercise a week can reduce your risk of developing type " +
                "2 diabetes and metabolic syndrome.";
        facts[3] = "Being physically active lowers your risk of colon cancer and breast cancer.";
        facts[4] = "Regular exercise can help keep your thinking, learning, and judgement skills " +
                "sharp as you age.";
    }

    //increment
    public void addExp(float x){
        level += x;
    }
    public int addBadge(int x){
        int num = x-1;
        int award = 0;
        badges[num] += 1;
        award = badgeImages[num];
        return award;
    }

    private String getFact() {
        Random rn = new Random();
        int x = rn.nextInt(4);
        return facts[x];
    }

    //converts number to string (gamification method)
    public String getString(int x) {
        int num = x-1;
        String method = "";
        switch (x) {
            case 0:
                method = "you will gain levels";
                break;
            case 1:
                method = "you will gain a badge";
                break;
            case 2:
                method = getFact();
                break;
            case 3:
                method = "friends";
                break;
            case 4:
                method = "competition";
                break;
        }
        return method;
    }

    //Getters & Setters

}
