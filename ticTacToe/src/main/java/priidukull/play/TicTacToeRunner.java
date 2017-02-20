package priidukull.play;

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
            alexa.printPrompt();
            turn.playerTurn();
        }
    }
}
