import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //objects
        Random randomNumber = new Random();
        Scanner challenge = new Scanner(System.in);
        Scanner tries = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner userReply = new Scanner(System.in);


        //variables
        int i;
        int numeroRandom1 = 0;
        String difficult;
        String range = "";
        int attempsNumber;


        System.out.println("Choose the difficult: 1. Easy, 2. Medium, 3. Hard");
        difficult = challenge.next();


        while (!difficult.equals("Easy") && !difficult.equals("1") && !difficult.equals("Medium") && !difficult.equals("2") && !difficult.equals("Hard") && !difficult.equals("3")){
            System.out.println("Incorrect value. Choose the difficult: 1. Easy, 2. Medium, 3. Hard");
            difficult = challenge.next();
        }

            switch (difficult) {
                case "Easy", "1" -> {
                    numeroRandom1 = randomNumber.nextInt(10) + 1;
                    System.out.println("Numbers 1-10");
                    range = "1-10";
                }

                case "Medium", "2" -> {
                    numeroRandom1 = randomNumber.nextInt(50) + 1;
                    System.out.println("Numbers 1-50");
                    range = "1-50";
                }
                case "Hard", "3" -> {
                    numeroRandom1 = randomNumber.nextInt(100) + 1;
                    System.out.println("Numbers 1-100");
                    range = "1-100";
                }
            }

        System.out.println("Enter the number of attempts you want ");
        attempsNumber = tries.nextInt();


        System.out.println("Guess the number between " + range);


        for (i = 0; i < attempsNumber; attempsNumber--) {
            int answer = sc.nextInt();
            if (numeroRandom1 == answer) {
                System.out.println("correct");
                i = attempsNumber;

            } else if (numeroRandom1 < answer) {
                System.out.println("the number is lower than " + answer);
                System.out.println(attempsNumber - 1 + " remaining attempts");

            } else {
                System.out.println("the number is higher than " + answer);
                System.out.println(attempsNumber - 1 + " remaining attempts");

            }
        }
        System.out.println("The number was " + numeroRandom1);

        System.out.println("Do you want to play again? Answer with Y/N");
        String answer = userReply.nextLine().toLowerCase();
        if ("y".equals(answer)) {
            main(args);
        } else {
            System.out.println("game exit");
        }
    }

}
