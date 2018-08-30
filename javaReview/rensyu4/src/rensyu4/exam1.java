package rensyu4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JFrame;

class Exam01_Sub extends JFrame {

	private Button btn1 = new Button("Ȯ��");
	private Button btn2 = new Button("���");

	public Exam01_Sub() {

		this.setTitle("������ �ڵ������� ������ �׸���");		
		this.setSize(500, 500);   //âũ�� 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â �ݱ� ����
		this.setVisible(true);
		this.init();
		this.start();

	}

	void init() {
		this.setLayout(new BorderLayout());
		Panel p = new Panel(new FlowLayout());
		p.add(btn1);
		p.add(btn2);
		this.add("North", p);
	}

	void start() {
	}

	public void paint(Graphics g) {
		
		int x, y, w, h;

		// ������ �޾Ƴ���
		for (int i = 0; i < 100; i++) {

			Dimension dm = this.getSize();
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			g.setColor(new Color(red, green, blue));

			x = (int) (Math.random() * dm.getWidth()); // �ʺ�� ���̰� �����ϱ�
			y = (int) (Math.random() * dm.getHeight());
			w = (int) (Math.random() * 50) + 50;
			h = (int) (Math.random() * 50) + 50;

			int dist = (int) (Math.random() * 4); // �ִ밪�� 4�̸��� ���� ����������. 3�� �ִ밪
													// (0~3������ ��)

			if (dist == 0)
				g.drawRect(x, y, w, h); // �Ӻ� �簢��
			else if (dist == 1)
				g.fillRect(x, y, w, h); // ���� �簢��
			else if (dist == 2)
				g.drawOval(x, y, w, h); // �Ӻ� ����
			else
				g.fillOval(x, y, w, h); // ���� ��������(x,y) �ʺ�� ���� (w,h)

			try {
				Thread.sleep(500);
			} catch (Exception ee) {

			}
		}
	}
}

public class exam1 {
	public static void main(String args[]) {
		
		Exam01_Sub ex = new Exam01_Sub();
	}

}
