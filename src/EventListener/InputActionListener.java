package EventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import Database.InsertDatabase;
import Gui.InsertFrameButton;

public class InputActionListener implements ActionListener {
	private InsertFrameButton button;
	private InsertDatabase insertData;

	public InputActionListener(InsertFrameButton button, InsertDatabase insertData) {
		this.button = button;
		this.insertData = insertData;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonName = ((JButton) e.getSource()).getText();

		if ("confirm".equals(buttonName)) {
			insertData.insertData();
			button.dispose();
		}
	}
}