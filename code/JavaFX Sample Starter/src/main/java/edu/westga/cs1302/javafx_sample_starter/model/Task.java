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
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("name can not be null or empty");
    }
    if (priority == null || priority.isEmpty()) {
      throw new IllegalArgumentException("name can not be null or empty");
    }
    if (descript == null || descript.isEmpty()) {
      throw new IllegalArgumentException("name can not be null or empty");
    }
    this.name = name;
    this.description = descript;
    this.priority = priority;
  }
  
  /** Updates the description of a task.
   *
   * @param newDescription the new description of the task
   * @return update description
   */
  public String updateDescription(String newDescription) {
    if (newDescription == null || newDescription.isEmpty()) {
      throw new IllegalArgumentException("description can not be null");
    }
    this.description = newDescription;
    return this.description;
  }
  
  /**gets the name of a task.
   * 
   * @return name the name of the task
   */
  public String getName() {
    return this.name;
  }
  
  /**gets the description of a task.
   * 
   * @return description the description of the task
   */
  public String getDescription() {
    return this.description;
  }
  
  /**gets the priority of a task.
   * 
   * @return priority the priority of the task
   */
  public String getPriority() {
    return this.priority;
  }
  
  /** To String method.
   * 
   * @return the name of the task
   */
  public String toString() {
    return this.name;
  }
}
