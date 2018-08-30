package review3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class randomSub extends JPanel{
   private JButton btn1 = new JButton("확인");	
   private JButton btn2 = new JButton("취소");	
	
   void init(){
	   this.setLayout(new BorderLayout());
       Panel p = new Panel(new FlowLayout());
       p.add(btn1);
       p.add(btn2);
       this.add("North",p);
       
   }
   void start(){}
   public void paintComponent(Graphics g){
	   
	   super.paintComponent(g);
       int x,y,w,h;
       
       //랜덤값 받기
       for (int i = 0 ; i<100 ; i++ ){
       Dimension dm = this.getSize();
       
       int red = (int)(Math.random()*256);
       int green = (int)(Math.random()*256);
       int blue = (int)(Math.random()*256);
       g.setColor(new Color(red,green,blue));
       
       
       x= (int)(Math.random()*dm.getWidth());  //너비와 높이 값 제한 
       y= (int)(Math.random()*dm.getHeight());
       w= (int)(Math.random()*50)+50;
       h= (int)(Math.random()*50)+50;
       
       int dist = (int)(Math.random()*4); 
       
       if (dist==0){
    	   g.drawRect(x,y,w,h); //속이 빈 사각형
       }
       else if(dist==1){
    	   g.fillRect(x, y, w, h);
       }else if(dist ==2){
    	   g.drawOval(x,y,w,h);
       }else{
    	   g.fillOval(x, y, w, h);
       }
       
       try{
    	   Thread.sleep(500);
       }catch(Exception ee){}
       
       
       
       }   
   }

}

public class random extends JFrame{
	   public random(){
	    	
			this.setSize(800,800);	
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("랜덤 출력");
			this.setVisible(true);
			this.add(new randomSub());
			
			}
			
	public static void main(String[] args) {
		
		random ex = new random();
	}

}
