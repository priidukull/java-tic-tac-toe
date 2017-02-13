package priidukull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

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
        TicTacToeScannerFactory factory = new TicTacToeScannerFactory();

        new Play(factory).printBoard();

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void printPromptTest() throws Exception {
        String expected = "Make your move, sir\n";
        TicTacToeScannerFactory factory = new TicTacToeScannerFactory();

        new Play(factory).printPrompt();

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void playerInputWithNonNumericInputTest() throws Exception {
        int expected = 1;
        TicTacToeScannerFactory factory = mock(TicTacToeScannerFactory.class);
        TicTacToeScanner sc = mock(TicTacToeScanner.class);
        when(sc.readInput()).thenAnswer(new Answer<Object>() {
            private int count = 0;
            public Object answer(InvocationOnMock invocation) throws Throwable {
                if (count++ == 0)
                    throw new InputMismatchException();
                return 1;
            }
        });
        when(factory.createInstance()).thenReturn(sc);

        assertEquals(expected, new Play(factory).playerInput());
    }
}
