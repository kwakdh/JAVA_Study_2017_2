package suUp4_3;

import java.sql.*;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-c generated method stub
         /* 
          * JDBC프로그래밍 절차
          * 1. JDBC드라이버를 메모리에 적재  :Class.forName(..)
          * 2. DB 
          * server와 연결을 설립한다.
          *    Connection con = 
          *            DriverManager, getConnection(...,...);
          *    --------------------> Connection 객체가 반환된다.
          * 3. 연결 객체를 통해 SQL문을 수행한다.
          *  1) Statement객체 이용해서 하는 방법
          *   Statement stmt =  con.createStatement();
          *   ResultSet rs = stmt.executeQuery("select * from...");//메소드 
          *  2) PreparedStatement pstmt =con.prepareStatement(...);
          *     ResultSet rs = pstmt.executeQuery();
          *    ...
          *     
          * 4. 반드시!!!! con.close(); 해주기!!! 안하면 큰일난다요 !!!(연결 끊어주는 역할)              
          * */
		
		//JDBC드라이버를 메모리에 로딩하기 
		//JDBC드라이버 이름은 DBMS마다 다르다 . 
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			//Class.forName("com.mysql.jdbc.Driver"); //빨간줄 그이면 try catch문 이용하기 !!
			//DB Server 의 URL, 이 URL 양식도 DBMS마다 다르다 
			//DB 사용자의 id와 암호 
			String url = "jdbc:orcle:thin:@localhost:1521/java";
			String user = "s1601012";
			String passwd="p1601012";
			//con= DriverManager.getConnection(url,user,passwd);
			con= DriverManager.getConnection("jdbc:orcle:thin:@localhost:1521/orcl");
			
			
			
			
			String sql ="select * from test";
			Statement stmt = con.createStatement();
			/*
			 * executeQuery()메소드 :select문
			 * exxecuteUpdate()메소드:select문을 제외한 DML
			 * Data Manipulation Language(insert,delete,update)
			 * */
			
			ResultSet rs = stmt.executeQuery(sql);
			//ResultSet 포인터 개념이다 약간 iterator과 비슷하다고 생각하면 도니다 .
			//   next가 true인동안 record를 빼오면 된다 
			/*
			create table test{
			id int,
			name varchar(32);
			phone varchar(32);}
			*/
			while(rs.next()){
				int id = rs.getInt("id");  
				//rs.getInt(1); //1부터 시작해서 인덱스 1부터 해도 된다 
				String name = rs.getString("name");
				String phone = rs.getString("phone");
			  //....처리.....
			
			}
			sql ="insert into test(id,name,phone) values(3,'홍길동','010-1234-5678)";
			stmt.executeUpdate(sql);
			
			//con.close(); //여기에 클로스 해주면 만약 앞에서 오류나면 catch문으로 이동되기때문에 close가 안된다....
			//-------------------->final안에 넣어주기                
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{try{con.close();}catch(SQLException e){
			
			e.printStackTrace();}
		
		}
		
		
		
		
		
		
		
		
		
	}

}
