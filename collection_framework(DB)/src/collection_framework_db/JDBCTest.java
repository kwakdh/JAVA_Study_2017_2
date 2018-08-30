package suUp4_3;

import java.sql.*;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-c generated method stub
         /* 
          * JDBC���α׷��� ����
          * 1. JDBC����̹��� �޸𸮿� ����  :Class.forName(..)
          * 2. DB 
          * server�� ������ �����Ѵ�.
          *    Connection con = 
          *            DriverManager, getConnection(...,...);
          *    --------------------> Connection ��ü�� ��ȯ�ȴ�.
          * 3. ���� ��ü�� ���� SQL���� �����Ѵ�.
          *  1) Statement��ü �̿��ؼ� �ϴ� ���
          *   Statement stmt =  con.createStatement();
          *   ResultSet rs = stmt.executeQuery("select * from...");//�޼ҵ� 
          *  2) PreparedStatement pstmt =con.prepareStatement(...);
          *     ResultSet rs = pstmt.executeQuery();
          *    ...
          *     
          * 4. �ݵ��!!!! con.close(); ���ֱ�!!! ���ϸ� ū�ϳ��ٿ� !!!(���� �����ִ� ����)              
          * */
		
		//JDBC����̹��� �޸𸮿� �ε��ϱ� 
		//JDBC����̹� �̸��� DBMS���� �ٸ��� . 
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			//Class.forName("com.mysql.jdbc.Driver"); //������ ���̸� try catch�� �̿��ϱ� !!
			//DB Server �� URL, �� URL ��ĵ� DBMS���� �ٸ��� 
			//DB ������� id�� ��ȣ 
			String url = "jdbc:orcle:thin:@localhost:1521/java";
			String user = "s1601012";
			String passwd="p1601012";
			//con= DriverManager.getConnection(url,user,passwd);
			con= DriverManager.getConnection("jdbc:orcle:thin:@localhost:1521/orcl");
			
			
			
			
			String sql ="select * from test";
			Statement stmt = con.createStatement();
			/*
			 * executeQuery()�޼ҵ� :select��
			 * exxecuteUpdate()�޼ҵ�:select���� ������ DML
			 * Data Manipulation Language(insert,delete,update)
			 * */
			
			ResultSet rs = stmt.executeQuery(sql);
			//ResultSet ������ �����̴� �ణ iterator�� ����ϴٰ� �����ϸ� ���ϴ� .
			//   next�� true�ε��� record�� ������ �ȴ� 
			/*
			create table test{
			id int,
			name varchar(32);
			phone varchar(32);}
			*/
			while(rs.next()){
				int id = rs.getInt("id");  
				//rs.getInt(1); //1���� �����ؼ� �ε��� 1���� �ص� �ȴ� 
				String name = rs.getString("name");
				String phone = rs.getString("phone");
			  //....ó��.....
			
			}
			sql ="insert into test(id,name,phone) values(3,'ȫ�浿','010-1234-5678)";
			stmt.executeUpdate(sql);
			
			//con.close(); //���⿡ Ŭ�ν� ���ָ� ���� �տ��� �������� catch������ �̵��Ǳ⶧���� close�� �ȵȴ�....
			//-------------------->final�ȿ� �־��ֱ�                
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{try{con.close();}catch(SQLException e){
			
			e.printStackTrace();}
		
		}
		
		
		
		
		
		
		
		
		
	}

}
