package thread;

//thread�Ϸ��� thread�� ��� �޾ƾ� �Ѵ� 
public class ThreadEx01 extends Thread{
	
    String name;
    /*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadEx01 t1 = new ThreadEx01();
		t1.name="ȫ�浿";
		
		ThreadEx01 t2 = new ThreadEx01();
		t2.name="������";
		
		//t1.run(); //run�θ��� ���ο�  thread �� �����ȴ�. 
		t1.start(); //start�� �θ��������� 
		            //���ο� �����尡 �������� �ʴ´� !!!! 
		            //run�޼��� ����������ϰ� ȣ���� start��!
		t2.start();
		System.out.println("���� ���� �մϴ� ~!!!!!!!!!!!!!");
		//single thread�� ����thread��
		//����Ǹ� ���μ����� ����ȴ�. 
		//����thread�� ����ǵ� �ٸ� �����尡 ����������
		//���μ����� ������� �ʴ´� 
		
	}*/
	
    @Override
	public void run(){
		for (int i =0 ; i < 500;i++){
			System.out.println(name);
		}
	}

}
