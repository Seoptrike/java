package pm;

import java.util.*;

public class Sub02 {
	public static void run() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> nums = new ArrayList<>();
		boolean run=true;
		while(run) {
			System.out.println("수 입력>");
			String num=scanner.nextLine();
			if(num=="") {
				System.out.println("입력을 종료합니다.");
				break;
			}//if
			else{
				nums.add(Integer.parseInt(num));
			}//else
		}//while
		int index= nums.size();
		System.out.println("데이터 갯수:"+index);
		int sum=0;
		for(int i=0; i<index; i++) {
			sum += nums.get(i);
		}
		System.out.println("합계:"+sum);
		double avg= sum /(double)nums.size();
		System.out.printf("평균: %.2f",avg);
	}//method
}//class
