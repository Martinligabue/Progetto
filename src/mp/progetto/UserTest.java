package mp.progetto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import mp.progetto.User.UserBuilder;

public class UserTest {

    @Test
    public void testIdIsAutomaticallyAssignedAsPositiveNumber() {
        // setup
        User primoUtente = new User.UserBuilder(1,"John").setBluetoothEnabled(true).build();
        // verify
        assertThat(primoUtente.getId()).isEqualTo(1);
    }

}

