package JDBC_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	
	private String dbURL = "jdbc:mysql://210.101.230.2:3306/java";
	private String userName = "s1601012"; //s�й�...
	private String passwd = "p1601012"; // p�й�
	   
    //DAD? data access object
	
	/*
	 *1.DB�� �����ϴ� �޼ҵ�
	 *2.DB�� ���ڵ� �����ϴ� �޼ҵ�
	 *3.DB���� ���ڵ� �����ϴ� �޼ҵ�
	 *4.DB�� ���ڵ� �����ϴ� �޼ҵ�
	 *5.DB���� ���ڵ� �����ϴ� �޼ҵ�
	 *
	 *mySQL ���� �������� ����...
	 *
	 *create table board{
	 *  bno int primary key auto_increment(�ڵ����� �����ض� ),
	 *  writer varchar(32) not null,
	 *  title varchar(32) not null,
	 *  content varchar(2048) not null,
	 *  regDate timestamp default now(),
	 *  viewCnt int default 0
	 *}
	 * */
	
	
	private Connection getConnection(){
		Connection con =null;
		/*
		 * ������ �ȵ� ��� , Exception�� Throw?,null�� ��ȯ ?
		 * null�� ��ȯ�ϴ� �ɷ� �����غ��� 
		 * 
		 * */
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbURL,userName,passwd);
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
	
	public int insert(String writer,String title,String content){
		//insert into board(writer , title, content) 
		//            values('scpack','test','test');
		//<1,'scpark','test','test','2017-05-01',0>
		
		
		//insert into board(writer , title, content) 
		//            values('gdhong','test1','test1');
		//<2,'gdhong','test1','test1','2017-05-01',0>
		
		
		/*
		 * 1.db������ �����Ѵ� Connection��ü�� �ϳ� ���� �Ѵ�.
		 * 2.�� Connection ��ü�� �̿��ؼ� insert���� DB�������� �����Ų��.
		 * 3.Connection �� close�Ѵ�
		 * */
		
		Connection con = getConnection();//�ҷ����� ���� ���� �޼���� 
		if(con==null) return -1;
		
		String sql = "insert into board(writer,title,content) "
				+ "values(?,?,?)";
		/*
		 * 1.SQL���� ������ ���� �����غ� ��û�Ѵ�.
		 * 1-1 ������ �� sql���� �Ʒ��� ���� �۾����� �����غ� �Ѵ� .
		 * 1-1-1 ���� �˻�, ���缺 �˻�, �����ȹ ������ preparedStatement ��ü ��ȯ
		 * 2.SQL�� ���࿡ �ʿ��� ������ ���� ����
		 * 3.SQL�� �����û(Insert,update,delete ���� executeUpdate�޼ҵ� ȣ��, 
		 *              select���� executeQuery�޼ҵ� ȣ�� )
		 * */
		
		//1���� �ش��ϴ� �ڵ�
		try {//1���� �ش��ϴ� �ڵ�
			PreparedStatement pstmt =con.prepareStatement(sql);
			
			//2���� �ش��ϴ� �ڵ�
			//?�ڸ��� �� ���� �����ؾ� �Ѵ�.
			//�̶� ����ϴ� �޼ҵ尡 setXXXXX();
			//������ ���� ���ڿ��̸� setString�̰� 
			//������ ���� ������ setInt
			//������ ���� Double�̸� setDouble�̰� 
			//������ ���� Timestamp�� setTimestamp��.
			
			
			pstmt.setString(1,writer);
			pstmt.setString(2,title);
			pstmt.setString(3,content);
		 
			//3���� �ش��ϴ� �ڵ�
			pstmt.executeUpdate();
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//4���� �ش��ϴ� �ڵ�
			try{con.close();
		
		}catch(Exception ignore){}
		}
		
		return 1;
		
	}
	
	//�޼ҵ� �����ε�
	public int insert(Board board){
	
		Connection con = getConnection();//�ҷ����� ���� ���� �޼���� 
		if(con==null) return -1;
		
		String sql = "insert into board(writer,title,content) values(?,?,?)";
		
		
		
		try {
			//1���� �ش��ϴ� �ڵ�
			PreparedStatement pstmt =con.prepareStatement(sql);
			
			
			pstmt.setString(1,board.getWriter());
			pstmt.setString(2,board.getTitle());
			pstmt.setString(3,board.getContent());
		 
			//3���� �ش��ϴ� �ڵ�
			pstmt.executeUpdate();
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//4���� �ش��ϴ� �ڵ�
			try{con.close();
		
		}catch(Exception ignore){}
		}
		
		return 1;
		
	}
	
	public void update(){

		/*
		 * 1.db������ �����Ѵ� Connection��ü�� �ϳ� ���� �Ѵ�.
		 * 2.�� Connection ��ü�� �̿��ؼ� update���� DB�������� �����Ų��.
		 * 3.Connection �� close�Ѵ�
		 * */
		
		Connection con = getConnection();//�ҷ����� ���� ���� �޼���� 
		
	}
	public void delete(String writer){

		/*
		 * 1.db������ �����Ѵ� Connection��ü�� �ϳ� ���� �Ѵ�.
		 * 2.�� Connection ��ü�� �̿��ؼ� delete���� DB�������� �����Ų��.
		 * 3.Connection �� close�Ѵ�
		 * */
		
		Connection con = getConnection();//�ҷ����� ���� ���� �޼���� 
		String sql ="delete from board where writer=?";
		try{
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.executeUpdate();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(Exception ignore){}
		}
		
	}
	
	//�����ε� �Ҽ�����.... ���� select�� �׷��� �޼��� �̸� �ٲ�� 
	public List<Board> getBoardList(String w){
		//������ �Խñ� ����Ʈ�� ��ȯ�Ѵ�. 
		List<Board> list = new ArrayList<>();
		
		Connection con = getConnection();
		String sql="select * from board ";
		
		//null�� �ƴϸ� sql������ �ٲ����� 
		if(w != null){
			sql +="where=?"; //�׻� �ڿ� �����ֱ� ���ָ� ū�ϳ��� 
		}
			
		System.out.println("sql: "+sql);
		try {
			PreparedStatement pstmt =con.prepareStatement(sql);
			
			if(w != null){
				pstmt.setString(1, w);
			}
			
			ResultSet rs=pstmt.executeQuery();
		     
			while(rs.next()==true){
				int bno = rs.getInt("bno");
				String writer=rs.getString("writer");
				String title =rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regDate");
				int viewCnt=rs.getInt("viewCnt");
				
				Board board = new Board(); //���� �ȿ� ��ü �����ؾ� �Ѵ� .
				board.setBno(bno);
				board.setContent(content);
				board.setRegDate(regdate);
				board.setTitle(title);
				board.setViewCnt(viewCnt);
				board.setWriter(writer);
				//board�� ���������� --->stack�� ���� 
				
				list.add(board);
	
			}
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//4���� �ش��ϴ� �ڵ�
			try{con.close();
		
		}catch(Exception ignore){}
		}
		
		
		return list;
	//	return 1;
	
	}
		
		
	
	
	
	public void select(){
		/*
		 * 1.db������ �����Ѵ� Connection��ü�� �ϳ� ���� �Ѵ�.
		 * 2.�� Connection ��ü�� �̿��ؼ� select���� DB�������� �����Ų��.
		 * 3.Connection �� close�Ѵ�
		 * */
		
		Connection con = getConnection();//�ҷ����� ���� ���� �޼���� 
		String sql="select * from board ";
		/* �ֽŲ� ���� ������: order by bno desc*/
		try {//1���� �ش��ϴ� �ڵ�
			PreparedStatement pstmt =con.prepareStatement(sql);
			
			//2���� �ش��ϴ� �ڵ����
		
			//3���� �ش��ϴ� �ڵ� executeQuery�޼ҵ�� ResultSet��ü�� ��ȯ�Ѵ�.
			ResultSet rs=pstmt.executeQuery();
		     /*
		      * ResultSet�� select���� ������ ����� ������� ������ ��Ÿ���� ��ü�̴�.
		      * ResultSet�� ���������� �����͸� ������ �ִٰ� �����ض� 
		      * �� �����ʹ� ù ��° ���ڵ� �ٷ� ������ ����Ű�� �־�.
		      * ResultSet �� next()�޼ҵ带 ȣ���ϸ� 
		      * �� �����Ͱ� �ٷ� ���� ���ڵ带 ����Ű�Եȴ�.
		      * �׸��� true�Ǵ� false ���� ��ȯ�ϴµ�
		      * ���� �����Ͱ� ����Ű�� ���� ���ڵ尡 ������ true ������ false �� 
		      * �׷��� ��� ���ڵ忡 �����Ϸ��� loop�� ���µ� 
		      * next()�޼ҵ尡 ��ȯ�ϴ� ���� true�� �� ���� ����ȴ�.
		      */
			while(rs.next()==true){
				int bno = rs.getInt("bno");
				String writer=rs.getString("writer");
				String title =rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regDate");
				int viewCnt=rs.getInt("viewCnt");
				
				System.out.println(bno+", "+writer+", "+title+", "
						+ ""+content+", "+ regdate+", "+viewCnt);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//4���� �ش��ϴ� �ڵ�
			try{con.close();
		
		}catch(Exception ignore){}
		}
		
	//	return 1;
	}

	
	
}
