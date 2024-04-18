package sale;

import product.*;
import java.text.*;
import java.util.*;


public class Sub {
	public static void run() {
		boolean run = true;
		SaleDAO dao = new SaleDAO() ;
		ProductDAO pdao = new ProductDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Scanner scanner = new Scanner(System.in);
				while(run) {
					System.out.println("\n=========================================");
					System.out.println("1.판매등록|2.판매조회|3.판매현황|4.판매삭제|0.종료");
					System.out.println("=========================================");
					System.out.println("선택>");
					String menu= scanner.nextLine();
					switch(menu) {
					case "1" :
						System.out.print("상품코드>");
						String code1 =scanner.nextLine();
						ProductVO vo1 =pdao.read(code1);
						if(vo1.getCode()==null) {
							System.out.println(code1 + " 번 상품이 존재하지 않습니다.");
						}else {
							System.out.println("상품명: "+ vo1.getName());
							String today = sdf.format(new Date());
							System.out.print("판매일: "+ today + ">" );
							String date = scanner.nextLine();
							System.out.print("판매가: "+ vo1.getPrice()+">" );
							String price =scanner.nextLine();
							System.out.println("수량>");
							String qnt = scanner.nextLine();
							SaleVO svo =new SaleVO();
							java.sql.Date saleSqlDate;
							svo.setCode(code1);
							if (date.equals("")) {
					            saleSqlDate = new java.sql.Date(System.currentTimeMillis());
					        } else {
					            try {
					                Date saleDate = new SimpleDateFormat("yyyyMMdd").parse(date);
					                saleSqlDate = new java.sql.Date(saleDate.getTime());
					            } catch (ParseException e) {
					                System.out.println("날짜 형식을 잘못 입력했습니다.");
					                break;
					            }
					        }
							svo.setName(vo1.getName());
							if(qnt.equals("")) {
								svo.setQnt(1);
							}else {
							svo.setQnt(Integer.parseInt(qnt));
							}
							if(price.equals("")) {
								svo.setPrice(vo1.getPrice());
							}else {
							svo.setPrice(Integer.parseInt(price));
							}
							
							dao.insert(svo);
							System.out.println("매출등록완료!");
							System.out.println(svo.toString());
							
						}
						break;
					case "2" :
						System.out.println("조회할 상품코드>");
						String suchCode = scanner.nextLine();
						ProductVO vo2 = pdao.read(suchCode);
						if(vo2.getCode()==null) {
							System.out.println(suchCode +" 번 상품이 존재하지 않습니다.");
						}else {
							System.out.println("상품이름: "+ vo2.getName());
							System.out.println("상품단가: "+ vo2.getPrice() );
						}
						break;
					case "3" :
						for(SaleVO vo:dao.list()) {
				               System.out.printf("%s\t%s(%s)\t%d개\t%,d원\n",
				                     vo.getSale_date(), vo.getName(), vo.getCode(), vo.getQnt()
				                     ,vo.getPrice());
				            }
						break;
					case "4" :
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
	public static boolean cancel(String str) {
		if(str.equals("")) {
			System.out.println("취소합니다.");
			return true;
		}else {
			return false;
		}
	}
}

