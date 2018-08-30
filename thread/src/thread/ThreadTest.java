package thread;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadEx01 t1 = new ThreadEx01();
		t1.name="홍길동";
		
		ThreadEx01 t2 = new ThreadEx01();
		t2.name="일지매"; 
		
		t1.start();
		t2.start();
		
		
		////////////////////////////////////////////////////////////
		//runnable인터페이스 구현할 때 적용하는 방법 
		
		ThreadEx2 r1 = new ThreadEx2();
		r1.s="-";
		Thread rt1 = new Thread(r1); //runnable한 객체를 넘겨주기
		rt1.start();
		
		ThreadEx2 r2 = new ThreadEx2();
		r2.s="|";
		Thread rt2 = new Thread(r2);
		rt2.start();
		
	   // r1.start();
	   // r2.start();
	
	   
	
		
	   
	}

}
