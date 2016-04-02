package task;

/**
 * It simply stores data about tasks.
 *
 * @author Asuki
 *
 */
public class SimplyTask {

  /**
   * The name of the task.
   */
  private String taskName;
  /** Some information about the task. */
  private String comment;
  /** It is true when the task is finished, otherwise it is false. */
  private boolean isFinished;

  /**
   * @param newtaskName
   *          The name of the task.
   */
  public SimplyTask(final String newtaskName) {
    this.taskName = newtaskName;
    comment = "";
  }

  /**
   * @param newTaskName
   *          The name of the task.
   * @param newComment
   *          Some information about the task.
   */
  public SimplyTask(final String newTaskName, final String newComment) {
    this.taskName = newTaskName;
    this.comment = newComment;
  }

  /**
   * Sets the task's name.
   *
   * @param newTaskName
   *          The name of the task.
   */
  public final void setTaskName(final String newTaskName) {
    this.taskName = newTaskName;
  }

  /**
   * Gives the task's name.
   *
   * @return The name of the task.
   */
  public final String getTaskName() {
    return taskName;
  }

  /**
   * Sets the stored information about the task.
   *
   * @param newComment
   *          Some information abut the task.
   */
  public final void setComment(final String newComment) {
    this.comment = newComment;
  }

  /**
   * Gives the stored information about the task.
   *
   * @return The information abut the task.
   */
  public final String getComment() {
    return comment;
  }

  /**
   * Sets the task finished value.
   *
   * @param newFinishValue
   *          The new finished value of the task.
   */
  public final void setIsFinished(final boolean newFinishValue) {
    this.isFinished = newFinishValue;
  }

  /**
   * Gives information about task if it is finished.
   *
   * @return True if the task is finished and false otherwise
   */
  public final boolean getIsFinished() {
    return isFinished;
  }
}
