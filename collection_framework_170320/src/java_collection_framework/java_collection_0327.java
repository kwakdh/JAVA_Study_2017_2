package suUp;

import java.util.HashMap;
import java.util.Scanner;

public class suUp0327 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //hashMap!!!!!!!
		//���� �����ϴ°� �ƴ϶� �� ���� ã������ key���� ã�¤�
		//key�� �� �Ѵ� �����Ѵ�.--->���� ��� �ϳ��� �����ͷ� ����
		//�ؽ��� �̿��ϱ� ������ �˻��� �پ ������ ������ �մ�!!
		//ȸ������ ���̵�� ��й�ȣ�� Ű,�� ������ �����Ѵ�.
		//�ؽ��ڵ尪�� �� �����ϴ°��� �����̴� 
		
		HashMap map = new HashMap();
		map.put("myId","1234");//key�� value �Ѵ� �����ؾ���.
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		
		
	    System.out.println(map.get("myId"));//�� --->1234
	    System.out.println(map.get("asdf"));
	    //Ű���� ������ ������ value���
		//------------->1234
		
		
		/* --------����ڰ� �Է��� ���̵�� ��ȣ�� 
		 *         �ؽ��ʿ� ����� �װͰ� ��ġ�Ҷ����� �ݺ�!!!!!!------
		 *  1.����ڷ� ���� ���̵�� ��ȣ�� �Է¹޴´�. 
		 * �Է��� ���̵� �������� ������ ���̵� �������� �ʴ´ٴ� �޽������
		 *  2.���̵�� �ִµ� ��й�ȣ�� ���� ������
		 * ��й�ȣ�� ��ġ���� �ʴ´ٴ� �޽������
		 * 
		 * */
		Scanner scn= new Scanner(System.in);
		
	    while(true) {
	    	//���̵� �Է¹ް� ��ȣ�Է¹ް�
	    	System.out.println("���̵�� �н����� �Է��ض�");
	    	System.out.print("ID:");
	    	String id=scn.nextLine();
	    	id=id.trim();	//����©������� trim 
	    	
	    	System.out.print("password: ");
	    	String pw=scn.nextLine().trim();
	    	
	    	
	        //���̵� ������ �ٽ� ������ ó������ ���� �Է¹ް�
	    	map.containsKey(id);//���̵� �ִ��� ������ ����°�
	    	if(map.containsKey(id)==false){
	    		System.out.println("�׷� ���̵� ���� ");
	    		continue;//�ٽ� ���� �ö󰣴� 
	    	}
	    	//���� ������Ʈ�� ��ȯ�ϱ⶧���� ���׸��ț����� �տ� Ÿ��ĳ�������ֱ�
	    	String stredPw=(String)map.get(id);
	    	//Ű���� �ش��ϴ� value�� stredPw�� �ش�.
	    	
	    	if(stredPw.equals(pw)){
	    		//value���� ����ڰ� �Է��� pw���� ������...
	    	System.out.println("id�� pw�� ��ġ�մϴ�.");	
	    	break;//���ѷ��� �����ֱ�..	
	    	}
	    	else{
	    		System.out.println("��ġ���� �ʴ´�.");	
	    	}
	    	
	    	//�׷��� ������ ��ȣ�� ��ġ�ϴ��� ���� 
	    	//��ġ�ϸ� �������� 
	    	
	    	
	    }
		
		
	}

}
