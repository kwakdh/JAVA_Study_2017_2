package rensyu;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Anonymous2 extends Frame { 
	//frame Ŭ���� �� (String���� ���Ǹ� �ϸ� Ÿ��Ʋ�� ���ٰ� ��������)
	
	int x = 0;
	int y = 0;
	
	public static void main(String args[]){
		new Anonymous2("�׸���!");
		//���� �ȿ� for( ; ;) �ִ�.. --> ���� �ݺ���
		//event-driven-programing : ���α׷��� ���׾�..(�̺�Ʈ�� �����ν� ������ ���ֱ⶧����..)
		//---------------------->GUI�� ���Ǵ� �� �̴�.
		//jfc�� ������ش�. 
        //���� �ݺ� �Ǹ鼭 �̺�Ʈ �Է��� �޴´�. �̺�Ʈ = ���  �Է�(���콺, Ű����, ����ũ)
		//�̺�Ʈ ���� ��ü�� ��Ÿ���� �ȴ�...
	}
	
	public Anonymous2(String argTitle){ //������
		super(argTitle); //���� frameŬ���� ������ ȣ���ϱ� !!!!Ÿ��Ʋ ���� 
	    
		
		// MouseMotionListener �������̽�  
		// ���콺 ������ �̺�Ʈ ó���� 	
		addMouseMotionListener(new MouseMotionListener(){
	
		public void mouseDragged(MouseEvent e){}  //--> ���콺�� �巡�� ���� ���� 
		public void mouseMoved(MouseEvent e){   // ---> ���콺�� �̵� ���� ���� 
			
			//  e.getX �� e.getY�� �޼��带 �̿��� ���� ���콺�� x,y��ǥ�� �������� 
			x = e.getX(); 
			y = e.getY();
	
			repaint(); //������ paint()�޼ҵ带 �ѹ��� ȣ���ϰ� ���� �� 
		
		}		
			
		});
		
		setBounds(100,100,800,700); //x, y, width, height ��ġ�� ũ�� ����
		setVisible(true); // ������ ������ ���� ���� 
		
		
	}
	
	//graphics��ü�� �׷��� �̹����� ����¿� ���ȴ�. 
	
	
	
	//paint�޼ҵ�� �ʿ信 ���ؼ� �ڵ����� ȣ��ȴ�.
	//������ ȭ���� �������� �ʴ��� ȭ���� �����ؾ� �� ��찡 ����µ� �׶��� repaint�޼ҵ带 ȣ���ϸ��.
	//repaint�޼ҵ尡 ȣ=-0��Ǹ� ������ update�޼ҵ尡 ȣ��ǰ� update�޼ҵ�� ������Ʈ�� ������ ������ 
	//�׸��Ŀ� paint�� ȣ���Ѵ�. 
	//----> repaint() -> update() -> paint()
	
	public void paint(Graphics g){
		g.drawString("*", x, y); //���ڿ��� �׸��� 
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	
}