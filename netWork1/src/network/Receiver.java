package network;

import java.io.*;
import java.net.*;

public class Receiver extends Thread{
    //통신을 하려면 소켓이 필요하다 !
	
	private Socket socket;
	//receiver는 받는 역할이여서 inputStream!
	private DataInputStream dis;
	
	public Receiver(Socket socket){
		this.socket=socket;
		InputStream is=null;
		
		try {
			is = socket.getInputStream();
			dis= new DataInputStream(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void run(){
    	String msg;
    	while(dis != null){ //inputStream연결될때까지... 돌자 ~
		try {
			msg = dis.readUTF();
			System.out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
    	}
    }	
}
