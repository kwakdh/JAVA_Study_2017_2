package gurimpan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// jmenuBar --> 클래스 객체를 만들어서 그것을
// 제이 메뉴바를 add해서 jframe에 붙이기 
// file-> jmenu --> jmenubar에 붙이기
// file--[save,load,exit] jmenuitem의 3 객체 --> jmunu에 붙이기



class Shape extends Vector {
	int shapeId;
	int getX;
	int getY;

	Shape(int argId, int argX, int argY) {

		shapeId = argId;
		getX = argX;
		getY = argY;

	}
}

class Rectangle extends Shape {
	int width = 100;
	int hight = 100;

	Rectangle(int argX, int argY) {
		super(2, argX, argY);
	}
}

class Circle extends Shape {
	int width = 100;
	int hight = 100;

	Circle(int argX, int argY) {
		super(3, argX, argY);
	}
}

class Line extends Shape {

	int argX2;
	int argY2;

	Line(int argX, int argY, int argX2, int argY2) {
		super(1, argX, argY);
		this.argX2 = argX2;
		this.argY2 = argY2;

	}
}

class myFrame extends JFrame implements Serializable, ChangeListener {

	private JPanel leftPanel;
	private JPanel rightPanel;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private Color btnColor;
	private JButton buttonCliked;
	private Color color2;
	Font font = new Font("고딕", Font.BOLD, 35);

	Vector<Shape> shapeList = new Vector<>();
	
	int startPx;
	int startPy;
	int endPx;
	int endPy;

