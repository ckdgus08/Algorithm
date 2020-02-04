package chap01;

import java.util.Scanner;

public class QuickSort1 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		sc.
		
		int[] a = { 3,4,5,6,7,1,2,9,10,8};
		
		quickSort(a,0,a.length -1 );
		
		for ( int i = 0; 10>i ; i++) {
			System.out.print(a[i] + " ");
		}
		
	}

	public static void quickSort(int[] a, int start, int end ) {
		
		int key = start;
		int i = start + 1;
		int j = end;
		int temp;
		
		if(i>=j) {
			return;
		}
		
		while(i < j) {
			
			while(a[key] > a[i]) {
				i++;
			}
			while(a[key] < a[j] && j > start) {
				j--;
			}
			
			if(i < j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			} else {
				temp = a[key];
				a[key] = a[j];
				a[j] = temp;
			}
		}
		quickSort(a,start,j-1);
		quickSort(a,j+1,end);
	}
}
