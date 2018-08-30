package genericRensyu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class statistics {
	
	
	
	public static<T extends student> void gradeStu(ArrayList<T> list){
		
		//총점, 평균, 최고학생,최저학생
		
		int total=0;
		double average=0;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		T maxSt=null;
		T minSt=null;
		
		Iterator<T> it = list.iterator();
		
		while(it.hasNext()){
			T t = it.next();
		    
			total += t.getScore();
			
			if(max<t.getScore()){
				max=t.getScore();
				maxSt=t;
			}
			if(min>t.getScore()){
				min=t.getScore();
				minSt=t;
			}
		}
		
		average= total/(double)list.size();
		System.out.println("총점: "+total);
		System.out.println("평균: "+average);
		System.out.println("최고학생: "+maxSt.toString());
		System.out.println("최저학생: "+minSt.toString());
	}
	
	//any 다 받겟다... 소팅하는 메서드 ~~~~~~~~~~~``
	public static void sort(ArrayList<? extends student> 
	list){
		
		Collections.sort(list);
		
	}
	
	
	//반대로 소팅하기 
	public static <T extends student>void descendingSort(ArrayList <T> list){
	//	Collections.sort(list , /*comparator인터페이스를 구현한 객체를 넘겨주기 */);
		Collections.sort(list , new StudentDescOrder<T>());
		
	}
	
     //sortReverse 만들어보기 	
	//<? super T> 이거쓰는 이유는 fruit에만 한정하는게 아니라 상속받는 apple도 쓰고싶어서 
	public static<T extends Comparable<? super T>> void sortReverse(List<T> list){

		//Collections.sort(list);//오름차순
		
		Collections.sort(list,new FruitDescOrder<T>());//역순
		
		
	}


	
	
}
