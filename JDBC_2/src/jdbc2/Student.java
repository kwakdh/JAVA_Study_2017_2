package jdbc2;

import java.sql.Timestamp;

public class Student {

	/*
	 * create table student(
	 *  sid varchar(10) primary key,
	 *  name varchar(32) not null,
	 *  dept varchar(32) null,
	 *  major varchar(32) null,
	 *  phone varchar(32) null,
	 *  entYear int not null )
	 * )
	 * 
	 * */
	
	
	private String sid;
	private String  name;
	private String dept;
	private String major;
	private String phone;
	private int entYear;
	
	
	public Student(String sid, String name,String dept, String major,
			String phone, int entYear){
		
		this.sid=sid;
		this.name=name;
		this.dept=dept;
		this.major=major;
		this.phone=phone;
		this.entYear=entYear;
		
	}
	public String toString(){
		return sid+", "+name+","+dept+","+major+","+phone+","+entYear;
	}
	
	public Student(){}
	public Student(String[] sArr){
	
		
		
		setSid(sArr[0]);
		setName(sArr[1]);
		setDept(sArr[2]);
		setMajor(sArr[3]);
		setPhone(sArr[4]);
	    setEntYear(Integer.parseInt(sArr[5]));
		
	}
	
	public Student(String s){
		
		String[] sArr = s.split(",");
		setSid(sArr[0]);
		setName(sArr[1]);
		setDept(sArr[2]);
		setMajor(sArr[3]);
		setPhone(sArr[4]);
	    setEntYear(Integer.parseInt(sArr[5]));
		
	}
	
	public String getSid() {
		return sid;
	}
	public String getName() {
		return name;
	}
	public String getDept() {
		return dept;
	}
	public String getMajor() {
		return major;
	}
	public String getPhone() {
		return phone;
	}
	public int getEntYear() {
		return entYear;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEntYear(int entYear) {
		this.entYear = entYear;
	}
	
	
	
	
	
	
	
}
