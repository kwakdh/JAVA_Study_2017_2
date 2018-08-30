package jdbc3;

import java.util.ArrayList;
import java.util.Iterator;

public class DAOTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*BoardDAO dao = new BoardDAO();
		dao.select("");
		
		Board b = new Board();
		b.setBno(23758);// 괄호 안에있는 번호 23758 변경하기
		b.setTitle("아자아자!");
		b.setWriter("봉봉이");
		b.setContent(">_<");
		
		
		
		
	    dao.update(b);
	    dao.select("");*/
		
		BoardDAO dao = new BoardDAO();
		/*Board board = dao.select(23758);
		System.out.println(board);
		dao.delete(23758);*/
		
		
		for(int i = 0; i<10;i++){
		  Board b = new Board();
		  
		  b.setContent("사무쿠 낫다 ");
		  b.setWriter("scpark");
		  b.setTitle("자바 넘나어려운것 ㅠㅠㅠㅠㅠ"+i);
		  
		  dao.insert(b);
		  
		}
		  //dao.select("");
		
		
		
		ArrayList<Board> list = dao.select("scpark"); 
		Iterator<Board> it = list.iterator();
		//작성자가 scpack인것만 select해오기 
		//return 은 arrayList..!! 
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	
	
	
}
