package myCalculator;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class myFrame extends JFrame {

	JPanel catachi = new JPanel(); // ����
	JPanel main = new JPanel(); // �Է� â
	JPanel btnPan = new JPanel(); // ��ư
	JPanel resultButtom = new JPanel(); // ��� ��

	JTextArea inputText = new JTextArea(1, 13); // �ؽ�Ʈ ����
	JTextArea inputText2 = new JTextArea(1, 13);

	Font font1;
	Font font2 = new Font("���", Font.BOLD, 50);
	
	JLabel jl;

	double number1 = 0;
	double number2 = 0;
	double result = 0;

	int add = 0;
	int minus = 0;
	int multi = 0;
	int divide = 0;

	Stack operands = new Stack();
	//char[] a = new char[0];
	int used = 0;
	String str = ""; 	
	Queue <String>a = new LinkedList<>();	
	
	// ��ư ��ü ����
	JButton button0 = new JButton("0");
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton buttonPlus = new JButton("+");
	JButton buttonMinus = new JButton("-");
	JButton buttonMulti = new JButton("*");
	JButton buttonDivide = new JButton("/");
	JButton buttonEqul = new JButton("���");
	JButton buttonC = new JButton("C");

	// ������
	public myFrame() {
		setting();
		componentSet();
		componentAdd();
		createListner();
	}

	// �⺻ ����
	public void setting() {
		this.setTitle("������ ����");
		this.setVisible(true);
		this.setSize(900, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ������Ʈ ����
	public void componentSet() {

		// y�� �������� ������Ʈ �ױ�
		catachi.setLayout(new BoxLayout(catachi, BoxLayout.Y_AXIS));

		font1 = new Font("���", Font.BOLD, 50);

		main.setLayout(new FlowLayout(FlowLayout.LEFT)); // ����, ����, ����

		inputText.setFont(font1);
		jl = new JLabel("�����Է�: ");
		jl.setFont(font1);

		btnPan.setLayout(new GridLayout(4, 4));

		resultButtom.setLayout(new FlowLayout(FlowLayout.LEFT)); // ����, ����, ����

		inputText2.setFont(font1);
		JLabel j2 = new JLabel("����� : ");
		j2.setFont(font1);
		resultButtom.add(j2);
		resultButtom.add(inputText2);

	}

	// ������Ʈ �߰�
	public void componentAdd() {
		main.add(jl);
		main.add(inputText);

		btnPan.add(button0).setFont(font2);
		btnPan.add(button1).setFont(font2);
		btnPan.add(button2).setFont(font2);
		btnPan.add(button3).setFont(font2);
		btnPan.add(button4).setFont(font2);
		btnPan.add(button5).setFont(font2);
		btnPan.add(button6).setFont(font2);
		btnPan.add(button7).setFont(font2);
		btnPan.add(button8).setFont(font2);
		btnPan.add(button9).setFont(font2);
		btnPan.add(buttonPlus).setFont(font2);
		btnPan.add(buttonMinus).setFont(font2);
		btnPan.add(buttonMulti).setFont(font2);
		btnPan.add(buttonDivide).setFont(font2);
		btnPan.add(buttonEqul).setFont(font2);
		btnPan.add(buttonC).setFont(font2);

		catachi.add(main);
		catachi.add(btnPan);
		catachi.add(resultButtom);
		catachi.setAlignmentX(Component.CENTER_ALIGNMENT);

		add(catachi);
	}

	// ������ ���� �޼���
	public void createListner() {
		// ��ư 0������ ��
		this.button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư 1������ ��
		this.button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư 2������ ��
		this.button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư 3������ ��
		this.button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư 4������ ��
		this.button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư 5������ ��
		this.button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư 6������ ��
		this.button6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư 7������ ��
		this.button7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư 8������ ��
		this.button8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư 9������ ��
		this.button9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư +������ ��
		this.buttonPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư -������ ��
		this.buttonMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư X������ ��
		this.buttonMulti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư /������ ��
		this.button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư 0������ ��
		this.buttonDivide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư =������ ��
		this.buttonEqul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// ��ư C������ ��
		this.buttonC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});

	}
	
	public void clicked(ActionEvent arg0) {

		Object obj = arg0.getSource(); // ��ü ��ȯ

        int used = 0;
	    
	    
		// C��ư ������ ���
		if (arg0.getActionCommand().equals("C")) {
			inputText.setText(String.valueOf(""));
			inputText2.setText(String.valueOf(""));
			operands = new Stack(); 
			a = new LinkedList<String>();
		}

		// ���� ��ư ������ ���
		if(arg0.getActionCommand().equals("1")){
	        str = inputText.getText();
	        inputText.setText(str + "1");
	      //  operands.push(1);
	    }

	    if(arg0.getActionCommand().equals("2")){
	        str = inputText.getText();
	        inputText.setText(str + "2");
	      //  operands.push(2);
	    }

	    if(arg0.getActionCommand().equals("3")){
	        str = inputText.getText();
	        inputText.setText(str + "3");
	     //   operands.push(3);
	    }
	    

	    if(arg0.getActionCommand().equals("4")){
	        str = inputText.getText();
	        inputText.setText(str + "4");
	      //  operands.push(4);
	    }

	    if(arg0.getActionCommand().equals("5")){
	        str = inputText.getText();
	        inputText.setText(str + "5");
	      ////  operands.push(5);
	    }

	    if(arg0.getActionCommand().equals("6")){
	        str = inputText.getText();
	        inputText.setText(str + "6");
	     //   operands.push(6);
	    }

	    if(arg0.getActionCommand().equals("7")){
	        str = inputText.getText();
	        inputText.setText(str + "7");
	      //  operands.push(7);
	    }
	    
	    if(arg0.getActionCommand().equals("8")){
	        str = inputText.getText();
	        inputText.setText(str + "8");
	      //  operands.push(8);
	    }
	    
	    if(arg0.getActionCommand().equals("9")){
	        str = inputText.getText();
	        inputText.setText(str + "9");
	       // operands.push(9);
	    }
	    
	    if(arg0.getActionCommand().equals("0")){
	        str = inputText.getText();
	        inputText.setText(str + "0");
	      //  operands.push(0);
	    }
	    
	    
		// ��Ģ ���� ������ ���
	    if(arg0.getActionCommand().equals("+")){
	        str = inputText.getText();
	        double operand = Double.parseDouble(str);
	        operands.push(operand);
	        inputText.setText("");
	        a.offer("+");
	        //used++;
	    }
	    
	    if(arg0.getActionCommand().equals("-")){
	        str = inputText.getText();
	        double operand = Double.parseDouble(str);
	        operands.push(operand);
	        inputText.setText("");
	        a.offer("-");
	        
	    }
	    
	    if(arg0.getActionCommand().equals("*")){
	        str = inputText.getText();
	        double operand = Double.parseDouble(str);
	        operands.push(operand);
	        inputText.setText("");
	        a.offer("*");
	        }
	    
	    if(arg0.getActionCommand().equals("/")){
	        str = inputText.getText();
	        double operand = Double.parseDouble(str);
	        operands.push(operand);
	        inputText.setText("");
	        a.offer("/");
	        
	    }
	    
		// ����ư ������ ���
	    if(arg0.getActionCommand().equals("���")){
	    	 str = inputText.getText();
		        double operand = Double.parseDouble(str);
		        operands.push(operand);
		       
	    	
	    for(int i = 0;!a.isEmpty(); i++){
	        	System.out.println("dd");
	           performBinaryOp(a.poll().charAt(0));
	        }

	        str = String.valueOf(operands.pop());
	        inputText2.setText(str);
	        
	    }
	}
	
	public void performBinaryOp(char nextOperation) {
	     double leftOperand, rightOperand;
	    Double result = new Double(0);
	    rightOperand = (Double) operands.pop();
	    leftOperand = (Double) operands.pop();
	    switch (nextOperation) {
	        case '+':
	            result = new Double(leftOperand + rightOperand);
	            break;
	        case '-':
	            result = new Double(leftOperand - rightOperand);
	            break;
	        case '*':
	            result = new Double(leftOperand * rightOperand);
	            break;
	        case '/':
	            result = new Double(leftOperand / rightOperand);
	            break;
	      
	    }
	    operands.push(result);
	}

}

public class calculator_gui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myFrame();
	}

}
