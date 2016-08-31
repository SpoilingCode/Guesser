package edu.opendev;

import edu.opendev.guess.GameGuess;
import edu.opendev.guess.Guesser;
import edu.opendev.guess.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Меню");
        System.out.println("Вы - 1");
        System.out.println("Бот - 2");
        System.out.println("Выход - 0");
        System.out.println("Выберите тип отвечающего на вопросы: ");
        Scanner scanner = new Scanner(System.in);
        int selectedCommand = Integer.parseInt(scanner.nextLine());
        boolean showMenu = true;

        while(showMenu) {
            switch (selectedCommand) {
                case 1:
                    GameGuess player = new GameGuess(100, new Player());
                    player.start();
                    System.out.printf("Вы угадали за %d попыток ",
                                  player.getCountAttempts());
                    break;

                case 2:
                    GameGuess guesser = new GameGuess(100, new Guesser(100));
                    guesser.start();
                    System.out.printf(guesser + " угадал за %d попыток ",
                                     guesser.getCountAttempts());
                    break;

                case 0:
                    showMenu = false;
                    break;

                default:
                    System.out.println("Данная команда отсутствует в меню");
                    break;
            }
        }
    }
}
