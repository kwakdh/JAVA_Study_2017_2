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

	
	//�����̳ʿ� ��ġ 
	public MyFrame(){
		
     this.setTitle("FlowLayout ���� ");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â �ݱ� ����.
     
     JPanel panel = new JPanel(); //�г� ���� 
   
     setLayout(new FlowLayout(FlowLayout.CENTER, 30, 40)); // ����, ����, ����
     
     JButton button1 = new JButton("����"); //��ư ��ü ����
     JButton button2 = new JButton("��Ȳ");
     JButton button3 = new JButton("���");
     JButton button4 = new JButton("�ʷ�");
     JButton button5 = new JButton("�Ķ�");
   
     panel.add(button1);
     panel.add(button2);
     panel.add(button3);
     panel.add(button4);
     panel.add(button5);
     

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

public class FlowLayoutRensyu {
	public static void main(String[] args) {

		 new MyFrame();
		
	}

}
