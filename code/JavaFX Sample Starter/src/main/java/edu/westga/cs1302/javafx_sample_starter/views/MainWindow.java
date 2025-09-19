package edu.westga.cs1302.javafx_sample_starter.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Controller class for drawing various things to our canvas window.
 *
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

  @FXML
  private TextArea taskDescription;

  @FXML
  private TextField taskName;

  @FXML
  private ComboBox<?> taskPriority;

  @FXML
  void selectPriority(ActionEvent event) {
    
  }

  @FXML
  void selectTask(MouseEvent event) {
    
  }

  @FXML
  void submitTask(ActionEvent event) {

  }

  /**
  * Perform any needed initialization of UI components and underlying objects.
  */
  public void initialize() {
    
  }
}
