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
    	
    	this.setTitle("CardLayout ���� ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(0,5,10,0)); //�г� ���� 
        
        addButton("<<",panel);
        addButton("<",panel);
        addButton(">>",panel);
        addButton(">",panel);
        addButton("����",panel);
        
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
        			add(new JButton("���� ī�� ��ȣ "+i+"�Դϴ�."),"Center");
        		}
        	}	
        }
        
        public void actionPerformed(ActionEvent e){
        	if(e.getActionCommand().equals("����")){
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
