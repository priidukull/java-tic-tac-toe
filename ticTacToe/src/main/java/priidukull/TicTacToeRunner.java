package priidukull;

import priidukull.board.Board;
import priidukull.board.Square;

import static priidukull.board.STATE.X;

class TicTacToeRunner implements Runnable {
    private Alexa c;
    private Board board = new Board();

    TicTacToeRunner() {
        TicTacToeScannerFactory factory = new TicTacToeScannerFactory();
        this.c = new Alexa(factory);
    }

    public void run() {
        playerTurn();
    }

    void playerTurn() {
        board.printBoard();
        c.printPrompt();
        int input = c.playerInput();
        Square s = (Square) board.getSquares().get(input);
        s.setValue(X);
    }
}
