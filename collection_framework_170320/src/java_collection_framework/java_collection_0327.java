package suUp;

import java.util.HashMap;
import java.util.Scanner;

public class suUp0327 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //hashMap!!!!!!!
		//값만 저장하는게 아니라 이 값을 찾기위한 key값도 찾는ㄷ
		//key와 값 둘다 저장한다.--->값을 묶어서 하나의 데이터로 저장
		//해싱을 이용하기 때문에 검색에 뛰어난 성능을 가지고 잇다!!
		//회원들의 아이디와 비밀번호를 키,값 쌍으로 저장한다.
		//해쉬코드값을 잘 설계하는가가 관건이다 
		
		HashMap map = new HashMap();
		map.put("myId","1234");//key와 value 둘다 저장해야함.
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		
		
	    System.out.println(map.get("myId"));//답 --->1234
	    System.out.println(map.get("asdf"));
	    //키값이 같은게 들어오면 value덮어씀
		//------------->1234
		
		
		/* --------사용자가 입력한 아이디와 암호가 
		 *         해쉬맵에 저장된 그것과 일치할때까지 반복!!!!!!------
		 *  1.사용자로 부터 아이디와 암호를 입력받는다. 
		 * 입력한 아이디가 존재하지 않으면 아이디가 존재하지 않는다는 메시지출력
		 *  2.아이디는 있는데 비밀번호가 맞지 않으면
		 * 비밀번호가 일치하지 않는다는 메시지출력
		 * 
		 * */
		Scanner scn= new Scanner(System.in);
		
	    while(true) {
	    	//아이디 입력받고 암호입력받고
	    	System.out.println("아이디와 패스워드 입력해라");
	    	System.out.print("ID:");
	    	String id=scn.nextLine();
	    	id=id.trim();	//공백짤라버려라가 trim 
	    	
	    	System.out.print("password: ");
	    	String pw=scn.nextLine().trim();
	    	
	    	
	        //아이디가 없으면 다시 루프의 처음으로 가서 입력받고
	    	map.containsKey(id);//아이디가 있는지 없는지 물어보는거
	    	if(map.containsKey(id)==false){
	    		System.out.println("그런 아이디 없다 ");
	    		continue;//다시 위로 올라간다 
	    	}
	    	//모든건 오브젝트로 반환하기때문에 지네릭안썻으면 앞에 타입캐스팅해주기
	    	String stredPw=(String)map.get(id);
	    	//키값에 해당하는 value을 stredPw에 준다.
	    	
	    	if(stredPw.equals(pw)){
	    		//value값과 사용자가 입력한 pw값이 같으면...
	    	System.out.println("id와 pw가 일치합니다.");	
	    	break;//무한루프 끝내주기..	
	    	}
	    	else{
	    		System.out.println("일치하지 않는다.");	
	    	}
	    	
	    	//그렇지 않으면 암호가 일치하는지 보고 
	    	//일치하면 루프종료 
	    	
	    	
	    }
		
		
	}

}
