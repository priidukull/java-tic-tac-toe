package priidukull.play;


import priidukull.board.STATE;

import static priidukull.board.STATE.O;
import static priidukull.board.STATE.X;

public class Turn {
    private Alexa alexa;
    private STATE activePlayer = X;

    public Turn(Alexa alexa) {
        this.alexa = alexa;
    }

    public void run() {
        for (int i=1; i<=9; i++) {
            alexa.getBoard().printBoard();
            alexa.printPrompt();
            playerTurn();
        }
    }

    public void playerTurn() {
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
