package priidukull;

public class Main {
    public static void main(String[] args) {
        TicTacToeScannerFactory ticTacToeScannerFactory = new TicTacToeScannerFactory();
        Alexa alexa = new Alexa(ticTacToeScannerFactory);
        TicTacToeRunner runner = new TicTacToeRunner(alexa);
        runner.run();
    }
}
