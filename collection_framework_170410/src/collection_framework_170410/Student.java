package suUp4_2;

public class Student extends Person implements Comparable<Student>{
 
	private String dept;
	private int score;
	
	public String toString(){
		
		return super.toString()+" dept: "+dept+" score: "+score;
	}
	
	public Student(String name, int age, int gender, String dept, int score){
		 super(name,age,gender);  //부모에게 넘겨주기 
		 this.dept=dept; //내 꺼
		 this.score=score; //내 꺼 
	 }
	
	public String getDept() {
		return dept;
	}

	public int getScore() {
		return score;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	
	@Override
	public int compareTo(Student arg0) {
		// TODO Auto-generated method stub
		return this.score-arg0.score; //점수순으로 오름차순 !!!
	}




}
