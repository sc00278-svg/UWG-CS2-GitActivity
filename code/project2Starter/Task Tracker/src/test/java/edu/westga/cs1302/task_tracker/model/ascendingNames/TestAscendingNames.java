package edu.westga.cs1302.task_tracker.model.ascendingNames;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.AscendingNames;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestAscendingNames {

	@Test
	void testT1Before() {
		Task o1 = new Task("bee", "desc", TaskPriority.HIGH);
		Task o2 = new Task("A", "desc", TaskPriority.LOW);
		AscendingNames order = new AscendingNames();
		
		int result = order.compare(o1, o2);
		
		assertTrue(result < 0);
	}
	
	@Test
	void testT1BeforeAtTheSecondLetter() {
		Task o1 = new Task("bee", "desc", TaskPriority.HIGH);
		Task o2 = new Task("bali", "desc", TaskPriority.LOW);
		AscendingNames order = new AscendingNames();
		
		int result = order.compare(o1, o2);
		
		assertTrue(result < 0);
	}
	
	@Test
	void testT1BeforeAtSecondWord() {
		Task o1 = new Task("project CS", "desc", TaskPriority.HIGH);
		Task o2 = new Task("Project Bio.", "desc", TaskPriority.LOW);
		AscendingNames order = new AscendingNames();
		
		int result = order.compare(o1, o2);
		
		assertTrue(result < 0);
	}
	
	@Test
	void testT1AndT2AreEqual() {
		Task o1 = new Task("Art", "desc", TaskPriority.HIGH);
		Task o2 = new Task("Art", "desc", TaskPriority.LOW);
		AscendingNames order = new AscendingNames();
		
		int result = order.compare(o1, o2);
		
		assertTrue(result == 0);
	}
	
	@Test
	void testT1After() {
		Task o1 = new Task("Art", "desc", TaskPriority.HIGH);
		Task o2 = new Task("dance practice", "desc", TaskPriority.LOW);
		AscendingNames order = new AscendingNames();
		
		int result = order.compare(o1, o2);
		
		assertTrue(result > 0);
	}
	
	@Test
	void testWhenT1IsNull() {
		Task o2 = new Task("Art", "desc", TaskPriority.LOW);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new AscendingNames().compare(null, o2);
		});
	}
	
	@Test
	void testWhenT2IsNull() {
		Task o2 = new Task("Art", "desc", TaskPriority.LOW);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new AscendingNames().compare(o2, null);
		});
	}

}
