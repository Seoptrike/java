package pm;
import java.util.*;

public class Sub01 {
	public static void run() {
		boolean run= true;
		Scanner scanner= new Scanner(System.in);
		ArrayList<Sale> sales = new ArrayList<>();
		Sale s1 = new Sale();
		s1.code="100";
		s1.name="냉장고";
		s1.price=350;
		s1.qnt=15;
		sales.add(s1);
		
		Sale s2= new Sale("101","세탁기",270,25);
		sales.add(s2);
		
		while(run) {
			System.out.println("\n\n---------------------------------------------");
			System.out.println("1.매출등록|2.매출목록|3.상품조회|4.상품삭제|0.종료");
			System.out.println("---------------------------------------------");
			System.out.print("선택>");
			String menu=scanner.nextLine();
			switch(menu) {
				case"1":
					Sale s3= new Sale();
					Sale last= sales.get(sales.size()-1);
					int newCode = Integer.parseInt(last.code)+1; //String -> int;
					s3.code = String.valueOf(newCode); // int -> String;
					System.out.println("상품코드>" + s3.code);
//					s3.code = scanner.nextLine();
					System.out.println("상품이름>");
					s3.name = scanner.nextLine();
					if(s3.name.equals("")) break;
					while(true) {
						System.out.println("상품가격>");
	//					s3.price =Integer.parseInt( scanner.nextLine() );
						String price=scanner.nextLine();
						if(checkNumber(price)) {
							s3.price = Integer.parseInt(price);
							break;
						}
					}
					while(true) {
						System.out.println("판매수량>");
	//					s3.price =Integer.parseInt( scanner.nextLine() );
						String qnt=scanner.nextLine();
						if(checkNumber(qnt)) {
							s3.qnt = Integer.parseInt(qnt);
							break;
						}
					}
					
//					s3.qnt =Integer.parseInt( scanner.nextLine() );	
					
					sales.add(s3);
					System.out.println("상품들록완료!");
					break;
				case"2":
					int total=0;
					int sumQnt=0;
					for(Sale s:sales) {
						total = total+ s.sum();
						sumQnt = sumQnt + s.qnt;
						s.printLand();
					}
					System.out.println("---------------------------------------------");
					System.out.printf("총 판매수량: %d\n총 판매금액: %,d만원\n",sumQnt,total);
					System.out.println("---------------------------------------------");
					System.out.println(sales.size()+" 개 상품이 존재합니다.");
					break;
				case"3":
					while(true) {
					System.out.println("조회 할 상품명>");
					String such=scanner.nextLine();
					if(such.equals("")) break;
					boolean find =false;
					for(Sale s:sales) {
						if(s.name.equals(such) || s.code.equals(such)) {
							s.printPort();
							System.out.println("");
							find = true;
							break;
						}
					}
					if(!find) System.out.println(such+" 상품이 존재하지 않습니다.");
					}//while
				case"4":
					System.out.println("삭제 할 상품명");
					String remove = scanner.nextLine();
					Iterator<Sale> iterator = sales.iterator();
					boolean find2= false;
					while(iterator.hasNext()) {
						{
							Sale s= iterator.next();
							if(s.name.equals(remove) || s.code.equals(remove)) {
								System.out.println("정말 삭제하시겠습니까? (Y/N)");
								String answer = scanner.nextLine();	
								if(answer.equals("Y") || answer.equals("y")) {
									iterator.remove();
									System.out.println("삭제 완료!");
								}
								else if(answer.equals("N") || answer.equals("n")) {
									System.out.println("삭제 취소!");
									break;
								}
								else {
									System.out.println("");
									System.out.println("잘못 입력하셨습니다.");
									break;
								}
								find2=true;
							}
						}
					}
						if(!find2) System.out.println(remove+" 상품이 존재하지 않습니다.");
				
					break;
				case"0":
					run=false;
					break;
				default:
					System.out.println("0~4번 메뉴를 선택하세요!");
			}//switch
		}//while
		System.out.println("프로그램을 종료합니다.");
	}//method
	//숫자인지 아닌지 판별하는 메서드
	public static boolean checkNumber(String str) {
		try {
			int num=Integer.parseInt(str);
			return true;
		}catch(Exception e) {
			System.out.println("숫자를 입력하세요!");
			return false;
		}
	}//try를  하다가 오류가 나면 catch 를 동작해라
}//class
