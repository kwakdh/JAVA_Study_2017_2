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
		
     this.setTitle("BoxLayout ���� ");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     JPanel panel = new JPanel(); //�г� ���� 
     
     panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS)); 
     //Y�� �������� ������Ʈ �ױ�.
     
     makeButton(panel,"���� �ڽ�");
     makeButton(panel,"��Ȳ �ڽ�");
     makeButton(panel,"��� �ڽ�");
     makeButton(panel,"�ʷ� �ڽ�");
     makeButton(panel,"�Ķ� �ڽ�");
     this.pack();
    

     
     add(panel); //�г��� �����ӿ� �߰�

	 this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	 setVisible(true);
	
	}
	
    //�޼��� 
	private void makeButton(JPanel panel, String string) {
		 JButton button = new JButton(string);
    	 button.setAlignmentX(Component.CENTER_ALIGNMENT);
    	 panel.add(button);
    	 
    	 button.addMouseListener(new MouseAdapter(){
 			//�������̵� ! 
 			public void mouseClicked(MouseEvent e){
 				JOptionPane.showMessageDialog(null, string+"��ư");
 			}
 		});
	} 
}


public class boxLayoutRensyu {
	public static void main(String[] args) {
		 new MyFrame();	
	}
}
