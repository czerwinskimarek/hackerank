import org.junit.Test;

import static org.hamcrest.collection.ArrayMatching.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

public class ShuffleTest {

    @Test
    public void shouldReturnSameSizeArray() {
        //given
        Integer[] input = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //when
        Integer[] output = Shuffle.shuffle(input);

        //then
        assertEquals(input.length, output.length);
    }

    @Test
    public void shouldShuffleArray() {
        //given
        Integer[] input = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        //when
        Integer[] output = Shuffle.shuffle(input);

        //then
        assertEquals(input.length, output.length);
        assertNotEquals(input, output);
        assertThat(output, arrayContainingInAnyOrder(input));
    }

}