package pm;

import java.util.*;

public class Sub03 {
	public static void run() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> jusos = new ArrayList<>();
		names.add("홍길동");jusos.add("인천 서구 경서동");
		names.add("심청이");jusos.add("서울 강남구 압구정동");
		int index = -1;
		
		boolean run=true;
		while(run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.주소등록|2.이름검색|3.주소목록|4.주소삭제|0.종료");
			System.out.println("-------------------------------------------------");
			System.out.println("선택>");
			String menu=scanner.nextLine();
			switch(menu) {
				case"1":
					while(true) {
					System.out.println("이름>");
					String name = scanner.nextLine();
					if(name=="") {
						System.out.println("입력을 종료합니다.");
						break;}
					names.add(name);
					
					
					System.out.println("주소>");
					String juso = scanner.nextLine();
					if(juso=="") {
						System.out.println("입력 완료.");
						System.out.println("입력을 종료합니다.");
						break;}
					jusos.add(juso);
					}
					break;
				case"2":
					while(true) {
						System.out.println("검색할이름>");
						String suchName=scanner.nextLine();
						if(suchName=="") {
							System.out.println("검색을 종료합니다.");
							break;
						}
						boolean find=false;
						for(int i=0; i<names.size(); i++) {
							String name=names.get(i);
							if(suchName.equals(name)) {
								find=true;
								System.out.println("주소:"+jusos.get(i)); 
									
							}//if
						}//for
						if(find==false) {
							 {System.out.println("존재하지 않습니다.");}
						}
					}
					break;
				case"3":
					for(int i=0; i<names.size(); i++) {
						System.out.printf("%s\t%s\n",names.get(i),jusos.get(i));
					}
					System.out.println(jusos.size()+"명이 존재합니다");
					break;
				case"4":
					System.out.println("삭제할 이름>");
					String rname=scanner.nextLine();
					boolean find=false;
					for(int i=0; i<names.size(); i++) {
						String name = names.get(i);
						if(rname.equals(name)) {
							System.out.println("주소"+jusos.get(i));
							find=true;
							System.out.println("삭제하시겠습니까(y/n)");
							String answer = scanner.nextLine();
							if(answer.equals("y")|| answer.equals("Y")){
								names.remove(i);
								jusos.remove(i);
								System.out.println("삭제완료!");
								break;
							
							}
							else if(answer.equals("n")|| answer.equals("N")) {
								System.out.println("삭제취소!");
								break;
							}
							else {
								System.out.println("Y나 N을 입력해주십시오.");
								continue;
							}
						}
					}
					break;
				case"0":
					System.out.println("프로그램이 종료합니다.");
					run=false;
					break;
				default:
					System.out.println("0~4번을 선택해주세요!");
					break;
			}//switch
		}//while
	}//method
}//class
