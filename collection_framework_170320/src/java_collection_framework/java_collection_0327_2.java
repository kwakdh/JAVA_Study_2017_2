package suUp;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class suUp0327_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
		//[�̸�(key)�� ����]�� ������ hashMap�� ����
		//���� �̸��� �л��� ���ٰ� �����ϱ�.
		
		/*
		 * �л����� ����,���,�ְ�����,��������  ���ϱ�
		 * */
		HashMap map=new HashMap();
		map.put("���ڹ�",90);
		map.put("���ڹ�",100);
		// ���ڹٰ� 2���̸� �̰� �������� �ڿ����� ���
		map.put("���ڹ�",100);
		map.put("���ڹ�",80);
		map.put("���ڹ�",90);
		//�ڿ��ִ°� �տ��ִ°��� �����.
		
		Set set = map.entrySet();//entrySet�� �޶�� ���̴�.
		
		//�ʿ��� �ٷ� ���ͷ��� �޶�Į�� ����
		//�ϳ��ϳ� �����ϴ� ����� iterator�̴�.
		Iterator it = set.iterator();
		//iterator ���� map.entryŸ���� ��ü���� ����ִ�. 
	
		//�ʿ��ִ°� �����ҷ��� �̹�����
	    while(it.hasNext()){
	    	Map.Entry entry = (Map.Entry)it.next();
	    	System.out.println("�̸�: "+entry.getKey()+" ,����: "+entry.getValue());
	    }
		
		set =map.keySet();//key�� ���ո� �޶�� �Ҷ�?!
		System.out.println(set);//----->���ڹ�,���ڹ�,���ڹ�,���ڹ�

	    Collection values=map.values();//collectionŸ������ �����Ѵ�.
	    it=values.iterator();//���� �����Ͷ� ~_~ 
	    
	    int total=0;
	    //***���1***
	   // int max=-1;
	   // int min=200;
	    
	    //***���2***
	    int max=Integer.MIN_VALUE;
	    int min=Integer.MAX_VALUE;
	    
	    
	    while(it.hasNext()){
	    	int jumsu=(int)it.next();
	    	
	    	total += jumsu;// next�� ��ü�� �����ϴϱ� Ÿ��ĳ����!!
	    	
	    	if(jumsu>max)max=jumsu;
	    	if(jumsu<max)min=jumsu;
	    }
	    
	    System.out.println("����: "+total);
	    System.out.println("���: "+((double)total/values.size()));
	    
	    System.out.println("�ְ�����: "+max);
	    //�ݷ��� Ÿ������ ã���ִ� ����� 3��°��
	    System.out.println("�ְ�����: "+Collections.max(values));
	    
	    System.out.println("��������: "+min);
	   System.out.println("��������: "+Collections.min(values));
	   
	    
	    
	    
	}

}
