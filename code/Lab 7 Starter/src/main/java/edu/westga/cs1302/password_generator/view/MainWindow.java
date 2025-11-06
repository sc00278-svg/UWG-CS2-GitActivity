package edu.westga.cs1302.password_generator.view;

import java.text.ParseException;
import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import edu.westga.cs1302.password_generator.viewmodel.MainWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML private Button generatorButton;
    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private TextArea output;
    
    private MainWindowViewModel viewModel;
    private PasswordGenerator generator;

//    @FXML
//    void generatePassword(ActionEvent event) {
////    	int minimumLength = -1;
////    	
////    	try {
////    		minimumLength = Integer.parseInt(this.minimumLength.getText());
////    	} catch (NumberFormatException numberError) {
////    		Alert alert = new Alert(AlertType.ERROR);
////    		alert.setContentText("Invalid Minimum Length: must be a positive integer, but was " + this.minimumLength.getText());
////    		alert.show();
////    		return;
////    	}
////    	
////    	try {
////    		this.generator.setMinimumLength(minimumLength);
////    	} catch (IllegalArgumentException invalidLengthError) {
////    		Alert alert = new Alert(AlertType.ERROR);
////    		alert.setContentText("Invalid Minimum Length: " + invalidLengthError.getMessage());
////    		alert.show();
////    		return;
////    	}
////    	
////    	this.generator.setMustHaveAtLeastOneDigit(this.mustIncludeDigits.isSelected());
////    	this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.mustIncludeLowerCaseLetters.isSelected());
////    	this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.mustIncludeUpperCaseLetters.isSelected());
////    	
////    	String password = this.generator.generatePassword();
////    	
////    	this.output.setText(password);
//    	
//        this.generatorButton.setOnAction((eve) -> {
//    		this.viewModel.makePassword();
//    	});
//    	
//    }  

    @FXML
    void initialize() {
        assert this.mustIncludeDigits != null : "fx:id=\"mustIncludeDigits\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.mustIncludeLowerCaseLetters != null : "fx:id=\"mustIncludeLowerCaseLetters\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.mustIncludeUpperCaseLetters != null : "fx:id=\"mustIncludeUpperCaseLetters\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.minimumLength != null : "fx:id=\"minimumLength\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.output != null : "fx:id=\"output\" was not injected: check your FXML file 'MainWindow.fxml'.";

        
        this.viewModel = new MainWindowViewModel();
        this.bindComponents();
        this.minimumLength.setText("1");
        Random randomNumberGenerator = new Random();
        this.generator = new PasswordGenerator(randomNumberGenerator.nextLong());
        
        this.generatorButton.setOnAction((eve) -> {
    		try {
    			this.viewModel.makePassword();
    		}
    		catch (IllegalArgumentException invalidLengthError) {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setContentText("Invalid Minimum Length: " + invalidLengthError.getMessage());
    			alert.show();
    			return;
    		}
    		catch (ParseException e) {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setContentText("Invalid Minimum Length: must be a positive integer, but was " + this.minimumLength.getText());
    			alert.show();
    			return;
    		}
    	});
    }
    
    /**binds the components to the viewModel.
     * 
     */
    public void bindComponents() {
    	this.minimumLength.textProperty().bindBidirectional(this.viewModel.minLength(), new NumberStringConverter());
    	this.output.textProperty().bindBidirectional(this.viewModel.getPassword());
    	this.mustIncludeDigits.selectedProperty().bindBidirectional(this.viewModel.hasNum());
    	this.mustIncludeLowerCaseLetters.selectedProperty().bindBidirectional(this.viewModel.hasLowerCase());
    	this.mustIncludeUpperCaseLetters.selectedProperty().bindBidirectional(this.viewModel.hasUpperCase());
    }
    
}
