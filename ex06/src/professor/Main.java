package professor;
import java.util.*;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		Connection con = Database.CON;
		ProDAO dao = new ProDAO();
		while(run) {
			System.out.println("\n=========================================");
			System.out.println("1.등록|2.조회|3.목록|4.삭제|5.수정|0.종료");
			System.out.println("=========================================");
			System.out.print("선택>");
			String menu= scanner.nextLine();
			switch(menu) {
			case "1" :
				ProVO vo = new ProVO();
				int code = dao.getCode();
				System.out.println("교수코드>"+ code);
				vo.setPcode(String.valueOf(code));;

				System.out.print("교수이름>");
				String pname = scanner.nextLine();
				if(pname=="") {
					System.out.println("등록을 취소합니다.");
					break;
				}else {
					vo.setPname(pname);
				}
				dao.insert(vo);
				System.out.println("교수등록 완료!");
				break;
			case "2" :
				while(true) {
					System.out.print("교수번호>");
					String code2 = scanner.nextLine();
					ProVO vo2 = dao.read(code2);
					if(code2=="") {
						System.out.println("조회를 취소합니다.");
						break;
					}
					String date = "미등록";
					if(vo2.getHiredate() != null) {
						date = vo2.getHiredate().substring(0,10);
					}
					String dept = "미등록";
					if(vo2.getDept() != null) {
						dept = vo2.getDept();
					}
					String title = "미등록";
					if(vo2.getTitle() != null) {
						title = vo2.getTitle();
					}
					if(vo2.getPcode()==null) {System.out.println(code2 + " 번 교수가 없습니다!");
					}else {
						System.out.printf("%s\t%s\t%s\t%s\t%-10s\t%,10d원\n",
								vo2.getPcode(),vo2.getPname(),dept,title,date,vo2.getSalary());}
				}
				break;
			case "3" : //목록
				for(ProVO v: dao.list()) {
					String date = "미등록";
					if(v.getHiredate() != null) {
						date = v.getHiredate().substring(0,10);
					}
					String dept = "미등록";
					if(v.getDept() != null) {
						dept = v.getDept();
					}
					String title = "미등록";
					if(v.getTitle() != null) {
						title = v.getTitle();
					}
					System.out.printf("%s\t%s\t%s\t%s\t%-10s\t%,10d원\n",
							v.getPcode(),v.getPname(),dept,title,date,v.getSalary());
				}
				break;
			case "4" : //삭제하기
				System.out.print("삭제할 교수번호>");
				String deleteCode = scanner.nextLine();
				ProVO vo3 =dao.read(deleteCode) ;
				String date = "미등록";
				if(vo3.getHiredate() != null) {
					date = vo3.getHiredate().substring(0,10);
				}
				String dept = "미등록";
				if(vo3.getDept() != null) {
					dept = vo3.getDept();
				}
				String title = "미등록";
				if(vo3.getTitle() != null) {
					title = vo3.getTitle();
				}
				if(vo3.getPcode()==null) {
					System.out.println(deleteCode +" 번 교수가 존재하지 않습니다.");
				}else {
					System.out.printf("%s\t%s\t%s\t%s\t%-10s\t%,10d원\n",
							vo3.getPcode(),vo3.getPname(),dept,title,date,vo3.getSalary());
					System.out.println(deleteCode + " 번 교수를 삭제하시겠습니까(Y/y)");
					String ans = scanner.nextLine();
					if(ans.equalsIgnoreCase("Y")) {
						dao.delete(deleteCode);
						System.out.println("삭제완료!");
					}else {
						System.out.println("삭제취소!");
					}
				}
				break;

			case "5" :
				System.out.print("수정할 교수번호>");
				String updateCode = scanner.nextLine();
				ProVO vo4 = dao.read(updateCode); //수정전의 값
				if(vo4.getPcode()==null) {
					System.out.println(updateCode +" 번 교수가 존재하지 않습니다.");
				}else {
					boolean run2 = true;
					while(run2) {
						System.out.println("\n=========================================");
						System.out.println("1.교수이름|2.교수학과|3.교수직급|4.급여|0.종료");
						System.out.println("=========================================");
						System.out.print("선택>");
						String choice= scanner.nextLine();
						switch(choice) {
						case "1":
							System.out.print("교수 이름:"+vo4.getPname()+">");
							String newName=scanner.nextLine();
							if(!newName.equals("")) vo4.setPname(newName);
							System.out.println("수정하시겠습니까?(Y/y)");
							String ans = scanner.nextLine();
							if(ans.equalsIgnoreCase("Y")) {
								dao.update(vo4);
								System.out.println("수정완료!");
							}else {
								System.out.println("수정취소!");
							}
							break;
						case "2":
							System.out.print("교수 학과:"+vo4.getDept()+">");
							String newDept=scanner.nextLine();
							if(!newDept.equals("")) vo4.setDept(newDept);
							System.out.println("수정하시겠습니까?(Y/y)");
							ans = scanner.nextLine();
							if(ans.equalsIgnoreCase("Y")) {
								dao.update(vo4);
								System.out.println("수정완료!");
							}else {
								System.out.println("수정취소!");
							}
							break;
						case "3":
							System.out.print("교수 직급:"+vo4.getTitle()+">");
							String newTitle=scanner.nextLine();
							if(!newTitle.equals("")) vo4.setTitle(newTitle);
							System.out.println("수정하시겠습니까?(Y/y)");
							ans = scanner.nextLine();
							if(ans.equalsIgnoreCase("Y")) {
								dao.update(vo4);
								System.out.println("수정완료!");
							}else {
								System.out.println("수정취소!");
							}
							break;
							//							case "4":
							//								System.out.print("임용 날짜:"+vo4.getHiredate()+">");
							//								String newHiredate=scanner.nextLine();
							//								if(!newHiredate.equals("")) vo4.setHiredate(newHiredate);
							//								System.out.println("수정하시겠습니까?(Y/y)");
							//								ans = scanner.nextLine();
							//								if(ans.equalsIgnoreCase("Y")) {
							//									dao.update(vo4);
							//									System.out.println("수정완료!");
							//								}else {
							//									System.out.println("수정취소!");
							//								}
							//								break;
						case "4":
							System.out.print("교수 급여:"+vo4.getSalary()+">");
							String newSalary=scanner.nextLine();
							if(!newSalary.equals("")) vo4.setSalary(Integer.parseInt(newSalary));
							System.out.println("수정하시겠습니까?(Y/y)");
							ans = scanner.nextLine();
							if(ans.equalsIgnoreCase("Y")) {
								dao.update(vo4);;
								System.out.println("수정완료!");
							}else {
								System.out.println("수정취소!");
							}
							break;
						case "0":
							System.out.println("수정을 종료합니다.");
							run2=false;
							break;

						default:
							System.out.println("0~4 메뉴를 입력하세요!");
							break;
						}
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

}
