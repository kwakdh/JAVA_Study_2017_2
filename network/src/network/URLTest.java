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
				//stream은 바이트 읽기 ! reader은 문자읽기 !
				InputStream is = url.openStream();
				//inputstream으로 데이터가 흘러 들어온다 !
				InputStreamReader isr =new InputStreamReader(is);//바이트 스트림을 문자로 바꿔 주는 것 
				//inputstreamReader도 출력해도 되는데 bufferStream을 해도 된다 
				BufferedReader br = new BufferedReader(isr);
				//버퍼해서 한 라인씩 주세여 
				String s ="";
			
				while((s=br.readLine())!=null){
					//System.out.printf("%c",v);
					System.out.println(s);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//스트림 열어라 !
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
}
