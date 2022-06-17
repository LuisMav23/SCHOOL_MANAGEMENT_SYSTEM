package SMSApp;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.border.LineBorder;

import DBManager.Database;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;

public class StudentPanel extends JPanel implements ActionListener, ItemListener	{

	private Object[] selectedStudentToRemove = null;
	private Object[] selectedStudentToEdit = null;
	private List<Object[]> searchedStudents = new ArrayList<>();
	private boolean isTableEmpty = true;

	private DefaultTableModel PersonalInfoTable = new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"STUDENT_ID", "LAST_NAME", "FIRST_NAME", "MIDDLE_NAME", "GENDER"
		}
	);

	private DefaultTableModel CourseInfoTable = new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"STUDENT_ID", "LAST_NAME", "FIRST_NAME", "MIDDLE_NAME", "PROGRAM", "YEAR", "BLOCK", "HEAD_ID", "STATUS"
		}
	);

	private DefaultTableModel ContactInfoTable = new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"STUDENT_ID", "LAST_NAME", "FIRST_NAME", "MIDDLE_NAME", "SCHOOL_EMAIL", "CONTACT_NUMBER"
		}
	);



	private JTextField txtSearchBar;
	private JPanel MainStudentPanel;
	private JButton btnSearch;
	private JButton btnSearchById;
	private JLabel lblNewLabel;
	JScrollPane scrollPane;
	private JTable table;
	private JComboBox cmbSearchOption;


	private JButton btnClear_AddPanel;
	private JButton btnRemove_RemovePanel;
	private JButton btnConfirm_AddPanel;
	private JTextField txtID_AddPanel;
	private JTextField txtLastName_AddPanel;
	private JTextField txtFirstName_AddPanel;
	private JTextField txtMiddleName_AddPanel;
	private JTextField txtDeptHeadID_AddPanel;
	private JTextField txtEmail_AddPanel;
	private JTextField txtContact_AddPanel;
	private JTextField txtLastName_RemovePanel;
	private JTextField txtFirstName_RemovePanel;
	private JTextField txtMiddleName_RemovePanel;
	private JTextField txtDeptHeadID_RemovePanel;
	private JTextField txtEmail_RemovePanel;
	private JTextField txtContact_RemovePanel;
	private JTextField txtStatus_RemovePanel;
	private JTextField txtGender_RemovePanel;
	private JTextField txtDegree_RemovePanel;
	private JTextField txtYearLevel_RemovePanel;
	private JTextField txtBlock_RemovePanel;
	private JTextField txtID_EditPanel;
	private JTextField txtLastName_EditPanel;
	private JTextField txtFirstName_EditPanel;
	private JTextField txtMiddleName_EditPanel;
	private JTextField txtDeptHeadID_EditPanel;
	private JTextField txtContact_EditPanel;
	private JTextField txtEmail_EditPanel;
	private JTabbedPane tabbedPane;
	private JPanel AddPanel;
	private JLabel lblID;
	private JComboBox cmbGender_AddPanel;
	private JComboBox cmbDegree_AddPanel;
	private JComboBox cmbYearLevel_AddPanel;
	private JComboBox cmbBlock_AddPanel;
	private JComboBox cmbStatus_AddPanel;
	private JButton btnGenerate_AddPanel;
	private JPanel RemovePanel;
	private JTextField txtID_RemovePanel;
	private JButton btnFind_RemovePanel;
	private JPanel EditPanel;
	private JComboBox cmbDegree_EditPanel;
	private JComboBox cmbGender_EditPanel;
	private JComboBox cmbYearLevel_EditPanel;
	private JComboBox cmbBlock_EditPanel;
	private JComboBox cmbStatus_EditPanel;
	private JButton btnGenerate_EditPanel;
	private JButton btnConfirm_EditPanel;
	private JButton btnFind_EditPanel;
	private JButton btnRefresh;

	/**
	 * Create the panel.
	 */
	public StudentPanel() {
		setBounds(0, 100, 1500, 663);
		setLayout(new CardLayout(0, 0));
		
		MainStudentPanel = new JPanel();
		MainStudentPanel.setLocation(-10, -91);
		MainStudentPanel.setBackground(new Color(255, 255, 255));
		add(MainStudentPanel, "name_39219436068400");
		MainStudentPanel.setLayout(null);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtSearchBar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txtSearchBar.setText("");
		txtSearchBar.setBounds(805, 9, 434, 42);
		MainStudentPanel.add(txtSearchBar);
		txtSearchBar.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBounds(1249, 15, 95, 32);
		btnSearch.addActionListener(this);
		MainStudentPanel.add(btnSearch);
		
		btnSearchById = new JButton("Search by ID");
		btnSearchById.setBackground(new Color(255, 255, 255));
		btnSearchById.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnSearchById.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearchById.setBounds(1354, 15, 125, 32);
		btnSearchById.addActionListener(this);
		MainStudentPanel.add(btnSearchById);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(574, 61, 905, 587);
		MainStudentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(PersonalInfoTable);		
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("STUDENT DATABASE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(10, 10, 554, 75);
		MainStudentPanel.add(lblNewLabel);
		
		cmbSearchOption = new JComboBox();
		cmbSearchOption.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbSearchOption.setModel(new DefaultComboBoxModel(new String[] {"Personal Info", "Course Info", "Contact Info"}));
		cmbSearchOption.setBounds(650, 16, 145, 29);
		cmbSearchOption.addItemListener(this);
		MainStudentPanel.add(cmbSearchOption);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		tabbedPane.setBounds(10, 95, 554, 553);
		MainStudentPanel.add(tabbedPane);
		
		AddPanel = new JPanel();
		AddPanel.setLayout(null);
		AddPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("ADD", null, AddPanel, null);
		
		txtID_AddPanel = new JTextField();
		txtID_AddPanel.setColumns(10);
		txtID_AddPanel.setBounds(37, 95, 109, 28);
		AddPanel.add(txtID_AddPanel);
		
		lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblID.setBounds(10, 97, 31, 19);
		AddPanel.add(lblID);
		
		txtLastName_AddPanel = new JTextField();
		txtLastName_AddPanel.setColumns(10);
		txtLastName_AddPanel.setBounds(10, 141, 159, 33);
		AddPanel.add(txtLastName_AddPanel);
		
		txtFirstName_AddPanel = new JTextField();
		txtFirstName_AddPanel.setColumns(10);
		txtFirstName_AddPanel.setBounds(172, 141, 199, 33);
		AddPanel.add(txtFirstName_AddPanel);
		
		txtMiddleName_AddPanel = new JTextField();
		txtMiddleName_AddPanel.setColumns(10);
		txtMiddleName_AddPanel.setBounds(375, 141, 165, 33);
		AddPanel.add(txtMiddleName_AddPanel);
		
		JLabel lblNewLabel_1 = new JLabel("LAST_NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(50, 185, 90, 19);
		AddPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FIRST_NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(226, 185, 90, 19);
		AddPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MIDDLE_NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(414, 184, 109, 19);
		AddPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GENDER:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 234, 64, 19);
		AddPanel.add(lblNewLabel_4);
		
		cmbGender_AddPanel = new JComboBox();
		cmbGender_AddPanel.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		cmbGender_AddPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbGender_AddPanel.setBounds(84, 234, 109, 22);
		AddPanel.add(cmbGender_AddPanel);
		
		JLabel lblNewLabel_5 = new JLabel("DEGREE_PROGRAM:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(203, 234, 139, 19);
		AddPanel.add(lblNewLabel_5);
		
		cmbDegree_AddPanel = new JComboBox();
		cmbDegree_AddPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbDegree_AddPanel.setBounds(345, 234, 195, 22);
		cmbDegree_AddPanel.addItemListener(this);
		AddPanel.add(cmbDegree_AddPanel);
		
		txtDeptHeadID_AddPanel = new JTextField();
		txtDeptHeadID_AddPanel.setEditable(false);
		txtDeptHeadID_AddPanel.setColumns(10);
		txtDeptHeadID_AddPanel.setBounds(132, 289, 159, 28);
		AddPanel.add(txtDeptHeadID_AddPanel);
		
		JLabel lblDeptheadid = new JLabel("DEPT_HEAD_ID:");
		lblDeptheadid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeptheadid.setBounds(10, 294, 112, 19);
		AddPanel.add(lblDeptheadid);
		
		JLabel lblYearlevel = new JLabel("YEAR_LEVEL:");
		lblYearlevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYearlevel.setBounds(336, 289, 90, 19);
		AddPanel.add(lblYearlevel);
		
		JLabel lblBlocknumber = new JLabel("BLOCK_NUMBER:");
		lblBlocknumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBlocknumber.setBounds(309, 334, 117, 19);
		AddPanel.add(lblBlocknumber);
		
		cmbYearLevel_AddPanel = new JComboBox();
		cmbYearLevel_AddPanel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		cmbYearLevel_AddPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbYearLevel_AddPanel.setBounds(431, 286, 109, 22);
		AddPanel.add(cmbYearLevel_AddPanel);
		
		cmbBlock_AddPanel = new JComboBox();
		cmbBlock_AddPanel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		cmbBlock_AddPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbBlock_AddPanel.setBounds(431, 331, 109, 22);
		AddPanel.add(cmbBlock_AddPanel);
		
		JLabel lblStatus = new JLabel("STATUS:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(58, 335, 64, 19);
		AddPanel.add(lblStatus);
		
		cmbStatus_AddPanel = new JComboBox();
		cmbStatus_AddPanel.setModel(new DefaultComboBoxModel(new String[] {"REGULAR", "IRREGULAR"}));
		cmbStatus_AddPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbStatus_AddPanel.setBounds(132, 335, 159, 22);
		AddPanel.add(cmbStatus_AddPanel);
		
		txtEmail_AddPanel = new JTextField();
		txtEmail_AddPanel.setEditable(false);
		txtEmail_AddPanel.setColumns(10);
		txtEmail_AddPanel.setBounds(86, 384, 240, 28);
		AddPanel.add(txtEmail_AddPanel);
		
		txtContact_AddPanel = new JTextField();
		txtContact_AddPanel.setColumns(10);
		txtContact_AddPanel.setBounds(336, 384, 204, 28);
		AddPanel.add(txtContact_AddPanel);
		
		JLabel lblSchoolemail = new JLabel("SCHOOL_EMAIL");
		lblSchoolemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSchoolemail.setBounds(149, 422, 112, 19);
		AddPanel.add(lblSchoolemail);
		
		JLabel lblContactnumber = new JLabel("CONTACT_NUMBER");
		lblContactnumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContactnumber.setBounds(377, 422, 148, 19);
		AddPanel.add(lblContactnumber);
		
		JLabel lblAction = new JLabel("ADD STUDENT");
		lblAction.setHorizontalAlignment(SwingConstants.CENTER);
		lblAction.setFont(new Font("Monospaced", Font.BOLD, 50));
		lblAction.setBounds(10, 10, 530, 66);
		AddPanel.add(lblAction);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 81, 534, 4);
		AddPanel.add(separator);
		
		btnGenerate_AddPanel = new JButton("Generate");
		btnGenerate_AddPanel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGenerate_AddPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGenerate_AddPanel.setBackground(new Color(255, 250, 250));
		btnGenerate_AddPanel.setBounds(10, 384, 73, 28);
		btnGenerate_AddPanel.addActionListener(this);
		AddPanel.add(btnGenerate_AddPanel);
		
		btnClear_AddPanel = new JButton("CLEAR");
		btnClear_AddPanel.setBounds(25, 468, 115, 32);
		AddPanel.add(btnClear_AddPanel);
		btnClear_AddPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnClear_AddPanel.setBackground(new Color(255, 250, 250));
		btnClear_AddPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
		btnConfirm_AddPanel = new JButton("CONFIRM");
		btnConfirm_AddPanel.setBounds(345, 468, 179, 32);
		AddPanel.add(btnConfirm_AddPanel);
		btnConfirm_AddPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirm_AddPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnConfirm_AddPanel.setBackground(new Color(255, 250, 250));
		btnConfirm_AddPanel.addActionListener(this);
				
		RemovePanel = new JPanel();
		tabbedPane.addTab("REMOVE", null, RemovePanel, null);
				RemovePanel.setLayout(null);
				
		btnRemove_RemovePanel = new JButton("REMOVE");
		btnRemove_RemovePanel.setBounds(184, 463, 170, 32);
		RemovePanel.add(btnRemove_RemovePanel);
		btnRemove_RemovePanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemove_RemovePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnRemove_RemovePanel.setBackground(new Color(255, 250, 250));
				
		txtID_RemovePanel = new JTextField();
		txtID_RemovePanel.setColumns(10);
		txtID_RemovePanel.setBounds(37, 95, 109, 28);
		RemovePanel.add(txtID_RemovePanel);
				
		JLabel lblID_1 = new JLabel("ID:");
		lblID_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblID_1.setBounds(10, 97, 31, 19);
		RemovePanel.add(lblID_1);
				
		txtLastName_RemovePanel = new JTextField();
		txtLastName_RemovePanel.setEditable(false);
		txtLastName_RemovePanel.setColumns(10);
		txtLastName_RemovePanel.setBounds(10, 141, 159, 33);
		RemovePanel.add(txtLastName_RemovePanel);
				
		txtFirstName_RemovePanel = new JTextField();
		txtFirstName_RemovePanel.setEditable(false);
		txtFirstName_RemovePanel.setColumns(10);
		txtFirstName_RemovePanel.setBounds(172, 141, 199, 33);
		RemovePanel.add(txtFirstName_RemovePanel);
				
		txtMiddleName_RemovePanel = new JTextField();
		txtMiddleName_RemovePanel.setEditable(false);
		txtMiddleName_RemovePanel.setColumns(10);
		txtMiddleName_RemovePanel.setBounds(375, 141, 165, 33);
		RemovePanel.add(txtMiddleName_RemovePanel);
				
		JLabel lblNewLabel_1_1 = new JLabel("LAST_NAME");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(50, 185, 90, 19);
		RemovePanel.add(lblNewLabel_1_1);
				
		JLabel lblNewLabel_2_1 = new JLabel("FIRST_NAME");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(226, 185, 90, 19);
		RemovePanel.add(lblNewLabel_2_1);
				
		JLabel lblNewLabel_3_1 = new JLabel("MIDDLE_NAME");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(414, 184, 109, 19);
		RemovePanel.add(lblNewLabel_3_1);
				
		JLabel lblAction_1 = new JLabel("REMOVE STUDENT");
		lblAction_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAction_1.setFont(new Font("Monospaced", Font.BOLD, 50));
		lblAction_1.setBounds(10, 10, 530, 66);
		RemovePanel.add(lblAction_1);
				
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 81, 534, 4);
		RemovePanel.add(separator_1);
				
		JLabel lblNewLabel_5_1 = new JLabel("DEGREE_PROGRAM:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_1.setBounds(203, 234, 139, 19);
		RemovePanel.add(lblNewLabel_5_1);
				
		JLabel lblNewLabel_4_1 = new JLabel("GENDER:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(10, 234, 64, 19);
		RemovePanel.add(lblNewLabel_4_1);
				
		JLabel lblDeptheadid_1 = new JLabel("DEPT_HEAD_ID:");
		lblDeptheadid_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeptheadid_1.setBounds(10, 294, 112, 19);
		RemovePanel.add(lblDeptheadid_1);
				
		txtDeptHeadID_RemovePanel = new JTextField();
		txtDeptHeadID_RemovePanel.setEditable(false);
		txtDeptHeadID_RemovePanel.setColumns(10);
		txtDeptHeadID_RemovePanel.setBounds(132, 289, 159, 28);
		RemovePanel.add(txtDeptHeadID_RemovePanel);
				
		JLabel lblStatus_1 = new JLabel("STATUS:");
		lblStatus_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus_1.setBounds(58, 335, 64, 19);
		RemovePanel.add(lblStatus_1);
				
		txtEmail_RemovePanel = new JTextField();
		txtEmail_RemovePanel.setEditable(false);
		txtEmail_RemovePanel.setColumns(10);
		txtEmail_RemovePanel.setBounds(10, 384, 294, 28);
		RemovePanel.add(txtEmail_RemovePanel);
				
		txtContact_RemovePanel = new JTextField();
		txtContact_RemovePanel.setEditable(false);
		txtContact_RemovePanel.setColumns(10);
		txtContact_RemovePanel.setBounds(314, 384, 226, 28);
		RemovePanel.add(txtContact_RemovePanel);
				
		JLabel lblContactnumber_1 = new JLabel("CONTACT_NUMBER");
		lblContactnumber_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContactnumber_1.setBounds(363, 422, 148, 19);
		RemovePanel.add(lblContactnumber_1);
				
		JLabel lblSchoolemail_1 = new JLabel("SCHOOL_EMAIL");
		lblSchoolemail_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSchoolemail_1.setBounds(108, 422, 112, 19);
		RemovePanel.add(lblSchoolemail_1);
				
		JLabel lblYearlevel_1 = new JLabel("YEAR_LEVEL:");
		lblYearlevel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYearlevel_1.setBounds(336, 289, 90, 19);
		RemovePanel.add(lblYearlevel_1);
				
		JLabel lblBlocknumber_1 = new JLabel("BLOCK_NUMBER:");
		lblBlocknumber_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBlocknumber_1.setBounds(309, 334, 117, 19);
		RemovePanel.add(lblBlocknumber_1);
				
		txtStatus_RemovePanel = new JTextField();
		txtStatus_RemovePanel.setEditable(false);
		txtStatus_RemovePanel.setColumns(10);
		txtStatus_RemovePanel.setBounds(132, 327, 159, 28);
		RemovePanel.add(txtStatus_RemovePanel);
				
		txtGender_RemovePanel = new JTextField();
		txtGender_RemovePanel.setEditable(false);
		txtGender_RemovePanel.setColumns(10);
		txtGender_RemovePanel.setBounds(74, 225, 119, 28);
		RemovePanel.add(txtGender_RemovePanel);
				
		txtDegree_RemovePanel = new JTextField();
		txtDegree_RemovePanel.setEditable(false);
		txtDegree_RemovePanel.setColumns(10);
		txtDegree_RemovePanel.setBounds(341, 225, 199, 28);
		RemovePanel.add(txtDegree_RemovePanel);
				
		txtYearLevel_RemovePanel = new JTextField();
		txtYearLevel_RemovePanel.setEditable(false);
		txtYearLevel_RemovePanel.setColumns(10);
		txtYearLevel_RemovePanel.setBounds(431, 280, 109, 28);
		RemovePanel.add(txtYearLevel_RemovePanel);
				
		txtBlock_RemovePanel = new JTextField();
		txtBlock_RemovePanel.setEditable(false);
		txtBlock_RemovePanel.setColumns(10);
		txtBlock_RemovePanel.setBounds(431, 326, 109, 28);
		RemovePanel.add(txtBlock_RemovePanel);
				
		btnFind_RemovePanel = new JButton("FIND");
		btnFind_RemovePanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFind_RemovePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnFind_RemovePanel.setBackground(new Color(255, 250, 250));
		btnFind_RemovePanel.setBounds(156, 95, 90, 28);
		btnFind_RemovePanel.addActionListener(this);
		RemovePanel.add(btnFind_RemovePanel);
				
		EditPanel = new JPanel();
		tabbedPane.addTab("EDIT", null, EditPanel, null);
		EditPanel.setLayout(null);
				
		txtID_EditPanel = new JTextField();
		txtID_EditPanel.setColumns(10);
		txtID_EditPanel.setBounds(37, 95, 109, 28);
		EditPanel.add(txtID_EditPanel);
				
		JLabel lblID_2 = new JLabel("ID:");
		lblID_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblID_2.setBounds(10, 97, 31, 19);
		EditPanel.add(lblID_2);
				
		txtLastName_EditPanel = new JTextField();
		txtLastName_EditPanel.setColumns(10);
		txtLastName_EditPanel.setBounds(10, 141, 159, 33);
		EditPanel.add(txtLastName_EditPanel);
				
		txtFirstName_EditPanel = new JTextField();
		txtFirstName_EditPanel.setColumns(10);
		txtFirstName_EditPanel.setBounds(172, 141, 199, 33);
		EditPanel.add(txtFirstName_EditPanel);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 81, 534, 4);
		EditPanel.add(separator_2);
				
		JLabel lblEditStudent = new JLabel("EDIT STUDENT");
		lblEditStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditStudent.setFont(new Font("Monospaced", Font.BOLD, 50));
		lblEditStudent.setBounds(10, 10, 530, 66);
		EditPanel.add(lblEditStudent);
				
		cmbDegree_EditPanel = new JComboBox();
		cmbDegree_EditPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbDegree_EditPanel.setBounds(345, 234, 195, 22);
		cmbDegree_EditPanel.addItemListener(this);
		EditPanel.add(cmbDegree_EditPanel);
				
		JLabel lblNewLabel_3_2 = new JLabel("MIDDLE_NAME");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(414, 184, 109, 19);
		EditPanel.add(lblNewLabel_3_2);
				
		txtMiddleName_EditPanel = new JTextField();
		txtMiddleName_EditPanel.setColumns(10);
		txtMiddleName_EditPanel.setBounds(375, 141, 165, 33);
		EditPanel.add(txtMiddleName_EditPanel);
				
		JLabel lblNewLabel_2_2 = new JLabel("FIRST_NAME");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(226, 185, 90, 19);
		EditPanel.add(lblNewLabel_2_2);
				
		JLabel lblNewLabel_1_2 = new JLabel("LAST_NAME");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(50, 185, 90, 19);
		EditPanel.add(lblNewLabel_1_2);
				
		JLabel lblNewLabel_5_2 = new JLabel("DEGREE_PROGRAM:");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_2.setBounds(203, 234, 139, 19);
		EditPanel.add(lblNewLabel_5_2);
				
		cmbGender_EditPanel = new JComboBox();
		cmbGender_EditPanel.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		cmbGender_EditPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbGender_EditPanel.setBounds(84, 234, 109, 22);
		EditPanel.add(cmbGender_EditPanel);
		
		JLabel lblNewLabel_4_2 = new JLabel("GENDER:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(10, 234, 64, 19);
		EditPanel.add(lblNewLabel_4_2);
				
		JLabel lblDeptheadid_2 = new JLabel("DEPT_HEAD_ID:");
		lblDeptheadid_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeptheadid_2.setBounds(10, 294, 112, 19);
		EditPanel.add(lblDeptheadid_2);
				
		txtDeptHeadID_EditPanel = new JTextField();
		txtDeptHeadID_EditPanel.setEditable(false);
		txtDeptHeadID_EditPanel.setColumns(10);
		txtDeptHeadID_EditPanel.setBounds(132, 289, 159, 28);
		EditPanel.add(txtDeptHeadID_EditPanel);
				
		cmbYearLevel_EditPanel = new JComboBox();
		cmbYearLevel_EditPanel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		cmbYearLevel_EditPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbYearLevel_EditPanel.setBounds(431, 286, 109, 22);
		EditPanel.add(cmbYearLevel_EditPanel);
				
		cmbBlock_EditPanel = new JComboBox();
		cmbBlock_EditPanel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		cmbBlock_EditPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbBlock_EditPanel.setBounds(431, 331, 109, 22);
		EditPanel.add(cmbBlock_EditPanel);
				
		JLabel lblStatus_2 = new JLabel("STATUS:");
		lblStatus_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus_2.setBounds(58, 335, 64, 19);
		EditPanel.add(lblStatus_2);
				
		cmbStatus_EditPanel = new JComboBox();
		cmbStatus_EditPanel.setModel(new DefaultComboBoxModel(new String[] {"REGULAR", "IRREGULAR"}));
		cmbStatus_EditPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbStatus_EditPanel.setBounds(132, 335, 159, 22);
		EditPanel.add(cmbStatus_EditPanel);
				
		txtContact_EditPanel = new JTextField();
		txtContact_EditPanel.setColumns(10);
		txtContact_EditPanel.setBounds(336, 384, 204, 28);
		EditPanel.add(txtContact_EditPanel);
				
		JLabel lblContactnumber_2 = new JLabel("CONTACT_NUMBER");
		lblContactnumber_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContactnumber_2.setBounds(377, 422, 148, 19);
		EditPanel.add(lblContactnumber_2);
				
		JLabel lblSchoolemail_2 = new JLabel("SCHOOL_EMAIL");
		lblSchoolemail_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSchoolemail_2.setBounds(149, 422, 112, 19);
		EditPanel.add(lblSchoolemail_2);
				
		txtEmail_EditPanel = new JTextField();
		txtEmail_EditPanel.setEditable(false);
		txtEmail_EditPanel.setColumns(10);
		txtEmail_EditPanel.setBounds(86, 384, 240, 28);
		EditPanel.add(txtEmail_EditPanel);
				
		btnGenerate_EditPanel = new JButton("Generate");
		btnGenerate_EditPanel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGenerate_EditPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGenerate_EditPanel.setBackground(new Color(255, 250, 250));
		btnGenerate_EditPanel.setBounds(10, 384, 73, 28);
		btnGenerate_EditPanel.addActionListener(this);
		EditPanel.add(btnGenerate_EditPanel);
				
		btnConfirm_EditPanel = new JButton("CONFIRM");
		btnConfirm_EditPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirm_EditPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnConfirm_EditPanel.setBackground(new Color(255, 250, 250));
		btnConfirm_EditPanel.setBounds(177, 466, 179, 32);
		btnConfirm_EditPanel.addActionListener(this);
		EditPanel.add(btnConfirm_EditPanel);
				
		btnFind_EditPanel = new JButton("FIND");
		btnFind_EditPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFind_EditPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnFind_EditPanel.setBackground(new Color(255, 250, 250));
		btnFind_EditPanel.setBounds(156, 95, 90, 28);
		btnFind_EditPanel.addActionListener(this);
		EditPanel.add(btnFind_EditPanel);
				
		JLabel lblYearlevel_2 = new JLabel("YEAR_LEVEL:");
		lblYearlevel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYearlevel_2.setBounds(331, 289, 90, 19);
		EditPanel.add(lblYearlevel_2);
		
		JLabel lblBlocknumber_2 = new JLabel("BLOCK_NUMBER:");
		lblBlocknumber_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBlocknumber_2.setBounds(304, 334, 117, 19);
		EditPanel.add(lblBlocknumber_2);
				
		btnRefresh = new JButton("REFRESH");
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRefresh.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnRefresh.setBackground(Color.WHITE);
		btnRefresh.setBounds(574, 15, 66, 32);
		btnRefresh.addActionListener(this);
		MainStudentPanel.add(btnRefresh);
		btnRemove_RemovePanel.addActionListener(this);
		btnClear_AddPanel.addActionListener(this);

		refresh();
	}

	/********************** EVENT HANDLERS **********************/
	@Override
	public void actionPerformed(ActionEvent e) {

	// SEARCH PANEL ------------------------
		if (e.getSource() == btnSearch){
			searchedStudents = Database.searchStudent(txtSearchBar.getText());
			if (isTableEmpty){
				fillTable((DefaultTableModel) table.getModel());
				return;
			}
			else {
				clearTable(PersonalInfoTable);
				clearTable(CourseInfoTable);
				clearTable(ContactInfoTable);
				isTableEmpty = true;
				fillTable((DefaultTableModel) table.getModel());
				return;
			}
		}

		if (e.getSource() == btnSearchById){
			try{
				searchedStudents = Database.searchStudentByID(Integer.parseInt(txtSearchBar.getText()));
				if (isTableEmpty){
					fillTable((DefaultTableModel) table.getModel());
					return;
				}
				else {
					clearTable(PersonalInfoTable);
					clearTable(CourseInfoTable);
					clearTable(ContactInfoTable);
					isTableEmpty = true;
					fillTable((DefaultTableModel) table.getModel());
				}
				return;
			}
			catch (Exception ex) {
				// ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "INVALID ID", "INVALID", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		if (e.getSource() == btnRefresh){
			refresh();
			return;
		}
		
		
	// ADD PANEL -----------------------------
		if (e.getSource() == btnClear_AddPanel){
			
			txtID_AddPanel.setText(null);
			txtLastName_AddPanel.setText(null);
			txtFirstName_AddPanel.setText(null);
			txtMiddleName_AddPanel.setText(null);
			txtEmail_AddPanel.setText(null);
			txtContact_AddPanel.setText(null);
			cmbGender_AddPanel.setSelectedItem((Object)"M");
			cmbDegree_AddPanel.setSelectedItem((Object)"BSCE");
			cmbYearLevel_AddPanel.setSelectedItem((Object)"1");
			cmbBlock_AddPanel.setSelectedItem((Object)"1");
			return;
		}

		if (e.getSource() == btnConfirm_AddPanel){
			addStudent();
			return;
		}

		if (e.getSource() == btnGenerate_AddPanel) {
			if (!txtFirstName_AddPanel.getText().isBlank() && !txtLastName_AddPanel.getText().isBlank() && isDigit(txtID_AddPanel.getText())) {
				txtEmail_AddPanel.setText(Database.generateEmail(txtLastName_AddPanel.getText(), txtFirstName_AddPanel.getText(), 
				txtMiddleName_AddPanel.getText(), Integer.parseInt(txtID_AddPanel.getText())));
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "INVALID FIRST_NAME, LAST_NAME, OR ID", "INVALID", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

	//REMOVE PANEL ---------------------------------------
		if(e.getSource() == btnFind_RemovePanel) {
			if (isDigit(txtID_RemovePanel.getText())){
				selectedStudentToRemove = Database.getStudentInfo(Integer.parseInt(txtID_RemovePanel.getText()));
				if (selectedStudentToRemove != null) {
					txtLastName_RemovePanel.setText((String)selectedStudentToRemove[1]);
					txtFirstName_RemovePanel.setText((String)selectedStudentToRemove[2]);
					txtMiddleName_RemovePanel.setText((String)selectedStudentToRemove[3]);
					txtGender_RemovePanel.setText((String)selectedStudentToRemove[4]);
					txtDegree_RemovePanel.setText((String)selectedStudentToRemove[5]);
					txtYearLevel_RemovePanel.setText(Integer.toString((Integer)selectedStudentToRemove[6]));
					txtBlock_RemovePanel.setText(Integer.toString((Integer)selectedStudentToRemove[7]));
					txtDeptHeadID_RemovePanel.setText(Integer.toString((Integer)selectedStudentToRemove[8]));
					txtStatus_RemovePanel.setText((String)selectedStudentToRemove[9]);
					txtEmail_RemovePanel.setText((String)selectedStudentToRemove[10]);
					txtContact_RemovePanel.setText((String)selectedStudentToRemove[11]);
					return;
				}
				else{
					JOptionPane.showMessageDialog(this, "STUDENT DOES NOT EXIST", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "INVALID ID", "INVALID", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		if (e.getSource() == btnRemove_RemovePanel) {
			if(selectedStudentToRemove != null) {
				if (Database.deleteStudent((Integer)selectedStudentToRemove[0])){
					JOptionPane.showMessageDialog(this, "STUDENT SUCCESSFULY REMOVED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				else {
					JOptionPane.showMessageDialog(this, "ERROR REMOVING STUDENT", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "NO STUDENT IS SELECTED", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}




	//EDIT PANEL ---------------------------------------------
		if(e.getSource() == btnFind_EditPanel) {
			if (isDigit(txtID_EditPanel.getText())){
				selectedStudentToEdit = Database.getStudentInfo(Integer.parseInt(txtID_EditPanel.getText()));
				if (selectedStudentToEdit != null) {
					txtLastName_EditPanel.setText((String)selectedStudentToEdit[1]);
					txtFirstName_EditPanel.setText((String)selectedStudentToEdit[2]);
					txtMiddleName_EditPanel.setText((String)selectedStudentToEdit[3]);
					cmbGender_EditPanel.setSelectedItem(selectedStudentToEdit[4]);
					cmbDegree_EditPanel.setSelectedItem(selectedStudentToEdit[5]);
					cmbYearLevel_EditPanel.setSelectedItem(Integer.toString((Integer)selectedStudentToEdit[6]));
					cmbBlock_EditPanel.setSelectedItem(Integer.toString((Integer)selectedStudentToEdit[7]));
					txtDeptHeadID_EditPanel.setText(Integer.toString((Integer)selectedStudentToEdit[8]));
					cmbStatus_EditPanel.setSelectedItem(selectedStudentToEdit[9]);
					txtEmail_EditPanel.setText((String)selectedStudentToEdit[10]);
					txtContact_EditPanel.setText((String)selectedStudentToEdit[11]);
					return;
				}
				else{
					JOptionPane.showMessageDialog(this, "STUDENT DOES NOT EXIST", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "INVALID ID", "INVALID", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}

		if (e.getSource() == btnConfirm_EditPanel){
			editStudent();
			return;
		}

		if (e.getSource() == btnGenerate_EditPanel) {
			if (!txtFirstName_EditPanel.getText().isBlank() && !txtLastName_EditPanel.getText().isBlank() && isDigit(txtID_EditPanel.getText())) {
				txtEmail_EditPanel.setText(Database.generateEmail(txtLastName_EditPanel.getText(), txtFirstName_EditPanel.getText(), 
				txtMiddleName_EditPanel.getText(), Integer.parseInt(txtID_EditPanel.getText())));
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "INVALID FIRST_NAME, LAST_NAME, OR ID", "INVALID", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}



	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbSearchOption){
			setTableModel((String)cmbSearchOption.getSelectedItem());
			return;
		}
		
		if (e.getSource() == cmbDegree_AddPanel) {
			txtDeptHeadID_AddPanel.setText(Integer.toString(Database.getCourseHeadID((String)cmbDegree_AddPanel.getSelectedItem())));
		}
		
	}

	/*********************** END OF EVENT HANDLERS ***********************/

	private void setTableModel(String Model) {

		if (Model.equalsIgnoreCase("Personal Info")) {
			
			table.setModel(PersonalInfoTable);
			table.getColumnModel().getColumn(0).setPreferredWidth(80);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
		}
		else if (Model.equalsIgnoreCase("Course Info")) {

			table.setModel(CourseInfoTable);
			table.getColumnModel().getColumn(0).setPreferredWidth(80);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(60);
			table.getColumnModel().getColumn(6).setPreferredWidth(60);
			table.getColumnModel().getColumn(7).setPreferredWidth(60);
			table.getColumnModel().getColumn(8).setPreferredWidth(80);
		}
		else if (Model.equalsIgnoreCase("Contact Info")) {

			table.setModel(ContactInfoTable);
			table.getColumnModel().getColumn(0).setPreferredWidth(80);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(150);
			table.getColumnModel().getColumn(5).setPreferredWidth(110);
		}


	}

	
	/********************************************************/

	private void addStudent(){
		
		if (!txtFirstName_AddPanel.getText().isBlank() && 
			!txtLastName_AddPanel.getText().isBlank() && 
			isDigit(txtID_AddPanel.getText()) &&
			!txtEmail_AddPanel.getText().isBlank() &&
			isDigit(txtContact_AddPanel.getText()))
			{
				if(Database.searchStudentByID(Integer.parseInt(txtID_AddPanel.getText())).isEmpty()) {

					Object[] info = new Object[] {
						Integer.parseInt(txtID_AddPanel.getText()),
						txtLastName_AddPanel.getText(),
						txtFirstName_AddPanel.getText(),
						txtMiddleName_AddPanel.getText(),
						(String)cmbGender_AddPanel.getSelectedItem(),
						(String)cmbDegree_AddPanel.getSelectedItem(),
						Integer.parseInt((String)cmbYearLevel_AddPanel.getSelectedItem()),
						Integer.parseInt((String)cmbBlock_AddPanel.getSelectedItem()),
						Integer.parseInt(txtDeptHeadID_AddPanel.getText()),
						(String)cmbStatus_AddPanel.getSelectedItem(),
						txtEmail_AddPanel.getText(),
						txtContact_AddPanel.getText()
					};
					if(Database.addStudent(info)){
						JOptionPane.showMessageDialog(this, "STUDENT SUCCESSFULY ADDED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(this, "ERROR ADDING STUDENT", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(this, "STUDENT WITH ID:" + txtID_AddPanel.getText() + "\n ALREADY EXIST", "INVALID INFO", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		else {
			JOptionPane.showMessageDialog(this, "STUDENT INFORMATION IS INVALID", "INVALID INFO", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void editStudent() {
		if (!txtFirstName_EditPanel.getText().isBlank() && 
			!txtLastName_EditPanel.getText().isBlank() && 
			isDigit(txtID_EditPanel.getText()) &&
			!txtEmail_EditPanel.getText().isBlank() &&
			isDigit(txtContact_EditPanel.getText()))
			{
				Object[] info = new Object[] {
					txtLastName_EditPanel.getText(),
					txtFirstName_EditPanel.getText(),
					txtMiddleName_EditPanel.getText(),
					(String)cmbGender_EditPanel.getSelectedItem(),
					(String)cmbDegree_EditPanel.getSelectedItem(),
					Integer.parseInt((String)cmbYearLevel_EditPanel.getSelectedItem()),
					Integer.parseInt((String)cmbBlock_EditPanel.getSelectedItem()),
					Integer.parseInt(txtDeptHeadID_EditPanel.getText()),
					(String)cmbStatus_EditPanel.getSelectedItem(),
					txtEmail_EditPanel.getText(),
					txtContact_EditPanel.getText()
				};

				if(Database.updateStudent((int)selectedStudentToEdit[0],info)){
					JOptionPane.showMessageDialog(this, "STUDENT SUCCESSFULY EDITED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(this, "ERROR EDITING STUDENT", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}

		else {
			JOptionPane.showMessageDialog(this, "STUDENT INFORMATION IS INVALID", "INVALID INFO", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	/********************************************************/

	private void clearTable(DefaultTableModel TableModel){
		if (TableModel.getRowCount() != 0){
			for (int i = TableModel.getRowCount() - 1; i >= 0; i--){
				TableModel.removeRow(i);
			}
		}
	}

	private void fillTable(DefaultTableModel TableModel) {
		for (Object[] obj : searchedStudents){

			PersonalInfoTable.addRow(new Object[]{
				obj[0], //STUDENT_ID
				obj[1], //LAST_NAME
				obj[2], //FIRST_NAME
				obj[3], //MIDDLE_NAME
				obj[4]  //GENDER
			});

			CourseInfoTable.addRow(new Object[]{
				obj[0], //STUDENT_ID
				obj[1], //LAST_NAME
				obj[2], //FIRST_NAME
				obj[3], //MIDDLE_NAME
				obj[5], //DEGREE_PROGRAM
				obj[6], //YEAR_LEVEL
				obj[7], //BLOCK_NUMBER
				obj[8], //DEPARTMENT_HEAD_ID
				obj[9]  //STATUS
			});

			ContactInfoTable.addRow(new Object[]{
				obj[0], //STUDENT_ID
				obj[1], //LAST_NAME
				obj[2], //FIRST_NAME
				obj[3], //MIDDLE_NAME
				obj[10],//SCHOOL_EMAIL
				obj[11] //CONTACT_NUMBER
			});
		}
		isTableEmpty = false;
	}

	private void refresh(){
		var course = Database.getAllCourse();
		String[] cmbModel = new String[course.size()];
		for (int i = 0; i < cmbModel.length; i++){
			cmbModel[i] = course.get(i);
		}
		cmbDegree_AddPanel.setModel((new DefaultComboBoxModel(cmbModel)));
		cmbDegree_EditPanel.setModel((new DefaultComboBoxModel(cmbModel)));
		Database.updateStudentDB();
	}

	private boolean isDigit(String id){
		if (id.matches("[0-9]+")){
			return true;
		}else {
			return false;
		}
	}
}
