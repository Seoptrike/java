package am;

import java.util.*;

public class Sub01 {
	public static void run() {
		Scanner scanner= new Scanner(System.in);
		ArrayList<String[]> gradeData = new ArrayList<>();
		boolean run = true;
		gradeData.add(new String[] {"홍길동","80","77","82"});
		gradeData.add(new String[] {"강감찬","90","87","83"});
		
		
		while(run) {
			System.out.println("------------------------------------------------");
			System.out.println("1.성적등록|2.성적목록|3.성적조회|4.성적삭제|0.종료");
			System.out.println("------------------------------------------------");
			System.out.println("선택하기>");
			String menu= scanner.nextLine();
			switch(menu) {
				case "1":
					System.out.println("이름>");
					String name= scanner.nextLine();
					System.out.println("국어점수를 입력하세요.>");
					String kor= scanner.nextLine();
					System.out.println("영어점수를 입력하세요.>");
					String eng= scanner.nextLine();
					System.out.println("수학점수를 입력하세요.>");
					String mat= scanner.nextLine();
					
					String[] studentsInfo = new String[4];
					studentsInfo[0]=name; studentsInfo[1]=kor; studentsInfo[2]=eng; studentsInfo[3]=mat;
					gradeData.add(studentsInfo);
					break;
				case "2":
					int sumKor=0; int sumEng=0; int sumMat=0;
					double korAvg=0; double engAvg=0; double matAvg=0;
					double totAvg=0;
					
					for(int i=0; i<gradeData.size(); i++) {
						String[] studentInfo = gradeData.get(i); 
						double tot = Integer.parseInt(studentInfo[1])+Integer.parseInt(studentInfo[2])+Integer.parseInt(studentInfo[3]);
						double avg = tot / 3;
						sumKor = sumKor + Integer.parseInt(studentInfo[1]);
						sumEng = sumEng + Integer.parseInt(studentInfo[2]);
						sumMat = sumMat + Integer.parseInt(studentInfo[3]);
						korAvg= sumKor/ gradeData.size();
						engAvg= sumEng/ gradeData.size();
						matAvg= sumMat/ gradeData.size();
						totAvg= (korAvg+engAvg+matAvg )/3;
						System.out.printf("%s	%s	%s	%s	%.0f	%.2f \n", studentInfo[0],studentInfo[1],studentInfo[2],studentInfo[3],tot,avg);
						
					}
					System.out.println("------------------------------------------------");
					System.out.printf("	%.2f	%.2f	%.2f		%.2f\n",korAvg,engAvg,matAvg,totAvg);
					
					break;
				case "3":
					System.out.println("조회할 이름>");
					String suchName=scanner.nextLine();
					boolean find = false;
					for(int i=0; i<gradeData.size();i++) {
						String[] studentInfo = gradeData.get(i);
						if(studentInfo[0].equals(suchName)) {
							System.out.printf("이름: %s\n국어: %s\n영어: %s\n수학: %s\n", studentInfo[0], studentInfo[1], studentInfo[2], studentInfo[3]);
							int tot = Integer.parseInt(studentInfo[1]) + Integer.parseInt(studentInfo[2]) + Integer.parseInt(studentInfo[3]);
							System.out.printf("총점: %d\n평균: %.2f\n", tot, tot / 3.0);
							find=true;
						}
					}
					if(!find) System.out.println(suchName + " 학생이 존재하지 않습니다.");
					break;
				case "4":
					System.out.println("삭제할 이름>");
					String deleteName=scanner.nextLine();
					boolean find2 = false;
//					for(int i=0; i<gradeData.size();i++){
//						String[] studentInfo = gradeData.get(i);
					for(String[] studentInfo : gradeData){
						if(studentInfo[0].equals(deleteName)) {
							System.out.printf("이름: %s\n국어: %s\n영어: %s\n수학: %s\n", studentInfo[0], studentInfo[1], studentInfo[2], studentInfo[3]);
							int tot = Integer.parseInt(studentInfo[1]) + Integer.parseInt(studentInfo[2]) + Integer.parseInt(studentInfo[3]);
							System.out.printf("총점: %d\n평균: %.2f\n", tot, tot / 3.0);
							System.out.println("\n삭제하시겠습니까?(Y/N)");
							String answer = scanner.nextLine();
							if( answer.equals("Y") || answer.equals("y") ) {
								gradeData.remove(studentInfo);
								System.out.println("삭제완료!");
							}
							else if( answer.equals("N")|| answer.equals("n")) {
								System.out.println("삭제취소");
								break;
							}
							else {
								System.out.println("Y or N을 입력해주십시오.");
							}
							find2=true;
						}
					}
					if(!find2) System.out.println(deleteName + " 학생이 존재하지 않습니다.");
					break;
				case "0":
					System.out.println("프로그램을 종료합니다");
					run = false;
					break;
				default:
					System.out.println("0~4 메뉴를 선택하세요!");
					break;
			}
		}
	}
}