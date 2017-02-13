package priidukull;

import java.util.InputMismatchException;

public class Play implements Runnable {
    private final TicTacToeScanner sc;

    Play(Factory ticTacToeScannerFactory) {
        this.sc = (TicTacToeScanner) ticTacToeScannerFactory.createInstance();
    }

    void printBoard() {
        System.out.println("_______");
        System.out.println("|1|2|3|");
        System.out.println("|4|5|6|");
        System.out.println("|7|8|9|");
    }

    void printPrompt() {
        System.out.println("Make your move, sir");
    }

    public int playerInput() {
        try {
            return sc.readInput();
        } catch (InputMismatchException e) {
            return playerInput();
        }
    }

    public void run() {
        printBoard();
        printPrompt();
        int input = playerInput();
        //int input = play.readInput();
    }
}
