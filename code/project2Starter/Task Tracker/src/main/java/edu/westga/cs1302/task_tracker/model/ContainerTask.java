package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;

/** makes a container Task.
 * 
 * @author samco
 * @version 1
 */
public class ContainerTask extends Task {
	
	private ArrayList<Task> subTasks;
	
	/**creates a new Container Task
	 * 
	 * @param name the name of the task
	 * @param description the description
	 * @param priority the priority
	 * @param subList the list of subtasks
	 */
	public ContainerTask(String name, String description, TaskPriority priority, ArrayList<Task> subList) {
		super(name, description, priority);
		this.subTasks = new ArrayList<Task>();
		subList = this.subTasks;
	}

	@Override
	public ArrayList<Task> getSubtasks() {
		return this.subTasks;
		
	}
	
	@Override
	public ContainerTask addTask(Task task) {
		// add the list of subTasks to this
		if (task != null) {
			ContainerTask container = this;
			this.subTasks.add(task);
			return container;
		} else {
			throw new IllegalArgumentException("either no task selected or no task to add");
		}
	}
	
	@Override
	public String toString() {
		return this.getName() + "(+)";
	}
}
