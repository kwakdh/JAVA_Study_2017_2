package suUp;
import java.util.HashMap;

public class suUp0327_3 {
    
	static HashMap phoneBook= new HashMap();
	//Ŭ���� �ȸ���� (��ü���� ���ϰ� )����ϱ����ؼ� ! static���
	/*
	 * phonebook�� (�׷��̸�,hashMap��ü)������ ����*/
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  //*************�׷캰�� ��ȭ��ȣ�� �����************	
      //key���� ��ȭ��ȣ�� �ϰٴ� �ֳ� key���� �̸������� �������� ����� ������..
	  //value ���� �̸��� �ִ´�.	
	  //key(�׷��̸�),value(�Ʊ� ������ �ؽ��� ��ü)
	  //�ؽ��ʾȿ� �ؽ��ʳֱ�..	
	
		//���� ����ƽ������ �ƴϸ� ��ü ������~
	     addPhoneNo("ģ��","���ڹ�","010-111-1111");
		 addPhoneNo("ģ��","���ڹ�","010-222-2222");
		
	}
	//��ȭ��ȣ�� ���������� �ҷ����� �޼��� 
	static void addPhoneNo(String groupName,String name, String tel){
		//�׷� �̸��� key�� �ؼ� �� �׷��� ��ȭ��ȣ�� ������ hashmap��ü�� �޾ƿ;���
		HashMap group = (HashMap)phoneBook.get(groupName);
	    if(group==null){
	    	group =new HashMap();
	    	phoneBook.put(groupName, group);
	    	
	    }
	    
	    group.put(tel, name);
	}

}


