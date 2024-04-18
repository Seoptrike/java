package pm;

import java.io.*;
import java.util.*;
import am.Car;

public class Sub01 {
	public static void run() {
		File file= new File("c:/수업/data/java/car.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line="";
			String[] items = new String[6];
			//StringTokenizer st=null;
			
			while(  (line=reader.readLine())!=null ) {
				items=line.split(",");
				Car car = new Car();
				car.setNo(Integer.parseInt(items[0]));
				car.setCompany(items[1]);
				car.setModel(items[2]);
				car.setColor(items[3]);
				car.setDistance(Integer.parseInt(items[4]));
				car.setDate(items[5]);
				
				//st=new StringTokenizer(line,",");
				//int no = Integer.parseInt( st.nextToken( ));
				//String company = st.nextToken();
				//String model = st.nextToken();
				//String color = st.nextToken();
				//int distance = Integer.parseInt(st.nextToken());
				//String date = st.nextToken();
				
				//Car car= new Car(no,company,model,color,distance,date);
		
				System.out.printf("\n번호: %d제조사: %s\n모델명: %s\n색상: %s\n주행거리: %,d km\n연식: %s\n", 
						car.getNo(),car.getCompany(),car.getModel(),car.getColor(),car.getDistance(),car.getDate());
				
			}
		}catch(Exception e) {
			System.out.println("오류:" +e.toString());
		}
	}
}
