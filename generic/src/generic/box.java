package generic;

import java.util.ArrayList;

public class box {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//����: student��ü�� ����Ʈ , GradStudent ��ü�� List�� �Է����� �޾Ƽ�
		// ����, ���, �ְ����� �л�����, �������� �л����� �� ����ϴ� generic Method�� ����
		
		ArrayList<Student> sList = new ArrayList<>();
		sList.add(new Student ("��",20,Student.FEMALE,"����",80));
		sList.add(new Student ("��",26,Student.MALE,"����",100));
		sList.add(new Student ("��",26,Student.MALE,"����",60));
		
		statistics.printList(sList);
		System.out.println();
		statistics.getGradeStat(sList);
		
		
		
		ArrayList<Student> gList = new ArrayList<>();
		gList.add(new GradStudent ("��",20,Student.FEMALE,"����",80,"it"));
		gList.add(new GradStudent ("��",26,Student.MALE,"����",100,"it"));
		gList.add(new GradStudent ("��",26,Student.MALE,"����",60,"it"));
		
		statistics.printList(gList);
		System.out.println();
	}

}
