package thread;

 public class ThreadEx2 implements Runnable{

	 //��ӹ޴°� �ٸ� Ŭ������ �ް� �����嵵 �ϰ������� !!!
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
