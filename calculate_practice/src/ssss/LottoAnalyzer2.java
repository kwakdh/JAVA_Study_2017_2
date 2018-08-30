package ssss;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class FileProcessor {
   FileReader       fr;
   
   FileProcessor(String argFileName) {
      try {
         fr   = new FileReader(argFileName);
      } catch (IOException e)
      {
         e.printStackTrace();
      }
   }
   
   String getNextLine() {
      String  readLine = "";
      int    readChar = 0;
      try {
         while(readChar != -1 && readChar != 10) {
            readChar = fr.read();
            readLine += (char)readChar;
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return readLine;
      
   }

public String[] split(String string) {
	// TODO Auto-generated method stub
	return null;
   }

public FileProcessor replaceAll(String string, String string2) {
	// TODO Auto-generated method stub
	return null;
}

public String FileProcessor() {
	// TODO Auto-generated method stub
	return null;
}
}
//--------------------------------------------------------//
//--------------------------------------------------------//
//--------------------------------------------------------//
class LottoResult {
   // 멤버변수 
   
   int   seq;// 회차
   static final int MAX_LOTTO_NUM = 6;
   //int   lottoNums[]= new int[MAX_LOTTO_NUM];// 번호 6자리
 
   private static final String Boolean = null;
   
   // 생성자
/*   LottoResult(int argSeq, int argNums[]) {
      lottoNums = new int[6];
      
      seq = argSeq;
      for(int iCount = 0 ; iCount < MAX_LOTTO_NUM ; iCount++){
         lottoNums[iCount] = argNums[iCount];
         }
      }*/
   }


public class LottoAnalyzer2 {
	
	
	 // "lotto.txt"을 읽어 회차별 당첨 번호를 자료로 구성하라.
	   //멤버변수 
	   final static int MAX_LOTTO_NUM2 = 6;//로또 넘버 최대치
	   final static int LOTTO_numberOfTrials = 738;//로또 시행 총 횟수
	   final static int LOTTO_numlast = 45;//로또 마지막 번호까지 다 담음
	   static int lottoNum[]=new int[LOTTO_numberOfTrials*MAX_LOTTO_NUM2];
       String temp[]=new String[MAX_LOTTO_NUM2]; 

	   static String lottoHC[]=new String[LOTTO_numberOfTrials]; //회차 
	   String InputValue;
  
   
   /* LottoResult lottoResults[];
   //생성자
   LottoAnalyzer(int argSeq) {
      lottoResults = new LottoResult[argSeq];
   }  */
   

   
   // 1 ~ 45까지 숫자 중 발생 빈도가 높은 순으로 정렬해 출력-------------------------
   
	   
    void printNumsOrderByDesc() {
	 
	 int count[]= new int[LOTTO_numlast];
     int j=0;  
	
     for(int i=0;i<LOTTO_numberOfTrials*MAX_LOTTO_NUM2;i++){
		     j=lottoNum[i]-1;
			 count[j]++; 
	 } 
     
     

	 //높은 순서대로 출력하기 
	  for(int i=0;i<45;i++)
		 System.out.println(i+1+"수 는 "+count[i]+"번 나옴.");

   }
   
   // 당첨번호 확인-----------------------------------------------------
  int checkLottoNums(int argNums[]) {
      // 입력 1 2 3 4 5 6
	   
	   Scanner scan = new Scanner(System.in);
       System.out.println("번호 입력하세요~(스페이스 기준)");
       InputValue= scan.nextLine();
       String list[] = InputValue.split(" ");
       int LOTTO[]=new int[MAX_LOTTO_NUM2];
       
       //입력받은 문자열을 정수로 쪼개서 배열 넣기 
       for(int i=0;i<MAX_LOTTO_NUM2;i++){
    	   LOTTO[i]=Integer.valueOf(list[i]);
       }
       
       for(int i=0;i<MAX_LOTTO_NUM2;i++){
    	   for(int j=0;j<LOTTO_numberOfTrials*MAX_LOTTO_NUM2;j++){
    		
    		   
    	   }
    	   
       }
       
      // 입력 값이 로또 결과 값으로 있으면 회차 번호 출력
      // 없으면 -1
      return 0;
  }
  
   // 특정회차 당첨번호 출력-----------------------------------------------
   void printNumsBySeq(int argSeq) {
      
   }
   
   // 특정 숫자에 대한 발생 확률값 출력---------------------------------------
   void printProbForNum(int argNum) {
         
   }
   
   // 로또번호 생성하기-----------------------------------------------------
   void generateLottoNum() {
      
   }
   
   // 발생 빈도를 기준으로 히스토그램 출력---------------------------------------
   void printHistogram() {
      
   }
   
   public static void main(String args[]) {
	 
	   FileProcessor fp = new FileProcessor("C:\\lotto.txt.txt");
      
      // LottoResult 객체 생성 후 값 초기화
      // lottoResults[i] = new LottoResult();

          String FP;      
          String FP2;
          
       // Parsing
       // 공백을 기준으로 문자 자르기 split
       // 문자 -> 정수로 변환   
         
        for(int i=0 ; i<LOTTO_numberOfTrials*MAX_LOTTO_NUM2 ;){ 
        	FP=fp.getNextLine(); 	    
        	FP= FP.replaceAll("\r\n", ""); 
        	 String list[] = FP.split("	");
        	 for(int j=0 ; j<MAX_LOTTO_NUM2 ; j++,i++)
        		 lottoNum[i]=Integer.valueOf(list[j]);
        	      
        }
        
       for(int i=0;i<LOTTO_numberOfTrials;){
        	for(int j=0;j<MAX_LOTTO_NUM2;j++,i++)

            System.out.print(lottoNum[i] +"\t");
        	System.out.println();
        
        }
       
          
     //스트링 배열로 회차 출력     
       
     for(int i=LOTTO_numberOfTrials-1;i>=0;i--){ 
        
        FP2=fp.getNextLine(); 	    
        FP2= FP2.replaceAll("\r\n", ""); 
        lottoHC[i]=FP2;
        	           
       }
       
     /*   for(int i1=0 ; i1<LOTTO_numberOfTrials;i1++){
              System.out.println(lottoHC[i1]);
        }
       */
       
        
      /*스트링 쪼가르는거 공부~
          String ddd ="1	2	3	4	5	6";
          String ddd2 ="abcdefg";
          String ddd3 =ddd+ddd2;
          String list[]=ddd.split(".");
          
          System.out.println(ddd3);
          for(int i=0;i<list.length;i++)
        	  System.out.println(list[i]);
   */  
     
     
              
          LottoAnalyzer2 val= new LottoAnalyzer2();
          
         // val.printNumsOrderByDesc(); 
         // val.checkLottoNums(int argNums[]);
         // val.printNumsBySeq(int argSeq);
         // val.printProbForNum(argNum);
         // val.generateLottoNum(); 
         // val.printHistogram();
          
     }
       
  }
  
