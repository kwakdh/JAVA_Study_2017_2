package suUp4;

import java.util.*;
import javax.swing.Box;

public class suUp0407 {
	public static void main(String[] args) {
		
		//Generic 
		/*ArrayList list = new ArrayList();	
		list.add(1);//����ڽ� --->integer������ ��
		list.add("abc");// �ƹ��ų� �� ������...����!
		
		int num = (int)list.get(1); //Ÿ��ĳ���� ����� �Ѵ� !!!
		*/
		
		List<Integer> list = new ArrayList<Integer>();
		//<>�̷��� ���൵ �ȴ�...!! 1.8������~~`
		list.add(1);
		//list.add("abc");
		int num =list.get(0);
		
		Box box =new Box();
		box.add("ȫ�浿");
		box.add("������");
		box.add("������");
		
		System.out.println("box: " + box);
		
		//box.add(new Student("ȫ�浿",100));//add��ü�� string�̶� �ȵȴ�....
	    BoxStudent bs =new BoxStudent();
	    bs.add(new Student("ȫ�浿",100));
	    
	    Box <String> sb = new Box<String>();
	    sb.add("ȫ�浿");
	    sb.add("�췹��");
	    sb.add("ȫ�浿");
	    System.out.println("sb: "+sb);
	    
	    Box<Student> stdBox = new Box<>();
	    //stdBox.add("ȫ�浿");---------->�ȵ�!!!
	    stdBox.add(new Student("�ڼ�ö",100));
	    stdBox.add(new Student("���İ�",100));
	    stdBox.add(new GraduateStudent("���п���",99));
	    System.out.println("stdBox: "+stdBox);
	    
	    //Box <Student> sBox = new Box<GraduateStudent>();
	    //-------------------->�̰� �ȵȴ�!!!!!!!!!!!
	    Box <Student> sBox = new Box<Student>();
	    //��Ӱ���� GraduateStudent���⶧���� �������� ����ȵȴ� !!! ����Ÿ������ ������� 
	    
	    //Ÿ���������ؼ� ������Ʈ �����̴�
	    Box rawBox = new Box();
	    rawBox.add("jsPack");
	    rawBox.add(new Student("��",99));
	    
	    
	    sBox = new FruitBox<Student>();
	    //�������� ����ȴ�!! �Ϲ�Ŭ������ �Ȱ���........ 
	    
	   // FruitBox<Student> fbox = new FruitBox<>();
	    FruitBox<Fruit> fbox = new FruitBox<>();
	    FruitBox<Apple> abox = new FruitBox<>();
	    
	    
	}
}
