package suUp;

import java.util.Set;
import java.util.TreeSet;

public class suUp0324 {
	public static void main(String[] args) {
	
/*	Set setA =new HashSet();
	Set setB =new HashSet();
	
	Set setHab =new HashSet();  //������
	Set setCha =new HashSet();  //������
	Set setKyo =new HashSet();  //������
	
	setA.add(1);
	setA.add(2);
	setA.add(3);
	setA.add(4);
	setA.add(5);
	
	System.out.println("setA:"+setA);
	
	setB.add(4);
	setB.add(5);
	setB.add(6);
	setB.add(7);
	setB.add(8);
	
	System.out.println("setB:"+setB);
	
	
	
	 * *****������ ������*****(retainAll �̶�� �޼ҵ尡 ������.....)
	 * setB�� �����ҿ� ���ؼ� setA�� �� ���Ҹ� �����ϰ� ������ setKyo�� �� ���Ҹ� add
	 * 
	
	//setA.retainAll(setB)
	//�̷��� ���鶧 setA�� setB�� �״���ΰ�? �ƴϸ�  setA�� setB�� ��ü�� ������ ��������°��ΰ�?
	//�� ���� ��ü�� ��ȭ�Ѵ�. ������ ��ȭ�Ǵ°��̴�!!!!!!!!!!
	
	Iterator it=setB.iterator();
	while(it.hasNext()){
		
		Object tmp=it.next();
		if(setA.contains(tmp))
			setKyo.add(tmp);
	}
	System.out.println("������: "+setKyo);
	
	
	 * 
	 * ������ ������(setA-setB)(removeAll �̶�� �޼ҵ尡 ������.....)
	 * setA�� �� ���ҿ� ���� setB�� �� ���Ҹ� �����ϰ� ���� ������ setCha�� �׿��Ҹ� add
	 * 
	 * 

	 it=setA.iterator();
	while(it.hasNext()){
		
		Object tmp=it.next();
		if(!setB.contains(tmp))
			//if(setB.contains(tmp)==false)
			setCha.add(tmp);
	}
	System.out.println("������: "+setCha);
	
	
	
	
	 * ������ ������(setA+setB)
	 * setA�� �����Ҹ� setHap�� add
	 * setB�� �����Ҹ� setHap�� add
	 * 
	
	
	 it=setA.iterator();
		while(it.hasNext())
			setHab.add(it.next());
	 it=setB.iterator();
	 while(it.hasNext())
			setHab.add(it.next());
		
		System.out.println("������: "+setHab);
		
		
	
	
	
	*/
	
	// TreeSet :������ �ִ�. root�� ������ �ִ�. 
    // root�� �θ������� �ڽ��� �������Ѵ� (����Ʈ��)
    /* ������ �������� �����ڽ� ������ ū���� �������ڽ�
     *                7(root)
     *             4      9(�θ������� �ڽ��� �������Ѵ�.)
     *            1 5
     *            
     *comparator�������̽��� �����ؾ��� treeSet�� �Ҽ��ִ�
     *comparator ����������Ѵ�!!!!! (�׷��������� treeSet�� �ι�° ��ü�� �����Ҷ� ���ܹ߻�)           
     *         
     *            
     * */	
	
		
	//****************TreeSetLotto*********************
	// TreeSet��ü����, �̰�ü�� set�̶�� ����
    // set.size()�� 6�̸��� ����
	// 1~45������ ������ �������� ������ set.add��� ����
	// set�� �ִ� ���Ҹ� �ϳ��� ���� ������ ������������ ���´�. (treeSet�� ���� ����!!
	//	������ ū�� ������ ������ ¦���� ���� �̷����� ..�Էµ� ������� ������ ���� �ƴ�)	
	// HashSet�� �̿��������� hasSet�� �ζ� ��ȣ�� �ְ� �����ϱ� ���ؼ� 
	// HashSet�� ������ list�����߰� �� list�� Colloections.sort �޼ҵ带 ȣ���ؼ� ����!
		
	
		
		
		/*Set set =new HashSet();
		for(int i=0 ; set.size()<6 ; i++){
			
		//0 (inclusive)~ 1(exclusive)	
		//random�Լ��� int ����ȯ ����� �Ѵ�!
	     int num = (int)(Math.random()*45+1);
	     set.add(num);
	     
		}
		//set��ü�� ���� ���°ǵ� sort�ϴ°� ���̾ȵȴ�!!!
		//Collections.sort(set);
		List list = new LinkedList(set);
		
		System.out.println("list:"+list);
		Collections.sort(list);
	    System.out.println("set: "+set);

	    System.out.println("After sorting list: "+list);
	
	*/
	/*	
	TreeSet set =new TreeSet();
	while(set.size()<6){
		
		int num = (int)(Math.random()*45+1);
		set.add(num);
		
	  }
	  System.out.println(set);

	*/
	
		
	//************TreeSet2************	
		
/*		TreeSet set =new TreeSet();
		String from ="b";
		String to ="d";
		// b���� ũ�� d���� ������
		// ���� �˻��Ҷ� ~_~
		
		//�빮�ڴ� �ҹ��ں��� �� ���� �ƽ�Ű�ڵ� 
		//���蹮�� ��ҹ��� ���о��ϰ� �����.....��������������ä�
		
		set.add("abc");set.add("alien");set.add("bat");
		set.add("car");set.add("Car");set.add("disk");set.add("dance");
		set.add("elephant");set.add("elevator");set.add("fan");set.add("flower");
		
		System.out.println(set);
		System.out.println("range search: from["+from+"]to ["+to+"]");
		Set subset = set.subSet(from, to);//�������ִ� set�� �ϳ� �����Ѵ�
		// from:����  to:������
		
	     System.out.println(subset);
	     
	     subset = set.subSet(from, to+"z");

	     System.out.println(subset);*/
		
		
/*	    TreeSet set = new TreeSet();	
	    
	    while(set.size()<10){
	    	set.add((int)Math.random()*100+1);
	    }
	    
	    System.out.println(set);
	    System.out.println("50�̸��� ����: "+set.headSet(50));
	    // headSet(50) �ֻ������� 50�̶� 50�̸�. �ֻ������� ���Ծȵ�!!!

	    System.out.println("50�̸��� ����: "+set.tailSet(50));
	    //tailSet(50) 50�̻�. ���������� ���Եȴ�!!! 
	    
	    
	    
		
		*/
	}		
}