package priidukull;

import priidukull.board.STATE;

import static priidukull.board.STATE.O;
import static priidukull.board.STATE.X;

class TicTacToeRunner implements Runnable {
    private Alexa alexa;
    private STATE activePlayer = X;

    TicTacToeRunner(Alexa alexa) {
        this.alexa = alexa;
    }

    public void run() {
        while (true) {
            alexa.getBoard().printBoard();
            alexa.printPrompt();
            playerTurn();
        }
    }

    void playerTurn() {
        alexa.playerInput(activePlayer);
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
