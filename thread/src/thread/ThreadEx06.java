package thread;
import javax.swing.*;
public class ThreadEx06 implements Runnable{

	public static void main(String[] args) {
		
		ThreadEx06 r = new ThreadEx06();
		Thread t = new Thread(r);
		t.start();
		
		String input = JOptionPane.showInputDialog( "아무 값이나 입력하세요 " );
		System.out.println( "입력하신 값은 : "+input+"입니다");
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"쓰레드");
	    
	/*	for(int i = 10; i>0 ; i--){
			System.out.println(i);
		  try{
			Thread.sleep(1000);
		  }catch(Exception e){}	
	  }*/
	}	
	public void run(){
		for(int i = 10; i>0 ; i--){
			System.out.println(i);
		  
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
	  }
	}
}
