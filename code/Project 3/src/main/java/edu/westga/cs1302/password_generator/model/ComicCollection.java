package edu.westga.cs1302.password_generator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates a random password based on the characteristics required.
 *
 * @author CS 1302
 * @version Fall 2025
 */
public class ComicCollection {

	private String comicCollectionName;
	private List<Comic> collection;
	
	/**creates a comic Collection with the name given
	 * 
	 * @precondition comicsName is not null or empty
	 * 
	 * @param comicsName the name of the comic collection
	 */
	public ComicCollection(String comicsName) {
		
		if (comicsName == null || comicsName.isEmpty()) {
			throw new IllegalArgumentException("Not a Valid Name");
		}
		
		this.comicCollectionName = comicsName;
		this.collection = new ArrayList<Comic>();
	}
	
	
	public void addComicToCollection(Comic comic) {
		this.collection.add(comic);
	}
	
	/**gets the name of a comic collection.
	 * 
	 * @return the name of the comic collection
	 */
	public String getComicCollectionName() {
		return this.comicCollectionName;
	}
	
	/**gets the comics in the collection
	 * 
	 * @return the comics in the collection
	 */
	public List<Comic> getComics() {
		return this.collection;
	}
	
	@Override
	public String toString() {
		return this.comicCollectionName;
	}

}
