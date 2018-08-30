package suUp4_3;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class BoardDAO {
   private String dbURL = null;
   private String userName = null;
   private String passwd = null;
   private String driverName = null;
   
   private String fileName = "database.properties";
   private Properties prop = new Properties();
   
   public BoardDAO() throws Exception{
      init();
      if(dbURL == null || userName==null || passwd == null || driverName==null)
         throw new Exception("There are some problems with database.properties file");
   }
   
   public ArrayList<Board> select() {
      ArrayList<Board> list = new ArrayList<Board>();
      Connection con = null;
      con = getConnection();
      if (con == null) {
         System.out.println("������ �ȵǾ����ϴ�");
         return null;
      }
      try {
         String sql = "select * from board";
         PreparedStatement pstmt = con.prepareStatement(sql);
         // select ���� ������ ���� executeQuery �޼ҵ带 ȣ���Ѵ�. 
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            int bno = rs.getInt("bno");
            String writer = rs.getString("writer");
            String title = rs.getString("title");
            String content = rs.getString("content");
            int viewCnt = rs.getInt("viewCnt");
            Timestamp regDate = rs.getTimestamp("regDate");
            
            Board board = new Board(writer, title, content);
            board.setBno(bno);
           // board.setRegDate(regDate);
            //board.setViewCnt(viewCnt);
            
            list.add(board);
         }
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            con.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      return list;
   }
   
   public void insert(Board board) {
      Connection con = null;
      con = getConnection();
      if (con == null) {
         System.out.println("������ �ȵǾ����ϴ�");
         return ;
      }
      // Statement, PreparedStatement ��ü�� �ʿ��ϴ�.
      // Statement ��ü�� ������ SQL���� ������ ��쿡 ����ϰ�
      // PreparedStatement ��ü�� ������ SQL���� �������� ���� ��� ���.
      // �׷��� �츮�� PreparedStatement ��ü�� �̿��� ���̴�. 
      // Statement ��ü ������� �˾Ƽ� �����ض�.
      
      try {
         String sql = "insert into board(writer, title, content) values(?, ?, ?)";
         /* prepareStatement�޼ҵ带 ȣ���ϸ� �Ʒ��� �����Ѵ�. 
          * 1. sql ���ڿ��� DB ������ ������. 
          * 2. DB ������ �� sql���� �Ľ��ؼ� ������ ������ ������ �˻��ϰ�
          * 3. ���缺 �˻縦 �����Ѵ�.(����ڰ� �� SQL���� ������ ������ �ִ���
          * board ���̺��� ������ �����ϴ���, board ���̺� writer, title, content ����
          * Į���� ������ �����ϴ��� ���� �˻��Ѵ�. )
          * 4. �� SQL���� ������ ������� �����ϱ� ����
          *    �����ȹ(execution plan)�� �����Ѵ�. 
          * 
          */
         PreparedStatement pstmt = con.prepareStatement(sql);
         pstmt.setString(1, board.getWriter());
         pstmt.setString(2, board.getTitle());
         pstmt.setString(3, board.getContent());
         
         // executeUpdate �޼ҵ�� insert, delete, update �� ������ �� ���.
         pstmt.executeUpdate();
         
      }catch(Exception e) {
         
      }finally {
         try {
            con.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      
      
   }
   
   private Connection getConnection() {
      Connection con = null;
      try {
         // 1. �޸𸮷� JDBC Driver�� �о���δ�. 
         Class.forName(driverName);
         
         // 2. DB Server���� �����Ѵ�. 
         con = DriverManager.getConnection(dbURL, userName, passwd);
         System.out.println("���� ����!!!!");
         
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return con;
   }
   
   private void init() {
      FileInputStream fi = null;
      try {
         fi = new FileInputStream(fileName);
         prop.load(fi);
         if(prop.getProperty("dbURL")!=null) {
            dbURL = prop.getProperty("dbURL");
         }
         if(prop.getProperty("userName")!=null) {
            userName = prop.getProperty("userName");
         }
         if(prop.getProperty("password")!=null) {
            passwd = prop.getProperty("password");
         }
         if(prop.getProperty("driverName")!=null) {
            driverName = prop.getProperty("driverName");
         }
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         try {
            fi.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
   }
   

}