package thread;
import javax.swing.*;
public class ThreadEx06 implements Runnable{

	public static void main(String[] args) {
		
		ThreadEx06 r = new ThreadEx06();
		Thread t = new Thread(r);
		t.start();
		
		String input = JOptionPane.showInputDialog( "�ƹ� ���̳� �Է��ϼ��� " );
		System.out.println( "�Է��Ͻ� ���� : "+input+"�Դϴ�");
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"������");
	    
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
