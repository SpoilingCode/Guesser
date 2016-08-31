package edu.opendev.guess;

import java.util.Random;

public class Guesser implements Respondent{
    private int max;
    private Random rnd = new Random();

    public Guesser(int max) {
        this.max = max;
    }

    @Override
    public int nextAnswer() {
        int answer = rnd.nextInt(max+1);
        return answer;
    }
}
