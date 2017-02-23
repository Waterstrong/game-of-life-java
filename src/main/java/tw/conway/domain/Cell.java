package tw.conway.domain;

import static tw.conway.enumeration.LifeStatus.DEAD;

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
    }

    public LifeStatus getStatus() {
        return status;
    }
}
