package suUp4_3;
import java.util.ArrayList;
import java.util.Iterator;

public class DAOTest {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      BoardDAO dao = null;
      try {
         dao = new BoardDAO();
         System.out.println("dao ���� ����");
         
         //dao.insert("scpark", "test", "test");
         
         Board board = new Board("gdhong", "test", "�׽�Ʈ�Դϴ�.");
         dao.insert(board);
         
         /*
         dao.update();
         dao.delete();
         */
         ArrayList<Board> list = dao.select();
         Iterator<Board> it = list.iterator();
         while(it.hasNext()) {
            System.out.println(it.next());
         }
         
      }catch(Exception e){
         e.printStackTrace();
         System.out.println(e.getMessage());
      }

   }

}