package ex01;

public class Sub06 {
	public static void run() {
		//반복문(for, while)
		int sum =0;
		for (int i=1; i<=100; i=i+1) {
			sum=sum+i;}//i에 대한 합계를 sum에 저장
			//System.out.println(i);
		sum=0;
		for(int i=1; i<=100; i=i+2) {
			sum=sum+i;	}
		System.out.println("1~100 홀수합계:" + sum);
		
		sum=0;
		for(int i=2; i<=100; i=i+2) {
			sum=sum+i;}
		System.out.println("1~100 짝수합계:" +sum);
		
		int i=1;
		sum=0;
		while(i<=100) {
			sum=sum+i;	
			i=i+1;
		}
		System.out.println("1~100 합계:" +sum);
		
		
		i=1;
		sum=0;
		while(i<=100) {
			sum=sum+i;	
			i=i+2;
		}
		System.out.println("1~100 홀수합계:" +sum);
		
		i=2;
		sum=0;
		while(i<=100) {
			sum=sum+i;	
			i=i+2;
		}
		System.out.println("1~100 짝수합계:" +sum);
	}
}
