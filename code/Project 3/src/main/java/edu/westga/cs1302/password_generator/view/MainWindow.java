package edu.westga.cs1302.password_generator.view;

import java.io.IOException;

import edu.westga.cs1302.password_generator.Main;
import edu.westga.cs1302.password_generator.model.Comic;
import edu.westga.cs1302.password_generator.model.ComicCollection;
import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    
    @FXML private MenuItem removeComic;
    @FXML private ListView<Comic> comicList;
    @FXML private Button comicRemoveButton;
    @FXML private Button addComicButt;
    
    @FXML private TextField searchCriter;
    @FXML private Button searchButt;
    
    private ViewModel vm;
 
    @FXML
	private void initialize() {
    	this.comicCName.setText("Collection Name");
    	this.vm = new ViewModel();
    	this.bindComponents();
    	this.setupChangeListenerListView();
    	
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
    	
    	this.removeButton.setOnAction((event) -> {
    		this.removeCollection(); });
    	
    	this.removeButtonButton.setOnAction((event) -> {
    		this.removeCollection(); });
    	
    	this.comicCName.textProperty().addListener(
    			(observable, oldV, newV) -> {
    				if (!this.comicCName.getText().isEmpty()) {
    					this.addButton.disableProperty().set(false);
    				} else {
    					this.addButton.disableProperty().set(true);
    				}
    			}
    			);
    	
    	this.removeComic.setOnAction((event) -> {
    				try {
    					this.vm.removeComic();
    					this.comicList.getItems().remove(this.vm.getSelectedComic());
    					this.comicList.setItems(this.vm.getComicsInCollection());
    				} catch (IllegalArgumentException error) {
    					Alert alert = new Alert(AlertType.ERROR);
    					alert.setContentText("Unable to Remove Comic");
    				alert.showAndWait();
    				}
    			});
    	
    	this.addComicWindowMethod();
   }

	private void addComicWindowMethod() {
		this.addComicButt.setOnAction((event) -> {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(Main.class.getResource(Main.ADD_COMIC_WINDOW_RESOURCE));
    		try {
    			loader.load();
    			Parent parent = loader.getRoot();
    			Scene scene = new Scene(parent);
    			Stage addCWindow = new Stage();
    			addCWindow.setTitle("");
    			addCWindow.setScene(scene);
    			addCWindow.initModality(Modality.APPLICATION_MODAL);
    			AddComicWindow controller = (AddComicWindow) loader.getController();
    			controller.setViewModel(this.vm);
    			addCWindow.showAndWait();
    		} catch (IOException error) {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setContentText("Failed to load add comic window. Error loading UI components;");
    			alert.showAndWait();
    		} catch (IllegalArgumentException error) {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setContentText("Failed to load options window. Error passing password generator to options window.");
    			alert.showAndWait();
    		}
    	});
	}

	private void removeCollection() {
		try {
			this.vm.removeSelectedCollection();
			this.comicCList.setItems(this.vm.getCollectionList());
		} catch (IllegalArgumentException error) {
			Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to Remove Comic collection");
			alert.showAndWait();
		}
	}
    
	private void setupChangeListenerListView() {
		this.comicCList.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldCollection, newCollection) -> {
					if (newCollection != null) {
						this.comicList.getItems().clear();
						this.comicList.getItems().addAll(newCollection.getComics());
						//this.comicList. .comicCList.getSelectionModel().getSelectedItem().getComics();
					}
				});
	}
    
    /** binds components to the viewModel
     * 
     */
    private void bindComponents() {
    	this.vm.getNewCollectionName().bindBidirectional(this.comicCName.textProperty());
    	this.comicCList.setItems(this.vm.getCollectionList());
    	this.comicList.setItems(this.vm.getComicsInCollection());
    	this.vm.getSelectedCollection().bind(this.comicCList.getSelectionModel().selectedItemProperty());
    	this.vm.getSelectedComic().bind(this.comicList.getSelectionModel().selectedItemProperty());
    }
    
}
