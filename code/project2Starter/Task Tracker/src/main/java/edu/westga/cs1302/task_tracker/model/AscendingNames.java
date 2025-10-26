package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/** Compare two Tasks to identify the correct Ascending ordering based on the name of the tasks.
 * 
 * @author samco
 * @version Fall 2025
 */
public class AscendingNames implements Comparator<Task> {
	
	@Override
	public int compare(Task t1, Task t2) {
		if (t1 == null) {
			throw new IllegalArgumentException("Not a valid task.");
		}
		if (t2 == null) {
			throw new IllegalArgumentException("Not a valid task.");
		}
		String one = t1.getName();
		String two = t2.getName();
		return one.compareToIgnoreCase(two) * -1;
	}
	
	/** Returns the name of the ordering method of the list of tasks
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return name of the way the tasks are ordered
	 */
	@Override
	public String toString() {
		return "Ascending Names";
	}
}
