package product;
import java.sql.*;

public class Database {
	public static Connection CON; // CON 상수 객체를 생성하지 않기 위해 static 사용
	
	static {
		try {
			String driver="oracle.jdbc.driver.OracleDriver";
			String url= "jdbc:oracle:thin:@localhost:1521:xe";
			String user="product";
			String password= "pass";
			Class.forName(driver);
			CON= DriverManager.getConnection(url,user,password);
			System.out.println("접속성공!");
		}catch(Exception e) {
			System.out.println("접속실패 : " +  e.toString());
		}
	}
}
