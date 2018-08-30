package jdbc2;

import java.util.List;
import java.util.Scanner;

public class DAOTest {

	public static void main(String args[]){
		
	String str = "1004, ���� ,���� ,����� , 010-1234-5678,2016";
	//���ڿ��� ������ student ��ü �����ϱ�
	String[] sArr = str.split(",");
	
	for(int i = 0; i<sArr.length;i++){
		System.out.println("sArr[" + i + "]:[" + sArr[i].trim() + "]");
		
	}
	
	Student std = new Student(sArr);
	
	studentDAO dao = new studentDAO();
	dao.insert(std);
	
	Scanner scan = new Scanner(System.in);
	while(true){
		System.out.println("�й�, �̸�, �迭, ����, ��ȭ��ȣ , ���г⵵ ");
		String s = scan.nextLine();
		if(s.equals("-1")) break;
		Student st = new Student(s);
		dao.insert(st);
		
	}
	
	List <Student> list = dao.selectAll();
    
	for(int i = 0; i<list.size();i++){
		Student s = list.get(i);
		System.out.println(s);
	}
		  
		
	}
	
}
