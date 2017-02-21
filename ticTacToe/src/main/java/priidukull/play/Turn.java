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

    void playerTurn() {
        alexa.printPrompt(activePlayer);
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
