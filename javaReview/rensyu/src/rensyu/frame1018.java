package rensyu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
// oracle회사 홈페이지 
// 1. Frame을 제일 먼저 만들어준다. -> 하나하나 다 만들 수는 있다. 하지만 귀찮타. 
// -> 그래서 Frame 상속을 받아서 바꾼다.
// Awt(단점.운영체제에 종속적이다.)  / Swing(awt를 상속받아 만든것) / f(x)    
// 책 ( PowerJAVA / 명품JAVA )

//리다이엑션으로 파일로 간다.


//마우스리스너안에 메서드가 5개 있다는 것은 스윙이 정의 한 것이다.
class cyka implements  MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		JOptionPane.showConfirmDialog(null, "cyka");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}


class myFrame extends JFrame {   // 기본적으로 Frame하나는 만들어졌음.
	
   myFrame() {
      this.setTitle("ckya");  //super("cyka");     // 창 이름.
      // Dimention d = this.getMaximumsize();
      // this.setSize(d);
      this.setSize(500,500);                                 // 창 크기.
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // 창 닫기 설정.
      this.setVisible(true);                                 // 창 보이기.
     
      JButton myBtn = new JButton("--눌러바--");      
      // 모든 컴퍼넌트는 이벤트를 가진다. -> 버튼이 클릭될 시 event를 버튼에다가 같이붙여야한다.
      // MouseListener형을 넘겨주어야한다. -> 익명클래스
      
      //버튼이 클릭 되었을 때 뭔가 수행되길 바란다면 그것을 인터페이스로 줄게
      //인터페이스(MouseListner)--->자바가 만듦, swing이 불러 씀 
      //이 인터페이스를 가지고 swing입장을 -->버튼이 클릭되면 
      
      
      //그 인터페이스에서 사용할만한 메서드가 존재 할 때 가져 온다. 
      //인터페이스 껍데기만 존재하니 5개의 메서드를 줄테니 너네 클래스에 안에 다 구현시켜줘
      //넘겨줄때는 인터페이스 형으로 넘겨주라 ~ !@@
     
      
      cyka myCyka = new cyka(); //마우스 리스너로 감싸진 객체 임 
      myBtn.addMouseListener(myCyka);//수카 자체를 마우스 리스너라는 인터페이스 형으로 등록했기때문에
                                     //넘겨 주는 것이 가능하다 ! 
      
     
      myBtn.addMouseListener(new MouseListener() {
         // addMouseListener : MouseListener 이벤트를 객체에 붙이는 역할. 
         // MouseListener안에 있는 추상 메서드르 모두 구현해야댐.
         
         
         // addMouseListener에서 넘어가는것은 익명객체형 ) 넘어갈 수 있는 이유
         // 인터페이스를 쓰는 이유 
         // class와 동급 / 인터페이스 이름 {  } / 상수, 추상메서드, Default메서드
         // 미완성메서드 (abstract) -> 메서드의 머리 있는데 그안에 내용은 X
         // 인터페이스는 객체로 생성할 수없는데 익명클래스를 이용해 객체로 생성할 수 있습니다.
         // 상수, 추상메서드, Default
         // implement 생략. 
         // 1. 익명객체는 단독으로 생성할 수 없고, 클래스를 상속받거나 인터페이스를 구현해야만 생성할수 있습니다.
         // 인터페이스를 구현할 경우 그안의 모든 메서드들을 구현시켜야 하는데. 여기서 구현시켜주지않아서 Error.
         // 2. MouseListener인터페이스안에 있는 MouseClicked라는 메서드를 사용하기 위해서.
      });
      this.add(myBtn);      // Frame에 붙여아한다. 
   }
}

public class frame1018 {
   public static void main(String[] args) {
      new myFrame(); // 하면 아무것도 나오지 않는다. 설정을 하지 않았기 때문에. -> 8번라인에서 설정해줌.

   }
}