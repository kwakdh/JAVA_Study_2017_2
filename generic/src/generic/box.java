package generic;

import java.util.ArrayList;

public class box {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//과제: student객체의 리스트 , GradStudent 객체의 List를 입력으로 받아서
		// 총점, 평균, 최고점수 학생정보, 최저점수 학생정보 를 출력하는 generic Method를 구현
		
		ArrayList<Student> sList = new ArrayList<>();
		sList.add(new Student ("가",20,Student.FEMALE,"컴정",80));
		sList.add(new Student ("나",26,Student.MALE,"컴정",100));
		sList.add(new Student ("다",26,Student.MALE,"컴정",60));
		
		statistics.printList(sList);
		System.out.println();
		statistics.getGradeStat(sList);
		
		
		
		ArrayList<Student> gList = new ArrayList<>();
		gList.add(new GradStudent ("가",20,Student.FEMALE,"컴정",80,"it"));
		gList.add(new GradStudent ("나",26,Student.MALE,"컴정",100,"it"));
		gList.add(new GradStudent ("다",26,Student.MALE,"컴정",60,"it"));
		
		statistics.printList(gList);
		System.out.println();
	}

}
