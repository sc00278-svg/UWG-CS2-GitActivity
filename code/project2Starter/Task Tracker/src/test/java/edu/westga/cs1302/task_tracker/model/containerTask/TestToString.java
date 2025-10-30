package edu.westga.cs1302.task_tracker.model.containerTask;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestToString {

	@Test
	void test() {
		ContainerTask task = new ContainerTask("name", "des", TaskPriority.LOW, new ArrayList<Task>());
		String actual = task.toString();
		assertEquals(actual, "name(+)", "checks to see if the actual String matches the expected String");
	}

}
