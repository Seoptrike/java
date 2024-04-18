package am;


public class GradeData {
	
	String name;
	int kor;
	int eng;
	int mat;
	



	public GradeData(String name, int kor, int eng, int mat ) {
		this.name = name;
		this.kor = kor;
		this.eng =eng;
		this.mat = mat;	
	}
	
	public int total() {
		int total = kor+eng+mat;
		return total;
	}
	
	public double avg() {
		return total()/3.;
	}
	
	public void printInfo() {
		System.out.printf("%s	%d	%d	%d	%.0f	%.2f\n",name,kor,eng,mat,total(),avg());
	}
	
}


