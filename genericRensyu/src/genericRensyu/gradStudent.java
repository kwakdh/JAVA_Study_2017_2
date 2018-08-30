package genericRensyu;

public class gradStudent extends student implements Comparable<student>{
    private Major major;
	
    public gradStudent(String name, int age, int gender,
			String dept, int score ,Major major) {
		super(name, age, gender, dept, score);
		this.major=major;
	}
	
	public String toString(){
		return super.toString()+"Àü°ø: "+major;
	}

	@Override
	public int compareTo(student o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
