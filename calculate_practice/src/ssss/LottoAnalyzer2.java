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
   // ������� 
   
   int   seq;// ȸ��
   static final int MAX_LOTTO_NUM = 6;
   //int   lottoNums[]= new int[MAX_LOTTO_NUM];// ��ȣ 6�ڸ�
 
   private static final String Boolean = null;
   
   // ������
/*   LottoResult(int argSeq, int argNums[]) {
      lottoNums = new int[6];
      
      seq = argSeq;
      for(int iCount = 0 ; iCount < MAX_LOTTO_NUM ; iCount++){
         lottoNums[iCount] = argNums[iCount];
         }
      }*/
   }


public class LottoAnalyzer2 {
	
	
	 // "lotto.txt"�� �о� ȸ���� ��÷ ��ȣ�� �ڷ�� �����϶�.
	   //������� 
	   final static int MAX_LOTTO_NUM2 = 6;//�ζ� �ѹ� �ִ�ġ
	   final static int LOTTO_numberOfTrials = 738;//�ζ� ���� �� Ƚ��
	   final static int LOTTO_numlast = 45;//�ζ� ������ ��ȣ���� �� ����
	   static int lottoNum[]=new int[LOTTO_numberOfTrials*MAX_LOTTO_NUM2];
       String temp[]=new String[MAX_LOTTO_NUM2]; 

	   static String lottoHC[]=new String[LOTTO_numberOfTrials]; //ȸ�� 
	   String InputValue;
  
   
   /* LottoResult lottoResults[];
   //������
   LottoAnalyzer(int argSeq) {
      lottoResults = new LottoResult[argSeq];
   }  */
   

   
   // 1 ~ 45���� ���� �� �߻� �󵵰� ���� ������ ������ ���-------------------------
   
	   
    void printNumsOrderByDesc() {
	 
	 int count[]= new int[LOTTO_numlast];
     int j=0;  
	
     for(int i=0;i<LOTTO_numberOfTrials*MAX_LOTTO_NUM2;i++){
		     j=lottoNum[i]-1;
			 count[j]++; 
	 } 
     
     

	 //���� ������� ����ϱ� 
	  for(int i=0;i<45;i++)
		 System.out.println(i+1+"�� �� "+count[i]+"�� ����.");

   }
   
   // ��÷��ȣ Ȯ��-----------------------------------------------------
  int checkLottoNums(int argNums[]) {
      // �Է� 1 2 3 4 5 6
	   
	   Scanner scan = new Scanner(System.in);
       System.out.println("��ȣ �Է��ϼ���~(�����̽� ����)");
       InputValue= scan.nextLine();
       String list[] = InputValue.split(" ");
       int LOTTO[]=new int[MAX_LOTTO_NUM2];
       
       //�Է¹��� ���ڿ��� ������ �ɰ��� �迭 �ֱ� 
       for(int i=0;i<MAX_LOTTO_NUM2;i++){
    	   LOTTO[i]=Integer.valueOf(list[i]);
       }
       
       for(int i=0;i<MAX_LOTTO_NUM2;i++){
    	   for(int j=0;j<LOTTO_numberOfTrials*MAX_LOTTO_NUM2;j++){
    		
    		   
    	   }
    	   
       }
       
      // �Է� ���� �ζ� ��� ������ ������ ȸ�� ��ȣ ���
      // ������ -1
      return 0;
  }
  
   // Ư��ȸ�� ��÷��ȣ ���-----------------------------------------------
   void printNumsBySeq(int argSeq) {
      
   }
   
   // Ư�� ���ڿ� ���� �߻� Ȯ���� ���---------------------------------------
   void printProbForNum(int argNum) {
         
   }
   
   // �ζǹ�ȣ �����ϱ�-----------------------------------------------------
   void generateLottoNum() {
      
   }
   
   // �߻� �󵵸� �������� ������׷� ���---------------------------------------
   void printHistogram() {
      
   }
   
   public static void main(String args[]) {
	 
	   FileProcessor fp = new FileProcessor("C:\\lotto.txt.txt");
      
      // LottoResult ��ü ���� �� �� �ʱ�ȭ
      // lottoResults[i] = new LottoResult();

          String FP;      
          String FP2;
          
       // Parsing
       // ������ �������� ���� �ڸ��� split
       // ���� -> ������ ��ȯ   
         
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
       
          
     //��Ʈ�� �迭�� ȸ�� ���     
       
     for(int i=LOTTO_numberOfTrials-1;i>=0;i--){ 
        
        FP2=fp.getNextLine(); 	    
        FP2= FP2.replaceAll("\r\n", ""); 
        lottoHC[i]=FP2;
        	           
       }
       
     /*   for(int i1=0 ; i1<LOTTO_numberOfTrials;i1++){
              System.out.println(lottoHC[i1]);
        }
       */
       
        
      /*��Ʈ�� �ɰ����°� ����~
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
  
