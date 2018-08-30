package ch11;

import java.util.EmptyStackException;
import java.util.Stack;

public class ExValidCheck {

	public static void main(String[] args) {
		/// ������ �־����� ġ�� => exp ���ڿ�
		//String exp = "(2+3)*4-(4-7)/2*3)";
		// java ch11.ExValidCheck (2+3)*4-(4-7)/2*3) 
		if(args.length != 1) {
			System.out.println("Usage: java ch11.ExValidCheck expression");
			System.out.println("Example: java ch11.ExValidCheck ((2+3)*2)+3");
			System.exit(0);
		}
		String exp = args[0];
		Stack st = new Stack();
		try {
			for(int i = 0; i < exp.length(); i++) {
				char ch = exp.charAt(i);
				if(ch=='('){
					st.push(ch);
				} else if(ch==')') {
					st.pop();
				}
			}
			if(st.isEmpty()) {
				System.out.println("��ȣ�� �����ϴ�");
			} else {
				System.out.println("��ȣ�� ��ġ���� �ʽ���");
			}
		}catch(EmptyStackException e) {
			System.out.println("��ȣ�� ���� �ʽ��ϴ�");
		}
		/*
		 * exp ���ڿ��� ù ��° ���ں��� ��  ��° ���ڱ��� ������ ����
		 *   - ���� '(' �̸� ���ÿ� Ǫ��
		 *   - ���ڰ� ')'�̸� ���ÿ��� pop <== ��⼭ exception�� ��
		 *      �ϴ� ��쵵 ��ȣ�� ���� �ʴ� ����̴�. 
		 *   
		 * ���� �۾� ���� �� ������ empty�̸� ��ȣ�� ��ġ�ϴ� ���̴�
		 * �׷��� ������ ��ȣ�� ��ġ���� �ʴ� ���̸�  
		 */
	}

}
