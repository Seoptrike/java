package ex01;

public class Sub08 {
	public static void run() {
//		int[] scores = new int[] {90,80,75,100,99};
//		for(int i=0; i<scores.length; i++) {
//			System.out.println(scores[i]);
//	}
		int[] no= new int[] {1,2,3};
		String[] name= new String[] {"홍길동","심청이","강감찬"};
		String[] adress= new String[] {"인천","서울","부산"};
		
		for(int i=0; i<no.length; i++) {
			System.out.println(no[i]+"\t"+name[i]+"\t"+adress[i]);
			System.out.println("---------------------------");
		}
		
		double[]kor = new double[] {90, 88, 92};
		double[]eng = new double[] {96, 92, 76};
		double[]mat = new double[] {99, 87, 56};
		for( int i=0; i<no.length; i++) {
			double tot= kor[i]+eng[i]+mat[i];
			double avg= tot / no.length;
			String grade="";
			if(avg>=90) {
				if(avg>=95) {
					grade="A+";
				}else{
					grade="A0";
				}
			}else if(avg>=80){
				if(avg>=85) {
					grade="B+";
				}else{
					grade="B0";
				}
			}else if(avg>=70){
				if(avg>=75) {
					grade="C+";
				}else{
					grade="C0";
				}
			}else if(avg>=60){
				if(avg>=65) {
					grade="D+";
				}else{
					grade="D0";
				}
			}else{
				grade="F";
			}

//			System.out.println(no[i]+ "\t"+ name[i] + "\t" + tot + "\t" + avg);
			System.out.printf("%d \t %s \t %.2f \t %.2f \t %s \n",no[i],name[i],tot,avg,grade); //%d=int %s=str
		}
		
		
	}
}
