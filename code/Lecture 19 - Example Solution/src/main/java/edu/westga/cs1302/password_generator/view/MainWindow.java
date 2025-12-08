package edu.westga.cs1302.password_generator.view;

import java.io.IOException;
import java.util.Random;

import edu.westga.cs1302.password_generator.Main;
import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
    @FXML private AnchorPane guiPane;
    @FXML private TextArea output;
    
    private PasswordGenerator generator;
    
    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void openOptionsWindow(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource(Main.OPTIONS_WINDOW_RESOURCE));
    	try {
			loader.load();
	    	Parent parent = loader.getRoot();
	    	Scene scene = new Scene(parent);
	    	Stage optionsWindow = new Stage();
	    	optionsWindow.setTitle("");
	    	optionsWindow.setScene(scene);
	    	optionsWindow.initModality(Modality.APPLICATION_MODAL);
	    	
	    	OptionsWindow controller = (OptionsWindow) loader.getController();
	    	controller.setPasswordGenerator(this.generator);
	    	
	    	optionsWindow.showAndWait();
		} catch (IOException error) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Failed to load options window. Error loading UI components;");
			alert.showAndWait();
		} catch (IllegalArgumentException error) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Failed to load options window. Error passing password generator to options window.");
			alert.showAndWait();
		}
    }

    @FXML
    void generatePassword(ActionEvent event) {
    	String password = this.generator.generatePassword();
    	
    	this.output.setText(password);
    }

    @FXML
    void initialize() {
        Random randomNumberGenerator = new Random();
        this.generator = new PasswordGenerator(randomNumberGenerator.nextLong());
    }
}
