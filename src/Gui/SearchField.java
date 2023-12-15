package Gui;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SearchField extends JFrame {
	private JTextField searchField;

	public void createTextField(int positionX, int positionY, int weight, int height) {
		searchField = new JTextField("search");
		searchField.setBounds(positionX, positionY, weight, height);

		searchField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (searchField.getText().equals("search")) {
					searchField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (searchField.getText().isEmpty()) {
					searchField.setText("search");
				}
			}
		});
	}

	public JTextField getSearchField() {
		return searchField;
	}

	public String getContent() {
		return searchField.getText();
	}
}