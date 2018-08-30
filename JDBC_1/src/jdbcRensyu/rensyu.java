package jdbcRensyu;

import javax.swing.JOptionPane;

public class rensyu implements Runnable{
   private int cnt = 0;
   public static void main(String args[])  /*throws Exception*/ {
	   
   rensyu rn = new rensyu();
   Thread th = new Thread(rn);
   th.start();
   
   rensyu rn2 = new rensyu();
   Thread th2 = new Thread(rn2);
   th2.start();
   
	   
   
   }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(cnt <200){
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cnt++;
			
			
		}
		String name = Thread.currentThread().getName();
		System.out.println(name +":"+ cnt);
		
		
	}

	
	
	
	
}


