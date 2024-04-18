package juso;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		boolean run = true;
		Scanner	scanner = new Scanner(System.in);
		JusoDAO dao = new JusoDAO();
		while(run) {
		System.out.println("********************주소관리********************");
		System.out.println("----------------------------------------------");
		System.out.println("1.주소등록|2.주소조회|3.주소목록|4.주소삭제|0.종료");
		System.out.println("----------------------------------------------");
		System.out.print("선택>");
		String menu = scanner.nextLine();
		switch(menu) {
			case "1": 
				Juso newJuso = new Juso();
				
				//새로운 번호 구하기
				ArrayList<Juso> list=dao.list();
				Juso juso1=list.get(list.size()-1);
				int lastNo= juso1.getNo()+1;
				System.out.println("번호>"+lastNo);
				newJuso.setNo((lastNo));
				System.out.print("이름>");
				String newName = scanner.nextLine();if(newName=="")break;
				newJuso.setName(newName);
				System.out.print("전화>");
				String newPhone = scanner.nextLine();if(newPhone=="")break;
				newJuso.setPhone(newPhone);
				System.out.print("주소>");
				String newAddress = scanner.nextLine();if(newAddress=="")break;
				newJuso.setAddress(newAddress);
				dao.insert(newJuso);
				System.out.println("주소등록완료!");
				break;
				
			case "2": 
				System.out.print("조회할 이름>");
				String name = scanner.nextLine();
				Juso juso = dao.read(name);
				if(juso.getNo()==0) {
					System.out.println(name +" 이(가) 존재하지 않습니다.");}
				else {
					System.out.println("번호: "+juso.getNo());
					System.out.println("이름: "+juso.getName());
					System.out.println("전화: "+juso.getPhone());
					System.out.println("주소: "+juso.getAddress());
				}
				break;
				
			case "3": 
				ArrayList<Juso> array = dao.list();
				for(Juso j : array) {
					System.out.printf("%d\t%s\t%s\t%s\n",j.getNo(),j.getName(),j.getPhone(),j.getAddress());
					}
				System.out.println("");
				break;
			case "4": 
				System.out.print("삭제할 번호>");
				String delete = scanner.nextLine();
				if(delete=="")break;
				juso = dao.read(delete);
				if(juso.getNo() == 0) {
					System.out.println(delete +" 번이 존재하지 않습니다.");
				}else {
					dao.delete(Integer.parseInt(delete));
					System.out.println(juso.getName() + "삭제완료!");
				}
				break;
			case "0":
				run = false;
				break;
			default:
				System.out.println("0~4번 메뉴를 선택하세요!");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
