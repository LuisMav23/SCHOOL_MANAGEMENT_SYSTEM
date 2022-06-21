package SMSApp;

import DBManager.Database;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JPanel implements ActionListener {
	private JTextField txtCurrPassword;
	private JTextField txtUsername;
	private JTextField txtNewPassword;
	private JButton btnChange;

	/**
	 * Create the panel.
	 */
	public AdminPanel() {
		setBackground(Color.WHITE);
		setBounds(0, 100, 1500, 663);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(838, 157, 580, 391);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 560, 81);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("USERNAME:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(20, 116, 116, 55);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("CURRENT PASSWORD:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(20, 181, 214, 55);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("NEW PASSWORD:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(20, 250, 214, 55);
		panel.add(lblNewLabel_2_1_1);
		
		txtCurrPassword = new JTextField();
		txtCurrPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCurrPassword.setBounds(244, 182, 280, 55);
		panel.add(txtCurrPassword);
		txtCurrPassword.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsername.setColumns(10);
		txtUsername.setBounds(244, 116, 280, 55);
		panel.add(txtUsername);
		
		txtNewPassword = new JTextField();
		txtNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNewPassword.setColumns(10);
		txtNewPassword.setBounds(244, 250, 280, 55);
		panel.add(txtNewPassword);
		
		btnChange = new JButton("CHANGE");
		btnChange.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChange.setBounds(208, 327, 174, 40);
		btnChange.addActionListener(this);
		panel.add(btnChange);
		
		JLabel lblCourseDatabase = new JLabel("Admin");
		lblCourseDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseDatabase.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblCourseDatabase.setBounds(882, 72, 497, 75);
		add(lblCourseDatabase);
		
		JLabel lblNewLabel_1 = new JLabel("LOGO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 99));
		lblNewLabel_1.setBounds(10, 10, 722, 643);
		add(lblNewLabel_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnChange){
			if(MainWindow.getPassword().equalsIgnoreCase(txtCurrPassword.getText())){
				if(Database.updateLogin(txtUsername.getText(), txtNewPassword.getText(), txtCurrPassword.getText())){
					JOptionPane.showMessageDialog(this, "LOGIN CREDENTIALS UPDATED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(this, "ERROR UPDATING LOGIN CREDENTIALS", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(this, "PLEASE ENTER CORRECT CURRENT PASSWORD", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
