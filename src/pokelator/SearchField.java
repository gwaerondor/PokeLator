package pokelator;

import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SearchField extends JTextField implements DocumentListener {
	private static final long serialVersionUID = 4157842307923731734L;
	private ResultPanel results;
	private Database db;
	
	public SearchField(ResultPanel results, Database db) {
		super("");
		this.results = results;
		this.setPreferredSize(new Dimension(600, 40));
		this.db = db;
		getDocument().addDocumentListener(this);
		update();
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

	private void updateCurrentHits(String s) throws IOException {
		ArrayList<String> hits = db.find(s);
		results.setResults(hits);
	}
}