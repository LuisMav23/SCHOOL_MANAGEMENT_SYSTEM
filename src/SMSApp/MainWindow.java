package SMSApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel HeaderPanel;
	private JPanel ContentCardPanel;
	private JButton btnStudent;
	private JLabel lblLogo;
	private JButton btnFaculty;
	private JButton btnCourse;
	private JButton btnLibrary;
	private JButton btnAdmin;
	private JButton btnLogOut;
	private StudentPanel StudentPanel;
	private JPanel FacultyPanel;
	private JPanel CoursePanel;
	private JPanel LibraryPanel;
	private JPanel AdminPanel;

	/**
	 * Launch the application.
	 */

	/****** Create the frame ******/
	public MainWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		HeaderPanel = new JPanel(){
	        @Override
	        protected void paintComponent(Graphics grphcs) {
	            super.paintComponent(grphcs);
	            Graphics2D g2d = (Graphics2D) grphcs;
	            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                    RenderingHints.VALUE_ANTIALIAS_ON);
	            GradientPaint gp = new GradientPaint(0, 0,
	                    Color.decode("#3a1c71"), 0, getHeight(),
	                    Color.decode("#ffaf7b"));
	            g2d.setPaint(gp);
	            g2d.fillRect(0, 0, getWidth(), getHeight()); 

	        }

	    };
		HeaderPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		HeaderPanel.setBackground(Color.RED);
		HeaderPanel.setBounds(0, 0, 1500, 100);
		contentPane.add(HeaderPanel);
		HeaderPanel.setLayout(null);
		
		btnStudent = new JButton("STUDENT");
		// btnStudent.addMouseListener(new MouseAdapter() {
		// 	@Override
		// 	public void mouseEntered(MouseEvent e) {
		// 		btnStudent.setBorder(new MatteBorder(0, 1, 0, 1, Color.decode("#3a1c71")));
		// 		btnStudent.setForeground(Color.BLACK);
		// 		btnStudent.setContentAreaFilled(true);
		// 	}
		// 	@Override
		// 	public void mouseExited(MouseEvent e) {
		// 		btnStudent.setBorder(null);
		// 		btnStudent.setForeground(Color.WHITE);
		// 		btnStudent.setContentAreaFilled(false);
		// 	}
		// 	@Override
		// 	public void mousePressed(MouseEvent e) {
		// 		btnStudent.setBackground(Color.decode("#8644ff"));
		// 	}
		// 	@Override
		// 	public void mouseReleased(MouseEvent e) {
		// 		btnStudent.setBackground(Color.decode("#763ddd"));
		// 	}
		// });
		btnStudent.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		btnStudent.setForeground(Color.WHITE);
		btnStudent.setBounds(400, 1, 170, 100);
		btnStudent.setOpaque(false);
		btnStudent.setContentAreaFilled(false);
		btnStudent.setBorder(null);
		btnStudent.setBackground(Color.decode("#763ddd"));
		btnStudent.addActionListener(this);
		HeaderPanel.add(btnStudent);
		
		lblLogo = new JLabel("LOGO");
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(10, 1, 100, 100);
		HeaderPanel.add(lblLogo);
		
		btnFaculty = new JButton("FACULTY");
		btnFaculty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnFaculty.setOpaque(false);
		btnFaculty.setForeground(Color.WHITE);
		btnFaculty.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		btnFaculty.setContentAreaFilled(false);
		btnFaculty.setBorder(null);
		btnFaculty.setBounds(570, 1, 170, 100);
		btnFaculty.addActionListener(this);
		HeaderPanel.add(btnFaculty);
		
		btnCourse = new JButton("COURSES");
		btnCourse.setOpaque(false);
		btnCourse.setForeground(Color.WHITE);
		btnCourse.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		btnCourse.setContentAreaFilled(false);
		btnCourse.setBorder(null);
		btnCourse.setBounds(740, 1, 170, 100);
		btnCourse.addActionListener(this);
		HeaderPanel.add(btnCourse);
		
		btnLibrary = new JButton("LIBRARY");
		btnLibrary.setOpaque(false);
		btnLibrary.setForeground(Color.WHITE);
		btnLibrary.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		btnLibrary.setContentAreaFilled(false);
		btnLibrary.setBorder(null);
		btnLibrary.setBounds(910, 1, 170, 100);
		btnLibrary.addActionListener(this);
		HeaderPanel.add(btnLibrary);
		
		btnAdmin = new JButton("ADMIN");
		btnAdmin.setOpaque(false);
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		btnAdmin.setContentAreaFilled(false);
		btnAdmin.setBorder(null);
		btnAdmin.setBounds(1080, 1, 170, 100);
		btnAdmin.addActionListener(this);
		HeaderPanel.add(btnAdmin);
		
		btnLogOut = new JButton("LOG OUT");
		btnLogOut.setOpaque(false);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBorder(null);
		btnLogOut.setBounds(1249, 1, 241, 100);
		btnLogOut.addActionListener(this);
		HeaderPanel.add(btnLogOut);
		
		
		ContentCardPanel = new JPanel();
		ContentCardPanel.setBounds(0, 100, 1500, 663);
		contentPane.add(ContentCardPanel);
		ContentCardPanel.setLayout(new CardLayout(0, 0));
		
		StudentPanel = new StudentPanel();
		ContentCardPanel.add(StudentPanel, "Student Panel");
		
		FacultyPanel = new FacultyPanel();
		ContentCardPanel.add(FacultyPanel, "Faculty Panel");
		
		CoursePanel = new JPanel();
		CoursePanel.setBackground(new Color(102, 255, 255));
		ContentCardPanel.add(CoursePanel, "Course Panel");
		
		LibraryPanel = new JPanel();
		LibraryPanel.setBackground(new Color(255, 204, 102));
		ContentCardPanel.add(LibraryPanel, "Library Panel");
		
		AdminPanel = new JPanel();
		AdminPanel.setBackground(new Color(102, 0, 255));
		ContentCardPanel.add(AdminPanel, "Admin Panel");
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStudent) {
			CardLayout cl = (CardLayout)(ContentCardPanel.getLayout());
		    cl.show(ContentCardPanel, "Student Panel");
		}
		else if (e.getSource() == btnFaculty) {
			CardLayout cl = (CardLayout)(ContentCardPanel.getLayout());
		    cl.show(ContentCardPanel, "Faculty Panel");
		}
		else if (e.getSource() == btnCourse) {
			CardLayout cl = (CardLayout)(ContentCardPanel.getLayout());
		    cl.show(ContentCardPanel, "Course Panel");
		}
		else if (e.getSource() == btnLibrary) {
			CardLayout cl = (CardLayout)(ContentCardPanel.getLayout());
		    cl.show(ContentCardPanel, "Library Panel");
		}
		else if (e.getSource() == btnAdmin) {
			CardLayout cl = (CardLayout)(ContentCardPanel.getLayout());
		    cl.show(ContentCardPanel, "Admin Panel");
		}
	}
}
