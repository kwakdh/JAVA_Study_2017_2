package rensyu;

import rensyu.InnerExam2.Cal;

//스위치 객체에 포트 객체가 달리는 것
/*class Switch{
	 int number=0;
   
   class Port {
	int number2 =0; 
	Port(){
		 number2=++number;
	 }
	}
	
}

public class rensyu2 {

	public static void main(String[] args) {
	
		Switch mySwitch  = new Switch();
	    Switch.Port p1 = mySwitch.new Port(); 
	    Switch.Port p2 = mySwitch.new Port();
	    Switch.Port p3 = mySwitch.new Port();
	    System.out.println(p1.number2);
	    System.out.println(p2.number2);
	    System.out.println(p3.number2);
	    
	}

}
*/
//static 붙고 안붙고 여부.. 수평관계 케이스는 어떤 케이스가 있는가?

//내부클래스 종류
//인스턴스클래스 - 외부 클래스의 멤버변수 선언위치에 선언됨
//스태틱 클래스 - 외부 클래스의 멤버변수 선언위치에 선언됨 (static멤버로 활용됨)
//지역 클래스 - 외부클래스의 메서드나 초기화 블럭안에서 선언됨
//익명 클래스 - 클래스의 선언과 객체의 생성을 동시에 하는 이름없는 클래스 (일회용)
class Switch {
    int totalPortNum = 0;
    Switch(int argPortNum) {
       Port p1[] = new Port[argPortNum];
       
       for(int iCount = 0 ; iCount < argPortNum; iCount++) {
          p1[iCount] = new Port();
       }
    }
    class Port {
       int myNum;
       Port() {
          myNum = ++totalPortNum;
          System.out.println(myNum);
       }
    }
 }

 public class rensyu2{
    public static void main(String args[]) {
       Switch mySwitch = new Switch(5);
    }   
 }

 


 