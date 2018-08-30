package ch11;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {

	public static void main(String[] args) {
		String[] strArr = {"cat", "Dog", "lion", "tiger"};
		/* �Ʒ��� ���� Arrays.sort �޼ҵ�� ���ĵǷ���
		 * �迭�� ������ Ÿ����(class) Comparable �������̽���
		 * ������ Ÿ��(class)�̾�� �Ѵ�. 
		 * ��, �Ʒ��� ���
		 * strArr �迭�� ������ ���ڿ�(String)��
		 * Comparable �������̽��� ������ Ÿ���̴�. 
		 */
		Arrays.sort(strArr);
		System.out.println("strArr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		System.out.println("strArr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr, new DescendingOrder());
		System.out.println("strArr="+Arrays.toString(strArr));
		//Arrays.sort(�迭, Comparator �������̽��� ������ Ŭ������ ��ü);
		// �� ����� Comparator �������̽��� ������ 
		// Ŭ������ ��ü�� �Ѱ��ָ� �ȴ�.
		
		
		Arrays.sort(strArr, new DescendingOrder2());
		System.out.println("strArr="+Arrays.toString(strArr));

	}
}

class DescendingOrder implements Comparator {

	@Override
	public int compare(Object obj1, Object obj2) {
		/*
		 * 
		 */
		/* obj1�� obj2�� Comparable Ÿ������ �˻� */
		if(obj1 instanceof Comparable && 
				obj2 instanceof Comparable) {
			/*
			 * �� ����� ���ؼ� ���� ���� ũ�� �����
			 * ������ 0
			 * ���� ���� ũ�� ���� �� ��ȯ
			 * �䷸�� ���ָ� Arrays.sort �޼ҵ尡 
			 * �������� �������ش�. 
			 * ����, ������������ ���ְ� ������ �ݴ�� �ϸ�ȴ�. 
			 */
			Comparable c1 = (Comparable)obj1;
			Comparable c2 = (Comparable)obj2;
			return c1.compareTo(c2)*-1;
		}
			
		return 0;
	}
}



class DescendingOrder2 implements Comparator {

	@Override
	public int compare(Object obj1, Object obj2) {
		/*
		 * 
		 */
		/* obj1�� obj2�� Comparable Ÿ������ �˻� */
		if(obj1 instanceof String && 
				obj2 instanceof String) {
			/*
			 * �� ����� ���ؼ� ���� ���� ũ�� �����
			 * ������ 0
			 * ���� ���� ũ�� ���� �� ��ȯ
			 * �䷸�� ���ָ� Arrays.sort �޼ҵ尡 
			 * �������� �������ش�. 
			 * ����, ������������ ���ְ� ������ �ݴ�� �ϸ�ȴ�. 
			 */
			String s1 = (String)obj1;
			String s2 = (String)obj2;
			
			return s1.toUpperCase().compareTo(s2.toUpperCase())*-1;
			
		}
			
		return 0;
	}
}











