package rensyu;

    //인터페이스 정의 : 우리가 만든 객체에서 다른사람이 만든 인터페이스 객체를 불러온다는 뜻 ! 
    //              내가 만든 객체와 다른사람이 만든 객체를 유기적으로 결합 할 때 (인터페이스 형으로 형변환 시킴)
    // 인터페이스를 가져온 사람들은 자기만의 클래스를 만들고 인터페이스 안에있는 추상메서드를 불러와 쓴다. 
    //-----------> 다른사람이 만든 클래스는 신경 쓰지 않는다. 

    //인터페이스는 엔진회사에서 만드는 것이 아니라 엔진을 인터페이스로 장착할 회사에서 만들어 주는 것이다. 
    
    //시스템 모듈화된 것! 다른 사람이 만든 인터페이스를 불러와서 사용할 수 있기때문에 개발 시간이 단축 된다.
    //어떤 클래스를 만드는 지 나는 모른다.. 하지만 그 둘만의 창고가 인터페이스고 
    //a,b,c,d -->독립적인 프로그래밍에서 ... 인터페이스 안에있는 메서드안에 내용을 부르면 가능하다. 
    //장점 : 독립적인 프로그래밍, 관계없는 클래스를 하나로 묶는 것이 가능하다, 표준화 (정형화)-->유지보수
    
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
	     public void start() { System.out.println("벤츠,부릉부릉"); }
	}

	class audiEngine implements Engine{
	     public void start() { System.out.println("아우디,부릉부릉"); }
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