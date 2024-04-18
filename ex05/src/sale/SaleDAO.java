package sale;
import java.util.*;
import java.io.*;
public class SaleDAO {
	File file = new File("C:/수업/data/java/ex05/sale.txt");
	
	public ArrayList<Sale> list(){
		ArrayList<Sale> array = new ArrayList<Sale>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			while((line=reader.readLine())!= null ) {
				String [] items = line.split(",");
				Sale sale = new Sale();
				sale.setCode(Integer.parseInt(items[0]));
				sale.setName(items[1]);
				sale.setPrice(Integer.parseInt(items[2]));
				sale.setQnt(Integer.parseInt(items[3]));
				array.add(sale);
			}
		}catch(Exception e) {
			System.out.println("매출 목록 오류 : "+ e.toString());
		}
		return array;
	}
	
	public void insert(Sale sale) {
		try {
			FileWriter writer = new FileWriter (file, true);
			writer.write(String.format("%d,%s,%d,%d,\n",sale.getCode(),sale.getName(),sale.getPrice(),sale.getQnt()));
//			writer.write(sale.getCode()+","+sale.getName()+","+sale.getPrice()+","+sale.getQnt()+"\n");
			writer.close();
		}catch(Exception e) {
			System.out.println("매출등록 : "+ e.toString());
		}		
	}
	
	public Sale read(int code) {
		Sale sale = new Sale();
		try {
			BufferedReader reader =new BufferedReader(new FileReader(file));
			String line = "";
			while( (line = reader.readLine())!=null) {
				String[] items = line.split(",");
				if( code==Integer.parseInt(items[0])){
					sale.setCode(code);
					sale.setName(items[1]);
					sale.setPrice(Integer.parseInt(items[2]));
					sale.setQnt(Integer.parseInt(items[3]));
				}
			}
		}catch(Exception e) {
			System.out.println("판매조회 : " + e.toString());
		}
		return sale;
	}
	
	public void delete(int code){
		try {
			BufferedReader reader =new BufferedReader(new FileReader(file));
			File tempFile = new File("temp.txt");
			FileWriter writer = new FileWriter(tempFile);
			String line = "";
			while( (line = reader.readLine())!=null) {
				String[] items = line.split(",");
				if( code!=Integer.parseInt(items[0])) {
					writer.write(line+"\n");
				}
			}
			reader.close();
			writer.close();
			
			 if (!tempFile.renameTo(file)) {
		            System.out.println("파일 대체 실패");
		        }
		}catch(Exception e) {
			System.out.println("매출삭제 : " + e.toString());
		}
	}
}