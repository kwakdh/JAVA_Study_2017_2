package jdbc3;

import java.sql.*;
import java.util.ArrayList;

import com.mysql.*;

public class BoardDAO {

	//Connection 
	//Statement,PreparedStatement
	//executeUpdatem,executeQurey
	//ResultSet
	
	private String url = "jdbc:mysql://210.101.230.2:3306/java";
	private String user = "s1601012";
	private String passwd ="p1601012";
	
	public void insert(Board board){
		
		//bno,writer,content,title,redGate,viewCnt
		//bno value is automatically assigned.
		//viewCnt ... default value 0
		//regDate ... default value now()
		//required value: writer, content, title
		//String sql ="";
		
	    Connection con =getConnection();
	    String sql = "insert into board (writer,title,content) values(?,?,?)";
	    try{
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    //�ʿ��� �� ����...
	    pstmt.setString(1,board.getWriter());
	    pstmt.setString(2, board.getTitle());
	    pstmt.setString(3, board.getContent());
	    //����
	    pstmt.executeUpdate();
	    }
	    catch(Exception e){
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
	public void delete(int bno){
		
		Connection con =getConnection();
		String sql ="delete from board where bno=?";
	  
		try{
			
	    	PreparedStatement pstmt =con.prepareStatement(sql);
	    	
	    	pstmt.setInt(1, bno);
	    	
	    	pstmt.executeUpdate();
	    	
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
	public void update(Board board){
		Connection con =getConnection();
		
		if(con == null){
			System.out.println("���� ����");
			return;
		}
		
		String sql ="update board set title=?, wirter=?, content=? where bno=?";
	    
		try{
			
	    	PreparedStatement pstmt =con.prepareStatement(sql);
	        pstmt.setString(1,board.getTitle());
	        pstmt.setString(2,board.getWriter());
	        pstmt.setString(3,board.getContent());
	        pstmt.setInt(4, board.getBno());
	    	pstmt.executeUpdate();
	    	
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
	public void select(){
		
		Connection con =getConnection();
		if(con == null){
			System.out.println("���� ����");
		   return ;
		}
		
		
		String sql ="select * from board";
		try{
	    PreparedStatement stmt = con.prepareStatement(sql);
	    //�ʿ��� �� ����...
	    //����
	    ResultSet rs =stmt.executeQuery();// ���� �ҽ��ڵ�� �ٸ��� 
	    //ResultSet ó���ϴ� �ڵ�...
	    while(rs.next()){
	    
	    	int  bno=rs.getInt("bno");
	    	String w=rs.getString("writer");
	    	String c=rs.getString("content");
	    	
	    	System.out.println(bno+", "+w+", "+c);
	    	
	    }
		}catch(Exception e){
			
		}
		finally{
	    try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public Board select(int bno){
		Board board = null;
		
		Connection con =getConnection();
		if(con == null){
			System.out.println("���� ����");
			return board; 
		}
		
		String sql ="select * from board where bno = ?";
		
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
		    pstmt.setInt(1, bno);
		    
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				
				int b = rs.getInt("bno");
				String w = rs.getString("writer");
				String t = rs.getString("title");
				String c = rs.getString("content");
				int v = rs.getInt("viewCnt");
				Timestamp r = rs.getTimestamp("regDate");
				board = new Board(b, w, t, c, r, v);
				
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		  try {
			con.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		   }
	    }
		
		return board;
	}
	
	public ArrayList<Board> select(String writer){
		
		ArrayList<Board> list = null;
		Board board = null;
		Connection con =getConnection();
		if(con == null){
			System.out.println("���� ����");
			return list; 
		}
		
		String sql ="select * from board where writer = ?";
		
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
		    pstmt.setString(1, writer);
		    
			ResultSet rs = pstmt.executeQuery();
			list =new ArrayList<>();
			
			
			while(rs.next()){
				
				int b = rs.getInt("bno");
				String w = rs.getString("writer");
				String t = rs.getString("title");
				String c = rs.getString("content");
				int v = rs.getInt("viewCnt");
				Timestamp r = rs.getTimestamp("regDate");
				board = new Board(b, w, t, c, r, v);
				list.add(board);
				
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		  try {
			con.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		   }
	    }
		
		return list;
		
	}

	private Connection getConnection(){
		Connection con =null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,passwd);
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
	
	
}
