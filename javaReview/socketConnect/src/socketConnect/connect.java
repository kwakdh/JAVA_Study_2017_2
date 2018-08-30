package socketConnect;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class connect {
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket acceptedSocket = null;

		System.out.println("Sever 1");

		try {

			serverSocket = new ServerSocket(5556);

		} catch (IOException e) {
			System.out.println("서버 소켓 생성 실패");
		}

		try {
			acceptedSocket = serverSocket.accept();
			InputStream is = acceptedSocket.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			System.out.println(dis.readUTF());

			acceptedSocket.close();
		} catch (IOException e) {
			System.out.println("연결 설정 실패");
		}

		System.out.println("Sever 2");
	}
}
