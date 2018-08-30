package thread;

 public class ThreadEx2 implements Runnable{

	 //상속받는게 다른 클래스를 받고 스레드도 하고싶은경우 !!!
	 //extends ThreadEx01 implements Runnable	
		
	String s ; 
	 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<500;i++){
			System.out.print(s);
		}
	}

	 
	
	
}
