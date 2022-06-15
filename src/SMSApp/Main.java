package SMSApp;

import java.awt.EventQueue;

import DBManager.Database;

public class Main {
	public static void main(String[] args) {
		Database.connect();
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
		
		// Database.addStudent(new Object[]{2, "w", "w", "w", "M", "BSCPE", 1, 1, 1, "REGULAR", "L", "L"});

		
		
		// var h = Database.generateEmail("Gabriel", "Luis Maverick", "Lazaro", 3782);
		// for (int i = 1; i < 40; i++){
		// 	var data = Database.getFacultyInfo(i);
		// 	for (Object obj : data){
		// 		System.out.print(obj + "\t\t");
		// 	}
		// 	System.out.println();
		// }
	}
}
