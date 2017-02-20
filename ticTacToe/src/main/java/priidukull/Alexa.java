package priidukull;

import priidukull.board.Board;
import priidukull.board.STATE;
import priidukull.board.Square;
import priidukull.exceptions.SquareOccupiedException;

class Alexa {
    private final TicTacToeScanner sc;
    private Board board;

    Board getBoard() {
        return board;
    }

    Alexa(Factory ticTacToeScannerFactory, Factory boardFactory) {
        this.sc = (TicTacToeScanner) ticTacToeScannerFactory.createInstance();
        this.board = (Board) boardFactory.createInstance();
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
            if (s.getValue() != STATE.EMPTY) {
                throw new SquareOccupiedException(String.format("Square %s has already been occupied. Please choose another square", s.getAddress()));
            }
            s.setValue(activePlayer);
        } catch (NumberFormatException e) {
            System.out.println("Please insert a number in the range 0-9");
            playerInput(activePlayer);
        } catch (SquareOccupiedException e) {
            System.out.println(e.getMessage());
            playerInput(activePlayer);
        }
    }
}

