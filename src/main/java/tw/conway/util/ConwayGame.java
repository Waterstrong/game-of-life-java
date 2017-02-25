package tw.conway.util;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static tw.conway.enumeration.LifeStatus.DEAD;
import static tw.conway.enumeration.LifeStatus.LIVE;

import tw.conway.enumeration.LifeStatus;

public class ConwayGame {
    private static final int[][] NEIGHBOR_INDEX = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    public LifeStatus[][] nextGeneration(LifeStatus[][] current) {
        LifeStatus[][] next = new LifeStatus[current.length][];
        range(0, next.length).forEach(row -> {
            next[row] = new LifeStatus[current[row].length];
            range(0, next[row].length).forEach(col -> next[row][col] = getNextLifeStatus(row, col, current));
        });
        return next;
    }

    private LifeStatus getNextLifeStatus(int row, int col, LifeStatus[][] current) {
        int aliveNeighborNumber = getAliveNeighborNumber(row, col, current);
        LifeStatus nextStatus = aliveNeighborNumber == 2 ? current[row][col] : DEAD;
        nextStatus = aliveNeighborNumber == 3 ? LIVE : nextStatus;
        return nextStatus;
    }

    private int getAliveNeighborNumber(int row, int col, LifeStatus[][] current) {
        return (int) stream(NEIGHBOR_INDEX).filter(index -> {
            int newX = row + index[0];
            int newY = col + index[1];
            return isWithinRange(newX, newY, current) && LIVE.equals(current[newX][newY]);
        }).count();
    }

    private boolean isWithinRange(int newX, int newY, LifeStatus[][] current) {
        return newX >= 0 && newX < current.length && newY >= 0 && newY < current[newX].length;
    }

}
