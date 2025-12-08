package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class OptionsWindow {

	@FXML
	private CheckBox mustIncludeDigits;
	@FXML
	private CheckBox mustIncludeLowerCaseLetters;
	@FXML
	private CheckBox mustIncludeUpperCaseLetters;
	@FXML
	private TextField minimumLength;

	private PasswordGenerator generator;

	@FXML
	void initialize() {
		this.minimumLength.setText("1");
	}

	/**
	 * Set the password generator for the OptionsWindow
	 * 
	 * @precondition generator != null
	 * @postcondition password generator is set
	 * 
	 * @param generator the password generator to set when options are changed
	 */
	public void setPasswordGenerator(PasswordGenerator generator) {
		if (generator == null) {
			throw new IllegalArgumentException("generator must not be null");
		}
		this.generator = generator;
		this.minimumLength.setText(this.generator.getMinimumLength() + "");
		this.mustIncludeDigits.selectedProperty().set(this.generator.getMustHaveAtLeastOneDigit());
		this.mustIncludeLowerCaseLetters.selectedProperty().set(this.generator.getMustHaveAtLeastOneLowerCaseLetter());
		this.mustIncludeUpperCaseLetters.selectedProperty().set(this.generator.getMustHaveAtLeastOneUpperCaseLetter());
		
		
	}

	@FXML
	void applyOptions(ActionEvent event) {
		int minimumLength = -1;

		try {
			minimumLength = Integer.parseInt(this.minimumLength.getText());
		} catch (NumberFormatException numberError) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(
					"Invalid Minimum Length: must be a positive integer, but was " + this.minimumLength.getText());
			alert.show();
			return;
		}  

		try {
			this.generator.setMinimumLength(minimumLength);
		} catch (IllegalArgumentException invalidLengthError) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Invalid Minimum Length: " + invalidLengthError.getMessage());
			alert.show();
			return;
		}

		this.generator.setMustHaveAtLeastOneDigit(this.mustIncludeDigits.isSelected());
		this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.mustIncludeLowerCaseLetters.isSelected());
		this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.mustIncludeUpperCaseLetters.isSelected());
	}
}
