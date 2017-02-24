package tw.conway.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static tw.conway.enumeration.LifeStatus.DEAD;
import static tw.conway.enumeration.LifeStatus.LIVE;

import java.awt.*;

import org.junit.Test;

public class GridTest {
    @Test
    public void shouldInitTheAliveCellsInTheGrid() {
        Point[] aliveCellsPosition = {new Point(0, 0), new Point(1, 1)};

        Grid grid = new Grid(3, 3, aliveCellsPosition);

        assertThat(grid.getCellAt(new Point(0, 0)).getStatus(), is(LIVE));
        assertThat(grid.getCellAt(new Point(1, 1)).getStatus(), is(LIVE));
        assertThat(grid.getCellAt(new Point(2, 1)).getStatus(), is(DEAD));
        assertThat(grid.getCellAt(new Point(2, 2)).getStatus(), is(DEAD));
        assertNull(grid.getCellAt(new Point(1, 3)));
        assertNull(grid.getCellAt(new Point(3, 1)));
        assertNull(grid.getCellAt(new Point(3, 3)));
        assertNull(grid.getCellAt(new Point(-1, 1)));
        assertNull(grid.getCellAt(new Point(1, -1)));
        assertNull(grid.getCellAt(new Point(-1, -1)));
    }

    @Test
    public void shouldGetTheAliveNeighborNumberGivenTheGridWithCells() {
        Point[] aliveCellsPosition = {
                new Point(0, 0), new Point(0, 1), new Point(0, 2),
                new Point(1, 0), new Point(1, 1), new Point(1, 2),
                new Point(2, 0), new Point(2, 1), new Point(2, 2)};
        Grid grid = new Grid(3, 3, aliveCellsPosition);

        int aliveNeighborNumber = grid.getAliveNeighborNumber(new Point(1, 1));

        assertThat(aliveNeighborNumber, is(8));
    }
}
