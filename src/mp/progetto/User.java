package mp.progetto;

import java.util.ArrayList;

public class User {

	private int id;
	private String name;
	private int age;
	private ArrayList<String> games;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public ArrayList<String> isBluetoothEnabled() {
		return games;
	}

	private User(UserBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.age = builder.age;
		this.games = builder.games;
	}

	public static class UserBuilder {

		private int id;
		private String name;
		private int age;
		private ArrayList<String> games;

		public UserBuilder(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public UserBuilder withAge(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder setBluetoothEnabled(ArrayList<String> games) {
			this.games = games;
			return this;
		}

		public User build() {
			return new User(this);
		}

	}

}