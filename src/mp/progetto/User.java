package mp.progetto;

public class User {
	private int id; // richiesto
	private String name; // richiesto
	private Integer age; // opzionale con validazione
	private String address; // opzionale senza validazione
	// diventerà la lista di giochi, se possibile con un singleton

	private void setId(int id) {
		this.id = id;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void setAge(Integer age) {
		this.age = age;
	}

	private void setAddress(String address) {
		this.address = address;
	}

	public User() {
		super();
	}

	public class UserBuilder {
		private int id;
		private String name;
		private Integer age;
		private String address;

		public UserBuilder(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public UserBuilder withAge(Integer age) {
			if (age < 13) // COPPA law
				throw new IllegalArgumentException("age must be at least 13: " + age);
			this.age = age;
			return this;
		}

		public UserBuilder withAddress(String address) {
			this.address = address;
			return this;
		}

		public User build() {
			User person = new User();
			person.setId(id);
			person.setName(name);
			person.setAge(age);
			person.setAddress(address);
			return person;
		}

	}
}
