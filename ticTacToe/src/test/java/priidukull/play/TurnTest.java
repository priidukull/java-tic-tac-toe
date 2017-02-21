package priidukull.play;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import priidukull.factory.BoardFactory;
import priidukull.board.STATE;
import priidukull.factory.ScannerFactory;
import priidukull.scanner.TicTacToeScanner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TurnTest {
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
    public void playerTurnTest() {
        ScannerFactory scannerFactory = mock(ScannerFactory.class);
        BoardFactory boardFactory = new BoardFactory();
        TicTacToeScanner scanner = mock(TicTacToeScanner.class);
        when(scanner.readInput()).thenAnswer(new Answer<String>(){
            private int count = 0;
            public String answer(InvocationOnMock invocation) throws Throwable {
                count++;
                return String.valueOf(count);
            }
        });
        when(scannerFactory.createInstance()).thenReturn(scanner);
        Alexa alexa = new Alexa(scannerFactory, boardFactory);

        Turn turn = new Turn(alexa);
        turn.playerTurn();
        turn.playerTurn();

        assertEquals(STATE.X, alexa.getBoard().getValue(1));
        assertEquals(STATE.O, alexa.getBoard().getValue(2));
    }
}
