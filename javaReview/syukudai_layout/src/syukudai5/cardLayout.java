package syukudai5;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame extends JFrame implements ActionListener{
    
	JPanel panel;
    Cards cards;
    
    MyFrame(){
    	
    	this.setTitle("CardLayout 예제 ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(0,5,10,0)); //패널 생성 
        
        addButton("<<",panel);
        addButton("<",panel);
        addButton(">>",panel);
        addButton(">",panel);
        addButton("종료",panel);
        
        add(panel,"North");
        cards = new Cards();
        add(cards,"Center");
        setVisible(true);
       
        }
    
        void addButton(String str, Container target){
    	  
          JButton button = new JButton();
          button.addActionListener(this);
          target.add(button);
          
        }
    
        private class Cards extends JPanel{
        	CardLayout layout;
        	
        	public Cards(){
        		layout = new CardLayout();
        		setLayout(layout);
        		
        		for(int i = 1 ; i <=10 ; i++){
        			add(new JButton("현재 카드 번호 "+i+"입니다."),"Center");
        		}
        	}	
        }
        
        public void actionPerformed(ActionEvent e){
        	if(e.getActionCommand().equals("종료")){
        		System.exit(0);
        	}else if(e.getActionCommand().equals("<<")){
        		cards.layout.first(cards);
        	}else if(e.getActionCommand().equals("<")){
        		cards.layout.previous(cards);
        	}else if(e.getActionCommand().equals(">")){
        		cards.layout.next(cards);
        	}else if(e.getActionCommand().equals(">>")){
        		cards.layout.last(cards);
        	}
        	
        }
}

public class cardLayout {
	public static void main(String[] args) {
		 new MyFrame();	
	}
}
