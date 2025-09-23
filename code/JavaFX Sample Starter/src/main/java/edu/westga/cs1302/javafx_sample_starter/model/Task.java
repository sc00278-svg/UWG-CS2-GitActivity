package edu.westga.cs1302.javafx_sample_starter.model;

/**stores the name, description, and the priority of a task.
 *
 * @author samco
 * @version 1.0
 */
public class Task {
  
  private String description;
  private final String name;
  private final String priority;
  
  /**initializes the task name, description, and priority.
   *
   * @param name the name of the task
   * @param priority the priority of the task
   * @param descript the description of the task
   */
  public Task(String name, String priority, String descript) {
    if (name == null) {
      throw new IllegalArgumentException("name can not be null");
    }
    if (priority == null) {
      throw new IllegalArgumentException("name can not be null");
    }
    if (descript == null) {
      throw new IllegalArgumentException("name can not be null");
    }
    this.name = name;
    this.description = descript;
    this.priority = priority;
  }
  
  /**gets the name of a task.
   */
  public String getName() {
    return this.name;
  }
  
  /**gets the description of a task.
   */
  public String getDescription() {
    return this.description;
  }
  
  /**gets the priority of a task.
   */
  public String getPriority() {
    return this.priority;
  }
  
  /** To String method.
   */
  public String toString() {
    return "Task: " + this.name  + "\nPriority: " + this.priority + "\nDescription: "
        + this.description;
  }
}
