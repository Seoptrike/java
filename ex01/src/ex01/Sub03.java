package ex01;

public class Sub03 {
	public static void run() {
		//정수 타입
		int num1=10; //10.5는 오류남 정수로 변수를 정의했기때문
		
		//실수 타입 float은 4바이트까지 저장 가능 
		float num2=11.5f; // 정수로 표현해도 오류는 안남 뒤에 f를 붙혀야된다.
		double num3=12.5; //double 은 8byte 까지 저장가능하며 뒤에 f를 붙히지 않아도 된다.
		System.out.println("num1=" + num1);
		System.out.println("num2=" + num2);
		System.out.println("num3=" + num3);
		
		//형변환(정수->실수)
//		num2=num1; // 한번 선언을 했으면 두번 하면 안된다
//		System.out.println("num2="+num2);
//		num3=num1;
//		System.out.println("num3="+num3);
		
		//형변환(실수->정수)
		num1=(int)num2; //뒤에 소숫점을 버려서 출력된다
		System.out.println("num1="+num1);
		num1=(int)num3;
		System.out.println("num1="+num1);
		
		//문자 타입
		char str1= 'A'; //char 는 작은따옴표 안에 한글자만 저장가능하다.
		String str2 = "홍길동"; //String 은 큰따옴표 안에 여러글자가 저장 가능하다.  string은 class이기 때문에 대문자로 시작한다.
		System.out.println("str1=" + str1);
		System.out.println("str2=" + str2);
		
		//불린 타입
		boolean bool1 = true;
		boolean bool2 = false;
		System.out.println("bool1=" + bool1);
		System.out.println("bool2=" + bool2);
		
	
		
	}
}
