package edu.opendev.menu;

import edu.opendev.guess.GameGuess;
import edu.opendev.guess.Guesser;
import edu.opendev.guess.Player;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
    private int selectedCommand;
    private boolean showMenu = true;

    public void launchMenu() {
        Scanner scanner = new Scanner(System.in);
        long startTime;

        while (showMenu) {
            printMenu();
            selectedCommand = Integer.parseInt(scanner.nextLine());
            switch (selectedCommand) {
                case 1:
                    GameGuess player = new GameGuess(100, new Player());
                    startTime = player.getStartTime();
                    player.start();
                    System.out.printf("Затраченное время на угадывание %d second",
                                    player.getDuration(startTime));
                    System.out.printf("\nВы угадали за %d попыток\n ",
                    player.getCountAttempts());
                    break;

                case 2:
                    GameGuess guesser = new GameGuess(100, new Guesser(100));
                    startTime = guesser.getStartTime();
                    guesser.start();
                    System.out.printf("Затраченное время на угадывание %d",
                                     guesser.getDuration(startTime));
                    System.out.printf( "\nGuesser угадал за %d попыток\n ",
                    guesser.getCountAttempts());
                    break;

                case 0:
                    showMenu = false;
                    System.out.println("Работа программы завершена.");
                    break;

                default:
                    System.out.println("Данная команда отсутствует в меню");
                    break;
            }

        }
    }

    private void printMenu(){
        System.out.println("\nВыбор отвечающего:");
        System.out.println("Вы - 1");
        System.out.println("Бот - 2");
        System.out.println("Выход - 0");
    }
}
