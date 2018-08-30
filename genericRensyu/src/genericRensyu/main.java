package genericRensyu;

import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
	
		ArrayList<student> slist= new ArrayList<>();
        slist.add(new student("나",20,student.FEMALE,"컴정",90));
        slist.add(new student("너",23,student.MALE,"컴정",100));
        slist.add(new student("위",26,student.FEMALE,"컴정",50));
        slist.add(new student("우리",27,student.MALE,"컴정",70));
		
	    statistics.gradeStu(slist);
	    //거꾸로 소팅하기 
	    statistics.descendingSort(slist);

	    System.out.println(slist);
	
	    ArrayList<gradStudent> glist= new ArrayList<>();
	    //이놈쓰는방법~!!~~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!~!
        glist.add(new gradStudent("나",20,student.FEMALE,"컴정",90,Major.COMPUTER));
        glist.add(new gradStudent("너",23,student.MALE,"기계",100,Major.MECHANICS));
        glist.add(new gradStudent("위",26,student.FEMALE,"전기",50,Major.ELECTRICITY));
        glist.add(new gradStudent("우리",27,student.MALE,"컴정",70,Major.COMPUTER));
		
        
	    statistics.gradeStu(glist);
	    
	    //소팅찍기
	    statistics.sort(glist);
	    System.out.println(glist);
	    
	    //거꾸로 소팅 찍기 
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
