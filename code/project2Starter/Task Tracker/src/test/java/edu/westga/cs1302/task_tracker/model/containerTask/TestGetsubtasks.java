package edu.westga.cs1302.task_tracker.model.containerTask;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestGetsubtasks {

	@Test
	void testWhenOneSubTask() {
		ContainerTask task = new ContainerTask("name", "des", TaskPriority.LOW, new ArrayList<Task>());
		Task sub = new Task("n", "d", TaskPriority.LOW);
		task.addTask(sub);
		ArrayList<Task> actual = task.getSubtasks();
		ArrayList<Task> expected = new ArrayList<Task>();
		expected.add(sub);
		assertEquals(actual, expected, "checks to see if the lists of sub tasks are the same");
	}
	
	@Test
	void testWhenMultipleSubTask() {
		ContainerTask task = new ContainerTask("name", "des", TaskPriority.LOW, new ArrayList<Task>());
		Task sub = new Task("n", "d", TaskPriority.LOW);
		Task sub2 = new Task("la", "de-da", TaskPriority.LOW);
		task.addTask(sub);
		task.addTask(sub2);
		ArrayList<Task> actual = task.getSubtasks();
		ArrayList<Task> expected = new ArrayList<Task>();
		expected.add(sub);
		expected.add(sub2);
		assertEquals(actual, expected, "checks to see if the lists of sub tasks are the same");
	}
	
	@Test
	void testWhenNoSubTask() {
		ContainerTask task = new ContainerTask("name", "des", TaskPriority.LOW, new ArrayList<Task>());
		ArrayList<Task> actual = task.getSubtasks();
		ArrayList<Task> expected = new ArrayList<Task>();
		assertEquals(actual, expected, "checks to see if the lists of sub tasks are the same");
	}

}
