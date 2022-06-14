package SMSApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel HeaderPanel;
	private JPanel ContentPanel;

	/**
	 * Launch the application.
	 */

	/****** Create the frame ******/
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		HeaderPanel = new JPanel();
		HeaderPanel.setBackground(Color.RED);
		HeaderPanel.setBounds(0, 0, 1500, 100);
		contentPane.add(HeaderPanel);
		
		ContentPanel = new JPanel();
		ContentPanel.setBounds(0, 101, 1500, 700);
		contentPane.add(ContentPanel);
	}

}
