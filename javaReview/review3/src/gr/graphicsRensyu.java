package gr;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel{
  public void paintComponent(Graphics g){
	 super.paintComponent(g);
	 g.drawString("���� ���� �Ͼ��...�Ф�", 10, 10);
	 g.drawLine(10, 20,110, 20);
	 g.drawRect(10, 30, 100, 100);
   }	
}

class MyFrame extends JFrame{
	public MyFrame(){
		this.setTitle("������ ����");
	    this.setSize(300,200);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    MyPanel p = new MyPanel();
	    this.setVisible(true);
	    add(p);
	}	
}

public class graphicsRensyu {
   public static void main(String[] args){
	   MyFrame frame = new MyFrame();
     }
}

