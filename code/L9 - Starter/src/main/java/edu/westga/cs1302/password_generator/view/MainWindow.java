package edu.westga.cs1302.password_generator.view;

import java.io.File;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

	@FXML private MenuItem fielAbout;
	@FXML private MenuItem fielClose;
	@FXML private MenuItem fileSave;
    @FXML private MenuBar menu;
	@FXML private Menu menuFile;
    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private Label errorTextLabel;
    @FXML private Label minLengthErrorText;
    @FXML private Button generatePasswordButton;
    @FXML private ListView<String> passwordHistory;
    
    private ViewModel vm;
    
    @FXML
    void initialize() {
    	this.vm = new ViewModel();
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
    	
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	this.passwordHistory.setItems(this.vm.getPasswordHistory());
    	
    	this.minimumLength.textProperty().addListener((observable, oldValue, newValue) -> {
    		this.minLengthErrorText.setVisible(!newValue.matches("\\d+") || Integer.parseInt(newValue) == 0);
    	});
    	
    	this.fielClose.setOnAction((event) -> {
    		((Node) (this.errorTextLabel)).getScene().getWindow().hide();
    	});
    	
    	this.fielAbout.setOnAction((event) -> {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setContentText("About info: This project allows users to submit information about requirements for a password. It will take those requirements and generate a random passowrd that fits the requirements needed." + System.lineSeparator() + "Author: me I guess?");
    		alert.showAndWait();
    	});
    	
    	this.fileSave.setOnAction((event) -> {
    		FileChooser fileChooser = new FileChooser();
    		fileChooser.setTitle("Save data");
    		fileChooser.getExtensionFilters().add(new ExtensionFilter("Text files", "*.txt"));
    		File selectedFile = fileChooser.showOpenDialog(null);
    		boolean saved = this.vm.saveData(selectedFile);
    		if (!saved) {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setContentText("Issue saving data to file");
    			alert.showAndWait();
    		}
    	});
    	
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    			} 
    	);
    }
}
