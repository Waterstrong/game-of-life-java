package tw.conway.game;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static tw.conway.enumeration.LifeStatus.DEAD;
import static tw.conway.enumeration.LifeStatus.LIVE;

import java.awt.Point;

import tw.conway.enumeration.LifeStatus;

public class ConwayGame {

    private static final int THREE_ALIVE = 3;
    private static final int TWO_ALIVE = 2;

    private static final int[][] NEIGHBOR_OFFSET = {
            {-1, -1},
            {0, -1},
            {1, -1},
            {-1, 0},
            {1, 0},
            {-1, 1},
            {0, 1},
            {1, 1}
    };

    public LifeStatus[][] nextGeneration(LifeStatus[][] current) {
        LifeStatus[][] next = new LifeStatus[current.length][];
        range(0, next.length).forEach(row -> {
            next[row] = new LifeStatus[current[row].length];
            range(0, next[row].length)
                    .forEach(col -> next[row][col] = getNextLifeStatus(new Point(row, col), current));
        });
        return next;
    }

    private LifeStatus getNextLifeStatus(Point position, LifeStatus[][] current) {
        int aliveNeighborNumber = getAliveNeighborNumber(position, current);
        LifeStatus nextStatus = aliveNeighborNumber == TWO_ALIVE ? current[position.x][position.y] : DEAD;
        nextStatus = aliveNeighborNumber == THREE_ALIVE ? LIVE : nextStatus;
        return nextStatus;
    }

    private int getAliveNeighborNumber(Point position, LifeStatus[][] current) {
        return (int) stream(NEIGHBOR_OFFSET)
                .filter(offset -> isNeighbourCellAlive(offset, position, current))
                .count();
    }

    private boolean isNeighbourCellAlive(int[] offset, Point position, LifeStatus[][] current) {
        int newX = position.x + offset[0];
        int newY = position.y + offset[1];
        return isWithinRange(newX, newY, current) && LIVE.equals(current[newX][newY]);
    }

    private boolean isWithinRange(int newX, int newY, LifeStatus[][] current) {
        return newX >= 0 && newX < current.length && newY >= 0 && newY < current[newX].length;
    }

}
