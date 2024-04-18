package am;

import java.util.*;

public class Sub02 {
	public static void run() {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Juso> jusoes = new ArrayList<>();
		
		Juso juso1=new Juso("홍길동", "010-1010-1010","인천"); jusoes.add(juso1);
		Juso juso2=new Juso("심청이", "010-2020-2020","서울"); jusoes.add(juso2);
		Juso juso3=new Juso("강감찬", "010-3030-3030","부산"); jusoes.add(juso3);
		
		
		while(run) {
			System.out.println("\n=========================================");
			System.out.println("1.주소등록|2.주소조회|3.주소목록|4.주소삭제|0.종료");
			System.out.println("=========================================");
			System.out.println("선택>");
			String menu= scanner.nextLine();
			switch(menu) {
				case "1" :
					Juso juso = new Juso();
					System.out.print("이름>");
					String name = scanner.nextLine();
					juso.setName(name);
					
					System.out.print("주소>");
					String address = scanner.nextLine();
					juso.setAddress(address);
					
					System.out.print("전화번호>");
					String phone = scanner.nextLine();
					juso.setPhone(phone);
					
					jusoes.add(juso);
					System.out.println(juso.toString()+"\n"+"등록완료!");
					System.out.println("등록된 데이터: "+jusoes.size());
					break;
				case "2" :
					while(true) {
					System.out.print("조회할 이름>");
					String suchName= scanner.nextLine();
					if(suchName=="");
					boolean find=false;
					for(Juso s: jusoes) {
						if(suchName.equals(s.getName())) {
							System.out.println("주소: " + s.getAddress());
							System.out.println("전화번호: " + s.getPhone());
							find=true;
						}
					}
					if(find==false) System.out.println(suchName + "데이터가 존재하지 않습니다.");
					break;}
				case "3" :
					for(Juso j:jusoes) {
						System.out.printf("%s\t%s\t%s\n", j.getName(),j.getPhone(),j.getAddress());
					}
					System.out.println("등록된 데이터: "+jusoes.size());
					break;
				case "4" :
					System.out.print("삭제할 이름>");
					String suchName= scanner.nextLine();
					boolean find=false;
					for(Juso s: jusoes) {
						if(suchName.equals(s.getName())) {
							System.out.println("주소: " + s.getAddress());
							System.out.println("전화번호: " + s.getPhone());
							find=true;
							System.out.println("삭제하시겠습니까(Y/y)");
							String ans = scanner.nextLine();
							if(ans.equals("Y")||ans.equals("y")) {
								jusoes.remove(s);
								System.out.println("삭제완료!");
								break;
							}else {
								System.out.println("삭제취소!");
							}
						
						}
					}
					if(find==false) System.out.println(suchName + " 데이터가 존재하지 않습니다.");
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
}//class
