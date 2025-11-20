package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
	void testWhenHasAFile() throws IOException {
		ViewModel vm = new ViewModel();
		
		vm.generatePassword();
		File save = new File("save.txt");
		boolean actual = vm.saveData(save);
		
		try (Scanner reader = new Scanner(save)) {
			  assertTrue(actual);
		  }
		
	}
	
	

}
