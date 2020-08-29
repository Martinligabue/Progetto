package mp.progetto;

public class User {

	private int id;
	private String name;
	private int age;
	private boolean isBluetoothEnabled;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	private User(UserBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.age = builder.age;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}

	// Builder Class
	public static class UserBuilder {

		private int id;
		private String name;
		private int age;
		private boolean isBluetoothEnabled;

		public UserBuilder(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public UserBuilder withAge(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}

		public User build() {
			return new User(this);
		}

	}

}