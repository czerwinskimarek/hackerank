import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BestTrioTest {

    @Test
    public void shouldReturnTwo() {
        //given
        int friendsNodes = 5;
        List<Integer> friendsFrom = Arrays.asList(1, 1, 2, 2, 3, 4);
        List<Integer> friendsTo = Arrays.asList(2, 3, 3, 4, 4, 5);

        //when
        int differentTeams = BestTrio.bestTrio(friendsNodes, friendsFrom, friendsTo);

        //then
        assertEquals(2, differentTeams);
    }

    @Test
    public void shouldReturnMinusOne() {
        //given
        int friendsNodes = 7;
        List<Integer> friendsFrom = Arrays.asList(2, 3, 5, 1);
        List<Integer> friendsTo = Arrays.asList(1, 6, 1, 7);

        //when
        int differentTeams = BestTrio.bestTrio(friendsNodes, friendsFrom, friendsTo);

        //then
        assertEquals(-1, differentTeams);
    }

    @Test
    public void shouldReturnMinusOneB() {
        //given
        int friendsNodes = 3;
        List<Integer> friendsFrom = Arrays.asList(2, 1);
        List<Integer> friendsTo = Arrays.asList(3, 2);

        //when
        int differentTeams = BestTrio.bestTrio(friendsNodes, friendsFrom, friendsTo);

        //then
        assertEquals(-1, differentTeams);
    }

}
