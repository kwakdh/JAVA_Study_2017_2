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
	JButton button1 = new JButton("선 그리기");
	JButton button2 = new JButton("사각형 그리기");
	JButton button3 = new JButton("원 그리기");
	JButton button4 = new JButton("도형 삭제");

	// font
	Font font = new Font("고딕", Font.BOLD, 35);

	// 필요한 변수들
	JButton buttonCliked;
	Color btnColor = button1.getBackground();

	// 생성자
	myFrame() {
		basic();
	}

	// 기본 설정 메서드
	public void basic() {

		this.setSize(1100, 1100);
		this.setTitle("다희의 real~ 그림판");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		settingLayout();
	}

	// 레이아웃 만들기 메서드
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

	// 이벤트 모드 메서드
	public void eventsMode() {

		// 버튼 1을 눌렀을 경우
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

		// 버튼 2을 눌렀을 경우
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

		// 버튼 3을 눌렀을 경우
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

		// 버튼 4를 눌렀을 경우
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
