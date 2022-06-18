package SMSApp;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import DBManager.Database;

import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class FacultyPanel extends JPanel implements ActionListener, ItemListener	{

	private Object[] selectedFacultyToRemove = null;
	private Object[] selectedFacultyToEdit = null;
	private List<Object[]> searchedFaculty = new ArrayList<>();
	private boolean isTableEmpty = true;

	private DefaultTableModel PersonalInfoTable = new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"FACULTY_ID", "LAST_NAME", "FIRST_NAME", "MIDDLE_NAME", "GENDER"
		}
	);

	private DefaultTableModel CourseInfoTable = new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"FACULTY_ID", "LAST_NAME", "FIRST_NAME", "MIDDLE_NAME", "DEPARTMENT_ID", "SUPER_ID", "SALARY"
		}
	);

	private DefaultTableModel ContactInfoTable = new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"FACULTY_ID", "LAST_NAME", "FIRST_NAME", "MIDDLE_NAME", "FACULTY_EMAIL", "CONTACT_NUMBER"
		}
	);




	private JTextField txtID_AddPanel;
	private JTabbedPane tabbedPane; 
	private JTextField txtLastName_AddPanel;
	private JTextField txtFirstName_AddPanel;
	private JTextField txtMiddleName_AddPanel;
	private JTextField txtEmail_AddPanel;
	private JTextField txtContact_AddPanel;
	private JComboBox cmbGender_AddPanel;
	private JComboBox cmbDeptID_AddPanel;
	private JButton btnGenerate_AddPanel;
	private JButton btnClear_AddPanel;
	private JButton btnConfirm_AddPanel;
	
	
	private JTextField txtID_RemovePanel;
	private JButton btnRemove_RemovePanel;
	private JButton btnFind_RemovePanel;
	
	
	private JTextField txtID_EditPanel;
	private JTextField txtSalary_AddPanel;
	private JTextField txtLastName_EditPanel;
	private JTextField txtFirstName_EditPanel;
	private JTextField txtMiddleName_EditPanel;
	private JTextField txtEmail_EditPanel;
	private JTextField txtContact_EditPanel;
	private JTextField txtSalary_EditPanel;
	private JTextField txtLastName_RemovePanel;
	private JTextField txtFirstName_RemovePanel;
	private JTextField txtMiddleName_RemovePanel;
	private JTextField txtEmail_RemovePanel;
	private JTextField txtContact_RemovePanel;
	private JTextField txtSalary_RemovePanel;
	private JTextField txtSuperID_RemovePanel;
	private JTextField txtDeptID_RemovePanel;
	private JTextField txtGender_RemovePanel;
	private JTextField txtSearchBar;
	private JTable table;
	private JButton btnConfirm_EditPanel;
	private JButton btnFind_EditPanel;
	private JComboBox cmbGender_EditPanel;
	private JComboBox cmbDeptID_EditPanel;
	private JButton btnGenerate_EditPanel;
	private JButton btnSearchById;
	private JButton btnSearch;
	private JComboBox cmbSearchOption;
	private JButton btnRefresh;
	private JTextField txtSuperID_AddPanel;
	private JTextField txtSuperID_EditPanel;





	/**
	 * Create the panel.
	 */
	public FacultyPanel() {
		setBackground(Color.WHITE);
		setBounds(0, 100, 1500, 663);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FACULTY DATABASE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(10, 10, 554, 75);
		add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(10, 95, 554, 553);
		add(tabbedPane);
		
		JPanel AddPanel = new JPanel();
		AddPanel.setLayout(null);
		AddPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("ADD", null, AddPanel, null);
		
		txtID_AddPanel = new JTextField();
		txtID_AddPanel.setColumns(10);
		txtID_AddPanel.setBounds(37, 95, 109, 28);
		AddPanel.add(txtID_AddPanel);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblID.setBounds(10, 97, 31, 19);
		AddPanel.add(lblID);
		
		txtLastName_AddPanel = new JTextField();
		txtLastName_AddPanel.setColumns(10);
		txtLastName_AddPanel.setBounds(10, 157, 159, 33);
		AddPanel.add(txtLastName_AddPanel);
		
		txtFirstName_AddPanel = new JTextField();
		txtFirstName_AddPanel.setColumns(10);
		txtFirstName_AddPanel.setBounds(172, 157, 199, 33);
		AddPanel.add(txtFirstName_AddPanel);
		
		txtMiddleName_AddPanel = new JTextField();
		txtMiddleName_AddPanel.setColumns(10);
		txtMiddleName_AddPanel.setBounds(375, 157, 165, 33);
		AddPanel.add(txtMiddleName_AddPanel);
		
		JLabel lblNewLabel_1 = new JLabel("LAST_NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(50, 201, 90, 19);
		AddPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FIRST_NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(226, 201, 90, 19);
		AddPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MIDDLE_NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(414, 200, 109, 19);
		AddPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GENDER:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 257, 64, 19);
		AddPanel.add(lblNewLabel_4);
		
		cmbGender_AddPanel = new JComboBox();
		cmbGender_AddPanel.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		cmbGender_AddPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbGender_AddPanel.setBounds(84, 257, 109, 22);
		AddPanel.add(cmbGender_AddPanel);
		
		JLabel lblNewLabel_5 = new JLabel("DEPARTMENT_ID:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(203, 257, 139, 19);
		AddPanel.add(lblNewLabel_5);
		
		cmbDeptID_AddPanel = new JComboBox();
		cmbDeptID_AddPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbDeptID_AddPanel.setBounds(345, 257, 195, 22);
		cmbDeptID_AddPanel.addItemListener(this);
		AddPanel.add(cmbDeptID_AddPanel);
		
		JLabel lblDeptheadid = new JLabel("SUPER_ID:");
		lblDeptheadid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeptheadid.setBounds(10, 327, 83, 19);
		AddPanel.add(lblDeptheadid);
		
		JLabel lblYearlevel = new JLabel("SALARY:");
		lblYearlevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYearlevel.setBounds(245, 327, 90, 19);
		AddPanel.add(lblYearlevel);
		
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
		
		JLabel lblAction = new JLabel("ADD FACULTY");
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
		btnClear_AddPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear_AddPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnClear_AddPanel.setBackground(new Color(255, 250, 250));
		btnClear_AddPanel.addActionListener(this);
		btnClear_AddPanel.setBounds(25, 468, 115, 32);
		AddPanel.add(btnClear_AddPanel);
		
		btnConfirm_AddPanel = new JButton("CONFIRM");
		btnConfirm_AddPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirm_AddPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnConfirm_AddPanel.setBackground(new Color(255, 250, 250));
		btnConfirm_AddPanel.setBounds(345, 468, 179, 32);
		btnConfirm_AddPanel.addActionListener(this);
		AddPanel.add(btnConfirm_AddPanel);
		
		txtSalary_AddPanel = new JTextField();
		txtSalary_AddPanel.setColumns(10);
		txtSalary_AddPanel.setBounds(309, 318, 231, 33);
		AddPanel.add(txtSalary_AddPanel);
		
		txtSuperID_AddPanel = new JTextField();
		txtSuperID_AddPanel.setEditable(false);
		txtSuperID_AddPanel.setColumns(10);
		txtSuperID_AddPanel.setBounds(84, 318, 151, 33);
		AddPanel.add(txtSuperID_AddPanel);
		
		JPanel RemovePanel = new JPanel();
		RemovePanel.setLayout(null);
		tabbedPane.addTab("REMOVE", null, RemovePanel, null);
		
		btnRemove_RemovePanel = new JButton("REMOVE");
		btnRemove_RemovePanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemove_RemovePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnRemove_RemovePanel.setBackground(new Color(255, 250, 250));
		btnRemove_RemovePanel.setBounds(184, 463, 170, 32);
		btnRemove_RemovePanel.addActionListener(this);
		RemovePanel.add(btnRemove_RemovePanel);
		
		txtID_RemovePanel = new JTextField();
		txtID_RemovePanel.setColumns(10);
		txtID_RemovePanel.setBounds(37, 95, 109, 28);
		RemovePanel.add(txtID_RemovePanel);
		
		JLabel lblID_1 = new JLabel("ID:");
		lblID_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblID_1.setBounds(10, 97, 31, 19);
		RemovePanel.add(lblID_1);
		
		JLabel lblAction_1 = new JLabel("REMOVE FACULTY");
		lblAction_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAction_1.setFont(new Font("Monospaced", Font.BOLD, 50));
		lblAction_1.setBounds(10, 10, 530, 66);
		RemovePanel.add(lblAction_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 81, 534, 4);
		RemovePanel.add(separator_1);
		
		btnFind_RemovePanel = new JButton("FIND");
		btnFind_RemovePanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFind_RemovePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnFind_RemovePanel.setBackground(new Color(255, 250, 250));
		btnFind_RemovePanel.setBounds(156, 95, 90, 28);
		btnFind_RemovePanel.addActionListener(this);
		RemovePanel.add(btnFind_RemovePanel);
		
		txtLastName_RemovePanel = new JTextField();
		txtLastName_RemovePanel.setEditable(false);
		txtLastName_RemovePanel.setColumns(10);
		txtLastName_RemovePanel.setBounds(10, 153, 159, 33);
		RemovePanel.add(txtLastName_RemovePanel);
		
		txtFirstName_RemovePanel = new JTextField();
		txtFirstName_RemovePanel.setEditable(false);
		txtFirstName_RemovePanel.setColumns(10);
		txtFirstName_RemovePanel.setBounds(172, 153, 199, 33);
		RemovePanel.add(txtFirstName_RemovePanel);
		
		txtMiddleName_RemovePanel = new JTextField();
		txtMiddleName_RemovePanel.setEditable(false);
		txtMiddleName_RemovePanel.setColumns(10);
		txtMiddleName_RemovePanel.setBounds(375, 153, 165, 33);
		RemovePanel.add(txtMiddleName_RemovePanel);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("LAST_NAME");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(50, 197, 90, 19);
		RemovePanel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("FIRST_NAME");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(226, 197, 90, 19);
		RemovePanel.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("MIDDLE_NAME");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2_1.setBounds(414, 196, 109, 19);
		RemovePanel.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("GENDER:");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_2_1.setBounds(10, 253, 64, 19);
		RemovePanel.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("DEPARTMENT_ID:");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_2_1.setBounds(203, 253, 139, 19);
		RemovePanel.add(lblNewLabel_5_2_1);
		
		JLabel lblDeptheadid_2_1 = new JLabel("SUPER_ID:");
		lblDeptheadid_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeptheadid_2_1.setBounds(10, 323, 83, 19);
		RemovePanel.add(lblDeptheadid_2_1);
		
		JLabel lblYearlevel_2_1 = new JLabel("SALARY:");
		lblYearlevel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYearlevel_2_1.setBounds(245, 323, 90, 19);
		RemovePanel.add(lblYearlevel_2_1);
		
		txtEmail_RemovePanel = new JTextField();
		txtEmail_RemovePanel.setEditable(false);
		txtEmail_RemovePanel.setColumns(10);
		txtEmail_RemovePanel.setBounds(10, 380, 294, 28);
		RemovePanel.add(txtEmail_RemovePanel);
		
		txtContact_RemovePanel = new JTextField();
		txtContact_RemovePanel.setEditable(false);
		txtContact_RemovePanel.setColumns(10);
		txtContact_RemovePanel.setBounds(314, 380, 226, 28);
		RemovePanel.add(txtContact_RemovePanel);
		
		txtSalary_RemovePanel = new JTextField();
		txtSalary_RemovePanel.setEditable(false);
		txtSalary_RemovePanel.setColumns(10);
		txtSalary_RemovePanel.setBounds(309, 314, 231, 33);
		RemovePanel.add(txtSalary_RemovePanel);
		
		JLabel lblSchoolemail_2_1 = new JLabel("SCHOOL_EMAIL");
		lblSchoolemail_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSchoolemail_2_1.setBounds(102, 418, 112, 19);
		RemovePanel.add(lblSchoolemail_2_1);
		
		JLabel lblContactnumber_2_1 = new JLabel("CONTACT_NUMBER");
		lblContactnumber_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContactnumber_2_1.setBounds(364, 418, 148, 19);
		RemovePanel.add(lblContactnumber_2_1);
		
		txtSuperID_RemovePanel = new JTextField();
		txtSuperID_RemovePanel.setEditable(false);
		txtSuperID_RemovePanel.setColumns(10);
		txtSuperID_RemovePanel.setBounds(85, 314, 150, 33);
		RemovePanel.add(txtSuperID_RemovePanel);
		
		txtDeptID_RemovePanel = new JTextField();
		txtDeptID_RemovePanel.setEditable(false);
		txtDeptID_RemovePanel.setColumns(10);
		txtDeptID_RemovePanel.setBounds(336, 245, 203, 33);
		RemovePanel.add(txtDeptID_RemovePanel);
		
		txtGender_RemovePanel = new JTextField();
		txtGender_RemovePanel.setEditable(false);
		txtGender_RemovePanel.setColumns(10);
		txtGender_RemovePanel.setBounds(85, 245, 108, 33);
		RemovePanel.add(txtGender_RemovePanel);
		
		JPanel EditPanel = new JPanel();
		EditPanel.setLayout(null);
		tabbedPane.addTab("EDIT", null, EditPanel, null);
		
		txtID_EditPanel = new JTextField();
		txtID_EditPanel.setColumns(10);
		txtID_EditPanel.setBounds(37, 95, 109, 28);
		EditPanel.add(txtID_EditPanel);
		
		JLabel lblID_2 = new JLabel("ID:");
		lblID_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblID_2.setBounds(10, 97, 31, 19);
		EditPanel.add(lblID_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 81, 534, 4);
		EditPanel.add(separator_2);
		
		JLabel lblEditStudent = new JLabel("EDIT FACULTY");
		lblEditStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditStudent.setFont(new Font("Monospaced", Font.BOLD, 50));
		lblEditStudent.setBounds(10, 10, 530, 66);
		EditPanel.add(lblEditStudent);
		
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
		
		txtLastName_EditPanel = new JTextField();
		txtLastName_EditPanel.setColumns(10);
		txtLastName_EditPanel.setBounds(10, 155, 159, 33);
		EditPanel.add(txtLastName_EditPanel);
		
		txtFirstName_EditPanel = new JTextField();
		txtFirstName_EditPanel.setColumns(10);
		txtFirstName_EditPanel.setBounds(172, 155, 199, 33);
		EditPanel.add(txtFirstName_EditPanel);
		
		txtMiddleName_EditPanel = new JTextField();
		txtMiddleName_EditPanel.setColumns(10);
		txtMiddleName_EditPanel.setBounds(375, 155, 165, 33);
		EditPanel.add(txtMiddleName_EditPanel);
		
		JLabel lblNewLabel_1_2 = new JLabel("LAST_NAME");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(50, 199, 90, 19);
		EditPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("FIRST_NAME");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(226, 199, 90, 19);
		EditPanel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("MIDDLE_NAME");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(414, 198, 109, 19);
		EditPanel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("GENDER:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(10, 255, 64, 19);
		EditPanel.add(lblNewLabel_4_2);
		
		cmbGender_EditPanel = new JComboBox();
		cmbGender_EditPanel.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		cmbGender_EditPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbGender_EditPanel.setBounds(84, 255, 109, 22);
		EditPanel.add(cmbGender_EditPanel);
		
		JLabel lblNewLabel_5_2 = new JLabel("DEPARTMENT_ID:");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_2.setBounds(203, 255, 139, 19);
		EditPanel.add(lblNewLabel_5_2);
		
		cmbDeptID_EditPanel = new JComboBox();
		cmbDeptID_EditPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbDeptID_EditPanel.setBounds(345, 255, 195, 22);
		cmbDeptID_EditPanel.addItem(this);
		EditPanel.add(cmbDeptID_EditPanel);
		
		JLabel lblDeptheadid_2 = new JLabel("SUPER_ID:");
		lblDeptheadid_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeptheadid_2.setBounds(10, 325, 83, 19);
		EditPanel.add(lblDeptheadid_2);
		
		JLabel lblYearlevel_2 = new JLabel("SALARY:");
		lblYearlevel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYearlevel_2.setBounds(245, 325, 90, 19);
		EditPanel.add(lblYearlevel_2);
		
		txtEmail_EditPanel = new JTextField();
		txtEmail_EditPanel.setEditable(false);
		txtEmail_EditPanel.setColumns(10);
		txtEmail_EditPanel.setBounds(86, 382, 240, 28);
		EditPanel.add(txtEmail_EditPanel);
		
		txtContact_EditPanel = new JTextField();
		txtContact_EditPanel.setColumns(10);
		txtContact_EditPanel.setBounds(336, 382, 204, 28);
		EditPanel.add(txtContact_EditPanel);
		
		btnGenerate_EditPanel = new JButton("Generate");
		btnGenerate_EditPanel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGenerate_EditPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGenerate_EditPanel.setBackground(new Color(255, 250, 250));
		btnGenerate_EditPanel.setBounds(10, 382, 73, 28);
		EditPanel.add(btnGenerate_EditPanel);
		
		txtSalary_EditPanel = new JTextField();
		txtSalary_EditPanel.setColumns(10);
		txtSalary_EditPanel.setBounds(309, 316, 231, 33);
		EditPanel.add(txtSalary_EditPanel);
		
		JLabel lblSchoolemail_2 = new JLabel("SCHOOL_EMAIL");
		lblSchoolemail_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSchoolemail_2.setBounds(147, 420, 112, 19);
		EditPanel.add(lblSchoolemail_2);
		
		JLabel lblContactnumber_2 = new JLabel("CONTACT_NUMBER");
		lblContactnumber_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContactnumber_2.setBounds(375, 420, 148, 19);
		EditPanel.add(lblContactnumber_2);
		
		txtSuperID_EditPanel = new JTextField();
		txtSuperID_EditPanel.setEditable(false);
		txtSuperID_EditPanel.setColumns(10);
		txtSuperID_EditPanel.setBounds(84, 316, 151, 33);
		EditPanel.add(txtSuperID_EditPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(574, 62, 905, 587);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(PersonalInfoTable);
		scrollPane.setViewportView(table);
		
		btnSearchById = new JButton("Search by ID");
		btnSearchById.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearchById.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnSearchById.setBackground(Color.WHITE);
		btnSearchById.setBounds(1354, 16, 125, 32);
		btnSearchById.addActionListener(this);
		add(btnSearchById);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(1249, 16, 95, 32);
		btnSearch.addActionListener(this);
		add(btnSearch);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setText("");
		txtSearchBar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtSearchBar.setColumns(10);
		txtSearchBar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txtSearchBar.setBounds(805, 10, 434, 42);
		add(txtSearchBar);
		
		cmbSearchOption = new JComboBox();
		cmbSearchOption.setModel(new DefaultComboBoxModel(new String[] {"Personal Info", "Course Info", "Contact Info"}));
		cmbSearchOption.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbSearchOption.setBounds(650, 17, 145, 29);
		cmbSearchOption.addItemListener(this);
		add(cmbSearchOption);
		
		btnRefresh = new JButton("REFRESH");
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRefresh.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnRefresh.setBackground(Color.WHITE);
		btnRefresh.setBounds(574, 16, 66, 32);
		btnRefresh.addActionListener(this);
		add(btnRefresh);
		refresh();
	}



	/********************** EVENT HANDLERS **********************/



	@Override
	public void actionPerformed(ActionEvent e) {
		// SEARCH PANEL ----------------------------------------------------------
		if (e.getSource() == btnSearch){
			searchedFaculty = Database.searchFaculty(txtSearchBar.getText());
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
				searchedFaculty = Database.searchFacultytByID(Integer.parseInt(txtSearchBar.getText()));
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
		}


		// ADD PANEL -------------------------------------------------------------
		if (e.getSource() == btnClear_AddPanel){
			
			txtID_AddPanel.setText(null);
			txtLastName_AddPanel.setText(null);
			txtFirstName_AddPanel.setText(null);
			txtMiddleName_AddPanel.setText(null);
			txtEmail_AddPanel.setText(null);
			txtContact_AddPanel.setText(null);
			txtSalary_AddPanel.setText(null);
			txtSuperID_AddPanel.setText(null);
			cmbGender_AddPanel.setSelectedItem((Object)"M");
			cmbDeptID_AddPanel.setSelectedItem((Object)"1");
			return;
		}

		if (e.getSource() == btnConfirm_AddPanel) {
			addFaculty();
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


		//REMOVE PANEL -----------------------------------------------------------
		
		if (e.getSource() == btnFind_RemovePanel) {
			if (isDigit(txtID_RemovePanel.getText())){
				selectedFacultyToRemove = Database.getFacultyInfo(Integer.parseInt(txtID_RemovePanel.getText()));
				if (selectedFacultyToRemove != null) {
					txtLastName_RemovePanel.setText((String)selectedFacultyToRemove[1]);
					txtFirstName_RemovePanel.setText((String)selectedFacultyToRemove[2]);
					txtMiddleName_RemovePanel.setText((String)selectedFacultyToRemove[3]);
					txtGender_RemovePanel.setText((String)selectedFacultyToRemove[4]);
					txtDeptID_RemovePanel.setText(Integer.toString((Integer)selectedFacultyToRemove[5]));
					txtSuperID_RemovePanel.setText(Integer.toString((Integer)selectedFacultyToRemove[6]));
					txtSalary_RemovePanel.setText(Double.toString((Double)selectedFacultyToRemove[7]));
					txtEmail_RemovePanel.setText((String)selectedFacultyToRemove[8]);
					txtContact_RemovePanel.setText((String)selectedFacultyToRemove[9]);
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
			if(selectedFacultyToRemove != null) {
				if (Database.deleteFaculty((Integer)selectedFacultyToRemove[0])){
					JOptionPane.showMessageDialog(this, "FACULTY SUCCESSFULY REMOVED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				else {
					JOptionPane.showMessageDialog(this, "ERROR REMOVING FACULTY", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "NO FACULTY IS SELECTED", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}


		//EDIT PANEL -------------------------------------------------------------

		if (e.getSource() == btnFind_EditPanel) {
			if (isDigit(txtID_EditPanel.getText())){
				selectedFacultyToEdit = Database.getFacultyInfo(Integer.parseInt(txtID_EditPanel.getText()));
				if (selectedFacultyToEdit != null) {
					txtLastName_EditPanel.setText((String)selectedFacultyToEdit[1]);
					txtFirstName_EditPanel.setText((String)selectedFacultyToEdit[2]);
					txtMiddleName_EditPanel.setText((String)selectedFacultyToEdit[3]);
					cmbGender_EditPanel.setSelectedItem(selectedFacultyToEdit[4]);
					cmbDeptID_EditPanel.setSelectedItem(selectedFacultyToEdit[5]);
					txtSuperID_EditPanel.setText(Integer.toString((Integer)selectedFacultyToEdit[6]));
					txtSalary_EditPanel.setText(Double.toString((Double)selectedFacultyToEdit[7]));
					txtEmail_EditPanel.setText((String)selectedFacultyToEdit[8]);
					txtContact_EditPanel.setText((String)selectedFacultyToEdit[9]);
					return;
				}
				else{
					JOptionPane.showMessageDialog(this, "FACULTY DOES NOT EXIST", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "INVALID ID", "INVALID", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		if (e.getSource() == btnConfirm_EditPanel){
			editFaculty();
			return;
		}

	}




	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbSearchOption){
			setTableModel((String)cmbSearchOption.getSelectedItem());
			return;
		}

		if (e.getSource() == cmbDeptID_AddPanel){
			txtSuperID_AddPanel.setText(Integer.toString(Database.getCourseHeadID(Integer.parseInt((String)cmbDeptID_AddPanel.getSelectedItem()))));
		}

		if (e.getSource() == cmbDeptID_EditPanel){
			txtSuperID_EditPanel.setText(Integer.toString(Database.getCourseHeadID(Integer.parseInt((String)cmbDeptID_EditPanel.getSelectedItem()))));
		}
		
	}



	/*********************** END OF EVENT HANDLERS ***********************/


	private void addFaculty() {
		if (!txtFirstName_AddPanel.getText().isBlank() && 
			!txtLastName_AddPanel.getText().isBlank() && 
			isDigit(txtID_AddPanel.getText()) &&
			!txtEmail_AddPanel.getText().isBlank() &&
			isDigit(txtContact_AddPanel.getText())) 
			{
				if(Database.searchFacultytByID(Integer.parseInt(txtID_AddPanel.getText())).isEmpty()) {

					Object[] info = new Object[] {
						Integer.parseInt(txtID_AddPanel.getText()),
						txtLastName_AddPanel.getText(),
						txtFirstName_AddPanel.getText(),
						txtMiddleName_AddPanel.getText(),
						(String)cmbGender_AddPanel.getSelectedItem(),
						Integer.parseInt((String)cmbDeptID_AddPanel.getSelectedItem()),
						Integer.parseInt(txtSuperID_AddPanel.getText()),
						Double.parseDouble(txtSalary_AddPanel.getText()),
						txtEmail_AddPanel.getText(),
						txtContact_AddPanel.getText()

					};
					if (Database.addFaculty(info)){
						JOptionPane.showMessageDialog(this, "FACULTY SUCCESSFULY ADDED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(this, "ERROR ADDING FACULTY", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(this, "FACULTY WITH ID :" + txtID_AddPanel.getText() + "\n ALREADY EXIST", "INVALID INFO", JOptionPane.INFORMATION_MESSAGE);
				}
			}	
		else {
			JOptionPane.showMessageDialog(this, "FACULTY INFORMATION IS INVALID", "INVALID INFO", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void editFaculty() {
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
					Integer.parseInt((String)cmbDeptID_EditPanel.getSelectedItem()),
					Integer.parseInt(txtSuperID_EditPanel.getText()),
					Double.parseDouble(txtSalary_EditPanel.getText()),
					txtEmail_EditPanel.getText(),
					txtContact_EditPanel.getText()

				};
				if (Database.updateFaculty((int)selectedFacultyToEdit[0],info)){
					JOptionPane.showMessageDialog(this, "FACULTY SUCCESSFULY EDITED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(this, "ERROR EDITING FACULTY", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}	
		else {
			JOptionPane.showMessageDialog(this, "FACULTY INFORMATION IS INVALID", "INVALID INFO", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	

	/*********************** TABLE ***********************/
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
			table.getColumnModel().getColumn(4).setPreferredWidth(60);
			table.getColumnModel().getColumn(5).setPreferredWidth(60);
			table.getColumnModel().getColumn(6).setPreferredWidth(80);
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

	private void fillTable(DefaultTableModel TableModel) {
		for (Object[] obj : searchedFaculty){

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
				obj[5], //DEPARTMENT_ID
				obj[6], //SUPER_ID
				obj[7], //SALARY
			});

			ContactInfoTable.addRow(new Object[]{
				obj[0], //STUDENT_ID
				obj[1], //LAST_NAME
				obj[2], //FIRST_NAME
				obj[3], //MIDDLE_NAME
				obj[8],//FACULTY_EMAIL
				obj[9] //CONTACT_NUMBER
			});
		}
		isTableEmpty = false;
	}

	private void clearTable(DefaultTableModel TableModel){
		if (TableModel.getRowCount() != 0){
			for (int i = TableModel.getRowCount() - 1; i >= 0; i--){
				TableModel.removeRow(i);
			}
		}
	}

	private void refresh(){
		var course = Database.getAllDeptID();
		String[] cmbModel = new String[course.size()];
		for (int i = 0; i < cmbModel.length; i++){
			cmbModel[i] = course.get(i);
		}
		cmbDeptID_AddPanel.setModel((new DefaultComboBoxModel(cmbModel)));
		cmbDeptID_EditPanel.setModel((new DefaultComboBoxModel(cmbModel)));
		Database.updateFacultyDB();
	}

	private boolean isDigit(String id){
		if (id.matches("[0-9]+")){
			return true;
		}else {
			return false;
		}
	}
}
