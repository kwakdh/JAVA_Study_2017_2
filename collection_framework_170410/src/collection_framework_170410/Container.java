package suUp4_2;

import java.util.List;


//<T extends Student> ���� �Ҽ��ֵ� 
public class Container<T> {
  private List<T> list ;
  
  
  /*
  //static�� ��ü���� ���� ��������°Ŷ� ����ϸ�ȵȴ�~
  private static T item;*/
/*  //new �� Ÿ��t�� ���̾��� �ȵȴ�
     
  T[]itemArr;
  itemArr = new T[];*/
  
  /*instanceof�� Ÿ�� t�� �Բ� ����Ҽ� ���� */
  
  public void setList(List<T> list){
	  this.list=list;
  }
  
  public String toString(){
	  return list.toString();
  }
  //���׸� Ŭ���� �ȿ� ���׸� �޼��� ���� �� �ִ� .
  //������ ���׸� �޼���� k��� �����ص� �ȴ� .
  public <K> void sayHello(K v){
	  System.out.println("Hello"+v);
  }
  
}
