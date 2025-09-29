package edu.westga.cs1302.javafx_sample_starter.model;

/**class takes a priority and a list of tasks for finding out how many tasks are in each priority category.
 * 
 * @author samco
 * @version 1.0
 */
public class Utility {
	
	/**get the number of tasks of a specific priority.
	 * 
	 * @param tasks the list of tasks
	 * @param priority the specified priority
	 * @return the number of tasks for the priority
	 */
	public static int tasksOfAPriority(Task[] tasks, String priority) {
		if (tasks != null && priority != null) {
			int num = 0;
			for (Task currtask : tasks) {
				if (currtask.getPriority().equals(priority)) {
					num++;
				}
			}
			return num;
		} else {
			throw new IllegalArgumentException("must have a list of tasks and a priority");
		}
	}
}
