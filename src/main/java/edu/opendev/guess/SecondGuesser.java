package edu.opendev.guess;

import java.util.Random;

public class SecondGuesser implements Respondent {
    private int max;
    private int lastNumber;
    private String message;

    @Override
    public void printAllAttempts() {
        System.out.println("\nСтатистика второго бота: ");
        for(Integer countAttempts : attemptsSecondGuesser){
            System.out.println(countAttempts);
        }
    }

    @Override
    public void recordCountAttempts(int countAttempts) {
        attemptsSecondGuesser.add(countAttempts);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private Random random = new Random();

    public SecondGuesser(int max) {
        this.max = max;
    }

    @Override
    public int nextAnswer() {
        int answer;
        if(message == "много"){
            answer = random.nextInt(max) +  lastNumber;
            lastNumber = answer;
        } else if(message == "мало"){
            answer = random.nextInt(lastNumber) + 1;
            lastNumber = answer;
        } else {
            answer = random.nextInt(max) + 1;
            lastNumber = answer;
        }
        return answer;
    }
}
