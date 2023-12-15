package Frames;
import java.awt.Color;

import javax.swing.*;

import Database.DataBaseConnection;
import Database.OutputDatabase;
import Database.SearchDatabaseContent;
import EventListener.ActionListenerForAllButtons;
import Gui.ScrollBar;
import Gui.SearchField;
import Gui.SideBarButton;

public class Frame extends JFrame {

	private SideBarButton sideBarButton;
	private ActionListenerForAllButtons actionListener;
	private ScrollBar scrollBar;
	private OutputDatabase data;
	private SearchField searchField;
	private DataBaseConnection connectionData;
	private SearchDatabaseContent searchData;

	
	public Frame() {
		super("Movie Database");
		connectionData = new DataBaseConnection();
		connectionData.connectDatabase();
		
		scrollBar = new ScrollBar(this, actionListener, data);
		data = new OutputDatabase(scrollBar, connectionData);
		searchField = new SearchField();
		
		searchData = new SearchDatabaseContent(connectionData, scrollBar, searchField);
		actionListener = new ActionListenerForAllButtons(data, this, scrollBar, searchData);
		sideBarButton = new SideBarButton(actionListener);
		
		getContentPane().setBackground(Color.GRAY);
		setSize(900, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		scrollBar.createTable();
		searchField.createTextField(10, 220, 150, 30);
		add(searchField.getSearchField());
		
		sideBarButton.createSideBar(10, 20, 150, 30);
		for (JButton button : sideBarButton.getSideButtons()) {
			add(button);
		}
		addWindowListener(new FrameIsClosed(this, connectionData));
		setLayout(null);
		setVisible(true);
	}
	
}