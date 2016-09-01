package edu.opendev.guess;

import java.util.ArrayList;
import java.util.List;

public interface Respondent {
    List<Integer> attemptsPlayer = new ArrayList<Integer>();
    List<Integer> attemptsSecondGuesser = new ArrayList<Integer>();
    List<Integer> attemptsFirstGuesser = new ArrayList<Integer>();

    int nextAnswer();
    void recordCountAttempts(int countAttempts);
    void printAllAttempts();
}
