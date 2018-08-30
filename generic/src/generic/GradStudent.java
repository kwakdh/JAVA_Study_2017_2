package generic;

public class GradStudent extends Student {
    private String major;
	public GradStudent(String name, int age, int gender,
			String dept, int score ,String major) {
		super(name, age, gender, dept, score);
		this.major=major;
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return super.toString()+" : "+major;
	}
	

}
