package mp.progetto;

import java.util.ArrayList;

public class User {

	private String id;
	private String name;
	private int age;
	private ArrayList<String> games;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public ArrayList<String> getGames() {
		return games;
	}
	
	public void addGame(String game) {
		games.add(game);
	}

	private User(UserBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.age = builder.age;
		this.games = builder.games;
	}

	public static class UserBuilder {

		private String id;
		private String name;
		private int age;
		private ArrayList<String> games;

		public UserBuilder(String id, String name) {
			this.id = id;
			this.name = name;
		}

		public UserBuilder withAge(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder setGames(ArrayList<String> games) {
			this.games = games;
			return this;
		}

		public User build() {
			return new User(this);
		}

	}

}