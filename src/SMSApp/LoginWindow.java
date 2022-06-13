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
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoginWindow extends JFrame {

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
	

	/* UNCOMMENT NYO TO KUNG USTO NYO MA RUN HEHE <3 */
	// Pag ayaw comment nyo din pala yung package

	// public static void main(String[] args) {
	// 	EventQueue.invokeLater(new Runnable() {
	// 		public void run() {
	// 			try {
	// 				LoginWindow frame = new LoginWindow();
	// 				frame.setVisible(true);
	// 			} catch (Exception e) {
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	});
	// }

	
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
	                    Color.decode("#647bfd"), 0, getHeight(),
	                    Color.decode("#a63dfd"));
	            g2d.setPaint(gp);
	            g2d.fillRect(0, 0, getWidth(), getHeight()); 

	        }

	    };
		
		contentPane.setBackground(new Color(102, 51, 255));;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LoginPanel = new JPanel();
		LoginPanel.setBackground(new Color(255, 255, 255));
		LoginPanel.setBounds(851, 48, 508, 639);
		contentPane.add(LoginPanel);
		LoginPanel.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(31, 401, 450, 46);
		LoginPanel.add(txtPassword);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		txtPassword.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		
				
		txtUsername = new JTextField();
		txtUsername.setBounds(31, 272, 450, 46);
		LoginPanel.add(txtUsername);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsername.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		txtUsername.setColumns(10);
		
		lblUsername = new JLabel("Username\r\n");
		lblUsername.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
		lblUsername.setIcon(null);
		lblUsername.setBounds(31, 216, 205, 46);
		LoginPanel.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
		lblPassword.setIcon(null);
		lblPassword.setBounds(31, 345, 205, 46);
		LoginPanel.add(lblPassword);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(102, 0, 255));
		btnLogin.setBorder(new LineBorder(new Color(51, 0, 153), 4, true));
		btnLogin.setBounds(152, 508, 192, 64);
		LoginPanel.add(btnLogin);
		
		lblAdminLogin = new JLabel("ADMIN LOGIN");
		lblAdminLogin.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setBounds(31, 70, 450, 54);
		LoginPanel.add(lblAdminLogin);
		
		lblSepBottom = new JLabel("");
		lblSepBottom.setBounds(62, 128, 388, 13);
		lblSepBottom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		LoginPanel.add(lblSepBottom);
		
		lblSepTop = new JLabel("");
		lblSepTop.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblSepTop.setBounds(62, 47, 388, 13);
		LoginPanel.add(lblSepTop);
		setLocationRelativeTo(null);
	}

}

