package mp.progetto;

public class FakeMain {

	public static void main(String[] args) {
		
		User person = new User.UserBuilder(1, "John")
				.withAge(10)
				.withAddress("an address")
				.build();
	}
}
