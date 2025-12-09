package edu.westga.cs1302.password_generator.model.password_generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.Comic;

class TestCheckIssueNumber {

	@Test
	void test() {
		String num = "2345";
		Comic comic = new Comic("name", 1334);
		
		assertTrue(comic.checkIssueNumber(num));
	}
	
	@Test
	void testWhenOneDigit() {
		String num = "2";
		Comic comic = new Comic("name", 1334);
		
		assertTrue(comic.checkIssueNumber(num));
	}
	
	@Test
	void testWhen0AtFront() {
		String num = "02345";
		Comic comic = new Comic("name", 1334);
		
		assertTrue(comic.checkIssueNumber(num));
	}
	
	@Test
	void testWhenNumIsZero() {
		String num = "0";
		Comic comic = new Comic("name", 1334);
		
		assertTrue(!comic.checkIssueNumber(num));
	}
	
	@Test
	void testWhenNull() {
		String num = null;
		Comic comic = new Comic("name", 1334);
		
		assertFalse(comic.checkIssueNumber(num));
	}

}
