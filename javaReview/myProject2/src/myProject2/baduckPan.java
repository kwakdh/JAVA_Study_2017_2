package myProject2;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class myFrame extends JFrame{
	
	myFrame(){
		this.setTitle("바둑판");
		this.setVisible(true);
		this.setSize(1000,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jp = new JPanel();  //패널생성
	    jp.setLayout(new GridLayout(4,4));	//그리드 레이아웃 4x4
	    
	    JLabel[] lb = new JLabel[16]; //라벨 배열 생성
	    
	    Color[] color = {new Color(153,051,051),new Color(204,102,102),new Color(255,153,153),new Color(255,153,102),
	    		new Color(204,102,000),new Color(255,153,000),new Color(255,255,153),new Color(204,204,051)
	    		,new Color(204,255,204),new Color(153,255,153),new Color(051,153,051),new Color(000,102,000)
	    		,new Color(000,255,255),new Color(000,102,102),new Color(051,102,102),new Color(000,051,102)};

	    for(int i = 0 ; i < 16 ; i++){
	    	
	    	 lb[i] = new JLabel(""+i+"");
	    	 lb[i].setFont(new Font("serif",Font.BOLD,45));
	    	 lb[i].setBackground(color[i]); 
	    	 lb[i].setOpaque(true); //배경색 보이게 하기 
		     jp.add(lb[i]);
		     	
	    }
	    
        add(jp);
	    
	}
}


public class baduckPan {
	public static void main(String[] args) {
        new myFrame();
	}
}
