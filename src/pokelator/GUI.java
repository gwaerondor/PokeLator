package pokelator;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
	JFrame frame;
	JTextField searchField;
	ResultPanel resultPanel;

	public GUI() {
		this.frame = new JFrame("PokéLator");
		this.searchField = new JTextField("");
		this.resultPanel = new ResultPanel();
		
		JPanel wrapper = new JPanel();
		BoxLayout layout = new BoxLayout(wrapper, BoxLayout.Y_AXIS);
		wrapper.setLayout(layout);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		wrapper.add(searchField);
		wrapper.add(new ResultPanel());
		frame.add(wrapper);
		frame.pack();
	}

	
	public void show() {
		frame.setVisible(true);
	}
	
}
