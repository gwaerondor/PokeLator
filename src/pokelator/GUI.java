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
		this.resultPanel = new ResultPanel();
		this.searchField = new SearchField(resultPanel);
		JPanel wrapper = createWrapper();
		setupFrame(wrapper);
	}
	
	private JPanel createWrapper() {
		JPanel wrapper = new JPanel();
		BoxLayout layout = new BoxLayout(wrapper, BoxLayout.Y_AXIS);
		wrapper.setLayout(layout);
		wrapper.add(searchField);
		wrapper.add(resultPanel);
		return wrapper;
	}
	
	private void setupFrame(JPanel contents){
		frame.add(contents);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
	public void show() {
		frame.setVisible(true);
	}
}