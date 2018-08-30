package dragRec;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class myFrame extends JFrame {
	JPanel contentPane = new JPanel();
	Rectangle rec; // 직사각형
	boolean isDragged; // 마우스 드래그 체크
	int offX, offY;

	myFrame() {
		basic();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.addMouseListener(new MyMouseAdapter());
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.blue);
		g.drawRect(rec.x, rec.y, rec.width, rec.height);
	}

	public void basic() {
		this.setSize(500, 500);
		this.setTitle("도형 움직이기 ");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class MyMouseAdapter extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			if (rec.contains(new Point(e.getX(), e.getY()))) {
				offX = e.getX() - rec.x;
				offY = e.getY() - rec.y;
				isDragged = true;
			}
		}

		public void mouseReleased(MouseEvent e) {
			isDragged = false;
		}

		public void mouseDragged(MouseEvent e) {
			if (isDragged) {

				rec.x = e.getX() - offX;
				rec.y = e.getY() - offY;

			}
			repaint();
		}

	}
}

public class dragRec {
	public void main(String[] args) {
		new myFrame();
	}
}
