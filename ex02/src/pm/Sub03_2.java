package pm;

import java.util.*;

public class Sub03_2 {
	public static void run() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> data = new ArrayList<>();
		boolean run=true;
		while(run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.주소등록|2.이름검색|3.주소목록|4.주소삭제|0.종료");
			System.out.println("-------------------------------------------------");
			System.out.println("선택>");
			String menu=scanner.nextLine();
			switch(menu) {
				case"1":
					
					break;
				case"2":
					break;
				case"3":
					break;
				case"4":
					break;
				case"0":
					System.out.println("프로그램이 종료합니다.");
					run=false;
					break;
				default:
					System.out.println("0~4번을 선택해주세요!");
					break;
			}//switch
		}//while
	}//method
}//class
