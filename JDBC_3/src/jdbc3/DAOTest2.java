package jdbc3;

import java.util.ArrayList;
import java.util.Iterator;

public class DAOTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*BoardDAO dao = new BoardDAO();
		dao.select("");
		
		Board b = new Board();
		b.setBno(23758);// ��ȣ �ȿ��ִ� ��ȣ 23758 �����ϱ�
		b.setTitle("���ھ���!");
		b.setWriter("������");
		b.setContent(">_<");
		
		
		
		
	    dao.update(b);
	    dao.select("");*/
		
		BoardDAO dao = new BoardDAO();
		/*Board board = dao.select(23758);
		System.out.println(board);
		dao.delete(23758);*/
		
		
		for(int i = 0; i<10;i++){
		  Board b = new Board();
		  
		  b.setContent("�繫�� ���� ");
		  b.setWriter("scpark");
		  b.setTitle("�ڹ� �ѳ������� �ФФФФ�"+i);
		  
		  dao.insert(b);
		  
		}
		  //dao.select("");
		
		
		
		ArrayList<Board> list = dao.select("scpark"); 
		Iterator<Board> it = list.iterator();
		//�ۼ��ڰ� scpack�ΰ͸� select�ؿ��� 
		//return �� arrayList..!! 
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	
	
	
}
