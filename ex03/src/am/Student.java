package am;

public class Student {
	// 필드 (Class가 갖고 있는 속성들)
	String no;
	String name;
	String address;
	String phone;

	//생성자1
	public Student() { //기본생성자
		
	}
	
	//생성자2
	public Student(String no, String name, String address, String phone) {
		super();//생략가능
		this.no = no;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	//method(명령어의 집합)
	public void print() {
		System.out.printf("학번:%s\n이름:%s\n주소:%s\n전화:%s\n",no,name,address,phone);
		System.out.println("---------------------------------------------");
	}
	
}
