package suUp4;

import java.util.*;
import javax.swing.Box;

public class suUp0407 {
	public static void main(String[] args) {
		
		//Generic 
		/*ArrayList list = new ArrayList();	
		list.add(1);//오토박싱 --->integer형으로 들어감
		list.add("abc");// 아무거나 다 넣으면...뺄때!
		
		int num = (int)list.get(1); //타입캐스팅 해줘야 한다 !!!
		*/
		
		List<Integer> list = new ArrayList<Integer>();
		//<>이렇게 써줘도 된다...!! 1.8에서는~~`
		list.add(1);
		//list.add("abc");
		int num =list.get(0);
		
		Box box =new Box();
		box.add("홍길동");
		box.add("일지매");
		box.add("성춘향");
		
		System.out.println("box: " + box);
		
		//box.add(new Student("홍길동",100));//add자체가 string이라서 안된다....
	    BoxStudent bs =new BoxStudent();
	    bs.add(new Student("홍길동",100));
	    
	    Box <String> sb = new Box<String>();
	    sb.add("홍길동");
	    sb.add("우레뫼");
	    sb.add("홍길동");
	    System.out.println("sb: "+sb);
	    
	    Box<Student> stdBox = new Box<>();
	    //stdBox.add("홍길동");---------->안됨!!!
	    stdBox.add(new Student("박성철",100));
	    stdBox.add(new Student("알파고",100));
	    stdBox.add(new GraduateStudent("대학원생",99));
	    System.out.println("stdBox: "+stdBox);
	    
	    //Box <Student> sBox = new Box<GraduateStudent>();
	    //-------------------->이거 안된다!!!!!!!!!!!
	    Box <Student> sBox = new Box<Student>();
	    //상속관계라서 GraduateStudent들어가기때문에 다형성이 적용안된다 !!! 같은타입으로 적어줘라 
	    
	    //타입지정안해서 오브젝트 파일이다
	    Box rawBox = new Box();
	    rawBox.add("jsPack");
	    rawBox.add(new Student("박",99));
	    
	    
	    sBox = new FruitBox<Student>();
	    //다형성이 적용된다!! 일반클래스랑 똑같다........ 
	    
	   // FruitBox<Student> fbox = new FruitBox<>();
	    FruitBox<Fruit> fbox = new FruitBox<>();
	    FruitBox<Apple> abox = new FruitBox<>();
	    
	    
	}
}
