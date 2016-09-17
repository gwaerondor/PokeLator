package pokelator;

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
	private static final int DEX_COLUMN = 0;
	private static final int ENG_COLUMN = 1;
	private static final int TW_COLUMN = 2;
	private static final int CN_COLUMN = 3;
	private static final int HK_COLUMN = 4;

	private ResultPanel results;

	public SearchField(ResultPanel results) {
		super("");
		this.results = results;
		getDocument().addDocumentListener(this);
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
		ArrayList<String> hits = new ArrayList<String>();
		File file = new File("E:\\PokeLator\\pokemans.txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis, "UTF8");
		BufferedReader r = new BufferedReader(isr);
		String line;
		while ((line = r.readLine()) != null) {
			if (line.toLowerCase().contains(s.toLowerCase())) {
				hits.add(line);
			}
		}
		r.close();

		if (hits.size() > 0) {
			ArrayList<ResultLine> resultLines = new ArrayList<ResultLine>();
			for (String hit : hits) {
				String[] f = hit.split("\\s");
				ResultLine rl = new ResultLine(f[DEX_COLUMN], f[ENG_COLUMN], f[CN_COLUMN], f[HK_COLUMN], f[TW_COLUMN]);
				System.out.println(rl.toString());
				resultLines.add(rl);
			}
			results.setResults(resultLines);
		}

	}
}