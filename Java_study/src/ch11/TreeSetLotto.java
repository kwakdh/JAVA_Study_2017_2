package ch11;

import java.util.TreeSet;

public class TreeSetLotto {

	public static void main(String[] args) {
		/*
		 * TreeSet ��ü ����, �� ��ü�� set�̶� ����
		 * set.size()�� 6 �̸��� ����
		 *   - 1~45 ������ ������ �������� ������ set.add ����.
		 */
		// set�� �ִ� ���Ҹ� �ϳ��� ����
		// ������ ������������ ���´�. 
		// HashSet�� �̿����� ����
		// hashset�� �ζǹ�ȣ �ְ�
		// �����ϱ� ���ؼ� 
		// hashset�� ������ list�� �����߰�
		// �� list�� Collections.sort �޼ҵ带 ȣ���ؼ�
		// �������ݾ�...
		
		TreeSet set = new TreeSet();
		while(set.size() < 6) {
			int num = (int)(Math.random()*45)+1;
			set.add(num);
		}
		System.out.println(set);
	}

}
