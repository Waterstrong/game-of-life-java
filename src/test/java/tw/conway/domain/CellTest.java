package tw.conway.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static tw.conway.enumeration.LifeStatus.DEAD;
import static tw.conway.enumeration.LifeStatus.LIVE;

import org.junit.Before;
import org.junit.Test;

public class CellTest {

    private Cell liveCell;
    private Cell deadCell;

    @Before
    public void setUp() {
        liveCell = new Cell(LIVE);
        deadCell = new Cell(DEAD);
    }

    @Test
    public void shouldNextStatusBeDeadGivenZeroAliveNeighbors() {
        liveCell.nextGeneration(0);
        deadCell.nextGeneration(0);

        assertThat(liveCell.getStatus(), is(DEAD));
        assertThat(deadCell.getStatus(), is(DEAD));
    }

    @Test
    public void shouldNextStatusBeDeadGivenOneAliveNeighbors() {
        liveCell.nextGeneration(1);
        deadCell.nextGeneration(1);

        assertThat(liveCell.getStatus(), is(DEAD));
        assertThat(deadCell.getStatus(), is(DEAD));
    }

    @Test
    public void shouldNextStatusBeRemainGivenTwoAliveNeighbors() {
        liveCell.nextGeneration(2);
        deadCell.nextGeneration(2);

        assertThat(liveCell.getStatus(), is(LIVE));
        assertThat(deadCell.getStatus(), is(DEAD));

    }
}
