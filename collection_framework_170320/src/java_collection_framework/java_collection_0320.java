package suUp;

public class das implements Comparable{
	   int age;
	   int score;
	   String name;
	   
	   public das(String name, int age, int score) {
	      this.name = name;
	      this.age = age;
	      this.score = score;
	   }
	   
	   public String toString() {
	      return "name:" + name + ", age:" + age + ", score" + score;
	   }
	   
	   public static void main(String[] args) {
	      das[] stds = {
	            new das("Hong", 20, 87),
	            new das("Kong", 18, 97),
	            new das("Park", 22, 86),
	            new das("Kim", 21, 98),
	            new das("Lee", 19, 100),
	      };
	      
	      Arrays.sort(stds);
	      for(das s : stds)
	         System.out.println(s);
	      
	      Arrays.sort(stds, new Desc());
	      System.out.println("성적의 역순");
	      for(das s : stds)
	          System.out.println(s);
	      
	      Arrays.sort(stds, new AgeOrder());
	      System.out.println("내밑으로 니 위로 다 집합해");
	      for(das s : stds)
	          System.out.println(s);
	   }
	   
	   public int compareTo(Object o) {
	      if(o instanceof das) {
	         das s = (das)o;
	         return (this.score - s.score)*-1;
	         // -1을 리턴하면 내림차순
	         // 아니면 오름차순
	      }
	      return -1;
	   }
	}

	class AgeOrder implements Comparator{
	   public int compare(Object o1 , Object o2){
	      if(o1 instanceof das &&
	               o2 instanceof das){
	         das s1 = (das)o1;
	         das s2 = (das)o2;
	         
	         return s1.age - s2.age;
	      }
	      return -1;
	   }
	}
	class Desc implements Comparator {
	   public int compare(Object o1, Object o2) {
	      if (o1 instanceof Comparable && o2 instanceof Comparable) {
	         Comparable c1 = (Comparable)o1;
	         Comparable c2 = (Comparable)o2;
	         
	         return c1.compareTo(c2)*-1;
	      }
	      
	      return -1;
	   }
	}