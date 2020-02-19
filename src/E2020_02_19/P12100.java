package E2020_02_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12100 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N+1][N+1];

		
		for (int i = 1; N >= i; i++) {
			String line = br.readLine();
			for (int j = 1; N >= j; j++) {
				StringTokenizer st = new StringTokenizer(line);
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		left(arr,N);
		
		for (int i = 1; N >= i; i++) {
			for (int j = 1; N >= j; j++) {

		System.out.print( arr[i][j] + " ");
			}
			System.out.println("");
		}

	}

	public static void left(int[][] arr, int N) {

		for (int i = 1; N >= i; i++) {
			for (int j = 1; N >= j; j++) {

				if (arr[i][j-1] == arr[i][j]) {
					arr[i][j-1] = 2 * arr[i][j];
					arr[i][j] = 0;
				}
			}
		}
		for (int i = 1; N  >= i; i++) {
			for (int j = 1; N  >= j; j++) {
				if (arr[i][j-1] == 0) {
					arr[i][j-1] = arr[i][j];
					arr[i][j] = 0;
				}

			}
		}
	}
}
