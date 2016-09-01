package edu.opendev.guess;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameGuess {

    private int max;
    private int value;
    private int countAttempts;
    private Respondent respondent;
    private String message;

    public long getDuration(long startTime){
        long duration = System.nanoTime() - startTime;
        return TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
    }

    public long getStartTime(){
        return System.nanoTime();
    }

    public int getCountAttempts() {
        return countAttempts;
    }

    public GameGuess(int max, Respondent respondent) {
        this.max = max;
        this.respondent = respondent;
        Random rnd = new Random();
        this.value = rnd.nextInt(max) + 1;
    }

    public String getMessage() {
        return message;
    }

    public void start() {
        countAttempts = 0;
        System.out.printf("Я загадал число от 1 до %d, отгадайте его%n", max);
        int answer;
        do {
            answer = respondent.nextAnswer();
            countAttempts++;

        } while (!checkAnswer(answer));
    }

    private boolean checkAnswer(int answer) {
        return checkAnswer(answer, false);
    }

    private boolean checkAnswer(int answer, boolean quiet) {
        boolean result = false;

        if(answer > value) {
            message = "много";
        } else if(answer < value) {
            message = "мало";
        } else {
            message = "Победа, Вы угадали!";
            result = true;
        }
        if(!quiet) {
            System.out.println(message);
        }
        return result;
    }
}
