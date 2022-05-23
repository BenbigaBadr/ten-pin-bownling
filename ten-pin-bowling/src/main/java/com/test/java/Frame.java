package com.test.java;

import static com.test.util.Constants.STRIKE;

public class Frame {
    private int firstShot;
    private int secondShot;
    private int thirdShot;
    private int fourthShot;

    public Frame()
    {

    }

    public static Frame initStrike()
    {
        Frame frame = new Frame();
        frame.firstShot = 10;
        frame.secondShot = 0;
        return frame;
    }

    public static Frame initSpare()
    {
        Frame frame = new Frame();
        frame.firstShot = 5;
        frame.secondShot = 3;
        return frame;
    }

    public static Frame initBonusSpare()
    {
        Frame frame = new Frame();
        frame.firstShot = 5;
        frame.secondShot = 5;
        frame.thirdShot = 8;
        return frame;
    }

    public static Frame initBonusStrike()
    {
        Frame frame = new Frame();
        frame.firstShot = 10;
        frame.secondShot = 0;
        frame.thirdShot = 10;
        frame.fourthShot = 10;
        return frame;
    }

    public int getBonus()
    {
        return thirdShot + fourthShot;
    }

    public int getScore(){
        return firstShot + secondShot;
    }

    public boolean isSpare()
    {
        return firstShot + secondShot == STRIKE;
    }

    public boolean isStrike()
    {
        return firstShot == STRIKE;
    }

    public Frame(int firstShot, int secondShot)
    {
        this.firstShot = firstShot;
        this.secondShot = secondShot;
    }

    public int getFirstShot() {
        return firstShot;
    }

    public void setFirstShot(int firstShot) {
        this.firstShot = firstShot;
    }

    public int getSecondShot() {
        return secondShot;
    }

    public void setSecondShot(int secondShot) {
        this.secondShot = secondShot;
    }

    public int getThirdShot() {
        return thirdShot;
    }

    public void setThirdShot(int thirdShot) {
        this.thirdShot = thirdShot;
    }

    public int getFourthShot() {
        return fourthShot;
    }

    public void setFourthShot(int fourthShot) {
        this.fourthShot = fourthShot;
    }
}
