package chap01;

import java.util.Scanner;

public class Example2884 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int minute= sc.nextInt();
		
		if(minute < 45) {
			hour = hour-1;
			if(hour == -1) hour=0;
			minute = minute - 45 + 60;
		} else if ( minute >= 45 ) {
			minute = minute - 45;
		}
		System.out.println(hour + " " + minute);
	}
}
