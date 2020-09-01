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

	public void addGame(String game, ArrayList<Game> shopGames) {

		if (containsName(shopGames, game)) {
			Game e = new Game(game, priceOfGame(shopGames, game));
			games.add(e);
		} else
			throw new IllegalArgumentException("game does not exist: " + game);
	}

	public boolean containsName(final ArrayList<Game> list, final String gameName) {
		return list.stream().filter(o -> o.getName().equals(gameName)).findAny().isPresent();
	}

	public double priceOfGame(final ArrayList<Game> list, final String gameName) {
		return list.stream().filter(o -> o.getName().equals(gameName)).findAny().get().price;
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
		private ArrayList<Game> games=new ArrayList<Game>();

		public UserBuilder(String id, String name) {
			this.id = id;
			this.name = name;
		}

		public UserBuilder withAge(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder setGames(ArrayList<Game> games, ArrayList<Game> shopGames) {
			/*Game var = null;
			while (games.iterator().hasNext())
				var=games.iterator().next();
				if (!containsName(shopGames, var.name))
					throw new IllegalArgumentException("game does not exist");
*/
			this.games = games;

			return this;

		}

		public UserBuilder setGames(Game game, ArrayList<Game> shopGames) {
			if (!containsName(shopGames, game.name)) {
				throw new IllegalArgumentException("game does not exist: " + game);

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