package am;

import java.util.*;

public class Sub01 {
	public static void run() {
		boolean run = true;
		ArrayList<Car> cars = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		Car car= new Car(1,"현대","그렌저","검정",20000,"2020-03");
		cars.add(car);
		car= new Car(2,"쌍용","티볼리","파랑",60000,"2019-06");
		cars.add(car);
		car= new Car(3,"기아","K7","흰색",120000,"2021-04");
		cars.add(car);
		
		while(run) {
			System.out.println("\n=========================================");
			System.out.println("1.차량등록|2.차량조회|3.차량목록|4.차량삭제|0.종료");
			System.out.println("=========================================");
			System.out.println("선택>");
			String menu= scanner.nextLine();
			switch(menu) {
				case "1" :
					car= new Car();
					Car last= cars.get( cars.size()-1 );
					int newNo = ( last.getNo() )+1; 
					System.out.println("번호>" + newNo );
//					System.out.println("번호");
//					String no = scanner.nextLine();
					car.setNo(newNo);
					System.out.print("제조사>");
					String company = scanner.nextLine();
					car.setCompany(company);
					
					System.out.print("차량모델>");
					String model = scanner.nextLine();
					car.setModel(model);
					
					System.out.print("색상");
					String color = scanner.nextLine();
					car.setColor(color);
					
					System.out.print("주행거리");
					int distance = Integer.parseInt(scanner.nextLine());
					car.setDistance(distance);
					
					System.out.print("연식");
					String date = scanner.nextLine();
					car.setDate(date);
					
					cars.add(car);
					System.out.println("");
					System.out.printf("%s 차량이 등록되었습니다.\n",model);
					break;
				case "2" :
					System.out.println("검색할 차량의 모델명을 입력하세요>");
					String such = scanner.nextLine();
					boolean find = false;
					for(Car c: cars) {
						if(c.getModel().equals(such)){
							find = true;
							System.out.printf("no.%d\t %s\t %s\t %s\t %d\t %s\n",
									c.getNo(),c.getCompany(),c.getModel(),c.getColor(),c.getDistance(),c.getDate());
							System.out.println(such + " 차량이 등록되어있습니다.");
							break; 
							}
						}
					
					if(!find) {System.out.println(such + " 차량이 등록되어있지않습니다.");}
					break;
				case "3" :
					for(Car c : cars) {
						System.out.printf("no.%d\t %s\t %s\t %s\t %d\t %s\n",
								c.getNo(),c.getCompany(),c.getModel(),c.getColor(),c.getDistance(),c.getDate());
					}
					System.out.println("=========================================");
					System.out.println(cars.size()+" 대의 차량이 등록되어있습니다.");
					break;
				case "4" :
					break;
				case "0" :
					System.out.println("프로그램을 종료합니다.");
					run = false;
					break;
				default:
					System.out.println("0~4 메뉴를 입력하세요!");
					break;
			}//switch	
		}//while
		run=false;
	}//method
}