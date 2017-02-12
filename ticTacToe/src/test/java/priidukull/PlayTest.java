package priidukull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PlayTest {
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

         new Play().printBoard();

         assertEquals(expected, outContent.toString());
    }

    @Test
    public void printPromptTest() throws Exception {
        String expected = "Make your move, sir\n";

        new Play().printPrompt();

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void playerInputTest() throws Exception {
        int expected = 5;
        TicTacToeScanner sc = mock(TicTacToeScanner.class);
        when(sc.readInput()).thenReturn(5);

        int actual = new Play().playerInput();

        assertEquals(expected, actual);
    }


}
