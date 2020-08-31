package mp.progetto;

import java.util.ArrayList;

public class User {

	private String id;
	private String name;
	private int age;
	private ArrayList<Game> games;

	public String getId() {// must be different
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public ArrayList<Game> getGames() {
		return games;
	}

	public void addGame(String game) {
		
		if (game.)
			games.add(game);
		else
			throw new IllegalArgumentException("game does not exist: " + game);
	}

	private User(UserBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.age = builder.age;
		//this.games = builder.games;
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
			if (!Shop.getGameList().containsAll(games)) {
				throw new IllegalArgumentException("game does not exist");
			}
			this.games = games;

			return this;

		}

		public User build() {
			return new User(this);
		}

	}

}