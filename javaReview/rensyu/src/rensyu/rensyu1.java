package rensyu;

import java.util.Scanner;

public class rensyu1 {

	 // 키보드로부터 주민등록번호를 입력 받고,
		   // 1. 입력된 주민등록번호의 유효성 검사 기능
		   // 2. 생년월일 출력 -> 1977년 8월 40일
		   // 3. 나이 : 한국 나이, 만 나이 (날짜: Date)
		   // 4. 성별: 남성, 여성
		 
	
	//멤버변수 
	String sNumber=" ";
	int ssNumber;
	int year;
	int month;
	int day;
	short gender;
	short ageK; //만 나이 
	short age; //원래 나이
	
	//입력 받는 메서드 
	Boolean getValueFromKeyBoard(){
		System.out.println("주민등록 번호 입력하시오.");
		Scanner scan = new Scanner(System.in);
		String jumin = scan.nextLine();
	
		if(jumin.length()!=14){
			
			System.out.println("잘못 쳤습니다.");
		    return false;
		    
		}else{
				String jumin2[]= jumin.split("-"); 
				sNumber =jumin2[0]+jumin2[1];
				
				return true;
		}	
	}
	
	//유효성 검사 
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
	    	System.out.println(sNumber + "는 유효한 주민번호 입니다.");
	    return true;
	    }else{
	    	System.out.println("잘못된 주민번호 입니다.");
	    	return false;
	    }
	}
	
	Boolean ageCheck(){
		
		char ch=0;
		ch = sNumber.charAt(6);
		
		// 성별 체크
		if(ch=='1'||ch=='3'){
			System.out.println("남자 입니다");
		}else{
			System.out.println("여자 입니다");
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
	
		
		
		//생년월일 나타내기 
		if(ch=='1' && ch1<=9||ch=='2' && ch1<=9){
			
			System.out.println(19+ch1+ch2+"년 "+ ch3+ch4+"월" +ch5+ch6+"일");
			
			
		}else if(ch =='3' && ch1<=9||ch=='4' && ch1<=9){
			System.out.println(20+ch1+ch2+"년 "+ ch3+ch4+"월" +ch5+ch6+"일");
		
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
