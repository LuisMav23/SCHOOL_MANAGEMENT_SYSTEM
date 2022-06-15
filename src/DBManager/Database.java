package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private static Connection ServerConnection = null;
	
	public static void connect(){
        if (ServerConnection == null){
            try {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }  
                ServerConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/School_Management_System","root","GABRIEL232514");
                // System.out.print("Connection Successful");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }  
        } else {
            System.out.println("Connection Already Established");
        }
    }

    public static boolean confirmLogin(String U, char[] P){
        var Pword = "";
        for (int i = 0; i < P.length; i++){
            Pword += P[i]; 
        }

        try {
            Statement stm = ServerConnection.createStatement();
            
            String sqlstm = "SELECT * FROM ADMIN WHERE USERNAME = '" + U + "' AND PASSWORD = '" + Pword + "';";
            ResultSet rs = stm.executeQuery(sqlstm);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String generateEmail(String surname, String firstname, String middlename, int id){
        String Email = "";

        char[] fnameArr = firstname.toLowerCase().toCharArray();
        Email += fnameArr[0];
        for (int i = 0; i < fnameArr.length; i++){
            char c = fnameArr[i];
            if (c == ' ') {
                Email += fnameArr[i + 1];
            }
        }

        char[] mnameArr = middlename.toLowerCase().toCharArray();
        Email += mnameArr[0];
        for (int i = 0; i < middlename.length(); i++){
            char c = mnameArr[i];
            if (c == ' ') {
                Email += mnameArr[i + 1];
            }
        }

        String idChar = Integer.toString(id);

        Email += surname.toLowerCase() + idChar + "@plm.edu.ph";

        return Email;
    }
}
