package edu.westga.cs1302.javafx_sample_starter.test.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.javafx_sample_starter.model.Task;

class testConstructor {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testWhenNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "low", "ffffff");});
	}
	
	
}
