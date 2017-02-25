package tw.conway.domain;

import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;
import static java.util.stream.IntStream.range;
import static tw.conway.enumeration.LifeStatus.DEAD;
import static tw.conway.enumeration.LifeStatus.LIVE;

import java.awt.*;

public class Grid {
    private final int width;
    private final int height;
    private final Cell[][] cells;
    private static final int[][] NEIGHBOR_INDEX = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    public Grid(int width, int height, Point... aliveCellsPosition) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        initCellStatus(aliveCellsPosition);
    }

    private void initCellStatus(Point... aliveCellsPosition) {
        range(0, width).forEach(w -> range(0, height).forEach(h -> cells[w][h] = new Cell(DEAD)));
        stream(ofNullable(aliveCellsPosition).orElse(new Point[]{}))
                .filter(point -> isWithinRange(point))
                .forEach(point -> cells[point.x][point.y].setStatus(LIVE));
    }

    private boolean isWithinRange(Point point) {
        return point.x >= 0 && point.x < width && point.y >= 0 && point.y < height;
    }

    public int getAliveNeighborNumber(Point point) {
        return (int) stream(NEIGHBOR_INDEX).filter(index -> {
            Point newPoint = new Point(point.x + index[0], point.y + index[1]);
            return isWithinRange(newPoint) && LIVE.equals(cells[newPoint.x][newPoint.y].getStatus());
        }).count();
    }

    public Cell getCellAt(Point point) {
        return isWithinRange(point) ? cells[point.x][point.y] : null;
    }

    public void nextGeneration() {
        range(0, width).forEach(w -> range(0, height).forEach(h -> cells[w][h].nextGeneration(getAliveNeighborNumber(new Point(w, h)))));
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
