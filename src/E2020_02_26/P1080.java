package E2020_02_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1080 {

	static int N, M, count, temp;
	static boolean[][] arr1;
	static boolean[][] arr2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str, " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr1 = new boolean[N][M];
		arr2 = new boolean[N][M];

		for (int i = 0; N > i; ++i) {
			str = br.readLine();
			for (int j = 0; M > j; ++j) {
				if (str.charAt(j) - 48 == 0) {
					arr1[i][j] = false;
				} else {
					arr1[i][j] = true;
				}
			}
		}
		for (int i = 0; N > i; ++i) {
			str = br.readLine();
			for (int j = 0; M > j; ++j) {
				if (str.charAt(j) - 48 == 0) {
					arr2[i][j] = false;
				} else {
					arr2[i][j] = true;
				}
			}
		}

		for (int i = 0; N - 2 > i; ++i) {
			for (int j = 0; M - 2 > j; ++j) {
				if (arr1[i][j] != arr2[i][j]) {
					arr1[i][j] = !arr1[i][j];
					arr1[i + 1][j] = !arr1[i + 1][j];
					arr1[i + 2][j] = !arr1[i + 2][j];
					arr1[i][j + 1] = !arr1[i][j + 1];
					arr1[i + 1][j + 1] = !arr1[i + 1][j + 1];
					arr1[i + 2][j + 1] = !arr1[i + 2][j + 1];
					arr1[i][j + 2] = !arr1[i][j + 2];
					arr1[i + 1][j + 2] = !arr1[i + 1][j + 2];
					arr1[i + 2][j + 2] = !arr1[i + 2][j + 2];
					++count;
				}
			}
		}

		for (int i = 0; N > i; ++i) {
			for (int j = 0; M > j; ++j) {
				if (arr1[i][j] != arr2[i][j]) {
					temp++;
					break;
				}
			}
			if (temp > 0)
				break;
		}

		if (temp > 0) {
			System.out.print("-1");
		} else {
			System.out.println(count);
		}

	}

}
