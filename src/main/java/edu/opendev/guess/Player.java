package edu.opendev.guess;

import java.util.Scanner;

public class Player implements Respondent{

    @Override
    public void printAllAttempts() {
        System.out.println("\nВаша статитика: ");
        for(Integer countAttempts : attemptsPlayer){
            System.out.println(countAttempts );
        }
    }

    @Override
    public void recordCountAttempts(int countAttempts) {
        attemptsPlayer.add(countAttempts);
    }

    @Override
    public int nextAnswer() {
        int answer;
        System.out.println("ваш ответ:");
        Scanner in = new Scanner(System.in);
        answer = in.nextInt();
        return answer;
    }
}
