package lesson3;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* 1. Написать программу, которая загадывает случайное число от 0 до 9,
        и пользователю дается 3 попытки угадать это число.
        При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
        После победы или проигрыша выводится запрос –
        «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет). */
        playGame();
    }

    private static void playGame() {
        Random rand = new Random();
        int guessed_num;
        int answer;
        int replay;
        while (true) {
            guessed_num = rand.nextInt(10);
            System.out.println("Guess the number!\n" +
                    "Я загадал число от 0 до 9. У тебя есть три попытки отгадать данное число.");
            for (int i = 0; i < 3; i++) {
                answer = getNumberFromScanner("Введи число от 0 до 9:", 0, 9);
                if (guessed_num < answer) {
                    System.out.println("Загаданное число меньше");
                }
                else if (guessed_num > answer) {
                    System.out.println("Загаданное число больше");
                }
                else {
                    System.out.println("Вы победили!");
                    break;
                }
            }
            replay = getNumberFromScanner("Повторить игру еще раз? 1 – да / 0 – нет", 0, 1);
            if (replay == 0) {
                scanner.close();
                System.out.println("Спасибо за игру!");
                break;
            }
        }
    }

    public static int getNumberFromScanner(String message, int min, int max) {
        int x;
        do {
            System.out.println(message);
            x = scanner.nextInt();
        } while (x < min || x > max);
        return x;
    }
}
