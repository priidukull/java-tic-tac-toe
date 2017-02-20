package priidukull.factory;

import priidukull.scanner.TicTacToeScanner;

public class ScannerFactory implements Factory {

    public Object createInstance() {
        return new TicTacToeScanner();
    }
}
