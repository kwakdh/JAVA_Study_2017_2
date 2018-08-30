package network;
import java.io.*;
import java.net.*;

public class URLConnectionTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			URL url = new URL("http://210.101.230.2:8080/midterm/myscore");
			try {
				URLConnection uc = url.openConnection();
				//URL CONNECITON �� ���� input�� �Ǿ��ִµ� output�� �ȿ��� �Ǿ��ֵ�
				//������............
				uc.setDoOutput(true);
				
				OutputStream os = uc.getOutputStream();
				//url������ ��û �ȵ����� url connecetion �� ��û�� ����!
				//input�� read output�� write
				OutputStreamWriter ow = new OutputStreamWriter(os);
				//���ڴ����� ���°� OutputStreamWriter
				ow.write("sid=1234567&passwd=19950505");
				ow.close();
				
				InputStream is = uc.getInputStream();
				InputStreamReader ir = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(ir);				

                String s ="";
                File file = new File("myscore.html");
                System.out.println(file.getAbsolutePath());
                FileWriter fw = new FileWriter(file);
                
                while((s=br.readLine())!=null){
                	System.out.println(s);
                	fw.write(s);
                }
                br.close();
                fw.close();
                
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
