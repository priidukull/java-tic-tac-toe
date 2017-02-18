package priidukull.board;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void printBoardTest() throws Exception {
        String expected = "_______\n|1|2|3|\n|4|5|6|\n|7|8|9|\n";

        new Board().printBoard();

        assertEquals(expected, outContent.toString());
    }
}
