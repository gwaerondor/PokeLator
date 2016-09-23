package pokelator;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ResultPanel extends JPanel {
	private static final long serialVersionUID = -9001873464769009162L;
	private JList<String> result;
	private JScrollPane scroller;
	private DefaultListModel<String> listModel;
	
	public ResultPanel(String title) {
		super();
		this.listModel = new DefaultListModel<String>();
		this.result = new JList<String>(listModel);
		this.scroller = new JScrollPane(result);
		doPreferenceSetup();
		
	}
	
	private void doPreferenceSetup() {
		result.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		result.setLayoutOrientation(JList.VERTICAL);
		result.setVisibleRowCount(-1);
		this.setPreferredSize(new Dimension(600,200));
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller.setPreferredSize(new Dimension(600, 200));
		this.add(scroller);
	}
	
	public void setResults(ArrayList<String> res) {
		listModel.clear();
		for(String r : res) {
			listModel.addElement(r);
		}
	}
}
