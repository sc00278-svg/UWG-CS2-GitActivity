package edu.westga.cs1302.password_generator.model;

/**creates a comic
 * 
 * @author samco
 * @version 1.0
 */
public class Comic {

	private String name;
	private int issueNum;
	
	/**creates a new comic
	 * 
	 * @param na is the name of the comic
	 * @param num is the issue number of the comic
	 */
	public Comic(String na, int num) {
		
		if (na.isEmpty() || na == null) {
			throw new IllegalArgumentException("not a valid name");
		} else if (num < 1) {
			throw new IllegalArgumentException("not a valid issue number");
		}
		
		this.name = na;
		this.issueNum = num;
		
	}
	
	/**gets the name of the comic
	 * 
	 * @return the name of the comic
	 */
	public String getName() {
		return this.name;
	}
	
	/**gets the issue number of the comic
	 * 
	 * @return the issue number of the comic
	 */
	public int getIssueNum() {
		return this.issueNum;
	}
	
	/** checks that the string matches a number greater than 0
	 * 
	 * @param issueNumber the issue number
	 * @return true is the issueNumber matches and false if it is null or does not match
	 */
	public static boolean checkIssueNumber(String issueNumber) {
		String noDashFormat = "^\\d[1-9]+\\d$";
		String optionTwo = "^[1-9]+$";
		return issueNumber != null && (issueNumber.matches(noDashFormat) || issueNumber.matches(optionTwo));
	}
	
	/** checks that the string matches a title pattern for comics
	 * 
	 * @param name the title 
	 * @return true if the the name matches and false if null or not matching
	 */
	public static boolean checkName(String name) {
		String wordAndSpace = "[a-zA-Z\\s*]+";
		return name != null && name.matches(wordAndSpace);
	}
	
	@Override
	public String toString() {
		return this.name + " Issue: " + this.issueNum;
	}
}
