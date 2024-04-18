package product;
import java.sql.Connection;
import java.util.*;

import sale.Sub;

public class Main {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		Connection con = Database.CON;
		ProductDAO dao = new ProductDAO();

		while(run) {
			System.out.println("\n===========================================================");
			System.out.println("1.상품등록|2.상품조회|3.상품목록|4.상품삭제|5.상품수정|6.매출관리|0.종료");
			System.out.println("===========================================================");
			System.out.println("선택>");
			String menu= scanner.nextLine();
			switch(menu) {
			case"6":
				Sub.run();
				break;
			case"5":
				System.out.print("수정할 상품코드>");
				String fixCode = scanner.nextLine();
				ProductVO vo5=dao.read(fixCode);
				if(cancel(vo5.getCode())){
					System.out.println(fixCode+" 번 상품이 존재하지 않습니다.");
				}else{
					System.out.print("상품이름>" + vo5.getName()+">");
					String fixName = scanner.nextLine(); 
					if( !(fixName.equals("")) ) vo5.setName(fixName);
					while(true) {
						System.out.print("상품단가>" + vo5.getPrice()+">");
						String fixPrice = scanner.nextLine(); 
						if( fixPrice.equals("") ) {
							break;
						}
						if(isNumber(fixPrice)) {
							vo5.setPrice(Integer.parseInt(fixPrice));
							break;
						}
					}
					System.out.println(vo5.toString());
					System.out.println("정말로 수정하시겠습니까? (Y/y)");
					String ans = scanner.nextLine();
					if(ans.equalsIgnoreCase("y")) {
						dao.update(vo5);
						System.out.println("상품정보 수정완료!");
					}else {
						System.out.println("수정을 취소합니다!");
					}
				}
				break;
			case "1" :
				ProductVO vo1 = new ProductVO();
				vo1.setCode( dao.lastCode() );				
				System.out.println("등록할 상품코드>" + vo1.getCode() );
				System.out.print("등록할 상품이름>");
				String newName = scanner.nextLine();
				if(cancel(newName)) break;
				else vo1.setName(newName);

				while(true) {
					System.out.print("등록할 상품가격>");
					String newPrice = scanner.nextLine();
					if(cancel(newPrice))break;
					
					if(isNumber(newPrice)) { //가격이 숫자이면
						vo1.setPrice(Integer.parseInt(newPrice));
						System.out.println(vo1.toString());
						dao.insert(vo1);
						System.out.println("상품등록완료!");
						break;
					}
				}
				break;
			case "2" :
				while(true) {
					System.out.print("조회할 상품코드>");
					String suchCode = scanner.nextLine();
					if(cancel(suchCode))break;
					ProductVO vo2 = dao.read(suchCode);
					if(vo2.getCode()==null) {
						System.out.println(suchCode+" 번 상품이 없습니다");
					}else {
						System.out.println(vo2.toString());
					}
				}
				break;
			case "3" :
				ArrayList<ProductVO> array =dao.list();
				for(ProductVO vo : array) {
					System.out.println(vo.toString());
				}
				break;
			case "4" :
				System.out.print("삭제할 코드>");
				String deleteCode = scanner.nextLine();
				ProductVO vo4 = dao.read(deleteCode);
				if(vo4.getCode() == null ) {
					System.out.println(deleteCode + " 번 상품이 존재하지 않습니다.");
				}else {
					System.out.println(vo4.toString());
					System.out.print("정말로 삭제하시겠습니까?(Y/y)");
					String ans = scanner.nextLine();
					if(ans.equalsIgnoreCase("Y")) {
						if(dao.delete(deleteCode)) {
							System.out.println("상품정보 삭제완료!");
						}else {
							System.out.println("상품정보 삭제실패!");
						}
					}else {
						System.out.println("삭제를 취소합니다.");
					}
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

	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}catch(Exception e) {
			System.out.println("숫자로 입력하세요!");
			return false;
		}
	}
	public static boolean cancel(String str) {
		if(str.equals("")) {
			System.out.println("취소합니다.");
			return true;
		}else {
			return false;
		}
	}
}

