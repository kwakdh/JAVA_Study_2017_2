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

	JPanel catachi = new JPanel(); // 형태
	JPanel main = new JPanel(); // 입력 창
	JPanel btnPan = new JPanel(); // 버튼
	JPanel resultButtom = new JPanel(); // 결과 값

	JTextArea inputText = new JTextArea(1, 13); // 텍스트 공간
	JTextArea inputText2 = new JTextArea(1, 13);

	Font font1;
	Font font2 = new Font("고딕", Font.BOLD, 50);
	
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
	
	// 버튼 객체 생성
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
	JButton buttonEqul = new JButton("계산");
	JButton buttonC = new JButton("C");

	// 생성자
	public myFrame() {
		setting();
		componentSet();
		componentAdd();
		createListner();
	}

	// 기본 세팅
	public void setting() {
		this.setTitle("다희의 계산기");
		this.setVisible(true);
		this.setSize(900, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 컴포넌트 설정
	public void componentSet() {

		// y축 방향으로 컴포넌트 쌓기
		catachi.setLayout(new BoxLayout(catachi, BoxLayout.Y_AXIS));

		font1 = new Font("고딕", Font.BOLD, 50);

		main.setLayout(new FlowLayout(FlowLayout.LEFT)); // 정렬, 수평, 수직

		inputText.setFont(font1);
		jl = new JLabel("수식입력: ");
		jl.setFont(font1);

		btnPan.setLayout(new GridLayout(4, 4));

		resultButtom.setLayout(new FlowLayout(FlowLayout.LEFT)); // 정렬, 수평, 수직

		inputText2.setFont(font1);
		JLabel j2 = new JLabel("계산결과 : ");
		j2.setFont(font1);
		resultButtom.add(j2);
		resultButtom.add(inputText2);

	}

	// 컴포넌트 추가
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

	// 리스너 생성 메서드
	public void createListner() {
		// 버튼 0눌렀을 때
		this.button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 1눌렀을 때
		this.button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 2눌렀을 때
		this.button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 3눌렀을 때
		this.button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 4눌렀을 때
		this.button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 5눌렀을 때
		this.button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 6눌렀을 때
		this.button6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 7눌렀을 때
		this.button7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 8눌렀을 때
		this.button8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 9눌렀을 때
		this.button9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 +눌렀을 때
		this.buttonPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 -눌렀을 때
		this.buttonMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 X눌렀을 때
		this.buttonMulti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 /눌렀을 때
		this.button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 0눌렀을 때
		this.buttonDivide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 =눌렀을 때
		this.buttonEqul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});
		// 버튼 C눌렀을 때
		this.buttonC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clicked(arg0);
			}
		});

	}
	
	public void clicked(ActionEvent arg0) {

		Object obj = arg0.getSource(); // 객체 반환

        int used = 0;
	    
	    
		// C버튼 눌렀을 경우
		if (arg0.getActionCommand().equals("C")) {
			inputText.setText(String.valueOf(""));
			inputText2.setText(String.valueOf(""));
			operands = new Stack(); 
			a = new LinkedList<String>();
		}

		// 숫자 버튼 눌렀을 경우
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
	    
	    
		// 사칙 연산 눌렀을 경우
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
	    
		// 계산버튼 눌렀을 경우
	    if(arg0.getActionCommand().equals("계산")){
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
