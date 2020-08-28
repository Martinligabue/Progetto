package mp.progetto;

import static org.assertj.core.api.Assertions.*;

public class Test {

	@Test
	public void assertThat(bankAccounts).
	 hasSize(1).
	 extracting(BankAccount::getId).
	 contains(newAccountId);

}
