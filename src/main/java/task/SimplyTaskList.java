package task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * It creates a list about tasks and task priorities with priority categories.
 *
 * <pre>
 * SimplyTaskList usage example:
 *
 * public static void main(String[] args) {
 *  SimplyTaskList taskList = new SimplyTaskList("myTasks");
 *
 *  System.out.println("Number of tasks:" + taskList.size());
 *  System.out.println("#########################################");
 *  System.out.println("# Adding some task to the taskList      #");
 *  System.out.println("#########################################");
 *
 *  System.out.println("\nGetting information"
 *    + " about priority categories:");
 *  System.out.println(taskList.getCategoryInfo());
 *
 * </pre>
 *
 * At first we can fill in the task list using the
 * {@link SimplyTaskList#addTask(String, Integer, String, String)} method. It
 * automatically sorts the tasks.
 *
 * <pre>
 *
 * taskList.addTask(taskList.getPriorityCategories().getFirst(), 1,
 *    "An aimportant task             ", "JDI - Just Do It");
 * taskList.addTask("C", 1, "Finish housework", "");
 * taskList.addTask("C", 1, "Go to lunch", "");
 * taskList.addTask("A", 1, "This is a More important task", "Do it previous");
 * taskList.addTask("B", 1, "Writing a letter",
 *    "Asking information about logging, compiling and complexity");
 * taskList.addTask("A", 1, "This is the MOST important task",
 *    "Finish the documentation!!!");
 * taskList.addTask("A", 3, "Do something useful", "");
 *
 * System.out.println();
 * System.out.println("#########################################");
 * System.out.println("# Getting my (ordered) task             #");
 * System.out.println("#########################################");
 * System.out.println();
 *
 * System.out.println("P. category\tPriority\tTask name\t\t\t\tComment");
 *
 * for (int i = 0; i &lt; taskList.size(); i++) {
 *  System.out.print(taskList.getCategory(i) + "\t\t");
 *  System.out.print(taskList.getPriority(i) + "\t\t");
 *  System.out.print(taskList.getTaskName(i) + "\t\t");
 *  System.out.println(taskList.getTaskComment(i));
 * }
 *
 * </pre>
 *
 * When a task is ready, you can use the {@link SimplyTaskList#finishTask(int)}
 * method. It removes the task from the task list and reorder the tasks.
 *
 * <pre>
 *
 * System.out.println();
 * System.out.println("#########################################");
 * System.out.println("# Finishing tasks                       #");
 * System.out.println("#########################################");
 * System.out.println();
 *
 * System.out.println("Finishing the first task");
 * taskList.finishTask(0);
 *
 * System.out.println("P. category\tPriority\tTask name\t\t\t\tComment");
 * for (int i = 0; i &lt; taskList.size(); i++) {
 *  System.out.print(taskList.getCategory(i) + "\t\t");
 *  System.out.print(taskList.getPriority(i) + "\t\t");
 *  System.out.print(taskList.getTaskName(i) + "\t\t");
 *  System.out.println(taskList.getTaskComment(i));
 * }
 *
 * System.out.println("Finishing \"Do something useful\" task");
 * taskList.finishTask(1);
 *
 * System.out.println("P. category\tPriority\tTask name\t\t\t\tComment");
 * for (int i = 0; i &lt; taskList.size(); i++) {
 *  System.out.print(taskList.getCategory(i) + "\t\t");
 *  System.out.print(taskList.getPriority(i) + "\t\t");
 *  System.out.print(taskList.getTaskName(i) + "\t\t");
 *  System.out.println(taskList.getTaskComment(i));
 * }
 *
 * </pre>
 *
 * To modify a task just use the
 * {@link SimplyTaskList#setTask(int, String, int, String, String)} method. With
 * this you can modify the:
 * <ul>
 * <li>Task informations: task name, comment</li>
 * <li>Priority category</li>
 * <li>Priority</li>
 * </ul>
 *
 * <pre>
 *
 *  System.out.println();
 *  System.out.println("#########################################");
 *  System.out.println("# Modifying tasks                       #");
 *  System.out.println("#########################################");
 *  System.out.println();
 *
 *
 *  System.out.println("Modify information");
 *  taskList.setTask(0, "A", 1, "The MOST IMPORTANT        ",
 *    "At this time this is the most important task");
 *
 *  System.out.println("P. category\tPriority\tTask name\t\t\t\tComment");
 *  for (int i = 0; i &lt; taskList.size(); i++) {
 *    System.out.print(taskList.getCategory(i) + "\t\t");
 *    System.out.print(taskList.getPriority(i) + "\t\t");
 *    System.out.print(taskList.getTaskName(i) + "\t\t");
 *    System.out.println(taskList.getTaskComment(i));
 *  }
 *
 *
 *  System.out.println("Modify Priority and category");
 *  taskList.setTask(4, "A", 1, taskList.getTaskName(4),
 *    taskList.getTaskComment(4));
 *
 *  System.out.println("P. category\tPriority\tTask name\t\t\t\tComment");
 *  for (int i = 0; i &lt; taskList.size(); i++) {
 *    System.out.print(taskList.getCategory(i) + "\t\t");
 *    System.out.print(taskList.getPriority(i) + "\t\t");
 *    System.out.print(taskList.getTaskName(i) + "\t\t");
 *    System.out.println(taskList.getTaskComment(i));
 *  }
 * }
 * </pre>
 *
 * @author Asuki
 * @version 0.3
 *
 */
public class SimplyTaskList {
  /**
   * The name of the task list.
   */
  private String listName;
  /**
   * The list of the active tasks.
   */
  private LinkedList<SimplyTask> tasks;
  /**
   * The list of the finished tasks.
   */
  private LinkedList<SimplyTask> finishedTasks;
  /**
   * The list of the category of priorities. It must be sync with the task list
   * and priority list.
   */
  private LinkedList<String> priorCat;
  /**
   * The list of the category. It must be sync with the task list and the
   * priorCat list.
   */
  private LinkedList<Integer> priority;
  /**
   * List of the possible priorities.
   */
  private LinkedList<String> priorityCategories;
  /**
   * Contains information about categories.
   */
  private LinkedList<Integer> isUsedCat;
  /**
   * Stores information about the categories.
   */
  private String categoryInfo;
  /**
   * Using for logging.
   */
  private Logger logger;
  /**
   * File for save and load.
   */
  private String xmlFile;

  /**
   * @param newListName
   *          The name of the task list.
   */
  public SimplyTaskList(final String newListName) {
    this.listName = newListName;
    tasks = new LinkedList<SimplyTask>();
    finishedTasks = new LinkedList<SimplyTask>();
    priorCat = new LinkedList<String>();
    priority = new LinkedList<Integer>();

    // Adding category elements.
    priorityCategories = new LinkedList<String>();
    priorityCategories.add("A");
    priorityCategories.add("B");
    priorityCategories.add("C");
    priorityCategories.add("D");
    categoryInfo = "A - Mindenképp fontos,"
        + " elvégzendő feladat rövid időn belül"
        + " | B - Olyan feladat ami hosszabb távú"
        + " | C - Nem fontos feladat | " + "D - Delegálandó feladat: "
        + "Amit más is el tud végezni, azt delegálni kell";

    isUsedCat = new LinkedList<Integer>();
    for (int i = 0; i < priorityCategories.size(); i++) {
      isUsedCat.add(0);
    }
    xmlFile = "taskList.xml";
    logger = Logger.getLogger(SimplyTaskList.class.getName());
  }

  /**
   * Removes the given name!'s task, puts in the finished task list and reorder
   * the elements after the element in the same category.
   *
   * SimplyTaskList
   *
   * @param taskIndex
   *          The index of the task what we want to finish.
   * @return true if the remove was successful and the active list had contained
   *         the task. Return false otherwise.
   */
  public final boolean finishTask(final int taskIndex) {
    logger.entering("SimplyTaskList", "finishTask", new Object[] {taskIndex});
    // tasks.get(taskIndex).setFinished(true);
    // return true;
    if (taskIndex >= 0 && taskIndex < tasks.size()) {
      String catTmp = this.priorCat.get(taskIndex);
      Integer priorTmp = this.priority.get(taskIndex);
      finishedTasks.add(tasks.get(taskIndex));
      tasks.remove(tasks.get(taskIndex));
      priorCat.remove(priorCat.get(taskIndex));
      priority.remove(taskIndex);
      reorderTasksAfterRemove(catTmp, priorTmp);
      logger.info("Task with then taskIndex: " + taskIndex + " was succesful.");
      logger.exiting("SimplyTaskList", "finishTask", true);
      return true;
    } else {
      logger.warning("Finishing task failed");
      logger.exiting("SimplyTaskList", "finishTask", false);
      return false;
    }
  }

  /**
   * Adds the index of the task in the active task list.
   *
   * Usage example:
   *
   * <pre>
   *
   * SimplyTaskList getInfo = new SimplyTaskList("getTask");
   * for (int i = 0; i &lt; 6; i++) {
   *   getInfo.addTask("A", i + 1, "taskName" + i, "");
   * }
   * System.out.println(getInfo.getTaskIndex("taskName2"));
   *
   * </pre>
   *
   * Output: 2
   *
   * @param searchTaskName
   *          The name what's index we search for.
   * @return the index of the task if it is in the active task list and -1
   *         otherwise.
   */
  public final int getTaskIndex(final String searchTaskName) {
    logger.entering("SimplyTaskList", "getTaskIndex",
        new Object[] {searchTaskName});
    for (int result = 0; result < tasks.size(); result++) {
      if (searchTaskName.equals(this.tasks.get(result).getTaskName())) {
        logger.info("Task index found: " + result);
        logger.exiting("SimplyTaskList", "getTaskIndex", result);
        return result;
      }
    }
    logger.info("Task index did not find.");
    logger.exiting("SimplyTaskList", "getTaskIndex", -1);
    return -1;
  }

  /**
   * Reorder the active task list's priority. It can use after remove an
   * element.
   *
   * @param newPriorCat
   *          The category of the removed element's priority.
   * @param newPriority
   *          The removed element's priority.
   */
  protected final void reorderTasksAfterRemove(final String newPriorCat,
      final Integer newPriority) {
    logger.entering("SimplyTaskList", "reorderTasksAfterRemove",
        new Object[] {priorCat, priority});
    for (int i = 0; i < this.priority.size(); i++) {
      Integer value = this.priority.get(i);
      if (value > newPriority && priorCat.equals(this.priorCat.get(i))) {
        this.priority.set(i, value - 1);
      }
    }
    logger.info("Priorities was added successful");
    logger.exiting("SimplyTaskList", "reorderTasksAfterRemove");
  }

  /**
   * Gives the last priority value of the given priority category.
   *
   * Usage example:
   *
   * <pre>
   *
   * SimplyTaskList getInfo = new SimplyTaskList("getTask");
   * for (int i = 0; i &lt; 6; i++) {
   *   getInfo.addTask("A", i + 1, "taskName" + i, "");
   * }
   * System.out.println(getInfo.getLastIndexOfCategory("A"));
   * System.out.println(getInfo.getLastIndexOfCategory("B"));
   *
   * </pre>
   *
   * Outputs: 5 -1
   *
   * @param sPriorCat
   *          The priority category what we want to find the last priority.
   * @return The last element of the priority category.
   */
  public final int getLastPriorityInCategory(final String sPriorCat) {
    logger.entering("SimplyTaskList", "getLastPriorityInCategory",
        new Object[] {priorCat});
    int max = 0;
    int priorTmp;
    for (int i = 0; i < this.priorCat.size(); i++) {
      if (sPriorCat.equals(this.priorCat.get(i))) {
        priorTmp = priority.get(i);
        if (max < priorTmp) {
          max = priorTmp;
        }
      }
    }
    logger.info("The category (" + priorCat + "found: " + max);
    logger.exiting("SimplyTaskList", "getLastPriorityInCategory", max);
    return max;
  }

  /**
   * Checks if the task is finished.
   *
   * @param taskName
   *          The name of the task what we want to check if it is finished.
   * @return true if the task is finished and false otherwise.
   */
  public final boolean isFinished(final String taskName) {
    logger.entering("SimplyTaskList", "isFinished", new Object[] {taskName});
    for (SimplyTask task : finishedTasks) {
      if (taskName.equals(task.getTaskName())) {
        logger.info("The task is finished: " + taskName);
        logger.exiting("SimplyTaskList", "isFinished", true);
        return true;
      }
    }
    logger.info("The task is not finished: " + taskName);
    logger.exiting("SimplyTaskList", "isFinished", false);
    return false;
  }

  /**
   * Removes the element of the finished list.
   */
  public final void clearFinished() {
    finishedTasks.clear();
  }

  /**
   * It gives the names of the finished tasks.
   *
   * Usage example:
   *
   * <pre>
   *
   * SimplyTaskList getInfo = new SimplyTaskList("getTask");
   * for (int i = 0; i &lt; 6; i++) {
   *   getInfo.addTask("A", i + 1, "taskName" + i, "");
   * }
   *
   * getInfo.finishTask(2);
   * getInfo.finishTask(4);
   * getInfo.finishTask(0);
   *
   * for (String tasks : getInfo.getFinishedTaskNames()) {
   *   System.out.println(tasks);
   * }
   *
   * </pre>
   *
   * Outputs: taskName2 taskName5 taskName0
   *
   * @return the name of the tasks
   */
  public final LinkedList<String> getFinishedTaskNames() {
    logger.entering("SimplyTaskList", "getFinishedTaskNames");
    LinkedList<String> result = new LinkedList<String>();
    String loggerString = "";
    for (SimplyTask task : finishedTasks) {
      result.add(task.getTaskName());
      loggerString += task.getTaskName() + " ";
    }
    logger.info("Task names collected");
    logger.exiting("SimplyTaskList", "getFinishedTaskNames", loggerString);
    return result;
  }

  /**
   * Ads a new task into the list. The method orders by categories and
   * priorities.
   *
   * <p>
   * You can read examples here: {@link task.SimplyTaskList}
   *
   * @param pcat
   *          The priority category of the task.
   * @param prior
   *          The priority of the task.
   * @param task
   *          The name of the task.
   * @param comment
   *          Some information about the task.
   * @return true if adding was successful and false otherwise
   */
  public final boolean addTask(final String pcat, final Integer prior,
      final String task, final String comment) {
    // Adding successful - There is task with the same name
    if (getTaskIndex(task) == -1) {
      if (!isUsedCategory(pcat)) {
        if (tasks.size() == 0) { // Adding the first item
          tasks.add(new SimplyTask(task, comment));
          this.priority.add(prior);
          this.priorCat.add(pcat);
        } else {
          // Getting the previous category
          int index = getPrevCatIndex(pcat);
          if (index == -1) {
            index = 0;
          }
          // Getting the previous category's last index
          index = getLastIndexOfCategory(priorityCategories.get(index));
          if (index == -1) {
            index = 0;
          }
          // Inserting the element
          index++;
          tasks.add(index, new SimplyTask(task, comment));
          priority.add(index, prior);
          priorCat.add(index, pcat);
        }
        isUsedCat.set(priorityCategories.indexOf(pcat), 1);
      } else {
        // Inserting the item
        int firstTaskIndex = getFirstIndexOfCategory(pcat);
        int lastTaskIndex = getLastIndexOfCategory(pcat);
        int inc = -1;
        boolean inserted = false;
        int tmp;
        // Searching the task's place
        for (int i = firstTaskIndex; i <= lastTaskIndex; i++) {
          tmp = priority.get(i);
          if (prior < tmp) {
            tasks.add(i, new SimplyTask(task, comment));
            priority.add(i, prior);
            priorCat.add(i, pcat);
            inserted = true;
            break;
          }
          if (prior == tmp) {
            tasks.add(i, new SimplyTask(task, comment));
            priority.add(i, prior);
            priorCat.add(i, pcat);
            inserted = true;
            inc = i + 1;
            break;
          }
        }
        lastTaskIndex++;
        // If there are tasks after the new task, than we increase them
        // priorities
        if (inc > -1) {
          for (int i = inc; i <= lastTaskIndex; i++) {
            priority.set(i, priority.get(i) + 1);
          }
        }
        if (!inserted) {
          tasks.add(lastTaskIndex, new SimplyTask(task, comment));
          priority.add(lastTaskIndex, prior);
          priorCat.add(lastTaskIndex, pcat);
        }
      }
      return true;
    } else { // Adding failed - The task name is already exists
      return false;
    }
  }
  
  
  /**
   * Gives the index of the previous category from the priorityCategories list.
   *
   * Usage example:
   *
   * <pre>
   *
   * SimplyTaskList getInfo = new SimplyTaskList("getTask");
   * for (int i = 0; i &lt; 6; i++) {
   *   getInfo.addTask("A", i + 1, "taskName" + i, "");
   * }
   * System.out.print(getInfo.getPrevCatIndex("A"));
   * getInfo.addTask("C", 1, "C task", "comment");
   * System.out.print(getInfo.getPrevCatIndex("C"));
   *
   * </pre>
   *
   * Output: -1 2
   *
   * @param cat
   *          The category what's ancestor we search.
   * @return The index of the previous category and -1 if does not have previous
   *         category
   */
  public final Integer getPrevCatIndex(final String cat) {
    logger.entering("SimplyTaskList", "getPrevCatIndex", new Object[] {cat});
    Integer catIndex = priorityCategories.indexOf(cat);
    Integer result = -1;
    for (int i = 0; i < isUsedCat.size() && catIndex != i; i++) {
      if (isUsedCat.get(i) != 0 && i < catIndex) {
        result = i;
      }
    }
    logger.exiting("SimplyTaskList", "getPrevCatIndex", result);
    return result;
  }

  /**
   * Gives the index of the next category used from the possible category list.
   *
   * Usage example:
   *
   * <pre>
   *
   * SimplyTaskList getInfo = new SimplyTaskList("getTask");
   * for (int i = 0; i &lt; 6; i++) {
   *   getInfo.addTask("A", i + 1, "taskName" + i, "");
   * }
   * System.out.print(getInfo.getNextCatIndex("A"));
   * getInfo.addTask("C", 1, "C task", "comment");
   * System.out.print(getInfo.getNextCatIndex("A"));
   *
   * </pre>
   *
   * Output: -1 2
   *
   * @param cat
   *          The category what's next we search.
   * @return The index of the next category and -1 otherwise.
   */
  public final int getNextCatIndex(final String cat) {
    logger.entering("SimplyTaskList", "getNextCatIndex", new Object[] {cat});
    int catIndex = priorityCategories.indexOf(cat);
    int result = -1;
    int max = isUsedCat.size() - 1;
    for (int i = max; i >= 0 && catIndex != i; i--) {
      if (isUsedCat.get(i) != 0 && i > catIndex) {
        result = i;
      }
    }
    logger.exiting("SimplyTaskList", "getNextCatIndex", result);
    return result;
  }

  /**
   * Gives the category usage.
   *
   * @param cat
   *          The category what we want to check.
   * @return True if the category is used, false otherwise.
   */
  private boolean isUsedCategory(final String cat) {
    return isUsedCat.get(priorityCategories.indexOf(cat)) != 0;
  }

  /**
   * Gives the first index of the category.
   *
   * @param category
   *          The category what's first index we search.
   * @return The first index of the category. If there is now such a category it
   *         returns with -1.
   */
  public final int getFirstIndexOfCategory(final String category) {
    logger.entering("SimplyTaskList", "getFirstIndexOfCategory",
        new Object[] {category});
    for (int i = 0; i < priorCat.size(); i++) {
      // If the category equals we find the first index
      if (category.equals(priorCat.get(i))) {
        logger.info("The first index was found");
        logger.exiting("SimplyTaskList", "getFirstIndexOfCategory", i);
        return i;
      }
    }
    logger.info("The category does not exist");
    logger.exiting("SimplyTaskList", "getFirstIndexOfCategory", -1);
    return -1;
  }

  /**
   * Gives the last index of the category.
   *
   * @param category
   *          The category what's last index we search.
   * @return The last index of the category. If there is now such a category it
   *         returns with -1.
   */
  public final int getLastIndexOfCategory(final String category) {
    logger.entering("SimplyTaskList", "getLastIndexOfCategory",
        new Object[] {category});
    int result = -1;
    for (int i = 0; i < priorCat.size(); i++) {
      if (category.equals(priorCat.get(i))) {
        logger.info("The first index was found");
        logger.exiting("SimplyTaskList", "getLastIndexOfCategory", i);
        result = i;
      }
    }
    logger.info("The category does not exist");
    logger.exiting("SimplyTaskList", "getLastIndexOfCategory", -1);
    return result;
  }

  /**
   * Gives the list of the tasks.
   *
   * @return The task list.
   */
  public final LinkedList<SimplyTask> getTasks() {
    return tasks;
  }

  /**
   * Gives the list of possible priority categories.
   *
   * @return The possible priority categories.
   */
  public final LinkedList<String> getPriorityCategories() {
    return priorityCategories;
  }

  /**
   * Gives the name of the task list.
   *
   * @return The name of the task list.
   */
  public final String getListName() {
    return listName;
  }

  /**
   * Sets the name of the task list.
   *
   * @param newListName
   *          The new name of the task list.
   */
  public final void setListName(final String newListName) {
    this.listName = newListName;
  }

  /**
   * Gives the name of a task.
   *
   * @param taskIndex
   *          The index what's name we want to know.
   * @return the name of the task in the index.
   */
  public final String getTaskName(final Integer taskIndex) {
    return tasks.get(taskIndex).getTaskName();
  }

  /**
   * Gives the category of the task.
   *
   * @param taskIndex
   *          The index of the task what's category we search.
   * @return The priority category of the task.
   */
  public final String getTaskCategory(final Integer taskIndex) {
    return priorCat.get(taskIndex);
  }

  /**
   * Checks if the task is finished.
   *
   * @param taskIndex
   *          The index of the task what we want to check if it is finished.
   * @return true if the task finished and false otherwise.
   */
  public final boolean getIsFinished(final Integer taskIndex) {
    return tasks.get(taskIndex).getIsFinished();
  }

  /**
   * Gives some information about the task.
   *
   * @param taskIndex
   *          The index of the task what from we want to know some information.
   * @return Some information about the task.
   */
  public final String getTaskComment(final Integer taskIndex) {
    return tasks.get(taskIndex).getComment();
  }

  /**
   * Gives information about the possible categories.
   *
   * @return information about the categories.
   */
  public final String getCategoryInfo() {
    return categoryInfo;
  }

  /**
   * Gives the priority category of the task.
   *
   * @param taskIndex
   *          The index of the task what's category we search.
   * @return The priority category of the task.
   */
  public final String getCategory(final Integer taskIndex) {
    return priorCat.get(taskIndex);
  }

  /**
   * Gives the priority of the task.
   *
   * @param taskIndex
   *          The index of the task what's priority we search.
   * @return The priority priority of the task.
   */
  public final int getPriority(final Integer taskIndex) {
    return priority.get(taskIndex);
  }

  /**
   * Gives the number of the tasks.
   *
   * @return The number of the tasks.
   */
  public final int size() {
    return tasks.size();
  }

  /**
   * Modify a task with the given information.
   *
   * <p>
   * You can read examples here: {@link task.SimplyTaskList}
   *
   * @param taskIndex
   *          The index of the task what we want to modify.
   * @param pcat
   *          The new priority category.
   * @param prior
   *          The new priority.
   * @param newTaskName
   *          The new name of the task.
   * @param newComment
   *          The modified comment.
   * @return True if the the modify was successful, false otherwise.
   */
  public final boolean setTask(final int taskIndex, final String pcat,
      final int prior, final String newTaskName, final String newComment) {
    logger.entering("SimplyTaskList", "setTask",
        new Object[] {taskIndex, pcat, prior, newTaskName, newComment});
    // If the new task name not exist or equals with the old task name.
    if (-1 == getTaskIndex(newTaskName)
        || newTaskName.equals(this.getTaskName(taskIndex))) {
      finishTask(taskIndex);
      tasks.size();
      addTask(pcat, prior, newTaskName, newComment);
      logger.fine("The task modified successfully");
      logger.exiting("SimplyTaskList", "setTask", false);
      return true;
    }
    logger.warning(
        "The task name is already exists. " + "The task name must be unique");
    logger.exiting("SimplyTaskList", "setTask", false);
    return false;
  }

  /**
   * Saves the current task list into an XML file.
   */
  public final void writeXmlFile() {
    try {
      logger.entering("SimplyTaskList", "writeXmlFile");
      DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
      DocumentBuilder build = dFact.newDocumentBuilder();
      Document doc = build.newDocument();

      // Creating the root element: TaskList
      Element root = doc.createElement("TaskList");
      doc.appendChild(root);

      logger.info("Saving task list");
      // Creating the XML tree
      for (int i = 0; i < tasks.size(); i++) {
        // Store every element into a Task element
        Element task = doc.createElement("Task");
        root.appendChild(task);

        Element pCat = doc.createElement("PriorCat");
        task.appendChild(pCat);
        pCat.appendChild(doc.createTextNode(this.priorCat.get(i)));

        Element prior = doc.createElement("Priority");
        task.appendChild(prior);
        prior.appendChild(doc.createTextNode(priority.get(i).toString()));

        Element taskName = doc.createElement("TaskName");
        task.appendChild(taskName);
        taskName.appendChild(doc.createTextNode(tasks.get(i).getTaskName()));

        Element taskComment = doc.createElement("TaskComment");
        task.appendChild(taskComment);
        taskComment.appendChild(doc.createTextNode(tasks.get(i).getComment()));

      }

      // Save the document to the disk file
      TransformerFactory tranFactory = TransformerFactory.newInstance();
      Transformer aTransformer = tranFactory.newTransformer();

      // Format the XML nicely
      aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

      aTransformer
          .setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
      aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

      DOMSource source = new DOMSource(doc);
      try {
        // Saving XML
        FileWriter fos = new FileWriter("taskList.xml");
        StreamResult result = new StreamResult(fos);
        aTransformer.transform(source, result);

      } catch (IOException e) {

        e.printStackTrace();
      }
      logger.fine("Saving was successful");

    } catch (TransformerException ex) {
      System.out.println("Error outputting document");

    } catch (ParserConfigurationException ex) {
      System.out.println("Error building document");
    }
    logger.exiting("SimplyTaskList", "writeXmlFile");
  }

  /**
   * Load the last save task list into the task list.
   */
  public final void loadXML() {
    try {
      logger.entering("SimplyTaskList", "loadXML");
      File fXmlFile = new File(xmlFile);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(fXmlFile);

      doc.getDocumentElement().normalize();

      NodeList nList = doc.getElementsByTagName("Task");

      logger.info("Loading tasks from xml");
      for (int temp = 0; temp < nList.getLength(); temp++) {

        Node nNode = nList.item(temp);

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;
          String pcat = eElement.getElementsByTagName("PriorCat").item(0)
              .getTextContent();
          int prior = Integer.parseInt(eElement.getElementsByTagName("Priority")
              .item(0).getTextContent());
          String taskName = eElement.getElementsByTagName("TaskName").item(0)
              .getTextContent();
          String comment = eElement.getElementsByTagName("TaskComment").item(0)
              .getTextContent();
          addTask(pcat, prior, taskName, comment);
        }
      }
      logger.fine("Load was successful");
    } catch (Exception e) {
      e.printStackTrace();
    }
    logger.exiting("SimplyTaskList", "loadXML");
  }
}
