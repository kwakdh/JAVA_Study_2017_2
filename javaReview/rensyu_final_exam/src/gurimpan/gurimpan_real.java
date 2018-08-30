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
	// �г� ����
	private JPanel leftPanel;
	private RightPanelC rightPanel;

	// ��ư ����
	private JButton button1; // ��
	private JButton button2; // ���簢��
	private JButton button3; // ��
	private JButton button4; // ��� �����

	// ��
	private Color btnColor;

	private JButton butttonClicked; // ������ ��ư ����
	// ��Ʈ����
	Font font = new Font("���", Font.BOLD, 40);

	Vector<Shape> shapeList = new Vector<>();
	
	// �� ��ǥ
	int startPx;
	int startPy;
	int endPx;
	int endPy;
	
	//�޴��� 
	private JMenuBar jmb;
	private JMenu jm ; 
	private JMenuItem jmiSave;
	private JMenuItem jmiLoad;
	private JMenuItem jmiExit;
	
	// ������
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
		//�����ϱ� ������ ���
		jmiSave.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int option = chooser.showSaveDialog(MyFrame.this);
				
				if (option == JFileChooser.APPROVE_OPTION) {
					String fileName = chooser.getSelectedFile().getAbsolutePath();
					try {
						//Serialization Ŭ���� �� ��ü ���� 
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
						//Serialization Ŭ���� �� ��ü ����
						Serialization objToFile = new Serialization(fileName);
						objToFile.loading();

					} catch (Exception e1) {
						System.out.println("load"+e1.getMessage());
					}

				}
			}                                     
			
		});
		
		// ��ü 2���
		this.getContentPane().setLayout(new GridLayout(0, 2));

		leftPanel = new JPanel();
		rightPanel = new RightPanelC();

		this.add(leftPanel);
		this.add(rightPanel);
		
		// ���� �г� 4���
		leftPanel.setLayout(new GridLayout(4, 0));
		// ��ư ��ü ����
		button1 = new JButton("�� �׸��� ");
		button2 = new JButton("���簢�� �׸��� ");
		button3 = new JButton("�� �׸��� ");
		button4 = new JButton("�� ����� ");

		// �� ��ư�� ������
		btnColor = button1.getBackground();
		btnColor = button2.getBackground();
		btnColor = button3.getBackground();
		btnColor = button4.getBackground();

		// ���� �гο� ���̱�
		leftPanel.add(button1).setFont(font);
		leftPanel.add(button2).setFont(font);
		leftPanel.add(button3).setFont(font);
		leftPanel.add(button4).setFont(font);

		basic();
		clickEvent();

	}

	// �⺻ ����
	public void basic() {
		this.setTitle("�����޳� �׸���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 1100);
		this.setVisible(true);
	}

	// �̺�Ʈ ���� ----> ���� �г� �� �ٲٱ�
	public void clickEvent() {
		// ù�� ° ��ư�� ������ ���
		this.button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// getSource : �ּҰ� �̿� ... !
				if (e.getSource() != butttonClicked) {
					button1.setBackground(Color.pink);
					if (butttonClicked != null) {
						butttonClicked.setBackground(btnColor);
					}
				}
				
				butttonClicked = (JButton) e.getSource();
			}

		});

		// �ι� ° ��ư�� ������ ���
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

		// ���� ° ��ư�� ������ ���
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

		// �׹� ° ��ư�� ������ ���
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
	//�̳� Ŭ���� --------------- ��ü ����ȭ 
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
	// �̳�Ŭ���� ------------ ������ �г�
	class RightPanelC extends JPanel {

		RightPanelC() {

			this.addMouseListener(new MouseAdapter() {

				// ��������,������(��������ġ)
				public void mousePressed(MouseEvent e) {
					if (butttonClicked == button1) {
						startPx = e.getX();
						startPy = e.getY();
					}
				}

				public void mouseReleased(MouseEvent e) {
					if (butttonClicked == button1) {

						endPx = e.getX(); // �巡�� �� �κ��� ������
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

		// ����� �������� �������� .... ! Vector ~
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // �θ� ����Ʈ ȣ��

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
