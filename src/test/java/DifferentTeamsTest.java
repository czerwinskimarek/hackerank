import org.junit.Test;

import static org.junit.Assert.*;

public class DifferentTeamsTest {

    @Test
    public void shouldFindDifferentTeam() {
        //given
        String skills = "pcmbz";

        //when
        int differentTeams = DifferentTeams.differentTeams(skills);

        //then
        assertEquals(1, differentTeams);
    }

    /**
     * pcmbzpcmbz  returns 2 since we have two matching strings pcmbz and pcmbz
     */
    @Test
    public void shouldFind2DifferentTeams() {
        //given
        String skills = "pcmbzpcmbz";

        //when
        int differentTeams = DifferentTeams.differentTeams(skills);

        //then
        assertEquals(2, differentTeams);
    }

    /**
     * pcmbzpcmbzzbmcp returns 3 since we have three matching strings pcmbz and pcmbz and zbmcp
     */
    @Test
    public void shouldFind3DifferentTeams() {
        //given
        String skills = "pcmbzpcmbzzbmcp";

        //when
        int differentTeams = DifferentTeams.differentTeams(skills);

        //then
        assertEquals(3, differentTeams);
    }

    /**
     * pcmbzpcmbp returns 1 since we can form only one pcmbz sequence
     */
    @Test
    public void shouldFind3DifferentTeamsB() {
        //given
        String skills = "pcmbzpcmbp";

        //when
        int differentTeams = DifferentTeams.differentTeams(skills);

        //then
        assertEquals(1, differentTeams);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFind1DifferentTeams() {
        //given
        String skills = "pcmbza";

        //when
        DifferentTeams.differentTeams(skills);
    }

    /**
     * pcm returns 0 since we cannot form any sequence
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenInputIsNotValid() {
        //given
        String skills = "pcm";

        //when
        int differentTeams = DifferentTeams.differentTeams(skills);

        //then
        assertEquals(0, differentTeams);
    }

    @Test
    public void shouldFind0DifferentTeams2() {
        //given
        String skills = "pcmbzp";

        //when
        int differentTeams = DifferentTeams.differentTeams(skills);

        //then
        assertEquals(1, differentTeams);
    }

}