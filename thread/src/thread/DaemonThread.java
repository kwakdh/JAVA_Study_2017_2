package thread;

import java.io.*;
import java.util.Scanner;

public  class DaemonThread implements Runnable {

	private static boolean autoSave = false;
	private static String msg = null;
	private PrintWriter pw = null;
	
	public DaemonThread(){
		File file = new File("output.txt");
		try {
			FileOutputStream fo = new FileOutputStream(file, true);
			pw = new PrintWriter(fo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
    while(true){
      try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  if(autoSave ==true){
    	  save();
          }
	   }
    
	}
	
	private void save(){
		String name = Thread.currentThread().getName();
		pw.println(msg);
		pw.flush();
		System.out.println(name + "자동 저장 되었습니다.");
		autoSave= false;
		
	}
	
	
	public static void main(String[] args){
		DaemonThread d = new DaemonThread();
		Thread t = new Thread(d);
		//thread스타트 전에 데몬 스레드 적용시키자 반드시 !
		t.setDaemon(true); //메인이끝나면 자동적으로 쓰레드도 끝!!!!
		
		t.start();
		
		/*for(int i =1 ; i<=10 ; i++){w
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
			if(i==5){
			     autoSave = true;
			     //맨위에 static 없으면 d.autoSave이용 
			     //private static boolean autoSave 
			}
			
		}*/
		Scanner scan = new Scanner(System.in);
		while(true){
			
		System.out.println("입력하세요. [종료는 -1] ");
		msg = scan.nextLine();
		if(msg.equals("-1")) break;
		autoSave = true;
		}
		String name = Thread.currentThread().getName();
		System.out.println(name+":  종료합니다..... ");
		
	}

}



