package thread;

//thread하려면 thread를 상속 받아야 한다 
public class ThreadEx01 extends Thread{
	
    String name;
    /*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadEx01 t1 = new ThreadEx01();
		t1.name="홍길동";
		
		ThreadEx01 t2 = new ThreadEx01();
		t2.name="일지매";
		
		//t1.run(); //run부를때 새로운  thread 가 생성된다. 
		t1.start(); //start를 부르지않으면 
		            //새로운 스레드가 생성되지 않는다 !!!! 
		            //run메서드 구현해줘야하고 호출은 start로!
		t2.start();
		System.out.println("메인 종료 합니다 ~!!!!!!!!!!!!!");
		//single thread는 메인thread가
		//종료되면 프로세스가 종료된다. 
		//메인thread가 종료되도 다른 스레드가 남이있으면
		//프로세스가 종료되지 않는다 
		
	}*/
	
    @Override
	public void run(){
		for (int i =0 ; i < 500;i++){
			System.out.println(name);
		}
	}

}
