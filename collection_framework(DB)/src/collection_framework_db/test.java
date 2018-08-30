package suUp4_3;
import java.sql.*;

public class test {
   static String dbURL = "jdbc:mysql://210.101.230.2:3306/java";
   static String userName = "s1601012"; //s학번...
   static String passwd = "p1601012"; // p학번
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      Connection con = null;
      try {
         // 1. 메모리로 JDBC Driver를 읽어들인다. 
         Class.forName("com.mysql.jdbc.Driver");
         
         // 2. DB Server에게 연결한다. 
         con = DriverManager.getConnection(dbURL, userName, passwd);
         System.out.println("연결 성공!!!!");
         
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         try {
            con.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }

}