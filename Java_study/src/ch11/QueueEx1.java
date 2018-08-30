package ch11;

import java.util.*;

public class QueueEx1 {
	private static Queue q = new LinkedList();
	private static final int MAX_SIZE = 5; 
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		while(true) {
			String command = input.nextLine().trim();
			if (command.equalsIgnoreCase("q")) {
				System.out.println("���α׷��� �����մϴ�...");
				System.exit(0);
			}else if(command.equalsIgnoreCase("history")) {
				save(command);
				showHistory();
			} else {
				save(command);
			}
		}
	}
	
	public static void showHistory() {
		Iterator it = q.iterator();
		int i = 1; 
		while(it.hasNext()) {
			String cmd = (String)it.next();
			System.out.println(i+++"."+cmd);
		}		
	}
	public static void save(String command) {
		// queue�� �����Ѵ�. 
		q.offer(command);
		
		// q�� ���� ������ MAX_SIZE ���� ũ�� remove
		if(q.size() > MAX_SIZE) q.remove();
	}

}
