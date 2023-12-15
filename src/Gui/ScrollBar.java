package Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Database.DataBaseConnection;
import Database.OutputDatabase;
import EventListener.ActionListenerForAllButtons;
import Frames.Frame;

public class ScrollBar extends JFrame {
	public DataBaseConnection connectionData;
	private Frame frame;

	private JTable dataTable;
	private DefaultTableModel tableModel;
	public JButton button;
	private JScrollPane scrollBar;

	public ScrollBar(Frame frame, ActionListenerForAllButtons actionListener, OutputDatabase data) {
		this.frame = frame;
	}

	public void createScrollBar(boolean isVisible) {
		scrollBar = new JScrollPane(dataTable);
		scrollBar.setBounds(200, 20, 600, 350);
		scrollBar.setVisible(isVisible);
		add(scrollBar);

		dataTable.getSelectionModel();
	}

	public void createTable() {
		tableModel = new DefaultTableModel();
		dataTable = new JTable(tableModel);

		tableModel.addColumn("ID");
		tableModel.addColumn("DVD Name");
		tableModel.addColumn("StorageLocation");
		tableModel.addColumn("CreateYear");
		tableModel.addColumn("Actors");
		tableModel.addColumn("Genre");

		TableColumn columnID = dataTable.getColumnModel().getColumn(0);
		TableColumn columnInventoryLocation = dataTable.getColumnModel().getColumn(2);
		TableColumn columnCreateYear = dataTable.getColumnModel().getColumn(3);

		columnID.setPreferredWidth(10);
		columnInventoryLocation.setPreferredWidth(10);
		columnCreateYear.setPreferredWidth(10);

		createScrollBar(true);
		frame.add(scrollBar);
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public JTable getDataTable() {
		return dataTable;
	}
}