import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ConwayGameTest {
    @Test
    public void shouldNextStateBeSameGivenZeroAliveCell() {
        ConwayGame conway = new ConwayGame();
        int[][] current = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] expectNext = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] next = conway.next(current);

        assertThat(next, is(expectNext));
    }
}
