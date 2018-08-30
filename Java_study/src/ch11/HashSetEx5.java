package ch11;

import java.util.*;

public class HashSetEx5 {

	public static void main(String[] args) {
		Set setA = new HashSet();
		Set setB = new HashSet();
		
		Set setHab = new HashSet();
		Set setCha = new HashSet();
		Set setKyo = new HashSet();
		
		setA.add(1);setA.add(2);setA.add(3);setA.add(4);setA.add(5);
		System.out.println("setA:"+setA);
		setB.add(4);setB.add(5);setB.add(6);setB.add(7);setB.add(8);
		System.out.println("setB:"+setB);
		
		/*
		setA.retainAll(setB);
		System.out.println("������:"+setA);
		*/
		// ������ ������. retainAll
		/*
		 * setB�� �� ���ҿ� ����
		 *   setA�� �� ���Ҹ� �����ϰ� ������
		 *     setKyo�� �� ���Ҹ� add
		 */
		Iterator it = setB.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(setA.contains(tmp)) {
				setKyo.add(tmp);
			}
		}
		System.out.println("setKyo:"+setKyo);
		
		// ������(setA-setB) removeAll
		/*
		 * setA�� �� ���ҿ� ����
		 *   setB�� �� ���Ҹ� �����ϰ� ���� ������
		 *     setCha�� �� ���Ҹ� add
		 */
		it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(setB.contains(tmp) == false) {
				setCha.add(tmp);
			}
		}
		System.out.println("setCha:"+setCha);
		
		// ������  addAll
		// setA�� �� ���Ҹ� setHab�� add
		// setB�� �� ���Ҹ� setHab�� add
		it = setA.iterator();
		while(it.hasNext()) setHab.add(it.next());
		it = setB.iterator();
		while(it.hasNext()) setHab.add(it.next());
		System.out.println("setHab:"+setHab);
		
	}

}
