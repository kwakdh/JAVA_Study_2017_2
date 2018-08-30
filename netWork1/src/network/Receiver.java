package network;

import java.io.*;
import java.net.*;

public class Receiver extends Thread{
    //����� �Ϸ��� ������ �ʿ��ϴ� !
	
	private Socket socket;
	//receiver�� �޴� �����̿��� inputStream!
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
    	while(dis != null){ //inputStream����ɶ�����... ���� ~
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
