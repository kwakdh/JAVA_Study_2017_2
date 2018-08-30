package genericRensyu;

public class Fruit implements Comparable<Fruit>{

	private static int idx = 0;
	protected int num; //�ڽĵ� �������� ~
	public Fruit(){
		num = idx++;
	}
	
	public String toString(){
		return "Fruit"+num;
	}

	@Override
	public int compareTo(Fruit o) {
		
		return this.num - o.num;// ���� ������� 
	    
	
	}
	
}


