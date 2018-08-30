package review2;
// java.awt
import java.awt.*;
import java.awt.event.*;

// javax.swing
import javax.swing.*;

public class myFrame extends JFrame
{
 private String chkInput; // ���� ������ ������ üũ �� ���� (��������, �������� ���� �ϱ� ���� ����)
 private int numOne, sum, total, sosu; // ���Կ��꿡 �ʿ��� ���� (numOne, sum, total), �Ҽ����� �������� �����ϱ� ���� ���� (sosu)
 private int count = 0, inputChk = 0; // üũ�� ����(count), ������ ������ ���� (��������, �������� ���� �ϱ� ���� ����)
 private final String names[] = {"7", "8", "9", "-", "4", "5", "6", "+", "1", "2", "3", "*", "0", ".", "=", "/"}; // Ű �е� �迭
 private JTextField inputText;
 Font font2 = new Font("���", Font.BOLD, 50);
	
 /*
  * ������ ���̾ƿ� �޼ҵ�
  */
 public myFrame()
 {
  super("����");
  
  BorderLayout layout = new BorderLayout(2, 2); // ����, ���� ������ �� 2, 2 �� �����Ѵ�.
  setLayout(layout); // �������� ���̾ƿ��� �����Ѵ�.
  
  
  JPanel groupPanel = new JPanel(new BorderLayout(5, 2));
  
  JLabel title = new JLabel("Swing ���� ������ ����", SwingConstants.CENTER); // Ÿ��Ʋ �� ����
  groupPanel.add(title, BorderLayout.NORTH);
   
  inputText = new JTextField("", SwingConstants.CENTER); // ����� �Է��� �޴� �ؽ�Ʈ �ʵ�
  inputText.setHorizontalAlignment(JTextField.RIGHT); // ������Ʈ�� ������ ���� ��Ų��.
  
  groupPanel.add(inputText, BorderLayout.CENTER);
  
  
  JPanel padPanel = new JPanel(new GridLayout(4, 4)); // Ű �е尡 �迭�� ���� 4, ���� 4 ���� ��ġ �� �� �ְ� GridLayout �� ���� 4,4 �� ���̾ƿ� �����Ѵ�.
  
  JButton buttons[] = new JButton[names.length]; // Ű�е� �迭 ����
  
  for(int count = 0; count < names.length; count++)
  {
   buttons[count] = new JButton(names[count]);
   padPanel.add(buttons[count]).setFont(font2);;
   
   PadInput handler = new PadInput(); // Ű�е� �̺�Ʈ�� �߻� ��Ű�� ���� handler ����
   buttons[count].addActionListener(handler); // �̺�Ʈ ���
  }
  
  /*
   * �ϴ� Ŭ���� ��ư �� ������ View
   */
  JPanel infoView = new JPanel(new BorderLayout(2, 4));
  
  JButton clear = new JButton("Clear"); // �Է� â�� Ŭ���� ��ų ��ư�� ����.
  infoView.add(clear, BorderLayout.NORTH);
  
  JLabel infoV = new JLabel("������ : windydh", SwingConstants.RIGHT);
  infoView.add(infoV, BorderLayout.CENTER);
  
  JLabel infoV2 = new JLabel("eMail : needcom@lycos.co.kr", SwingConstants.RIGHT);
  infoView.add(infoV2, BorderLayout.SOUTH);
  
  // Ÿ��Ʋ �󺧰�, �ؽ�Ʈ �ʵ带 ���� groupPanel�� ��ü �������� �ֻ�ܿ� ��ġ ��Ų��. 
  add(groupPanel, BorderLayout.NORTH);
  // ���� Ű�е� �г��� ��ü �������� �߰��� ��ġ ��Ų��.
  add(padPanel, BorderLayout.CENTER);
  add(infoView, BorderLayout.SOUTH);
  
  ClearButton handler = new ClearButton();
  clear.addActionListener(handler);
 }
 
