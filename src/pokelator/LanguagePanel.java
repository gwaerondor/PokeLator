package pokelator;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class LanguagePanel extends JPanel {
	private JTextArea result;
	
	public LanguagePanel(String title) {
		super();
		this.result = new JTextArea();
		result.setEditable(false);
		JLabel label = new JLabel(title, SwingConstants.CENTER);
		this.add(label);
		this.add(result);
		this.setPreferredSize(new Dimension(100,200));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void setResult(String t) {
		result.setText(t);
	}
	
}
