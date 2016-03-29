package Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

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
 * 
 * It creates a list about tasks and task priorities with priority categories.
 * 
 * @author Asuki
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
	LinkedList<SimplyTask> tasks;
	/**
	 * The list of the finished tasks.
	 */
	LinkedList<SimplyTask> finishedTasks;
	/**
	 * The list of the category of priorities. It must be sync with the task list and priority list.
	 */
	LinkedList<String> priorCat;
	/**
	 * The list of the category. It must be sync with the task list and the priorCat list.
	 */
	LinkedList<Integer> priority;
	/**
	 * List of the possible priorities.
	 */
	LinkedList<String> priorityCategories;
	/**
	 * Contains information about categories.
	 */
	LinkedList<Integer> isUsedCat;
	/**
	 * Stores information about the categories.
	 */
	String categoryInfo;
	String XMLFile;
	 
	/**
	 * @param listName The name of the task list.
	 */
	public SimplyTaskList(String listName){
		this.listName = listName;
		tasks = new LinkedList<SimplyTask>();
		finishedTasks = new LinkedList<SimplyTask>();
		priorCat = new LinkedList<String>();
		priority = new LinkedList<Integer>();
		priorityCategories = new LinkedList<String>();
		priorityCategories.add("A");
		priorityCategories.add("B");
		priorityCategories.add("C");
		priorityCategories.add("D");
		categoryInfo = "A - Mindenképp fontos, elvégzendő feladat rövid időn belül | B - Olyan feladat ami hosszabb távú | C - Nem fontos feladat | D - Delegálandó feladat: Amit más is el tud végezni, azt delegálni kell";
		isUsedCat = new LinkedList<Integer>();
		for (int i = 0; i < priorityCategories.size(); i++) {
			isUsedCat.add(0);
		}
		XMLFile = "taskList.xml";
	}
	

	/**
	 * Removes the given name!'s task, puts in the finished task list and reorder the elements after the element in the same category.
	 * 
	 * @param taskIndex The index of the task what we want to finish.
	 * @return true if the remove was successful and the active list had contained the task. Return false otherwise. 
	 */
	public boolean FinishTask(int taskIndex){
		//tasks.get(taskIndex).setFinished(true);
		//return true;
		if (taskIndex >= 0 && taskIndex < tasks.size()){
			String catTmp = this.priorCat.get(taskIndex);
			Integer priorTmp = this.priority.get(taskIndex);
			finishedTasks.add(tasks.get(taskIndex));
			tasks.remove(tasks.get(taskIndex));
			priorCat.remove(priorCat.get(taskIndex));
			priority.remove(taskIndex);
			reorderTasksAfterRemove(catTmp, priorTmp);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Adds the index of the task in the active task list.
	 * 
	 * @param taskName The name what's index we search for.
	 * @return the index of the task if it is in the active task list and -1 otherwise.
	 */
	public int getTaskIndex(String taskName){
		for (int result = 0; result < tasks.size(); result++) {
			if (taskName.equals(this.tasks.get(result).taskName))
				return result;
		}
		return -1;
	}
	
	/**
	 * Reorder the active task list's priority. It can use after remove an element.
	 * 
	 * @param priorCat The category of the removed element's priority.
	 * @param priority The removed element's priority.
	 */
	protected void reorderTasksAfterRemove(String priorCat, Integer priority){
		for (int i = 0; i < this.priority.size(); i++) {
			Integer value = this.priority.get(i);
			if (value > priority && priorCat.equals(this.priorCat.get(i))) 
				this.priority.set(i, value - 1);
		}
	}
	
	/*
	 * Changes a task's priority category. If the new category is higher than the older, the task will have the worst (highest value) priority in the new category. If the new category is lower than the old one, the task will be the first in that.
	 * 
	 * @param taskName The name of the task what's priority category we want to change.
	 * @param newPriorCat The new priority category we want to use. It can be: "A", "B" or "C".
	 */
	/*public void changePriorCat(String taskName, String newPriorCat){
		Integer taskIndex = getTaskIndex(taskName);
		if (taskIndex == -1)
			return;
		Integer newCatIndex = priorityCategories.indexOf(newPriorCat);
		Integer oldCatIndex = priorityCategories.indexOf(priorCat.get(taskIndex));
		if (oldCatIndex == newCatIndex)
			return;
		if (newCatIndex > oldCatIndex) {
			for (int i = 0; i < this.priority.size(); i++) {
				if (this.priorCat.get(i) == newPriorCat)
					priority.set(i, priority.get(i) + 1);
			}
			priority.set(taskIndex, 1);
		}
		else
			priority.set(taskIndex, getLastPriorityInCategory(newPriorCat) + 1);
		priorCat.set(taskIndex, newPriorCat);
	}*/
	
	/**
	 * Gives the last priority value of the given priority category.
	 * 
	 * @param priorCat The priority category what we want to find the last priority.
	 * @return The last element of the priority category.
	 */
	public int getLastPriorityInCategory(String priorCat){
		int max = 0;
		int priorTmp;
		for (int i = 0; i < this.priorCat.size(); i++) {
			if (priorCat == this.priorCat.get(i) && max < (priorTmp = priority.get(i)))
				max = priorTmp;
		}
		return max;
	}
	
	/**
	 * Checks if the task is finished.
	 * 
	 * @param taskName The name of the task what we want to check if it is finished.
	 * @return true if the task is finished and false otherwise.
	 */
	public boolean isFinished(String taskName){
		for (SimplyTask task : finishedTasks) {
			if (taskName.equals(task.taskName)) 
				return true;
		}
		return false;
	}
	
	/**
	 * Removes the element of the finished list.
	 */
	public void clearFinished(){
		finishedTasks.clear();
	}
	
	/**
	 * It gives the names of the finished tasks.
	 * 
	 * @return the name of the tasks
	 */
	public LinkedList<String> getFinishedTaskNames(){
		LinkedList<String> result = new LinkedList<String>();
		for (SimplyTask task : finishedTasks) {
			result.add(task.taskName);
		}
		return result;
	}
	 
	 /**
	  * Renames the task if there is no other task with the new name
	  * 
	 * @param oldName The task name what we want to change.
	 * @param newName The name what we want to use in the future.
	 * @return True if the name change was successful and false if it is failed.
	 */
	public boolean setTaskName (String oldName, String newName){
		 int taskIndex;
		 if ((taskIndex = getTaskIndex(oldName)) != -1 && getTaskIndex(newName) == -1){
			 tasks.get(taskIndex).setTaskName(newName);
			 return true;
		 }
		 return false;
	 }
	
	/**
	 * Ads a new task into the list. The method orders by categories and priorities.
	 * 
	 * @param pcat The priority category of the task.
	 * @param prior The priority of the task.
	 * @param task The name of the task.
	 * @param comment Some information about the task.
	 * @return true if adding was successful and false otherwise
	 */
	public boolean addTask(String pcat, Integer prior, String task, String comment) {
		if(-1 == getTaskIndex(task))
		{
			//It checks if has task in the list
			if (tasks.size() > 0){
				//If the category of the new task is exists
				if (isUsedCategory(pcat)){
					//Sets the previous category's last priority index
					Integer indexTmp = getPrevCatIndex(pcat);
					indexTmp = indexTmp < 0 ? 0 : indexTmp;
					Integer lastLower = getLastIndexOfCategory(priorityCategories.get(indexTmp));
					//Increasing all of the task's priority with equal or higher priority.
					for (int i = 0; i < priority.size(); i++) {
						if (priority.get(i) >= prior && pcat == priorCat.get(i))
							priority.set(i, priority.get(i) + 1);
						if (priorCat.get(i) == pcat && priority.get(i) < prior){
							lastLower = i;
						}
					}
					//Inserting the task, its priority and category into the right place.
					lastLower = (pcat == priorityCategories.get(0) && 1 == prior) ? 0 : lastLower + 1;
					tasks.add(lastLower, new SimplyTask(task));
					tasks.get(lastLower).setComment(comment);
					priorCat.add(lastLower, pcat);
					priority.add(lastLower, prior);
				}
				//If the category of the new task does not exists
				else{
					Integer indexTmp = priorityCategories.indexOf(pcat);
					isUsedCat.set(indexTmp, 1);
					Integer catIndexTmp;
					//If has priority category before the new task's category, we insert the new task after the previous category.
					if ((catIndexTmp = getPrevCatIndex(pcat)) != -1){
						Integer addIndextmp = getLastIndexOfCategory(priorityCategories.get(catIndexTmp)) + 1;
						tasks.add(addIndextmp, new SimplyTask(task));
						priorCat.add(addIndextmp, pcat);
						priority.add(addIndextmp, prior);
					}
					//If has no priority category before the new task's category, we insert the new task before the next category.
					else{
						catIndexTmp = getNextCatIndex(pcat);
						Integer addIndextmp = getFirstIndexOfCategory(priorityCategories.get(catIndexTmp)) - 1;
						tasks.add(addIndextmp, new SimplyTask(task));
						priorCat.add(addIndextmp, pcat);
						priority.add(addIndextmp, prior);
					}
				}
			}
			//If there is no item in the list
			else{
				tasks.addFirst(new SimplyTask(task));
				priorCat.addFirst(pcat);
				priority.addFirst(prior);
				isUsedCat.set(priorityCategories.indexOf(pcat), 1);
				tasks.getFirst().setComment(comment);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Gives the index of the previous category from the priorityCategories list.
	 * 
	 * @param cat The category what's ancestor we search.
	 * @return The index of the previous category and -1 otherwise.
	 */
	private Integer getPrevCatIndex(String cat){
		Integer catIndex = priorityCategories.indexOf(cat);
		Integer result = -1;
		for (int i = 0; i < isUsedCat.size() && catIndex != i; i++) {
			if (isUsedCat.get(i) != 0 && i < catIndex)
				result = i;
		}
		return result;
	}
	
	/**
	 * Gives the index of the next category from the priorityCategories list.
	 * 
	 * @param cat The category what's next we search.
	 * @return The index of the next category and -1 otherwise.
	 */
	private Integer getNextCatIndex(String cat){
		Integer catIndex = priorityCategories.indexOf(cat);
		Integer result = isUsedCat.size() - 1;
		for (int i = isUsedCat.size() - 1; i >= 0 && catIndex != i; i++) {
			if (isUsedCat.get(i) != 0 && i > catIndex)
				result = i;
		}
		return result;
	}
	
	/**
	 * Gives the category usage.
	 * 
	 * @param cat The category what we want to check.
	 * @return True if the category is used, false otherwise.
	 */
	private boolean isUsedCategory(String cat){
		return isUsedCat.get(priorityCategories.indexOf(cat)) != 0;
	}
	
	/**
	 * Sets a category to used.
	 * 
	 * @param cat The category what we want to set as used.
	 */
	private void setCatToUsed(String cat){
		isUsedCat.set(priorityCategories.indexOf(cat), 1);
	}
	
	/**
	 * Gives the first index of the category.
	 * 
	 * @param category The category what's first index we search.
	 * @return The first index of the category. If there is now such a category it returns with -1.
	 */
	public int getFirstIndexOfCategory(String category){
		for (int i = 0; i < priorCat.size(); i++) {
			if (priorCat.get(i) == category)
				return i;
		}
		return -1;
	}
	
	/**
	 * Gives the last index of the category.
	 * 
	 * @param category The category what's last index we search.
	 * @return The last index of the category. If there is now such a category it returns with -1.
	 */
	public int getLastIndexOfCategory(String category){
		int result = -1;
		for (int i = 0; i < priorCat.size(); i++) {
			if (priorCat.get(i) == category)
				result = i;
		}
		return result;
	}
	
	/**
	 * Gives the list of the tasks.
	 * 
	 * @return The task list.
	 */
	public LinkedList<SimplyTask> getTasks() {
		return tasks;
	}
		
	/**
	 * Gives the list of possible priority categories.
	 * 
	 * @return The possible priority categories.
	 */
	public LinkedList<String> getPriorityCategories() {
		return priorityCategories;
	}
	
	 /**
	  * Gives the name of the task list.
	  * 
	 * @return The name of the task list.
	 */
	public String getListName() {
		return listName;
	}
	
	 /**
	  * Sets the name of the task list.
	  * 
	 * @param listName The new name of the task list.
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}
	
	/**
	 * Gives the name of a task.
	 * 
	 * @param taskIndex The index what's name we want to know.
	 * @return the name of the task in the index.
	 */
	public String getTaskName(Integer taskIndex){
		return tasks.get(taskIndex).taskName;
	}
	
	/**
	 * Gives the category of the task.
	 * 
	 * @param taskIndex The index of the task what's category we search.
	 * @return The priority category of the task.
	 */
	public String getTaskCategory(Integer taskIndex){
		return priorCat.get(taskIndex);
	}
	
	/**
	 * Checks if the task is finished.
	 * 
	 * @param taskIndex The index of the task what we want to check if it is finished.
	 * @return true if the task finished and false otherwise.
	 */
	public boolean getIsFinished(Integer taskIndex){
		return tasks.get(taskIndex).isFinished;
	}
	
	/**
	 * Gives some information about the task.
	 * 
	 * @param taskIndex The index of the task what from we want to know some information.
	 * @return Some information about the task.
	 */
	public String getTaskComment(Integer taskIndex){
		return tasks.get(taskIndex).getComment();
	}
	
	/**
	 * Gives information about the possible categories.
	 * 
	 * @return information about the categories.
	 */
	public String getCategoryInfo() {
		return categoryInfo;
	}
	
	/**
	 * Gives the priority category of the task.
	 * 
	 * @param taskIndex The index of the task what's category we search.
	 * @return The priority category of the task.
	 */
	public String getCategory(Integer taskIndex){
		return priorCat.get(taskIndex);
	}
	

	/**
	 * Gives the priority of the task.
	 * 
	 * @param taskIndex The index of the task what's priority we search.
	 * @return The priority priority of the task.
	 */
	public int getPriority(Integer taskIndex){
		return priority.get(taskIndex);
	}
	
	/**
	 * Gives the number of the tasks.
	 * 
	 * @return The number of the tasks.
	 */
	public int size(){
		return tasks.size();
	}

	/**
	 * Modify a task with the given information.
	 * 
	 * @param taskIndex The index of the task what we want to modify.
	 * @param pcat The new priority category.
	 * @param prior The new priority.
	 * @param newTaskName The new name of the task.
	 * @param newComment The modified comment.
	 * @return True if the the modify was successful, false otherwise.
	 */
	public boolean setTask(int taskIndex, String pcat, int prior, String newTaskName, String newComment) {
		//If the new task name not exist or equals with the old task name.
		if(-1 == getTaskIndex(newTaskName) || newTaskName.equals(this.getTaskName(taskIndex))){
			FinishTask(taskIndex);
			addTask(pcat, prior, newTaskName, newComment);
			return true;
		}
		return false;
	}
	
	/**
	 * Saves the current task list into an XML file.
	 */
	public void writeXmlFile() {
	    try {

	        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
	        DocumentBuilder build = dFact.newDocumentBuilder();
	        Document doc = build.newDocument();
	        
	        // Creating the root element: TaskList
	        Element root = doc.createElement("TaskList");
	        doc.appendChild(root);

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
		        
		        Element taskIsFinished = doc.createElement("TaskIsFinished");
		        task.appendChild(taskIsFinished);
		        taskIsFinished.appendChild(doc.createTextNode(String.valueOf(tasks.get(i).getIsFinished())));
		        
			}

	        // Save the document to the disk file
	        TransformerFactory tranFactory = TransformerFactory.newInstance();
	        Transformer aTransformer = tranFactory.newTransformer();

	        // Format the XML nicely
	        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

	        aTransformer.setOutputProperty(
	                "{http://xml.apache.org/xslt}indent-amount", "4");
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

	    } catch (TransformerException ex) {
	        System.out.println("Error outputting document");

	    } catch (ParserConfigurationException ex) {
	        System.out.println("Error building document");
	    }
	}
	
	/**
	 * Load the last save task list into the task list.
	 */
	public void loadXML(){
		 try {

				File fXmlFile = new File(XMLFile);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
						
				doc.getDocumentElement().normalize();
						
				NodeList nList = doc.getElementsByTagName("Task");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
							
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						priorCat.add(eElement.getElementsByTagName("PriorCat").item(0).getTextContent());
						priority.add(Integer.parseInt(eElement.getElementsByTagName("Priority").item(0).getTextContent()));
						tasks.add(new SimplyTask(eElement.getElementsByTagName("TaskName").item(0).getTextContent()));
						tasks.get(temp).setComment(eElement.getElementsByTagName("TaskComment").item(0).getTextContent());
						if ("true".equals(eElement.getElementsByTagName("TaskIsFinished").item(0).getTextContent()))
							tasks.get(temp).setIsFinished(true);
					}
				}
				isUsedCat.size();
				checkUsedCategories();
				int x;
				x = 1;
				x = x+1;
		 } catch (Exception e) {
				e.printStackTrace();
		 }
	}
	
	public void checkUsedCategories(){
		for (int i = 0; i < priorCat.size(); i++) {
			if(!isUsedCategory(priorCat.get(i)))
				setCatToUsed(priorCat.get(i));
		}
	}
}
