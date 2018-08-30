package ch11;

import java.util.*;
import java.util.Map.Entry;

public class HashMap3 {
	static HashMap<String, HashMap<String, String>> phoneBook = 
					new HashMap<String, HashMap<String, String>>();
	public static void main(String[] args) {
		/* Map: HashMap, TreeMap */
		/* <key, value> pair ����.
		 * HashMap Ÿ���� phoneBook�� �����Ѵ�.
		 * <group name, HashMap ��ü>
		 * �� group name�� ������ ����Ǵ� HashMap ��ü����
		 * <��ȭ��ȣ, �̸�>�� ���� ����ȴ�. 
		 */
		/*
		 * 1. HashMap phoneBook = new HashMap();
		 * phoneBook.get("ģ��");
		 * ù ��° ��û�� ���, �갡 �����ϴ� ���� null�̴�. 
		 * �� ���� phoneBook.put("ģ��", new HashMap());
		 * �� ��° phoneBoo.get("ģ��") ���ʹ�
		 * ù ��°���� �־��� HashMap ��ü�� ��ȯ�ɰŴ�. 
		 * �� ��ü�� <��ȭ��ȣ, �̸�> ���� put ���ָ� �ȴ�. 
		 */
		addPhoneNo("ģ��", "���ڹ�", "010-111-1111");
		addPhoneNo("ģ��", "���ڹ�", "010-222-2222");
		addPhoneNo("ģ��", "���ڹ�", "010-333-3333");
		addPhoneNo("ȸ��", "���ڹ�", "010-444-4444");
		addPhoneNo("ȸ��", "��븮", "010-555-5555");
		addPhoneNo("ȸ��", "�ڴ븮", "010-666-6666");
		addPhoneNo("ȸ��", "�̰���", "010-777-7777");
		addPhoneNo("��Ź", "010-888-8888");
		printList();
		updatePhoneNo("ģ��", 
				"010-333-3333", "010-322-3232");
		// ��������: printPhoneNo("ģ��", "���ڹ�");
		     // 010=2221=21
		     // 010 23443 4553
		
		// ��������: printPhoneNo("���ڹ�");
			// �׷��̸�  0101
			// �׷��̸�2  000232��3
			// �׷��̸�3  010212
		
		System.out.println("After update!!!");
		printList("ģ��");
//		removePhoneNo("ȸ��", "010-444-4444");
		System.out.println("After remove!!!!");
		printList("ȸ��");
		
		
		//printGroups();
		
		 printPhoneNo("ģ��", "���ڹ�");
		 printPhoneNo("���ڹ�");
		
	}
	
