package mp.progetto;

public class User {

	private int id;
	private String name;
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	private User(UserBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}

	// Builder Class
	public static class UserBuilder {

		private int id;
		private String name;
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;

		public UserBuilder(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public UserBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
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