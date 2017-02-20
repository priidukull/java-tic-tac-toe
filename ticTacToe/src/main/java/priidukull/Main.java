package priidukull;

import priidukull.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
        TicTacToeScannerFactory ticTacToeScannerFactory = new TicTacToeScannerFactory();
        BoardFactory boardFactory = new BoardFactory();
        Alexa alexa = new Alexa(ticTacToeScannerFactory, boardFactory);
        TicTacToeRunner runner = new TicTacToeRunner(alexa);
        runner.run();
    }
}
