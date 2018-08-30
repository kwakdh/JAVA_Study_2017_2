package suUp;

import java.util.TreeSet;

public class suUp0324_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		  TreeSet set = new TreeSet(new NumDescendingOrder());	
		    
		    while(set.size()<10){
		    	set.add((int)Math.random()*100+1);
		    }
		    
		    
		    System.out.println(set);
		    System.out.println("50미만의 값들: "+set.headSet(50));
		    // headSet(50) 최상위값이 50이라서 50미만. 최상위값은 포함안됨!!!

		    System.out.println("50미만의 값들: "+set.tailSet(50));
		    //tailSet(50) 50이상. 최하위값은 포함된다!!! 
		    
		    
		    
	}

}

class NumDescendingOrder implement Comparator {
	public int compare(Object o1,Object o2){
		if(o1 instanceof Comparable && instanceof Comparable){
			Comparable c1= (Comparable)o1;
			Comparable c2= (Comparable)o2;
			
			return c1.comparaTo(o2)-1;
			
			return -1;
		}
	}
	
	
}
