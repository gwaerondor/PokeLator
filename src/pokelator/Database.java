package pokelator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Database {
	private final int NUMBER = 0;
	private final int ENGLISH = 1;
	private final int CHINA = 2;
	private final int HONGKONG = 3;
	private final int TAIWAN = 4;

	private ArrayList<PokeData> pokemonData;

	public Database(String fileDir) {
		URL databaseURL = getClass().getResource(fileDir);
		File f = new File(databaseURL.getPath());
		initiateData(f);
	}

	private void initiateData(File f) {
		try {
			this.pokemonData = readAllLinesFromCsvFile(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ArrayList<PokeData> readAllLinesFromCsvFile(File file) throws Exception {
		ArrayList<PokeData> data = new ArrayList<PokeData>();
		BufferedReader reader = createBufferedReader(file);
		String line;
		String[] csvData;
		while ((line = reader.readLine()) != null) {
			csvData = parseCsvData(line);
			PokeData d = createPokeDataFromCsvData(csvData);
			data.add(d);
		}
		return data;
	}

	private PokeData createPokeDataFromCsvData(String[] csvData) {
		PokeData d = new PokeData(csvData[NUMBER],
								  csvData[ENGLISH],
								  csvData[CHINA],
								  csvData[HONGKONG],
								  csvData[TAIWAN]);
		return d;
	}

	private String[] parseCsvData(String line) {
		String[] res = line.split(",");
		for (int i = 0; i < res.length; i++) {
			res[i] = stripQuotes(res[i]);
		}
		return res;
	}

	private String stripQuotes(String s) {
		if (s.charAt(0) == '"') {
			s = s.substring(1, s.length());
		}
		if (s.charAt(s.length() - 1) == '"') {
			s = s.substring(0, s.length() - 1);
		}
		return s;
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