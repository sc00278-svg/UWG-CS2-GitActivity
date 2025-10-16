package edu.westga.cs1302.task_tracker.model.descending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.DescendingOrder;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

	@Test
	void testWhenThereAreTwoValidTasks() {
		Task one = new Task("nameOne", "dagj", TaskPriority.HIGH);
		Task two = new Task("Second", "dga", TaskPriority.LOW);
		DescendingOrder order = new DescendingOrder();
		
		int result = order.compare(one, two);
		
		assertEquals(result, -1, "aserts that task two is sorted before task one.");
	}
	
	@Test
	void testWhenNoTaskOne() {
		Task two = new Task("Second", "dga", TaskPriority.LOW);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new DescendingOrder().compare(null, two);
		});
	}
	
	@Test
	void testWhenNoTaskTwo() {
		Task one = new Task("first", "dga", TaskPriority.LOW);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new DescendingOrder().compare(one, null);
		});
	}
	
	@Test
	void testWhenBothTasksAreNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new DescendingOrder().compare(null, null);
		});
	}

}
