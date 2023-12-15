package Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Database.DataBaseConnection;
import Database.DeleteEntryDatabase;

public class DeleteFrameButton extends JFrame implements ActionListener {
	private DeleteEntryDatabase deleteEntryDatabase;
	private DataBaseConnection connectionData;
	private JButton entryButton;
	private String buttonName = "Dataset delete";
	private String labelName = "DVD-ID";
	private JTextField idTextField;
	private JLabel idLabel;

	public DeleteFrameButton() {
		super("Dataset delete");
		connectionData = new DataBaseConnection();
		setSize(300, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		createIDTextField(130, 60, 90, 30);
		createIDLabel(70, 60, 50, 30);
		createEntryButton(70, 100, 150, 30);

		setLayout(null);
		setVisible(true);
	}

	public void createIDLabel(int positionX, int positionY, int weight, int height) {
		idLabel = new JLabel(labelName);
		idLabel.setBounds(positionX, positionY, weight, height);
		add(idLabel);
	}

	public void createIDTextField(int positionX, int positionY, int weight, int height) {
		idTextField = new JTextField();
		idTextField.setBounds(positionX, positionY, weight, height);
		add(idTextField);
	}

	public void createEntryButton(int positionX, int positionY, int weight, int height) {
		entryButton = new JButton(buttonName);
		entryButton.setBounds(positionX, positionY, weight, height);
		entryButton.addActionListener(this);
		add(entryButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == entryButton) {
			deleteEntryDatabase = new DeleteEntryDatabase(connectionData, this);
			deleteEntryDatabase.deleteEntry();
		}
	}

	public String getIdTextField() {
		return idTextField.getText();
	}
}