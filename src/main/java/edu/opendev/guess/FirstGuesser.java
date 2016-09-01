package edu.opendev.guess;

import java.util.Random;

public class FirstGuesser implements Respondent{
    private int max;
    private Random rnd = new Random();

    @Override
    public void printAllAttempts() {
        System.out.println("\nСтатистика первого бота: ");
        for(Integer countAttempts : attemptsFirstGuesser){
            System.out.println(countAttempts );
        }
    }

    @Override
    public void recordCountAttempts(int countAttempts) {
        attemptsFirstGuesser.add(countAttempts);
    }

    public FirstGuesser(int max) {
        this.max = max;
    }

    @Override
    public int nextAnswer() {
        int answer = rnd.nextInt(max+1);
        return answer;
    }
}
