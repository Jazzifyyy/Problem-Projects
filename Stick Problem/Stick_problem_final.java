import java.util.Scanner;
import java.util.Random;

public class Stick_problem_final {
    static Scanner sc = new Scanner(System.in);
    public static int n;
    public static int turn;

    public static void menu() {
        System.out.println("There are " + n + " sticks.");
        if (turn == 0 && n != 0) {
            int keep = 0;
            // Input validation loop
            while (true) {
                System.out.print("Enter number of sticks to keep (1 to 3): ");
                keep = sc.nextInt();
                if (keep >= 1 && keep <= 3 && keep <= n) {
                    break; // Valid input
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            }
            n -= keep;
            turn = 1;
        }

        if (turn == 1 && n != 0) {
            game();
        }

        if (n == 0) {
            if (turn == 1) {
                System.out.println("You lost.");
            } else {
                System.out.println("You won.");
            }
            System.exit(0);
        }
    }

    public static void game() {
        turn = 0;
        int computerKeep;

        if (n % 4 == 0) {
            computerKeep = 3;
        } else if (n % 4 == 1) {
            computerKeep = 1;
        } else if (n % 4 == 2) {
            computerKeep = 1;
        } else {
            computerKeep = 2;
        }

        n -= computerKeep;
        System.out.println("The computer has kept " + computerKeep + " stick(s).\n");
        menu();
    }

    public static void main(String[] args) {
        Random ran = new Random();
        n = ran.nextInt(30) + 10; // Ensuring at least 10 sticks for more engaging gameplay
        turn = ran.nextInt(2);
        System.out.println("Game Start!");
        System.out.println("Initial number of sticks: " + n);
        System.out.println(turn == 0 ? "You go first!" : "Computer goes first!");
        menu();
    }
}

