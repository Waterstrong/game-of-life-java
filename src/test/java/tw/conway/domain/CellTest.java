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

    @Test
    public void shouldNextStatusBeAliveGivenThreeNeighbors() {
        liveCell.nextGeneration(3);
        deadCell.nextGeneration(3);

        assertThat(liveCell.getStatus(), is(LIVE));
        assertThat(deadCell.getStatus(), is(LIVE));
    }

    @Test
    public void shouldNextStatusBeDeadGivenMoreThanThreeNeighbors() {
        liveCell.nextGeneration(4);
        deadCell.nextGeneration(4);

        assertThat(liveCell.getStatus(), is(DEAD));
        assertThat(deadCell.getStatus(), is(DEAD));

        liveCell.nextGeneration(8);
        deadCell.nextGeneration(8);
        assertThat(liveCell.getStatus(), is(DEAD));
        assertThat(liveCell.getStatus(), is(DEAD));
    }
}

