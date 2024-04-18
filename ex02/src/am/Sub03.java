package am;

import java.util.Scanner;

public class Sub03 {
	public static void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("주소관리");
		boolean run=true;
		String[] names= new String[100];
		String[] adresses= new String[100];
		String[] phones= new String[100];
		int count=0;
		
		while(run) {
			System.out.println("===========================================");
			System.out.println("\t1.주소등록|2.주소현황|0.프로그램종료");
			System.out.println("===========================================");
			System.out.println("선택>");
			String menu = scanner.nextLine();
			switch(menu) {
				case"1":
					while(true) {
						System.out.println("이름>");
						String name=scanner.nextLine();
						if(name=="") {
							System.out.println("입력을 종료합니다.");
							break;
						}
						System.out.println("주소>");
						String adress=scanner.nextLine();
						if(adress=="") {
							System.out.println("입력을 종료합니다.");
							break;
						}
						System.out.println("전화번호>");
						String phone=scanner.nextLine();
						if(phone=="") {
							System.out.println("입력을 종료합니다.");
							break;
						}
					
					names[count]=name;
					adresses[count]=adress;
					phones[count]=phone;
					System.out.println(name+" 님의 정보가 등록되었습니다.");
					count++;
					}//case1 while
					break;
				case"2":
					if(count==0) {
						System.out.println("등록된 주소가 없습니다.");
					}else {
						for(int i=0; i<count; i++) {
							System.out.printf("%s\t%s\t%s\n",names[i],adresses[i],phones[i]);}
					}
					break;
				case"0":
					System.out.println("프로그램을 종료합니다.");
					run=false;
					break;
				default:
					System.out.println("0~2 메뉴를 선택하세요!");
					break;
			}
		}
	}
}
