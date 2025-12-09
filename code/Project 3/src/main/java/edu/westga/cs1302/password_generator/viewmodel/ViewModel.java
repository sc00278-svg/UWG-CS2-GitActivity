package edu.westga.cs1302.password_generator.viewmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.westga.cs1302.password_generator.model.Comic;
import edu.westga.cs1302.password_generator.model.ComicCollection;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
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
	
	private StringProperty searchCriteria;
	private Map<String, Comic> issueNumMap;
	private Map<String, Comic> comicNameMap;
	
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
		
		this.name = new SimpleStringProperty("");
		this.issueNumber = new SimpleIntegerProperty();
		this.comicsInSelectedCollection = new SimpleListProperty<Comic>(FXCollections.observableList(new ArrayList<Comic>()));
		this.selectedComic = new SimpleObjectProperty<Comic>();
		
		this.searchCriteria = new SimpleStringProperty("");
		this.issueNumMap = new HashMap<String, Comic>();
		this.comicNameMap = new HashMap<String, Comic>();
	}
	
	/**gets the search criteria for a comic
	 * 
	 * @return the search criteria
	 */
	public StringProperty getSearchCriteria() {
		return this.searchCriteria;
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
			Comic newComic = new Comic(this.name.get(), this.issueNumber.get());
			this.selectedCollection.get().addComicToCollection(newComic);
			this.comicsInSelectedCollection.add(newComic);
			this.comicNameMap.put(this.name.get(), newComic);
			String numKey = String.valueOf(this.issueNumber.get());
			this.issueNumMap.put(numKey, newComic);
	}
	
	/** removes a selected comic from a list of comics in a collection
	 * 
	 */
	public void removeComic() {
		Comic selected = this.selectedComic.get();
		if (this.selectedComic.get() != null) {
			this.selectedCollection.get().removeComicFromCollection(selected);
			this.comicsInSelectedCollection.remove(selected);
		} else {
			throw new IllegalArgumentException("no comic selected to be removed");
		}
	}
	
	/** finds comic based on the title or issue number
	 * 
	 * @return the comic found
	 */
	public String findComic() {
		if (!Comic.checkName(this.searchCriteria.get()) && !Comic.checkIssueNumber(this.searchCriteria.get())) {
			throw new IllegalArgumentException("Search criteria is not a valid name or issue number");
		}
		
		if (Comic.checkIssueNumber(this.searchCriteria.get())) {
			Comic com = this.issueNumMap.get(this.searchCriteria.get());
			if (com != null) {
				return com.toString();
			}
		}
		if (Comic.checkName(this.searchCriteria.get())) {
			Comic com = this.comicNameMap.get(this.searchCriteria.get());
			if (com != null) {
				return com.toString();
			}
		}
		
		return "No comic found.";
	}
}
