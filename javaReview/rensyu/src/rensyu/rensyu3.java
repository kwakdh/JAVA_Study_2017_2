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
	 
	   //PersonŬ������ �ڽ� ��üȭ �Ȱ��� rim�ε� overriding�� ��....
	   //greeting�� �������̵��� ��... (�������̵��� �ڽ�Ŭ����������!)
	   //Person�� �ڽ� Ŭ������ �Ⱥ��δ�....
	   Person rim = new Person(){
		   public void greeting(){
			   System.out.println("my name sangsock");
		   }
		   
	   };
	   
	   rim.greeting();
	   
	   //�������̽��� ��üȭ ��Ű�������.. �̰� �Ұ��� �մϴ�
	   //�͸�Ŭ������ ���� ----> �������̽� �����ϱ� 
	   
	   Utility util = new Utility(){
		 public void showInfo(){
			 System.out.println("showing info...");
		 }
		   
	   };
	   
	   util.showInfo();
	   
	   
     }
}
