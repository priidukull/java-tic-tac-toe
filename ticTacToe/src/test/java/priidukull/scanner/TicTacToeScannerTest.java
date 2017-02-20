package priidukull.scanner;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class TicTacToeScannerTest {

    @Test
    public void readInputTest() throws Exception {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(input, new TicTacToeScanner().readInput());
    }

    @Test
    public void readInputWithNonNumericInputTest() {
        String input = "foo";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(input, new TicTacToeScanner().readInput());
    }
}