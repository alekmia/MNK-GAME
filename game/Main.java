package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("What board would you like to play on:\nm = ");
        int n = sc.nextInt();
        System.out.print("n = ");
        int m = sc.nextInt();
        System.out.print("k = ");
        int k = sc.nextInt();

        boolean choosingOpponent = true;
        Player opponent = new HumanPlayer(new Scanner(System.in));
        while(choosingOpponent) {
            System.out.print("""
                    1 - another human\s
                    2 - random player\s
                    3 - sequential player\s
                    4 - a cheater\s
                    Who would you like to face (type the number):""");
            int player = sc.nextInt();
            choosingOpponent = false;
            switch(player) {
                case 1:
                    opponent = new HumanPlayer(new Scanner(System.in));
                    break;
                case 2:
                    opponent = new RandomPlayer(m, n);
                    break;
                case 3:
                    opponent = new SequentialPlayer(m, n);
                    break;
                case 4:
                    opponent = new CheatingPlayer(m, n, k);
                default:
                    choosingOpponent = true;
                    System.out.println("that doesnt equal to an opponent! Try again");
            }
        }

        final int result = new TwoPlayerGame(
                new MNKBoard(m, n, k),
                opponent,
                new HumanPlayer(new Scanner(System.in))
        ).play(true);
        switch (result) {
            case 1 -> System.out.println("First player won");
            case 2 -> System.out.println("Second player won");
            case 0 -> System.out.println("Draw");
            default -> throw new AssertionError("Unknown result " + result);
        }
    }
}
