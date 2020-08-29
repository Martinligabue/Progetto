package mp.progetto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class UserTest {

    @Test
    public void testValuesAreAssigned() {
        // setup
        User primoUtente = new User.UserBuilder(1,"John").withAge(20).build();
        // verify
        assertThat(primoUtente.getId()).isEqualTo(1);
        assertThat(primoUtente.getAge()).isEqualTo(20);
    }

}

