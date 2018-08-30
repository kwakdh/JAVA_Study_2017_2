package suUp4_2;

public class STUDENTS {
	
	public static final int MALE =0;
	public static final int FEMALE =1;
	public static final int UNKNWON =2;
    
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	//정보은닉하는 이유는 바깥에서 사용하는것을 막기위해서 
	private String name;
	private int score;
	private int gender;
	
	public String toString(){
		return "name: "+name+" score: "+score+" gender: "+(gender==MALE?"남":(gender ==FEMALE? "여":"모름"));
	}
	
	//생성자
	public Person(String name,int score, int gender){
		this.name=name;
		this.score=score;
	     if(gender!=MALE && gender!=FEMALE){
	    	 gender = UNKNWON;
	     }
	     else 
		    this.gender=gender;
	}
	
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	

}
