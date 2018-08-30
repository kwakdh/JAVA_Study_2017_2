package suUp4;

import java.util.ArrayList;
//<T>타입의 매개변수 

public class Box<T> {
	
	private ArrayList<T> list = new ArrayList<>();
    
	public void add(T item){
		list.add(item);
	}
	
	
	public /*static*/ void setItem(T item){
		
	}
	
	
	//get - 인스턴스 멤버메서드 !!(객체가 생성되야 가능한 멤버메서드)
	public T get(int index){
		return list.get(index);
	}
	
	public String toString(){
		return list.toString();
	}
	
}
