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
	}
}
