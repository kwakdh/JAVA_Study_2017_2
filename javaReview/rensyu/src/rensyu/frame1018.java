package rensyu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
// oracleȸ�� Ȩ������ 
// 1. Frame�� ���� ���� ������ش�. -> �ϳ��ϳ� �� ���� ���� �ִ�. ������ ����Ÿ. 
// -> �׷��� Frame ����� �޾Ƽ� �ٲ۴�.
// Awt(����.�ü���� �������̴�.)  / Swing(awt�� ��ӹ޾� �����) / f(x)    
// å ( PowerJAVA / ��ǰJAVA )

//�����̿������� ���Ϸ� ����.


//���콺�����ʾȿ� �޼��尡 5�� �ִٴ� ���� ������ ���� �� ���̴�.
class cyka implements  MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		JOptionPane.showConfirmDialog(null, "cyka");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}


class myFrame extends JFrame {   // �⺻������ Frame�ϳ��� ���������.
	
   myFrame() {
      this.setTitle("ckya");  //super("cyka");     // â �̸�.
      // Dimention d = this.getMaximumsize();
      // this.setSize(d);
      this.setSize(500,500);                                 // â ũ��.
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // â �ݱ� ����.
      this.setVisible(true);                                 // â ���̱�.
     
      JButton myBtn = new JButton("--������--");      
      // ��� ���۳�Ʈ�� �̺�Ʈ�� ������. -> ��ư�� Ŭ���� �� event�� ��ư���ٰ� ���̺ٿ����Ѵ�.
      // MouseListener���� �Ѱ��־���Ѵ�. -> �͸�Ŭ����
      
      //��ư�� Ŭ�� �Ǿ��� �� ���� ����Ǳ� �ٶ��ٸ� �װ��� �������̽��� �ٰ�
      //�������̽�(MouseListner)--->�ڹٰ� ����, swing�� �ҷ� �� 
      //�� �������̽��� ������ swing������ -->��ư�� Ŭ���Ǹ� 
      
      
      //�� �������̽����� ����Ҹ��� �޼��尡 ���� �� �� ���� �´�. 
      //�������̽� �����⸸ �����ϴ� 5���� �޼��带 ���״� �ʳ� Ŭ������ �ȿ� �� ����������
      //�Ѱ��ٶ��� �������̽� ������ �Ѱ��ֶ� ~ !@@
     
      
      cyka myCyka = new cyka(); //���콺 �����ʷ� ������ ��ü �� 
      myBtn.addMouseListener(myCyka);//��ī ��ü�� ���콺 �����ʶ�� �������̽� ������ ����߱⶧����
                                     //�Ѱ� �ִ� ���� �����ϴ� ! 
      
     
      myBtn.addMouseListener(new MouseListener() {
         // addMouseListener : MouseListener �̺�Ʈ�� ��ü�� ���̴� ����. 
         // MouseListener�ȿ� �ִ� �߻� �޼��帣 ��� �����ؾߴ�.
         
         
         // addMouseListener���� �Ѿ�°��� �͸�ü�� ) �Ѿ �� �ִ� ����
         // �������̽��� ���� ���� 
         // class�� ���� / �������̽� �̸� {  } / ���, �߻�޼���, Default�޼���
         // �̿ϼ��޼��� (abstract) -> �޼����� �Ӹ� �ִµ� �׾ȿ� ������ X
         // �������̽��� ��ü�� ������ �����µ� �͸�Ŭ������ �̿��� ��ü�� ������ �� �ֽ��ϴ�.
         // ���, �߻�޼���, Default
         // implement ����. 
         // 1. �͸�ü�� �ܵ����� ������ �� ����, Ŭ������ ��ӹްų� �������̽��� �����ؾ߸� �����Ҽ� �ֽ��ϴ�.
         // �������̽��� ������ ��� �׾��� ��� �޼������ �������Ѿ� �ϴµ�. ���⼭ �������������ʾƼ� Error.
         // 2. MouseListener�������̽��ȿ� �ִ� MouseClicked��� �޼��带 ����ϱ� ���ؼ�.
      });
      this.add(myBtn);      // Frame�� �ٿ����Ѵ�. 
   }
}

public class frame1018 {
   public static void main(String[] args) {
      new myFrame(); // �ϸ� �ƹ��͵� ������ �ʴ´�. ������ ���� �ʾұ� ������. -> 8�����ο��� ��������.

   }
}