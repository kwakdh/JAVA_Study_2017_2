package rensyu;

class Person{
	public void greeting(){
		System.out.println("hello");
	}
	
}

interface Utility{
	public void showInfo();
}


public class rensyu3 {
   public static void main(String[] args){
	 
	 //Person rim = new Person();
	 //rim.greeting();
	 
	   //Person클래스의 자식 객체화 된것이 rim인데 overriding이 됨....
	   //greeting이 오버라이딩이 됨... (오버라이딩은 자식클래스에서만!)
	   //Person의 자식 클래스가 안보인다....
	   Person rim = new Person(){
		   public void greeting(){
			   System.out.println("my name sangsock");
		   }
		   
	   };
	   
	   rim.greeting();
	   
	   //인터페이스를 객체화 시키고싶은데.. 이건 불가능 합니다
	   //익명클래스를 만들어서 ----> 인터페이스 적용하기 
	   
	   Utility util = new Utility(){
		 public void showInfo(){
			 System.out.println("showing info...");
		 }
		   
	   };
	   
	   util.showInfo();
	   
	   
     }
}
