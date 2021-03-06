package priidukull.board;

public class Square {
    private int address;
    private STATE value = STATE.EMPTY;

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public STATE getValue() {
        return value;
    }

    public void setValue(STATE value) {
        this.value = value;
    }

    public Square(int address) {
        this.address = address;
    }

    public String toString() {
        return value.equals(STATE.EMPTY) ? Integer.toString(address) : value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square square = (Square) o;

        if (getAddress() != square.getAddress()) return false;
        return getValue() == square.getValue();

    }

    @Override
    public int hashCode() {
        int result = getAddress();
        result = 31 * result + getValue().hashCode();
        return result;
    }
}

