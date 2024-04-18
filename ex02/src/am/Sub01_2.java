package am;

import java.util.Scanner;

public class Sub01_2 {
	public static void run() {
		System.out.println("성적관리프로그램");
		boolean stop = false;
		Scanner scanner= new Scanner(System.in);
		
		String[] names = new String[100];
		int[] korPoints = new int[100];
		int[] engPoints = new int[100];
		int[] mathPoints = new int[100];
		double sum_kor=0;
		double sum_eng=0;
		double sum_math=0;
		
		names[0]="홍길동"; korPoints[0]=98; engPoints[0]=88; mathPoints[0]=99;
		names[1]="심청이"; korPoints[1]=67; engPoints[1]=82; mathPoints[1]=78;
		int count=2;
		while(!stop) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("      1.성적등록 |    2.성적출력    |    3.과목별 평균    | 0.종료      ");
			System.out.println("----------------------------------------------------------------");
			System.out.print("선택>");
			String menu = scanner.nextLine();
			switch(menu) {
				case "1":
					System.out.println("이름>");
					String name= scanner.nextLine();
					names[count]=name;
					System.out.println("국어점수를 입력하세요>");
					int korPoint= Integer.parseInt(scanner.nextLine());
					korPoints[count]=korPoint;
					System.out.println("영어점수를 입력하세요>");
					int engPoint= Integer.parseInt(scanner.nextLine());
					engPoints[count]=engPoint;
					System.out.println("수학점수를 입력하세요>");
					int mathPoint= Integer.parseInt(scanner.nextLine());
					mathPoints[count]=mathPoint;
					System.out.println("등록이 완료되었습니다.");
					count++;
					
					break;
				case "2":
					System.out.println("이름	국어	영어	수학	총점	평균	등급");
					for(int i=0; i<count; i++) {
						double tot= engPoints[i]+korPoints[i]+mathPoints[i];
						double avg = tot/3;
						String grade="";
						if(avg>=90) {
							if(avg>=95) {
								grade="A+";
							}else{
								grade="A0";
							}
						}else if(avg>=80){
							if(avg>=85) {
								grade="B+";
							}else{
								grade="B0";
							}
						}else if(avg>=70){
							if(avg>=75) {
								grade="C+";
							}else{
								grade="C0";
							}
						}else if(avg>=60){
							if(avg>=65) {
								grade="D+";
							}else{
								grade="D0";
							}
						}else{
							grade="F";
						}
						System.out.printf("%s \t %d \t %d \t %d \t %.0f \t %.2f \t %s \n", names[i],korPoints[i],engPoints[i],mathPoints[i],tot,avg,grade);
					}
					System.out.println("                  "+count+"명 학생이 등록되어있습니다.");
					break;
					
				case "3":
					for(int i=0; i<count; i++) {
					sum_kor=sum_kor+korPoints[i];
					sum_eng=sum_eng+engPoints[i];
					sum_math=sum_math+mathPoints[i];}
					System.out.println("우리반의	국어	영어	수학 ");
					System.out.printf("\t%.2f\t%.2f\t%.2f\n",
							sum_kor/(float)count, sum_eng/(float)count, sum_math/(float)count);
					
					break;
					
				case "0":
					System.out.println("프로그램이 종료되었습니다.");
					stop=true;
					break;
				default:
					System.out.println("0~3번 메뉴를 선택하세요!");
			}
			
			
		
			
			
		}
	}
}