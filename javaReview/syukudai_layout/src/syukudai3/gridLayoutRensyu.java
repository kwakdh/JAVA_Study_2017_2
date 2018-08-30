package syukudai3;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/*class panel extends JPanel{
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.println("cyka"+coutn+);
	}
}
*/

class MyFrame extends JFrame{

	public MyFrame(){
		
     this.setTitle("gridLayout 예제 ");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     JPanel panel = new JPanel(); //패널 생성 
     
     panel.setLayout(new GridLayout(0,3)); //그리드 레이아웃 
     
     JButton button1 = new JButton("빨그리드");
     JButton button2 = new JButton("주그리드");
     JButton button3 = new JButton("노그리드");
     JButton button4 = new JButton("초그리드");
     JButton button5 = new JButton("파그리드");
   
     panel.add(button1);
     panel.add(button2);
     panel.add(button3);
     panel.add(button4);
     panel.add(button5);
     
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


public class gridLayoutRensyu {
	public static void main(String[] args) {
		 new MyFrame();	
	}
}
