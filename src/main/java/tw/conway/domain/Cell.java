package tw.conway.domain;

import static tw.conway.enumeration.LifeStatus.DEAD;
import static tw.conway.enumeration.LifeStatus.LIVE;

import tw.conway.enumeration.LifeStatus;

public class Cell {
    private LifeStatus status;

    public Cell(LifeStatus status) {
        this.status = status;
    }

    public void nextGeneration(int aliveNeighborNumber) {
        if (aliveNeighborNumber < 2) {
            this.status = DEAD;
        }
        if (aliveNeighborNumber == 3) {
            this.status = LIVE;
        }
    }

    public LifeStatus getStatus() {
        return status;
    }
}
