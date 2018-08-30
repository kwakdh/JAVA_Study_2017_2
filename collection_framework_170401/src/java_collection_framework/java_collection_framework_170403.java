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
		//�����˻� ������ �ʿ��� ��� !!!! treeMap�̿��ϸ� �ȴ� 
        //tree�� binary���·� ���� (�������� ����, ū���� ���������� ������ �ȴ� )
		
		String[] data ={"A","K","A","K","D","K","A","K","K","Z","D"};
		TreeMap <String,Integer>map = new TreeMap<>();
	
		/*�� ������ ���ڿ� ���ؼ� 
		 * 1. map�� �� ���ڸ� key�� �ϴ� entry�� �ִٸ� �� key�� �ش��ϴ� ���� ����(value)
		 *    �׸��� �� 1 ������ ������ <key ,value+1> put!!!
		 * 2. �� entry�� ������ <key,1>�� put�Ѵ�!!
		 *     (�׹��ڿ��� � ��Ÿ������ �󵵼��� �� �� �ִ�.)
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
		
		System.out.println("*********��������!!!!!************");
		//collections Ŭ������ sort��� �����޼ҵ带 �̿��ؼ� ���ڿ��� ���� �󵵼��� ������������ ����!
		
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
			//Ÿ��ĳ�������� �װ� �´��� Ȯ��
			
			Map.Entry e1 =(Map.Entry)o1;
			Map.Entry e2 =(Map.Entry)o2;
			
			//�������� ����
			
		    return (int)e1.getValue()-(int)e2.getValue();
			//return (int)e2.getValue()-(int)e1.getValue();
		}
		return -1;
	}
	
	
	
	
	
}