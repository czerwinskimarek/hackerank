import org.junit.Test;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.ArrayMatching.arrayContaining;

public class MovieTitlesTest {

    @Test
    public void shouldFindSpidermanMovieTitles() throws IOException {
        //given
        String skills = "spiderman";

        //when
        String[] movieTitles = MovieTitles.getMovieTitles(skills);

        //then
        assertThat(movieTitles, arrayContaining("Amazing Spiderman Syndrome",
                "Fighting, Flying and Driving: The Stunts of Spiderman 3",
                "Hollywood's Master Storytellers: Spiderman Live",
                "Italian Spiderman",
                "Spiderman",
                "Spiderman",
                "Spiderman 5",
                "Spiderman and Grandma",
                "Spiderman in Cannes",
                "Superman, Spiderman or Batman",
                "The Amazing Spiderman T4 Premiere Special",
                "The Death of Spiderman",
                "They Call Me Spiderman"));
    }

}
