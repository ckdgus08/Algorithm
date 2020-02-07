package chap01;

import java.util.Scanner;

public class Example10818{
    public static void main(String[] agrs) {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max=-1000001;
        int min=1000001;
        int[] arr = new int[n];
        
        for(int i = 0; n > i;i++){
            arr[i]=sc.nextInt();
            }
        for(int j=0; n>j;j++) {
            if(arr[j] > max) max=arr[j];
            if(arr[j] < min) min=arr[j];
            }
        System.out.print(max+" "+min);
        
    }
    }