package pm;

public class Sale {
	
	//필드
	String code;
	String name;
	int price;
	int qnt;
	int sum;
	
	//생성자
	
	public Sale() {
		
	}
	
	public Sale(String code, String name, int price, int qnt) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.qnt = qnt;
	}
	
	//method
	//금액을 구하는 메서드
	public int sum() {
		int sum=price*qnt;
		return sum;
	}
	
	// 내용 가로출력
	public void printLand() {
		System.out.printf("%s\t%s\t%d만원\t%d개\t%,d만원\n",code,name,price,qnt,sum());
	}
	
	//내용 세로출력
	public void printPort() {
		System.out.printf("상품코드:	%s\n",code);
		System.out.printf("상품이름:	%s\n",name);
		System.out.printf("상품가격:	%d\n",price);
		System.out.printf("상품수량:	%d\n",qnt);
		System.out.printf("판매금액:	%d\n",sum());
		
	}
}
