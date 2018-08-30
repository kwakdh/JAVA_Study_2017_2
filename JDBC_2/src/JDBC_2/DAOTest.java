package JDBC_2;

import java.util.*;

public class DAOTest {
  
  private static Map<String,Integer> map = new HashMap<>(); 	
  public static void main(String args[]){
	  
	BoardDAO dao= new BoardDAO();
	  //dao.insert();
	  int result= dao.insert("scpark","test","test�Դϴ�");
	  if(result>0){
		  System.out.println("���ڵ� ���Լ���");
	  }
	  else{
		  System.out.println("���ڵ� ���� ����!!");
	  }
	  
	 Board board = new Board();
	 board.setWriter("ggg");
	 board.setTitle("����̳�");
	 board.setContent("���� �ƺ� ����ؿ�");
	 result = dao.insert(board);
	 
	 if(result>0){
		  System.out.println("���ڵ� ���Լ���");
	  }
	  else{
		  System.out.println("���ڵ� ���� ����!!");
	  }
	  
	  //dao.update(1,"scpark","test!!!","test����");
	  //dao.delete(3);
	  
	  
	  //dao.select();
	
	 // dao.delete("scpark"); //����°� --->scpark ����� 
	                        //null ������ �ϴ�����°��� ����
	  
	  /* �ۼ��� ���� ��� �Խñ��� ������?.....�ľ����� */
	 /* List<Board> list =dao.getBoardList(null); //��ȣ�ȿ� "�ڼ�ö"������ �ڼ�ö�� ����� �˼� �ִ� 
	  if(list.size()==0){
		  System.out.println("No article.. ");
	  }
	  else{
		  Iterator<Board> it = list.iterator();
		  while(it.hasNext()){
			  Board b = it.next();
			  putToMap(b);
		  }
		  printMap();
	   }  */
	  /* while(true){
		   printMenu(); // �޴��� .... �л����� ���� ���� ���� �ϱ� 
		   int menu = scn.nextInt();
		   if(menu == 1){ 
			   System.out.println();
			   //�л����� �Է¹޾Ƽ� 
			   dao.insert(student);
			   
		   }else if(menu ==-1){
			   break;
		   }
		  
	   }*/
    }
    private static void putToMap(Board b){
    	//map�� �̹� ��key ������ ��ϵ� �����Ͱ� �ִ��� ���� 
    	//������ �� ���� �ٰ� 1�� ���ؼ� �ٽ� put�ϰ� 
    	//������ �� <�� key,1>���� put
    	
    	if(map.containsKey(b.getWriter())){
    		int cnt = map.get(b.getWriter());
    		map.put(b.getWriter(),cnt+1);
    	}else{
    		map.put(b.getWriter(), 1);
    	}
    	
    }
    
    private static void printMap(){
     Set<String> keys = map.keySet();
     Iterator<String> it = keys.iterator();
     while(it.hasNext()){
    	 String key = it.next();
    	 int count = map.get(key);
    	 
    	 System.out.println(key+" : "+count);
     }
    }
}
