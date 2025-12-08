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
	
	@Override
	public String toString() {
		return this.name + "Issue: " + this.issueNum;
	}
}
