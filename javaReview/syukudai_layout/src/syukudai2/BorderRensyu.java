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
		
     this.setTitle("BorderLayout ���� ");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     JPanel panel = new JPanel(); 
     //�г� ���� 
     
     panel.setLayout(new BorderLayout()); // borderLayout 
     
     JButton button1 = new JButton("������");
     JButton button2 = new JButton("��Ȳ");
     JButton button3 = new JButton("���");
     JButton button4 = new JButton("�ʷ�");
     JButton button5 = new JButton("�Ķ�");
   
     panel.add(button1, BorderLayout.NORTH);
     panel.add(button2, BorderLayout.WEST);
     panel.add(button3, BorderLayout.EAST);
     panel.add(button4, BorderLayout.SOUTH);
     panel.add(button5, BorderLayout.CENTER);
     
     this.pack();
     
     button1.addMouseListener(new MouseAdapter(){
			//�������̵� ! 
			public void mouseClicked(MouseEvent e){
				JOptionPane.showMessageDialog(null, "������ ��ư");
			}
		});
     button2.addMouseListener(new MouseAdapter(){
			//�������̵� ! 
			public void mouseClicked(MouseEvent e){
				JOptionPane.showMessageDialog(null, "��Ȳ�� ��ư");
			}
		});
     
     button3.addMouseListener(new MouseAdapter(){
			//�������̵� ! 
			public void mouseClicked(MouseEvent e){
				JOptionPane.showMessageDialog(null, "����� ��ư");
			}
		});
     button4.addMouseListener(new MouseAdapter(){
			//�������̵� ! 
			public void mouseClicked(MouseEvent e){
				JOptionPane.showMessageDialog(null, "�ʷϻ� ��ư");
			}
		});
     
     button5.addMouseListener(new MouseAdapter(){
			//�������̵� ! 
			public void mouseClicked(MouseEvent e){
				JOptionPane.showMessageDialog(null, "�Ķ��� ��ư");
			}
		});
     
     add(panel); //�г��� �����ӿ� �߰�

	 this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	 setVisible(true);
	
	}
}


public class BorderRensyu {
	public static void main(String[] args) {
		 new MyFrame();	
	}
}
