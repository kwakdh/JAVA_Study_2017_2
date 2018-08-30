package jdbc2;

import java.sql.*;
import java.util.*;

import com.mysql.jdbc.PreparedStatement;

public class studentDAO {

	/*
	 * 1. 학생 레코드 삽입
	 * 2. 특정 학번에 해당하는 학생 레코드 삭제 
	 * 3. 특정 학번에 학생정보수정
	 * 4. 모든 학생 레코드 인출
	 * 
	 * 
	 * */
	private String url ="jdbc:mysql://210.101.230.2:3306/java";
	private String user ="s1601012";
	private String passwd = "p1601012";
    
	 private Connection getConnection(){
		 
		  Connection con= null;
	  try {
			Class.forName("com.mysql.jdbc.Driver");//jdbc드라이버 찾기 
			con = DriverManager.getConnection(url,user,passwd);	//서버 연결하기		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return con;
		  
	  }
	  
	//1.학생 레코드 삽입
	public void insert(Student s){
	 
	 Connection con = getConnection();
	 String sql = "insert into student values(?,?,?,?,?,?)";
	  
	 try{

		 PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
			
		 ps.setString(1,s.getSid());
		 ps.setString(2,s.getName());
		 ps.setString(3,s.getDept());
		 ps.setString(4,s.getMajor());
		 ps.setString(5,s.getPhone());
		 ps.setInt(6,s.getEntYear());
		 
		 ps.executeUpdate();
		 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
    }
	
	//2.특정 학생 의 학번의  삭제 
	public void delete(String argSid){
		Connection con = getConnection();
		 
		  
		 try{
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	
	//3.학생레코드 수정 (학번 가지고와서 해야되니까 !!!)-- 학생 정보 다 가지고 와야 하니까 
	public void update(Student argStudent){
		Connection con = getConnection();
		 
		  
		 try{
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}

	//4.학생정보 인출
	public ArrayList<Student> selectAll(){
		
		ArrayList<Student> list = new ArrayList<>();
		Connection con = getConnection();
		String sql = "select * from Student"; 
		  
		 try{
				//실행준비
          	PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
			
          	ResultSet rs = ps.executeQuery(); //ResultSet라는 결과집합에 반환된다
          	while(rs.next()){
          	  String sid =rs.getString("sid");
          	  String name =rs.getString("name");
          	  String dept =rs.getString("dept");
          	  String major =rs.getString("major");
          	  String phone =rs.getString("phone");
              int entYear = rs.getInt("entYear");
              
              Student std = new Student(sid,name,dept,major,phone,entYear);
              list.add(std);
          		
          	}
			 return list;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return list;
		
	}
	
}
