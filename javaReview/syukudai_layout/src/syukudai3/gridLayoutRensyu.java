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
		
     this.setTitle("gridLayout ���� ");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     JPanel panel = new JPanel(); //�г� ���� 
     
     panel.setLayout(new GridLayout(0,3)); //�׸��� ���̾ƿ� 
     
     JButton button1 = new JButton("���׸���");
     JButton button2 = new JButton("�ֱ׸���");
     JButton button3 = new JButton("��׸���");
     JButton button4 = new JButton("�ʱ׸���");
     JButton button5 = new JButton("�ı׸���");
   
     panel.add(button1);
     panel.add(button2);
     panel.add(button3);
     panel.add(button4);
     panel.add(button5);
     
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


public class gridLayoutRensyu {
	public static void main(String[] args) {
		 new MyFrame();	
	}
}
