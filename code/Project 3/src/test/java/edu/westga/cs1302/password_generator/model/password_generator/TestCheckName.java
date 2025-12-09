package edu.westga.cs1302.password_generator.model.password_generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.Comic;

class TestCheckName {

	@Test
	void testMultipleWords() {
		Comic comic = new Comic("name", 12);
		String name = "The Amazing SpiderMan";
		
		assertTrue(comic.checkName(name));
	}
	
	@Test
	void testWhenOneWord() {
		Comic comic = new Comic("name", 12);
		String name = "Batman";
		
		assertTrue(comic.checkName(name));
	}
	
	@Test
	void testWhenNotValidWord() {
		Comic comic = new Comic("name", 12);
		String name = "Batman!";
		
		assertFalse(comic.checkName(name));
	}
	
	@Test
	void testWhenNull() {
		Comic comic = new Comic("name", 12);
		String name = null;
		
		assertFalse(comic.checkName(name));
	}

}
