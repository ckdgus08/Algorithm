package chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Example10814 {
	
	public void main(String[] args) throws NumberFormatException, IOException {
	
	Scanner br = new Scanner(System.in);
	int number = br.nextInt();
	int[] age = new int[number];
	String[] name = new String[number];
	
	for(int i = 0; number > i ; i++) {
		age[i] =  br.nextInt();
		name[i] = br.next();
		System.out.println(age[i] + " " + name[i].toString());
	}
	sort(age,name,0,number-1);
	
	for(int k=0 ; number > k ; k++) {
	}
	
	}
	public void sort(int[] age,String[] name , int start, int end) {
		int key = start;
		int i = start+1;
		int j = end;
		int temp;
		String temp1;
		if(i >= j) {
			return;
		}
		
		while( i > j ) {
			while(age[key] > age[i]) {
				i++;
			}
			while(age[key] < age[j] && j > start ) {
				j--;
			}
			
			if( j > i ) {
				temp = age[key];
				age[key] = age[j];
				age[j] = temp;
				temp1 = name[key];
				name[key] = name[j];
				name[j] = temp1;
			} else {
				temp = age[i];
				age[i] = age[j];
				age[j] = temp;
				temp1 = name[i];
				name[i] = name[j];
				name[j] = temp1;
			}
			
		}
		sort(age,name,start,j-1);
		sort(age,name,j+1,end);
		{
	}
		
	}
	

}
