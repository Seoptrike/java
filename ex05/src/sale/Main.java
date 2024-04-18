package sale;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
			boolean run = true;
			Scanner scanner = new Scanner(System.in);
			SaleDAO dao = new SaleDAO();
			while(run) {
				System.out.println("\n=========================================");
				System.out.println("1.판매등록|2.판매조회|3.판매목록|4.판매삭제|0.종료");
				System.out.println("=========================================");
				System.out.println("선택>");
				String menu= scanner.nextLine();
				switch(menu) {
					case "1" :
						Sale sale = new Sale();
						
						ArrayList<Sale> list = dao.list();
						Sale lastSale = list.get(list.size()-1);
						int newCode = lastSale.getCode()+1;
						System.out.println("판매코드> " + newCode);
						System.out.print("상품이름>");
						String name = scanner.nextLine();if(name=="")break;
						while(true) {
						System.out.print("판매가격>");
						String price = scanner.nextLine();
							if( check(price)){
								sale.setPrice( Integer.parseInt(price));
								break;
								}
							}
						while(true) {
						System.out.print("판매수량>");
						String qnt=scanner.nextLine();
							if( check(qnt) ) {
								sale.setQnt(Integer.parseInt(qnt));
								break;
							}
						}
						
						sale.setCode(newCode);
						sale.setName(name);
				
					
						dao.insert(sale);
						System.out.println("등록완료!");
	
						break;
					case "2" :
						System.out.print("조화할 상품>");
						String code = scanner.nextLine();
						if(code==""){
							System.out.println("조회를 종료합니다!");
							break;
							}
						if(check(code)) {
							sale = dao.read(Integer.parseInt(code));
							if(sale.getName()==null) {
								System.out.println(code+" 번 매출정보가 존재하지 않습니다.");
								
							}else {
							System.out.println("상품이름: "+sale.getName());
							System.out.println("상품단가: "+sale.getPrice());
							System.out.println("판매수량: "+sale.getQnt());
							}
							System.out.println("");
						}
						break;
					case "3" :
						ArrayList<Sale> array = dao.list();
						for (Sale s : array) {
							System.out.printf("%d\t%s\t%d만원\t%3d개\t%,10d만원\n",
									s.getCode(),s.getName(),s.getPrice(),s.getQnt(),s.getPrice()*s.getQnt());
						}
						System.out.println(array.size() + " 개 상품이 존재합니다.");
						break;
					case "4" :
						System.out.print("조화할 상품>");
						code = scanner.nextLine();
						if(code==""){
							System.out.println("조회를 종료합니다!");
							break;
							}
						if(check(code)) {
							sale = dao.read(Integer.parseInt(code));
							if(sale.getName()==null) {
								System.out.println(code+" 번 매출정보가 존재하지 않습니다.");
								
							}else {
								System.out.println("상품이름: "+sale.getName());
								System.out.println("상품단가: "+sale.getPrice());
								System.out.println("판매수량: "+sale.getQnt());
								System.out.print("삭제하시겠습니까?(Y/y)");
								String ans =scanner.nextLine();
								if(ans.equals("Y")||ans.equals("y")){
									dao.delete(Integer.parseInt(code));
									System.out.println("매츨삭제 완료!");
								}else {
									System.out.println("매출삭제 취소!");
								}
								}
							System.out.println("");
							}
						break;
					case "0" :
						System.out.println("프로그램을 종료합니다.");
						run = false;
						break;
					default:
						System.out.println("0~4 메뉴를 입력하세요!");
						break;
				}//switch	
			}//while
		}//method
	//숫자 체크 method
		public static boolean check(String str) {
			try {
				int num = Integer.parseInt(str);
				return true;
			}catch(Exception e ) {
				System.out.println("숫자로 입력하세요!");
				return false;
			}
		}
	}

