package priidukull;

import java.util.InputMismatchException;
import java.util.Scanner;

class TicTacToeScanner implements priidukull.Scanner {

    int readInput() {
        return new Scanner(System.in).nextInt();
    }

    public int playerInput() {
        try {
            return readInput();
        } catch (InputMismatchException e) {
            return -1;
        }
    }
}
