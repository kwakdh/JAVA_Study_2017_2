package jdbc2;

import java.util.List;
import java.util.Scanner;

public class DAOTest {

	public static void main(String args[]){
		
	String str = "1004, 나다 ,컴정 ,웹디비 , 010-1234-5678,2016";
	//문자열을 가지고 student 객체 생성하기
	String[] sArr = str.split(",");
	
	for(int i = 0; i<sArr.length;i++){
		System.out.println("sArr[" + i + "]:[" + sArr[i].trim() + "]");
		
	}
	
	Student std = new Student(sArr);
	
	studentDAO dao = new studentDAO();
	dao.insert(std);
	
	Scanner scan = new Scanner(System.in);
	while(true){
		System.out.println("학번, 이름, 계열, 전공, 전화번호 , 입학년도 ");
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
