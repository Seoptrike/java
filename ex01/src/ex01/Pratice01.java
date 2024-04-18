package ex01;

public class Pratice01 {

	public static void run() {
		
		// 1000 아래의 3과 5의 배수의 합을 구하시오.
		
		int i=1;
		int sum=0;
		int r=0;
		for(i=1; i<1000; i++) {
				if(i%3==0 || i%5==0) {
					sum=sum+i;}
			}
		System.out.println("3과 5의 배수의 합:"+ sum);
		}
	}