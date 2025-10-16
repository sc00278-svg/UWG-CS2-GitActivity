package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

/** compares two tasks to determine which one comes first in descending order
 *
 * @author samco
 * @version 1
 */
public class DescendingOrder implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		if (o1 == null) {
			throw new IllegalArgumentException("missing a task to compare.");
		}
		if (o2 == null) {
			throw new IllegalArgumentException("missing a task to compare.");
		}

		int val1;
		if (o1.getPriority() == TaskPriority.HIGH) {
			val1 = 2;
		} else if (o1.getPriority() == TaskPriority.MEDIUM) {
			val1 = 1;
		} else {
			val1 = 0;
		}

		int val2;
		if (o2.getPriority() == TaskPriority.HIGH) {
			val2 = 2;
		} else if (o2.getPriority() == TaskPriority.MEDIUM) {
			val2 = 1;
		} else {
			val2 = 0;
		}

		if (val1 < val2) {
			return 1;
		} else if (val1 == val2) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Descending";
	}
}
