package edu.westga.cs1302.password_generator.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.password_generator.model.Comic;
import edu.westga.cs1302.password_generator.model.ComicCollection;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
	
	private StringProperty name;
	private IntegerProperty issueNumber;
	private ListProperty<Comic> comicsInSelectedCollection;
	private ObjectProperty<Comic> selectedComic;
	
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
		
		//this.comicsInSelectedCollection = this.selectedCollection.get().getComics();
		
		this.name = new SimpleStringProperty("");
		this.issueNumber = new SimpleIntegerProperty();
		this.comicsInSelectedCollection = new SimpleListProperty<Comic>(FXCollections.observableList(new ArrayList<Comic>()));
		this.selectedComic = new SimpleObjectProperty<Comic>();
	}
	
	/** gets the list of comics in a collection
	 * 
	 * @return list of comics in collection
	 */
	public ListProperty<Comic> getComicsInCollection() {
		return this.comicsInSelectedCollection;
	}
	
	/** gets the selected Comic
	 * 
	 * @return selected comic
	 */
	public ObjectProperty<Comic> getSelectedComic() {
		return this.selectedComic;
	}
	
	/** gets the name of a comic 
	 * 
	 * @return the name of a comic
	 */
	public StringProperty getComicName() {
		return this.name;
	}
	
	/**gets the issue number
	 * 
	 * @return the issue number
	 */
	public IntegerProperty getIssue() {
		return this.issueNumber;
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
	
	/** adds comics to the list of comics for the selected Collection
	 * 
	 */
	public void addNewComic() {
//		ComicCollection collection = this.selectedCollection.get();
//		if (collection == null) {
//			throw new IllegalArgumentException("not collection to add to");
//		} else {
			Comic newComic = new Comic(this.name.get(), this.issueNumber.get());
			this.comicsInSelectedCollection.add(newComic);
//		}
		
//		this.selectedCollection.get().addComicToCollection(new Comic(this.getComicName().get(), this.issueNumber.get()));
	}
	
	/** removes a selected comic from a list of comics in a collection
	 * 
	 */
	public void removeComic() {
		Comic selected = this.selectedComic.get();
		if (this.selectedComic != null) {
			this.comicsInSelectedCollection.remove(selected);
		} else {
			throw new IllegalArgumentException("no comic selected to be removed");
		}
	}
}
