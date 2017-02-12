package priidukull;

public class Play {
    void printBoard() {
        System.out.println("_______");
        System.out.println("|1|2|3|");
        System.out.println("|4|5|6|");
        System.out.println("|7|8|9|");
    }

    int playerInput() {
        TicTacToeScanner sc = new TicTacToeScanner();
        return sc.readInput();
    }

    void printPrompt() {
        System.out.println("Make your move, sir");
    }

    public static void main(String[] args) {
        Play play = new Play();
        TicTacToeScanner sc = new TicTacToeScanner();
        play.printBoard();
        play.printPrompt();
        int input = play.playerInput();
        //int input = play.readInput();

    }

}
