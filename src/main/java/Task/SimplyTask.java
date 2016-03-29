package Task;

/**
 * It simply stores data about tasks.
 * 
 * @author Asuki
 *
 */
public class SimplyTask {

	/** The name of the task.*/
	String taskName;
	/**Some information about the task.*/
	String comment;
	/**It is true when the task is finished, otherwise it is false.*/
	boolean isFinished;
	

	/**
	 * @param taskName The name of the task.
	 */
	public SimplyTask(String taskName)
	{
		this.taskName = taskName;
		comment = "";
	}
	
	/**
	 * @param taskName The name of the task.
	 * 
	 * @param comment Some information about the task.
	 */
	public SimplyTask(String taskName, String comment)
	{
		this.taskName = taskName;
		this.comment = comment;
	}
	
	/**
	 * Sets the task's name.
	 * 
	 * @param taskName The name of the task.
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * Gives the task's name.
	 * 
	 * @return The name of the task.
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * Sets the stored information about the task.
	 * 
	 * @param comment Some information abut the task.
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * Gives the stored information about the task.
	 * 
	 * @return The information abut the task.
	 */
	public String getComment() {
		return comment;
	}
	
	/**
	 * Sets the task finished value.
	 * 
	 * @param isFinished The new finished value of the task.
	 */
	public void setIsFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	
	/**
	 * Gives information about task if it is finished.
	 * 
	 * @return True if the task is finished and false otherwise
	 */
	public boolean getIsFinished() {
		return isFinished;
	}
}
