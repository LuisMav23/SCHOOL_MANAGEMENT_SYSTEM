package SMSApp;

import java.awt.EventQueue;

import DBManager.Database;

public class Main {
	public static void main(String[] args) {
		// Database.connect();
		// EventQueue.invokeLater(new Runnable() {
		// 	public void run() {
		// 		try {
		// 			LoginWindow frame = new LoginWindow();
		// 			frame.setVisible(true);
		// 		} catch (Exception e) {
		// 			e.printStackTrace();
		// 		}
		// 	}
		// });
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		var h = Database.generateEmail("Gabriel", "Luis Maverick", "Lazaro", 3782);
		System.out.println(h);
	}
}
