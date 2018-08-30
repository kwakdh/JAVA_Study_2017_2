package awtprj;

public class Student extends Member{
	
	private int id;
	private String classRoom;
	
	
   public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(String name, String age, String sex, String addr) {
		super(name, age, sex, addr);
		// TODO Auto-generated constructor stub
	}


public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getClassRoom() {
		return classRoom;
	}


	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}


}
