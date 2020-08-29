package mp.progetto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class UserTest {

    @Test
    public void testValuesAreAssigned() {
        // setup
        User primoUtente = new User.UserBuilder(1,"John").withAge(20).build();
        // verify
        assertThat(primoUtente.getId()).isEqualTo(1);
        assertThat(primoUtente.getName()).isEqualTo("John");
        assertThat(primoUtente.getAge()).isEqualTo(20);
    }
    
    @Test
    public void testAddGames() {
        // setup
        ArrayList<String> list=new ArrayList<>(Arrays.asList("Game1", "Game2"));
        User primoUtente = new User.UserBuilder(1,"John").setGames(list).build();
        primoUtente.addGame("Game3");
        // verify
        assertThat(primoUtente.getGames()).containsExactlyInAnyOrder("Game1", "Game2", "Game3");
    }

}

