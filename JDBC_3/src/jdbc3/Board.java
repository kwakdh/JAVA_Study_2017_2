package jdbc3;

import java.sql.*;

public class Board {
   //bno, writer, title, content, regDate, viewCnt
	
	private int bno;
	private String writer;
	private String title;
	private String content;
	private Timestamp regDate;
	private int viewCnt;
	
	public Board(){
	}
	public String toString(){
		return bno +", "+ writer+", "+title+", "+content;
	}
	public Board(int b, String w, String t, String c, Timestamp r,int v){
		
		bno=b;
		writer =w;
		title=t;
		content =c;
		regDate = r;
		viewCnt = v;
		
		
	}
	public int getBno() {
		return bno;
	}
	public String getWriter() {
		return writer;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	
	
	
	
}
