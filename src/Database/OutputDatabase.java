package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

import Gui.ScrollBar;

public class OutputDatabase {
	private DataBaseConnection connectionData;
	private ScrollBar scrollBar;

	public OutputDatabase(ScrollBar scrollBar, DataBaseConnection connectionData) {
		this.scrollBar = scrollBar;
		this.connectionData = connectionData;
	}

	public void queryData() {

		try {
			ResultSet resultSet = connectionData.statement.executeQuery("SELECT * FROM dvd");
			
			scrollBar.getTableModel().setRowCount(0);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String dvdName = resultSet.getString("dvdName");
				String storageLocation = resultSet.getString("lagerort");
				int createYear = resultSet.getInt("erstellungsjahr");
				String actors = resultSet.getString("schauspieler");
				String genre = resultSet.getString("genre");

				scrollBar.getTableModel()
						.addRow(new Object[] { id, dvdName, storageLocation, createYear, actors, genre });
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}