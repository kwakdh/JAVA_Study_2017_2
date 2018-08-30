package review3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

// layout management : 배치관리자는 판넬에서 컴포넌트를 배치하기 위해서 !!!!!!!!!!!!
// 레이아웃 매니지 먼트를 적용할 대상이 판넬인데 판넬에 가서 setLayout이라는 메서드가있다.
// 디폴트 값은 border , flow는 1열로 흐르는거 ! 
// setLayout 메서드 가져오면 배치관리 를 바꿀 수있다. 사용하려는 레이아웃 관련 객체 가져옴 !

// 제일 많이 쓰이는 : borderLayout 랑 , gridLayout ---> 그림판에서 사이즈 딱 맞게 버튼 만들고 싶을때  
// gridLayout : 열과 행을 지정해준다 . 
// boxLayout : 쌓기 
// 


class myFrame extends JFrame {
	myFrame() {
		
		JButton mybtn1 = new JButton("눌러라");
		mybtn1.setPreferredSize(new Dimension(450, 0));

		mybtn1.addMouseListener(new MouseAdapter(){
			//오버라이딩 ! 
			public void mouseClicked(MouseEvent e){
				super.mouseClicked(e);
			}
		});
		
		JButton mybtn2 = new JButton("눌러라");
		mybtn2.setPreferredSize(new Dimension(450, 0));

		mybtn2.addMouseListener(new MouseAdapter(){
			//오버라이딩 ! 
			public void mouseClicked(MouseEvent e){
				super.mouseClicked(e);
			}
		});
		
		JButton mybtn3 = new JButton("눌러라");
		mybtn3.setPreferredSize(new Dimension(450, 0));

		mybtn3.addMouseListener(new MouseAdapter(){
			//오버라이딩 ! 
			public void mouseClicked(MouseEvent e){
				super.mouseClicked(e);
			}
		});
		
        this.getContentPane().setLayout(new FlowLayout());
		this.add(mybtn1);
		this.add(mybtn2);
		this.add(mybtn3);
		this.setTitle("GUI");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

public class swingRensyu {

	public static void main(String[] args) {

		new myFrame();

	}

}
