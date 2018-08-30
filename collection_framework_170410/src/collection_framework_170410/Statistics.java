package suUp4_2;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Statistics {

	//instance 객체의 멤버변수 접근할필요가 있을 때 
	//static 접근할 필요가 없을때 
	public static void dummy(Person p){
		System.out.println(p);
	}
	
	public static<T extends Student & Comparable<Student>> void dummy(T p) {
		
		System.out.println(p);
		
	}
	
	
	
	//지네릭클래스는 아니지만 지네릭 메서드 만들수 있다
	public static <T>void printList(List <T> slist){
		System.out.println(slist);
	}
	
	//지네릭 메소드는 extends 까지 된다...
		//위로 제한하는건 아니고 조상을 딱 두어서 그조상 밑으로 지네릭 메소드 사용하는건 된다.\
		//public static<T super gradStudent> void gradeStu(ArrayList<T> list)  ----(X)
		//이에 반해 와일드 카드는 위로 제한하는것도 가능하다 !!! anyType ok!!!!
		//public static void gradeStu(ArrayList<? extends student> list)   ------(O)
		//public static void gradeStu(ArrayList<? super gradStudent> list) ------(O)
		//
	    //
		//public static<T extends Student & Comparable<T>> void dummy(T p) 
	    //comparable -----인터페이스지만 implement 사용안하고 extends를 쓴다 !!!
	
	
	
	
	
	
	
	
	
    //지네릭 타입만다른 오버로딩이 안된다. 
	//지금 person인데 student로 안된다 !!
	//-------------------->지네릭 메소드로 만들자
	public static <T extends Person >void getGenderStat(List<T> plist){
		        
		      //남자 몇명? 여자 몇명?
				TreeMap <Integer,Integer> gmap = new TreeMap <>();
				Iterator<T> it = plist.iterator();
				while(it.hasNext()){
					Person p = it.next();
					int gender = p.getGender();
					Integer value = gmap.get(gender);
				
				    if(value == null){
				    	gmap.put(gender, 1);
				    }
				    else {
				    	gmap.put(gender,value+1);
				    }
				}
				
				printMap(gmap);
				
	}
	
	
	
	
	
	
	/* 와일드 카드????
	public static void getGenderStat(List<? extends Person> plist){
        
	      //남자 몇명? 여자 몇명?
			TreeMap <Integer,Integer> gmap = new TreeMap <>();
			Iterator<? extends Person> it = plist.iterator();
			while(it.hasNext()){
				Person p = it.next();
				int gender = p.getGender();
				Integer value = gmap.get(gender);
			
			    if(value == null){
			    	gmap.put(gender, 1);
			    }
			    else {
			    	gmap.put(gender,value+1);
			    }
			}
			
			printMap(gmap);
			
}
	
	
	*/
	
	
	
	/*public static void getGenderStat(List<Person> plist){
		
		//남자 몇명? 여자 몇명?
		TreeMap <Integer,Integer> gmap = new TreeMap <>();
		Iterator<Person> it = plist.iterator();
		while(it.hasNext()){
			Person p = it.next();
			int gender = p.getGender();
			Integer value = gmap.get(gender);
		
		    if(value == null){
		    	gmap.put(gender, 1);
		    }
		    else {
		    	gmap.put(gender,value+1);
		    }
		}
		
		printMap(gmap);
		
	}*/
	public static void printMap(Map<Integer,Integer> map){
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> it = keySet.iterator();
		
		
		while(it.hasNext()){
			Integer key = it.next();
			if(key==Person.MALE){
				System.out.println("남자: "+map.get(key));
			}else if(key == Person.FEMALE){
				System.out.hprintln("여자: "+map.get(key));
			}else{
				System.out.println("불분명: "+map.get(key));
			}
		}
		
	}
	
	//과제: student객체의 리스트 , GradStudent 객체의 List를 입력으로 받아서
	// 총점, 평균, 최고점수 학생정보, 최저점수 학생정보 를 출력하는 generic Method를 구현하라 
	
	
	
}
