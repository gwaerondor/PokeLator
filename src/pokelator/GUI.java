package pokelator;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
	private JFrame frame;
	private JTextField searchField;
	private ResultPanel resultPanel;
	
	public GUI(Database db) {
		this.frame = new JFrame("PokéLator");
		this.resultPanel = new ResultPanel();
		this.searchField = new SearchField(resultPanel, db);
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
		frame.setResizable(false);
		frame.add(contents);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
	public void show() {
		frame.setVisible(true);
	}
}