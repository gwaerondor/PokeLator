package pokelator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Database {
	private ArrayList<String> pokemonData;

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

	private ArrayList<String> readAllLinesFromFile(File file) throws Exception {
		ArrayList<String> lines = new ArrayList<String>();
		BufferedReader reader = createBufferedReader(file);
		String line;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		reader.close();
		return lines;
	}

	private BufferedReader createBufferedReader(File f) throws Exception {
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis, "UTF8");
		return new BufferedReader(isr);
	}

	public ArrayList<String> find(String s) {
		ArrayList<String> hits = new ArrayList<String>();
		for (String line : pokemonData) {
			if (line.contains(s)) {
				hits.add(line);
			}
		}
		return hits;
	}
}