package priidukull.play;

import priidukull.board.STATE;

public class TicTacToeRunner implements Runnable {
    private Alexa alexa;
    private Turn turn;

    public TicTacToeRunner(Alexa alexa, Turn turn) {
        this.alexa = alexa;
        this.turn = turn;
    }

    public void run() {
        for (int i=1; i<=9; i++) {
            alexa.getBoard().printBoard();
            turn.playerTurn();
            STATE winner = alexa.getBoard().winCondition();
            if (!winner.equals(STATE.EMPTY)) {
                alexa.getBoard().printBoard();
                System.out.println(String.format("Player %s won!", winner));
                return;
            };
        }
        alexa.getBoard().printBoard();
        System.out.println("The game ended in a draw!");
    }

}
