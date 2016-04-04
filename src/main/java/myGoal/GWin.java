package myGoal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import task.SimplyTask;
import task.SimplyTaskList;
import task.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class GWin {

  private JFrame frmGwin;
  private JTable table;
  private JTextField textFieldPrior;
  private JTextField textFieldTaskName;
  private JTextField textFieldTaskComment;
  private SimplyTaskList tasks = new SimplyTaskList("taskList");
  private JTextField textFieldPriorMod;
  private JTextField textFieldTaskNameMod;
  private JTextField textFieldTaskCommentMond;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GWin window = new GWin();
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
  public GWin() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmGwin = new JFrame();
    frmGwin.setTitle("GWin");
    frmGwin.setBounds(100, 100, 836, 460);
    frmGwin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JScrollPane scrollPane = new JScrollPane();
    
    final JComboBox comboBox = new JComboBox();
    comboBox.setToolTipText(tasks.getCategoryInfo());
    fillCat(comboBox);
    
    textFieldPrior = new JTextField();
    textFieldPrior.setColumns(10);
    
    final JCheckBox chckbxLastPrior = new JCheckBox("Utols\u00F3 priorit\u00E1s");
    chckbxLastPrior.setSelected(true);
    
    textFieldTaskName = new JTextField();
    textFieldTaskName.setColumns(10);
    
    textFieldTaskComment = new JTextField();
    textFieldTaskComment.setColumns(10);
    
    final JButton btnAdd = new JButton("Add");
    
    Box horizontalBox = Box.createHorizontalBox();
    
    Box horizontalBox_1 = Box.createHorizontalBox();
    
    final JComboBox comboBoxMod = new JComboBox();
    fillCat(comboBoxMod);
    
    textFieldPriorMod = new JTextField();
    textFieldPriorMod.setColumns(10);
    
    textFieldTaskNameMod = new JTextField();
    
    textFieldTaskNameMod.setColumns(10);
    
    textFieldTaskCommentMond = new JTextField();
    textFieldTaskCommentMond.setColumns(10);
    
    final JButton btnModify = new JButton("Modify");
    
    JLabel lblCategory = new JLabel("Category");
    
    JLabel label = new JLabel("Category");
    
    JLabel lblPriority = new JLabel("Priority");
    
    JLabel label_1 = new JLabel("Priority");
    
    JLabel lblTaskName = new JLabel("Task name");
    
    JLabel label_2 = new JLabel("Task name");
    
    JLabel lblCommentAboutTask = new JLabel("Comment about task");
    
    JLabel label_3 = new JLabel("Comment about task");
    GroupLayout groupLayout = new GroupLayout(frmGwin.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 802, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(comboBoxMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                .addGroup(groupLayout.createSequentialGroup()
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(textFieldPriorMod, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addGroup(groupLayout.createSequentialGroup()
                      .addGap(2)
                      .addComponent(label_1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(textFieldTaskNameMod, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(textFieldTaskCommentMond, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_3, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(btnModify))
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(textFieldPrior, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(chckbxLastPrior)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(textFieldTaskName, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(lblCommentAboutTask)
                    .addGroup(groupLayout.createSequentialGroup()
                      .addComponent(textFieldTaskComment, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(ComponentPlacement.RELATED)
                      .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))))))
          .addGap(64))
        .addComponent(horizontalBox_1, GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblCategory)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(lblPriority)
          .addGap(111)
          .addComponent(lblTaskName)
          .addContainerGap(622, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.TRAILING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(16)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblCategory)
            .addComponent(lblPriority)
            .addComponent(lblTaskName)
            .addComponent(lblCommentAboutTask))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(textFieldPrior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(chckbxLastPrior)
                .addComponent(textFieldTaskName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(textFieldTaskComment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
              .addGap(22)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                  .addComponent(label)
                  .addComponent(label_1))
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                  .addComponent(label_2)
                  .addComponent(label_3)))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                .addComponent(btnModify)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                  .addComponent(textFieldTaskCommentMond, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addComponent(textFieldTaskNameMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addComponent(textFieldPriorMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addComponent(comboBoxMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(258)
              .addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(6)
              .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(horizontalBox_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
    );
    
    final JLabel labelPriorSum = new JLabel("");
    horizontalBox_1.add(labelPriorSum);

    final DefaultTableModel model = new DefaultTableModel(
        new Object[][] {
        },
        new String[] {
          "Prior.kat.", "Priorit\u00E1s", "Feladat", "Megjegyz\u00E9s", "K\u00E9sz"
        }
      ) {
        Class[] columnTypes = new Class[] {
          String.class, Integer.class, String.class, String.class, Boolean.class
        };
        public Class getColumnClass(int columnIndex) {
          return columnTypes[columnIndex];
        }
      };
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        if (addNewTask(comboBox.getSelectedItem().toString(),
            Integer.parseInt(textFieldPrior.getText()),
            textFieldTaskName.getText(), textFieldTaskComment.getText(),
            model)) {
          reload(labelPriorSum, model);
          clearFields(chckbxLastPrior,
              comboBox.getSelectedItem().toString());
        }
      }
    });
    table = new JTable(model);
    table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        if (table.getValueAt(table.getSelectedRow(), 4).toString() == "true"){
          tasks.finishTask(table.getSelectedRow());
          //model.removeRow(table.getSelectedRow());
          refreshPriority(chckbxLastPrior, comboBox.getSelectedItem().toString());
          labelPriorSum.setText("Feladatok sz�ma: " + tasks.getTasks().size());
          clearModel(model);
          loadTable(model);
        }
        else{
          Integer taskIndex = table.getSelectedRow();
          textFieldPriorMod.setText(tasks.getPriority(taskIndex) + "");
          textFieldTaskNameMod.setText(tasks.getTaskName(taskIndex));
          textFieldTaskCommentMond.setText(tasks.getTaskComment(taskIndex));
          comboBoxMod.setSelectedIndex(tasks.getPriorityCategories().indexOf(tasks.getCategory(taskIndex)));
        }
      }
    });
    table.getColumnModel().getColumn(0).setPreferredWidth(52);
    table.getColumnModel().getColumn(1).setPreferredWidth(48);
    table.getColumnModel().getColumn(2).setPreferredWidth(150);
    table.getColumnModel().getColumn(3).setPreferredWidth(150);
    table.getColumnModel().getColumn(4).setPreferredWidth(20);
    table.getColumnModel().getColumn(0).setMinWidth(11);
    table.getColumnModel().getColumn(0).setMaxWidth(500);
    if (chckbxLastPrior.isSelected()){
      Integer lastPItem = tasks.getLastPriorityInCategory(comboBox.getSelectedItem().toString()) + 1;
      textFieldPrior.setText(lastPItem.toString());
    }
    comboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        refreshPriority(chckbxLastPrior, comboBox.getSelectedItem().toString());
      }
    });
    btnModify.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        if(tasks.setTask(table.getSelectedRow(), comboBoxMod.getSelectedItem().toString(), Integer.parseInt(textFieldPriorMod.getText()), textFieldTaskNameMod.getText(), textFieldTaskCommentMond.getText())){
          clearModel(model);
          loadTable(model);
        }
        else
          JOptionPane.showMessageDialog(frmGwin, "A k�vetkez� feladtn�v m�r haszn�latban van: \"" + textFieldTaskNameMod.getText() + "\"\n K�rem ellen�rizze, hogy l�tez� feladatot akar-e r�gz�teni, vagy v�lasszon m�sik nevet!", "Figyelem!",
                JOptionPane.WARNING_MESSAGE);
      }
    });
    scrollPane.setViewportView(table);
    frmGwin.getContentPane().setLayout(groupLayout);
    frmGwin.getRootPane().setDefaultButton(btnAdd);
    
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
    
    JMenuItem mntmLoad = new JMenuItem("Load");
    mntmLoad.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tasks.loadXML();
        reload(labelPriorSum, model);
      }
    });
    mnFile.add(mntmLoad);
    textFieldPriorMod.addFocusListener(new FocusAdapter() {
      @Override
      public void focusGained(FocusEvent arg0) {
        frmGwin.getRootPane().setDefaultButton(btnModify);
      }
    });
    textFieldTaskNameMod.addFocusListener(new FocusAdapter() {
      @Override
      public void focusGained(FocusEvent arg0) {
        frmGwin.getRootPane().setDefaultButton(btnModify);
      }
    });
    textFieldTaskName.addFocusListener(new FocusAdapter() {
      @Override
      public void focusGained(FocusEvent e) {
        frmGwin.getRootPane().setDefaultButton(btnAdd);
      }
    });
  }
  
  /**
   * Add elements to the given combobox uses the task list possible categories.
   * 
   * @param cbox The combobox what will contain the the categories.
   */
  public void fillCat(JComboBox cbox){
    for (String boxItem : tasks.getPriorityCategories()) {
      cbox.addItem(boxItem);
    }
  }
  

  /**
   * Adds new task into the task list and into the given table model.
   * 
   * @param pcat
   *          Priority category of the task.
   * @param prior
   *          The priority of the new task.
   * @param task
   *          The name of the new task.
   * @param comment
   *          Some information about the new task.
   * @param model
   *          The table model what into we want to insert the task.
   */
  public boolean addNewTask(String pcat, Integer prior, String task,
      String comment, DefaultTableModel model) {
    // If the add was successful, the new task will be added into the table
    if (tasks.addTask(pcat, prior, task, comment)) {
      model.addRow(new Object[] { pcat, prior, task, comment, false });
      return true;
    }
    // The Task's name must be unique. If it doesn't we show an error message.
    else {
      // textFieldTaskName.setText(task + "-2");
      JOptionPane.showMessageDialog(frmGwin,
          "The task name is already exists. Please choose a different name!",
          "Figyelem!", JOptionPane.WARNING_MESSAGE);
      return false;
    }
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
  
  /**
   * Refresh the menu strip information.
   * 
   * @param lblTasks
   *          The label what contains information about tasks.
   */
  private void refreshStatusStrip(JLabel lblTasks) {
    lblTasks.setText("Tasks: " + tasks.size());
  }
  
  public void reload(JLabel lblTasks, DefaultTableModel model) {
    refreshStatusStrip(lblTasks);
    clearModel(model);
    loadTable(model);
  }
}
