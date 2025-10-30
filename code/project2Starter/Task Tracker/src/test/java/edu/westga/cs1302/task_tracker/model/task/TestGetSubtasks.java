package edu.westga.cs1302.task_tracker.model.task;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestGetSubtasks {

	@Test
	public void testGetSubtasks() {
		Task task = new Task("name", "descript", TaskPriority.LOW);
		ArrayList<Task> actual = task.getSubtasks();
		assertTrue(actual.isEmpty());
	}

}
