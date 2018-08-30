package suUp;
import java.util.HashMap;

public class suUp0327_3 {
    
	static HashMap phoneBook= new HashMap();
	//클래스 안만들고 (객체생성 안하고 )사용하기위해서 ! static사용
	/*
	 * phonebook은 (그룹이름,hashMap객체)쌍으로 저장*/
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  //*************그룹별로 전화번호부 만들기************	
      //key값을 전화번호로 하겟다 왜냐 key값에 이름넣으면 동명이인 우려가 잇으니..
	  //value 값에 이름을 넣는다.	
	  //key(그룹이름),value(아까 저장한 해쉬맵 객체)
	  //해쉬맵안에 해쉬맵넣기..	
	
		//위에 스태틱쓰던지 아니면 객체 찍어내던지~
	     addPhoneNo("친구","이자바","010-111-1111");
		 addPhoneNo("친구","김자바","010-222-2222");
		
	}
	//전화번호부 넣을때마다 불러오는 메서드 
	static void addPhoneNo(String groupName,String name, String tel){
		//그룹 이름을 key로 해서 그 그룹의 전화번호를 저장할 hashmap객체를 받아와야함
		HashMap group = (HashMap)phoneBook.get(groupName);
	    if(group==null){
	    	group =new HashMap();
	    	phoneBook.put(groupName, group);
	    	
	    }
	    
	    group.put(tel, name);
	}

}


