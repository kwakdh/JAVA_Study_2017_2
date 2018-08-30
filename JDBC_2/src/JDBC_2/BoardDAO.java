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
	private String userName = "s1601012"; //s학번...
	private String passwd = "p1601012"; // p학번
	   
    //DAD? data access object
	
	/*
	 *1.DB에 연결하는 메소드
	 *2.DB에 레코드 삽입하는 메소드
	 *3.DB에서 레코드 삭제하는 메소드
	 *4.DB의 레코드 수정하는 메소드
	 *5.DB에서 레코드 인출하는 메소드
	 *
	 *mySQL 보드 만들어놨다 지금...
	 *
	 *create table board{
	 *  bno int primary key auto_increment(자동으로 증가해라 ),
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
		 * 연결이 안될 경우 , Exception을 Throw?,null을 반환 ?
		 * null을 반환하는 걸로 구현해보자 
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
		 * 1.db서버에 연결한다 Connection객체를 하나 얻어야 한다.
		 * 2.그 Connection 객체를 이용해서 insert문을 DB서버에게 실행시킨다.
		 * 3.Connection 을 close한다
		 * */
		
		Connection con = getConnection();//불러쓰자 위에 만든 메서드로 
		if(con==null) return -1;
		
		String sql = "insert into board(writer,title,content) "
				+ "values(?,?,?)";
		/*
		 * 1.SQL문을 서버에 보내 실행준비를 요청한다.
		 * 1-1 서버는 그 sql문을 아래와 같은 작업으로 실행준비 한다 .
		 * 1-1-1 문법 검사, 정당성 검사, 실행계획 수립후 preparedStatement 객체 반환
		 * 2.SQL문 실행에 필요한 데이터 값을 설정
		 * 3.SQL문 실행요청(Insert,update,delete 문은 executeUpdate메소드 호출, 
		 *              select문은 executeQuery메소드 호출 )
		 * */
		
		//1번에 해당하는 코드
		try {//1번에 해당하는 코드
			PreparedStatement pstmt =con.prepareStatement(sql);
			
			//2번에 해당하는 코드
			//?자리에 들어갈 값을 설정해야 한다.
			//이때 사용하는 메소드가 setXXXXX();
			//설정할 값이 문자열이면 setString이고 
			//설정할 값이 정수면 setInt
			//설정할 값이 Double이면 setDouble이고 
			//설정할 값이 Timestamp면 setTimestamp다.
			
			
			pstmt.setString(1,writer);
			pstmt.setString(2,title);
			pstmt.setString(3,content);
		 
			//3번에 해당하는 코드
			pstmt.executeUpdate();
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//4번에 해당하는 코드
			try{con.close();
		
		}catch(Exception ignore){}
		}
		
		return 1;
		
	}
	
	//메소드 오버로딩
	public int insert(Board board){
	
		Connection con = getConnection();//불러쓰자 위에 만든 메서드로 
		if(con==null) return -1;
		
		String sql = "insert into board(writer,title,content) values(?,?,?)";
		
		
		
		try {
			//1번에 해당하는 코드
			PreparedStatement pstmt =con.prepareStatement(sql);
			
			
			pstmt.setString(1,board.getWriter());
			pstmt.setString(2,board.getTitle());
			pstmt.setString(3,board.getContent());
		 
			//3번에 해당하는 코드
			pstmt.executeUpdate();
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//4번에 해당하는 코드
			try{con.close();
		
		}catch(Exception ignore){}
		}
		
		return 1;
		
	}
	
	public void update(){

		/*
		 * 1.db서버에 연결한다 Connection객체를 하나 얻어야 한다.
		 * 2.그 Connection 객체를 이용해서 update문을 DB서버에게 실행시킨다.
		 * 3.Connection 을 close한다
		 * */
		
		Connection con = getConnection();//불러쓰자 위에 만든 메서드로 
		
	}
	public void delete(String writer){

		/*
		 * 1.db서버에 연결한다 Connection객체를 하나 얻어야 한다.
		 * 2.그 Connection 객체를 이용해서 delete문을 DB서버에게 실행시킨다.
		 * 3.Connection 을 close한다
		 * */
		
		Connection con = getConnection();//불러쓰자 위에 만든 메서드로 
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
	
	//오버로딩 할수없다.... 밑의 select와 그래서 메서드 이름 바꿔라 
	public List<Board> getBoardList(String w){
		//인출한 게시글 리스트를 반환한다. 
		List<Board> list = new ArrayList<>();
		
		Connection con = getConnection();
		String sql="select * from board ";
		
		//null이 아니면 sql문으로 바꿔주자 
		if(w != null){
			sql +="where=?"; //항상 뒤에 공백주기 안주면 큰일난다 
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
				
				Board board = new Board(); //루프 안에 객체 생성해야 한다 .
				board.setBno(bno);
				board.setContent(content);
				board.setRegDate(regdate);
				board.setTitle(title);
				board.setViewCnt(viewCnt);
				board.setWriter(writer);
				//board는 지역변수다 --->stack에 쌓임 
				
				list.add(board);
	
			}
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//4번에 해당하는 코드
			try{con.close();
		
		}catch(Exception ignore){}
		}
		
		
		return list;
	//	return 1;
	
	}
		
		
	
	
	
	public void select(){
		/*
		 * 1.db서버에 연결한다 Connection객체를 하나 얻어야 한다.
		 * 2.그 Connection 객체를 이용해서 select문을 DB서버에게 실행시킨다.
		 * 3.Connection 을 close한다
		 * */
		
		Connection con = getConnection();//불러쓰자 위에 만든 메서드로 
		String sql="select * from board ";
		/* 최신꺼 부터 보려면: order by bno desc*/
		try {//1번에 해당하는 코드
			PreparedStatement pstmt =con.prepareStatement(sql);
			
			//2번에 해당하는 코드없음
		
			//3번에 해당하는 코드 executeQuery메소드는 ResultSet객체를 반환한다.
			ResultSet rs=pstmt.executeQuery();
		     /*
		      * ResultSet은 select문의 실행결과 인출된 레토드의 집합을 나타내는 객체이다.
		      * ResultSet은 내부적으로 포인터를 가지고 있다고 생각해라 
		      * 그 포인터는 첫 번째 레코드 바로 직저을 가리키고 있어.
		      * ResultSet 의 next()메소드를 호출하면 
		      * 이 포인터가 바로 다으 레코드를 가르키게된다.
		      * 그리고 true또는 false 값을 반환하는데
		      * 현재 포인터가 가르키는 곳에 레코드가 있으면 true 없으면 false 다 
		      * 그래서 모든 레코드에 접근하려면 loop를 도는데 
		      * next()메소드가 반환하는 값이 true일 때 까지 돌면된다.
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
			//4번에 해당하는 코드
			try{con.close();
		
		}catch(Exception ignore){}
		}
		
	//	return 1;
	}

	
	
}
