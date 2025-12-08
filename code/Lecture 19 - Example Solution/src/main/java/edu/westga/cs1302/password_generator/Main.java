package edu.westga.cs1302.password_generator;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Starting point for the project. Launches the main window.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class Main extends Application {
	private static final String WINDOW_TITLE = "Password Generator";
	private static final String MAIN_WINDOW_RESOURCE = "view/MainWindow.fxml";
	public static final String OPTIONS_WINDOW_RESOURCE = "view/OptionsWindow.fxml";

	/**
	 * JavaFX entry point.
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @throws IOException
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource(Main.MAIN_WINDOW_RESOURCE));
		Scene scene = new Scene(parent);
		primaryStage.setTitle(WINDOW_TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Primary Java entry point.
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param args command line arguments
	 */

	public static void main(String[] args) {
		Main.launch(args);
	}

}
