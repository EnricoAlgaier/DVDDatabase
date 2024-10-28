package Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateDatabase {
	private DataBaseConnection connectionData;
	private OutputDatabase data;
	private JTextField[] changeFields;

	public UpdateDatabase(DataBaseConnection connectionData) {
		this.connectionData = connectionData;

	}

	public void update() {

		try {
			connectionData.connectDatabase();
			String updateQuery = "UPDATE dvd SET `dvdName` = ?, lagerort = ?, erstellungsjahr = ?, schauspieler = ?, genre = ? WHERE id = ?";
			PreparedStatement preparedStatement = connectionData.connection.prepareStatement(updateQuery);

			preparedStatement.setString(1, changeFields[1].getText());
			preparedStatement.setString(2, changeFields[2].getText());
			preparedStatement.setString(4, changeFields[4].getText());
			preparedStatement.setString(5, changeFields[5].getText());

			String idText = changeFields[0].getText();
			String idText1 = changeFields[3].getText();
			try {
				int dvdId = Integer.parseInt(idText);
				preparedStatement.setInt(6, dvdId);

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Only numbers are allowed", idText, JOptionPane.WARNING_MESSAGE);
			}
			try {
				int erstellungsjahr = Integer.parseInt(changeFields[3].getText());
				preparedStatement.setInt(3, erstellungsjahr);
			} catch (NumberFormatException exs) {
				JOptionPane.showMessageDialog(null, "Only numbers are allowed", idText1, JOptionPane.WARNING_MESSAGE);
			}

			preparedStatement.executeUpdate();

			System.out.println("Successfully changed");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Operation canceled", "Abort", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void setChangeField(JTextField[] changeFields) {
		this.changeFields = changeFields;
	}
}