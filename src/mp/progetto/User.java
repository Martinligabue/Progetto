package mp.progetto;

import java.util.ArrayList;

public class User extends Streams {

	private String id;
	private String name;
	private int age;
	private int friends;
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

	public int getFriends() {
		return friends;
	}

	public ArrayList<Game> getGames() {
		return games;
	}

	public Game getExactGame(String gameName) {
		return games.stream().filter(o -> o.name == gameName).findAny().get();
	}

	public void addGame(String game, ArrayList<Game> shopGames) {

		if (containsName(shopGames, game)) {
			Game e = new Game(game, priceOfGame(shopGames, game));
			games.add(e);
		} else
			throw new IllegalArgumentException("game does not exist: " + game);
	}

	private User(UserBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.age = builder.age;
		this.friends = builder.friends;
		this.games = builder.games;
	}

	public static class UserBuilder {

		private String id;
		private String name;
		private int age;
		private int friends;
		private ArrayList<Game> games = new ArrayList<Game>();

		public UserBuilder(String id, String name) {
			this.id = id;
			this.name = name;
		}

		public UserBuilder withAge(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder withFriends(int friends) {
			this.friends = friends;
			return this;
		}

		public UserBuilder setGames(ArrayList<Game> games, ArrayList<Game> shopGames) {

			while (games.iterator().hasNext())
				if (!containsName(shopGames, games.iterator().next().name))
					throw new IllegalArgumentException("game does not exist");

			this.games = games;

			return this;

		}

		public UserBuilder setGames(Game game, ArrayList<Game> shopGames) {
			if (!containsName(shopGames, game.name)) {
				throw new IllegalArgumentException("game does not exist: " + game.name);

			} else {
				games.add(game);
				return this;
			}

		}

		public User build() {
			return new User(this);
		}

		public boolean containsName(final ArrayList<Game> list, final String gameName) {
			return list.stream().filter(o -> o.getName().equals(gameName)).findAny().isPresent();
		}

		public double priceOfGame(final ArrayList<Game> list, final String gameName) {
			return list.stream().filter(o -> o.getName().equals(gameName)).findAny().get().price;
		}
	}

}