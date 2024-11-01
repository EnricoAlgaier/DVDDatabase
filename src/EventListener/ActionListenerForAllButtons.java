package EventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import Database.OutputDatabase;
import Database.SearchDatabaseContent;
import Frames.DeleteFrameButton;
import Frames.Frame;
import Frames.FrameForChange;
import Gui.InsertFrameButton;
import Gui.ScrollBar;
import Gui.SearchField;

public class ActionListenerForAllButtons implements ActionListener {

	private OutputDatabase data;
	private SearchDatabaseContent searchDatabase;
	private FrameForChange frameForChange;
	private InsertFrameButton inputButton;
	private DeleteFrameButton deleteFrameButton;
	
	public ActionListenerForAllButtons(OutputDatabase data, Frame frame, ScrollBar scrollBar,
			SearchDatabaseContent searchDatabase) {
		this.data = data;
		this.searchDatabase = searchDatabase;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonName = ((JButton) e.getSource()).getText();
	
		if ("Show all".equals(buttonName)) {
			data.queryData();
			
		} else if ("New entry".equals(buttonName)) {
			inputButton = new InsertFrameButton();

		} else if ("New change".equals(buttonName)) {
			frameForChange = new FrameForChange();

		} else if ("Delete entry".equals(buttonName)) {
			deleteFrameButton = new DeleteFrameButton();
		}
		else if ("Search".equals(buttonName)) {
			searchDatabase.searchDatabase();
		}
	}
}