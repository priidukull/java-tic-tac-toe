package priidukull;

class Alexa {
    private final TicTacToeScanner sc;

    Alexa(Factory ticTacToeScannerFactory) {
        this.sc = (TicTacToeScanner) ticTacToeScannerFactory.createInstance();
    }

    void printPrompt() {
        System.out.println("Make your move, sir");
    }

    int playerInput() {
        String input = sc.readInput();
        try {
            int inputNumber = Integer.parseInt(input);
            if (inputNumber < 1 || inputNumber > 9) {
                throw new NumberFormatException();
            }
            return inputNumber;
        } catch (NumberFormatException e) {
            System.out.println("Please insert a number in the range 0-9");
            return playerInput();
        }
    }
}
