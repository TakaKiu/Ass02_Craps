import java.util.Random;
import java.util.Scanner;

class CrapsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int dice1 = rollDice(random);
            int dice2 = rollDice(random);
            int sum = dice1 + dice2;

            System.out.println("Rolling the dice...");
            System.out.println("Die 1: " + dice1);
            System.out.println("Die 2: " + dice2);
            System.out.println("Sum: " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose!");
                playAgain = promptToPlayAgain(scanner);
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
                playAgain = promptToPlayAgain(scanner);
            } else {
                int point = sum;
                System.out.println("Point is set to " + point);
                System.out.println("Trying for point...");

                boolean gameOver = false;
                while (!gameOver) {
                    dice1 = rollDice(random);
                    dice2 = rollDice(random);
                    sum = dice1 + dice2;

                    System.out.println("Rolling the dice...");
                    System.out.println("Die 1: " + dice1);
                    System.out.println("Die 2: " + dice2);
                    System.out.println("Sum: " + sum);

                    if (sum == point) {
                        System.out.println("Made point! You win!");
                        gameOver = true;
                        playAgain = promptToPlayAgain(scanner);
                    } else if (sum == 7) {
                        System.out.println("Got a seven! You lose!");
                        gameOver = true;
                        playAgain = promptToPlayAgain(scanner);
                    }
                }
            }
        }

        System.out.println("Thanks for playing Craps!");
    }

    private static int rollDice(Random random) {
        return random.nextInt(6) + 1;
    }

    private static boolean promptToPlayAgain(Scanner scanner) {
        System.out.print("Play again? (y/n): ");
        String input = scanner.next();
        return input.equalsIgnoreCase("y");
    }
}
