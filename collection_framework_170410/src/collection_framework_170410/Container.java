package suUp4_2;

import java.util.List;


//<T extends Student> 제한 할수있따 
public class Container<T> {
  private List<T> list ;
  
  
  /*
  //static은 객체생성 전에 만들어지는거라서 사용하면안된다~
  private static T item;*/
/*  //new 와 타입t를 같이쓰면 안된다
     
  T[]itemArr;
  itemArr = new T[];*/
  
  /*instanceof랑 타입 t와 함께 사용할수 없다 */
  
  public void setList(List<T> list){
	  this.list=list;
  }
  
  public String toString(){
	  return list.toString();
  }
  //지네릭 클래스 안에 지네릭 메서드 넣을 수 있다 .
  //독자적 지네릭 메서드라서 k라고 지정해도 된다 .
  public <K> void sayHello(K v){
	  System.out.println("Hello"+v);
  }
  
}
