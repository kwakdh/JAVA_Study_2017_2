package genericRensyu;

public class student implements Comparable<student> {

	public static final int MALE =0;
	public static final int FEMALE =1;
	public static final int UNKNWON =2;
	
	private String name;
	private int age;
	private int gender;
	private String dept;
	private int score;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getGender() {
		return gender;
	}
	public String getDept() {
		return dept;
	}
	public int getScore() {
		return score;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public student(String name,int age,int gender,String dept,int score){
		this.name=name;
		this.age=age;
		if(gender!=MALE&&gender!=FEMALE){
			gender=UNKNWON;
		}
		else this.gender=gender;
		this.dept=dept;
		this.score=score;
			
	}
	
	public String toString(){
		return "이름: "+name+"나이: "+age+"성별: "+
	     (gender==MALE?"남":(gender==FEMALE? "여":"모름"))+"dept: "+dept+"성적: "+score;
	}
	@Override
	public int compareTo(student o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
