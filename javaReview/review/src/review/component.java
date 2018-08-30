package review;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame{

	public MyFrame(){
		
     this.setTitle("그림판 좀 되라 이제 ");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     JPanel panel = new JPanel(); //컨테이너로 패널 생성 ----> 라벨과 버튼 구역
     JPanel panel2 = new JPanel(); //텍스트 필드 패널 생성

     JTextField t1 = new JTextField(10); //텍스트 필드 두개 생성해서 패널에 추가하기.
     JTextField t2 = new JTextField(10);
     t2.setEditable(false); // 두 번째 텍스트 필드는 입력금지로 설정
     
     
     setLayout(new FlowLayout(FlowLayout.CENTER, 30, 40)); // 정렬, 수평, 수직
     
     JLabel label = new JLabel("색깔 놀이");
    /* JButton button1 = new JButton("빨강");
     JButton button2 = new JButton("주황");
     JButton button3 = new JButton("노랑");
     JButton button4 = new JButton("파랑");
     
     button4.setEnabled(false); //버튼을 불확성으로 설정
     
     panel.add(label);  //패널에 레이블과 버튼 추가
     panel.add(button1);
     panel.add(button2);
     panel.add(button3);
     panel.add(button4);
     */
     
     panel2.add(t1); //텍스트 필드를 패널에 추가
     panel2.add(t2);
     
     add(panel); //패널을 프레임에 추가
	 add(panel2); 
	 this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	 setVisible(true);
	}
	
	
}
public class component {

	public static void main(String[] args) {

		 new MyFrame();
		
	}

}
