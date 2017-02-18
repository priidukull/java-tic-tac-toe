package priidukull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

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
        int expected = 1;
        TicTacToeScannerFactory factory = mock(TicTacToeScannerFactory.class);
        TicTacToeScanner sc = mock(TicTacToeScanner.class);
        when(sc.readInput()).thenAnswer(new Answer<Object>() {
            private int count = 0;
            public String answer(InvocationOnMock invocation) throws Throwable {
                if (count++ == 0)
                    return "foo";
                return "1";
            }
        });
        when(factory.createInstance()).thenReturn(sc);

        assertEquals(expected, new Alexa(factory).playerInput());
    }

    @Test
    public void playerInputNotInRangeTest() {
        int expected = 1;
        TicTacToeScannerFactory factory = mock(TicTacToeScannerFactory.class);
        TicTacToeScanner sc = mock(TicTacToeScanner.class);
        when(sc.readInput()).thenAnswer(new Answer<Object>() {
            private int count = 0;
            public String answer(InvocationOnMock invocation) throws Throwable {
                if (count++ == 0)
                    return "11";
                return "1";
            }
        });
        when(factory.createInstance()).thenReturn(sc);

        assertEquals(expected, new Alexa(factory).playerInput());
    }

    @Test
    public void playerInputFloatTest() {
        int expected = 1;
        TicTacToeScannerFactory factory = mock(TicTacToeScannerFactory.class);
        TicTacToeScanner sc = mock(TicTacToeScanner.class);
        when(sc.readInput()).thenAnswer(new Answer<Object>() {
            private int count = 0;
            public String answer(InvocationOnMock invocation) throws Throwable {
                if (count++ == 0)
                    return "5.1";
                return "1";
            }
        });
        when(factory.createInstance()).thenReturn(sc);

        assertEquals(expected, new Alexa(factory).playerInput());
    }
}