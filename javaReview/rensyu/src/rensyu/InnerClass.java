package rensyu;

//인스턴스 클래스 ---------------------------------------------------------
/*public class InnerClass {
   class Cal{
	   int value =0;
	   public void plus(){
		   value++;
	   }
   }
	
	public static void main(String[] args) {
     InnerClass c = new InnerClass();
     InnerClass.Cal cal = c.new Cal();
     cal.plus();
     System.out.println(cal.value);		
	}

}*/


//스태틱 클래스 ----------------------------------------------------------

/*public class InnerClass{
    static class Cal{
     int value = 0;
     public void plus(){
    	 value++;
     }
    }
    
	public static void main(String[] args){
		//innerClass를 꼭 생성 하지 않고 바로 접근해서 사용 가능하다
		InnerClass.Cal cal = new InnerClass.Cal();
		cal.plus();
		System.out.println(cal.value);
		
	}
}*/

//지역 클래스 ------------------------------------------------------------
//------------>메서드 내부에서 선언되는 경우

public class InnerClass{
	
	public void exec(){
		class Cal{
			int value =0;
			public void plus(){
				value++;
			}
		}
		
		//객체를 생성하는 부분은 메서드 내부에서 가능하다 !
		Cal cal = new Cal();
		cal.plus();
		System.out.println(cal.value);
	}
	
	
	public static void main(String[] args){
		InnerClass t = new InnerClass();
		t.exec();
		
	}
	
	
}







