package priidukull;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TicTacToeScannerTest {

    @Test
    public void readInputTest() throws Exception {
        int expected = 5;
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int actual = new TicTacToeScanner().readInput();

        assertEquals(expected, actual);
    }

    @Test(expected=InputMismatchException.class)
    public void readInputWithNonNumericInputTest() {
        String input = "foo";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        new TicTacToeScanner().readInput();

        assertTrue(true);
    }

}
