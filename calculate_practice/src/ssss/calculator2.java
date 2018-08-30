package ssss;

import java.util.Scanner;
import java.util.Stack;

public class calculator2 {
	public static void main(String[] args) {
	 
	Scanner scn = new Scanner(System.in);	
	String input =scn.nextLine();
	
	double temp1=0;
	double temp2=0;
	
	Stack st = new Stack();
	String spl[] = input.split(" ");
	
	for(int i=0 ; i <spl.length ;i++){
		switch(spl[i]){
		case "+":
			temp1=(double)st.pop();
			temp2=(double)st.pop();
			st.push(temp1+temp2);
			break;
		case "-":
			temp1=(double)st.pop();
			temp2=(double)st.pop();
			st.push(temp2-temp1);
			break;
		case "*":
			temp1=(double)st.pop();
			temp2=(double)st.pop();
			st.push(temp1*temp2);
			break;
		case "/":
			temp1=(double)st.pop();
			temp2=(double)st.pop();
			st.push(temp2/temp1);
			break;
		default:
			st.push(Double.parseDouble(spl[i]));
			break;
			
		}
		
	}System.out.println(st.pop());
	
		
	}
}