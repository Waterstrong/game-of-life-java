package tw.conway.util;

import static java.util.Arrays.stream;

import tw.conway.enumeration.LifeStatus;

public class ConwayGame {
    public LifeStatus[][] next(LifeStatus[][] current) {
        return stream(current).parallel().map(row -> stream(row).parallel()
                .map(cell -> cell).toArray(LifeStatus[]::new)).toArray(LifeStatus[][]::new);
    }
}
