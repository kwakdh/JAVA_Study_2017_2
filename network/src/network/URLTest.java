package network;

import java.io.*;
import java.net.*;

public class URLTest {
	public static void main (String[] args){
		
		try {
			URL url = new URL("http://210.101.230.2:8080/midterm/myscore");
			//URL url = new URL("www.naver.com");
			System.out.println("Protocol:" + url.getProtocol());
			System.out.println("host: "+ url.getHost());
			System.out.println("Port: "+ url.getPort());
			System.out.println("File: "+ url.getFile());
			System.out.println("Path: "+ url.getPath());
			
			try {
				//stream�� ����Ʈ �б� ! reader�� �����б� !
				InputStream is = url.openStream();
				//inputstream���� �����Ͱ� �귯 ���´� !
				InputStreamReader isr =new InputStreamReader(is);//����Ʈ ��Ʈ���� ���ڷ� �ٲ� �ִ� �� 
				//inputstreamReader�� ����ص� �Ǵµ� bufferStream�� �ص� �ȴ� 
				BufferedReader br = new BufferedReader(isr);
				//�����ؼ� �� ���ξ� �ּ��� 
				String s ="";
			
				while((s=br.readLine())!=null){
					//System.out.printf("%c",v);
					System.out.println(s);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//��Ʈ�� ����� !
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
}
