package thread;

public class CountThread implements Runnable{

   
	public static void main(String args[]){
		
		CountThread ct = new CountThread();
		//ct.run();
		//ct.run(); //�̹� �տ��� 200�ϰ� ������ �������� 
		
		Thread t1 = new Thread(ct);
		t1.start();
		
		//thread�� �����ֱⰡ �ִ�. run�޼ҵ带 ������ ����Ǽ� �״´� ... !!!!
		//t1.start(),t1.start() �̰Ÿ� �ΰ� ���ָ� ���� ��� .
		

		CountThread ct2 = new CountThread();
		Thread t2 = new Thread(ct2);
		t2.start();
		//��Ƽ ������ ����Ϸ��� �����带 �ΰ� �������Ѵ� . 
		//cnt�� ���������� ���� ����ȴ�. 
		
		
	}
}
