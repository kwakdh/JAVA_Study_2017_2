package genericRensyu;

import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
	
		ArrayList<student> slist= new ArrayList<>();
        slist.add(new student("��",20,student.FEMALE,"����",90));
        slist.add(new student("��",23,student.MALE,"����",100));
        slist.add(new student("��",26,student.FEMALE,"����",50));
        slist.add(new student("�츮",27,student.MALE,"����",70));
		
	    statistics.gradeStu(slist);
	    //�Ųٷ� �����ϱ� 
	    statistics.descendingSort(slist);

	    System.out.println(slist);
	
	    ArrayList<gradStudent> glist= new ArrayList<>();
	    //�̳𾲴¹��~!!~~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!
        glist.add(new gradStudent("��",20,student.FEMALE,"����",90,Major.COMPUTER));
        glist.add(new gradStudent("��",23,student.MALE,"���",100,Major.MECHANICS));
        glist.add(new gradStudent("��",26,student.FEMALE,"����",50,Major.ELECTRICITY));
        glist.add(new gradStudent("�츮",27,student.MALE,"����",70,Major.COMPUTER));
		
        
	    statistics.gradeStu(glist);
	    
	    //�������
	    statistics.sort(glist);
	    System.out.println(glist);
	    
	    //�Ųٷ� ���� ��� 
	    statistics.descendingSort(glist);
	    
	    
	    ArrayList <Fruit> flist = new ArrayList<Fruit>();
	    flist.add(new Fruit());
	    flist.add(new Fruit());
	    flist.add(new Fruit());
	    flist.add(new Fruit());
	    flist.add(new Fruit());
	    
	    
	    statistics.sortReverse(flist);
	    System.out.println(flist);
	    
	    ArrayList<Apple> alist = new ArrayList<Apple>();
	    alist.add(new Apple());
	    alist.add(new Apple());
	    alist.add(new Apple());
	    
	    statistics.sortReverse(alist);
	    System.out.println(alist);
	}
	
}
