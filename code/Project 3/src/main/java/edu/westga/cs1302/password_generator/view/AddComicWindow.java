package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.Node;

/**CodeBehind for adding a Comic to a Collection.
 *
 * @author samco
 * @version 1.0 
 */
public class AddComicWindow {

	 @FXML private Button addButton;
	 @FXML private Button cancelButton;
	 @FXML private TextField comicName;
	 @FXML private TextField issueNum;
	 
	 private ViewModel viewM;
	
	 @FXML
	 void initialize() {
		 this.comicName.setText("");
		 this.issueNum.setText("");
		 this.addButton.disableProperty().set(true);
	 }
	 
	 /**sets the viewModel for the window
	  * 
	  * @param vM the viewModel
	  */
	 public void setViewModel(ViewModel vM) {
		 if (vM == null) {
				throw new IllegalArgumentException("veiwModel must not be null");
			}
		 this.viewM = vM;
		 this.comicName.textProperty().bindBidirectional(this.viewM.getComicName());
		 this.issueNum.textProperty().bindBidirectional(this.viewM.getIssue(), new NumberStringConverter());
		 
		 this.addButton.setOnAction((event) -> {
			 try {
				 if (this.viewM.getSelectedCollection() != null) {
					 this.viewM.addNewComic();
					 ((Node) (event.getSource())).getScene().getWindow().hide();
				 }
			 } catch (IllegalArgumentException error) {
				 Alert alert = new Alert(AlertType.ERROR);
				 alert.setContentText("error: could not add comic");
				 alert.showAndWait();
			 }
		 });
		 
		 this.comicName.textProperty().addListener(
	    			(observable, oldV, newV) -> {
	    				if (!this.comicName.getText().isEmpty() || !this.issueNum.getText().isEmpty()) {
	    					this.addButton.disableProperty().set(false);
	    				} else {
	    					this.addButton.disableProperty().set(true);
	    				}
	    			}
	    			);
		 
		 this.issueNum.textProperty().addListener(
	    			(observable, oldV, newV) -> {
	    				if (!this.issueNum.getText().isEmpty()) {
	    					this.addButton.disableProperty().set(false);
	    				} else {
	    					this.addButton.disableProperty().set(true);
	    				}
	    			}
	    			);
		 
		 this.cancelButton.setOnAction((event) -> {
			 ((Node) (event.getSource())).getScene().getWindow().hide();
		 });
	 }
	 
}
