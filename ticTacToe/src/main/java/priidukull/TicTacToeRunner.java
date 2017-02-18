package priidukull;

import priidukull.board.Board;
import priidukull.board.STATE;
import priidukull.board.Square;

import static priidukull.board.STATE.O;
import static priidukull.board.STATE.X;

class TicTacToeRunner implements Runnable {
    private Alexa alexa;
    private static Board board = new Board();
    private STATE activePlayer = X;

    static Board getBoard() {
        return board;
    }

    TicTacToeRunner(Alexa alexa) {
        this.alexa = alexa;
    }

    public void run() {
        while (true) {
            board.printBoard();
            playerTurn();
        }
    }

    void playerTurn() {
        alexa.printPrompt();
        int input = alexa.playerInput();
        Square s = (Square) board.getSquares().get(input);
        s.setValue(activePlayer);
        setActivePlayer();
    }

    private void setActivePlayer() {
        if (activePlayer == X) {
            activePlayer = O;
        } else {
            activePlayer = X;
        }
    }
}
