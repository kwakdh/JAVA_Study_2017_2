package generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class statistics {
	
	
	public static<T extends Student> void getGradeStat(List<T> list){
		
		int total=0;
		double average=0;
		int max=0;
		int min=0;
		T maxStd=null;
		T minStd =null;
		
		Iterator<T> it = list.iterator();
		
		while(it.hasNext()){
			
			T value = it.next();
			
			total +=value.getScore();
			
			if(max>value.getScore()){
				maxStd =value;
			}
			if(min<value.getScore()){
				minStd =value;
			}
			
			average=total/(double)list.size();
			
		}
	
		System.out.println("최고점수: "+maxStd.toString());
	}
		   
}
	
	  	 
