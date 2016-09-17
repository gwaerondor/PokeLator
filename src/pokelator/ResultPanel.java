package pokelator;

import java.awt.FlowLayout;
import javax.swing.JPanel;

public class ResultPanel extends JPanel {
	LanguagePanel number;
	LanguagePanel english;
	LanguagePanel china;
	LanguagePanel hongKong;
	LanguagePanel taiwan;

	public ResultPanel() {
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

	public void setResult(String dexNumber, String englishName, String chinaName, String hongKongName, String taiwanName) {
		number.setResult(dexNumber);
		english.setResult(englishName);
		china.setResult(chinaName);
		hongKong.setResult(hongKongName);
		taiwan.setResult(taiwanName);
		return;
	}
}