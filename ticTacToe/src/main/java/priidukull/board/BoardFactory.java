package priidukull.board;

import priidukull.Factory;

public class BoardFactory implements Factory {
    public Object createInstance() {
        return new Board();
    }
}
