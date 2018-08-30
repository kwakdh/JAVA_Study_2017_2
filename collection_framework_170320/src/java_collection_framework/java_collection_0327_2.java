package suUp;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class suUp0327_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
		//[이름(key)과 점수]의 쌍으로 hashMap에 저장
		//동일 이름의 학생은 없다고 가정하기.
		
		/*
		 * 학생들의 총점,평균,최고점수,최저점수  구하기
		 * */
		HashMap map=new HashMap();
		map.put("김자바",90);
		map.put("강자바",100);
		// 강자바가 2명이면 이게 없어지고 뒤에껄로 덮어씀
		map.put("이자바",100);
		map.put("강자바",80);
		map.put("박자바",90);
		//뒤에있는게 앞에있는것을 덮어쓴다.
		
		Set set = map.entrySet();//entrySet을 달라는 뜻이다.
		
		//맵에서 바로 이터러터 달라칼수 없다
		//하나하나 접근하는 방법이 iterator이다.
		Iterator it = set.iterator();
		//iterator 에는 map.entry타입의 객체들이 들어있다. 
	
		//맵에있는거 접근할려면 이방법써라
	    while(it.hasNext()){
	    	Map.Entry entry = (Map.Entry)it.next();
	    	System.out.println("이름: "+entry.getKey()+" ,점수: "+entry.getValue());
	    }
		
		set =map.keySet();//key의 집합만 달라고 할때?!
		System.out.println(set);//----->김자바,박자바,강자바,이자바

	    Collection values=map.values();//collection타입으로 리턴한다.
	    it=values.iterator();//값을 가져와라 ~_~ 
	    
	    int total=0;
	    //***방법1***
	   // int max=-1;
	   // int min=200;
	    
	    //***방법2***
	    int max=Integer.MIN_VALUE;
	    int min=Integer.MAX_VALUE;
	    
	    
	    while(it.hasNext()){
	    	int jumsu=(int)it.next();
	    	
	    	total += jumsu;// next가 객체로 리턴하니까 타입캐스팅!!
	    	
	    	if(jumsu>max)max=jumsu;
	    	if(jumsu<max)min=jumsu;
	    }
	    
	    System.out.println("총점: "+total);
	    System.out.println("평균: "+((double)total/values.size()));
	    
	    System.out.println("최고점수: "+max);
	    //콜렉션 타입으로 찾아주는 방법이 3번째당
	    System.out.println("최고점수: "+Collections.max(values));
	    
	    System.out.println("최저점수: "+min);
	   System.out.println("최저점수: "+Collections.min(values));
	   
	    
	    
	    
	}

}