	//색 선택
	protected JColorChooser color;	
	JPanel colorPanel;
	//Color color21 = new Color();
	// 생성자
	myFrame() {
		 
        color = new JColorChooser();
        color2 = color.showDialog(null, "색 선택", Color.BLACK);
        
        color.getSelectionModel().addChangeListener(this);
        //color.setBorder(BorderFactory.createTitledBorder("색상 선택"));
		//color2 = color.set
		JMenuBar jmb = new JMenuBar();
		JMenu jm = new JMenu("file");
		jmb.add(jm);

		JMenuItem jmiSave = new JMenuItem("Save");
		JMenuItem jmiLoad = new JMenuItem("Load");
		JMenuItem jmiExit = new JMenuItem("Exit");

		jm.add(jmiSave);
		jm.addSeparator(); // 버튼끼리 구분 짓는 선
		jm.add(jmiLoad);
		jm.addSeparator();
		jm.add(jmiExit);

		// 저장하기 버튼 눌렀을 때
		jmiSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				//chooser.setFileFilter(new FileNameExtensionFilter("dhBoard", "gurim"));

				int option = chooser.showSaveDialog(myFrame.this);

				if (option == JFileChooser.APPROVE_OPTION) {
					String fileName = chooser.getSelectedFile().getAbsolutePath();

					try {
						//Serialization 클래스 의 객체 생성 
						Serialization objToFile = new Serialization(fileName);
						objToFile.change(shapeList);
						
					} catch (Exception e1) {
						System.out.println("save"+e1.getMessage());
					}
				}
			}
		});

		// 저장된 파일 로드하기
		jmiLoad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				//chooser.setFileFilter(new FileNameExtensionFilter("dhBoard", "gurim"));

				int option = chooser.showOpenDialog(myFrame.this);

				if (option == JFileChooser.APPROVE_OPTION) {
					String fileName = chooser.getSelectedFile().getAbsolutePath();

					try {
						//Serialization 클래스 의 객체 생성
						Serialization objToFile = new Serialization(fileName);
						objToFile.loading();

					} catch (Exception e1) {
						System.out.println("load"+e1.getMessage());
					}
				}

			}
		});

		this.getContentPane().setLayout(new GridLayout(0, 3));
		
		leftPanel = new JPanel();
		rightPanel = new RightPanelC();
		colorPanel = new JPanel();
		colorPanel.add(color);

		this.add(leftPanel); // 컴포넌트 추가
		this.add(rightPanel);
		this.add(colorPanel);

		leftPanel.setLayout(new GridLayout(4, 0));

		btn1 = new JButton(" 선 그리기 ");
		btn2 = new JButton(" 사각형 그리기 ");
		btn3 = new JButton(" 원 그리기 ");
		btn4 = new JButton(" 도형 다 지우기 ");
		
		btnColor = btn1.getBackground();
		btnColor = btn2.getBackground();
		btnColor = btn3.getBackground();
		btnColor = btn4.getBackground();

		
		leftPanel.add(btn1).setFont(font);
		leftPanel.add(btn2).setFont(font);
		leftPanel.add(btn3).setFont(font);
		leftPanel.add(btn4).setFont(font);

		basic();
		createListner();
		setJMenuBar(jmb);

	
	}

	// 기본 틀
	public void basic() {

		this.setSize(1100, 1100);
		this.setTitle("그림판");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// 리스너 생성
	public void createListner() {

		// 버튼 1번 눌렀을 경우
		this.btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() != buttonCliked) {
					btn1.setBackground(Color.pink);
					if (buttonCliked != null) {
						buttonCliked.setBackground(btnColor);
					}

					buttonCliked = (JButton) e.getSource();
				}
			}
		});

		// 버튼 2번 눌렀을 경우
		this.btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() != buttonCliked) {
					btn2.setBackground(Color.pink);
					if (buttonCliked != null) {
						buttonCliked.setBackground(btnColor);
					}
					buttonCliked = (JButton) e.getSource();
				}
			}

		});

		// 버튼 3번 눌렀을 경우
		this.btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() != buttonCliked) {
					btn3.setBackground(Color.pink);
					if (buttonCliked != null) {
						buttonCliked.setBackground(btnColor);
					}

					buttonCliked = (JButton) e.getSource();
				}
			}
		});
        //버튼 4번 누를 경우 
		this.btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() != buttonCliked) {
					btn4.setBackground(Color.pink);
					if (buttonCliked != null) {
						buttonCliked.setBackground(btnColor);
						
					}
					rightPanel.repaint();
					shapeList.clear();
					

					buttonCliked = (JButton) e.getSource();
				}
			}
		});
	
	}

	// 이너클래스 -------------------- 객체 직렬화

	class Serialization {

		String fileName;
		FileOutputStream fow;
		ObjectOutputStream out;
		FileInputStream fiw;
		ObjectInputStream in;

		public Serialization(String fileName) {
			this.fileName = fileName;
		}

		public void change(Vector<Shape> shapeList) {

			try {
				// 객체를 파일로 직렬화 하기 . 파일 저장될 위치 인수로 받아서 객체 생성
				// FileOutputStream : 문자를 바이트 파일로 변환 하는 역할
				fow = new FileOutputStream(fileName);

				// 작렬화 하기 위해....
				out = new ObjectOutputStream(fow);
				out.writeObject(shapeList);
				fow.close();
				out.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("save2"+e.getMessage());
				e.printStackTrace();
			}
		}

		
		@SuppressWarnings("unchecked")
		public void loading() {

			try {
				// FileInputStream : 파일에서 바이트를 읽어들여 문자로 변환
				fiw = new FileInputStream(fileName);
				in = new ObjectInputStream(fiw);
				shapeList = (Vector<Shape>) in.readObject();
				// 자바 플랫폼에게 컴포넌트 그리기를 강제 지시하는 메서드
				// 자바 플랫폼이 컴포넌트의 paintComponent() 호출
				repaint(); //현재 컴포넌트 만 ~!
				fiw.close();
				in.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block

				System.out.println("load2"+e.getMessage());
				e.printStackTrace();
			}

		}

	

	}

	// 이너 클래스 ------------------- 라이트 패널
	class RightPanelC extends JPanel {

		RightPanelC() {

			this.addMouseListener(new MouseAdapter() {

				// 프레스드,릴리즈(마지막위치)
				public void mousePressed(MouseEvent e) {
					if (buttonCliked == btn1) {
						startPx = e.getX();
						startPy = e.getY();
					}
				}

				public void mouseReleased(MouseEvent e) {
					if (buttonCliked == btn1) {

						endPx = e.getX(); // 드래그 한 부분을 종료점
						endPy = e.getY();

						Graphics g = rightPanel.getGraphics();
						g.setColor(color2); 
						g.drawLine(startPx, startPy, endPx, endPy);
						Line li = new Line(startPx, startPy, endPx, endPy);
						shapeList.add((Shape) li);

					}
				}

				public void mouseClicked(MouseEvent e) {

					if (buttonCliked == btn2) {
						Graphics g = rightPanel.getGraphics();
						g.drawRect(e.getX() - 50, e.getY() - 50, 100, 100);
						Rectangle re = new Rectangle(e.getX(), e.getY());
						shapeList.add((Shape) re);
					}

					if (buttonCliked == btn3) {
						Graphics g = rightPanel.getGraphics();
						g.drawOval(e.getX() - 50, e.getY() - 50, 100, 100);
						Circle ci = new Circle(e.getX(), e.getY());
						shapeList.add((Shape) ci);
					}
					

				}

			});

		}

		// 저장된 정보들을 가져오기 .... ! Vector ~
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // 부모 페인트 호출

			for (int i = 0; i < shapeList.size(); i++) {

				Shape s = (Shape) shapeList.get(i);
				if (s.shapeId == 1) {
					Line r = (Line) s;
					g.drawLine(r.getX, r.getY, r.argX2, r.argY2);
				}

				if (s.shapeId == 2) {
					Rectangle r = (Rectangle) s;
					g.drawRect(r.getX, r.getY, r.width, r.hight);
				}

				if (s.shapeId == 3) {
					Circle r = (Circle) s;
					g.drawOval(r.getX, r.getY, r.width, r.hight);

				}
			}

		}
		// 라이트 패널에 지우기 기능 repaint ,shapeList 안에있는거 다 지우기
		// 버튼 클릭시 
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	// ============== 내렸다가 올려도 그 상태 그대로....!=================

	// 1. (rightPanel) 도형그릴때마다 저장 하기.
	// -----> 1) 그림 그려질 때마다 그 도형에대한 정보를 저장... 객체로 ! 클래스 정의를 할것
	// (공통점 : 첫 시작점이 존재한다. 이 도형의 아이디 ) ------ 다형성을 이용해서 ... !
	// 서로다른 도형들을 객체에 정의 한다.

	// 세 다른 것중에서 공통점이 존재한다.... 여기서 상속이 필요하다 !
	// -----> 2) 미리 정의된 객체를 가지고 배열에 저장한다 .

	// 2. 저장된 정보들을 가져와서 새롭게 그려주기.---> 라이트 판넬에서 그려주라

}

public class Gurimpan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myFrame();
	}

}
