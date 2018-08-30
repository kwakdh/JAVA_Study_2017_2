package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread{

	private Socket socket;
	private DataOutputStream dos; //������ ���Ҹ� �ϴϱ�......
	private String name;
	
	//������ 
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
		while(dos!=null){ //�Է��ϸ� �������ϴ� ���� ���� ����(�����Ͱ� ����ִµ���...) 
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
