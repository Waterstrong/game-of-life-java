package tw.conway.util;

import static java.util.Arrays.stream;
import static tw.conway.enumeration.LifeStatus.DEAD;

import tw.conway.enumeration.LifeStatus;

public class ConwayGame {
    public LifeStatus[][] nextGeneration(LifeStatus[][] current) {
        return stream(current).parallel().map(row -> stream(row).parallel()
                .map(cell -> DEAD).toArray(LifeStatus[]::new)).toArray(LifeStatus[][]::new);
    }

}
