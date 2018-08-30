package dahui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class myFrame extends JFrame {

	// JPanel
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();

	// JButton
	JButton button1 = new JButton("�� �׸���");
	JButton button2 = new JButton("�簢�� �׸���");
	JButton button3 = new JButton("�� �׸���");
	JButton button4 = new JButton("���� ����");

	// font
	Font font = new Font("���", Font.BOLD, 35);

	// �ʿ��� ������
	JButton buttonCliked;
	Color btnColor = button1.getBackground();

	// ������
	myFrame() {
		basic();
	}

	// �⺻ ���� �޼���
	public void basic() {

		this.setSize(1100, 1100);
		this.setTitle("������ real~ �׸���");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		settingLayout();
	}

	// ���̾ƿ� ����� �޼���
	public void settingLayout() {

		this.getContentPane().setLayout(new GridLayout(0, 2));
		this.add(leftPanel);
		this.add(rightPanel);

		leftPanel.setLayout(new GridLayout(4, 0));

		leftPanel.add(button1).setFont(font);
		leftPanel.add(button2).setFont(font);
		leftPanel.add(button3).setFont(font);
		leftPanel.add(button4).setFont(font);

		eventsMode();
	}

	// �̺�Ʈ ��� �޼���
	public void eventsMode() {

		// ��ư 1�� ������ ���
		this.button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() != buttonCliked) {
					button1.setBackground(Color.pink);
					if (buttonCliked != null) {
						buttonCliked.setBackground(btnColor);
					}

					buttonCliked = (JButton) e.getSource();
				}
			}
		});

		// ��ư 2�� ������ ���
		this.button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() != buttonCliked) {
					button2.setBackground(Color.cyan);
					if (buttonCliked != null) {
						buttonCliked.setBackground(btnColor);
					}
					buttonCliked = (JButton) e.getSource();
				}
			}

		});

		// ��ư 3�� ������ ���
		this.button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() != buttonCliked) {
					button3.setBackground(Color.orange);
					if (buttonCliked != null) {
						buttonCliked.setBackground(btnColor);
					}
					buttonCliked = (JButton) e.getSource();
				}
			}

		});

		// ��ư 4�� ������ ���
		this.button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}

			/*
			 * @Override public void actionPerformed(ActionEvent e) {
			 * if(e.getSource()!= buttonCliked){
			 * button4.setBackground(Color.LIGHT_GRAY); if(buttonCliked !=
			 * null){ buttonCliked.setBackground(btnColor);
			 * button4.setBackground(btnColor);
			 * 
			 * }
			 * 
			 * buttonCliked = (JButton)e.getSource(); } }
			 */

			
		}
	
);
	}	
}

public class Gurimpan_real {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myFrame();
	}

}
