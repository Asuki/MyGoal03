package MyGoal;

import Task.SimplyTaskList;

public class Example {

	public static void main(String[] args) {
		SimplyTaskList taskList = new SimplyTaskList("myTasks");
		System.out.println("Number of tasks:" + taskList.size());
		System.out.println("##################################################");
		System.out.println("# Adding some task to the taskList               #");
		System.out.println("##################################################");
		System.out.println("\nGetting information about priority categories:");
		System.out.println(taskList.getCategoryInfo());
		taskList.addTask(taskList.getPriorityCategories().getFirst(), 1, "An aimportant task             ", "JDI - Just Do It");
		taskList.addTask("C", 1, "Finish housework", "");
		taskList.addTask("C", 1, "Go to lunch", "");
		taskList.addTask("A", 1, "This is a More important task", "Do it previous");
		taskList.addTask("B", 1, "Writing a letter", "Asking information about logging, compiling and complexity");
		taskList.addTask("A", 1, "This is the MOST important task", "Finish the documentation!!!");
		taskList.addTask("A", 3, "Do something useful", "");
		System.out.println();
		System.out.println("##################################################");
		System.out.println("# Getting my (ordered) task                      #");
		System.out.println("##################################################");
		System.out.println();
		System.out.println("P. category\tPriority\tTask name\t\t\t\tComment");
		for (int i = 0; i < taskList.size(); i++) {
			System.out.print(taskList.getCategory(i) + "\t\t");
			System.out.print(taskList.getPriority(i) + "\t\t");
			System.out.print(taskList.getTaskName(i) + "\t\t");
			System.out.println(taskList.getTaskComment(i));
		}
		//It shows that the priority ordering automatically when you inserting a new task
		System.out.println();
		System.out.println("##################################################");
		System.out.println("# Finishing tasks                                #");
		System.out.println("##################################################");
		System.out.println();
		System.out.println("Finishing the first task");
		taskList.FinishTask(0);
		System.out.println("P. category\tPriority\tTask name\t\t\t\tComment");
		for (int i = 0; i < taskList.size(); i++) {
			System.out.print(taskList.getCategory(i) + "\t\t");
			System.out.print(taskList.getPriority(i) + "\t\t");
			System.out.print(taskList.getTaskName(i) + "\t\t");
			System.out.println(taskList.getTaskComment(i));
		}
		System.out.println("Finishing \"Do something useful\" task");
		taskList.FinishTask(1);
		System.out.println("P. category\tPriority\tTask name\t\t\t\tComment");
		for (int i = 0; i < taskList.size(); i++) {
			System.out.print(taskList.getCategory(i) + "\t\t");
			System.out.print(taskList.getPriority(i) + "\t\t");
			System.out.print(taskList.getTaskName(i) + "\t\t");
			System.out.println(taskList.getTaskComment(i));
		}
		System.out.println();
		System.out.println("##################################################");
		System.out.println("# Modifing tasks                                 #");
		System.out.println("##################################################");
		System.out.println();
		System.out.println("Modify information");
		taskList.setTask(0, "A", 1, "The MOST IMPORTANT        ", "At this time this is the most important task");
		System.out.println("P. category\tPriority\tTask name\t\t\t\tComment");
		for (int i = 0; i < taskList.size(); i++) {
			System.out.print(taskList.getCategory(i) + "\t\t");
			System.out.print(taskList.getPriority(i) + "\t\t");
			System.out.print(taskList.getTaskName(i) + "\t\t");
			System.out.println(taskList.getTaskComment(i));
		}
		System.out.println("Modify Priority and category");
		taskList.setTask(4, "A", 1, taskList.getTaskName(4), taskList.getTaskComment(4));
		System.out.println("P. category\tPriority\tTask name\t\t\t\tComment");
		for (int i = 0; i < taskList.size(); i++) {
			System.out.print(taskList.getCategory(i) + "\t\t");
			System.out.print(taskList.getPriority(i) + "\t\t");
			System.out.print(taskList.getTaskName(i) + "\t\t");
			System.out.println(taskList.getTaskComment(i));
		}
		
		SimplyTaskList getInfo = new SimplyTaskList("getTask");
		for (int i = 0; i < 6; i++) {
			getInfo.addTask("A", i + 1, "taskName" + i, "");
		}
		System.out.println(getInfo.getTaskIndex("taskName2"));
		System.out.println(getInfo.getLastIndexOfCategory("A"));
		System.out.println(getInfo.getLastIndexOfCategory("B"));
		
	}

}
