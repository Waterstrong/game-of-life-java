package tw.conway.domain;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static tw.conway.enumeration.LifeStatus.DEAD;
import static tw.conway.enumeration.LifeStatus.LIVE;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Grid {
    private final int width;
    private final int height;
    private final Map<Integer, Map<Integer, Cell>> cells = new HashMap<>();
    private static final int[][] NEIGHBOR_INDEX = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    public Grid(int width, int height, Point... aliveCellsPosition) {
        this.width = width;
        this.height = height;
        initCellStatus(aliveCellsPosition);
    }

    private void initCellStatus(Point... aliveCellsPosition) {
        range(0, width).forEach(w -> {
            Map<Integer, Cell> cellMap = new HashMap<>();
            range(0, height).forEach(h -> cellMap.put(h, new Cell(DEAD)));
            cells.put(w, cellMap);
        });
        stream(aliveCellsPosition).forEach(point -> cells.get(point.x).get(point.y).setStatus(LIVE));
    }

    public int getAliveNeighborNumber(Point point) {
        return (int) stream(NEIGHBOR_INDEX)
                .filter(index -> LIVE.equals(cells.get(point.x + index[0]).get(point.y + index[1]).getStatus()))
                .count();
    }

    public Cell getCellAt(Point point) {
        return cells.getOrDefault(point.x, new HashMap<>()).getOrDefault(point.y, null);
    }
}
