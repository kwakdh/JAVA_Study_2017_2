package genericRensyu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class statistics {
	
	
	
	public static<T extends student> void gradeStu(ArrayList<T> list){
		
		//����, ���, �ְ��л�,�����л�
		
		int total=0;
		double average=0;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		T maxSt=null;
		T minSt=null;
		
		Iterator<T> it = list.iterator();
		
		while(it.hasNext()){
			T t = it.next();
		    
			total += t.getScore();
			
			if(max<t.getScore()){
				max=t.getScore();
				maxSt=t;
			}
			if(min>t.getScore()){
				min=t.getScore();
				minSt=t;
			}
		}
		
		average= total/(double)list.size();
		System.out.println("����: "+total);
		System.out.println("���: "+average);
		System.out.println("�ְ��л�: "+maxSt.toString());
		System.out.println("�����л�: "+minSt.toString());
	}
	
	//any �� �ްٴ�... �����ϴ� �޼��� ~~~~~~~~~~~``
	public static void sort(ArrayList<? extends student> 
	list){
		
		Collections.sort(list);
		
	}
	
	
	//�ݴ�� �����ϱ� 
	public static <T extends student>void descendingSort(ArrayList <T> list){
	//	Collections.sort(list , /*comparator�������̽��� ������ ��ü�� �Ѱ��ֱ� */);
		Collections.sort(list , new StudentDescOrder<T>());
		
	}
	
     //sortReverse ������ 	
	//<? super T> �̰ž��� ������ fruit���� �����ϴ°� �ƴ϶� ��ӹ޴� apple�� ����; 
	public static<T extends Comparable<? super T>> void sortReverse(List<T> list){

		//Collections.sort(list);//��������
		
		Collections.sort(list,new FruitDescOrder<T>());//����
		
		
	}


	
	
}
