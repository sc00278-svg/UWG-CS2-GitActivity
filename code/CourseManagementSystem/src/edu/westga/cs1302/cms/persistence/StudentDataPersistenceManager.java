package edu.westga.cs1302.cms.persistence;

import edu.westga.cs1302.cms.model.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/** Suppports saving and loading student data.
 *
 * @author CS 1302
 * @version Fall 2025
 */
public class StudentDataPersistenceManager {

  /** Save the students!.
   *
   * @precondition students != null
   * @postcondition none
   * 
   * @param students the set of students to save
   * @throws IO exception when unable to write to default file location
   */
  public static void saveStudentData(Student[] students) throws IOException {
    FileWriter writer = new FileWriter("names. txt");

    for (Student currStudent : students) {
      writer.write(currStudent.getName() + System.lineSeparator());
      writer.write(currStudent.getGrade());
      writer.write(System.lineSeparator());
    }

    writer.close();
  }

  /** Load the students!.
   *
   * @precondition none
   * @postcondition none
   * 
   * @return the set of students loaded
   * @throws IOException unable to find default file
   * @throws NumberFormatException file was not properly formatted, failed while loading grade value
   * @throws NoSuchElementException file not formatted properly, failed to read line when trying to read a grade value.
   */
  public static Student[] loadStudentData() throws IOException, NumberFormatException, NoSuchElementException {
    ArrayList<Student> students = new ArrayList<Student>();
    File inputFile = new File("names.txt");
    // makes sure that the scanner is closed no matter what happens in the try block
    try (Scanner reader = new Scanner(inputFile)) {
      while (reader.hasNextLine()) {
        String name = reader.nextLine();
        int grade = Integer.parseInt(reader.nextLine());
        Student nextStudent = new Student(name, grade);
        students.add(nextStudent);
      }
    }
    
    return (Student[]) students.toArray();
  }

}
