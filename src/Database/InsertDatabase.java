package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Gui.InsertTexfield;

public class InsertDatabase {
	private DataBaseConnection connectionData;
	private InsertTexfield insertText;
	private String dvdName;
	private JTextField[] inserTextFields;

	public InsertDatabase(DataBaseConnection connectionData, InsertTexfield insertText) {
		this.connectionData = connectionData;
		this.insertText = insertText;
		inserTextFields = insertText.getTextField();
	}

	public void insertData() {

		try {
			connectionData.connectDatabase();
			String insertQuery = "INSERT INTO dvd (`dvdName`, `storageLocation`, `createYear`, `actors`, `genre`) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connectionData.connection.prepareStatement(insertQuery);

			dvdName = inserTextFields[0].getText();

			if (isDuplicateDVDName(dvdName)) {
				System.out.println("Entry with this DVD name already exists. Insertion aborted.");
				return;
			}

			try {
				preparedStatement.setString(1, inserTextFields[0].getText());
				preparedStatement.setString(2, inserTextFields[1].getText());
				preparedStatement.setString(3, inserTextFields[2].getText());
				preparedStatement.setString(4, inserTextFields[3].getText());
				preparedStatement.setString(5, inserTextFields[4].getText());

				preparedStatement.executeUpdate();
				System.out.println("Record successfully inserted.");

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Not all fields filled out", "Abort",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {

		}
	}

	private boolean isDuplicateDVDName(String dvdName) throws SQLException {
		ResultSet resultSet = connectionData.statement
				.executeQuery("SELECT * FROM dvd WHERE dvdName = '" + dvdName + "'");
		return resultSet.next();
	}
}