package priidukull;

public class Main {
    public static void main(String[] args) {
        TicTacToeScannerFactory ticTacToeScannerFactory = new TicTacToeScannerFactory();
        Play play = new Play(ticTacToeScannerFactory);
        play.run();
    }
}
