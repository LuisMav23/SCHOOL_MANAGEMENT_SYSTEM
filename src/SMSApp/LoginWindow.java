package SMSApp;


import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import DBManager.Database;

import java.awt.EventQueue;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;

public class LoginWindow extends JFrame implements ActionListener{

	
	String Pword = "";

	/******** DECLARE UI COMPONENTS ********/
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPanel LoginPanel;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JLabel lblAdminLogin;
	private JLabel lblSepBottom;
	private JLabel lblSepTop;
	
	/********** END UI COMPONENTS **********/

	
	public LoginWindow() {
		Initialize();
	}
	
	/******** INIT UI COMPONENTS ********/
	public void Initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel(){
	        @Override
	        protected void paintComponent(Graphics grphcs) {
	            super.paintComponent(grphcs);
	            Graphics2D g2d = (Graphics2D) grphcs;
	            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                    RenderingHints.VALUE_ANTIALIAS_ON);
	            GradientPaint gp = new GradientPaint(0, 0,
	                    Color.decode("#3a1c71"), 
						0, getHeight(),
	                    Color.decode("#ffaf7b"));
	            g2d.setPaint(gp);
	            g2d.fillRect(0, 0, getWidth(), getHeight()); 

	        }

	    };
		contentPane.setLocation(-851, -44);
		
		contentPane.setBackground(new Color(165, 42, 42));;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LoginPanel = new JPanel();
		LoginPanel.setBorder(new EmptyBorder(1, 1, 1, 0));
		LoginPanel.setBackground(UIManager.getColor("Button.background"));
		LoginPanel.setBounds(851, 48, 508, 639);
		contentPane.add(LoginPanel);
		LoginPanel.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(UIManager.getColor("Button.background"));
		txtPassword.setBounds(172, 380, 309, 46);
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					confirmLogin();
				}
			}
		});
		LoginPanel.add(txtPassword);
		txtPassword.setFont(new Font("MS UI Gothic", Font.BOLD, 25));
		txtPassword.setColumns(10);
		txtPassword.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));	
				
		txtUsername = new JTextField();
		txtUsername.setBackground(UIManager.getColor("Button.background"));
		txtUsername.setBounds(172, 261, 309, 46);
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					confirmLogin();
				}
			}
		});
		LoginPanel.add(txtUsername);
		txtUsername.setFont(new Font("MS UI Gothic", Font.BOLD, 25));
		txtUsername.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		txtUsername.setColumns(10);
		
		lblUsername = new JLabel("Username\r\n:");
		lblUsername.setFont(new Font("MS UI Gothic", Font.BOLD, 25));
		lblUsername.setIcon(null);
		lblUsername.setBounds(31, 262, 131, 46);
		LoginPanel.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("MS UI Gothic", Font.BOLD, 25));
		lblPassword.setIcon(null);
		lblPassword.setBounds(31, 384, 116, 46);
		LoginPanel.add(lblPassword);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(255, 99, 71));
		btnLogin.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnLogin.setBounds(152, 508, 192, 64);
		btnLogin.addActionListener(this);
		LoginPanel.add(btnLogin);
		
		lblAdminLogin = new JLabel("ADMIN PORTAL");
		lblAdminLogin.setFont(new Font("MS UI Gothic", Font.BOLD, 50));
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setBounds(31, 68, 450, 54);
		LoginPanel.add(lblAdminLogin);
		
		lblSepBottom = new JLabel("");
		lblSepBottom.setBounds(62, 196, 388, 13);
		lblSepBottom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		LoginPanel.add(lblSepBottom);
		
		lblSepTop = new JLabel("");
		lblSepTop.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblSepTop.setBounds(62, 44, 388, 13);
		LoginPanel.add(lblSepTop);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("MS UI Gothic", Font.BOLD, 50));
		lblLogin.setBounds(31, 132, 450, 54);
		LoginPanel.add(lblLogin);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("LOGO.png"));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 99));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 48, 722, 657);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
	}
	
	/****************************************************************************************/
	
	

	/********** EVENT HANDLER **********/
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			confirmLogin();
		} 
	}
	
	private void confirmLogin() {
		var P = txtPassword.getPassword();
        for (int i = 0; i < P.length; i++){
            Pword += P[i]; 
        }
		if (Database.confirmLogin(txtUsername.getText(), Pword)){
			JOptionPane.showMessageDialog(this, "LOGIN SUCCESSFUL", "LOGIN", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MainWindow frame = new MainWindow(txtUsername.getText(), Pword);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else {
			Pword = "";
			JOptionPane.showMessageDialog(this, "LOGIN ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
			txtUsername.setText(null);
			txtPassword.setText(null);
		}
	}
}

