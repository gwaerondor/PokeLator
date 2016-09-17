package pokelator;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ResultPanel extends JPanel {
	private static final long serialVersionUID = -3997379883540327215L;
	LanguagePanel number;
	LanguagePanel english;
	LanguagePanel china;
	LanguagePanel hongKong;
	LanguagePanel taiwan;

	public ResultPanel() {
		super();
		setupPanel();
	}
	
	private void setupPanel() {
		this.number = new LanguagePanel("National Dex");
		this.english = new LanguagePanel("English");
		this.china = new LanguagePanel("简体");
		this.hongKong = new LanguagePanel("香港");
		this.taiwan = new LanguagePanel("繁體");
		FlowLayout resultLayout = new FlowLayout();
		this.setLayout(resultLayout);
		add(number);
		add(english);
		add(china);
		add(hongKong);
		add(taiwan);
	}
	
	public void setResults(ArrayList<ResultLine> results) {
		clear();
		String oldNumber;
		String oldEng;
		String oldCn;
		String oldHk;
		String oldTw;
		
		for(ResultLine r : results) {
			oldNumber = number.getText();
			number.setResult(oldNumber + "\n" + r.getDex());
			
			oldEng = english.getText();
			english.setResult(oldEng + "\n" + r.getEng());
			
			oldCn = china.getText();
			china.setResult(oldCn + "\n" + r.getCn());
			
			oldHk = hongKong.getText();
			hongKong.setResult(oldHk+ "\n" + r.getHk());
			
			oldTw = taiwan.getText();
			taiwan.setResult(oldTw+ "\n" + r.getTw());
		}
	}
	
	public void clear() {
		number.clearResults();
		english.clearResults();
		china.clearResults();
		hongKong.clearResults();
		taiwan.clearResults();
	}
}