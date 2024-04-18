package ex01;

import java.util.Scanner;

public class Pratice03 {
	public static void run() {
		Scanner n=new Scanner(System.in);
		System.out.println("===============");
		System.out.println("숫자를 세 개 입력하세요.");
		System.out.println("===============");
		System.out.print("입력하기>");
		double a = n.nextDouble();
		double b = n.nextDouble();
		double c = n.nextDouble();
		double m1, m2, m3;
		
		if(a>b)
	    {
	        if(a>c){
	            m1 =a;
	            if(b>c){
	                m2=b; m3=c;
	            }
	            else{
	                m2=c; m3=b;
	            }
	        }
	        else{
	            m1 =c; m2=b; m3=a;
	        }
	    }
	else
	    {
	        if(b<c){
	            m1=c; m2=b; m3=a;
	        }
	        else{
	            if(a>c){
	                m1=b; m2=a; m3=c;
	            }
	            else{
	                m1=b; m2=c; m3=a;
	            }
	        }
	    }
		
		System.out.printf("%2f %2f %2f", m1,m2,m3);
	
		
		
		}
	}
