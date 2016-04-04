package task;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class SimplyTaskListTest {

	String taskListName = "taskTest";
	String A = "A";
	String B = "B";
	String C = "C";
	String D = "D";
	String task = "task";
	String comment = "comment";

	@Test
	public void testGetTaskComment() throws Exception {
		SimplyTaskList taskList = new SimplyTaskList(taskListName);
		assertTrue(taskList.addTask(A, 1, "Comment Test", "New comment test"));
		assertEquals(taskList.getTaskComment(0), "New comment test");
	}
	
	@Test
	public void testAddTask() throws Exception {
		SimplyTaskList taskList = new SimplyTaskList(taskListName);
		for (int i = 0; i < 3; i++) {
			assertTrue(taskList.addTask(A, i + 1, "task" + i, comment + i));
		}
		assertEquals(3, taskList.size());
		for (int i = 0; i < 3; i++) {
			assertEquals(A, taskList.getCategory(i));
			assertEquals(i + 1, taskList.getPriority(i));
			assertEquals("task" + i, taskList.getTaskName(i));
			assertEquals(comment + i, taskList.getTaskComment(i));
		}
		
		//Insert new element with lower category
		assertTrue(taskList.addTask(B, 1, task + "B1", comment + "B1"));
		assertEquals(4, taskList.size());
		assertEquals(B, taskList.getCategory(3));
		assertEquals(1, taskList.getPriority(3));
		
		//Insert new element before the first B element
		assertTrue(taskList.addTask(B, 1, task + "B1New", task + "B1New"));
		assertEquals(5, taskList.size());
		assertEquals(B, taskList.getCategory(3));
		assertEquals(1, taskList.getPriority(3));
		assertEquals(task + "B1New", taskList.getTaskName(3));
		assertEquals(B, taskList.getCategory(4));
		assertEquals(2, taskList.getPriority(4));
		assertEquals(task + "B1", taskList.getTaskName(4));
		
		assertTrue(taskList.addTask(D, 1, task + "D1", comment + "D1"));
		assertTrue(taskList.addTask(C, 1, task + "C1", comment + "C1"));
		assertEquals(7, taskList.size());
		assertEquals(C, taskList.getCategory(5));
		assertEquals(task + "D1", taskList.getTaskName(6));
		
		//Insert a new first element into a category
		assertTrue(taskList.addTask(B, 1, task + "BFirst", comment));
		assertEquals(8, taskList.size());
		assertEquals(task + "BFirst", taskList.getTaskName(3));
		
		//Insert a new first element into the first category.
		assertTrue(taskList.addTask(A, 1, task + "A1First", comment));
		assertEquals(9, taskList.size());
		assertEquals(task + "A1First", taskList.getTaskName(0));
	}
	
	@Test
	public void testGetTaskIndex() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		assertEquals(taskList.getTaskIndex("taskA1"), 1);
		assertEquals(taskList.getTaskIndex("taskB2"), 5);
		assertEquals(taskList.getTaskIndex("notExistedTask"), -1);
	}
	
	@Test
	public void testFinishTask() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		assertEquals(taskList.getTaskIndex("taskA1"), 1);
		taskList.finishTask(1);
		assertEquals(taskList.getTaskIndex("taskA1"), -1);
	}
	
	@Test
	public void testGetLastIndexOfCategory() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		assertEquals(taskList.getLastIndexOfCategory(A), 3);
		assertEquals(taskList.getLastIndexOfCategory(B), 5);
		assertEquals(taskList.getLastIndexOfCategory(C), 6);
	}
	
	@Test
	public void testGetFirstIndexOFCategory() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		assertEquals(taskList.getFirstIndexOfCategory(A), 0);
		assertEquals(taskList.getFirstIndexOfCategory(B), 4);
		assertEquals(taskList.getFirstIndexOfCategory(C), 6);
	}
	
	@Test
	public void testGetCategory() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		assertEquals(taskList.getCategory(0), A);
		assertEquals(taskList.getCategory(2), A);
		assertEquals(taskList.getCategory(5), B);
		assertEquals(taskList.getCategory(6), C);
	}
	
	@Test
	public void testGetIsFinished() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		taskList.finishTask(3);
		assertEquals(taskList.isFinished(task + A + 3), true);
	}
	
	@Test
	public void testGetLastPriorityInCategory() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		assertEquals(taskList.getLastPriorityInCategory(A), 4);
		assertEquals(taskList.getLastPriorityInCategory(B), 2);
		assertEquals(taskList.getLastPriorityInCategory(C), 1);
	}
	
	@Test
	public void testGetListName() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		assertEquals(taskList.getListName(), "test");
	}
	
	@Test
	public void testGetPriority() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		assertEquals(taskList.getPriority(2), 3);
		assertEquals(taskList.getPriority(5), 2);
		assertEquals(taskList.getPriority(6), 1);
	}
	
	@Test
	public void testGetPriorityCategories() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		LinkedList<String> tmp = new LinkedList<String>();
		tmp.add(A);
		tmp.add(B);
		tmp.add(C);
		tmp.add(D);
		assertEquals(taskList.getPriorityCategories(), tmp);
	}
	
	@Test
	public void testGetTaskCategory() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		for (int i = 0; i < 4; i++)
			assertEquals(taskList.getTaskCategory(i), A);
		assertEquals(taskList.getTaskCategory(4), B);
		assertEquals(taskList.getTaskCategory(5), B);
		assertEquals(taskList.getTaskCategory(6), C);
	}
	
	@Test
	public void testGetTaskName() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		for (int i = 0; i < 4; i++) {
			assertEquals(taskList.getTaskName(i), task + A +i);;
		}
		assertEquals(taskList.getTaskName(4), "taskB1");
		assertEquals(taskList.getTaskName(5), "taskB2");
		assertEquals(taskList.getTaskName(6), "taskC1");
	}
	
	@Test
	public void testSetListName() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		taskList.setListName("testSetListName");
		assertEquals(taskList.getListName(), "testSetListName");
	}
	
	@Test
	public void testSize() throws Exception {
		SimplyTaskList taskList = createSomeTask();
		assertEquals(taskList.size(), 7);
	}
	
	@Test
  public void testLoad() throws Exception {
    SimplyTaskList taskLoad = new SimplyTaskList("loadTest");
    taskLoad.loadXML();
    assertEquals(taskLoad.getTaskName(2), "Convergence");
    assertEquals(taskLoad.getCategory(2), A);
    assertEquals(taskLoad.getPriority(2), 3);
  }
	
	public SimplyTaskList createSomeTask(){
		SimplyTaskList result = new SimplyTaskList("test");
		for (int i = 0; i < 4; i++) {
			result.addTask(A, i + 1, task + A + i, comment + i);
		}
		result.addTask(B, 1, task + "B1", comment);
		result.addTask(B, 2, task + "B2", comment);
		result.addTask(C, 1, task + "C1", comment);
		return result;
	}
}