	static void printPhoneNo(String grpName, String name) {
		HashMap<String, String> hm = phoneBook.get(grpName);
		Set<Entry<String, String>> set = hm.entrySet();
		Iterator<Entry<String, String>> it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, String> map = it.next();
			if (map.getValue().equals(name)) {
				System.out.println(name + " : " + map.getKey());
			}
		}
	}
	
	static void printPhoneNo(String name) {
		/*
		Set<Entry<String, HashMap<String, String>>> set = phoneBook.entrySet();
		Iterator<Entry<String, HashMap<String, String>>> it1 = set.iterator();
		
		while(it1.hasNext()) {
			Entry<String, HashMap<String, String>> entry = it1.next();
			
			String grpName = entry.getKey();
			
			HashMap<String, String> hm1 = entry.getValue();
			Set<Entry<String, String>> set1 = hm1.entrySet();
			Iterator<Entry<String, String>> it2 = set1.iterator();
			
			while (it2.hasNext()) {
				Entry<String, String> ent2 = it2.next();
				if(ent2.getValue().equals(name)) {
					System.out.println("[" + grpName + "] " + name + " : " + ent2.getKey());
					
				}
			}
			
		}*/
		Set<String> set = phoneBook.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String grpName = it.next();
			System.out.println("\n�׷�:"+grpName);
			printPhoneNo(grpName, name);
		}
	}
	
	static void printGroups() {
		System.out.println("Group names.....");
		Set<String> set = phoneBook.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
	/*
	 * HashMap<String, String> h 
	 * 			= new HashMap<String, String>();
	 * HashMap�� ����Ǵ� ��ü�� Ÿ���� Map.Entry �̴�. 
	 * �׷���, <key, value> ���� Ÿ���� <String, String>
	 * Generic�� ����ؼ� Ÿ���� ����Ѵٸ�
	 * HashMap�� ����Ǵ� ��ü(h�� �ϸ�)�� Ÿ���� 
	 * Map.Entry<String, String>
	 * Set<Map.Entry<String, String>> s =  h.entrySet();
	 * Iterator<Map.Entry<String, String>> it = s.iterator();
	 * Map.Entry<String, String> e = it.next();
	 * e.getKey(); e.getValue();
	 * 
	 * HashSet set = new HashSet();
	 * Generic�� �̿��ؼ� ǥ���ϸ�, 
	 * �׸��� ���࿡ �� set�� ����Ǵ� ��ü�� Ÿ���� String �̶��
	 * HashSet<String> set = new HashSet<String>();
	 * Iterator<String> it = set.iterator();
	 * String s = it.next();
	 * 
	 */
	
	static void printList(String groupName) {
		/*
		 * groupName�� Ű�� phoneBook���� 
		 * HashMap ��ü�� ã�´�. 
		 * �� ��ü�� entry�� �� ����ش�. 
		 */
		HashMap<String, String> group 
			= phoneBook.get(groupName);
		
		if(group==null) {
			System.out.println("�׷� �׷��� ����!!!!");
			return;
		}
		Set<Map.Entry<String, String >> es 
					= group.entrySet();
		Iterator<Map.Entry<String, String>> it =
				es.iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> e =
					it.next();
			System.out.println("name:"+e.getValue()
				+", poneNo:"+e.getKey());
		}
		System.out.println("################\n");
	}
	static void updatePhoneNo(String groupName, 
			 String oldTel, String newTel) {
		// groupName�� key ������ �ؼ� �� group�� 
		/* ��ȭ��ȣ�� �����ϰ� �ִ� HashMap ��ü�� ã��
		 * �� HashMap ��ü���� oldTel�� Ű������
		 * �� �����Ǵ� ���� �����´�(�̸�).
		 * oldTel�� Ű������ ������ ��Ʈ���� �����Ѵ�. 
		 * <newTel, �̸�>���� HashMap�� put
		 */
		HashMap<String, String> phones 
					= phoneBook.get(groupName);
		String name = phones.get(oldTel);
		if(name == null) {
			System.out.println("�׷� ��ȣ ����!~");
			return;
		}
		phones.remove(oldTel);
		phones.put(newTel, name);
		
	}
	static void removePhoneNo(String groupName, String tel) {
		HashMap<String, String> h = phoneBook.get(groupName);
		//String name = h.get(tel);
		if(h.containsKey(tel) == false) {
			System.out.println("�׷� ��ȣ �����!!!");
			return;
		}
		h.remove(tel);		
	}
	
	static void addGroup(String groupName) {
		if (phoneBook.containsKey(groupName)==false) {
		//if(phoneBook.get(groupName) == null) {
			phoneBook.put(groupName, new HashMap<String, String>());
		}
	}
	
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap<String, String> group =
				phoneBook.get(groupName);
		group.put(tel, name); 		
	}
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("��Ÿ", name, tel); 		
	}
	
	static void printList() {
		Set<Map.Entry<String, HashMap<String, String>>> set 
						= phoneBook.entrySet();
		Iterator<Map.Entry<String, HashMap<String, String>>> it 
					= set.iterator();
		while(it.hasNext()) {
			Map.Entry<String, HashMap<String, String>> e 
						= it.next();
			HashMap<String, String> group = e.getValue();
			Set<Map.Entry<String, String>> phoneSet = group.entrySet();
			Iterator<Map.Entry<String, String>> phoneIt 
							= phoneSet.iterator();
			System.out.println(e.getKey()+"["+ phoneSet.size()+"]");
			while(phoneIt.hasNext()) {
				Map.Entry<String, String> p = phoneIt.next();
				String tel = p.getKey();
				String name = p.getValue();
				System.out.println(name+", "+tel);
			}
			System.out.println("\n");
		}
	}
}
