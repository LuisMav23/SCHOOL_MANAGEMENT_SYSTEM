package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
	private static Connection ServerConnection = null;
	

    /*********** PRIVATE METHODS **********/
	public static void connect(){
        if (ServerConnection == null){
            try {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }  
                ServerConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/School_Management_System","root","GABRIEL232514");
                // System.out.print("Connection Successful");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }  
        } else {
            System.out.println("Connection Already Established");
        }
    }


    
    /* CONFIRM LOGIN BY SEARCHING ADMIN TABLE */
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



    /* GENERATE AN EMAIL BASED ON THE NAME AND ID OF THE STUDENT */
    public static String generateEmail(String surname, String firstname, String middlename, int id){
        String Email = "";

        char[] fnameArr = firstname.toLowerCase().toCharArray();
        Email += fnameArr[0];
        for (int i = 0; i < fnameArr.length; i++){
            char c = fnameArr[i];
            if (c == ' ' && (i + 1) < fnameArr.length){
                Email += fnameArr[i + 1];
            }
        }
        if (!middlename.isBlank()) {
            
            char[] mnameArr = middlename.toLowerCase().toCharArray();
            Email += mnameArr[0];
            for (int i = 0; i < middlename.length(); i++){
                char c = mnameArr[i];
                if (c == ' ') {
                    Email += mnameArr[i + 1];
                }
            }
        }

        char[] snameArr = surname.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();  
        for (int i = 0; i < snameArr.length; i++) {  
            if ((snameArr[i] != ' ') && (snameArr[i] != '\t')) {  
                stringBuffer.append(snameArr[i]);  
            }  
        }  
        String surNew = stringBuffer.toString();  

        String idChar = Integer.toString(id);

        Email += surNew + idChar + "@scu.edu.ph";

        return Email;
    }



    /* FINDS ALL THE ROWS IN A TABLE */
    public static int getRowCount(String table) {
        try{
            Statement stm = ServerConnection.createStatement();
            String sqlstm = "SELECT COUNT(*) FROM " + table + ";";
            ResultSet rs = stm.executeQuery(sqlstm);

            if (rs.next()){
                return rs.getInt(0);
            }
            else{
                return 0;
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return 0;
        }
    }

/**************************************************** STUDENT ****************************************************/

    /* FINDS ALL STUDENTS THAT MATCHES THE SEACRH KEYWORD */
    public static List<Object[]> searchStudent(String keyword){
        List<Object[]> students = new ArrayList<>();
        try{
            if (keyword.isBlank()){
                Statement stm = ServerConnection.createStatement();
                String sqlstm = "SELECT * FROM STUDENT LIMIT 5000;";
                ResultSet rs = stm.executeQuery(sqlstm);
                while(rs.next()){
                    students.add(setStudentInfoArray(rs));
                }
                return students;
            }
            else {
                Statement stm = ServerConnection.createStatement();
                String sqlstm = "SELECT * FROM STUDENT WHERE LAST_NAME LIKE '%" + keyword + 
                                "%' OR FIRST_NAME LIKE '%" + keyword + 
                                "%' OR MIDDLE_NAME LIKE '%" + keyword + 
                                "%' OR GENDER LIKE '%" + keyword + 
                                "%' OR DEGREE_PROGRAM LIKE '%" + keyword + 
                                "%' OR STATUS LIKE '%" + keyword + 
                                "%' OR SCHOOL_EMAIL LIKE '%" + keyword + "%' LIMIT 5000;";
                ResultSet rs = stm.executeQuery(sqlstm);
                while(rs.next()){
                    students.add(setStudentInfoArray(rs));
                }
                return students;
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
        
    }


    /* DELETES STUDENT */
    public static boolean deleteStudent(int id) {
        try{
            Statement stm = ServerConnection.createStatement();
            String sqlstm = "DELETE FROM STUDENT WHERE STUDENT_ID = " + Integer.toString(id) + ";"; 
            

            stm.execute(sqlstm);
            return true;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }


    /* SEACH ALL STUDENT USING THE ID */
    public static List<Object[]> searchStudentByID(int id){
        List<Object[]> students = new ArrayList<>();
        try{
            Statement stm = ServerConnection.createStatement();
            String sqlstm = "SELECT * FROM STUDENT WHERE STUDENT_ID =" + id + " LIMIT 5000;";
            ResultSet rs = stm.executeQuery(sqlstm);
            while(rs.next()){
                students.add(setStudentInfoArray(rs));
            }
            return students;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
        
    }



    /* GET ALL COURSES */
    public static List<String> getAllCourse(){
        List<String> course = new ArrayList<>();
        try{
            Statement stm = ServerConnection.createStatement();
            String sqlstm = "SELECT DEGREE_PROGRAM FROM COURSE;";
            ResultSet rs = stm.executeQuery(sqlstm);
            while(rs.next()){
                course.add(rs.getString(1));
            }
            return course;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }



    /* GETS COURSE HEAD ID */
    public static int getCourseHeadID(String course){
        try{
            Statement stm = ServerConnection.createStatement();
            String sqlstm = "SELECT DEPARTMENT_HEAD_ID FROM COURSE WHERE DEGREE_PROGRAM = '" + course + "';";
            ResultSet rs = stm.executeQuery(sqlstm);
            if(rs.next()){
                return rs.getInt(1);
            }
            else {
                return 0;
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return 0;
        }
    }



    /* ADD STUDENT TO DATABASE */
    public static boolean addStudent(Object[] studentInfo){
        try{
            String sqlstm = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = ServerConnection.prepareStatement(sqlstm);

            stm.setInt(1, (int)studentInfo[0]);         //STUDENT_ID 
            stm.setString(2, (String)studentInfo[1]);   //LAST_NAME
            stm.setString(3, (String)studentInfo[2]);   //FIRST_NAME
            stm.setString(4, (String)studentInfo[3]);   //MIDDLE_NAME
            stm.setString(5, (String)studentInfo[4]);   //GENDER
            stm.setString(6, (String)studentInfo[5]);   //DEGREE_PROGRAM
            stm.setInt(7, (int)studentInfo[6]);         //YEAR_LEVEL
            stm.setInt(8, (int)studentInfo[7]);         //BLOCK_NUMBER
            stm.setInt(9, (int)studentInfo[8]);         //DEPARTMENT_HEAD_ID
            stm.setString(10, (String)studentInfo[9]);  //STATUS
            stm.setString(11, (String)studentInfo[10]); //SCHOOL_EMAIL
            stm.setString(12, (String)studentInfo[11]); //CONTACT_NUMBER

            stm.execute();
            return true;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }



    /* GET ALL STUDENT INFO BY ID */
    public static Object[] getStudentInfo(int id){
        try{
            Statement stm = ServerConnection.createStatement();
            String sqlstm = "SELECT * FROM STUDENT WHERE STUDENT_ID = " + Integer.toString(id) + ";";
            ResultSet rs = stm.executeQuery(sqlstm);
            if (rs.next()){
                return setStudentInfoArray(rs);
            }
            else{
                return null;
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }


    
    /* UPDATE STUDENT EMAILS AND DEPARTMENT HEAD ID */
    public static void updateStudentDB(){
         try{
            
            Statement stm = ServerConnection.createStatement();
            var studentInfo = searchStudent("");
            for (Object[] obj : studentInfo){
                var generatedEmail = generateEmail((String)obj[1], (String)obj[2], (String)obj[3], (Integer)obj[0]);
                String email = "UPDATE STUDENT SET SCHOOL_EMAIL = '" + generatedEmail + "' WHERE STUDENT_ID = " + (Integer)obj[0] + ";";
                String HeadID = "UPDATE STUDENT SET DEPARTMENT_HEAD_ID = " + getCourseHeadID((String)obj[5]) + " WHERE STUDENT_ID = " + (Integer)obj[0] + ";";
                stm.execute(email); 
                stm.execute(HeadID); 
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public static boolean updateStudent(int id, Object[] info) {
        try{
            String sqlstm = "UPDATE STUDENT SET " +
                            "LAST_NAME = '" + (String)info[0] + "', " +
                            "FIRST_NAME = '" + (String)info[1] + "', " +
                            "MIDDLE_NAME = '" + (String)info[2] + "', " +
                            "GENDER = '" + (String)info[3] + "', " +
                            "DEGREE_PROGRAM = '" + (String)info[4] + "', " +
                            "YEAR_LEVEL = " + info[5]  + ", " +
                            "BLOCK_NUMBER = " + info[6]  + ", " +
                            "DEPARTMENT_HEAD_ID = " + info[7]  + ", " +
                            "STATUS = '" + (String)info[8] + "', " +
                            "SCHOOL_EMAIL = '" + (String)info[9] + "', " +
                            "CONTACT_NUMBER = '" + (String)info[10] + "' " +
                            "WHERE STUDENT_ID = " + id + " ;";
                            
            Statement stm = ServerConnection.createStatement();
            stm.execute(sqlstm);
            return true;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    /**************************************************** FACULTY ****************************************************/



    /* GET ALL FACULTY INFO BY ID*/
    public static Object[] getFacultyInfo(int id){
        
        try{
            Statement stm = ServerConnection.createStatement();
            String sqlstm = "SELECT * FROM FACULTY WHERE FACULTY_ID = " + Integer.toString(id) + ";";
            ResultSet rs = stm.executeQuery(sqlstm);
            if (rs.next()){
                return setFacultyInfoArray(rs);
            }
            else {
                return null;
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }



    /*********** END OF PUBLIC METHODS ************/

    private static Object[] setStudentInfoArray(ResultSet rs) throws SQLException{
        Object[] studentInfo = new Object[12];

        studentInfo[0] = rs.getInt(1);      //STUDENT_ID
        studentInfo[1] = rs.getString(2);   //LAST_NAME
        studentInfo[2] = rs.getString(3);   //FIRST_NAME
        studentInfo[3] = rs.getString(4);   //MIDDLE_NAME
        studentInfo[4] = rs.getString(5);   //GENDER
        studentInfo[5] = rs.getString(6);   //DEGREE_PROGRAM
        studentInfo[6] = rs.getInt(7);      //YEAR_LEVEL
        studentInfo[7] = rs.getInt(8);      //BLOCK_NUMBER
        studentInfo[8] = rs.getInt(9);      //DEPARTMENT_HEAD_ID
        studentInfo[9] = rs.getString(10);  //STATUS
        studentInfo[10] = rs.getString(11); //SCHOOL_EMAIL
        studentInfo[11] = rs.getString(12); //CONTACT_NUMBER
        return studentInfo;
    }

    private static Object[] setFacultyInfoArray(ResultSet rs) throws SQLException{
        Object[] facultyInfo = new Object[10];
        
        facultyInfo[0] = rs.getInt(1);      //FACULTY_ID
        facultyInfo[2] = rs.getString(3);   //LAST_NAME
        facultyInfo[1] = rs.getString(2);   //FIRST_NAME
        facultyInfo[3] = rs.getString(4);   //MIDDLE_NAME
        facultyInfo[4] = rs.getString(5);   //GENDER
        facultyInfo[5] = rs.getInt(6);      //DEPARTMENT_ID
        facultyInfo[6] = rs.getInt(7);      //SUPER_ID
        facultyInfo[7] = rs.getDouble(8);   //SALARY
        facultyInfo[8] = rs.getString(9);   //FACULTYL_EMAIL
        facultyInfo[9] = rs.getString(10);  //CONTACT_NUMBER
        return facultyInfo;
    }

    

}
