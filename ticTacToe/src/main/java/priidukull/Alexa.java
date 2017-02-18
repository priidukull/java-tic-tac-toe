package priidukull;

import priidukull.board.Board;
import priidukull.board.STATE;
import priidukull.board.Square;

class Alexa {
    private final TicTacToeScanner sc;
    private Board board = new Board();

    Board getBoard() {
        return board;
    }

    Alexa(Factory ticTacToeScannerFactory) {
        this.sc = (TicTacToeScanner) ticTacToeScannerFactory.createInstance();
    }

    void printPrompt() {
        System.out.println("Make your move, sir");
    }

    void playerInput(STATE activePlayer) {
        String input = sc.readInput();
        try {
            Integer inputNumber = Integer.parseInt(input);
            if (inputNumber < 1 || inputNumber > 9) {
                throw new NumberFormatException();
            }
            Square s = getBoard().getSquare(inputNumber);
            s.setValue(activePlayer);
        } catch (NumberFormatException e) {
            System.out.println("Please insert a number in the range 0-9");
            playerInput(activePlayer);
        }
    }
}
