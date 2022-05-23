package com.test.java;

import java.util.List;

import static com.test.util.Constants.*;

public class Game {

    public static final int ZERO = 0;
    public static final int MAX_FRAMES_NUMBER = 10;
    private List<Frame> frames;

    public int getTotalScore() {
        int[] result = new int[MAX_FRAMES_NUMBER];
        int score = 0;
        int previousScore = 0;

        if (frames.size() < ZERO || frames.size() > MAX_FRAMES_NUMBER)
            throw new IllegalArgumentException(ERROR_FRAMES_SIZE);

        for (int i = 0; i < frames.size(); i++) {
            Frame actualFrame = frames.get(i);

            if (actualFrame.isStrike()) {
                score = previousScore + STRIKE;
                if (i == 9) {
                    score += actualFrame.getBonus();
                } else {
                    score += frames.get(i + 1).getScore() + (i == 8 ? frames.get(i +1).getThirdShot() : frames.get(i +2).getScore());
                }
            } else if (actualFrame.isSpare()) {
                score = previousScore + STRIKE;
                if (i == 9) {
                    if (actualFrame.getFourthShot() > 0)
                        throw new IllegalArgumentException(ERROR_LAST_SHOT_SPARE);
                    score += actualFrame.getThirdShot();
                } else {
                    score += frames.get(i + 1).getFirstShot();
                }
            } else {
                score = previousScore + actualFrame.getScore();
            }
            previousScore = score;
            result[i] = score;
        }
        return result[frames.size() - 1];
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }
}
