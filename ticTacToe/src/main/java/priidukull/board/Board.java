package priidukull.board;

import java.util.*;

public class Board {
    private Map<Integer, Square> squares = new HashMap<Integer, Square>();
    private final List<Integer[]> winCombinations = new ArrayList<Integer[]>();

    public Square getSquare(Integer s) {
        return squares.get(s);
    }

    public STATE getValue(Integer s) {
        return getSquare(s).getValue();
    }

    public Board() {
        for (int i=1; i<=9; i++) {
            squares.put(i, new Square(i));
        }
        winCombinations.add(new Integer[]{1, 2, 3});
        winCombinations.add(new Integer[]{1, 5, 9});
        winCombinations.add(new Integer[]{1, 4, 7});
        winCombinations.add(new Integer[]{2, 5, 8});
        winCombinations.add(new Integer[]{3, 5, 7});
        winCombinations.add(new Integer[]{3, 6, 9});
        winCombinations.add(new Integer[]{4, 5, 6});
        winCombinations.add(new Integer[]{7, 8, 9});
    }

    public void printBoard() {
        System.out.println("_______");
        System.out.println(String.format("|%s|%s|%s|", squares.get(1), squares.get(2), squares.get(3)));
        System.out.println(String.format("|%s|%s|%s|", squares.get(4), squares.get(5), squares.get(6)));
        System.out.println(String.format("|%s|%s|%s|", squares.get(7), squares.get(8), squares.get(9)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board)) return false;

        Board board = (Board) o;

        return squares.equals(board.squares);

    }

    @Override
    public int hashCode() {
        return squares.hashCode();
    }

    public STATE winCondition() {
        for (Integer[] combo : winCombinations) {
            Set<STATE> result = new HashSet<STATE>();
            for (int address : combo) {
                STATE value = getValue(address);
                result.add(value);
            }
            if (result.size() == 1) {
                STATE winner = result.iterator().next();
                if(!winner.equals(STATE.EMPTY)) {
                    return winner;
                }
            }
        }
        return STATE.EMPTY;
    }
}