 /*
  * Ű�е�(����)�� ������ ��� �ڵ鸵 �ϴ� ���� Ŭ����
  */
 private class PadInput implements ActionListener
 {
  public void actionPerformed(ActionEvent event)
  {
   String eventText = event.getActionCommand();
   
   
   if(eventText.equals("+")) // ���� ����
   {
    inputChk = 1;
   }
   else if(eventText.equals("-")) // ���� ����
   {
    inputChk = 2;
   }
   else if(eventText.equals("*")) // ���� ����
   {
    inputChk = 3;
   }
   else if(eventText.equals("/")) // ������ ����
   {
    inputChk = 4;
   }
   else if(eventText.equals("=")) // ����
   {
    inputChk = 5;
   }
   else
   {
    if(count == 1) // ���� �Է� �� �ؽ�Ʈ �ʵ忡 ���ο� ���ڰ� ��� �� ��� �ؽ�Ʈ �ʵ带 ����ֱ� ���� ī��Ʈ
    {
     inputText.setText("");
     count = 0;
    }
    
    inputText.setText(inputText.getText()+event.getActionCommand()); // ����ڰ� �Է��ϴ� ���ڸ� �����Ͽ� �ؽ�Ʈ �󺧿� ǥ���Ѵ�.
   }
   
   /*
    * ������ ���� ����
    */
   try
   {
    if((total != 0) && (inputChk <= 5)) // �����Է� ���� �����ȣ�� �������� ���� ��� ó��
    {
     inputText.setText(inputText.getText()); // �ؽ�Ʈ �󺧿� �ƹ��͵� ǥ�� ���� �ʴ´�.
    }
    else
    {
     if( inputChk == 1 ) // ���� ������ ���
     {
      numOne = Integer.parseInt(inputText.getText()); // numOne �Լ��� ù��° ���� �Է� �ϰ�
      total += numOne; // total ������ ���� �� 
      numOne = 0; // ���ο� ���� �ޱ����� numOne ������ �ٽ� �ʱ�ȭ �Ѵ�.
      
      inputText.setText(String.valueOf(total)); // �ؽ�Ʈ �󺧿��� ���� �׿� �ִ� total ���� �����ش�.
      
      count = 1; // ���ο� �ι�° ���� ���� �Է� �ϱ� ���� �ؽ�Ʈ ���� �ʱ�ȭ �Ѵ�.
      chkInput = "+"; // ���� �����ڸ� �����ϱ� ���� üũ ���� �Ѱ� ������ ���� �� �� �ְ� �Ѵ�.
     }
     else if( inputChk == 2 ) // ���� ������ ���
     {
      numOne = Integer.parseInt(inputText.getText());
      total += numOne;
      numOne = 0;
      
      inputText.setText(String.valueOf(total));
      
      count = 1;
      chkInput = "-";
     }
     else if( inputChk == 3 ) // ���� ������ ���
     {
      numOne = Integer.parseInt(inputText.getText());
      total += numOne;
      numOne = 0;
      
      inputText.setText(String.valueOf(total));
      
      count = 1;
      chkInput = "*";
     }
     else if( inputChk == 4 ) // ������ ������ ���
     {
      numOne = Integer.parseInt(inputText.getText());
      total += numOne;
      numOne = 0;
      
      inputText.setText(String.valueOf(total));
      
      System.out.println(" numBer ==> " + numOne);
      System.out.println(" total ==> " + total);
      
      count = 1;
      chkInput = "/";
     }
    }
   }
   catch(Exception e)
   {
    System.out.println(" Error ==> " + e);
   }
   
   /*
    * ���� ������ �����Ͽ� ���� ���Ѵ�.
    */
   if(total == 0) // �ƹ� �Է� ����( �� �ؽ�Ʈ �ʵ� ) ���� ������ �� ��� ó��
   {
    inputText.setText(inputText.getText()); // �ƹ��� ������ ������ ����.
   }
   else
   {
    if((inputChk == 5) && chkInput.equals("+")) // ���� ������ ��������, �װ��� ���� �� ���
    {
     numOne = Integer.parseInt(inputText.getText()); // ����  �ؽ�Ʈ �ʵ忡 �����ִ� ���� �����´�.
     sum = numOne + total; // ���� �ؽ�Ʈ �ʵ忡 �ִ� ���ڿ� �����Ǿ� �ִ� total ���� ���� ���� �Ѵ�.
     
     count = 1;
     numOne = 0;
     total = 0;
     inputText.setText(String.valueOf(sum)); // �ؽ�Ʈ �󺧿� ���� sum ������� �����ش�.
     //sum = 0;
    }
    else if((inputChk == 5) && chkInput.equals("-")) // ���� ������ ��������, �װ��� ���� �� ���
    {
     System.out.println("bbb");
     numOne = Integer.parseInt(inputText.getText());
     sum = total - numOne;
     
     count = 1;
     numOne = 0;
     total = 0;
     inputText.setText(String.valueOf(sum));
     //sum = 0;
    }
    else if((inputChk == 5) && chkInput.equals("*")) // ���� ������ ��������, �װ��� ���� �� ���
    {
     System.out.println("ccc");
     numOne = Integer.parseInt(inputText.getText());
     sum = numOne * total;
     
     count = 1;
     numOne = 0;
     total = 0;
     inputText.setText(String.valueOf(sum));
    }
    else if((inputChk == 5) && chkInput.equals("/")) // ���� ������ ��������, �װ��� ������ �� ���
    {
     System.out.println("ddd");
     numOne = Integer.parseInt(inputText.getText());
     sum = total / numOne;
     
     count = 1;
     numOne = 0;
     total = 0;
     inputText.setText(String.valueOf(sum));
    }
   }
  }
 }
 
 /*
  * �Ҽ��� �ڸ� üũ
  */
 public void chkNum(String tField)
 {
  if(tField.i-dexOf(".") != -1) // tField �� �Ҽ����� ���� ���
  {
   sosu = 1;
  }
  else
  {
   sosu = 0;
  }
  return;
 }
 
 /*
  * Ŭ���� ��ư�� �ڵ鸵 �ϴ� ���� �͸� Ŭ����
  */
 private class ClearButton implements ActionListener
 {
  public void actionPerformed(ActionEvent event)
  {
   // Ŭ���� ��ư �� ��� ���� �Լ� �ʱ�ȭ
   inputText.setText("");
   numOne = 0;
   total = 0;
   sum = 0;
   count = 0;
   inputChk = 0;
  }
 }
 
 /*
  * ���⸦ ���� ��Ű�� �޼ҵ�
  */
 public static void main(String args[])
 {
  myFrame calStart = new myFrame(); // ��ü ����
  
  //calStart.pack(); // �ּ����� ������� �ڵ����� ������ ������ ����
  calStart.setSize(550, 550); // ���� �������� ������ ����
  calStart.setResizable(false);
  calStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���� ��� ���� ��Ŵ
  calStart.setVisible(true);
 }
}