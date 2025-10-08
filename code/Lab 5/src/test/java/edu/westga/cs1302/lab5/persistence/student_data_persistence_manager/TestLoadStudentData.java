package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestLoadStudentData {

	@Test
	void testWhenOnlyOneStudent() throws IOException {
		Student[] students = new Student[1];
		Student s1 = new Student("Bob", 50);
		students[0] = s1;
		StudentDataPersistenceManager.saveStudentData(students, "test-data.txt");
		
		Student[] actual = StudentDataPersistenceManager.loadStudentData("test-data.txt");
		String name = actual[0].getName();
		int grade = actual[0].getGrade();
		
		assertEquals(s1.getName(), name, "checks to see if the actual array matches what is expected.");
		assertEquals(s1.getGrade(), grade, "checks to see if the actual array matches what is expected.");
	}
	
	@Test
	void testWhenMultipleSutdents() throws IOException{
		Student[] students = new Student[2];
		Student s1 = new Student("Bob", 50);
		students[0] = s1;
		Student s2 = new Student("Jannet", 89);
		students[1] = s2;
		StudentDataPersistenceManager.saveStudentData(students, "test-data.txt");
		
		Student[] actual = StudentDataPersistenceManager.loadStudentData("test-data.txt");
		String name1 = actual[0].getName();
		int grade1 = actual[0].getGrade();
		String name2 = actual[1].getName();
		int grade2 = actual[1].getGrade();
		
		assertEquals(s1.getName(), name1, "checks to see if the actual array matches what is expected.");
		assertEquals(s1.getGrade(), grade1, "checks to see if the actual array matches what is expected.");
		assertEquals(s2.getName(), name2, "checks to see if the actual array matches what is expected.");
		assertEquals(s2.getGrade(), grade2, "checks to see if the actual array matches what is expected.");
	}
	
	@Test
	void testWhenNameDoesnotHaveAGrade() {
		
	}
	
	@Test
	void testWhenThereAreNoStudents() {
		
	}
}
