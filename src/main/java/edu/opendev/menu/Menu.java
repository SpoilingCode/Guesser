package edu.opendev.menu;

import edu.opendev.guess.*;

import java.util.Scanner;

public class Menu {
    private int selectedCommand;
    private boolean showMenu = true;

    public void launchMenu() {
        Scanner scanner = new Scanner(System.in);
        long startTime;
        int countAttempts;

        while (showMenu) {
            printMenu();
            selectedCommand = Integer.parseInt(scanner.nextLine());
            switch (selectedCommand) {
                case 1:
                    FirstGuesser firstGuesser = new FirstGuesser(100);
                    GameGuess guesser = new GameGuess(100, firstGuesser);
                    startTime = guesser.getStartTime();
                    guesser.start();
                    System.out.printf("Затраченное время на угадывание %d",
                            guesser.getDuration(startTime));
                    countAttempts = guesser.getCountAttempts();
                    System.out.printf( "\nFirstGuesser угадал за %d попыток\n ",
                            countAttempts);
                    firstGuesser.recordCountAttempts(countAttempts);
                    firstGuesser.printAllAttempts();
                    break;

                case 2:
                    SecondGuesser secondGuesser = new SecondGuesser(100);
                    GameGuess guess = new GameGuess(100, secondGuesser);
                    secondGuesser.setMessage(guess.getMessage());
                    startTime = guess.getStartTime();
                    guess.start();
                    System.out.printf("Затраченное время на угадывание %d",
                            guess.getDuration(startTime));
                    countAttempts = guess.getCountAttempts();
                    System.out.printf( "\nSecondGuesser угадал за %d попыток\n ",
                            countAttempts);
                    secondGuesser.recordCountAttempts(countAttempts);
                    secondGuesser.printAllAttempts();
                    break;

                case 3:
                    Player player = new Player();
                    GameGuess gameGues = new GameGuess(100, player );
                    startTime = gameGues.getStartTime();
                    gameGues.start();
                    System.out.printf("Затраченное время на угадывание %d second",
                            gameGues.getDuration(startTime));
                    countAttempts = gameGues.getCountAttempts();
                    System.out.printf("\nВы угадали за %d попыток\n ",
                            countAttempts);
                    player.recordCountAttempts(countAttempts);
                    player.printAllAttempts();
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
        System.out.println("\nВыберите отвечающего:");
        System.out.println("Первый бот - 1");
        System.out.println("Второй бот - 2");
        System.out.println("Вы - 3");
        System.out.println("Выход - 0");
    }
}
