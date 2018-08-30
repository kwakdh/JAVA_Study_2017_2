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

	   //사각형 영역
	   Rectangle box;
	   
	   //마우스 드래그 체크 
	   boolean isDragged;
	   
	   //마우스 오프셋 좌표
	   int offX,offY;
	
	   public myPanel(){
		   
		   //사각형 정의 
		    box = new Rectangle(0,0,100,80); //--->사이즈 저장
		    
		    //현재 드래그 상태 저장
		    isDragged = false;  
		    
		    //마우스 리스너 등록
		    addMouseListener(this);
		    addMouseMotionListener(this);
	    }
		    
		    //컴포넌트 페인팅
		    public void paintComponent(Graphics g){
				super.paintComponent(g);
			    g.setColor(Color.red);	
		        g.drawRect(box.x, box.y, box.width, box.height);
		       
		    }
		  
		    
	   
	
	
	
	
	@Override
	public void mouseDragged(MouseEvent me) {
	
	//드래그 모드인 경우에만 사각형을 이동시킴
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
		//사각형 내에서만 적용되게 하기 
		if(box.contains(new Point(me.getX(),me.getY()))){
			
			//마우스 버튼 눌러서 사각형 내 마우스 좌표 구하기 
			//현재 마우스 스크린 좌표에서 사각형 위치 좌표 차이구함
			offX = me.getX()-box.x;
			offY = me.getY()-box.y;
		
		    isDragged = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	
	//마우스 버튼이 릴리즈되면 드래그모드 종료
		isDragged = false;
	
	}
	
	

}
public class recDrag extends JFrame{

	
	//생성자
	public recDrag(){
		
		this.setTitle("사각형 마우스 드래그");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.add(new myPanel());
        
	}
	
	public static void main(String[] args) {
      //프로그램 실행
		recDrag r = new recDrag();
	}

}
