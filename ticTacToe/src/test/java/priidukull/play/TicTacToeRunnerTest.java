package priidukull.play;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import priidukull.board.Board;
import priidukull.board.STATE;
import priidukull.factory.BoardFactory;
import priidukull.factory.ScannerFactory;
import priidukull.scanner.TicTacToeScanner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicTacToeRunnerTest {
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
    public void runTest() {
        Board expectedBoard = new Board();
        expectedBoard.getSquare(1).setValue(STATE.X);
        expectedBoard.getSquare(2).setValue(STATE.O);
        expectedBoard.getSquare(3).setValue(STATE.X);
        expectedBoard.getSquare(4).setValue(STATE.O);
        expectedBoard.getSquare(5).setValue(STATE.X);
        expectedBoard.getSquare(6).setValue(STATE.O);
        expectedBoard.getSquare(7).setValue(STATE.X);
        ScannerFactory scannerFactory = mock(ScannerFactory.class);
        TicTacToeScanner ticTacToeScanner = mock(TicTacToeScanner.class);
        BoardFactory boardFactory = mock(BoardFactory.class);
        Board board = new Board();
        when(boardFactory.createInstance()).thenReturn(board);
        when(ticTacToeScanner.readInput()).thenAnswer(new Answer<String>() {
            int counter = 1;
            public String answer(InvocationOnMock invocation) throws Throwable {
                return String.valueOf(counter++);
            }
        });
        when(scannerFactory.createInstance()).thenReturn(ticTacToeScanner);
        Alexa alexa = new Alexa(scannerFactory, boardFactory);

        new TicTacToeRunner(alexa, new Turn(alexa)).run();

        assertEquals(expectedBoard, board);
    }
}
