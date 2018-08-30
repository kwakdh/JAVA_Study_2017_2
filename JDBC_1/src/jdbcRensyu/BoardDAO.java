package jdbcRensyu;

import java.io.*;
import java.sql.*;
import java.util.*;

public class BoardDAO {

	private static BoardDAO dao = null;
	private String url = "jdbc:mysql://localhost:3306/java";
	private String driverClassName ="com.mysql.jdbc.Driver";
	private String userName ="s1601012";
	private String password ="p1601012";
	
	private Properties prop = new Properties();
	public final static String DATABASE_PROPERTIES="database.properties";
    
	private Connection con = null;
	
	private BoardDAO(){
		FileInputStream inStream = null;
	
	    try {
			inStream = new FileInputStream(DATABASE_PROPERTIES);
		    prop.load(arg0);
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
