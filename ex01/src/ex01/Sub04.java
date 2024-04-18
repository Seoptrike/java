package ex01;

public class Sub04 {
	public static void run() {
		//산술연산자
		
		int num1=11;
		int num2=3;
		int sum= num1 + num2;
		System.out.println(num1+"+"+num2+"="+sum);
		
		int sub = num1-num2;
		System.out.println(num1+"-"+num2+"+"+sub);
		
		int mul=num1*num2;
		System.out.println(num1+"*"+num2+"="+mul);
		double div= (double) num1 / (double) num2;
		float div2= (float) num1 / (float) num2;
		System.out.println(num1+"/"+num2+"="+div);
		System.out.println(num1+"/"+num2+"="+div2);
		
		// 관계연산자 true or false 값만 나온다
		
		boolean result= num1>num2;
		System.out.println(num1+"이"+ num2 + "보다 크다:" + result);
		result = num1 < num2; // 위에서 result 변수를 선언했으므로 변수값만 적으면 됌
		System.out.println(num1+"이"+ num2 + "보다 작다:" + result);
		result = num1==num2;
		System.out.println(num1+"과"+ num2 + "가 같다:" + result);
		result = num1!=num2;
		System.out.println(num1+"과"+ num2 + "가 같지않다:" + result);
		
 		//논리 연산자(and=&& or=|| not=!)
		boolean b1 =true;
		boolean b2 =false;
		result = b1 && b2;
		System.out.println(result);
		result = b1 || b2;
		System.out.println(result);
		result = !b1;
		System.out.println(result);
		
	}

}
