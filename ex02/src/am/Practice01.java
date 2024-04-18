package am;

import java.util.Scanner;

public class Practice01 {
	public static void run() {
		Scanner scanner= new Scanner(System.in);
		boolean run=true;
		while(run) {
			String inPutNum = scanner.nextLine();
			int checkNum = Integer.parseInt(inPutNum);
			boolean isPrime = true;
			if(checkNum<=1) {
				isPrime=false;
			}
		}
	}
}
