package suUp4_2;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Statistics {

	//instance ��ü�� ������� �������ʿ䰡 ���� �� 
	//static ������ �ʿ䰡 ������ 
	public static void dummy(Person p){
		System.out.println(p);
	}
	
	public static<T extends Student & Comparable<Student>> void dummy(T p) {
		
		System.out.println(p);
		
	}
	
	
	
	//���׸�Ŭ������ �ƴ����� ���׸� �޼��� ����� �ִ�
	public static <T>void printList(List <T> slist){
		System.out.println(slist);
	}
	
	//���׸� �޼ҵ�� extends ���� �ȴ�...
		//���� �����ϴ°� �ƴϰ� ������ �� �ξ ������ ������ ���׸� �޼ҵ� ����ϴ°� �ȴ�.\
		//public static<T super gradStudent> void gradeStu(ArrayList<T> list)  ----(X)
		//�̿� ���� ���ϵ� ī��� ���� �����ϴ°͵� �����ϴ� !!! anyType ok!!!!
		//public static void gradeStu(ArrayList<? extends student> list)   ------(O)
		//public static void gradeStu(ArrayList<? super gradStudent> list) ------(O)
		//
	    //
		//public static<T extends Student & Comparable<T>> void dummy(T p) 
	    //comparable -----�������̽����� implement �����ϰ� extends�� ���� !!!
	
	
	
	
	
	
	
	
	
    //���׸� Ÿ�Ը��ٸ� �����ε��� �ȵȴ�. 
	//���� person�ε� student�� �ȵȴ� !!
	//-------------------->���׸� �޼ҵ�� ������
	public static <T extends Person >void getGenderStat(List<T> plist){
		        
		      //���� ���? ���� ���?
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
	
	
	
	
	
	
	/* ���ϵ� ī��????
	public static void getGenderStat(List<? extends Person> plist){
        
	      //���� ���? ���� ���?
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
		
		//���� ���? ���� ���?
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
				System.out.println("����: "+map.get(key));
			}else if(key == Person.FEMALE){
				System.out.hprintln("����: "+map.get(key));
			}else{
				System.out.println("�Һи�: "+map.get(key));
			}
		}
		
	}
	
	//����: student��ü�� ����Ʈ , GradStudent ��ü�� List�� �Է����� �޾Ƽ�
	// ����, ���, �ְ����� �л�����, �������� �л����� �� ����ϴ� generic Method�� �����϶� 
	
	
	
}
