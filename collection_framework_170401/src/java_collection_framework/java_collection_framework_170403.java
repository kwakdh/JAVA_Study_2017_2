package suUp4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class suUp0403 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//범위검색 정렬이 필요한 경우 !!!! treeMap이용하면 된다 
        //tree는 binary형태로 저장 (작은것은 왼쪽, 큰것은 오른쪽으로 정렬이 된다 )
		
		String[] data ={"A","K","A","K","D","K","A","K","K","Z","D"};
		TreeMap <String,Integer>map = new TreeMap<>();
	
		/*각 데이터 문자에 대해서 
		 * 1. map에 그 문자를 key로 하는 entry가 있다면 그 key에 해당하는 값을 인출(value)
		 *    그리고 그 1 증가된 값으로 <key ,value+1> put!!!
		 * 2. 그 entry가 없으면 <key,1>을 put한다!!
		 *     (그문자열이 몇개 나타나는지 빈도수를 알 수 있다.)
		 * */
		for(int i =0;i<data.length;i++){
			if(map.containsKey(data[i])){
				int value = map.get(data[i]);
				map.put(data[i], value+1);
			}else {
				map.put(data[i], 1);
			}
		}  
		
		Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<String,Integer> e = it.next();
			
		    String key = e.getKey();
		    int value = e.getValue();
			
		    System.out.println("key: "+key+" value: "+value);
		    
		    System.out.println(key+":" + printBar('#',value));
		}
		
		System.out.println("*********내림차순!!!!!************");
		//collections 클래스의 sort라는 정적메소드를 이용해서 문자열의 출현 빈도순의 내림차순으로 정렬!
		
		 Set <Map.Entry<String,Integer>>set =map.entrySet();
		 ArrayList list = new ArrayList(set);
		 
	     Collections.sort(list,new ValueComparator());
		 it= list.iterator();
		 
		 while(it.hasNext()){
			    Map.Entry<String,Integer> e2 =it.next();
			    String key = e2.getKey();
			    int value = e2.getValue();
				
			    System.out.println(key+":" + printBar('#',value));
		 } 
		
		
	} //end of main



static String printBar(char ch,int value){
	char[] bar = new char[value];
	for(int i =0;i<bar.length;i++)
		bar[i]=ch;
	
	
	return new String(bar);
     }
}


class ValueComparator implements Comparator<Map.Entry<String,Integer>> {

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Map.Entry&& o2 instanceof Map.Entry){
			//타입캐스팅전에 그게 맞는지 확인
			
			Map.Entry e1 =(Map.Entry)o1;
			Map.Entry e2 =(Map.Entry)o2;
			
			//오름차순 정렬
			
		    return (int)e1.getValue()-(int)e2.getValue();
			//return (int)e2.getValue()-(int)e1.getValue();
		}
		return -1;
	}
	
	
	
	
	
}