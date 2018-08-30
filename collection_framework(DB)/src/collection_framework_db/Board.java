package suUp4_3;

import java.sql.Timestamp;

public class Board {
/*
 * create table board (
   bno int primary key auto_increment, 
   writer varchar(32) not null, 
   title varchar(32) not null, 
   content varchar(2048) not null, 
   regDate timestamp default now(), 
   viewCnt int default 0
)
 */
   /*
    * data�� ��� ���� ��ü��
    * JavaBean ��ü�� �Ѵ�. 
    * ����������� private�� ������
    * �׵鿡 �����ϱ� ����
    * set, get �޼ҵ���� public���� ������ Ư¡�� 
    * �ִ�.
    */
   private int bno;
   private String writer;
   private String title;
   private String content;
   private Timestamp regDate;
   private int viewCnt;
   
   public Board() {
      
   }
   
   public Board(String writer, String title, String content) {
      this.writer = writer;
      this.title = title;
      this.content = content;
   }
   
   public String toString() {
      return "bno:"+bno+", writer:"+ writer+", title:"+title+", content:"+content;
   }
   
   public int getBno() {
      return bno;
   }
   public void setBno(int bno) {
      this.bno = bno;
   }
   public String getWriter() {
      return writer;
   }
   public void setWriter(String writer) {
      this.writer = writer;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
}}