package review4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
class myPanel extends JComponent implements MouseListener,MouseMotionListener{

	   //�簢�� ����
	   Rectangle box;
	   
	   //���콺 �巡�� üũ 
	   boolean isDragged;
	   
	   //���콺 ������ ��ǥ
	   int offX,offY;
	
	   public myPanel(){
		   
		   //�簢�� ���� 
		    box = new Rectangle(0,0,100,80); //--->������ ����
		    
		    //���� �巡�� ���� ����
		    isDragged = false;  
		    
		    //���콺 ������ ���
		    addMouseListener(this);
		    addMouseMotionListener(this);
	    }
		    
		    //������Ʈ ������
		    public void paintComponent(Graphics g){
				super.paintComponent(g);
			    g.setColor(Color.red);	
		        g.drawRect(box.x, box.y, box.width, box.height);
		       
		    }
		  
		    
	   
	
	
	
	
	@Override
	public void mouseDragged(MouseEvent me) {
	
	//�巡�� ����� ��쿡�� �簢���� �̵���Ŵ
		if(isDragged){
			box.x=me.getX()-offX;
			box.y=me.getY()-offY;
		}
	
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent me) {
		//�簢�� �������� ����ǰ� �ϱ� 
		if(box.contains(new Point(me.getX(),me.getY()))){
			
			//���콺 ��ư ������ �簢�� �� ���콺 ��ǥ ���ϱ� 
			//���� ���콺 ��ũ�� ��ǥ���� �簢�� ��ġ ��ǥ ���̱���
			offX = me.getX()-box.x;
			offY = me.getY()-box.y;
		
		    isDragged = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	
	//���콺 ��ư�� ������Ǹ� �巡�׸�� ����
		isDragged = false;
	
	}
	
	

}
public class recDrag extends JFrame{

	
	//������
	public recDrag(){
		
		this.setTitle("�簢�� ���콺 �巡��");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.add(new myPanel());
        
	}
	
	public static void main(String[] args) {
      //���α׷� ����
		recDrag r = new recDrag();
	}

}
