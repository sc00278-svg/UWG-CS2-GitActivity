package edu.westga.cs1302.password_generator.model;

/**
 * Generates a random password based on the characteristics required.
 *
 * @author CS 1302
 * @version Fall 2025
 */
public class ComicCollections {

	//TODO: commit before you do anything else
	
	private String comicCollectionName;
	
	/**creates a comic Collection with the name given
	 * 
	 * @precondition comicsName is not null or empty
	 * 
	 * @param comicsName the name of the comic collection
	 */
	public ComicCollections(String comicsName) {
		
		if (comicsName == null || comicsName.isEmpty()) {
			throw new IllegalArgumentException("Not a Valid Name");
		}
		
		this.comicCollectionName = comicsName;
	}

//	private String combineCharacters(ArrayList<Character> passwordCharacters) {
//		String password = "";
//		for (Character currentChar : passwordCharacters) {
//			password += currentChar;
//		}
//		return password;
//	}
}
