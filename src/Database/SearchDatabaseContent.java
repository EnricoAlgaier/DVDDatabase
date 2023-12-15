package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Gui.ScrollBar;
import Gui.SearchField;

public class SearchDatabaseContent {
	private DataBaseConnection connectionData;
	private ScrollBar scrollBar;
	private SearchField searchField;
	private String searchTerm;

	public SearchDatabaseContent(DataBaseConnection connectionData, ScrollBar scrollBar, SearchField searchField) {
		this.connectionData = connectionData;
		this.scrollBar = scrollBar;
		this.searchField = searchField;
	}

	public void searchDatabase() {
		searchTerm = searchField.getContent();

		try {
			String query = "SELECT * FROM dvd WHERE id LIKE ? OR dvdName LIKE ? OR storageLocation LIKE ? OR createYear LIKE ? OR actors LIKE ? OR genre LIKE ?";
			PreparedStatement preparedStatement = connectionData.connection.prepareStatement(query);

			for (int i = 1; i <= 6; i++) {
				preparedStatement.setString(i, "%" + searchTerm + "%");
			}

			ResultSet resultSet = preparedStatement.executeQuery();

			scrollBar.getTableModel().setRowCount(0);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String dvdName = resultSet.getString("dvdName");
				String storageLocation = resultSet.getString("storageLocation");
				int createYear = resultSet.getInt("createYear");
				String actors = resultSet.getString("actors");
				String genre = resultSet.getString("genre");

				scrollBar.getTableModel()
						.addRow(new Object[] { id, dvdName, storageLocation, createYear, actors, genre });
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getContent() {
		return searchField.getContent();
	}
}