package syukudai4;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MyFrame extends JFrame{

	public MyFrame(){
		
     this.setTitle("BoxLayout 예제 ");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     JPanel panel = new JPanel(); //패널 생성 
     
     panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS)); 
     //Y축 방향으로 컴포넌트 쌓기.
     
     makeButton(panel,"빨간 박스");
     makeButton(panel,"주황 박스");
     makeButton(panel,"노랑 박스");
     makeButton(panel,"초록 박스");
     makeButton(panel,"파랑 박스");
     this.pack();
    

     
     add(panel); //패널을 프레임에 추가

	 this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	 setVisible(true);
	
	}
	
    //메서드 
	private void makeButton(JPanel panel, String string) {
		 JButton button = new JButton(string);
    	 button.setAlignmentX(Component.CENTER_ALIGNMENT);
    	 panel.add(button);
    	 
    	 button.addMouseListener(new MouseAdapter(){
 			//오버라이딩 ! 
 			public void mouseClicked(MouseEvent e){
 				JOptionPane.showMessageDialog(null, string+"버튼");
 			}
 		});
	} 
}


public class boxLayoutRensyu {
	public static void main(String[] args) {
		 new MyFrame();	
	}
}
