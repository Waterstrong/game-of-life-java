package tw.conway.util;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static tw.conway.enumeration.LifeStatus.DEAD;
import static tw.conway.enumeration.LifeStatus.LIVE;

import tw.conway.enumeration.LifeStatus;

public class ConwayGame {
    private static final int[][] NEIGHBOR_INDEX = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    public LifeStatus[][] nextGeneration(LifeStatus[][] current) {
        LifeStatus[][] next = current.clone();
        range(0, next.length).forEach(row -> range(0, next[row].length).forEach(col -> {
            int aliveNeighborNumber = getAliveNeighborNumber(row, col, current);
            System.out.println(aliveNeighborNumber);
            next[row][col] = aliveNeighborNumber == 2 ? current[row][col] : DEAD;
            next[row][col] = aliveNeighborNumber == 3 ? LIVE : next[row][col];
        }));
        return next;
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
