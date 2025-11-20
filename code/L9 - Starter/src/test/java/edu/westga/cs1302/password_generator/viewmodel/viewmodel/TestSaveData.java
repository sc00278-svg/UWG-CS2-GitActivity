package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestSaveData {

	@Test
	void testIfNull() {
		ViewModel vm = new ViewModel();
		boolean actual = vm.saveData(null);
		assertFalse(actual);
	}
	
	@Test
	void testWhenHasAFile() {
		
	}
	
	

}
