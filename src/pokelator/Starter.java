package pokelator;

public class Starter {
	public static void main(String... args) {
		Database db = new Database("pokemans.csv");
		new GUI(db).show();
	}
}
