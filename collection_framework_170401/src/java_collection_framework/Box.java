package suUp4;

import java.util.ArrayList;
//<T>Ÿ���� �Ű����� 

public class Box<T> {
	
	private ArrayList<T> list = new ArrayList<>();
    
	public void add(T item){
		list.add(item);
	}
	
	
	public /*static*/ void setItem(T item){
		
	}
	
	
	//get - �ν��Ͻ� ����޼��� !!(��ü�� �����Ǿ� ������ ����޼���)
	public T get(int index){
		return list.get(index);
	}
	
	public String toString(){
		return list.toString();
	}
	
}
