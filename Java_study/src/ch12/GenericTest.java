package ch12;

import java.util.ArrayList;

public class GenericTest {
	public static void main(String[] args) {
		/*
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(2);
		list.add(1);
		
		int num = list.get(0);
		
		//ArrayList<Object> list2 =new ArrayList<String>();
		ArrayList<Object> list2 =new ArrayList<Object>();
		list2.add("abc");
		list2.add(3);
		*/
		
		ArrayList<Person> pList = new ArrayList<Person>();
		pList.add(new Person("ȫ�浿", 17, Person.MALE));
		pList.add(new Person("������", 32, Person.MALE));
		pList.add(new Person("������", 18, Person.FEMALE));
		pList.add(new Person("�̸���", 20, Person.MALE));
		pList.add(new Person("�����", 17, Person.FEMALE));
		//pList.add(new Student("�����", 17, Person.FEMALE, "����", 100));
		//Statistics.getGenderStat(pList);
		/*
		Container<Person> c1 = new Container<Person>();
		c1.setList(pList);
		System.out.println(c1);
		*/
		
	//	Statistics.dummy(new Person("ȫ�浿", 17, Person.MALE));
		//Statistics.dummy(new Student("�̼���", 20, Person.MALE, "����", 88));
		//Statistics.dummy2(new Student("�̼���", 20, Person.MALE, "����", 88));
		ArrayList<Student> sList = new ArrayList<Student>();
		sList.add(new Student("�̼���", 20, Person.MALE, "����", 88));
		sList.add(new Student("�ں���", 20, Person.MALE, "����", 68));
		sList.add(new Student("�����", 20, Person.MALE, "����", 78));
		sList.add(new Student("Ȳ�ݺ�", 20, Person.FEMALE, "����", 99));
		sList.add(new Student("�ּ���", 20, Person.FEMALE, "����", 98));
		Container<Student> c2 = new Container<Student>();
		/*
		c2.setList(sList);
		System.out.println(c2);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		Container.sayHello(new SalesMan("�ڼ�ö", Person.MALE, 30, 100));
		Statistics.getGenderStat(sList);
		*/
		//Statistics.sort(sList);
		Statistics.descendingSort(sList);
		System.out.println(sList);
		//Statistics.getPGenderStat(sList);
		/*
		ArrayList<SalesMan> smList = new ArrayList<SalesMan>();
		smList.add(new SalesMan("�̼���", 23, Person.MALE, 300));
		smList.add(new SalesMan("�̾Ƹ�", 23, Person.FEMALE, 400));
		smList.add(new SalesMan("��ȿ��", 23, Person.FEMALE, 250));
		smList.add(new SalesMan("������", 23, Person.MALE, 310));
		smList.add(new SalesMan("������", 23, Person.FEMALE, 280));
		*/
		/*
		Container<SalesMan> c3 = new Container<SalesMan>();
		c3.setList(smList);
		System.out.println(c3);
		*/
		/*
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("A");
		strList.add("B");
		strList.add("C");
		Statistics.printList(strList);
		
		//Statistics.<SalesMan>printList(smList);
		Statistics.printList(smList); */
		
		//Statistics.prtInfo(sList);
		
	}
}









