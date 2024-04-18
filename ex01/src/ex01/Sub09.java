package ex01;

import java.util.Scanner;

public class Sub09 {
	public static void run() {
		boolean run= true;
		Scanner scanner = new Scanner(System.in);
		String[] names= new String[100];
		String[] adresses= new String[100];
		String[] phones= new String[100];
		
		names[0]="홍길동";
		adresses[0]="인천 서구 경서동";
		phones[0]="010-1010-2020";
		names[1]="심청이";
		adresses[1]="인천 부평구 계산동";
		phones[1]="010-1010-3030";
		int count=2;
		
		
		while(run) {
			System.out.println("\n\n-----------------------");
			System.out.println("1.주소등록|2.주소출력|0.종료");
			System.out.println("-----------------------");
			System.out.print("선택>");
			String menu=scanner.nextLine();
			switch(menu) {
				case "1":
					System.out.print("이름>");
					String name=scanner.nextLine();
					System.out.print("주소>");
					String adress=scanner.nextLine();
					System.out.print("전화번호>");
					String phone=scanner.nextLine();
					names[count]=name;
					adresses[count]=adress;
					phones[count]=phone;
					count=count+1;
					System.out.println("등록되었습니다.");
					
					break;
				case "2":
					for(int i=0; i<count; i++) {
					System.out.printf("\n%s %s \t %s \n",names[i],adresses[i],phones[i]);}
					break;
				case "0":
					System.out.println("프로그램을 종료합니다.");
					run=false;
					break;
				default:
					System.out.println("0~2 메뉴를 선택하세요!");
			}//switch
		}//while
	}//method
}//class
