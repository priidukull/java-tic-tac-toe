package priidukull;

import priidukull.factory.BoardFactory;
import priidukull.play.Alexa;
import priidukull.play.TicTacToeRunner;
import priidukull.factory.ScannerFactory;
import priidukull.play.Turn;

public class Main {
    public static void main(String[] args) {
        ScannerFactory scannerFactory = new ScannerFactory();
        BoardFactory boardFactory = new BoardFactory();
        Alexa alexa = new Alexa(scannerFactory, boardFactory);
        TicTacToeRunner runner = new TicTacToeRunner(alexa, new Turn(alexa));
        runner.run();
    }
}
