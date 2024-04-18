package ex01;

import java.util.Scanner;

public class Sub10 {
	public static void run() {
		boolean run = true;
		Scanner scanner= new Scanner(System.in);
		String[] names=new String[100];
		int[] prices= new int[100];
		int[] qnts= new int[100];
		int count=0;
	
		while(run) {
			System.out.println("---------------------------------------");
			System.out.println("1.매출등록|2.매출현황|0.종료");
			System.out.println("---------------------------------------");
			System.out.print("선택>");
			String menu=scanner.nextLine();
			switch(menu) {
				case"1":
					System.out.println("이름>");
					String name= scanner.nextLine();
					names[count]=name;
					System.out.println("단가>");
					int price= Integer.parseInt(scanner.nextLine()); //string 을 int로 강제 형변환이 안된다 이럴때 integer method를 써서 바꾼다.
					prices[count]=price;
					System.out.println("수량>");
					int qnt= Integer.parseInt(scanner.nextLine());
					qnts[count]=qnt;
					System.out.println("\n\n 등록완료!");
					count++;
					break;
				case"2":{
					if(count==0) {
						System.out.println("등록된 상품이 없습니다.");
					}else {
						for(int i=0; i<count; i++) {
								int sum=prices[i]*qnts[i];
								System.out.printf("%s |\t %d만원|   %d개| \t %d만원\n\n",names[i],prices[i],qnts[i],prices[i]*qnts[i] );}
						}
					}
					
					break;
				case"0":
					System.out.println("프로그램을 종료합니다.");
					run=false;
					break;
				default:
					System.out.println("0~2 메뉴를 선택하세요!");
			}

		}//while
	}//method
}//class
