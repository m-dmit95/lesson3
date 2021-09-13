package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    public static void main(String[] args) {
        /*
        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
        Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.

        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)

        Для сравнения двух слов посимвольно, можно пользоваться:
        String str = "apple";
        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово
        Используем только маленькие буквы
        */
        playGame();
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        String answer;
        String result;
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"
        };
        System.out.println(
                "Guess the Word!\n" +
                "Я загадал одно из этих слов:\n" +
                Arrays.toString(words) + "\nТебе нужно его отгадать."
        );
        String guessed_word = words[rand.nextInt(words.length)];
        while (true) {
            result = "";
            System.out.println("Введи ответ:");
            answer = scanner.nextLine();
            if (answer.equals(guessed_word)) {
                System.out.println("Вы угадали!\nСпасибо за игру!");
                scanner.close();
                break;
            }
            for (int i = 0; i < 15; i++) {
                if (i < answer.length() && i < guessed_word.length()) {
                    if (guessed_word.charAt(i) == answer.charAt(i)) {
                        result += answer.charAt(i);
                    }
                    else {
                        result += "#";
                    }
                }
                else {
                    result += "#";
                }
            }
            System.out.println(result);
        }
    }
}
