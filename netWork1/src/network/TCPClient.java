package network;

import java.net.*;
import java.io.*;

public class TCPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String serverIp ="106.249.39.228";
		System.out.println("서버에 연결 중입니"+ "다. 서버 IP: "+serverIp);
		try {
			
			Socket socket = new Socket(serverIp,7777);
			
			InputStream is = socket.getInputStream();
			DataInputStream ds = new DataInputStream(is);
			System.out.println("서버로 부터 받은 메시지:"+ds.readUTF());
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("잘 받앗다 서버야~");
			dos.close();
			ds.close();
			socket.close();
			System.out.println("연결이 종료되었습니다.");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
