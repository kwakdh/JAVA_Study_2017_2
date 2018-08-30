package thread;

public class CountThread implements Runnable{

   
	public static void main(String args[]){
		
		CountThread ct = new CountThread();
		//ct.run();
		//ct.run(); //이미 앞에서 200하고 끝나서 안찍힌다 
		
		Thread t1 = new Thread(ct);
		t1.start();
		
		//thread는 생명주기가 있다. run메소드를 끝나면 종료되서 죽는다 ... !!!!
		//t1.start(),t1.start() 이거를 두개 써주면 에러 뜬다 .
		

		CountThread ct2 = new CountThread();
		Thread t2 = new Thread(ct2);
		t2.start();
		//멀티 쓰레드 사용하려면 쓰레드를 두개 만들어야한다 . 
		//cnt의 지역변수가 따로 적용된다. 
		
		
	}
}
