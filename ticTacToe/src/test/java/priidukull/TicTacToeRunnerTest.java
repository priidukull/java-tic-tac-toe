package priidukull;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import priidukull.board.BoardFactory;
import priidukull.board.STATE;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicTacToeRunnerTest {
    @Test
    public void playerTurnTest() {
        TicTacToeScannerFactory ticTacToeScannerFactory = mock(TicTacToeScannerFactory.class);
        BoardFactory boardFactory = new BoardFactory();
        TicTacToeScanner scanner = mock(TicTacToeScanner.class);
        when(scanner.readInput()).thenAnswer(new Answer<String>(){
            private int count = 0;
            public String answer(InvocationOnMock invocation) throws Throwable {
                count++;
                return String.valueOf(count);
            }
        });
        when(ticTacToeScannerFactory.createInstance()).thenReturn(scanner);
        Alexa alexa = new Alexa(ticTacToeScannerFactory, boardFactory);

        TicTacToeRunner runner = new TicTacToeRunner(alexa);
        runner.playerTurn();
        runner.playerTurn();

        assertEquals(STATE.X, alexa.getBoard().getValue(1));
        assertEquals(STATE.O, alexa.getBoard().getValue(2));
    }
}
