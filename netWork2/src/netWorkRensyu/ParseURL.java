package netWorkRensyu;

import java.io.*;
import java.net.*;

public class ParseURL {

	public static void main(String[] args) {
	
	try {
		URL aURL = new URL("http://www.snee.com/xml/crud/posttest.cgi");
	    URLConnection uc = aURL.openConnection();
	    uc.setDoOutput(true);
	    OutputStreamWriter out = 
	    		new OutputStreamWriter(uc.getOutputStream());	    
	    out.write("fname = gggg");
	    out.close();
	    BufferedReader in = 
	    new BufferedReader(
	    new InputStreamReader(uc.getInputStream()));
	    String inputLine;
	    while((inputLine = in.readLine())!=null)
	     System.out.println(inputLine);
	    in.close();
	    
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	}
}
