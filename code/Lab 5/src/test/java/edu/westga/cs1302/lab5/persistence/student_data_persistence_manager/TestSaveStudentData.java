package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;


class TestSaveStudentData {

	@Test
	void testNoArray() throws IOException {
		assertThrows(IllegalArgumentException.class, () -> {   
			StudentDataPersistenceManager.saveStudentData(null, "test-data.txt");
		});
	}
	
	@Test
	void testNoStudents() throws IllegalArgumentException, IOException {
		StudentDataPersistenceManager.saveStudentData(new Student[0], "test-data.txt");

		File inputFile = new File("test-data.txt");
		try (Scanner reader = new Scanner(inputFile)) {
			assertFalse(reader.hasNextLine(), "checking if file is empty (should have no lines)");
		}
	}
	
	@Test
	void testWhenThereIsAValidStudent() throws IOException{
		Student[] students = new Student[1];
		Student s1 = new Student("Bob", 50);
		students[0] = s1;
		StudentDataPersistenceManager.saveStudentData(students, "test-data.txt");
		
		File inputFile = new File("test-data.txt");
		Scanner reader = new Scanner(inputFile);
		String firstLine = reader.nextLine();
		reader.close();
		
		assertEquals("Bob,50" + System.lineSeparator(), firstLine + System.lineSeparator(), "asserts that the text and format of the file matches what is expected");
	}
	
	@Test
	void testMultipleValidStudents() throws IOException {
		Student[] students = new Student[3];
		Student s1 = new Student("Bob", 50);
		students[0] = s1;
		Student s2 = new Student("Lily", 67);
		students[1] = s2;
		Student s3 = new Student("Andy", 80);
		students[2] = s3;
		StudentDataPersistenceManager.saveStudentData(students, "test-data.txt");
		
		File inputFile = new File("test-data.txt");
		Scanner reader = new Scanner(inputFile);
		String firstLine = reader.nextLine();
		String secondLine = reader.nextLine();
		String thirdLine = reader.nextLine();
		reader.close();
		
		assertEquals("Bob,50"+ System.lineSeparator() + "Lily,67" + System.lineSeparator() + "Andy,80" + System.lineSeparator(),
				firstLine + System.lineSeparator() + secondLine + System.lineSeparator() + thirdLine + System.lineSeparator(),
				"asserts that the text file has the expected text in the expected format.");
	}
	
	@Test
	void testWhenArrayHasANullStudentInTheMiddle() throws IOException {
		Student[] students = new Student[3];
		Student s1 = new Student("Bob", 50);
		students[0] = s1;
		Student s2 = new Student("lily", 67);
		students[2] = s2;
		StudentDataPersistenceManager.saveStudentData(students, "test-data.txt");

		File inputFile = new File("test-data.txt");
		Scanner reader = new Scanner(inputFile);
		String firstLine = reader.nextLine();
		String secondLine = reader.nextLine();
		reader.close();
		
		assertEquals("Bob,50"+ System.lineSeparator() + "Lily,67" + System.lineSeparator(),
				firstLine + System.lineSeparator() + secondLine + System.lineSeparator(),
				"asserts that the text file has the expected text in the expected format.");
	}
	
	@Test
	void testWhenArrayHasANullStudentAtTheEnd() throws IOException {
		Student[] students = new Student[3];
		Student s1 = new Student("Bob", 50);
		students[0] = s1;
		Student s2 = new Student("lily", 67);
		students[1] = s2;
		StudentDataPersistenceManager.saveStudentData(students, "test-data.txt");

		File inputFile = new File("test-data.txt");
		Scanner reader = new Scanner(inputFile);
		String firstLine = reader.nextLine();
		String secondLine = reader.nextLine();
		reader.close();
		
		assertEquals("Bob,50"+ System.lineSeparator() + "Lily,67" + System.lineSeparator(),
				firstLine + System.lineSeparator() + secondLine + System.lineSeparator(),
				"asserts that the text file has the expected text in the expected format.");
	}
	
	@Test
	void testWhenArrayHasANullStudentAtTheBeginning() throws IOException {
		Student[] students = new Student[3];
		Student s1 = new Student("Bob", 50);
		students[1] = s1;
		Student s2 = new Student("lily", 67);
		students[2] = s2;
		StudentDataPersistenceManager.saveStudentData(students, "test-data.txt");

		File inputFile = new File("test-data.txt");
		Scanner reader = new Scanner(inputFile);
		String firstLine = reader.nextLine();
		String secondLine = reader.nextLine();
		reader.close();
		
		assertEquals("Bob,50"+ System.lineSeparator() + "Lily,67" + System.lineSeparator(),
				firstLine + System.lineSeparator() + secondLine + System.lineSeparator(),
				"asserts that the text file has the expected text in the expected format.");
	}
	
}
