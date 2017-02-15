package priidukull;

class TicTacToeRunner implements Runnable {
    private Communication c;

    TicTacToeRunner() {
        TicTacToeScannerFactory factory = new TicTacToeScannerFactory();
        this.c = new Communication(factory);
    }

    public void run() {
        c.printBoard();
        c.printPrompt();
        int input = c.playerInput();
        //int input = play.readInput();
    }
}
