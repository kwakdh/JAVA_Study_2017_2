package syukudai2;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MyFrame extends JFrame{

	public MyFrame(){
		
     this.setTitle("BorderLayout 예제 ");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     JPanel panel = new JPanel(); 
     //패널 생성 
     
     panel.setLayout(new BorderLayout()); // borderLayout 
     
     JButton button1 = new JButton("빨간맛");
     JButton button2 = new JButton("주황");
     JButton button3 = new JButton("노랑");
     JButton button4 = new JButton("초록");
     JButton button5 = new JButton("파랑");
   
     panel.add(button1, BorderLayout.NORTH);
     panel.add(button2, BorderLayout.WEST);
     panel.add(button3, BorderLayout.EAST);
     panel.add(button4, BorderLayout.SOUTH);
     panel.add(button5, BorderLayout.CENTER);
     
     this.pack();
     
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


public class BorderRensyu {
	public static void main(String[] args) {
		 new MyFrame();	
	}
}
