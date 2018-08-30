package review3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

// layout management : ��ġ�����ڴ� �ǳڿ��� ������Ʈ�� ��ġ�ϱ� ���ؼ� !!!!!!!!!!!!
// ���̾ƿ� �Ŵ��� ��Ʈ�� ������ ����� �ǳ��ε� �ǳڿ� ���� setLayout�̶�� �޼��尡�ִ�.
// ����Ʈ ���� border , flow�� 1���� �帣�°� ! 
// setLayout �޼��� �������� ��ġ���� �� �ٲ� ���ִ�. ����Ϸ��� ���̾ƿ� ���� ��ü ������ !

// ���� ���� ���̴� : borderLayout �� , gridLayout ---> �׸��ǿ��� ������ �� �°� ��ư ����� ������  
// gridLayout : ���� ���� �������ش� . 
// boxLayout : �ױ� 
// 


class myFrame extends JFrame {
	myFrame() {
		
		JButton mybtn1 = new JButton("������");
		mybtn1.setPreferredSize(new Dimension(450, 0));

		mybtn1.addMouseListener(new MouseAdapter(){
			//�������̵� ! 
			public void mouseClicked(MouseEvent e){
				super.mouseClicked(e);
			}
		});
		
		JButton mybtn2 = new JButton("������");
		mybtn2.setPreferredSize(new Dimension(450, 0));

		mybtn2.addMouseListener(new MouseAdapter(){
			//�������̵� ! 
			public void mouseClicked(MouseEvent e){
				super.mouseClicked(e);
			}
		});
		
		JButton mybtn3 = new JButton("������");
		mybtn3.setPreferredSize(new Dimension(450, 0));

		mybtn3.addMouseListener(new MouseAdapter(){
			//�������̵� ! 
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
