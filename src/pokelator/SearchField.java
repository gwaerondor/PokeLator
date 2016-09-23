package pokelator;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SearchField extends JTextField implements DocumentListener {
	private static final long serialVersionUID = 4157842307923731734L;
	private ResultPanel results;

	public SearchField(ResultPanel results) {
		super("");
		this.results = results;
		this.setPreferredSize(new Dimension(600, 40));
		getDocument().addDocumentListener(this);
	}

	@Override
	public Dimension getMaximumSize() {
		return new Dimension(8000, 40);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		update();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		update();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		update();
	}

	public void update() {
		try {
			String s = this.getText();
			updateCurrentHits(s);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void updateCurrentHits(String s) throws IOException {
		try {
			ArrayList<String> lines = readAllLinesFromFile();
			ArrayList<String> resultLines = new ArrayList<String>();
			for (String line : lines) {
				if (line.contains(s)) {
					resultLines.add(line);
				}
			}
			results.setResults(resultLines);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ArrayList<String> readAllLinesFromFile() throws Exception {
		File file = new File("E:\\PokeLator\\PokeLator\\pokemans.txt");
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
}