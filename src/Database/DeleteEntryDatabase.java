package Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Frames.DeleteFrameButton;

public class DeleteEntryDatabase {
	private DataBaseConnection connectionData;
	private DeleteFrameButton deleteFrameButton;

	public DeleteEntryDatabase(DataBaseConnection connectionData, DeleteFrameButton deleteFrameButton) {
		this.connectionData = connectionData;
		this.deleteFrameButton = deleteFrameButton;
	}

	public void deleteEntry() {
		String idText = deleteFrameButton.getIdTextField();
		try {
			connectionData.connectDatabase();
			String insertQuery = "DELETE FROM dvd WHERE id = ?";
			PreparedStatement preparedStatement = connectionData.connection.prepareStatement(insertQuery);

			int id = Integer.parseInt(idText);
			preparedStatement.setInt(1, id);

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Not all fields filled out.");
			} else {
				JOptionPane.showMessageDialog(null, "No record found for the specified ID", "Abort",
						JOptionPane.WARNING_MESSAGE);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection error", "Abort", JOptionPane.WARNING_MESSAGE);
		}
	}
}
