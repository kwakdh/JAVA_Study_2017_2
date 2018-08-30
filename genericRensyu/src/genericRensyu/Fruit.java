package genericRensyu;

public class Fruit implements Comparable<Fruit>{

	private static int idx = 0;
	protected int num; //자식도 보게해줘 ~
	public Fruit(){
		num = idx++;
	}
	
	public String toString(){
		return "Fruit"+num;
	}

	@Override
	public int compareTo(Fruit o) {
		
		return this.num - o.num;// 원래 순서대로 
	    
	
	}
	
}


