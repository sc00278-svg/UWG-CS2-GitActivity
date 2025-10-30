package edu.westga.cs1302.task_tracker.model.task;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestAddTask {

	@Test
	void testWhenSubTaskNull() {
		Task task = new Task("name", "descr", TaskPriority.LOW);
		Task sub = null;
		ContainerTask actual = task.addTask(sub);
		ContainerTask excpected = new ContainerTask("name", "descr", TaskPriority.LOW, new ArrayList<Task>());
		assertTrue(actual.getName().equals(excpected.getName()));
		assertTrue(actual.getDescription().equals(excpected.getDescription()));
		assertTrue(actual.getPriority().equals(excpected.getPriority()));
		assertTrue(actual.getSubtasks().equals(excpected.getSubtasks()));
	}
	
	@Test
	void testWhenSubTaskNotNull() {
		Task task = new Task("name", "descr", TaskPriority.LOW);
		Task sub = new Task("nm", "des", TaskPriority.LOW);
		ContainerTask actual = task.addTask(sub);
		ContainerTask excpected = new ContainerTask("name", "descr", TaskPriority.LOW, new ArrayList<Task>());
		assertTrue(actual.getName().equals(excpected.getName()));
		assertTrue(actual.getDescription().equals(excpected.getDescription()));
		assertTrue(actual.getPriority().equals(excpected.getPriority()));
		assertTrue(actual.getSubtasks().equals(excpected.getSubtasks()));
	}

}
