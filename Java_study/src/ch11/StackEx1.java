package ch11;

import java.util.Stack;

public class StackEx1 {
	private static Stack back = new Stack();
	private static Stack forward = new Stack();
	
	public static void main(String[] args) {
		goURL("1. ����Ʈ");
		goURL("2. ����");
		goURL("3. ���̹�");
		goURL("4. ����");		
		printStatus();
		
		System.out.println("�ڷΰ��� ��ư�� ���� ��");
		goBack();
		printStatus();
		
		System.out.println("�ڷΰ��� ��ư�� ���� ��");
		goBack();
		printStatus();
		
		System.out.println("�����ΰ��� ��ư�� ���� ��");
		goForward();
		printStatus();
		
		System.out.println("�����ΰ��� ��ư�� ���� ��");
		goForward();
		printStatus();
		
		System.out.println("���ο� �ּҷ� �̵�");
		goURL("5. codechobo.com");
		printStatus();
		

	}
	/* �ּ��ٿ� URL �Է��ؼ� �̵� */
	public static void goURL(String url) {
		back.push(url);
		// forward stack ����. 
		if(forward.isEmpty() != false)
			forward.clear();
	}
	
	/* forward ȭ��ǥ Ŭ�� */
	public static void goForward() {
		// forward ���ÿ��� pop�� �ذ�
		// �� ���� back ���ؿ� push
		if(forward.isEmpty()==false) {
			back.push(forward.pop());
		}	
	}
	
	/* backward ȭ��ǥ Ŭ�� */
	public static void goBack() {
		if(back.isEmpty()==false) {
			forward.push(back.pop());
		}
	}
	
	public static void printStatus() {
		System.out.println("back:"+back);
		System.out.println("forward:"+forward);
		System.out.println("����ȭ����:"+ back.peek() + "�Դϴ�.");	
		System.out.println();
	}

}
