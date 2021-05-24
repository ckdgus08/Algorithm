package boj;

import java.util.Scanner;

public class P11399 {

	static int[] a;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		a = new int[N];
		
		for(int i = 0 ; N>i ; i++) {
		a[i] = sc.nextInt();
		}


		quickSort(a,0,a.length-1);
		
		for(int g=0; 5>g ; g++) {
			System.out.print(a[g]+" ");
		}
	}

	public static void quickSort(int[] a, int start, int end) {
		if(start >= end) {
			return;
		}
		int key = start;
		int i = start+1;
		int j = end;
		int temp;
		
		while(j >= i ) {
			while(i < a.length && a[key] >= a[i]) {
				i++;
			}
			while(a[key] <= a[j] && j>start) {
				j--;
			}
			if(i > j) {
				temp = a[key];
				a[key] = a[j];
				a[j] = temp;
			} else {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		quickSort(a,j+1,end);
		quickSort(a,start, j-1);
	}
}
