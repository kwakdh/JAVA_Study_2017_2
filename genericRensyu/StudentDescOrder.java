

import java.util.Comparator;

public class StudentDescOrder<T extends student> implements Comparator<T> {

	@Override
	public int compare(T std1, T std2) {
		// TODO Auto-generated method stub
		return std1.comparaTo(std2)*-1;//¹Ý´ë·Î 
	}

}
