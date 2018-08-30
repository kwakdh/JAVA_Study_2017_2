package suUp4;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class suUp0403_2 {

	public static void main(String[] args) {
		//properties :맵이긴 한테 key,value가 둘다 string값으로 특화되어 있다!!!!!
		Properties prop = new Properties();
		//맵타입이긴 하지만.... put사용 안함
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
	
		System.out.println("timeout: "+prop.getProperty("timeout"));

		prop.setProperty("timeout", "50"); //변경하고싶을때 그냥 값 다르게지정하면됨
		System.out.println("timeout: "+prop.getProperty("timeout"));
		
		System.out.println("------------------------------------------");
		
		Set set = prop.keySet(); //entryset으로 할수도 있따. 앞에서 배운것처럼......
		Iterator it = set.iterator();
		
		while(it.hasNext()){
			String name = (String)it.next();
			System.out.println(name+": "+prop.getProperty(name));
		}
		
		
		//프로퍼티 객체는 파일로 저장하는 법...... 
		// ------------------------->FileOutputStream 객체 필요
	    //예외가 발생할수 있으니 try -catch문 이용 
		try{
		
		  FileOutputStream fo = new FileOutputStream("myProp.properties");
		  FileOutputStream fxml = new FileOutputStream("myProp.xml");//웹브라우저용
		  
		  prop.store(fo,"My test Properties");
		                  //주석
		  prop.storeToXML(fxml,"MY test xml properties");
		
		}catch(Exception e){
			e.printStackTrace();

			
		}
		System.out.println("------------------------------------------");
		try{
			//properties에 저장한 경우 !!!!
        
        FileInputStream input = new FileInputStream("myProp.properties");
	    prop.load(input);
	    System.out.println("timeout: "+prop.getProperty("timeout"));
	     //바꾸고싶을때 노트패드를 이용해서 바꿔주면된당 ~_ ~
        		
			
			//xml에 저장한 경우 ~
			FileInputStream input2 = new FileInputStream("myProp.xml");
		    prop.loadFromXML(input2);
		    System.out.println("timeout: "+prop.getProperty("timeout"));	
			
		}  catch(Exception e){
		   e.printStackTrace();
	
	    //프로퍼티 파일 한글을 저장할시 문제발생!!!!!!!!!!!!
		//--------------->유니코드 값으로 저장해야한다......
		//한글로 굳이 저장하고싶을댄 xml로 저장하기!!!!!(인코딩을 udf8로 저장)
		   
	}
		Properties sysProp = System.getProperties();//얻을수있다.
		
		Set pset =sysProp.entrySet();		
		Iterator it2 =pset.iterator();
		while(it2.hasNext()){
			Entry e2 =(Entry)it2.next();
			System.out.println(e2.getKey()+e2.getValue());
		}
		
  }//end of main
   //총점 평균 최고점수 받은학생이름최저점수 받은 학생이름(이니셜로)
   //kdhong.score =100
   //chsung.score =200
   //scpark.score =100
}

