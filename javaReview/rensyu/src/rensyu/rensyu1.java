package rensyu;

import java.util.Scanner;

public class rensyu1 {

	 // Ű����κ��� �ֹε�Ϲ�ȣ�� �Է� �ް�,
		   // 1. �Էµ� �ֹε�Ϲ�ȣ�� ��ȿ�� �˻� ���
		   // 2. ������� ��� -> 1977�� 8�� 40��
		   // 3. ���� : �ѱ� ����, �� ���� (��¥: Date)
		   // 4. ����: ����, ����
		 
	
	//������� 
	String sNumber=" ";
	int ssNumber;
	int year;
	int month;
	int day;
	short gender;
	short ageK; //�� ���� 
	short age; //���� ����
	
	//�Է� �޴� �޼��� 
	Boolean getValueFromKeyBoard(){
		System.out.println("�ֹε�� ��ȣ �Է��Ͻÿ�.");
		Scanner scan = new Scanner(System.in);
		String jumin = scan.nextLine();
	
		if(jumin.length()!=14){
			
			System.out.println("�߸� �ƽ��ϴ�.");
		    return false;
		    
		}else{
				String jumin2[]= jumin.split("-"); 
				sNumber =jumin2[0]+jumin2[1];
				
				return true;
		}	
	}
	
	//��ȿ�� �˻� 
	Boolean validValue(){
		
		int check[] ={2,3,4,5,6,7,8,9,2,3,4,5};
	    int total=0;
	    int temp=0;
	    int result=0;
	    
	    for(int i =0 ; i<check.length;i++){
	    	total=total+((sNumber.charAt(i)-48)*check[i]);
	    }
	    temp= 11-(total%11);
	    result = temp%10;
	    
	    if(result == Integer.parseInt(sNumber.substring(12))){
	    	System.out.println(sNumber + "�� ��ȿ�� �ֹι�ȣ �Դϴ�.");
	    return true;
	    }else{
	    	System.out.println("�߸��� �ֹι�ȣ �Դϴ�.");
	    	return false;
	    }
	}
	
	Boolean ageCheck(){
		
		char ch=0;
		ch = sNumber.charAt(6);
		
		// ���� üũ
		if(ch=='1'||ch=='3'){
			System.out.println("���� �Դϴ�");
		}else{
			System.out.println("���� �Դϴ�");
		}
        
		
		char ch1=0;
		char ch2=0;
		
		ch1=sNumber.charAt(0);
		ch2=sNumber.charAt(1);
		
		char ch3=0;
		char ch4=0;
		
		ch3=sNumber.charAt(2);		
		ch4=sNumber.charAt(3);
		
		char ch5=0;
		char ch6=0;
	
		ch5=sNumber.charAt(4);		
		ch6=sNumber.charAt(5);
	
		
		
		//������� ��Ÿ���� 
		if(ch=='1' && ch1<=9||ch=='2' && ch1<=9){
			
			System.out.println(19+ch1+ch2+"�� "+ ch3+ch4+"��" +ch5+ch6+"��");
			
			
		}else if(ch =='3' && ch1<=9||ch=='4' && ch1<=9){
			System.out.println(20+ch1+ch2+"�� "+ ch3+ch4+"��" +ch5+ch6+"��");
		
		}
		
		return true;
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		  
	 rensyu1 ren = new rensyu1();
	 
	 ren.getValueFromKeyBoard();
	 ren.validValue();
	 ren.ageCheck();	
	
	

	

	
	
	
		
		
		
	}

}
