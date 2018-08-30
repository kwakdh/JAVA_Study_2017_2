package jdbc2;

import java.sql.*;
import java.util.*;

import com.mysql.jdbc.PreparedStatement;

public class studentDAO {

	/*
	 * 1. �л� ���ڵ� ����
	 * 2. Ư�� �й��� �ش��ϴ� �л� ���ڵ� ���� 
	 * 3. Ư�� �й��� �л���������
	 * 4. ��� �л� ���ڵ� ����
	 * 
	 * 
	 * */
	private String url ="jdbc:mysql://210.101.230.2:3306/java";
	private String user ="s1601012";
	private String passwd = "p1601012";
    
	 private Connection getConnection(){
		 
		  Connection con= null;
	  try {
			Class.forName("com.mysql.jdbc.Driver");//jdbc����̹� ã�� 
			con = DriverManager.getConnection(url,user,passwd);	//���� �����ϱ�		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return con;
		  
	  }
	  
	//1.�л� ���ڵ� ����
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
	
	//2.Ư�� �л� �� �й���  ���� 
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
	
	//3.�л����ڵ� ���� (�й� ������ͼ� �ؾߵǴϱ� !!!)-- �л� ���� �� ������ �;� �ϴϱ� 
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

	//4.�л����� ����
	public ArrayList<Student> selectAll(){
		
		ArrayList<Student> list = new ArrayList<>();
		Connection con = getConnection();
		String sql = "select * from Student"; 
		  
		 try{
				//�����غ�
          	PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
			
          	ResultSet rs = ps.executeQuery(); //ResultSet��� ������տ� ��ȯ�ȴ�
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
