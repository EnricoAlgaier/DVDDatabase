package Gui;

import javax.swing.*;

import Database.DataBaseConnection;
import Database.InsertDatabase;
import EventListener.InputActionListener;

public class InsertFrameButton extends JFrame {
	private InsertTexfield textField;
	private DataBaseConnection connectionData;
	private InputActionListener insertListener;
	private JButton inputButton;
	private InsertDatabase insertDatabase;
	private String buttonName = "Register";

	public InsertFrameButton() {
		super("Create a dataset");
		connectionData = new DataBaseConnection();
		textField = new InsertTexfield(insertDatabase);
		insertDatabase = new InsertDatabase(connectionData, textField);

		insertListener = new InputActionListener(this, insertDatabase);

		setSize(300, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		textField.createInsertTextField(20, 20, 100, 30);
		createInputButton(150, 20, 100, 30);

		for (JTextField textField : textField.getTextField()) {
			add(textField);
		}

		setLayout(null);
		setVisible(true);
	}

	public void createInputButton(int positionX, int positionY, int weight, int height) {
		inputButton = new JButton(buttonName);
		inputButton.setBounds(positionX, positionY, weight, height);
		inputButton.addActionListener(insertListener);
		add(inputButton);
	}

	public JButton getSideButtons() {
		return inputButton;
	}
}