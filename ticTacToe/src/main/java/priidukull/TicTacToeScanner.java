package priidukull;

import java.util.Scanner;

class TicTacToeScanner implements priidukull.Scanner {

    public String readInput() {
        return new Scanner(System.in).nextLine();
    }
}
