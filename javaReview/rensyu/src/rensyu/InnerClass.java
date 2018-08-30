package rensyu;

//�ν��Ͻ� Ŭ���� ---------------------------------------------------------
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


//����ƽ Ŭ���� ----------------------------------------------------------

/*public class InnerClass{
    static class Cal{
     int value = 0;
     public void plus(){
    	 value++;
     }
    }
    
	public static void main(String[] args){
		//innerClass�� �� ���� ���� �ʰ� �ٷ� �����ؼ� ��� �����ϴ�
		InnerClass.Cal cal = new InnerClass.Cal();
		cal.plus();
		System.out.println(cal.value);
		
	}
}*/

//���� Ŭ���� ------------------------------------------------------------
//------------>�޼��� ���ο��� ����Ǵ� ���

public class InnerClass{
	
	public void exec(){
		class Cal{
			int value =0;
			public void plus(){
				value++;
			}
		}
		
		//��ü�� �����ϴ� �κ��� �޼��� ���ο��� �����ϴ� !
		Cal cal = new Cal();
		cal.plus();
		System.out.println(cal.value);
	}
	
	
	public static void main(String[] args){
		InnerClass t = new InnerClass();
		t.exec();
		
	}
	
	
}







