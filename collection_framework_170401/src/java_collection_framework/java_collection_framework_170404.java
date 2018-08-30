package suUp4;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class suUp0403_2 {

	public static void main(String[] args) {
		//properties :���̱� ���� key,value�� �Ѵ� string������ Ưȭ�Ǿ� �ִ�!!!!!
		Properties prop = new Properties();
		//��Ÿ���̱� ������.... put��� ����
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
	
		System.out.println("timeout: "+prop.getProperty("timeout"));

		prop.setProperty("timeout", "50"); //�����ϰ������ �׳� �� �ٸ��������ϸ��
		System.out.println("timeout: "+prop.getProperty("timeout"));
		
		System.out.println("------------------------------------------");
		
		Set set = prop.keySet(); //entryset���� �Ҽ��� �ֵ�. �տ��� ����ó��......
		Iterator it = set.iterator();
		
		while(it.hasNext()){
			String name = (String)it.next();
			System.out.println(name+": "+prop.getProperty(name));
		}
		
		
		//������Ƽ ��ü�� ���Ϸ� �����ϴ� ��...... 
		// ------------------------->FileOutputStream ��ü �ʿ�
	    //���ܰ� �߻��Ҽ� ������ try -catch�� �̿� 
		try{
		
		  FileOutputStream fo = new FileOutputStream("myProp.properties");
		  FileOutputStream fxml = new FileOutputStream("myProp.xml");//����������
		  
		  prop.store(fo,"My test Properties");
		                  //�ּ�
		  prop.storeToXML(fxml,"MY test xml properties");
		
		}catch(Exception e){
			e.printStackTrace();

			
		}
		System.out.println("------------------------------------------");
		try{
			//properties�� ������ ��� !!!!
        
        FileInputStream input = new FileInputStream("myProp.properties");
	    prop.load(input);
	    System.out.println("timeout: "+prop.getProperty("timeout"));
	     //�ٲٰ������ ��Ʈ�е带 �̿��ؼ� �ٲ��ָ�ȴ� ~_ ~
        		
			
			//xml�� ������ ��� ~
			FileInputStream input2 = new FileInputStream("myProp.xml");
		    prop.loadFromXML(input2);
		    System.out.println("timeout: "+prop.getProperty("timeout"));	
			
		}  catch(Exception e){
		   e.printStackTrace();
	
	    //������Ƽ ���� �ѱ��� �����ҽ� �����߻�!!!!!!!!!!!!
		//--------------->�����ڵ� ������ �����ؾ��Ѵ�......
		//�ѱ۷� ���� �����ϰ������ xml�� �����ϱ�!!!!!(���ڵ��� udf8�� ����)
		   
	}
		Properties sysProp = System.getProperties();//�������ִ�.
		
		Set pset =sysProp.entrySet();		
		Iterator it2 =pset.iterator();
		while(it2.hasNext()){
			Entry e2 =(Entry)it2.next();
			System.out.println(e2.getKey()+e2.getValue());
		}
		
  }//end of main
   //���� ��� �ְ����� �����л��̸��������� ���� �л��̸�(�̴ϼȷ�)
   //kdhong.score =100
   //chsung.score =200
   //scpark.score =100
}

