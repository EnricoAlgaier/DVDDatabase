package Gui;

import javax.swing.JButton;

import EventListener.ActionListenerForAllButtons;

public class SideBarButton {
	private ActionListenerForAllButtons actionListener;

	private JButton[] sideButton;
	private String[] sideButtonList = { "Show all", "New entry", "New change", "Delete entry", "Search" };

	public SideBarButton(ActionListenerForAllButtons actionListener) {
		this.actionListener = actionListener;
		sideButton = new JButton[5];
	}

	public void createSideBar(int positionX, int positionY, int weight, int height) {

		for (int index = 0; index < 5; index++) {

			sideButton[index] = new JButton(sideButtonList[index]);
			sideButton[index].setBounds(positionX, positionY, weight, height);
			sideButton[index].addActionListener(actionListener);
			positionY += 40;
		}
	}

	public JButton getButtonByName(String buttonName) {
		for (JButton button : sideButton) {
			if (button.getText().equals(buttonName)) {
				return button;
			}
		}
		return null;
	}

	public JButton[] getSideButtons() {

		return sideButton;
	}
}