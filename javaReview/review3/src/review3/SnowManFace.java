package review3;

import java.awt.Color; 
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel{
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.YELLOW);
		g.fillOval(20, 30,200, 200);
		g.setColor(Color.BLACK);
		g.drawArc(60,80,50, 50, 180,-180); //¿Þ´«
		g.drawArc(150,80,50, 50, 180,-180); //¿À¸¥´«
		g.drawArc(70,130,100, 70, 180,180);//ÀÔ
	}
	
	
}


public class SnowManFace extends JFrame{

    public SnowManFace(){
    	
	this.setSize(500,500);	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("´«»ç¶÷ ¾ó±¼");
	this.setVisible(true);
	this.add(new MyPanel());
	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      SnowManFace s = new SnowManFace(); 
	}

}
