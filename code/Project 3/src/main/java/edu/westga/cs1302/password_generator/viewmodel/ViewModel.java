package edu.westga.cs1302.password_generator.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.password_generator.model.ComicCollection;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** Manages utilizing the model and makes properties available to bind the UI elements.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class ViewModel {

	private StringProperty newCollectionName;
	private ListProperty<ComicCollection> collections;
	private ObjectProperty<ComicCollection> selectedCollection;
	
	/** creates the veiwModel
	 * 
	 */
	public ViewModel() {
		
		this.newCollectionName = new SimpleStringProperty("");
		this.collections = new SimpleListProperty<ComicCollection>(
				FXCollections.observableList(
						new ArrayList<ComicCollection>()
				)
			);
		this.selectedCollection = new SimpleObjectProperty<ComicCollection>();
	}
	
	/**gets the list of collections
	 * 
	 * @return the list of collections
	 */
	public ListProperty getCollectionList() {
		return this.collections;
	}
	
	/**the name of the new collection
	 * 
	 * @return the new Collection's name
	 */
	public StringProperty getNewCollectionName() {
		return this.newCollectionName;
	}
	
	/**gets the selected  comic collection
	 * 
	 * @return the selected Collection
	 */
	public ObjectProperty<ComicCollection> getSelectedCollection() {
		return this.selectedCollection;
	}
	
	/** adds a new comic collection to the list of collections
	 * 
	 */
	public void addCollection() {
		ComicCollection comics = new ComicCollection(this.newCollectionName.get());
		this.collections.add(comics);
	}
	
	/**removes the selected collection from the list
	 * 
	 */
	public void removeSelectedCollection() {	
		ComicCollection comics = this.selectedCollection.get();
    	if (comics != null) {
    		this.collections.remove(comics);
    	} else {
    		throw new IllegalArgumentException("no collection to remove");
    	}
		
	}
}
