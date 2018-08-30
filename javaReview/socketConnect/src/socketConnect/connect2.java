package socketConnect;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class connect2 {

	public static void main(String[] args) {
		Socket clientSocket = null;
	      
	      try {
	         clientSocket = new Socket("localhost", 5556);
	      } catch (IOException e) {
	         System.out.println("立加角菩");
	      }
	      
	      try {
	         OutputStream os = clientSocket.getOutputStream();
	         DataOutputStream dos = new DataOutputStream(os);
	         dos.writeUTF("cyka");
	         
	         clientSocket.close();
	         
	      } catch (IOException e) {
	         System.out.println("立加角菩");
	      }
	}

}
