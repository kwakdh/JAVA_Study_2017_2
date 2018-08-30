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
         System.out.println("연결이 안되었습니다");
         return null;
      }
      try {
         String sql = "select * from board";
         PreparedStatement pstmt = con.prepareStatement(sql);
         // select 문을 수행할 때는 executeQuery 메소드를 호출한다. 
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
         System.out.println("연결이 안되었습니다");
         return ;
      }
      // Statement, PreparedStatement 객체가 필요하다.
      // Statement 객체는 실행할 SQL문이 고정된 경우에 사용하고
      // PreparedStatement 객체는 실행할 SQL문이 고정되지 않은 경우 사용.
      // 그래서 우리는 PreparedStatement 객체를 이용할 것이다. 
      // Statement 객체 사용방법은 알아서 공부해라.
      
      try {
         String sql = "insert into board(writer, title, content) values(?, ?, ?)";
         /* prepareStatement메소드를 호출하면 아래를 수행한다. 
          * 1. sql 문자열을 DB 서버에 보낸다. 
          * 2. DB 서버는 그 sql문을 파싱해서 문법적 오류가 없는지 검사하고
          * 3. 정당성 검사를 수행한다.(사용자가 이 SQL문을 수행할 권한이 있는지
          * board 테이블이 실제로 존재하는지, board 테이블에 writer, title, content 등의
          * 칼럼이 실제로 존재하는지 등을 검사한다. )
          * 4. 이 SQL문을 최적의 방법으로 수행하기 위한
          *    실행계획(execution plan)을 생성한다. 
          * 
          */
         PreparedStatement pstmt = con.prepareStatement(sql);
         pstmt.setString(1, board.getWriter());
         pstmt.setString(2, board.getTitle());
         pstmt.setString(3, board.getContent());
         
         // executeUpdate 메소드는 insert, delete, update 문 수행할 때 사용.
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
         // 1. 메모리로 JDBC Driver를 읽어들인다. 
         Class.forName(driverName);
         
         // 2. DB Server에게 연결한다. 
         con = DriverManager.getConnection(dbURL, userName, passwd);
         System.out.println("연결 성공!!!!");
         
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