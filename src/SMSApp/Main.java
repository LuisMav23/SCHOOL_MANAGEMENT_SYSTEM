package SMSApp;

import java.awt.EventQueue;

import DBManager.Database;

public class Main {
	public static void main(String[] args) { 
		String user = "root";
		String password = "GABRIEL232514";
		Database.connect(user, password);
		Database.updateStudentDB();
		Database.updateFacultyDB();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		// EventQueue.invokeLater(new Runnable() {
		// 	public void run() {
		// 		try {
		// 			MainWindow frame = new MainWindow();
		// 			frame.setVisible(true);
		// 		} catch (Exception e) {
		// 			e.printStackTrace();
		// 		}
		// 	}
		// });
	}
}
