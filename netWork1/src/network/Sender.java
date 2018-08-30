package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread{

	private Socket socket;
	private DataOutputStream dos; //보내는 역할만 하니까......
	private String name;
	
	//생성자 
	public Sender(Socket socket){
		this.socket=socket;
		
		OutputStream os;
		try{
		 os = this.socket.getOutputStream();
		 dos = new DataOutputStream(os);
		 name ="["+socket.getInetAddress()+":"+socket.getPort()+"]";
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		Scanner scan = new Scanner(System.in);
		while(dos!=null){ //입력하면 보내게하는 무한 루프 생성(데이터가 살아있는동안...) 
		try {
			String s = scan.nextLine();
			dos.writeUTF(name+s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        	}
	       }    
		}
	
}
