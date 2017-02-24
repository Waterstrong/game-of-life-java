package tw.conway.domain;

import static tw.conway.enumeration.LifeStatus.DEAD;
import static tw.conway.enumeration.LifeStatus.LIVE;

import tw.conway.enumeration.LifeStatus;

public class Cell {
    private static final int TWO = 2;
    private static final int THREE = 3;
    private LifeStatus status;

    public Cell(LifeStatus status) {
        this.status = status;
    }

    public void nextGeneration(int aliveNeighborNumber) {
        this.status = aliveNeighborNumber == TWO ? status : DEAD;
        this.status = aliveNeighborNumber == THREE ? LIVE : status;
    }

    public LifeStatus getStatus() {
        return status;
    }

    public void setStatus(LifeStatus status) {
        this.status = status;
    }
}
