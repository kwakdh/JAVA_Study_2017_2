package network;

import java.io.*;
import java.net.*;

public class URLConectionTest {
   public static void main(String[] args){
	   try {
		URL url = new URL("http://210.101.230.2:8080/midterm/myscore");
		try {
			URLConnection uc = url.openConnection();
			InputStream is = uc.getInputStream();
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir); //한꺼번에 가져오기 
			//버퍼가져와서 라인단위로 출력 가능 
			String s = "";
			while((s=br.readLine())!=null){
				System.out.println(s);
			}
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   
	   
	   
   }
}
