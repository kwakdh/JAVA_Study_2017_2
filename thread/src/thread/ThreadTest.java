package thread;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadEx01 t1 = new ThreadEx01();
		t1.name="ȫ�浿";
		
		ThreadEx01 t2 = new ThreadEx01();
		t2.name="������"; 
		
		t1.start();
		t2.start();
		
		
		////////////////////////////////////////////////////////////
		//runnable�������̽� ������ �� �����ϴ� ��� 
		
		ThreadEx2 r1 = new ThreadEx2();
		r1.s="-";
		Thread rt1 = new Thread(r1); //runnable�� ��ü�� �Ѱ��ֱ�
		rt1.start();
		
		ThreadEx2 r2 = new ThreadEx2();
		r2.s="|";
		Thread rt2 = new Thread(r2);
		rt2.start();
		
	   // r1.start();
	   // r2.start();
	
	   
	
		
	   
	}

}
