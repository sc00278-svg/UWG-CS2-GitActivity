package edu.westga.cs1302.task_tracker.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestDescendingName {
	
	@Test
	void testT1AfterAndT2Before() {
		Task o1 = new Task("bee", "desc", TaskPriority.HIGH);
		Task o2 = new Task("A", "desc", TaskPriority.LOW);
		DescendingNames order = new DescendingNames();
		
		int result = order.compare(o1, o2);
		
		assertTrue(result > 0);
	}
	
	@Test
	void testT1AfterAndT2BeforeAtTheSecondLetter() {
		Task o1 = new Task("bee", "desc", TaskPriority.HIGH);
		Task o2 = new Task("bali", "desc", TaskPriority.LOW);
		DescendingNames order = new DescendingNames();
		
		int result = order.compare(o1, o2);
		
		assertTrue(result > 0);
	}
	
	@Test
	void testT1AfterAndT2BeforeAtSecondWord() {
		Task o1 = new Task("project CS", "desc", TaskPriority.HIGH);
		Task o2 = new Task("Project Bio.", "desc", TaskPriority.LOW);
		DescendingNames order = new DescendingNames();
		
		int result = order.compare(o1, o2);
		
		assertTrue(result > 0);
	}
	
	@Test
	void testT1AndT2AreEqual() {
		Task o1 = new Task("Art", "desc", TaskPriority.HIGH);
		Task o2 = new Task("Art", "desc", TaskPriority.LOW);
		DescendingNames order = new DescendingNames();
		
		int result = order.compare(o1, o2);
		
		assertTrue(result == 0);
	}
	
	@Test
	void testT1BeforeAndT2After() {
		Task o1 = new Task("Art", "desc", TaskPriority.HIGH);
		Task o2 = new Task("dance practice", "desc", TaskPriority.LOW);
		DescendingNames order = new DescendingNames();
		
		int result = order.compare(o1, o2);
		
		assertTrue(result < 0);
	}
	
	@Test
	void testWhenT1IsNull() {
		Task o2 = new Task("Art", "desc", TaskPriority.LOW);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new DescendingNames().compare(null, o2);
		});
	}
	
	@Test
	void testWhenT2IsNull() {
		Task o2 = new Task("Art", "desc", TaskPriority.LOW);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new DescendingNames().compare(o2, null);
		});
	}

}
