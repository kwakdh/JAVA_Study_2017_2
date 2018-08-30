package network;

import java.io.*;
import java.net.*;

public class ChatClient {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("106.249.39.228",7777);
			
			System.out.println("서버 연결 오케잉~^______^");
			
			Receiver receiver =new Receiver(socket);
			Sender sender = new Sender(socket);
			
			receiver.start();
			sender.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

