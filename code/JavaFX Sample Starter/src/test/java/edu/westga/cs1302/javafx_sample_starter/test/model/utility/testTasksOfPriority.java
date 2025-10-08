package edu.westga.cs1302.javafx_sample_starter.test.model.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample_starter.model.Task;
import edu.westga.cs1302.javafx_sample_starter.model.Utility;

class testTasksOfPriority {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testWhenNormal() {
		//arrange
		ArrayList<Task> tkL = new ArrayList<Task>();
		Task tk1 = new Task("task1", "low", "fffff");
		tkL.add(tk1);
		Task tk2 = new Task("task2", "high", "fffff");
		tkL.add(tk2);
		Task tk3 = new Task("task3", "low", "llllll");
		tkL.add(tk3);
		//act
		int num = Utility.tasksOfAPriority(tkL, "low");
		//assert
		assertEquals(2, num, "asserts that num and the expected number are the same");
	}
}
