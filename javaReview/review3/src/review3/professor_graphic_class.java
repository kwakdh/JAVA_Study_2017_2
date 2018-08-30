package review3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    // 스윙에서는 gui가 [컴포넌트] 단위!!!!
	// 그림을 다시그려주기위한 컴포넌트 ? 페인트 컴포넌트... ! 
	
	// 창이 없어질 경우 ....?! 초기화 된당....(메모리상에서 사라짐)
	// 자바 jvm에서 페인트 컴포넌트 호출해라 ~~~~
	// 프레임 -> 패널 -> 컴포넌트 
	// 그림을 그리기 위해서는...? graphics객체가 필요함! 
	// 각각의 컴포넌트 마다 그래픽 객체가 있다. 
	// 
	
    //선그리기......?!?!??!?!?
    // 클릭드(현재위치), 프레스드,릴리즈(마지막위치) 
   class btnYCButton extends JButton {
	   
      btnYCButton (String args) {
         super(args);
      }
      
      @Override
      protected void paintComponent(Graphics g) { //버튼 안에 그려줌 ! 
         // TODO Auto-generated method stub
         super.paintComponent(g);
         g.drawLine(10, 10, 80, 80);
      }
   }

   class myFrame extends JFrame {
      private JPanel leftPanel;
      private JPanel rightPanel;
      private JButton buttonCliked ;
      private Color btnColor;
      private JButton btn1;
      private JButton btn2;
      private JButton btn3;
      //이너클래스 !!!!!!!!!!!!!!!!!!!!! 내부에서 외부 접근 가능 !
      class rightPanelC extends JPanel {   
    	   
    	  rightPanelC(){
    		  this.addMouseListener(new MouseAdapter(){
    			  public void mouseClicked(MouseEvent e) {  
    				 //사각형을 그려라
    				 //사각형은 drawRect(x,y,가로,세로) 
    				  
    				  Graphics g= rightPanel.getGraphics();
    				  g.drawRect(e.getX()-50, e.getY()-50, 100, 100);
    			  }
    		  });
    	  }
    		
    		
          /*static int count = 0;
          @Override
          protected void paintComponent(Graphics g) {  //그려주는 역할
             // TODO Auto-generated method stub
             super.paintComponent(g);
             System.out.println(count++);
          }*/
          
       }

      
      
      
      
      myFrame() {
         //프레임 안쪽을 pane이라고 한다...!--------getContentPane
    	 //팬 을 가져와야 팬 안에 레이아웃을 설정할 수있당.
    	 this.getContentPane().setLayout(new GridLayout(0, 2));
         leftPanel = new JPanel();
         rightPanel = new rightPanelC(); 
         // 그림그릴때 여러 정보가 들어간다..
         /// 여러 변수가 들어갈 필요가 있기 때문에 rightPanelC라는 클래스를 생성해서 넣기
         this.add(leftPanel); //컴포넌트 추가는 add
         this.add(rightPanel);
         
         leftPanel.setLayout(new GridLayout(3, 0));
         btn1  =new JButton("선");
         btn2  =new JButton("사각형");
         btn3  = new JButton( "원");
         btnColor= btn1.getBackground();
         btnColor= btn2.getBackground();
         btnColor= btn3.getBackground();
         leftPanel.add(btn1);
         leftPanel.add(btn2);
         leftPanel.add(btn3);
         /*btn1.addMouseListener(new MouseAdapter() {
            
        	 @Override
            public void mouseClicked(MouseEvent e) {  //버튼 밖에 그려줌! 
               Graphics g = rightPanel.getGraphics(); //패널 안 컴포넌트 컴포넌트 안 getGraphics존재 draw하기 위해서 ! 
               g.drawLine(10, 10, 80, 80); // 시작점 x축 y축 // 끝점 x축 y축
               
            }
            
         });*/
         
         //선
         btn1.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e) {  //버튼 밖에 그려줌! 
        		//buttonCliked
        		//이벤트도 객체다... 객체로넘어오면서 여러가지 부가적 멤버들이 온다.
        		// 그중에 겟소스.. 겟소스는 현재이벤트가 발생한 객체의 주소 !
           if(e.getSource()!=buttonCliked){
        		btn1.setBackground(Color.orange);
        		//검사 : 이전에 버튼이 클릭되어 졌는가...?
               if(buttonCliked!= null){ //널이 아니면 클릭이되어있다는 말..
            	// 클릭이 되었다면... 원래 색깔로 회귀
            	   buttonCliked.setBackground(btnColor);
               }
        		
        		buttonCliked = (JButton)e.getSource();
             }
        	}
         });
         
         
         btn2.addMouseListener(new MouseAdapter(){
        	 public void mouseClicked(MouseEvent e) {  //버튼 밖에 그려줌! 
           if(e.getSource()!=buttonCliked){
        		btn2.setBackground(Color.orange);
        		if(buttonCliked!= null){ //널이 아니면 클릭이되어있다는 말..
                	// 클릭이 되었다면... 원래 색깔로 회귀
                	   buttonCliked.setBackground(btnColor);
                   }
        		buttonCliked = (JButton)e.getSource();
             }
        	} 
        	// 버튼을 눌렀을 경우 오른쪽 패널에 사각형 그릴 준비가 된다.
        	// 오른쪽 패널에 커서가 움직여짐.
        	// 드로잉을 하면 사각형이 그려진다. 
        	 
         }); 
         
         btn3.addMouseListener(new MouseAdapter(){
        	 public void mouseClicked(MouseEvent e) {  //버튼 밖에 그려줌! 
                 if(e.getSource()!=buttonCliked){
              		btn3.setBackground(Color.orange);
              		if(buttonCliked!= null){ //널이 아니면 클릭이되어있다는 말..
                    	// 클릭이 되었다면... 원래 색깔로 회귀
                    	   buttonCliked.setBackground(btnColor);
                       }
              		buttonCliked = (JButton)e.getSource();
                   }
              	} 
        	 
        	 
         });
         
         this.setTitle("ㅋㅋㅋㅋ");
         this.setSize(500, 400);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
      }
      
     /* JButton addButton(JPanel panel, String titleOfBtn){
         btnYCButton btn = new btnYCButton(titleOfBtn);
         panel.add(btn1);    
         panel.add(btn2); 
         panel.add(btn3); 
         return btn;
      }*/

   }

   public class professor_graphic_class {
      public static void main(String args[]) {
         new myFrame();
      }
   }