package pokelator;

public class Starter {
	public static void main(String... args) {
		Database db = new Database("E:\\PokeLator\\PokeLator\\pokemans.txt");
		new GUI(db).show();
	}
}
