package E2020_02_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1969 {

	static int N, M, result;
	static String result1;
	static String[][] arr;
	static int[][] count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str, " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 0;
		result1= "";
		arr = new String[N][M];
		count = new int[M][4];
		// A=0 C=1 G=2 T=3

		for (int i = 0; N > i; ++i) {
			str = br.readLine();
			for (int j = 0; M > j; ++j) {
				arr[i][j] = str.substring(j, j + 1);
			}
		} // ют╥б

		for (int i = 0; N > i; ++i) {
			for (int j = 0; M > j; ++j) {
				switch (arr[i][j]) {
				case "A":
					count[j][0]++;
					break;
				case "C":
					count[j][1]++;
					break;
				case "G":
					count[j][2]++;
					break;
				case "T":
					count[j][3]++;
					break;
				}
			}
		}

		for (int j = 0; M > j; ++j) {
			if (Math.max(Math.max(count[j][0], count[j][1]), Math.max(count[j][2], count[j][3])) == count[j][0]) {
				result1 += "A";
				result = result + count[j][1] + count[j][2] + count[j][3];
			} else if (Math.max(Math.max(count[j][0], count[j][1]),
					Math.max(count[j][2], count[j][3])) == count[j][1]) {
				result1 += "C";
				result = result + count[j][0] + count[j][2] + count[j][3];
			} else if (Math.max(Math.max(count[j][0], count[j][1]),
					Math.max(count[j][2], count[j][3])) == count[j][2]) {
				result1 += "G";
				result = result + count[j][1] + count[j][0] + count[j][3];
			} else if (Math.max(Math.max(count[j][0], count[j][1]),
					Math.max(count[j][2], count[j][3])) == count[j][3]) {
				result1 += "T";
				result = result + count[j][1] + count[j][2] + count[j][0];
			}

		}

		System.out.println(result1);
		System.out.print(result);

	}

}
