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

// jmenuBar --> Ŭ���� ��ü�� ���� �װ���
// ���� �޴��ٸ� add�ؼ� jframe�� ���̱� 
// file-> jmenu --> jmenubar�� ���̱�
// file--[save,load,exit] jmenuitem�� 3 ��ü --> jmunu�� ���̱�



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
	Font font = new Font("���", Font.BOLD, 35);

	Vector<Shape> shapeList = new Vector<>();
	
	int startPx;
	int startPy;
	int endPx;
	int endPy;

	//�� ����
	protected JColorChooser color;	
	JPanel colorPanel;
	//Color color21 = new Color();
	// ������
	myFrame() {
		 
        color = new JColorChooser();
        color2 = color.showDialog(null, "�� ����", Color.BLACK);
        
        color.getSelectionModel().addChangeListener(this);
        //color.setBorder(BorderFactory.createTitledBorder("���� ����"));
		//color2 = color.set
		JMenuBar jmb = new JMenuBar();
		JMenu jm = new JMenu("file");
		jmb.add(jm);

		JMenuItem jmiSave = new JMenuItem("Save");
		JMenuItem jmiLoad = new JMenuItem("Load");
		JMenuItem jmiExit = new JMenuItem("Exit");

		jm.add(jmiSave);
		jm.addSeparator(); // ��ư���� ���� ���� ��
		jm.add(jmiLoad);
		jm.addSeparator();
		jm.add(jmiExit);

		// �����ϱ� ��ư ������ ��
		jmiSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				//chooser.setFileFilter(new FileNameExtensionFilter("dhBoard", "gurim"));

				int option = chooser.showSaveDialog(myFrame.this);

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

		// ����� ���� �ε��ϱ�
		jmiLoad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				//chooser.setFileFilter(new FileNameExtensionFilter("dhBoard", "gurim"));

				int option = chooser.showOpenDialog(myFrame.this);

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

		this.getContentPane().setLayout(new GridLayout(0, 3));
		
		leftPanel = new JPanel();
		rightPanel = new RightPanelC();
		colorPanel = new JPanel();
		colorPanel.add(color);

		this.add(leftPanel); // ������Ʈ �߰�
		this.add(rightPanel);
		this.add(colorPanel);

		leftPanel.setLayout(new GridLayout(4, 0));

		btn1 = new JButton(" �� �׸��� ");
		btn2 = new JButton(" �簢�� �׸��� ");
		btn3 = new JButton(" �� �׸��� ");
		btn4 = new JButton(" ���� �� ����� ");
		
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

	// �⺻ Ʋ
	public void basic() {

		this.setSize(1100, 1100);
		this.setTitle("�׸���");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// ������ ����
	public void createListner() {

		// ��ư 1�� ������ ���
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

		// ��ư 2�� ������ ���
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

		// ��ư 3�� ������ ���
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
        //��ư 4�� ���� ��� 
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

	// �̳�Ŭ���� -------------------- ��ü ����ȭ

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
				// ��ü�� ���Ϸ� ����ȭ �ϱ� . ���� ����� ��ġ �μ��� �޾Ƽ� ��ü ����
				// FileOutputStream : ���ڸ� ����Ʈ ���Ϸ� ��ȯ �ϴ� ����
				fow = new FileOutputStream(fileName);

				// �۷�ȭ �ϱ� ����....
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
				// FileInputStream : ���Ͽ��� ����Ʈ�� �о�鿩 ���ڷ� ��ȯ
				fiw = new FileInputStream(fileName);
				in = new ObjectInputStream(fiw);
				shapeList = (Vector<Shape>) in.readObject();
				// �ڹ� �÷������� ������Ʈ �׸��⸦ ���� �����ϴ� �޼���
				// �ڹ� �÷����� ������Ʈ�� paintComponent() ȣ��
				repaint(); //���� ������Ʈ �� ~!
				fiw.close();
				in.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block

				System.out.println("load2"+e.getMessage());
				e.printStackTrace();
			}

		}

	

	}

	// �̳� Ŭ���� ------------------- ����Ʈ �г�
	class RightPanelC extends JPanel {

		RightPanelC() {

			this.addMouseListener(new MouseAdapter() {

				// ��������,������(��������ġ)
				public void mousePressed(MouseEvent e) {
					if (buttonCliked == btn1) {
						startPx = e.getX();
						startPy = e.getY();
					}
				}

				public void mouseReleased(MouseEvent e) {
					if (buttonCliked == btn1) {

						endPx = e.getX(); // �巡�� �� �κ��� ������
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
		// ����Ʈ �гο� ����� ��� repaint ,shapeList �ȿ��ִ°� �� �����
		// ��ư Ŭ���� 
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	// ============== ���ȴٰ� �÷��� �� ���� �״��....!=================

	// 1. (rightPanel) �����׸������� ���� �ϱ�.
	// -----> 1) �׸� �׷��� ������ �� ���������� ������ ����... ��ü�� ! Ŭ���� ���Ǹ� �Ұ�
	// (������ : ù �������� �����Ѵ�. �� ������ ���̵� ) ------ �������� �̿��ؼ� ... !
	// ���δٸ� �������� ��ü�� ���� �Ѵ�.

	// �� �ٸ� ���߿��� �������� �����Ѵ�.... ���⼭ ����� �ʿ��ϴ� !
	// -----> 2) �̸� ���ǵ� ��ü�� ������ �迭�� �����Ѵ� .

	// 2. ����� �������� �����ͼ� ���Ӱ� �׷��ֱ�.---> ����Ʈ �ǳڿ��� �׷��ֶ�

}

public class Gurimpan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myFrame();
	}

}
