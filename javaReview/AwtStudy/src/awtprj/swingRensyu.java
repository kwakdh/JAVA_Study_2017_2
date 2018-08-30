package awtprj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//표준 : 키보드, 마우스 ----> 기본 , 휠, 모션
//객체 찍으면 포문을 무한루프로 돈다...... 이벤트를 받는다 ---> 마우스 나 키보드나..
// 이벤트 수집기를 받아들여서 그것을 이벤트가 발생하는 컴포넌트를 찾는다 ! 
// 마우스를 클릭하면 그 대상 컴포넌트가 



//Jpanel = 공간을 만들어주는 판 ---> 칸막이 ! 판넬 1, 판넬 2 로 나눠서... 
//(동일한 성격이나 특징을 하나의 판넬로 묶어줌)
// 레이아웃(컴퍼넌트들의 배치 !) 도 다르게 할 수있다.
// 패널의 역할 : 레이아웃 매니지 먼트 - 배치 관리자 !!!, 컴포넌트 크기 , 색깔


//프레임 -> 버튼 생성 -> 버튼 타겟패널 추가 ->레이아웃



//class hirerachy 에서 다형성이 일어난다... !

class myFrame extends JFrame {
	myFrame() {
		
		JButton mybtn = new JButton("눌러라");
		mybtn.setPreferredSize(new Dimension(450, 0));

        //인터페이스 사용하면서 불편한 점?!
	    // 인터페이스를 사용하면 추상메서드들을 전부다 사용하지는 않더라도 구현은 되어야 한다.
	    //마우스 어댑터 ! --- 리스너와 어댑터의 공통점 ? 이벤트를 등록할 때 사용
		//--->  추상클래스다! (기본적 구현은 다되어있다!) 객체화 시키면 안됨.! abstract라서
		// 필요한 부분(메서드)은 오버라이딩 하면됨! 
		// 마우스에 관련된 인터페이스 3개를 하나의 클래스로 만들어서 ! ---> 그들을 추상으로 묶음!
		// 이 클래스를 가지고 상속을 받으면.... 필요한 기능이 있으면 그것을 오버라이딩
		// 다형성 상속관계 ---> 인터페이스에 구현되어있을 때 , 부모 자식간 ! 
		// 부모형을 받아서 가시권은 리스너 인터페이스
		
		//이 추상글래스가 상속을 받아서 이 객체를 생성할 필요가 없다. 
		mybtn.addMouseListener(new MouseAdapter(){
			//오버라이딩 ! 
			public void mouseClicked(MouseEvent e){
				super.mouseClicked(e);
			}
			
		});
/*		mybtn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "버튼이 눌러 졌어요.");

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			 mybtn.setBackground(Color.pink);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				 mybtn.setBackground(Color.white);
					
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});*/

		this.add(mybtn); // add -----> 컨퍼넌트와 컨퍼넌트를 붙이는 역할
		// 이벤트처리하기위해서 인터페이스 가 뭔지 알아야한다!!
		// 마우스리스너, 마우스모션리스너...
		// 이벤트 등록위해서... 1>이 인터페이스를 알기 ! 2> 구현하기 3>소스코드 작성
		// 4>이 클래스의 객체 찍기 5>그 객체를 끼우기.. --컴포넌트에!끼우기...add~ ( 인터페이스형 으로 !)

		this.setTitle("GUI");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		/*
		 * Dimension m = this.getMaximumSize(); this.setSize(m);
		 */
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

public class swingRensyu {

	public static void main(String[] args) {

		new myFrame();

	}

}
