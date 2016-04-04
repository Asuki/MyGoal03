package myGoal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import task.SimplyTaskList;

import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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

    Box horizontalBox_1 = Box.createHorizontalBox();

    Box horizontalBox_2 = Box.createHorizontalBox();

    Box horizontalBox_3 = Box.createHorizontalBox();

    JLabel label = new JLabel("P. category");

    Box horizontalBox_4 = Box.createHorizontalBox();

    JScrollPane scrollPane = new JScrollPane();

    Box horizontalBox = Box.createHorizontalBox();

    JLabel lblTasks = new JLabel("Tasks: 0");

    JLabel lblPriorCategory = new JLabel("P. category");

    JLabel lblPriority = new JLabel("                    Priority        ");

    comboBoxPriorCat = new JComboBox<String>();
    comboBoxPriorCat.setMaximumRowCount(10);

    JCheckBox chckbxLastPriority = new JCheckBox("Last priority");
    chckbxLastPriority.setSelected(true);

    textFieldPrior = new JTextField();
    textFieldPrior.setColumns(6);

    JSeparator separator = new JSeparator();

    textFieldTaskName = new JTextField();
    textFieldTaskName.setColumns(20);

    textFieldTaskComment = new JTextField();
    textFieldTaskComment.setColumns(35);

    JButton btnAdd = new JButton("Add");

    Component horizontalGlue = Box.createHorizontalGlue();

    JLabel lblTask = new JLabel(
        "   Task                                                           ");

    JLabel lblCommentsomeInformation = new JLabel(
        "   Comment (some information about the task)");

    JComboBox<String> comboBoxPriorCatMod = new JComboBox<String>();

    // Filling up the comboboxes with the possible categories.
    fillCat(comboBoxPriorCat);
    fillCat(comboBoxPriorCatMod);

    Component verticalStrut_12 = Box.createVerticalStrut(20);

    Component verticalStrut_10 = Box.createVerticalStrut(20);

    Component verticalStrut_16 = Box.createVerticalStrut(20);

    Component verticalStrut_15 = Box.createVerticalStrut(20);

    Component verticalStrut_18 = Box.createVerticalStrut(20);

    Component verticalStrut_17 = Box.createVerticalStrut(20);

    Component verticalStrut_19 = Box.createVerticalStrut(20);

    Component verticalStrut_14 = Box.createVerticalStrut(20);

    Component verticalStrut_20 = Box.createVerticalStrut(20);

    Component verticalStrut_13 = Box.createVerticalStrut(20);

    Component verticalStrut_11 = Box.createVerticalStrut(20);

    textFieldPriorMod = new JTextField();
    textFieldPriorMod.setColumns(6);

    textFieldTaskNameMod = new JTextField();
    textFieldTaskNameMod.setColumns(20);

    textFieldTaskCommentMod = new JTextField();
    textFieldTaskCommentMod.setColumns(35);

    JButton btnModify = new JButton("Modify");

    JLabel label_1 = new JLabel("   Priority        ");

    JLabel label_2 = new JLabel(
        "   Task                                                           ");

    JLabel label_3 = new JLabel("   Comment (some information about the task)");

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

    refreshPriority(chckbxLastPriority,
        comboBoxPriorCat.getSelectedItem().toString());

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
    DefaultTableModel model = new DefaultTableModel(new Object[][] {},
        new String[] { "Prior.cat.", "Priority", "Task", "Comment",
            "Finished" }) {
      Class[] columnTypes = new Class[] { String.class, Integer.class,
          String.class, String.class, Boolean.class };

      public Class getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
      }
    };

    // Add a new task into the task list and into the table.
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (addNewTask(comboBoxPriorCat.getSelectedItem().toString(),
            Integer.parseInt(textFieldPrior.getText()),
            textFieldTaskName.getText(), textFieldTaskComment.getText(),
            model)) {
          reload(lblTasks, model);
          clearFields(chckbxLastPriority,
              comboBoxPriorCat.getSelectedItem().toString());
        }
      }
    });

    btnModify.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (tasks.setTask(table.getSelectedRow(),
            comboBoxPriorCatMod.getSelectedItem().toString(),
            Integer.parseInt(textFieldPriorMod.getText()),
            textFieldTaskNameMod.getText(),
            textFieldTaskCommentMod.getText())) {
          clearModel(model);
          loadTable(model);
        } else
          JOptionPane.showMessageDialog(frmGwin,
              "A következő feladtnév már használatban van: \""
                  + textFieldTaskNameMod.getText()
                  + "\"\n Kérem ellenőrizze, hogy létező feladatot akar-e rögzíteni, vagy válasszon másik nevet!",
              "Figyelem!", JOptionPane.WARNING_MESSAGE);
      }
    });

    table = new JTable(model);
    table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        if (table.getValueAt(table.getSelectedRow(), 4).toString() == "true") {
          tasks.finishTask(table.getSelectedRow());
          // model.removeRow(table.getSelectedRow());
          refreshPriority(chckbxLastPriority,
              comboBoxPriorCat.getSelectedItem().toString());
          reload(lblTasks, model);
        } else {
          Integer taskIndex = table.getSelectedRow();
          textFieldPriorMod.setText(tasks.getPriority(taskIndex) + "");
          textFieldTaskNameMod.setText(tasks.getTaskName(taskIndex));
          textFieldTaskCommentMod.setText(tasks.getTaskComment(taskIndex));
          comboBoxPriorCatMod.setSelectedIndex(tasks.getPriorityCategories()
              .indexOf(tasks.getCategory(taskIndex)));
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
    frmGwin.getContentPane().setLayout(new MigLayout("", "[1px][1px][3px][28px][1px][3px][1px][3px][4px][1px][3px][1px][3px][4px][4px][1px][3px][1px][3px][1px][3px][1px][3px][43px][4px][7px][1px][46px][4px][1px][4px][114px][4px][35px][4px][9px][4px][38px][4px][192px][4px][48px][4px][149px]", "[1px][14px][23px][1px][14px][23px][255px][14px]"));
    frmGwin.getContentPane().add(horizontalBox_1, "cell 1 1,alignx left,aligny center");
    frmGwin.getContentPane().add(horizontalBox_2, "cell 1 2,alignx left,aligny center");
    frmGwin.getContentPane().add(horizontalBox_3, "cell 1 3,alignx left,aligny top");
    frmGwin.getContentPane().add(label, "cell 1 4 13 1,alignx left,aligny top");
    frmGwin.getContentPane().add(horizontalBox_4, "cell 1 5,alignx left,aligny top");
    frmGwin.getContentPane().add(scrollPane, "cell 1 6 43 1,grow");
    frmGwin.getContentPane().add(horizontalBox, "cell 1 7,alignx left,aligny center");
    frmGwin.getContentPane().add(lblTasks, "cell 3 7 6 1,alignx left,aligny top");
    frmGwin.getContentPane().add(lblPriorCategory, "cell 3 1 12 1,alignx left,aligny top");
    frmGwin.getContentPane().add(lblPriority, "cell 17 1 13 1,alignx left,aligny top");
    frmGwin.getContentPane().add(comboBoxPriorCat, "cell 3 2,alignx left,aligny center");
    frmGwin.getContentPane().add(chckbxLastPriority, "cell 6 2 18 1,alignx left,aligny top");
    frmGwin.getContentPane().add(textFieldPrior, "cell 25 2 3 1,alignx left,aligny center");
    frmGwin.getContentPane().add(separator, "cell 29 2,growx,aligny center");
    frmGwin.getContentPane().add(textFieldTaskName, "cell 31 2 5 1,alignx left,aligny center");
    frmGwin.getContentPane().add(textFieldTaskComment, "cell 37 2 5 1,alignx left,aligny center");
    frmGwin.getContentPane().add(btnAdd, "cell 43 2,alignx left,aligny top");
    frmGwin.getContentPane().add(horizontalGlue, "cell 0 0,alignx left,aligny top");
    frmGwin.getContentPane().add(lblTask, "cell 31 1 7 1,alignx left,aligny top");
    frmGwin.getContentPane().add(lblCommentsomeInformation, "cell 39 1 3 1,alignx left,aligny top");
    frmGwin.getContentPane().add(comboBoxPriorCatMod, "cell 1 5 3 1,alignx left,aligny center");
    frmGwin.getContentPane().add(verticalStrut_12, "cell 4 5,growx,aligny center");
    frmGwin.getContentPane().add(verticalStrut_10, "cell 6 5,growx,aligny center");
    frmGwin.getContentPane().add(verticalStrut_16, "cell 8 5,growx,aligny center");
    frmGwin.getContentPane().add(verticalStrut_15, "cell 9 5,growx,aligny center");
    frmGwin.getContentPane().add(verticalStrut_18, "cell 11 5,growx,aligny center");
    frmGwin.getContentPane().add(verticalStrut_17, "cell 13 5,growx,aligny center");
    frmGwin.getContentPane().add(verticalStrut_19, "cell 14 5,growx,aligny center");
    frmGwin.getContentPane().add(verticalStrut_14, "cell 15 5,growx,aligny center");
    frmGwin.getContentPane().add(verticalStrut_20, "cell 17 5,growx,aligny center");
    frmGwin.getContentPane().add(verticalStrut_13, "cell 19 5,growx,aligny center");
    frmGwin.getContentPane().add(verticalStrut_11, "cell 21 5,growx,aligny center");
    frmGwin.getContentPane().add(textFieldPriorMod, "cell 23 5 3 1,alignx left,aligny center");
    frmGwin.getContentPane().add(textFieldTaskNameMod, "cell 27 5 5 1,alignx right,aligny center");
    frmGwin.getContentPane().add(textFieldTaskCommentMod, "cell 33 5 7 1,alignx left,aligny center");
    frmGwin.getContentPane().add(btnModify, "cell 41 5 3 1,alignx left,aligny top");
    frmGwin.getContentPane().add(label_1, "cell 15 4 11 1,alignx left,aligny top");
    frmGwin.getContentPane().add(label_2, "cell 27 4 7 1,alignx left,aligny top");
    frmGwin.getContentPane().add(label_3, "cell 35 4 5 1,alignx left,aligny top");

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
        refreshPriority(chckbxLastPriority,
            comboBoxPriorCat.getSelectedItem().toString());
      }
    });

  }

  /**
   * Add elements to the given combobox from the task list's possible
   * categories.
   * 
   * @param cbox
   *          The combobox what will contain the the categories.
   */
  public void fillCat(JComboBox<String> cbox) {
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
          "A következő feladtnév már használatban van: \"" + task
              + "\"\n Kérem ellenőrizze, hogy létező feladatot akar-e rögzíteni, vagy válasszon másik nevet!",
          "Figyelem!", JOptionPane.WARNING_MESSAGE);
      return false;
    }
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

  /**
   * Load the task list into the given table model.
   * 
   * @param model
   *          The table model what will contain the task list.
   */
  public void loadTable(DefaultTableModel model) {
    for (Integer i = 0; i < tasks.getTasks().size(); i++) {
      model.addRow(new Object[] { tasks.getTaskCategory(i),
          tasks.getPriority(i), tasks.getTaskName(i), tasks.getTaskComment(i),
          tasks.getIsFinished(i) });
    }
  }

  /**
   * Delete all element of the given model.
   * 
   * @param model
   *          The model what we want to empty.
   */
  private void clearModel(DefaultTableModel model) {
    int size = model.getRowCount();
    for (int i = 0; i < size; i++) {
      model.removeRow(0);
    }
  }

  /**
   * Sets the text field back to normal.
   * 
   * @param lastPrior
   *          The checkbox what contains information about the usage.
   * @param priorCat
   *          The priority category what's last element we will set in the
   *          priority text field.
   */
  public void clearFields(JCheckBox lastPrior, String priorCat) {
    refreshPriority(lastPrior, priorCat);
    textFieldTaskName.setText("");
    // textFieldTaskName.setText(textFieldPrior.getText());
    textFieldTaskComment.setText("");
  }

  /**
   * In the Priority's text field sets the last priority in the category if we
   * want to use the last priority and sets to empty otherwise.
   * 
   * @param lastPrior
   *          The checkbox what contains information about the usage.
   * @param priorCat
   *          The priority category what's last element we will set in the
   *          priority text field.
   */
  public void refreshPriority(JCheckBox lastPrior, String priorCat) {
    if (lastPrior.isSelected()) {
      Integer lastPItem = tasks.getLastPriorityInCategory(priorCat) + 1;
      textFieldPrior.setText(lastPItem.toString());
    } else
      textFieldPrior.setText("");

  }

  public void reload(JLabel lblTasks, DefaultTableModel model) {
    refreshStatusStrip(lblTasks);
    clearModel(model);
    loadTable(model);
  }
}
