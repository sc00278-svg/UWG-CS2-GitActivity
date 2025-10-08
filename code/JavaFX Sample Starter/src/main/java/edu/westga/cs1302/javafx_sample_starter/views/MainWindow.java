package edu.westga.cs1302.javafx_sample_starter.views;

import java.util.ArrayList;

import edu.westga.cs1302.javafx_sample_starter.model.Task;
import edu.westga.cs1302.javafx_sample_starter.model.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
  private Label highPriLabel;

  @FXML
  private Label lowPriLabel;

  @FXML
  private Label midPriLabel;

  @FXML
  private TextArea selectedDescription;

  @FXML
  private TextField selectedTaskPriority;

  @FXML
  private TextArea taskDescription;

  @FXML
  private TextField taskName;

  @FXML
  private ComboBox<String> taskPriority;
  
  @FXML
  private ListView<Task> taskList;
  
  @FXML
  void displayNumOfPriorities(ActionEvent event) {
	// just making a change to the thing to hopefully get the git commit to work
	int num = this.taskList.getItems().size();
    for (String currPrio : this.taskPriority.getItems()) {
    	if (currPrio.equals("High")) {
    		this.highPriLabel.setText(currPrio + " Priority: " + Utility.tasksOfAPriority(this.taskList.getItems().toArray(new Task[num]), currPrio));
    	} else if (currPrio.equals("Medium")) {
    		this.midPriLabel.setText(currPrio + " Priority: " + Utility.tasksOfAPriority(this.taskList.getItems().toArray(new Task[num]), currPrio));
    	} else if (currPrio.equals("Low")) {
    		this.lowPriLabel.setText(currPrio + " Priority: " + Utility.tasksOfAPriority(this.taskList.getItems().toArray(new Task[num]), currPrio));
    	}
    }
  }

  @FXML
  void selectPriority(ActionEvent event) {
    this.taskPriority.setValue(this.taskPriority.getValue());
  }

  @FXML
  void selectTask(MouseEvent event) {
    Task selectedTask = this.taskList.getSelectionModel().getSelectedItem();
    this.selectedDescription.setText(selectedTask.getDescription());
    this.selectedTaskPriority.setText(selectedTask.getPriority());
  }

  @FXML
  void submitTask(ActionEvent event) {
    Task newTask = new Task(this.taskName.getText(), this.taskPriority.getValue(),
        this.taskDescription.getText());
    this.taskList.getItems().add(newTask);
  }
  
  @FXML
  void updateDescription(ActionEvent event) {
    Task selected = this.taskList.getSelectionModel().getSelectedItem();
    selected.updateDescription(this.selectedDescription.getText());
  }
  
  @FXML
  void removeTask(ActionEvent event) {
    Task task = this.taskList.getSelectionModel().getSelectedItem();
    if (task != null) {
      this.taskList.getItems().remove(task);
    }
  }

  /**
  * Perform any needed initialization of UI components and underlying objects.
  */
  public void initialize() {
    // turn into constants in the Task class
    this.taskPriority.getItems().add("High");
    this.taskPriority.getItems().add("Medium");
    this.taskPriority.getItems().add("Low");
    // preselects the medium value
    this.taskPriority.setValue(this.taskPriority.getItems().get(1)); 
  }
}
