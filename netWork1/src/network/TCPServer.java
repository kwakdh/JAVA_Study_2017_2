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
		
		System.out.println(" ���� ��û�� ��ٸ��ϴ�. ");
		
	  while(true){
		try {
			Socket socket = serverSocket.accept();
			if(map.get(socket.getInetAddress().toString())==null){
			System.out.println(socket.getInetAddress()+"�κ��� �����û�� ���Դ�");
			//Ŭ���̾�Ʈ�� ip�ּ� �˼��ֵ�
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
			ds.writeUTF("�ȳ��ϼ��� �氡�氡 ^______________^ ����������"+socket.getInetAddress());
			
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			String msg = dis.readUTF();
			System.out.println("Ŭ���̾�Ʈ�� ���� �� �޽��� : " + msg);
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
