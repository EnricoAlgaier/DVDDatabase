package EventListener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class InsertTextFieldFocuListener implements FocusListener {
	private JTextField textField;
	private String nameTextField;

	public InsertTextFieldFocuListener(JTextField inserttextfield, String textFieldName) {
		this.textField = inserttextfield;
		this.nameTextField = textFieldName;
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (textField.getText().equals(nameTextField)) {
			textField.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (textField.getText().isEmpty()) {
			textField.setText(nameTextField);
		}
	}
}