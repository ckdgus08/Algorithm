package chap01;

public class QuickSort {

	public static void main(String[] args) {

		int[] a = { 5, 6, 3, 10, 9, 8, 1, 2, 4, 7 };

		quickSort(a,0,9);
		
		for(int g=0; 10>g ; g++) {
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
		
		while(j >= i) {
			System.out.print(key+" "+i+"/");
			while(a[key] >= a[i]) {
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
