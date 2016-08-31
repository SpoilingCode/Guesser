package edu.opendev;

import edu.opendev.guess.GameGuess;
import edu.opendev.guess.Guesser;
import edu.opendev.guess.Player;

public class Main {
    public static void main(String[] args) {
        GameGuess player = new GameGuess(100, new Player());
        player.start();

        GameGuess guesser = new GameGuess(100, new Guesser(100));
        guesser.start();
    }
}
