package review;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame{

	public MyFrame(){
		
     this.setTitle("�׸��� �� �Ƕ� ���� ");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     JPanel panel = new JPanel(); //�����̳ʷ� �г� ���� ----> �󺧰� ��ư ����
     JPanel panel2 = new JPanel(); //�ؽ�Ʈ �ʵ� �г� ����

     JTextField t1 = new JTextField(10); //�ؽ�Ʈ �ʵ� �ΰ� �����ؼ� �гο� �߰��ϱ�.
     JTextField t2 = new JTextField(10);
     t2.setEditable(false); // �� ��° �ؽ�Ʈ �ʵ�� �Է±����� ����
     
     
     setLayout(new FlowLayout(FlowLayout.CENTER, 30, 40)); // ����, ����, ����
     
     JLabel label = new JLabel("���� ����");
    /* JButton button1 = new JButton("����");
     JButton button2 = new JButton("��Ȳ");
     JButton button3 = new JButton("���");
     JButton button4 = new JButton("�Ķ�");
     
     button4.setEnabled(false); //��ư�� ��Ȯ������ ����
     
     panel.add(label);  //�гο� ���̺�� ��ư �߰�
     panel.add(button1);
     panel.add(button2);
     panel.add(button3);
     panel.add(button4);
     */
     
     panel2.add(t1); //�ؽ�Ʈ �ʵ带 �гο� �߰�
     panel2.add(t2);
     
     add(panel); //�г��� �����ӿ� �߰�
	 add(panel2); 
	 this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	 setVisible(true);
	}
	
	
}
public class component {

	public static void main(String[] args) {

		 new MyFrame();
		
	}

}
