package am;

import java.util.Scanner;
import java.util.ArrayList;


public class Sub01_1 {
	public static void run() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String[]> StudentsInfo = new ArrayList<>();

		boolean run = true;
		while(run) {
			System.out.println("===========================================");
			System.out.println("\t1.주소등록|2.주소현황|0.프로그램종료");
			System.out.println("===========================================");
			System.out.println("선택>");
			String menu = scanner.nextLine();
			switch(menu){
				case "1" :
					while(true) {
						System.out.println("이름>");
						String name=scanner.nextLine();
						if(name=="") {
							System.out.println("입력을 종료합니다.");
							break;
						}
						System.out.println("주소>");
						String address=scanner.nextLine();
						if(address=="") {
							System.out.println("입력을 종료합니다.");
							break;
						}
						System.out.println("전화번호>");
						String phone=scanner.nextLine();
						if(phone=="") {
							System.out.println("입력을 종료합니다.");
							break;
						}
					
					String[] newData= new String[3];
					newData[0]=name;
					newData[1]=address;
					newData[2]=phone;
					StudentsInfo.add(newData);
					}
						break;
					
				case"2":
					System.out.println("주소 현황을 출력합니다.");
					for(int i=0; i<StudentsInfo.size(); i++) {
						String[] item = StudentsInfo.get(i);
						 System.out.printf("이름: %s, 주소: %s, 전화번호: %s\n", item[0], item[1], item[2]);
						
						
					}
					break;
					
					
				case"0":
					System.out.println("프로그램을 종료합니다.");
					run=false;
					break;
			}
		}
	}
}
