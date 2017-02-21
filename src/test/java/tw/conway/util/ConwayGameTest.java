package tw.conway.util;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static tw.conway.enumeration.LifeStatus.DEAD;

import org.junit.Test;

import tw.conway.enumeration.LifeStatus;

public class ConwayGameTest {
    @Test
    public void shouldNextStateBeSameGivenZeroAliveCell() {
        ConwayGame conway = new ConwayGame();
        LifeStatus[][] current = {
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD}
        };
        LifeStatus[][] expectNext = {
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD}
        };

        LifeStatus[][] next = conway.next(current);

        assertThat(next, is(expectNext));
    }
}
