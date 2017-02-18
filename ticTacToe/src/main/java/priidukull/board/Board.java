package priidukull.board;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map squares = new HashMap<Integer, Square>();

    public Square getSquare(Integer s) {
        return (Square) squares.get(s);
    }

    public STATE getValue(Integer s) {
        return getSquare(s).getValue();
    }

    public void setSquares(Map squares) {
        this.squares = squares;
    }

    public Board() {
        for (int i=1; i<=9; i++) {
            squares.put(i, new Square(i));
        }
    }

    public void printBoard() {
        System.out.println("_______");
        System.out.println(String.format("|%s|%s|%s|", squares.get(1), squares.get(2), squares.get(3)));
        System.out.println(String.format("|%s|%s|%s|", squares.get(4), squares.get(5), squares.get(6)));
        System.out.println(String.format("|%s|%s|%s|", squares.get(7), squares.get(8), squares.get(9)));
    }
}
