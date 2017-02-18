package priidukull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import priidukull.board.STATE;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AlexaTest {
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
    public void printPromptTest() throws Exception {
        String expected = "Make your move, sir\n";
        TicTacToeScannerFactory factory = new TicTacToeScannerFactory();

        new Alexa(factory).printPrompt();

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void playerInputWithNonNumericInputTest() throws Exception {
        TicTacToeScannerFactory factory = mock(TicTacToeScannerFactory.class);
        TicTacToeScanner scanner = mock(TicTacToeScanner.class);
        when(scanner.readInput()).thenAnswer(new Answer<String>() {
            private int count = 0;
            public String answer(InvocationOnMock invocation) throws Throwable {
                if (count++ == 0)
                    return "foo";
                return "1";
            }
        });
        when(factory.createInstance()).thenReturn(scanner);
        Alexa alexa = new Alexa(factory);

        alexa.playerInput(STATE.X);

        assertEquals(STATE.X, alexa.getBoard().getValue(1));
    }

    @Test
    public void playerInputNotInRangeTest() {
        TicTacToeScannerFactory factory = mock(TicTacToeScannerFactory.class);
        TicTacToeScanner scanner = mock(TicTacToeScanner.class);
        when(scanner.readInput()).thenAnswer(new Answer<Object>() {
            private int count = 0;
            public String answer(InvocationOnMock invocation) throws Throwable {
                if (count++ == 0)
                    return "11";
                return "1";
            }
        });
        when(factory.createInstance()).thenReturn(scanner);
        Alexa alexa = new Alexa(factory);

        alexa.playerInput(STATE.X);

        assertEquals(STATE.X, alexa.getBoard().getValue(1));
    }

    @Test
    public void playerInputFloatTest() {
        TicTacToeScannerFactory factory = mock(TicTacToeScannerFactory.class);
        TicTacToeScanner scanner = mock(TicTacToeScanner.class);
        when(scanner.readInput()).thenAnswer(new Answer<Object>() {
            private int count = 0;
            public String answer(InvocationOnMock invocation) throws Throwable {
                if (count++ == 0)
                    return "5.1";
                return "1";
            }
        });
        when(factory.createInstance()).thenReturn(scanner);
        Alexa alexa = new Alexa(factory);

        alexa.playerInput(STATE.X);

        assertEquals(STATE.X, alexa.getBoard().getValue(1));
    }

    @Test
    public void playerInputSquareNotEmptyTest() {

    }
}
