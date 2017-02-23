package tw.conway.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static tw.conway.enumeration.LifeStatus.DEAD;
import static tw.conway.enumeration.LifeStatus.LIVE;

import org.junit.Test;

public class CellTest {
    @Test
    public void shouldNextStatusBeDeadGivenZeroAliveNeighbors() {
        Cell aliveCell = new Cell(LIVE);
        Cell deadCell = new Cell(DEAD);

        aliveCell.nextGeneration(0);
        deadCell.nextGeneration(0);

        assertThat(aliveCell.getStatus(), is(DEAD));
        assertThat(deadCell.getStatus(), is(DEAD));
    }
}
