package pokelator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Database {
	private ArrayList<PokeData> pokemonData;

	public Database(String fileDir) {
		File f = new File(fileDir);
		initiateData(f);
	}

	private void initiateData(File f) {
		try {
			this.pokemonData = readAllLinesFromFile(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ArrayList<PokeData> readAllLinesFromFile(File file) throws Exception {
		ArrayList<PokeData> lines = new ArrayList<PokeData>();
		BufferedReader reader = createBufferedReader(file);
		String line;
		while ((line = reader.readLine()) != null) {
			PokeData pd = new PokeData(line);
			lines.add(pd);
		}
		reader.close();
		return lines;
	}

	private BufferedReader createBufferedReader(File f) throws Exception {
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis, "UTF8");
		return new BufferedReader(isr);
	}

	public ArrayList<PokeData> find(String s) {
		ArrayList<PokeData> hits = new ArrayList<PokeData>();
		for (PokeData line : pokemonData) {
			String pd = line.toString().toLowerCase();
			if (pd.contains(s.toLowerCase())) {
				hits.add(line);
			}
		}
		return hits;
	}
}