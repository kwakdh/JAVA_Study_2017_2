package suUp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class suUp0331 {
    
	static HashMap<String,HashMap<String,String>> phoneBook =
			new HashMap<String,HashMap<String,String>>();
	
	public static void main(String[] args) {
     /* map: hashmap,treemap
      * hashmap Ÿ���� phonebook����
      * <groupname,hashmap��ü >
      * �� group name�� ������ ����Ǵ� hashmap��ü���� 
      * (��ȭ��ȣ,�̸�)�� ���������
      * */
		
	//  hashmap phonebook = new HashMap();
	//  phonebook.get("ģ��");
	//  ù��° ��û�� ��� �갡 �����ϴ� ���� null�̴� �׶��� new�� �ϳ� �����Ǽ� 
	//  phonebook.put("ģ��", new HashMap());
	//  �ι�° 	phonebook.get("ģ��") ���ʹ�  ù��°���� �־���hashmap��ü�� ��ȯ�ɰ�
	//  �� ��ü�� <��ȭ��ȣ,�̸�> ���� put���ָ� �ȴ�.	
		
		addPhoneNo("ģ��","���ڹ�","010-111-1111");
		addPhoneNo("ģ��","���ڹ�","010-222-2222");
		addPhoneNo("ģ��","���ڹ�","010-333-3333");
		
		addPhoneNo("ȸ��","��븮","010-444-4444");
		addPhoneNo("ȸ��","��븮","010-555-5555");
		addPhoneNo("ȸ��","�ڴ븮","010-666-6666");
		addPhoneNo("ȸ��","�̰���","010-777-7777");

		addPhoneNo("��Ź","010-888-8888");
		printList();
		
		updatePhoneNo("ģ��","010-333-3333","010-322-3232");

		System.out.println("--------------------------------");
		System.out.println(" ");
		
		//�׳� �� ��ü �������� printList�ϸ� �Ǵµ� ���࿡
		//�� �׷��� ���븸 ��������.... ��������� �Ѵ� .
		System.out.println("update~!!!!!");
		printList("ģ��");
		
		System.out.println("--------------------------------");
		System.out.println(" ");
	
		
		//��������1: printPhoneNo("ģ��","���ڹ�");
		// ģ���� ���ڹ� ������ϱ�
		// 010-29312-23213
		// 010-2313-2130
		
		//�������� 1 ���� �����ͼ� ����2�� �Ͻÿ� 
		//�������� 2 :printPhoneNo("���ڹ�")
		//  �׷��̸� 999-112
		//  �׷��̸� 324982349823
		//  

		System.out.println("--------------������-----------");
		removePhoneNo("ģ��","010-444-4444");
		System.out.println("--------------------------------");
		printList();
		
		
		System.out.println("--------------------------------");
		printGroups();//�׷��̸��� ����� �޼���
		System.out.println("********���� 1********");
		
		printGwaze1("ģ��","���ڹ�");
		System.out.println("********���� 2**********");
		printGwaze2("���ڹ�");  
	}
	

	//���� 1*******************************************************
     static void printGwaze1(String groupName, String name){
    	HashMap<String,String> group = phoneBook.get(groupName);
    	Set<Map.Entry<String,String>> set = group.entrySet();
    	Iterator<Map.Entry<String,String>> it = set.iterator();
    	
    	while(it.hasNext()){
    		
    		Map.Entry<String,String> e = it.next();
    		if(name.equals(e.getValue())){
    			System.out.println(name +"�� ��ȣ : "+e.getKey());}
    		}
    	
    	}
	
	
	//����2*****************************************************
   
     static void printGwaze2(String name){
    	
    	 Set <Map.Entry<String,HashMap<String,String>>> set1 = phoneBook.entrySet();
    	 Iterator <Map.Entry<String,HashMap<String,String>>> it1 = set1.iterator();
    	 
    	 while(it1.hasNext()){
    		 
    		 Map.Entry<String,HashMap<String,String>> e1 = it1.next();
    		 System.out.println(e1.getKey());
    		
    		 HashMap <String,String> group = e1.getValue();
    		 if(group.containsValue(name)){
    			 Set<Entry<String, String>>  set2 = group.entrySet();
    			 Iterator<Entry<String, String>> it2 = set2.iterator();
    			 
    			 while(it2.hasNext()){
    				 
    				 Map.Entry<String,String> e2 = it2.next();
    				 if(name == e2.getValue()){
    					 System.out.println(e2.getKey());
    				 }
    				 
    			 }
    			 
    		 }
    		 
    		 //�ݺ����ϰ� �׷��̸� 
    		 /*Set<String> set = phoneBook.keySet();
    		 Iterator<String> it =set.iterator();
    		 while(it.hasNext()){
    			 String grpName = it.next();
    			 System.out.println("\n�׷��̸�: "+grpName);*/
    			 
    		 }
    	 }
    	 
    	 
     }
     
     
     
	//�׷����� �����°� ~_~ 
	static void printGroups(){
		  System.out.println("�׷�~_~_~_~_~_~_~_~");
		  Set <String> set = phoneBook.keySet();
		  Iterator<String> it = set.iterator();
		  while(it.hasNext()){
			  System.out.println(it.next());
		  }
	  }
	
	/*
	 * HashMap<String,String> h = new HashMap<String,Stirng>();
	 * 
	 * HashMap�� ����Ǵ� ��ü�� Ÿ���� Map.entry�̴�.
	 * �׷��� <key,value> ���� Ÿ���� <String,String>�̸�
	 * Generic�� ����ؼ� Ÿ���� ����Ѵٸ� 
	 * hashMap�� ����Ǵ� ��ü(h�� �ϸ�)�� Ÿ����
	 * Map.Entry<Stirng,String>�̴� 
	 *  Set<Map.Entry<String,String>> s = h.entrySet();
	 *  Iterator<Map.Entry<String,String>> it =s.iterator;
	 * Map.Entry<String,String> e = it1.next();
	 * e.getKey(); e.getValue();
	 * 
	 * 
	 * HashSet set= new HashSet();
	 * Generic�� �̿��ؼ� ǥ���ϸ�, �׸��� ���࿡ �� set�� ����Ǵ�
	 * ��ü�� Ÿ����  String�̶�� 
	 * HashSet<String> set= new HashSet<String>();
 	 * Iterator<String> it = set.iterator();
 	 * String s= it.next();
 	 * 
 	 * 
	 * */
	
	
	
	
	static void printList(String groupName){
		HashMap<String,String>group=phoneBook.get(groupName);
		
		if(group==null){
			System.out.println("�׷� �׷� ���� !!!!!");
			 return;
		}
		Set<Map.Entry<String,String>> es= group.entrySet();
		
		Iterator<Map.Entry<String, String>> it =es.iterator();
		while(it.hasNext()){
			Map.Entry<String, String> e =it.next();
         System.out.println("name: "+e.getValue()+",phoneNo :"+e.getKey());
		
		}
		
	}
	
	
	//������Ʈ �޼���
	static void updatePhoneNo(String groupName,String oldTel,String newTel){
		
		//groupName�� key������ �ؼ� �� group�� ��ȭ��ȣ�� �����ϰ� �ִ� hashmap��ü�� ã��
		//�� �ؽ��ʰ�ü���� oldtel�� Ű������ �ؼ� �� �����Ǵ� ���� �����´� (�̸��� ������ )
		//oldtel�� Ű������ ������ ��Ʈ���� �����Ѵ�. ----> �����ϰ� ���� ���������� ��ü�ؼ� �ֱ� 
		//<newTel,�̸�> ���� HashMap�� put
		
		HashMap<String,String>phones =phoneBook.get(groupName);
		String name= phones.get(oldTel);
		if(name== null){
			System.out.println("�׷� ��ȣ ���� ");
			return;//������ 
		}
		
		phones.remove(oldTel);
		phones.put(newTel,name);
		
	}
	//��ȭ��ȣ ���� �޼��� 
	static void removePhoneNo(String groupName,String tel){
	   
		//���� �ؽ��ʾȿ� �ؽ����̴� 
	   HashMap<String,String> h = phoneBook.get(groupName);	
	   String name = h.get(tel);
	   if(h.containsKey(tel) == false){
		   System.out.println("�׷� ��ȣ ���� ");
	       return;
	   }
	   
	   h.remove(tel);
	}
	
	
	
	//�׷��� ������ΰ� �����ΰ� ?!
	static void addGroup(String groupName){
		if(phoneBook.containsKey(groupName) == false){
		//if(phoneBook.get(groupName)==null)	
	       phoneBook.put(groupName, new HashMap<String,String>());
		}
	}
	
	//�긦 �ٷ� �θ� 
	static void addPhoneNo(String groupName,String name, String tel ){
	    addGroup(groupName);
		HashMap<String,String>group= phoneBook.get(groupName);
	    //�׷�� �´� �ؽ����ּ���
		
		group.put(tel, name);
		phoneBook.put(groupName, group);

    }
	
	//�����ε��ϰڴ� �ֳ�? �׷��̸� �Ⱦ��� �׳� �ٷ� ������ �ֱ� ������ 
	static void addPhoneNo(String name, String tel ){
	    addPhoneNo("��Ÿ",name,tel);
	
    }
	
	static void printList(){
     Set<Map.Entry<String, HashMap<String,String>>> set
                                   =  phoneBook.entrySet();
     
      //iterator�ȿ� �� ���Ұ� ����
     Iterator<Map.Entry<String, HashMap<String,String>>> it 
                                   = set.iterator();
     //�׷� ��ü ����� 
     while(it.hasNext()){
    	Map.Entry<String, HashMap<String,String>> e = it.next();
         
       HashMap<String,String>group = e.getValue();
       Set<Map.Entry<String,String>> phoneSet = group.entrySet();
       Iterator<Map.Entry<String,String>> phoneIt= phoneSet.iterator(); 
      
       //�̱׷쿡 ��ȭ��ȣ�� � �ִ��� . �׷��� �� entry�� e�� 
       
       System.out.println(e.getKey()+"["+phoneSet.size()+"]");
       
       // �ϳ��� �׷쿡�� ��ȭ��ȣ ��°� 
        while(phoneIt.hasNext()){
        	Map.Entry<String,String> p = phoneIt.next();
        	String tel = p.getKey();
        	String name = p.getValue();
        	System.out.println(name+","+tel);
        }
         System.out.println("\n");
     }
     
	
	}
}
