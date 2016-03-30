package MyGoal;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import net.miginfocom.swing.MigLayout;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import SimplyTaskList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GWin03 {

	private JFrame frmGwin;
	private JTable table;
	private JTextField textFieldPrior;
	private JTextField textFieldTaskName;
	private JTextField textFieldTaskComment;
	private SimplyTaskList tasks = new SimplyTaskList("taskList");
	private JTextField textFieldPriorMod;
	private JTextField textFieldTaskNameMod;
	private JTextField textFieldTaskCommentMod;
	private JComboBox<String> comboBoxPriorCat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GWin03 window = new GWin03();
					window.frmGwin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GWin03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGwin = new JFrame();
		frmGwin.setTitle("GWin");
		frmGwin.setBounds(100, 100, 825, 480);
		frmGwin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGwin.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][grow][][][][][][][][][]"));
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		frmGwin.getContentPane().add(horizontalBox_1, "flowx,cell 0 0");
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		frmGwin.getContentPane().add(horizontalBox_2, "flowx,cell 0 1");
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		frmGwin.getContentPane().add(horizontalBox_3, "flowx,cell 0 4");
		
		JLabel label = new JLabel("P. category");
		frmGwin.getContentPane().add(label, "flowx,cell 0 5");
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		frmGwin.getContentPane().add(horizontalBox_4, "flowx,cell 0 6 1 3");
		
		JScrollPane scrollPane = new JScrollPane();
		frmGwin.getContentPane().add(scrollPane, "cell 0 9 1 9,grow");
		
		Box horizontalBox = Box.createHorizontalBox();
		frmGwin.getContentPane().add(horizontalBox, "flowx,cell 0 18");
		
		JLabel lblTasks = new JLabel("Tasks: 0");
		frmGwin.getContentPane().add(lblTasks, "cell 0 18");
		
		JLabel lblPriorCategory = new JLabel("P. category");
		frmGwin.getContentPane().add(lblPriorCategory, "cell 0 0");
		
		JLabel lblPriority = new JLabel("                    Priority        ");
		frmGwin.getContentPane().add(lblPriority, "cell 0 0");
		
		comboBoxPriorCat = new JComboBox<String>();
		comboBoxPriorCat.setMaximumRowCount(10);
		frmGwin.getContentPane().add(comboBoxPriorCat, "cell 0 1");
		
		JCheckBox chckbxLastPriority = new JCheckBox("Last priority");
		chckbxLastPriority.setSelected(true);
		frmGwin.getContentPane().add(chckbxLastPriority, "cell 0 1");
		
		textFieldPrior = new JTextField();
		frmGwin.getContentPane().add(textFieldPrior, "cell 0 1");
		textFieldPrior.setColumns(6);
		
		JSeparator separator = new JSeparator();
		frmGwin.getContentPane().add(separator, "cell 0 1");
		
		textFieldTaskName = new JTextField();
		frmGwin.getContentPane().add(textFieldTaskName, "cell 0 1");
		textFieldTaskName.setColumns(20);
		
		textFieldTaskComment = new JTextField();
		frmGwin.getContentPane().add(textFieldTaskComment, "cell 0 1");
		textFieldTaskComment.setColumns(35);
		
		JButton btnAdd = new JButton("Add");
		frmGwin.getContentPane().add(btnAdd, "cell 0 1");
		
		Component horizontalGlue = Box.createHorizontalGlue();
		frmGwin.getContentPane().add(horizontalGlue, "cell 0 1");
		
		JLabel lblTask = new JLabel("   Task                                                           ");
		frmGwin.getContentPane().add(lblTask, "cell 0 0");
		
		JLabel lblCommentsomeInformation = new JLabel("   Comment (some information about the task)");
		frmGwin.getContentPane().add(lblCommentsomeInformation, "cell 0 0");
		
		JComboBox<String> comboBoxPriorCatMod = new JComboBox<String>();
		frmGwin.getContentPane().add(comboBoxPriorCatMod, "cell 0 8");
		
		//Filling up the comboboxes with the possible categories.
		fillCat(comboBoxPriorCat);
		fillCat(comboBoxPriorCatMod);
		
		Component verticalStrut_12 = Box.createVerticalStrut(20);
		frmGwin.getContentPane().add(verticalStrut_12, "cell 0 8");
		
		Component verticalStrut_10 = Box.createVerticalStrut(20);
		frmGwin.getContentPane().add(verticalStrut_10, "cell 0 8");
		
		Component verticalStrut_16 = Box.createVerticalStrut(20);
		frmGwin.getContentPane().add(verticalStrut_16, "cell 0 8");
		
		Component verticalStrut_15 = Box.createVerticalStrut(20);
		frmGwin.getContentPane().add(verticalStrut_15, "cell 0 8");
		
		Component verticalStrut_18 = Box.createVerticalStrut(20);
		frmGwin.getContentPane().add(verticalStrut_18, "cell 0 8");
		
		Component verticalStrut_17 = Box.createVerticalStrut(20);
		frmGwin.getContentPane().add(verticalStrut_17, "cell 0 8");
		
		Component verticalStrut_19 = Box.createVerticalStrut(20);
		frmGwin.getContentPane().add(verticalStrut_19, "cell 0 8");
		
		Component verticalStrut_14 = Box.createVerticalStrut(20);
		frmGwin.getContentPane().add(verticalStrut_14, "cell 0 8");
		
		Component verticalStrut_20 = Box.createVerticalStrut(20);
		frmGwin.getContentPane().add(verticalStrut_20, "cell 0 8");
		
		Component verticalStrut_13 = Box.createVerticalStrut(20);
		frmGwin.getContentPane().add(verticalStrut_13, "cell 0 8");
		
		Component verticalStrut_11 = Box.createVerticalStrut(20);
		frmGwin.getContentPane().add(verticalStrut_11, "cell 0 8");
		
		textFieldPriorMod = new JTextField();
		frmGwin.getContentPane().add(textFieldPriorMod, "cell 0 8");
		textFieldPriorMod.setColumns(6);
		
		textFieldTaskNameMod = new JTextField();
		frmGwin.getContentPane().add(textFieldTaskNameMod, "cell 0 8");
		textFieldTaskNameMod.setColumns(20);
		
		textFieldTaskCommentMod = new JTextField();
		frmGwin.getContentPane().add(textFieldTaskCommentMod, "cell 0 8");
		textFieldTaskCommentMod.setColumns(35);
		
		JButton btnModify = new JButton("Modify");
		frmGwin.getContentPane().add(btnModify, "cell 0 8");
		
		JLabel label_1 = new JLabel("   Priority        ");
		frmGwin.getContentPane().add(label_1, "cell 0 5");
		
		JLabel label_2 = new JLabel("   Task                                                           ");
		frmGwin.getContentPane().add(label_2, "cell 0 5");
		
		JLabel label_3 = new JLabel("   Comment (some information about the task)");
		frmGwin.getContentPane().add(label_3, "cell 0 5");
		
		JMenuBar menuBar = new JMenuBar();
		frmGwin.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tasks.writeXmlFile();
			}
		});
		mnFile.add(mntmSave);
		
		refreshPriority(chckbxLastPriority, comboBoxPriorCat.getSelectedItem().toString());
		
		textFieldPrior.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				frmGwin.getRootPane().setDefaultButton(btnAdd);
			}
		});
		textFieldTaskName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				frmGwin.getRootPane().setDefaultButton(btnAdd);
			}
		});
		textFieldTaskComment.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				frmGwin.getRootPane().setDefaultButton(btnAdd);
			}
		});
		textFieldPriorMod.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				frmGwin.getRootPane().setDefaultButton(btnModify);
			}
		});
		textFieldTaskNameMod.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				frmGwin.getRootPane().setDefaultButton(btnModify);
			}
		});
		textFieldTaskCommentMod.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				frmGwin.getRootPane().setDefaultButton(btnModify);
			}
		});
		
		/**
		 * Table what contains the task list
		 */
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Prior.cat.", "Priority", "Task", "Comment", "Finished"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, Integer.class, String.class, String.class, Boolean.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			};
		
		// Add a new task into the task list and into the table.
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addNewTask(comboBoxPriorCat.getSelectedItem().toString(), Integer.parseInt(textFieldPrior.getText()), textFieldTaskName.getText(), textFieldTaskComment.getText(), model)){
					reload(lblTasks, model);
					clearFields(chckbxLastPriority, comboBoxPriorCat.getSelectedItem().toString());
				}
			}
		});

		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tasks.setTask(table.getSelectedRow(), comboBoxPriorCatMod.getSelectedItem().toString(), Integer.parseInt(textFieldPriorMod.getText()), textFieldTaskNameMod.getText(), textFieldTaskCommentMod.getText())){
					clearModel(model);
					loadTable(model);
				}
				else
					JOptionPane.showMessageDialog(frmGwin, "A következő feladtnév már használatban van: \"" + textFieldTaskNameMod.getText() + "\"\n Kérem ellenőrizze, hogy létező feladatot akar-e rögzíteni, vagy válasszon másik nevet!", "Figyelem!",
						    JOptionPane.WARNING_MESSAGE);
			}
		});
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (table.getValueAt(table.getSelectedRow(), 4).toString() == "true"){
					tasks.FinishTask(table.getSelectedRow());
					//model.removeRow(table.getSelectedRow());
					refreshPriority(chckbxLastPriority, comboBoxPriorCat.getSelectedItem().toString());
					reload(lblTasks, model);
				}
				else{
					Integer taskIndex = table.getSelectedRow();
					textFieldPriorMod.setText(tasks.getPriority(taskIndex) + "");
					textFieldTaskNameMod.setText(tasks.getTaskName(taskIndex));
					textFieldTaskCommentMod.setText(tasks.getTaskComment(taskIndex));
					comboBoxPriorCatMod.setSelectedIndex(tasks.getPriorityCategories().indexOf(tasks.getCategory(taskIndex)));
				}
			}
		});
		table.getColumnModel().getColumn(0).setMaxWidth(80);
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(48);
		table.getColumnModel().getColumn(1).setMaxWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setMaxWidth(450);
		table.getColumnModel().getColumn(3).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setMaxWidth(800);
		table.getColumnModel().getColumn(4).setPreferredWidth(55);
		table.getColumnModel().getColumn(4).setMaxWidth(80);
		scrollPane.setViewportView(table);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tasks.loadXML();
				reload(lblTasks, model);
			}
		});
		mnFile.add(mntmLoad);

		comboBoxPriorCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshPriority(chckbxLastPriority, comboBoxPriorCat.getSelectedItem().toString());
			}
		});
		
	}
	
	/**
	 * Add elements to the given combobox from the task list's possible categories.
	 * 
	 * @param cbox The combobox what will contain the the categories.
	 */
	public void fillCat(JComboBox<String> cbox){
		for (String boxItem : tasks.getPriorityCategories()) {
			cbox.addItem(boxItem);
		}
	}
	
	/**
	 * Adds new task into the task list and into the given table model.
	 * 
	 * @param pcat Priority category of the task.
	 * @param prior The priority of the new task.
	 * @param task The name of the new task.
	 * @param comment Some information about the new task.
	 * @param model The table model what into we want to insert the task.
	 */
	public boolean addNewTask(String pcat, Integer prior, String task, String comment,DefaultTableModel model){
		// If the add was successful, the new task will be added into the table
		if(tasks.addTask(pcat, prior, task, comment)){
			model.addRow(new Object[]{pcat, prior, task, comment, false});
			return true;
		}
		// The Task's name must be unique. If it doesn't we show an error message.
		else{
			//textFieldTaskName.setText(task + "-2");
			JOptionPane.showMessageDialog(frmGwin, "A következő feladtnév már használatban van: \"" + task + "\"\n Kérem ellenőrizze, hogy létező feladatot akar-e rögzíteni, vagy válasszon másik nevet!", "Figyelem!",
				    JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
	
	/**
	 * Refresh the menu strip information.
	 * 
	 * @param lblTasks The label what contains information about tasks.
	 */
	private void refreshStatusStrip(JLabel lblTasks){
		lblTasks.setText("Tasks: " + tasks.size());
	}
	
	/**
	 * Load the task list into the given table model.
	 * 
	 * @param model The table model what will contain the task list.
	 */
	public void loadTable(DefaultTableModel model){
		for (Integer i = 0; i < tasks.getTasks().size(); i++) {
			model.addRow(new Object[]{tasks.getTaskCategory(i), tasks.getPriority(i), tasks.getTaskName(i), tasks.getTaskComment(i), tasks.getIsFinished(i)});
		}
	}
	
	/**
	 * Delete all element of the given model.
	 * @param model The model what we want to empty.
	 */
	private void clearModel(DefaultTableModel model){
		int size = model.getRowCount();
		for (int i = 0; i < size; i++) {
			model.removeRow(0);
		}
	}
	
	/**
	 * Sets the text field back to normal.
	 * 
	 * @param lastPrior The checkbox what contains information about the usage.
	 * @param priorCat The priority category what's last element we will set in the priority text field.
	 */
	public void clearFields(JCheckBox lastPrior, String priorCat){
		refreshPriority(lastPrior, priorCat);
		textFieldTaskName.setText("");
		//textFieldTaskName.setText(textFieldPrior.getText());
		textFieldTaskComment.setText("");
	}
	
	/**
	 * In the Priority's text field sets the last priority in the category if we want to use the last priority and sets to empty otherwise.
	 * 
	 * @param lastPrior The checkbox what contains information about the usage.
	 * @param priorCat The priority category what's last element we will set in the priority text field.
	 */
	public void refreshPriority(JCheckBox lastPrior, String priorCat){
		if (lastPrior.isSelected()){
			Integer lastPItem = tasks.getLastPriorityInCategory(priorCat) + 1;
			textFieldPrior.setText(lastPItem.toString());
		}
		else
			textFieldPrior.setText("");
		
	}
	
	public void reload(JLabel lblTasks, DefaultTableModel model){
		refreshStatusStrip(lblTasks);
		clearModel(model);
		loadTable(model);
	}
	
}
