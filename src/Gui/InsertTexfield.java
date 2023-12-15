package Gui;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Database.InsertDatabase;
import EventListener.InsertTextFieldFocuListener;

public class InsertTexfield extends JFrame {
	private JTextField[] inserttextfield;
	private String[] textFieldName = { "Dvd Name", "Storage Location", "Create Year", "Actors", "Genre" };
	private InsertDatabase insertDatabase;

	public InsertTexfield(InsertDatabase insertDatabase) {
		this.insertDatabase = insertDatabase;
		inserttextfield = new JTextField[5];
	}

	public void createInsertTextField(int positionX, int positionY, int weight, int height) {

		for (int index = 0; index < 5; index++) {
			inserttextfield[index] = new JTextField(textFieldName[index]);
			inserttextfield[index].setBounds(positionX, positionY, weight, height);

			InsertTextFieldFocuListener focusListener = new InsertTextFieldFocuListener(inserttextfield[index],
					textFieldName[index]);
			inserttextfield[index].addFocusListener(focusListener);

			positionY += 40;
		}
	}

	public JTextField[] getTextField() {
		return inserttextfield;
	}

	public String[] getFieldName() {
		return textFieldName;
	}

}