package rensyu;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Anonymous2 extends Frame { 
	//frame 클래스 에 (String으로 정의를 하면 타이틀로 간다고 적혀있음)
	
	int x = 0;
	int y = 0;
	
	public static void main(String args[]){
		new Anonymous2("그림판!");
		//여기 안에 for( ; ;) 있다.. --> 무한 반복됨
		//event-driven-programing : 프로그램은 안죽어..(이벤트를 함으로써 움직일 수있기때문에..)
		//---------------------->GUI에 사용되는 것 이다.
		//jfc가 만들어준다. 
        //무한 반복 되면서 이벤트 입력은 받는다. 이벤트 = 사건  입력(마우스, 키보드, 마이크)
		//이벤트 또한 객체로 나타나게 된다...
	}
	
	public Anonymous2(String argTitle){ //생성자
		super(argTitle); //상위 frame클래스 생성자 호출하기 !!!!타이틀 적기 
	    
		
		// MouseMotionListener 인터페이스  
		// 마우스 리스너 이벤트 처리자 	
		addMouseMotionListener(new MouseMotionListener(){
	
		public void mouseDragged(MouseEvent e){}  //--> 마우스가 드래그 중인 상태 
		public void mouseMoved(MouseEvent e){   // ---> 마우스가 이동 중인 상태 
			
			//  e.getX 와 e.getY의 메서드를 이용해 현재 마우스의 x,y좌표를 가져오기 
			x = e.getX(); 
			y = e.getY();
	
			repaint(); //강제로 paint()메소드를 한번더 호출하고 싶을 때 
		
		}		
			
		});
		
		setBounds(100,100,800,700); //x, y, width, height 위치와 크기 설정
		setVisible(true); // 윈도우 보일지 말지 설정 
		
		
	}
	
	//graphics개체는 그래픽 이미지를 만드는에 사용된다. 
	
	
	
	//paint메소드는 필요에 의해서 자동으로 호출된다.
	//하지만 화면이 가려지지 않더라도 화면을 갱신해야 할 경우가 생기는데 그때는 repaint메소드를 호출하면됨.
	//repaint메소드가 호=-0출되면 빠르게 update메소드가 호출되고 update메소드는 컴포넌트를 원래의 모습대로 
	//그린후에 paint를 호출한다. 
	//----> repaint() -> update() -> paint()
	
	public void paint(Graphics g){
		g.drawString("*", x, y); //문자열을 그린다 
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	
}