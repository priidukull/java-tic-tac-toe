package priidukull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import priidukull.board.Board;
import priidukull.board.BoardFactory;
import priidukull.board.STATE;
import priidukull.board.Square;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AlexaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private TicTacToeScannerFactory ticTacToeScannerFactory;
    private TicTacToeScanner scanner;
    private BoardFactory boardFactory;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        ticTacToeScannerFactory = mock(TicTacToeScannerFactory.class);
        scanner = mock(TicTacToeScanner.class);
        when(ticTacToeScannerFactory.createInstance()).thenReturn(scanner);
        boardFactory = new BoardFactory();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void printPromptTest() throws Exception {
        String expected = "Make your move, sir\n";
        TicTacToeScannerFactory ticTacToeScannerFactory = new TicTacToeScannerFactory();

        new Alexa(ticTacToeScannerFactory, boardFactory).printPrompt();

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void playerInputWithNonNumericInputTest() throws Exception {
        when(scanner.readInput()).thenAnswer(new Answer<String>() {
            private int count = 0;
            public String answer(InvocationOnMock invocation) throws Throwable {
                if (count++ == 0)
                    return "foo";
                return "1";
            }
        });
        when(ticTacToeScannerFactory.createInstance()).thenReturn(scanner);
        Alexa alexa = new Alexa(ticTacToeScannerFactory, boardFactory);

        alexa.playerInput(STATE.X);

        assertEquals(STATE.X, alexa.getBoard().getValue(1));
    }

    @Test
    public void playerInputNotInRangeTest() {
        when(scanner.readInput()).thenAnswer(new Answer<Object>() {
            private int count = 0;
            public String answer(InvocationOnMock invocation) throws Throwable {
                if (count++ == 0)
                    return "11";
                return "1";
            }
        });
        when(ticTacToeScannerFactory.createInstance()).thenReturn(scanner);
        Alexa alexa = new Alexa(ticTacToeScannerFactory, boardFactory);

        alexa.playerInput(STATE.X);

        assertEquals(STATE.X, alexa.getBoard().getValue(1));
    }

    @Test
    public void playerInputFloatTest() {
        when(scanner.readInput()).thenAnswer(new Answer<Object>() {
            private int count = 0;
            public String answer(InvocationOnMock invocation) throws Throwable {
                if (count++ == 0)
                    return "5.1";
                return "1";
            }
        });
        when(ticTacToeScannerFactory.createInstance()).thenReturn(scanner);
        Alexa alexa = new Alexa(ticTacToeScannerFactory, boardFactory);

        alexa.playerInput(STATE.X);

        assertEquals(STATE.X, alexa.getBoard().getValue(1));
    }

    @Test
    public void playerInputSquareNotEmptyTest() {
        BoardFactory boardFactory = mock(BoardFactory.class);
        Board board = new Board();
        when(boardFactory.createInstance()).thenReturn(board);
        Square square = board.getSquare(1);
        square.setValue(STATE.X);
        when(scanner.readInput()).thenAnswer(new Answer<Object>() {
            private int count = 0;
            public String answer(InvocationOnMock invocation) throws Throwable {
                if (count++ == 0)
                    return "1";
                return "2";
            }
        });
        Alexa alexa = new Alexa(ticTacToeScannerFactory, boardFactory);

        alexa.playerInput(STATE.O);

        assertEquals(STATE.X, alexa.getBoard().getValue(1));
    }
}
