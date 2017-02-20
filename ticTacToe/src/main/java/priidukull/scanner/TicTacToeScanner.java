package priidukull.scanner;

import java.util.Scanner;

public class TicTacToeScanner implements priidukull.scanner.Scanner {

    public String readInput() {
        return new Scanner(System.in).nextLine();
    }
}
