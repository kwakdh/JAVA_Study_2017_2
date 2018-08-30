package rensyu;

    //�������̽� ���� : �츮�� ���� ��ü���� �ٸ������ ���� �������̽� ��ü�� �ҷ��´ٴ� �� ! 
    //              ���� ���� ��ü�� �ٸ������ ���� ��ü�� ���������� ���� �� �� (�������̽� ������ ����ȯ ��Ŵ)
    // �������̽��� ������ ������� �ڱ⸸�� Ŭ������ ����� �������̽� �ȿ��ִ� �߻�޼��带 �ҷ��� ����. 
    //-----------> �ٸ������ ���� Ŭ������ �Ű� ���� �ʴ´�. 

    //�������̽��� ����ȸ�翡�� ����� ���� �ƴ϶� ������ �������̽��� ������ ȸ�翡�� ����� �ִ� ���̴�. 
    
    //�ý��� ���ȭ�� ��! �ٸ� ����� ���� �������̽��� �ҷ��ͼ� ����� �� �ֱ⶧���� ���� �ð��� ���� �ȴ�.
    //� Ŭ������ ����� �� ���� �𸥴�.. ������ �� �Ѹ��� â�� �������̽��� 
    //a,b,c,d -->�������� ���α׷��ֿ��� ... �������̽� �ȿ��ִ� �޼���ȿ� ������ �θ��� �����ϴ�. 
    //���� : �������� ���α׷���, ������� Ŭ������ �ϳ��� ���� ���� �����ϴ�, ǥ��ȭ (����ȭ)-->��������
    
    interface Engine{
	   abstract void start();
	}
    

	class car {
	      Engine myEngine;
	      
	      car(Engine e) {
	         myEngine = e;
	      }
	      
	      void start() { myEngine.start();}
	}

	class benzEngine implements Engine{
	     public void start() { System.out.println("����,�θ��θ�"); }
	}

	class audiEngine implements Engine{
	     public void start() { System.out.println("�ƿ��,�θ��θ�"); }
	}

	public class carInterface {
	   public static void main(String args[]) {
	      benzEngine obj1Engine = new benzEngine();
	      car obj1 = new car(obj1Engine);
	         
	      obj1.start();
	      
	      audiEngine obj2Engine = new audiEngine();
	      car obj2 = new car(obj2Engine);
	      
	      obj2.start();
	   }
	}