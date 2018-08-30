package generic;

public class Student {

	public static final int MALE =0;
	public static final int FEMALE =0;
	public static final int UNKWON =0;
	
	private String name;
	private int age;
	private int gender;
	private String dept;
	private int score;
	
	public Student(String name,int age,int gender,String dept,int score){
		
	this.name=name;
	this.age=age;
	if(gender!=MALE&&gender!=FEMALE){
		gender=UNKWON;
	}else
		this.gender=gender;
	this.dept=dept;
	this.score=score;
	
	}
	
	
	public String toString(){
		return name+" : "+age+" : "
	    +(gender==MALE? "남":(gender==FEMALE ?"여":"모름"))+" : "+
				dept+" : "+score;
	}


	public static int getMale() {
		return MALE;
	}


	public static int getFemale() {
		return FEMALE;
	}


	public static int getUnkwon() {
		return UNKWON;
	}


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
	
	
	
}
