package network;

import java.net.*;
import java.io.*;

public class TCPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String serverIp ="106.249.39.228";
		System.out.println("������ ���� ���Դ�"+ "��. ���� IP: "+serverIp);
		try {
			
			Socket socket = new Socket(serverIp,7777);
			
			InputStream is = socket.getInputStream();
			DataInputStream ds = new DataInputStream(is);
			System.out.println("������ ���� ���� �޽���:"+ds.readUTF());
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("�� �޾Ѵ� ������~");
			dos.close();
			ds.close();
			socket.close();
			System.out.println("������ ����Ǿ����ϴ�.");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
