package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.model.ComicCollection;
import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	
    @FXML private ListView<ComicCollection> comicCList;
    @FXML private TextField comicCName;
    @FXML private Button addButton;
    @FXML private ContextMenu contextMenu;
    @FXML private Button removeButton;
    @FXML private Button removeButtonButton;

    private ViewModel vm;
    //private ObjectProperty<ComicCollection> selectedCollection;
    
    @FXML
	private void initialize() {
    	this.comicCName.setText("Collection Name");
    	//this.selectedCollection = new SimpleObjectProperty<ComicCollection>();
    	this.vm = new ViewModel();
    	this.bindComponents();
    	
    	this.addButton.setOnAction(
    			(event) -> {
    				try {
    					this.vm.addCollection();
    				} catch (IllegalArgumentException error) {
    					Alert alert = new Alert(AlertType.ERROR);
	    					alert.setContentText("Unable to Add Comic collection: " + error.getMessage());
						alert.showAndWait();
    				}
    				}
    			);
    	
    	this.removeButton.setOnAction(
    			(event) -> {
    				this.removeCollection();
    				}
    			);
    	
    	this.removeButtonButton.setOnAction(
    			(event) -> {
    				this.removeCollection();
    			});
    	
    	this.comicCName.textProperty().addListener(
    			(observable, oldV, newV) -> {
    				if (!this.comicCName.getText().isEmpty()) {
    					this.addButton.disableProperty().set(false);
    				} else {
    					this.addButton.disableProperty().set(true);
    				}
    			}
    			);
   }

	private void removeCollection() {
		try {
			this.vm.getSelectedCollection().set(this.comicCList.getSelectionModel().getSelectedItem());
			this.vm.removeSelectedCollection();
			this.comicCList.setItems(this.vm.getCollectionList());
		} catch (IllegalArgumentException error) {
			Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to Remove Comic collection");
			alert.showAndWait();
		}
	}
    
//	private void setupChangeListenerListView() {
//		this.comicCList.getSelectionModel().selectedItemProperty()
//				.addListener((observable, oldCollection, newCollection) -> {
//					if (newCollection != null) {
//						this.selectedCollection.set(newCollection);
//						
//					}
//				});
//	}
    
    /** binds components to the viewModel
     * 
     */
    private void bindComponents() {
    	this.vm.getNewCollectionName().bindBidirectional(this.comicCName.textProperty());
    	this.comicCList.setItems(vm.getCollectionList());
    	//this.vm.getSelectedCollection().bindBidirectional(this.selectedCollection);
    	
    }
    
}
