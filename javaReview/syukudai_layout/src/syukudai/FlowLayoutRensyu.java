package syukudai;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame{

	
	//컨네이너에 설치 
	public MyFrame(){
		
     this.setTitle("FlowLayout 예제 ");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 설정.
     
     JPanel panel = new JPanel(); //패널 생성 
   
     setLayout(new FlowLayout(FlowLayout.CENTER, 30, 40)); // 정렬, 수평, 수직
     
     JButton button1 = new JButton("빨강"); //버튼 객체 생성
     JButton button2 = new JButton("주황");
     JButton button3 = new JButton("노랑");
     JButton button4 = new JButton("초록");
     JButton button5 = new JButton("파랑");
   
     panel.add(button1);
     panel.add(button2);
     panel.add(button3);
     panel.add(button4);
     panel.add(button5);
     

     button1.addMouseListener(new MouseAdapter(){
			//오버라이딩 ! 
			public void mouseClicked(MouseEvent e){
				JOptionPane.showMessageDialog(null, "빨간색 버튼");
			}
		});
     button2.addMouseListener(new MouseAdapter(){
			//오버라이딩 ! 
			public void mouseClicked(MouseEvent e){
				JOptionPane.showMessageDialog(null, "주황색 버튼");
			}
		});
     
     button3.addMouseListener(new MouseAdapter(){
			//오버라이딩 ! 
			public void mouseClicked(MouseEvent e){
				JOptionPane.showMessageDialog(null, "노란색 버튼");
			}
		});
     button4.addMouseListener(new MouseAdapter(){
			//오버라이딩 ! 
			public void mouseClicked(MouseEvent e){
				JOptionPane.showMessageDialog(null, "초록색 버튼");
			}
		});
     
     button5.addMouseListener(new MouseAdapter(){
			//오버라이딩 ! 
			public void mouseClicked(MouseEvent e){
				JOptionPane.showMessageDialog(null, "파란색 버튼");
			}
		});
     
     add(panel); //패널을 프레임에 추가

	 this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	 setVisible(true);
	
	}
}

public class FlowLayoutRensyu {
	public static void main(String[] args) {

		 new MyFrame();
		
	}

}
