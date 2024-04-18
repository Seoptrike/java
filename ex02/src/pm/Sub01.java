package pm;

import java.util.*;

public class Sub01 {
	public static void run() {
		Scanner scanner= new Scanner(System.in);
		ArrayList<String> names = new ArrayList<>();
		names.add("홍길동");
		names.add("심청이");
		names.add("강감찬");
		names.add("성춘향");
		names.add("이몽룡");
		
		names.remove(1);
		for(int i=0; i<names.size(); i++) {
			String name=names.get(i);
			System.out.println(name);
			}//for
		//이름검색
		while(true) {
			System.out.println("검색할이름>");
			String suchName=scanner.nextLine();
			if(suchName=="") {
				System.out.println("검색을 종료합니다.");
				break;
			}
			boolean find=false;
			for(int i=0; i<names.size(); i++) {
				String name=names.get(i);
				if(suchName.equals(name)) {
					find=true;
					System.out.println("존재합니다."); 
						
				}//if
			}//for
			if(find==false) {
				 {System.out.println("존재하지 않습니다.");}
			}
		}//while
	}//method
}//class
