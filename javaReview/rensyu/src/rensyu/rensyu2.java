package rensyu;

import rensyu.InnerExam2.Cal;

//����ġ ��ü�� ��Ʈ ��ü�� �޸��� ��
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
//static �ٰ� �Ⱥٰ� ����.. ������� ���̽��� � ���̽��� �ִ°�?

//����Ŭ���� ����
//�ν��Ͻ�Ŭ���� - �ܺ� Ŭ������ ������� ������ġ�� �����
//����ƽ Ŭ���� - �ܺ� Ŭ������ ������� ������ġ�� ����� (static����� Ȱ���)
//���� Ŭ���� - �ܺ�Ŭ������ �޼��峪 �ʱ�ȭ �����ȿ��� �����
//�͸� Ŭ���� - Ŭ������ ����� ��ü�� ������ ���ÿ� �ϴ� �̸����� Ŭ���� (��ȸ��)
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

 


 