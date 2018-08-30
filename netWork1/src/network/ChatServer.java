package network;
import java.io.IOException;
import java.net.*;

public class ChatServer {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("������ �غ�Ǿ����ϴ�.");
			
			while(true){
				
			socket = serverSocket.accept();
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start(); //run�� ����Ǿ�� ���ο� �����尡 ��Ÿ����
			                //start�޼ҵ� ������ run�޼��� �ҷ���
			                //run�޼��带 ���������� �ҷ����� �ȵȴ�
			                //�ݵ�� start�޼ҵ带 �ҷ��;� �Ѵ� !!!!!!!!!!!!!!!!
			receiver.start();
			
	      }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
  //��Ƽ ������� ��� �����尡 ����Ǿ�� ���μ����� ����ȴ�
  //�̱� �������϶��� �̻��¿��� �ٷ� ���μ����� ����ȴ�. 
}
