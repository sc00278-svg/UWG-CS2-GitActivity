package edu.westga.cs1302.cms.test.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import edu.westga.cs1302.cms.model.Student;
import edu.westga.cs1302.cms.persistence.StudentDataPersistenceManager;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;



class TestSaveStudentData {

	@Test
	void test() {
		fail("Not yet implemented");
	}

  @Test
  void testNoStudents() throws IllegalArgumentException, IOException {
	  StudentDataPersistenceManager.saveStudentData(new Student[0], "test-data.txt");
	  
	  File inputFile = new File("test-data.txt");
	  try (Scanner reader = new Scanner(inputFile)) {
		  assertFalse(reader.hasNextLine(), "checking if file is empty (should have no lines)");
	  }
  }
}
