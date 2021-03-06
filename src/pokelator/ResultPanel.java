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
	
	public ResultPanel() {
		super();
		this.listModel = new DefaultListModel<String>();
		this.result = new JList<String>(listModel);
		this.scroller = new JScrollPane(result);
		setupPreferences();
		
	}
	
	private void setupPreferences() {
		result.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		result.setLayoutOrientation(JList.VERTICAL);
		result.setVisibleRowCount(-1);
		this.setPreferredSize(new Dimension(600,400));
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller.setPreferredSize(new Dimension(600, 400));
		this.add(scroller);
	}
	
	public void setResults(ArrayList<PokeData> res) {
		listModel.clear();
		for(PokeData r : res) {
			listModel.addElement(r.toString());
		}
	}
}
