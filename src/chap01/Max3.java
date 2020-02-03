package chap01;

import java.util.Scanner;

public class Max3 {
	
	public static void main(String[] args) {
		max3(1,2,3,6);
		
		min3(5,5,9);
	}
	
	public static void max3(int a, int b, int c, int d) {
		int max = a;
		if ( b > max ) max = b;
		if ( c > max ) max = c;
		if ( d > max ) max = d;
		
	
		System.out.println("최대값은 "+ max + "입니다.");
	}
	
	public static void min3(int a, int b, int c) {
		int min = a ;
		if ( b < min ) min = b;
		if ( c < min ) min = c ;
		
		System.out.println("최소값은 " + min + "입니다." );
	}

}
