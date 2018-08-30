	package ch12;
	
	import java.util.*;
	
	public class Statistics {
		
		public static <T> void printList(List<T> slist) {
			System.out.println(slist);
		}
		
		public static void dummy(Person p ) {
			System.out.println(p);
		}
		
		public static void getPGenderStat(List<? super Student> list) {
			
		}
		
		public static <T extends Student & Comparable<Student>> void dummy2(T p ) {
			System.out.println(p);
		}
		
		/*
		public static void getPGenderStat(List<Person> plist) {
			TreeMap<Integer, Integer> gmap = new TreeMap<>();
			Iterator<Person> it = plist.iterator();
			while(it.hasNext()) {
				Person p = it.next();
				int gender = p.getGender();
				Integer value = gmap.get(gender);
				if(value == null) {
					gmap.put(gender,  1);
				}else {
					gmap.put(gender,  value+1);
				}
			}
			
			printMap(gmap);
		}
		*/
		/*
		public static <T extends Person> void getGenderStat(List<T> plist) {
			TreeMap<Integer, Integer> gmap = new TreeMap<>();
			Iterator<T> it = plist.iterator();
			while(it.hasNext()) {
				Person p = it.next();
				int gender = p.getGender();
				Integer value = gmap.get(gender);
				if(value == null) {
					gmap.put(gender,  1);
				}else {
					gmap.put(gender,  value+1);
				}
			}
			
			printMap(gmap);
		}
		*/
		/* ����:
		 *   Student ��ü�� List �Ǵ� GradStudent ��ü�� List��
		 *   �Է����� �޾Ƽ�
		 *   ����, ���, �ְ����� �л�����, �������� �л�������
		 *   ����ϴ�
		 *   Generic Method�� �����϶�.  
		 */
		
		public static void getGenderStat(List<? extends Person> plist) {
			TreeMap<Integer, Integer> gmap = new TreeMap<>();
			Iterator<? extends Person> it = plist.iterator();
			while(it.hasNext()) {
				Person p = it.next();
				int gender = p.getGender();
				Integer value = gmap.get(gender);
				if(value == null) {
					gmap.put(gender,  1);
				}else {
					gmap.put(gender,  value+1);
				}
			}
			
			printMap(gmap);
		}	
		
		public static void printMap(Map<Integer, Integer> map) {
			Set<Integer> keySet = map.keySet();
			Iterator<Integer> it = keySet.iterator();
			while(it.hasNext()) {
				Integer key = it.next();
				if (key==Person.MALE) {
					System.out.println("����:" + map.get(key));
				} else if (key == Person.FEMALE) {
					System.out.println("����:" + map.get(key));
				}else {
					System.out.println("�Һи�:" + map.get(key));
				}
			}
		}
		
		public static <T extends Student> void prtInfo (List<T> list) {
			int		sum = 0;
			int		min = Integer.MAX_VALUE;
			int		max = Integer.MIN_VALUE;
			
			Iterator<T> it = list.iterator();
			
			while (it.hasNext()) {
				Student value = it.next();
				
				int Sscore = value.getScore();
				sum += Sscore;
				
				if (max < Sscore) {
					max = Sscore;
				}
				if (min > Sscore) {
					min = Sscore;
				}
			}
			
			System.out.println("���� : " + sum);
			System.out.println("��� : " + (float)sum/list.size());
			
			Iterator<T> it2 = list.iterator();
			
			while(it2.hasNext()) {
				Student value2 = it2.next();
				int temp = value2.getScore();
				
				if (temp == max) {
					System.out.println("�ְ����� �л�");
					System.out.println(value2);
				}
				if (temp == min) {
					System.out.println("�������� �л�");
					System.out.println(value2);
				}
			}
			
		}
		
		
		public static void sort(List<? extends Student> list){
			Collections.sort(list);
		}
		
		public static <T extends Student> void descendingSort(List<T> list) {
			//Collections.sort(list);
			//Collections.sort(list, /* Comparator �������̽��� ������ ��ü */);
			Collections.sort(list, new StudentDescOrder<T>());
		}
		
		public static <T extends Comparable<? super T>> void sortReverse(List<T> list) {
			Collections.sort(list,  new ReverseComparator<T>());
		}
		
		
		
		
		
		
	}
