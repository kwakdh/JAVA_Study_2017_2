package awtprj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//ǥ�� : Ű����, ���콺 ----> �⺻ , ��, ���
//��ü ������ ������ ���ѷ����� ����...... �̺�Ʈ�� �޴´� ---> ���콺 �� Ű���峪..
// �̺�Ʈ �����⸦ �޾Ƶ鿩�� �װ��� �̺�Ʈ�� �߻��ϴ� ������Ʈ�� ã�´� ! 
// ���콺�� Ŭ���ϸ� �� ��� ������Ʈ�� 



//Jpanel = ������ ������ִ� �� ---> ĭ���� ! �ǳ� 1, �ǳ� 2 �� ������... 
//(������ �����̳� Ư¡�� �ϳ��� �ǳڷ� ������)
// ���̾ƿ�(���۳�Ʈ���� ��ġ !) �� �ٸ��� �� ���ִ�.
// �г��� ���� : ���̾ƿ� �Ŵ��� ��Ʈ - ��ġ ������ !!!, ������Ʈ ũ�� , ����


//������ -> ��ư ���� -> ��ư Ÿ���г� �߰� ->���̾ƿ�



//class hirerachy ���� �������� �Ͼ��... !

class myFrame extends JFrame {
	myFrame() {
		
		JButton mybtn = new JButton("������");
		mybtn.setPreferredSize(new Dimension(450, 0));

        //�������̽� ����ϸ鼭 ������ ��?!
	    // �������̽��� ����ϸ� �߻�޼������ ���δ� ��������� �ʴ��� ������ �Ǿ�� �Ѵ�.
	    //���콺 ����� ! --- �����ʿ� ������� ������ ? �̺�Ʈ�� ����� �� ���
		//--->  �߻�Ŭ������! (�⺻�� ������ �ٵǾ��ִ�!) ��üȭ ��Ű�� �ȵ�.! abstract��
		// �ʿ��� �κ�(�޼���)�� �������̵� �ϸ��! 
		// ���콺�� ���õ� �������̽� 3���� �ϳ��� Ŭ������ ���� ! ---> �׵��� �߻����� ����!
		// �� Ŭ������ ������ ����� ������.... �ʿ��� ����� ������ �װ��� �������̵�
		// ������ ��Ӱ��� ---> �������̽��� �����Ǿ����� �� , �θ� �ڽİ� ! 
		// �θ����� �޾Ƽ� ���ñ��� ������ �������̽�
		
		//�� �߻�۷����� ����� �޾Ƽ� �� ��ü�� ������ �ʿ䰡 ����. 
		mybtn.addMouseListener(new MouseAdapter(){
			//�������̵� ! 
			public void mouseClicked(MouseEvent e){
				super.mouseClicked(e);
			}
			
		});
/*		mybtn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "��ư�� ���� �����.");

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			 mybtn.setBackground(Color.pink);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				 mybtn.setBackground(Color.white);
					
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});*/

		this.add(mybtn); // add -----> ���۳�Ʈ�� ���۳�Ʈ�� ���̴� ����
		// �̺�Ʈó���ϱ����ؼ� �������̽� �� ���� �˾ƾ��Ѵ�!!
		// ���콺������, ���콺��Ǹ�����...
		// �̺�Ʈ ������ؼ�... 1>�� �������̽��� �˱� ! 2> �����ϱ� 3>�ҽ��ڵ� �ۼ�
		// 4>�� Ŭ������ ��ü ��� 5>�� ��ü�� �����.. --������Ʈ��!�����...add~ ( �������̽��� ���� !)

		this.setTitle("GUI");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		/*
		 * Dimension m = this.getMaximumSize(); this.setSize(m);
		 */
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

public class swingRensyu {

	public static void main(String[] args) {

		new myFrame();

	}

}
