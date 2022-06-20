package SMSApp;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DBManager.Database;

import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;

public class CoursePanel extends JPanel implements ActionListener, ItemListener {
	

	private String courseSelected = null;
	private DefaultTableModel courseTableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DEPARTMENT_ID", "DEGREE_PROGRAM", "DEPARTMENT_HEAD_ID", "NUMBER_OF_STUDENTS", "NUMBER_OF_FACULTY"
			}
		);	


	private DefaultTableModel studentsListModel = new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"STUDENT_NAME", "YEAR", "BLOCK", "STATUS"
		}
	);

	private DefaultTableModel facultyListModel = new DefaultTableModel(
		new Object[][] {
			{null, null, null, null},
		},
		new String[] {
			"FACULTY_NAME", "DEPARTMENT_ID", "SUPER_ID", "SALARY"
		}
	);
	
	private JTable tableCourse;
	private JTable tableList;
	private JButton btnRefresh;
	private JComboBox cmbListOption;
	private JPanel panel;
	private JComboBox cmbCourse;
	

	/**
	 * Create the panel.
	 */
	public CoursePanel() {
		setBackground(Color.WHITE);
		setBounds(0, 100, 1500, 663);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 346, 896, 307);
		add(scrollPane);
		
		tableCourse = new JTable();
		tableCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableCourse.setModel(courseTableModel);
		tableCourse.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableCourse.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableCourse.getColumnModel().getColumn(2).setPreferredWidth(40);
		tableCourse.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableCourse.getColumnModel().getColumn(4).setPreferredWidth(50);
		scrollPane.setViewportView(tableCourse);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(916, 68, 564, 585);
		add(scrollPane_1);
		
		tableList = new JTable();
		tableList.setModel(studentsListModel);
		scrollPane_1.setViewportView(tableList);
		tableList.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableList.getColumnModel().getColumn(1).setPreferredWidth(20);
		tableList.getColumnModel().getColumn(2).setPreferredWidth(20);
		tableList.getColumnModel().getColumn(3).setPreferredWidth(70);
		
		btnRefresh = new JButton("REFRESH");
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRefresh.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnRefresh.setBackground(Color.WHITE);
		btnRefresh.setBounds(915, 26, 66, 32);
		btnRefresh.addActionListener(this);
		add(btnRefresh);
		
		cmbListOption = new JComboBox();
		cmbListOption.setModel(new DefaultComboBoxModel(new String[] {"STUDENTS", "FACULTY"}));
		cmbListOption.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbListOption.setBounds(1334, 27, 145, 29);
		cmbListOption.addItemListener(this);
		add(cmbListOption);
		
		JLabel lblCourseDatabase = new JLabel("COURSE DATABASE");
		lblCourseDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseDatabase.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblCourseDatabase.setBounds(10, 10, 896, 75);
		add(lblCourseDatabase);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
		panel.setBounds(10, 102, 896, 234);
		add(panel);
		
		cmbCourse = new JComboBox();
		cmbCourse.setModel(new DefaultComboBoxModel(new String[] {}));
		cmbCourse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbCourse.setBounds(1081, 27, 145, 29);
		cmbCourse.addItemListener(this);
		add(cmbCourse);
		refresh();
		fillTableList();
		fillCourseTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRefresh){
			refresh();
		}
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbCourse) {
			fillTableList();
			return;
		}

		if (e.getSource() == cmbListOption) {
			if (cmbListOption.getSelectedItem().equals("STUDENTS")){
				tableList.setModel(studentsListModel);
				return;
			}
			else if (cmbListOption.getSelectedItem().equals("FACULTY")) {
				tableList.setModel(facultyListModel);
				return;
			}
		}
	}

	private void clearTable(DefaultTableModel TableModel){
		if (TableModel.getRowCount() != 0){
			for (int i = TableModel.getRowCount() - 1; i >= 0; i--){
				TableModel.removeRow(i);
			}
		}
	}

	private void refresh(){
		var course = Database.getAllCourse();
		String[] cmbModel = new String[course.size()];
		for (int i = 0; i < cmbModel.length; i++){
			cmbModel[i] = course.get(i);
		}
		cmbCourse.setModel((new DefaultComboBoxModel(cmbModel)));
		Database.updateStudentDB();
	}

	private void fillTableList(){
		clearTable(studentsListModel);
		clearTable(facultyListModel);
		var studentlist = Database.searchStudentByCourse((String) cmbCourse.getSelectedItem());
		for (Object[] objStudent : studentlist){
			studentsListModel.addRow(new Object[]{
				objStudent[2] + " " + objStudent[3] + " " + objStudent[1],
				objStudent[6],
				objStudent[7],
				objStudent[9]
			});
		}
		var facultylist = Database.searchfacultyByDeptID((String) cmbCourse.getSelectedItem());
		for (Object[] objfaculty : facultylist){
			facultyListModel.addRow(new Object[]{
				objfaculty[2] + " " + objfaculty[3] + " " + objfaculty[1],
				objfaculty[5],
				objfaculty[6],
				objfaculty[7]
			});
		}
	}

	private void fillCourseTable(){
		clearTable(courseTableModel);
		var courselist = Database.getCourseInfoList();
		for (Object[] objCourse : courselist){
				courseTableModel.addRow(new Object[]{
				objCourse[0],
				objCourse[1],
				objCourse[2],
				objCourse[3],
				objCourse[4]
			});
		}
	}
}
