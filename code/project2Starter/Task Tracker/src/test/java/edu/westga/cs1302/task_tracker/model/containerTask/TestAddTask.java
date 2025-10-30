package edu.westga.cs1302.task_tracker.model.containerTask;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestAddTask {

	@Test
	void testWhenTaskIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ContainerTask("name", "des", TaskPriority.LOW, new ArrayList<Task>()).addTask(null);
		});
	}
	
	@Test
	void testWhenTaskIsValid() {
		// I'm not sure if I did this one right
		ContainerTask task = new ContainerTask("name", "des", TaskPriority.LOW, new ArrayList<Task>());
		Task sub = new Task("n", "d", TaskPriority.LOW);
		task.addTask(sub);
		ArrayList<Task> actual = task.getSubtasks();
		ArrayList<Task> expected = new ArrayList<Task>();
		expected.add(sub);
		assertEquals(actual, expected);
		assertTrue(task.addTask(sub).equals(task));
	}

}
