package JDBC_2;

import java.util.*;

public class DAOTest {
  
  private static Map<String,Integer> map = new HashMap<>(); 	
  public static void main(String args[]){
	  
	BoardDAO dao= new BoardDAO();
	  //dao.insert();
	  int result= dao.insert("scpark","test","test입니다");
	  if(result>0){
		  System.out.println("레코드 삽입성공");
	  }
	  else{
		  System.out.println("레코드 삽입 실패!!");
	  }
	  
	 Board board = new Board();
	 board.setWriter("ggg");
	 board.setTitle("어버이날");
	 board.setContent("엄마 아빠 사랑해요");
	 result = dao.insert(board);
	 
	 if(result>0){
		  System.out.println("레코드 삽입성공");
	  }
	  else{
		  System.out.println("레코드 삽입 실패!!");
	  }
	  
	  //dao.update(1,"scpark","test!!!","test수정");
	  //dao.delete(3);
	  
	  
	  //dao.select();
	
	 // dao.delete("scpark"); //지우는거 --->scpark 지우기 
	                        //null 넣으면 싹다지우는것을 뜻함
	  
	  /* 작성자 별로 몇개의 게시글을 썻는지?.....파악하자 */
	 /* List<Board> list =dao.getBoardList(null); //괄호안에 "박성철"넣으면 박성철이 몇개인지 알수 있다 
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
		   printMenu(); // 메뉴로 .... 학생정보 수정 변경 삭제 하기 
		   int menu = scn.nextInt();
		   if(menu == 1){ 
			   System.out.println();
			   //학생정보 입력받아서 
			   dao.insert(student);
			   
		   }else if(menu ==-1){
			   break;
		   }
		  
	   }*/
    }
    private static void putToMap(Board b){
    	//map에 이미 그key 값으로 등록된 데이터가 있는지 보고 
    	//있으면 그 값에 다가 1을 더해서 다시 put하고 
    	//없으면 그 <그 key,1>쌍을 put
    	
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
