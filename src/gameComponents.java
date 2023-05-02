import java.util.Random;
import java.util.Scanner;

public class gameComponents {
    public static void startGame() {
        Random randomNumber = new Random();
        Scanner challenge = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        int i;
        int numberToGuess = 0;
        String range = "";
        int attempsNumber ;
        String again;

        chooseDifficulty gameDifficult = getChooseDifficulty(randomNumber, challenge, numberToGuess, range);

        do {
            try {
                System.out.println("Enter the number of attempts you want ");
                attempsNumber = sc.nextInt();
                if (attempsNumber <= 0) {
                    System.out.println("Error: the number of attempts should be greater than zero.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: invalid input. Please enter a valid number.");
                sc.next(); // consume the invalid input
            }
        } while (true);


        System.out.println("Guess the number between " + gameDifficult.range());


        for (i = 0; i < attempsNumber; attempsNumber--) {
            int answer = sc.nextInt();
            if (gameDifficult.numberToGuess() == answer) {
                System.out.println("correct");
                i = attempsNumber;

            } else if (gameDifficult.numberToGuess() < answer) {
                System.out.println("the number is lower than " + answer);
                System.out.println(attempsNumber - 1 + " remaining attempts");

            } else {
                System.out.println("the number is higher than " + answer);
                System.out.println(attempsNumber - 1 + " remaining attempts");

            }
        }
        System.out.println("The number was " + gameDifficult.numberToGuess());

        System.out.println("Do you want to play again? Answer with Y/N");
        again = sc.next().toUpperCase();
        if ("Y".equals(again)) {
            startGame();
        } else {
            System.out.println("game exit");
        }
    }

    public static boolean optionIsNotValid(String difficult) {
        return !difficult.equals("Easy") && !difficult.equals("1") && !difficult.equals("Medium") && !difficult.equals("2") && !difficult.equals("Hard") && !difficult.equals("3");
    }

    private static chooseDifficulty getChooseDifficulty(Random randomNumber, Scanner challenge, int numberToGuess, String range) {
        String difficult;
        System.out.println("Choose the difficult: 1. Easy, 2. Medium, 3. Hard");
        difficult = challenge.next();


        while (optionIsNotValid(difficult)) {
            System.out.println("Incorrect value. Choose the difficult: 1. Easy, 2. Medium, 3. Hard");
            difficult = challenge.next();
        }

        switch (difficult) {
            case "Easy", "1" -> {
                numberToGuess = randomNumber.nextInt(10) + 1;
                System.out.println("Numbers 1-10");
                range = "1-10";
            }

            case "Medium", "2" -> {
                numberToGuess = randomNumber.nextInt(50) + 1;
                System.out.println("Numbers 1-50");
                range = "1-50";
            }
            case "Hard", "3" -> {
                numberToGuess = randomNumber.nextInt(100) + 1;
                System.out.println("Numbers 1-100");
                range = "1-100";
            }
        }
        return new chooseDifficulty(numberToGuess, range);

    }
    private record chooseDifficulty(int numberToGuess, String range) {

    }
}
