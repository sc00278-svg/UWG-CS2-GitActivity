package edu.westga.cs1302.javafx_sample_starter.test.model.utility;

import static org.junit.jupiter.api.Assertions.*;

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
		Task[] tkL = new Task[3];
		Task tk1 = new Task("task1", "low", "fffff");
		tkL[0] = tk1;
		Task tk2 = new Task("task2", "high", "fffff");
		tkL[1] = tk2;
		Task tk3 = new Task("task3", "low", "llllll");
		tkL[2] = tk3;
		//act
		int num = Utility.tasksOfAPriority(tkL, "low");
		//assert
		assertEquals(2, num, "asserts that num and the expected number are the same");
	}
}
