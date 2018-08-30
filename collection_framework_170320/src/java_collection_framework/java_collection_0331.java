package suUp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class suUp0331 {
    
	static HashMap<String,HashMap<String,String>> phoneBook =
			new HashMap<String,HashMap<String,String>>();
	
	public static void main(String[] args) {
     /* map: hashmap,treemap
      * hashmap 타입의 phonebook생성
      * <groupname,hashmap객체 >
      * 이 group name과 쌍으로 저장되는 hashmap객체에는 
      * (전화번호,이름)의 쌍이저장됨
      * */
		
	//  hashmap phonebook = new HashMap();
	//  phonebook.get("친구");
	//  첫번째 요청의 경우 얘가 리턴하는 값은 null이다 그때는 new가 하나 생성되서 
	//  phonebook.put("친구", new HashMap());
	//  두번째 	phonebook.get("친구") 부터는  첫번째에서 넣어준hashmap객체가 반환될것
	//  그 객체에 <전화번호,이름> 쌍을 put해주면 된다.	
		
		addPhoneNo("친구","이자바","010-111-1111");
		addPhoneNo("친구","김자바","010-222-2222");
		addPhoneNo("친구","김자바","010-333-3333");
		
		addPhoneNo("회사","김대리","010-444-4444");
		addPhoneNo("회사","김대리","010-555-5555");
		addPhoneNo("회사","박대리","010-666-6666");
		addPhoneNo("회사","이과장","010-777-7777");

		addPhoneNo("세탁","010-888-8888");
		printList();
		
		updatePhoneNo("친구","010-333-3333","010-322-3232");

		System.out.println("--------------------------------");
		System.out.println(" ");
		
		//그냥 다 전체 찍을려면 printList하면 되는데 만약에
		//그 그룹의 내용만 찍고싶으면.... 구현해줘야 한다 .
		System.out.println("update~!!!!!");
		printList("친구");
		
		System.out.println("--------------------------------");
		System.out.println(" ");
	
		
		//도전과제1: printPhoneNo("친구","김자바");
		// 친구랑 김자바 다출력하기
		// 010-29312-23213
		// 010-2313-2130
		
		//도전과제 1 에서 가져와서 도전2를 하시오 
		//도전과제 2 :printPhoneNo("김자바")
		//  그룹이름 999-112
		//  그룹이름 324982349823
		//  

		System.out.println("--------------삭제중-----------");
		removePhoneNo("친구","010-444-4444");
		System.out.println("--------------------------------");
		printList();
		
		
		System.out.println("--------------------------------");
		printGroups();//그룹이름만 다찍기 메서드
		System.out.println("********과제 1********");
		
		printGwaze1("친구","김자바");
		System.out.println("********과제 2**********");
		printGwaze2("김자바");  
	}
	

	//과제 1*******************************************************
     static void printGwaze1(String groupName, String name){
    	HashMap<String,String> group = phoneBook.get(groupName);
    	Set<Map.Entry<String,String>> set = group.entrySet();
    	Iterator<Map.Entry<String,String>> it = set.iterator();
    	
    	while(it.hasNext()){
    		
    		Map.Entry<String,String> e = it.next();
    		if(name.equals(e.getValue())){
    			System.out.println(name +"의 번호 : "+e.getKey());}
    		}
    	
    	}
	
	
	//과제2*****************************************************
   
     static void printGwaze2(String name){
    	
    	 Set <Map.Entry<String,HashMap<String,String>>> set1 = phoneBook.entrySet();
    	 Iterator <Map.Entry<String,HashMap<String,String>>> it1 = set1.iterator();
    	 
    	 while(it1.hasNext()){
    		 
    		 Map.Entry<String,HashMap<String,String>> e1 = it1.next();
    		 System.out.println(e1.getKey());
    		
    		 HashMap <String,String> group = e1.getValue();
    		 if(group.containsValue(name)){
    			 Set<Entry<String, String>>  set2 = group.entrySet();
    			 Iterator<Entry<String, String>> it2 = set2.iterator();
    			 
    			 while(it2.hasNext()){
    				 
    				 Map.Entry<String,String> e2 = it2.next();
    				 if(name == e2.getValue()){
    					 System.out.println(e2.getKey());
    				 }
    				 
    			 }
    			 
    		 }
    		 
    		 //반복안하고 그룹이름 
    		 /*Set<String> set = phoneBook.keySet();
    		 Iterator<String> it =set.iterator();
    		 while(it.hasNext()){
    			 String grpName = it.next();
    			 System.out.println("\n그룹이름: "+grpName);*/
    			 
    		 }
    	 }
    	 
    	 
     }
     
     
     
	//그룹종류 나오는거 ~_~ 
	static void printGroups(){
		  System.out.println("그룹~_~_~_~_~_~_~_~");
		  Set <String> set = phoneBook.keySet();
		  Iterator<String> it = set.iterator();
		  while(it.hasNext()){
			  System.out.println(it.next());
		  }
	  }
	
	/*
	 * HashMap<String,String> h = new HashMap<String,Stirng>();
	 * 
	 * HashMap에 저장되는 객체의 타입은 Map.entry이다.
	 * 그런데 <key,value> 쌍의 타입이 <String,String>이면
	 * Generic을 사용해서 타입을 명시한다면 
	 * hashMap에 저장되는 객체(h라 하면)의 타입은
	 * Map.Entry<Stirng,String>이다 
	 *  Set<Map.Entry<String,String>> s = h.entrySet();
	 *  Iterator<Map.Entry<String,String>> it =s.iterator;
	 * Map.Entry<String,String> e = it1.next();
	 * e.getKey(); e.getValue();
	 * 
	 * 
	 * HashSet set= new HashSet();
	 * Generic을 이용해서 표현하면, 그리고 만약에 이 set에 저장되는
	 * 객체의 타입이  String이라면 
	 * HashSet<String> set= new HashSet<String>();
 	 * Iterator<String> it = set.iterator();
 	 * String s= it.next();
 	 * 
 	 * 
	 * */
	
	
	
	
	static void printList(String groupName){
		HashMap<String,String>group=phoneBook.get(groupName);
		
		if(group==null){
			System.out.println("그런 그룹 없음 !!!!!");
			 return;
		}
		Set<Map.Entry<String,String>> es= group.entrySet();
		
		Iterator<Map.Entry<String, String>> it =es.iterator();
		while(it.hasNext()){
			Map.Entry<String, String> e =it.next();
         System.out.println("name: "+e.getValue()+",phoneNo :"+e.getKey());
		
		}
		
	}
	
	
	//업데이트 메서드
	static void updatePhoneNo(String groupName,String oldTel,String newTel){
		
		//groupName을 key값으로 해서 그 group의 전화번호를 저장하고 있는 hashmap객체를 찾고
		//그 해쉬맵객체에서 oldtel을 키값으로 해서 그 대응되는 값을 가져온다 (이름을 가져옴 )
		//oldtel을 키값으로 가지는 엔트리를 삭제한다. ----> 삭제하고 새로 넣은것으로 대체해서 넣기 
		//<newTel,이름> 쌍을 HashMap에 put
		
		HashMap<String,String>phones =phoneBook.get(groupName);
		String name= phones.get(oldTel);
		if(name== null){
			System.out.println("그런 번호 없어 ");
			return;//끝내기 
		}
		
		phones.remove(oldTel);
		phones.put(newTel,name);
		
	}
	//전화번호 삭제 메서드 
	static void removePhoneNo(String groupName,String tel){
	   
		//지금 해쉬맵안에 해쉬맵이다 
	   HashMap<String,String> h = phoneBook.get(groupName);	
	   String name = h.get(tel);
	   if(h.containsKey(tel) == false){
		   System.out.println("그런 번호 없음 ");
	       return;
	   }
	   
	   h.remove(tel);
	}
	
	
	
	//그룹을 만들것인가 말것인가 ?!
	static void addGroup(String groupName){
		if(phoneBook.containsKey(groupName) == false){
		//if(phoneBook.get(groupName)==null)	
	       phoneBook.put(groupName, new HashMap<String,String>());
		}
	}
	
	//얘를 바로 부름 
	static void addPhoneNo(String groupName,String name, String tel ){
	    addGroup(groupName);
		HashMap<String,String>group= phoneBook.get(groupName);
	    //그룹명에 맞는 해쉬맵주세요
		
		group.put(tel, name);
		phoneBook.put(groupName, group);

    }
	
	//오버로딩하겠다 왜냐? 그룹이름 안쓰고 그냥 바로 쓸수도 있기 때문에 
	static void addPhoneNo(String name, String tel ){
	    addPhoneNo("기타",name,tel);
	
    }
	
	static void printList(){
     Set<Map.Entry<String, HashMap<String,String>>> set
                                   =  phoneBook.entrySet();
     
      //iterator안에 는 원소가 들어간당
     Iterator<Map.Entry<String, HashMap<String,String>>> it 
                                   = set.iterator();
     //그룹 전체 다찍기 
     while(it.hasNext()){
    	Map.Entry<String, HashMap<String,String>> e = it.next();
         
       HashMap<String,String>group = e.getValue();
       Set<Map.Entry<String,String>> phoneSet = group.entrySet();
       Iterator<Map.Entry<String,String>> phoneIt= phoneSet.iterator(); 
      
       //이그룹에 전화번호가 몇개 있는지 . 그룹의 각 entry가 e다 
       
       System.out.println(e.getKey()+"["+phoneSet.size()+"]");
       
       // 하나의 그룹에서 전화번호 찍는것 
        while(phoneIt.hasNext()){
        	Map.Entry<String,String> p = phoneIt.next();
        	String tel = p.getKey();
        	String name = p.getValue();
        	System.out.println(name+","+tel);
        }
         System.out.println("\n");
     }
     
	
	}
}
