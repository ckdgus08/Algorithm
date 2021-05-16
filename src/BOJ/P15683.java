package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15683 {

	static int N, M, count, count1, count2, count3, count4, temp1, temp2;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str, " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = N * M;
		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; N > i; ++i) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; M > j; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // �Է�

		check();
		System.out.println(count);

	}

	public static void left(int i, int j, int count1, int count2, int count3, int count4) {
		while (j != 0) {
			// ���� üũ
			if (arr[i][j - 1] == 6)
				break;
			if (arr[i][j - 1] == 0 && visited[i][j - 1] == false) {
				visited[i][j - 1] = true;
				++count1;
				++count2;
				++count3;
				++count4;
			}
			j--;
		}
		j = temp1;
		i = temp2;

	}

	public static void right(int i, int j, int count1, int count2, int count3, int count4) {
		while (j != N - 1) {
			// ������ üũ
			if (arr[i][j + 1] == 6)
				break;
			if (arr[i][j + 1] == 0 && visited[i][j + 1] == false) {
				visited[i][j + 1] = true;
				++count1;
				++count2;
				++count3;
				++count4;
			}
			j++;
		}
		j = temp1;
		i = temp2;
	}

	public static void up(int i, int j, int count1, int count2, int count3, int count4) {
		while (i != 0) { // ������ üũ
			if (arr[i - 1][j] == 6)
				break;
			if (arr[i - 1][j] == 0 && visited[i - 1][j] == false) {
				visited[i - 1][j] = true;
				++count1;
				++count2;
				++count3;
				++count4;
			}
			i--;
		}
		j = temp1;
		i = temp2;
	}

	public static void down(int i, int j, int count1, int count2, int count3, int count4) {
		while (i != N - 1) { // �Ʒ����� üũ
			if (arr[i + 1][j] == 6)
				break;
			if (arr[i + 1][j] == 0 && visited[i + 1][j] == false) {
				visited[i + 1][j] = true;
				count4++;
			}
			i++;
		}
		j = temp1;
		i = temp2;
	}

	public static void check() {
		for (int i = 0; N > i; ++i) {
			for (int j = 0; M > j; ++j) {
				switch (arr[i][j]) {
				case 1:
					--count;
					temp1 = j;
					temp2 = i;

					left(i, j, count1, -100, -100, -100);
					right(i, j, -100, count2, -100, -100);
					up(i, j, -100, -100, count3, -100);
					down(i, j, -100, -100, -100, count4);

					count -= Math.max(Math.max(count1, count2), Math.max(count3, count4));
					count1 = 0;
					count2 = 0;
					count3 = 0;
					count4 = 0;

					break;

				case 2:
					--count;

					temp1 = j;
					temp2 = i;

					left(i, j, count1, -100, -100, -100);
					right(i, j, count1, -100, -100, -100);
					up(i, j, -100, -100, count3, -100);
					down(i, j, -100, -100, count3, -100);

					count -= Math.max(count1, count2);
					count1 = 0;
					count2 = 0;
					break;
				case 3:

					--count;
					temp1 = j;
					temp2 = i;
					// ������ + �� = 1
					// ������ + �Ʒ� = 2
					// ���� + �� = 3
					// ���� + �Ʒ� = 4

					left(i, j, count3, count4, -100, -100);
					right(i, j, count1, count2, -100, -100);
					up(i, j, -100, -100, count1, count3);
					down(i, j, -100, -100, count2, count4);

					count -= Math.max(Math.max(count1, count2), Math.max(count3, count4));
					count1 = 0;
					count2 = 0;
					count3 = 0;
					count4 = 0;

					break;
				case 4:

					--count;
					temp1 = j;
					temp2 = i;

					// ������ + �� + ���� = 1
					// ������ + �Ʒ� + ����= 2
					// ���� + �� + �Ʒ�= 3
					// ������ + �Ʒ� + ��= 4

					left(i, j, count3, count2, count1, -100);
					right(i, j, count1, count2, count4, -100);
					up(i, j, count4, -100, count1, count3);
					down(i, j, -100, count2, count3, count4);

					count -= Math.max(Math.max(count1, count2), Math.max(count3, count4));
					count1 = 0;
					count2 = 0;
					count3 = 0;
					count4 = 0;

					break;
				case 5:
					--count;

					temp1 = j;
					temp2 = i;

					left(i, j, count1, -100, -100, -100);
					right(i, j, count1, -100, -100, -100);
					up(i, j, count1, -100, -100, -100);
					down(i, j, count1, -100, -100, -100);
					count -= count1;
					break;

				case 6:
					--count;
					break;
				}

			}
		}
	}
}
