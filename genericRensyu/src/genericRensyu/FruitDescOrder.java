package genericRensyu;

import java.util.Comparator;

public class FruitDescOrder<T extends Comparable<? super T>> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2)*-1;
	}
	

}
