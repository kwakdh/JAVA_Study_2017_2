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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
class MyFrame extends JFrame implements Serializable {
	// 패널 생성
	private JPanel leftPanel;
	private RightPanelC rightPanel;

	// 버튼 생성
	private JButton button1; // 선
	private JButton button2; // 직사각형
	private JButton button3; // 원
	private JButton button4; // 모두 지우기

	// 색
	private Color btnColor;

	private JButton butttonClicked; // 임의의 버튼 생성
	// 폰트설정
	Font font = new Font("고딕", Font.BOLD, 40);

	Vector<Shape> shapeList = new Vector<>();
	
	// 선 좌표
	int startPx;
	int startPy;
	int endPx;
	int endPy;
	
	//메뉴바 
	private JMenuBar jmb;
	private JMenu jm ; 
	private JMenuItem jmiSave;
	private JMenuItem jmiLoad;
	private JMenuItem jmiExit;
	
	// 생성자
	public MyFrame() {
		
		jmb = new JMenuBar();
		jm = new JMenu("file");
		jmb.add(jm);
		jmiSave = new JMenuItem("save");
		jmiLoad = new JMenuItem("load");
		jmiExit = new JMenuItem("exit");
		
		jm.add(jmiSave);
		jm.add(jmiLoad);		
		jm.add(jmiExit);

		setJMenuBar(jmb); 
		//저장하기 눌렀을 경우
		jmiSave.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int option = chooser.showSaveDialog(MyFrame.this);
				
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
		
		jmiLoad.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				//chooser.setFileFilter(new FileNameExtensionFilter("dhBoard", "gurim"));

				int option = chooser.showOpenDialog(MyFrame.this);

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
		
		// 전체 2등분
		this.getContentPane().setLayout(new GridLayout(0, 2));

		leftPanel = new JPanel();
		rightPanel = new RightPanelC();

		this.add(leftPanel);
		this.add(rightPanel);
		
		// 왼쪽 패널 4등분
		leftPanel.setLayout(new GridLayout(4, 0));
		// 버튼 객체 생성
		button1 = new JButton("선 그리기 ");
		button2 = new JButton("직사각형 그리기 ");
		button3 = new JButton("원 그리기 ");
		button4 = new JButton("다 지우기 ");

		// 각 버튼에 바탕색
		btnColor = button1.getBackground();
		btnColor = button2.getBackground();
		btnColor = button3.getBackground();
		btnColor = button4.getBackground();

		// 왼쪽 패널에 붙이기
		leftPanel.add(button1).setFont(font);
		leftPanel.add(button2).setFont(font);
		leftPanel.add(button3).setFont(font);
		leftPanel.add(button4).setFont(font);

		basic();
		clickEvent();

	}

	// 기본 설정
	public void basic() {
		this.setTitle("마지메나 그림판");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 1100);
		this.setVisible(true);
	}

	// 이벤트 설정 ----> 왼쪽 패널 색 바꾸기
	public void clickEvent() {
		// 첫번 째 버튼을 눌렀을 경우
		this.button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// getSource : 주소값 이용 ... !
				if (e.getSource() != butttonClicked) {
					button1.setBackground(Color.pink);
					if (butttonClicked != null) {
						butttonClicked.setBackground(btnColor);
					}
				}
				
				butttonClicked = (JButton) e.getSource();
			}

		});

		// 두번 째 버튼을 눌렀을 경우
		this.button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() != butttonClicked) {
					button2.setBackground(Color.orange);
					if (butttonClicked != null) {
						butttonClicked.setBackground(btnColor);
					}
				}
				butttonClicked = (JButton) e.getSource();
			}
		});

		// 세번 째 버튼을 눌렀을 경우
		this.button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() != butttonClicked) {
					button3.setBackground(Color.LIGHT_GRAY);
					if (butttonClicked != null) {
						butttonClicked.setBackground(btnColor);
					}
				}
				butttonClicked = (JButton) e.getSource();
			}

		});

		// 네번 째 버튼을 눌렀을 경우
		this.button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() != butttonClicked) {
					button4.setBackground(Color.pink);
					if (butttonClicked != null) {
						butttonClicked.setBackground(btnColor);
						
					}
					
					rightPanel.repaint();
					shapeList.clear();
					

					butttonClicked = (JButton) e.getSource();
				}
			}
		});
	}
	//이너 클래스 --------------- 객체 직렬화 
	class Serialization {
		String fileName;
		FileOutputStream fow;
		ObjectOutputStream out;
		FileInputStream fiw;
		ObjectInputStream in;

		Serialization(String fileName){
			fileName=this.fileName;
		}
		
		public void change(Vector<Shape> ShapeList ){
		  try {
			fow = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fow);
			out.writeObject(ShapeList);
			fow.close();
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("save2" +e.getMessage());
		}
		  
		}
		public void loading(){
			try {
				fiw =new FileInputStream(fileName);
				in = new ObjectInputStream(fiw);
				shapeList=(Vector<Shape>)in.readObject();
				repaint();
				fiw.close();
				in.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
			System.out.println("load2"+e.getMessage());
			}
			 catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	// 이너클래스 ------------ 오른쪽 패널
	class RightPanelC extends JPanel {

		RightPanelC() {

			this.addMouseListener(new MouseAdapter() {

				// 프레스드,릴리즈(마지막위치)
				public void mousePressed(MouseEvent e) {
					if (butttonClicked == button1) {
						startPx = e.getX();
						startPy = e.getY();
					}
				}

				public void mouseReleased(MouseEvent e) {
					if (butttonClicked == button1) {

						endPx = e.getX(); // 드래그 한 부분을 종료점
						endPy = e.getY();

						Graphics g = rightPanel.getGraphics();
						g.drawLine(startPx, startPy, endPx, endPy);
						Line li = new Line(startPx, startPy, endPx, endPy);
						shapeList.add((Shape) li);

					}
				}

				public void mouseClicked(MouseEvent e) {

					if (butttonClicked == button2) {
						Graphics g = rightPanel.getGraphics();
						g.drawRect(e.getX() - 50, e.getY() - 50, 100, 100);
						Rectangle re = new Rectangle(e.getX(), e.getY());
						shapeList.add((Shape) re);
					}

					if (butttonClicked == button3) {
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
	}

}

public class gurimpan_real {
	public static void main(String[] args) {
		new MyFrame();
	}
}
