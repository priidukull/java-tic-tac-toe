package priidukull;

class TicTacToeScannerFactory implements Factory {

    public Object createInstance() {
        return new TicTacToeScanner();
    }
}
