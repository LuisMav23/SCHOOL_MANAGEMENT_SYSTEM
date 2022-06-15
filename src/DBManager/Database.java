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

    public static Object[] getStudentInfo(int id){
        Object[] studentInfo = {};
        try{
            Statement stm = ServerConnection.createStatement();
            String sqlstm = "SELECT * FROM STUDENT WHERE STUDENT_ID = " + Integer.toString(id) + ";";
            ResultSet rs = stm.executeQuery(sqlstm);

            if (rs.next()){
                studentInfo[0] = rs.getInt(1);      //STUDENT_ID
                studentInfo[2] = rs.getString(3);   //LAST_NAME
                studentInfo[1] = rs.getString(2);   //FIRST_NAME
                studentInfo[3] = rs.getString(4);   //MIDDLE_NAME
                studentInfo[4] = rs.getString(5);   //GENDER
                studentInfo[5] = rs.getString(6);   //DEGREE_PROGRAM
                studentInfo[6] = rs.getInt(7);      //YEAR_LEVEL
                studentInfo[7] = rs.getInt(8);      //BLOCK_NUMBER
                studentInfo[8] = rs.getInt(9);      //DEPARTMENT_HEAD_ID
                studentInfo[9] = rs.getString(10);  //STATUS
                studentInfo[10] = rs.getString(11); //SCHOOL_EMAIL
                studentInfo[11] = rs.getString(12); //CONTACT_NUMBER
            }
            return studentInfo;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    

}
