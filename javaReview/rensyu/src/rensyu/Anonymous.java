package rensyu;

import java.awt.Button;
import java.awt.event.ActionEvent;

public class Anonymous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Button b = new Button("Start");
	b.addActionListener(new EventHandler());
	
	}

}

class EventHandler implements ActionLister{
	public void actionPerformed(ActionEvent e){
		System.out.println("ActionEvent occured");
	}
	
}