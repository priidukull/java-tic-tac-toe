package priidukull.factory;

import priidukull.board.Board;

public class BoardFactory implements Factory {
    public Object createInstance() {
        return new Board();
    }
}
