package review3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    // ���������� gui�� [������Ʈ] ����!!!!
	// �׸��� �ٽñ׷��ֱ����� ������Ʈ ? ����Ʈ ������Ʈ... ! 
	
	// â�� ������ ��� ....?! �ʱ�ȭ �ȴ�....(�޸𸮻󿡼� �����)
	// �ڹ� jvm���� ����Ʈ ������Ʈ ȣ���ض� ~~~~
	// ������ -> �г� -> ������Ʈ 
	// �׸��� �׸��� ���ؼ���...? graphics��ü�� �ʿ���! 
	// ������ ������Ʈ ���� �׷��� ��ü�� �ִ�. 
	// 
	
    //���׸���......?!?!??!?!?
    // Ŭ����(������ġ), ��������,������(��������ġ) 
   class btnYCButton extends JButton {
	   
      btnYCButton (String args) {
         super(args);
      }
      
      @Override
      protected void paintComponent(Graphics g) { //��ư �ȿ� �׷��� ! 
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
      //�̳�Ŭ���� !!!!!!!!!!!!!!!!!!!!! ���ο��� �ܺ� ���� ���� !
      class rightPanelC extends JPanel {   
    	   
    	  rightPanelC(){
    		  this.addMouseListener(new MouseAdapter(){
    			  public void mouseClicked(MouseEvent e) {  
    				 //�簢���� �׷���
    				 //�簢���� drawRect(x,y,����,����) 
    				  
    				  Graphics g= rightPanel.getGraphics();
    				  g.drawRect(e.getX()-50, e.getY()-50, 100, 100);
    			  }
    		  });
    	  }
    		
    		
          /*static int count = 0;
          @Override
          protected void paintComponent(Graphics g) {  //�׷��ִ� ����
             // TODO Auto-generated method stub
             super.paintComponent(g);
             System.out.println(count++);
          }*/
          
       }

      
      
      
      
      myFrame() {
         //������ ������ pane�̶�� �Ѵ�...!--------getContentPane
    	 //�� �� �����;� �� �ȿ� ���̾ƿ��� ������ ���ִ�.
    	 this.getContentPane().setLayout(new GridLayout(0, 2));
         leftPanel = new JPanel();
         rightPanel = new rightPanelC(); 
         // �׸��׸��� ���� ������ ����..
         /// ���� ������ �� �ʿ䰡 �ֱ� ������ rightPanelC��� Ŭ������ �����ؼ� �ֱ�
         this.add(leftPanel); //������Ʈ �߰��� add
         this.add(rightPanel);
         
         leftPanel.setLayout(new GridLayout(3, 0));
         btn1  =new JButton("��");
         btn2  =new JButton("�簢��");
         btn3  = new JButton( "��");
         btnColor= btn1.getBackground();
         btnColor= btn2.getBackground();
         btnColor= btn3.getBackground();
         leftPanel.add(btn1);
         leftPanel.add(btn2);
         leftPanel.add(btn3);
         /*btn1.addMouseListener(new MouseAdapter() {
            
        	 @Override
            public void mouseClicked(MouseEvent e) {  //��ư �ۿ� �׷���! 
               Graphics g = rightPanel.getGraphics(); //�г� �� ������Ʈ ������Ʈ �� getGraphics���� draw�ϱ� ���ؼ� ! 
               g.drawLine(10, 10, 80, 80); // ������ x�� y�� // ���� x�� y��
               
            }
            
         });*/
         
         //��
         btn1.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e) {  //��ư �ۿ� �׷���! 
        		//buttonCliked
        		//�̺�Ʈ�� ��ü��... ��ü�γѾ���鼭 �������� �ΰ��� ������� �´�.
        		// ���߿� �ټҽ�.. �ټҽ��� �����̺�Ʈ�� �߻��� ��ü�� �ּ� !
           if(e.getSource()!=buttonCliked){
        		btn1.setBackground(Color.orange);
        		//�˻� : ������ ��ư�� Ŭ���Ǿ� ���°�...?
               if(buttonCliked!= null){ //���� �ƴϸ� Ŭ���̵Ǿ��ִٴ� ��..
            	// Ŭ���� �Ǿ��ٸ�... ���� ����� ȸ��
            	   buttonCliked.setBackground(btnColor);
               }
        		
        		buttonCliked = (JButton)e.getSource();
             }
        	}
         });
         
         
         btn2.addMouseListener(new MouseAdapter(){
        	 public void mouseClicked(MouseEvent e) {  //��ư �ۿ� �׷���! 
           if(e.getSource()!=buttonCliked){
        		btn2.setBackground(Color.orange);
        		if(buttonCliked!= null){ //���� �ƴϸ� Ŭ���̵Ǿ��ִٴ� ��..
                	// Ŭ���� �Ǿ��ٸ�... ���� ����� ȸ��
                	   buttonCliked.setBackground(btnColor);
                   }
        		buttonCliked = (JButton)e.getSource();
             }
        	} 
        	// ��ư�� ������ ��� ������ �гο� �簢�� �׸� �غ� �ȴ�.
        	// ������ �гο� Ŀ���� ��������.
        	// ������� �ϸ� �簢���� �׷�����. 
        	 
         }); 
         
         btn3.addMouseListener(new MouseAdapter(){
        	 public void mouseClicked(MouseEvent e) {  //��ư �ۿ� �׷���! 
                 if(e.getSource()!=buttonCliked){
              		btn3.setBackground(Color.orange);
              		if(buttonCliked!= null){ //���� �ƴϸ� Ŭ���̵Ǿ��ִٴ� ��..
                    	// Ŭ���� �Ǿ��ٸ�... ���� ����� ȸ��
                    	   buttonCliked.setBackground(btnColor);
                       }
              		buttonCliked = (JButton)e.getSource();
                   }
              	} 
        	 
        	 
         });
         
         this.setTitle("��������");
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