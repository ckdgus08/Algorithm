package chap01;

import java.util.Scanner;

public class Matrics {

	// �迭 �Է¹����� �������� ����ϱ�.
	public static void main(String[] agrs) {

		Scanner sc = new Scanner(System.in);
		System.out.println("�迭 ����");
		int b = sc.nextInt();
		int a[] = new int[b];
		for (int i = 0; b > i; i++) {
			System.out.println(i + "��° �����Է�");
			a[i] = sc.nextInt();
		}

		for (int i = 0; b > i; i++) {
			System.out.print(a[i] + " ");
		}

		if (b / 2 == 0) {
			for (int i = 0; b / 2 > i; i++) {
				int temp ;
				temp = a[i];
				a[i] = a[b-1-i];
				a[b-1-i] = temp;
			}
		} else {
			for (int i = 0; b / 2 - 0.5 > i; i++) {
				int temp ;
				temp = a[i];
				a[i] = a[b-1-i];
				a[b-1-i] = temp;
			}
		}
		
		System.out.println("������ : ");
		for (int i = 0; b > i; i++) {
			System.out.print(a[i] + " ");
		}

	}

	public static void matrics() {
		int a[] = { 1, 2, 3 };
		int[] b = { 4, 5, 6 };

		System.out.println(b[0] + b[1] + b[2] + " " + a[0] + a[1] + a[2]);
	}

	public static void sort(int a, int b, int c, int d) {

	}
}
