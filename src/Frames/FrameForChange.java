package Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

import Database.DataBaseConnection;
import Database.UpdateDatabase;
import Gui.ScrollBar;

public class FrameForChange extends JFrame implements ActionListener {
	private String[] nameTextFields = { "From ID", "Dvd Name", "Storage Location", "Create Year", "Actors", "Genre" };
	private JTextField[] changeFields;
	private JButton changeButton;
	private DataBaseConnection connectionData;
	private UpdateDatabase updateDatabase;
	private ScrollBar scrollBar;

	public FrameForChange() {
		super("Change entry");

		connectionData = new DataBaseConnection();
		connectionData.connectDatabase();

		scrollBar = new ScrollBar(null, null, null);

		updateDatabase = new UpdateDatabase(connectionData);

		changeFields = new JTextField[6];

		setSize(300, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		createtextFields(20, 20, 100, 30);
		createButton();

		setLayout(null);
		setVisible(true);
	}

	public void createtextFields(int positionX, int positionY, int weight, int height) {
		for (int index = 0; index < 6; index++) {
			final int finalIndex = index;

			changeFields[index] = new JTextField(nameTextFields[index]);
			changeFields[index].setBounds(positionX, positionY, weight, height);

			updateDatabase.setChangeField(changeFields);

			add(changeFields[index]);

			positionY += 40;

			changeFields[index].addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (changeFields[finalIndex].getText().equals(nameTextFields[finalIndex])) {
						changeFields[finalIndex].setText("");
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (changeFields[finalIndex].getText().isEmpty()) {
						changeFields[finalIndex].setText(nameTextFields[finalIndex]);
					}
				}
			});
		}
	}

	public void createButton() {
		changeButton = new JButton("confirm");
		changeButton.setBounds(120, 20, 100, 30);
		changeButton.addActionListener(this);
		add(changeButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == changeButton) {
			updateDatabase.update();
			dispose();
		}
	}
}