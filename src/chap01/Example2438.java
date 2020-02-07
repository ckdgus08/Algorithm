package chap01;

import java.util.Scanner;

public class Example2438 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int number = sc.nextInt();
        
        for(int i = 0 ; number > i ; i++) {
            for(int j = 0 ; i+1 > j ; j++) {
            System.out.print("*");
            }
            System.out.println("");
        }
    }
}