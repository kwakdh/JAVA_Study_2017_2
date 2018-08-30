package gurimpan2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class myFrame extends JFrame {

	private JPanel leftPanel;
	private RJPanel RightPanel;
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	
	private JButton buttonClicked;
	
	private Color btnColor;
    int startX, startY;
    int endX, endY;
    
	myFrame() {
		
		leftPanel = new JPanel();
		RightPanel = new RJPanel();
		this.getContentPane().setLayout(new GridLayout(0, 2));
		this.add(leftPanel);
		this.add(RightPanel);
		leftPanel.setLayout(new GridLayout(4, 0));

		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");

		leftPanel.add(btn1);
		leftPanel.add(btn2);
		leftPanel.add(btn3);
		leftPanel.add(btn4);

		basic();
		clickEvent();
	}

	// 이너클래스
	class RJPanel extends JPanel {
		RJPanel() {
			this.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent e) {
					if (buttonClicked == btn1) {
                    startX= e.getX();  
					}
				}

				public void mousePressed(MouseEvent e) {
					
				}

				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == btn2) {
                     
					}

					if (buttonClicked == btn3) {

					}

				}

			});
		}

	}

	public void basic() {
		this.setSize(500, 500);
		this.setTitle("도형 움직이기 ");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void clickEvent() {
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (buttonClicked != e.getSource()) {
					btn1.setBackground(Color.pink);
					if (buttonClicked != null) {
						buttonClicked.setBackground(btnColor);
					}
					buttonClicked = (JButton) e.getSource();
				}
			}
		});

	}
}

public class gurimpan_real2 {
	public void main(String[] args) {

		new myFrame();
	}
}
