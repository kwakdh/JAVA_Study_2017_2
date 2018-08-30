package network;
import java.io.IOException;
import java.net.*;

public class ChatServer {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
			
			while(true){
				
			socket = serverSocket.accept();
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start(); //run이 실행되어야 새로운 스레드가 나타나짐
			                //start메소드 내에서 run메서드 불러옴
			                //run메서드를 직접적으로 불러서는 안된다
			                //반드시 start메소드를 불러와야 한다 !!!!!!!!!!!!!!!!
			receiver.start();
			
	      }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
  //멀티 스레드는 모든 스레드가 종료되어야 프로세스가 종료된다
  //싱글 스레드일때는 이상태에서 바로 프로세스가 종료된다. 
}
