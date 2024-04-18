package ex01;

import java.util.Scanner;

public class Pratice02 {
	public static void run() {
		Scanner r=new Scanner(System.in);
		System.out.println("===============");
		System.out.println("반지름을 입력하세요.");
		System.out.println("===============");
		System.out.print("입력하기>");
		double radius =r.nextDouble();
		double area = radius*radius*3.14;
		
		System.out.println(area);
		
		
	
		
	}
}
