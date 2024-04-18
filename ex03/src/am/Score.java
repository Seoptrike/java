package am;

public class Score {
	//filed
	String name;
	int kor;
	int eng;
	int mat;
	
	//생성자
	
	public Score() {
		
	}
	
	
	public Score(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}


	//method
	public int total() {
		int total= kor+eng+mat;
		return total;
	}	
	public double avg() {
		return total()/3.;
	}
	
	public void print() {
		System.out.printf("%s \t %d \t %d \t %d \t %d \t %.2f \t %s \n",name,kor,eng,mat,total(),avg(),grade());
		//void 는 돌려줄 값이 없을때 사용한다	
	}
	
	public String grade() {
		String grade="";
		if(avg()>=90) {
			if(avg()>=95) {
				grade="A+";
			}else{
				grade="A0";
			}
		}else if(avg()>=80){
			if(avg()>=85) {
				grade="B+";
			}else{
				grade="B0";
			}
		}else if(avg()>=70){
			if(avg()>=75) {
				grade="C+";
			}else{
				grade="C0";
			}
		}else if(avg()>=60){
			if(avg()>=65) {
				grade="D+";
			}else{
				grade="D0";
			}
		}else{
			grade="F";
			}
		return grade;	
		}

}
