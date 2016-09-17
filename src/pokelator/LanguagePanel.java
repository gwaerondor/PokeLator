package pokelator;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LanguagePanel extends JPanel {
	private static final long serialVersionUID = -9001873464769009162L;
	private JTextField result;
	//private DefaultListModel listModel;
	
	public LanguagePanel(String title) {
		super();
		//this.listModel = new DefaultListModel();
		this.result = new JTextField();
		JLabel label = new JLabel(title, SwingConstants.CENTER);
		this.add(label);
		this.add(result);
		this.setPreferredSize(new Dimension(100,200));
		result.setPreferredSize(new Dimension(100, 200));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void setResult(String t) {
		result.setText(t);
	}
	
	public String getText() {
		return result.getText();
	}
	public void clearResults() {
		result.setText("");
	}
}
