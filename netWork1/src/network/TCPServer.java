package network;

import java.net.*;
import java.util.HashMap;
import java.io.*;

public class TCPServer {
	public static void main(String args[]){
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(7777);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		HashMap<String,Integer> map = new HashMap<>();
		
		System.out.println(" 연결 요청을 기다립니다. ");
		
	  while(true){
		try {
			Socket socket = serverSocket.accept();
			if(map.get(socket.getInetAddress().toString())==null){
			System.out.println(socket.getInetAddress()+"로부터 연결요청이 들어왔다");
			//클라이언트의 ip주소 알수있따
			map.put( socket.getInetAddress().toString() , 1);
			}else {
				int cnt = map.get(socket.getInetAddress().toString());
				map.put(socket.getInetAddress().toString(), cnt+1);
			}
			/*try {
				Thread.currentThread().sleep(1000*10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream ds = new DataOutputStream(os);
			ds.writeUTF("안녕하세요 방가방가 ^______________^ 나가누구게"+socket.getInetAddress());
			
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			String msg = dis.readUTF();
			System.out.println("클라이언트로 부터 온 메시지 : " + msg);
			ds.close();
			
			socket.close();
			//serverSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		}
	}
}
