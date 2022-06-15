package SMSApp;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputFilter.Status;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import DBManager.Database;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class StudentPanel extends JPanel implements ActionListener{

	private int[] selectedRows;
	private String action = "ADD";

	private JTextField textField;
	private JPanel MainStudentPanel;
	private JButton btnSearch;
	private JButton btnSearchById;
	private JPanel AddStudentPanel;
	private JLabel lblNewLabel;
	private JTable table;
	private JComboBox comboBox;
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnEdit;
	private JButton btnConfirm;
	private JTextField txtID;
	private JLabel lblID;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtMiddleName;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox cmbGender;
	private JLabel lblNewLabel_5;
	private JComboBox cmbDegreeProgram;
	private JTextField txtDeptHeadID;
	private JLabel lblDeptheadid;
	private JLabel lblYearlevel;
	private JLabel lblBlocknumber;
	private JComboBox cmbYearLevel;
	private JComboBox cmbBlockNumber;
	private JLabel lblStatus;
	private JComboBox cmbStatus;
	private JTextField txtSchoolEmail;
	private JTextField txtContactNumber;
	private JLabel lblSchoolemail;
	private JLabel lblContactnumber;
	private JLabel lblAction;
	private JSeparator separator;

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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setText("");
		textField.setBounds(805, 9, 434, 42);
		MainStudentPanel.add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBounds(1249, 15, 95, 32);
		MainStudentPanel.add(btnSearch);
		
		btnSearchById = new JButton("Search by ID");
		btnSearchById.setBackground(new Color(255, 255, 255));
		btnSearchById.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnSearchById.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearchById.setBounds(1354, 15, 125, 32);
		MainStudentPanel.add(btnSearchById);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(574, 61, 905, 587);
		MainStudentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("STUDENT DATABASE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 10, 554, 75);
		MainStudentPanel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(574, 18, 221, 29);
		MainStudentPanel.add(comboBox);

		btnAdd = new JButton("ADD");
		btnAdd.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnAdd.setBackground(new Color(255, 250, 250));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(10, 599, 115, 32);
		btnAdd.addActionListener(this);
		MainStudentPanel.add(btnAdd);
		
		btnRemove = new JButton("REMOVE");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemove.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnRemove.setBackground(new Color(255, 250, 250));
		btnRemove.setBounds(135, 599, 115, 32);
		btnRemove.addActionListener(this);
		MainStudentPanel.add(btnRemove);
		
		btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnEdit.setBackground(new Color(255, 250, 250));
		btnEdit.setBounds(260, 599, 115, 32);
		MainStudentPanel.add(btnEdit);
		
		btnConfirm = new JButton("CONFIRM");
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirm.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnConfirm.setBackground(new Color(255, 250, 250));
		btnConfirm.setBounds(385, 599, 179, 32);
		MainStudentPanel.add(btnConfirm);
		
		JPanel InfoPanel = new JPanel();
		InfoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		InfoPanel.setBounds(10, 95, 554, 475);
		MainStudentPanel.add(InfoPanel);
		InfoPanel.setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(37, 95, 109, 28);
		InfoPanel.add(txtID);
		txtID.setColumns(10);
		
		lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblID.setBounds(10, 97, 31, 19);
		InfoPanel.add(lblID);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(10, 141, 159, 33);
		InfoPanel.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(172, 141, 199, 33);
		InfoPanel.add(txtFirstName);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setColumns(10);
		txtMiddleName.setBounds(375, 141, 165, 33);
		InfoPanel.add(txtMiddleName);
		
		lblNewLabel_1 = new JLabel("LAST_NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(50, 185, 90, 19);
		InfoPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("FIRST_NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(226, 185, 90, 19);
		InfoPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("MIDDLE_NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(414, 184, 109, 19);
		InfoPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("GENDER:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 234, 64, 19);
		InfoPanel.add(lblNewLabel_4);
		
		cmbGender = new JComboBox();
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		cmbGender.setBounds(84, 234, 109, 22);
		InfoPanel.add(cmbGender);
		
		lblNewLabel_5 = new JLabel("DEGREE_PROGRAM:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(203, 234, 139, 19);
		InfoPanel.add(lblNewLabel_5);
		
		cmbDegreeProgram = new JComboBox();
		cmbDegreeProgram.setBounds(345, 234, 195, 22);
		InfoPanel.add(cmbDegreeProgram);
		
		txtDeptHeadID = new JTextField();
		txtDeptHeadID.setEditable(false);
		txtDeptHeadID.setColumns(10);
		txtDeptHeadID.setBounds(132, 289, 159, 28);
		InfoPanel.add(txtDeptHeadID);
		
		lblDeptheadid = new JLabel("DEPT_HEAD_ID:");
		lblDeptheadid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeptheadid.setBounds(10, 294, 112, 19);
		InfoPanel.add(lblDeptheadid);
		
		lblYearlevel = new JLabel("YEAR_LEVEL:");
		lblYearlevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYearlevel.setBounds(336, 289, 90, 19);
		InfoPanel.add(lblYearlevel);
		
		lblBlocknumber = new JLabel("BLOCK_NUMBER:");
		lblBlocknumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBlocknumber.setBounds(309, 334, 117, 19);
		InfoPanel.add(lblBlocknumber);
		
		cmbYearLevel = new JComboBox();
		cmbYearLevel.setBounds(431, 286, 109, 22);
		InfoPanel.add(cmbYearLevel);
		
		cmbBlockNumber = new JComboBox();
		cmbBlockNumber.setBounds(431, 331, 109, 22);
		InfoPanel.add(cmbBlockNumber);
		
		lblStatus = new JLabel("STATUS:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(58, 335, 64, 19);
		InfoPanel.add(lblStatus);
		
		cmbStatus = new JComboBox();
		cmbStatus.setModel(new DefaultComboBoxModel(new String[] {"REGULAR", "IRREGULAR"}));
		cmbStatus.setBounds(132, 335, 159, 22);
		InfoPanel.add(cmbStatus);
		
		txtSchoolEmail = new JTextField();
		txtSchoolEmail.setEditable(false);
		txtSchoolEmail.setColumns(10);
		txtSchoolEmail.setBounds(10, 384, 318, 28);
		InfoPanel.add(txtSchoolEmail);
		
		txtContactNumber = new JTextField();
		txtContactNumber.setColumns(10);
		txtContactNumber.setBounds(336, 384, 204, 28);
		InfoPanel.add(txtContactNumber);
		
		lblSchoolemail = new JLabel("SCHOOL_EMAIL");
		lblSchoolemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSchoolemail.setBounds(117, 422, 112, 19);
		InfoPanel.add(lblSchoolemail);
		
		lblContactnumber = new JLabel("CONTACT_NUMBER");
		lblContactnumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContactnumber.setBounds(377, 422, 148, 19);
		InfoPanel.add(lblContactnumber);
		
		lblAction = new JLabel("ADD");
		lblAction.setFont(new Font("Monospaced", Font.BOLD, 50));
		lblAction.setHorizontalAlignment(SwingConstants.CENTER);
		lblAction.setBounds(10, 10, 530, 66);
		InfoPanel.add(lblAction);
		
		separator = new JSeparator();
		separator.setBounds(10, 81, 534, 4);
		InfoPanel.add(separator);
		
		AddStudentPanel = new JPanel();
		add(AddStudentPanel, "name_39224549468000");

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		selectedRows = table.getSelectedRows();

		if (e.getSource() == btnAdd){
			setActionAdd();
		}
		else if (e.getSource() == btnRemove){
			setActionRemove();
		}
	}

	private void setActionAdd(){
		
		action = "ADD";
		lblAction.setText(action);;
		txtID.setText(null);
		txtID.setEditable(true);

		txtLastName.setText(null);
		txtLastName.setEditable(true);

		txtFirstName.setText(null);
		txtFirstName.setEditable(true);

		txtMiddleName.setText(null);
		txtMiddleName.setEditable(true);

		cmbGender.setSelectedItem(null);
		cmbGender.setEditable(true);

		cmbDegreeProgram.setSelectedItem(null);
		cmbDegreeProgram.setEditable(true);

		txtDeptHeadID.setText(null);
		txtDeptHeadID.setEditable(false);

		cmbYearLevel.setSelectedItem(null);
		cmbYearLevel.setEditable(true);
			
		cmbBlockNumber.setSelectedItem(null);
		cmbBlockNumber.setEditable(true);
			
		txtSchoolEmail.setText(null);
		txtSchoolEmail.setEditable(false);

		txtContactNumber.setText(null);
		txtContactNumber.setEditable(true);
	}

	private void setActionRemove(){

		action = "REMOVE";

		
		lblAction.setText(action);;
		txtID.setEditable(false);
		txtLastName.setEditable(false);
		txtFirstName.setEditable(false);
		txtMiddleName.setEditable(false);
		cmbGender.setEditable(false);
		cmbDegreeProgram.setEditable(false);
		txtDeptHeadID.setEditable(false);
		cmbYearLevel.setEditable(false);
		cmbBlockNumber.setEditable(false);
		txtSchoolEmail.setEditable(false);
		txtContactNumber.setEditable(false);

		if (selectedRows != null){

			
			txtID.setText(null);
			txtLastName.setText(null);
	
			txtFirstName.setText(null);
	
			txtMiddleName.setText(null);
	
			cmbGender.setSelectedItem(null);
	
			cmbDegreeProgram.setSelectedItem(null);
	
			txtDeptHeadID.setText(null);
	
			cmbYearLevel.setSelectedItem(null);
				
			cmbBlockNumber.setSelectedItem(null);
				
			txtSchoolEmail.setText(null);
	
			txtContactNumber.setText(null);

		} 
		else {

			Object[] studentInfo = Database.getStudentInfo((int)table.getModel().getValueAt(selectedRows[0], 0));

			txtID.setText(Integer.toString((int)studentInfo[0]));
			txtLastName.setText(null);
	
			txtFirstName.setText(null);
	
			txtMiddleName.setText(null);
	
			cmbGender.setSelectedItem(null);
	
			cmbDegreeProgram.setSelectedItem(null);
	
			txtDeptHeadID.setText(null);
	
			cmbYearLevel.setSelectedItem(null);
				
			cmbBlockNumber.setSelectedItem(null);
				
			txtSchoolEmail.setText(null);
	
			txtContactNumber.setText(null);

		}
	}







}
