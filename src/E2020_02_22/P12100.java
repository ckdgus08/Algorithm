package E2020_02_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12100 {

	static int[][] arr, arr1;
	static int N, max;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		arr1 = new int[N][N];
		max = 0;

		for (int i = 0; N > i; ++i) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			for (int j = 0; N > j; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				arr1[i][j] = arr[i][j];
			}
		}
		int[] k = new int[5];

		for (int a = 0; 4 > a; ++a)
			for (int b = 0; 4 > b; ++b)
				for (int c = 0; 4 > c; ++c)
					for (int d = 0; 4 > d; ++d)
						for (int e = 0; 4 > e; ++e) {
							k[0] = a;
							k[1] = b;
							k[2] = c;
							k[3] = d;
							k[4] = e;
							for (int i = 0; 5 > i; ++i) {
								switch (k[i]) {
								case 0:
									left();
									break;
								case 1:
									right();
									break;
								case 2:
									up();
									break;
								case 3:
									down();
									break;
								}
							}
							for (int q = 0; N > q; ++q) {
								for (int j = 0; N > j; ++j) {
									if (max < arr[q][j]) {
										max = arr[q][j];
									}
									arr[q][j] = arr1[q][j];
								}
							}
						}

		System.out.print(max);

	}

	public static void left() {
		for (int i = 0; N > i; ++i) {

			for (int j = 0; N - 1 > j; ++j) {
				if (arr[i][j] == 0 && arr[i][j + 1] != 0) {
					arr[i][j] = arr[i][j + 1];
					arr[i][j + 1] = 0;
					j = 0;
				}
			} // 한쪽으로 밀기

			for (int j = 0; N - 1 > j; ++j) {
				if (arr[i][j] == arr[i][j + 1]) {
					arr[i][j] = 2 * arr[i][j];
					arr[i][j + 1] = 0;
				}
			} // 같은 숫자 합치기

			for (int j = 0; N - 1 > j; ++j) {
				if (arr[i][j] == 0 && arr[i][j + 1] != 0) {
					arr[i][j] = arr[i][j + 1];
					arr[i][j + 1] = 0;
					j = 0;
				} // 한쪽으로 밀기
			}
		}
	}

	public static void right() {

		for (int i = 0; N > i; ++i) {

			for (int j = N - 1; 0 < j; --j) {
				if (arr[i][j] == 0 && arr[i][j - 1] != 0) {
					arr[i][j] = arr[i][j - 1];
					arr[i][j - 1] = 0;
					j = N - 1;
				}

			}

			for (int j = N - 1; 0 < j; --j) {
				if (arr[i][j] == arr[i][j - 1]) {
					arr[i][j] = 2 * arr[i][j];
					arr[i][j - 1] = 0;
				}
			}

			for (int j = N - 1; 0 < j; --j) {
				if (arr[i][j] == 0 && arr[i][j - 1] != 0) {
					arr[i][j] = arr[i][j - 1];
					arr[i][j - 1] = 0;
					j = N - 1;
				}

			}

		}
	}

	public static void down() {

		for (int j = 0; N > j; ++j) {

			for (int i = N - 1; 0 < i; --i) {
				if (arr[i][j] == 0 && arr[i - 1][j] != 0) {
					arr[i][j] = arr[i - 1][j];
					arr[i - 1][j] = 0;
					i = N - 1;
				}

			}

			for (int i = N - 1; 0 < i; --i) {
				if (arr[i][j] == arr[i - 1][j]) {
					arr[i][j] = 2 * arr[i][j];
					arr[i - 1][j] = 0;
				}
			}

			for (int i = N - 1; 0 < i; --i) {
				if (arr[i][j] == 0 && arr[i - 1][j] != 0) {
					arr[i][j] = arr[i - 1][j];
					arr[i - 1][j] = 0;
					i = N - 1;
				}

			}

		}
	}

	public static void up() {
		for (int j = 0; N > j; ++j) {

			for (int i = 0; N - 1 > i; ++i) {
				if (arr[i][j] == 0 && arr[i + 1][j] != 0) {
					arr[i][j] = arr[i + 1][j];
					arr[i + 1][j] = 0;
					i = 0;
				}
			} // 한쪽으로 밀기

			for (int i = 0; N - 1 > i; ++i) {
				if (arr[i][j] == arr[i + 1][j]) {
					arr[i][j] = 2 * arr[i][j];
					arr[i + 1][j] = 0;
				}
			} // 같은 숫자 합치기

			for (int i = 0; N - 1 > i; ++i) {
				if (arr[i][j] == 0 && arr[i + 1][j] != 0) {
					arr[i][j] = arr[i + 1][j];
					arr[i + 1][j] = 0;
					i = 0;
				} // 한쪽으로 밀기
			}
		}
	}
}