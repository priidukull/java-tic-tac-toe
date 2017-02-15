package priidukull;

class Communication {
    private final TicTacToeScanner sc;

    Communication(Factory ticTacToeScannerFactory) {
        this.sc = (TicTacToeScanner) ticTacToeScannerFactory.createInstance();
    }

    void printBoard() {
        System.out.println("_______");
        System.out.println("|1|2|3|");
        System.out.println("|4|5|6|");
        System.out.println("|7|8|9|");
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
