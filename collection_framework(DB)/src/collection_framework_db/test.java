package suUp4_3;
import java.sql.*;

public class test {
   static String dbURL = "jdbc:mysql://210.101.230.2:3306/java";
   static String userName = "s1601012"; //s�й�...
   static String passwd = "p1601012"; // p�й�
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      Connection con = null;
      try {
         // 1. �޸𸮷� JDBC Driver�� �о���δ�. 
         Class.forName("com.mysql.jdbc.Driver");
         
         // 2. DB Server���� �����Ѵ�. 
         con = DriverManager.getConnection(dbURL, userName, passwd);
         System.out.println("���� ����!!!!");
         
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